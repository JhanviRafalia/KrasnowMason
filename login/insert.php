<?php
require_once('conn.php');
$un= $_POST['username'];
$pd= $_POST['psd'];
$firstname= $_POST['firstname'];
$lastname= $_POST['lastname'];
mysql_query("INSERT INTO tbllogin (firstname, lastname, username, psd) VALUES ('$firstname','$lastname', '$un', '$pd')");
header("location:home.php?action");
?>