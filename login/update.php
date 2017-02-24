<?php
require_once('conn.php');
$idp= $_REQUEST['id'];
$firstname= $_POST['firstname'];
$lastname= $_POST['lastname'];
$un= $_POST['username'];
$pd= $_POST['psd'];
mysql_query("UPDATE tbllogin SET firstname='$firstname', lastname='$lastname', username='$un',psd='$pd' where id=$idp");
header("location:home.php?action");
?>