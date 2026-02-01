<?php
include "db.php";

/* JOIN QUERY: Customer Order History */
$orderSql = "
SELECT 
    customers.name AS customer_name,
    products.product_name,
    products.price,
    orders.quantity,
    (products.price * orders.quantity) AS total_price,
    orders.order_date
FROM orders
JOIN customers ON orders.customer_id = customers.customer_id
JOIN products ON orders.product_id = products.product_id
ORDER BY orders.order_date DESC
";
$orderResult = mysqli_query($conn, $orderSql);

/* SUBQUERY: Highest Value Order */
$highestSql = "
SELECT MAX(products.price * orders.quantity) AS highest_order
FROM orders
JOIN products ON orders.product_id = products.product_id
";
$highestResult = mysqli_query($conn, $highestSql);
$highest = mysqli_fetch_assoc($highestResult);

/* SUBQUERY: Most Active Customer */
$activeSql = "
SELECT name FROM customers
WHERE customer_id = (
    SELECT customer_id
    FROM orders
    GROUP BY customer_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
";
$activeResult = mysqli_query($conn, $activeSql);
$active = mysqli_fetch_assoc($activeResult);
?>

<!DOCTYPE html>
<html>
<head>
    <title>Order Management</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h2>📦 Customer Order History</h2>

<table>
    <tr>
        <th>Customer</th>
        <th>Product</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Total</th>
        <th>Order Date</th>
    </tr>

    <?php while ($row = mysqli_fetch_assoc($orderResult)) { ?>
    <tr>
        <td><?= $row['customer_name'] ?></td>
        <td><?= $row['product_name'] ?></td>
        <td>₹<?= $row['price'] ?></td>
        <td><?= $row['quantity'] ?></td>
        <td>₹<?= $row['total_price'] ?></td>
        <td><?= $row['order_date'] ?></td>
    </tr>
    <?php } ?>
</table>

<div class="highlight">
    <h3>💰 Highest Value Order: ₹<?= $highest['highest_order'] ?></h3>
    <h3>⭐ Most Active Customer: <?= $active['name'] ?></h3>
</div>

</body>
</html>
