<?php
include "db.php";

$amount = 1000; // Payment amount

mysqli_autocommit($conn, false); // START TRANSACTION

try {
    // Deduct from User
    $deduct = "
        UPDATE accounts 
        SET balance = balance - $amount 
        WHERE name='User' AND balance >= $amount
    ";
    mysqli_query($conn, $deduct);

    if (mysqli_affected_rows($conn) === 0) {
        throw new Exception("Insufficient balance");
    }

    // Add to Merchant
    $add = "
        UPDATE accounts 
        SET balance = balance + $amount 
        WHERE name='Merchant'
    ";
    mysqli_query($conn, $add);

    if (mysqli_affected_rows($conn) === 0) {
        throw new Exception("Merchant account error");
    }

    mysqli_commit($conn);
    echo "<h2>✅ Payment Successful</h2>";

} catch (Exception $e) {
    mysqli_rollback($conn);
    echo "<h2>❌ Payment Failed</h2>";
    echo "<p>" . $e->getMessage() . "</p>";
}

mysqli_autocommit($conn, true);
?>
