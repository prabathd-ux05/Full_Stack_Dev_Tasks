<?php
include "db.php";

$email = $_POST['email'];
$password = $_POST['password'];

$sql = "SELECT * FROM users WHERE email='$email' AND password='$password'";
$result = mysqli_query($conn, $sql);

if (mysqli_num_rows($result) === 1) {
    header("Location: dashboard.php");
} else {
    echo "<p style='color:red; text-align:center;'>Invalid Email or Password</p>";
    echo "<a href='index.html'>Go Back</a>";
}
?>
