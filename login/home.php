<html>
<title>Database Application using PHP</title>

<script type="text/javascript">
function validateForm()
{ var un=document.form1.username.value;
  var pd=document.form1.psd.value;
  if(un=="" && pd!="")
  {	  
  document.getElementById("errorMessage").innerHTML="Please enter username";return false;	}
  if(un!="" && pd=="")
  {	   document.getElementById("errorMessage").innerHTML="Please enter password"; return false;	}
  if(un=="" && pd=="")
	  {	 document.getElementById("errorMessage").innerHTML="Please enter username & password";return false;	}
	}
</script>
<style>
div.container {
    width: 100%;
    border: 1px solid #fccb0a;
    padding: 5px;
    background-color: #D3D3D3;
}
.form-control {
	text-align: center;
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
	box-sizing: border-box;
}

tr, td {
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
}

h1 {
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif;
	color: blue;
	text-align: center;
}
</style>
<body>

<div class=container>
<h1> Database Application using PHP</h1>
<br>
		<br>
<?PHP
if ($_REQUEST ['action'] == 'edit') {
	?>
<form id="form1" name="form1" method="post"
		action="update.php?id=<?PHP echo $_REQUEST['id']; ?>"
		onSubmit="return validateForm();">
		
		<table align="center" width="200" border="1">
			<tr>
				<td>First Name</td>
				<td><label for="firstname"></label> <input type="text"
					name="firstname" id="firstname" class="form-control"
					value="<?PHP echo $_REQUEST['firstname']; ?>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><label for="lastname"></label> <input type="text"
					name="lastname" id="lastname" class="form-control"
					value="<?PHP echo $_REQUEST['lastname']; ?>" /></td>
			</tr>
			<tr>
			<tr>
				<td>Username</td>
				<td><label for="username"></label> <input type="text"
					name="username" id="username" class="form-control"
					value="<?PHP echo $_REQUEST['un']; ?>" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><label for="psd"></label> <input type="text" name="psd"
					class="form-control" id="psd"
					value="<?PHP echo $_REQUEST['pd']; ?>" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" id="submit" value="Submit" /></td>
				<td><input type="reset" name="Reset" id="Reset" value="Reset" /></td>
			</tr>
		</table>

	</form>
<?PHP
} else {
	?>
<form id="form1" name="form1" method="post" action="insert.php"
		onSubmit="return validateForm();">
		<table align="center" width="200" border="1">
			<tr>
				<td>First Name</td>
				<td><label for="firstname"></label> <input type="text"
					class="form-control" name="firstname" id="firstname" value="" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><label for="lastname"></label> <input type="text"
					class="form-control" name="lastname" id="lastname" value="" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><label for="username"></label> <input type="text"
					class="form-control" name="username" id="username" value="" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><label for="psd"></label> <input type="text" name="psd" id="psd"
					class="form-control" value="" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" id="submit" value="Submit" /></td>
				<td><input type="reset" name="Reset" id="Reset" value="Reset" /></td>
			</tr>
		</table>

	</form>
<?PHP } ?>
<p id="errorMessage" style="color: #C00; font-style: italic;"></p>

<?php
require_once ('conn.php');
$result = mysql_query ( "SELECT * FROM tbllogin" );
echo "<table align='center', border='2'>";
echo "<th>First Name</th><th>Last Name</th><th>Username</th><th>Password</th>";
while ( $row = mysql_fetch_array ( $result ) ) {
	echo "<tr>";
	$idn = $row ['id'];
	$firstname = $row ['firstname'];
	$lastname = $row ['lastname'];
	$un = $row ['username'];
	$pd = $row ['psd'];
	echo "<td>" . $row ['firstname'] . " </td>";
	echo "<td>" . $row ['lastname'] . " </td>";
	echo "<td>" . $row ['username'] . " </td>";
	echo "<td>" . $row ['psd'] . "</td>";
	echo "<td><a href='delete.php?id=$idn'>Delete</a></td>
   <td><a href='home.php?id=$idn&action=edit&firstname=$firstname&lastname=$lastname&un=$un&pd=$pd'>Edit</a></td>";
	echo "</tr>";
}
echo "</table>";

?>
<br>
<br>
</div>
</body>
</html>