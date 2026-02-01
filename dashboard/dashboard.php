<?php
include "db.php";

// Sorting
$sort = $_GET['sort'] ?? 'name';
$orderBy = ($sort === 'date') ? 'joining_date' : 'name';

// Filtering
$department = $_GET['department'] ?? '';
$where = $department ? "WHERE department='$department'" : "";

// Fetch records
$sql = "SELECT * FROM employees $where ORDER BY $orderBy";
$result = mysqli_query($conn, $sql);

// Count per department
$countSql = "SELECT department, COUNT(*) AS total FROM employees GROUP BY department";
$countResult = mysqli_query($conn, $countSql);
?>

<!DOCTYPE html>
<html>
<head>
    <title>Data Dashboard</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Employee Data Dashboard</h2>

<form method="GET">
    <select name="sort">
        <option value="name">Sort by Name</option>
        <option value="date">Sort by Joining Date</option>
    </select>

    <select name="department">
        <option value="">All Departments</option>
        <option>HR</option>
        <option>IT</option>
        <option>Finance</option>
    </select>

    <button type="submit">Apply</button>
</form>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Department</th>
        <th>Joining Date</th>
    </tr>

    <?php while ($row = mysqli_fetch_assoc($result)) { ?>
    <tr>
        <td><?= $row['id'] ?></td>
        <td><?= $row['name'] ?></td>
        <td><?= $row['email'] ?></td>
        <td><?= $row['department'] ?></td>
        <td><?= $row['joining_date'] ?></td>
    </tr>
    <?php } ?>
</table>

<div class="count-box">
    <h3>Count per Department</h3>
    <ul>
        <?php while ($c = mysqli_fetch_assoc($countResult)) { ?>
            <li><?= $c['department'] ?> : <?= $c['total'] ?></li>
        <?php } ?>
    </ul>
</div>

</body>
</html>
