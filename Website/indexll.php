<!doctype html>
<html lang="en-US">
<head>

<form method="post"> 
    
          
        <input type="submit" name="button2"
                value="HOME"/>
				
<title> Database Analysis </title>
<?php
session_start();



//connect to mysql db, provide hostname, login privileges, dbname
$mysqli = mysqli_connect('192.168.1.133', 'Sam', '', 'smart_watch');


if (mysqli_connect_errno($mysqli)) {
    trigger_error('Database connection failed: '  . mysqli_connect_error(), E_USER_ERROR);
}

$query = "SELECT * FROM `Log` "; //this is the SELECT query to select all records

//query executed and result stored in variable $result.
$result = mysqli_query($mysqli, $query) or trigger_error("Query Failed! SQL: $query - Error: ". mysqli_error($mysqli), E_USER_ERROR);

?>
<!--this is html comment -->
<!--now we provide html to create table, to display data -->
<!--first row is header and is fixed, so we type it -->
<table width="30%">
<tr>
<td><b>ID</b></td>
<td><b>Temperature</b></td>
<td><b>Pressure</b></td>
<td><b>GPSLAT</b></td>
<td><b>GPSLON</b></td>
<td><b>Motion</b></td>



</tr>

<?php
//all other rows are now coming from the database 
//this is availale in $result. This has multiple rows, so we use loop to go through all of them
//for each row, we create a html row and display the php variable
if($result)
{   
    while($row = mysqli_fetch_assoc($result)) { //go through all rows       
        echo "<tr>";
        echo "<td>".$row['ID']."</td>";
        echo "<td>".$row['Temperature']."</td>";
            echo "<td>".$row['Pressure']."</td>";
        echo "<td>".$row['GPSLAT']."</td>";
        echo "<td>".$row['GPSLON']."</td>";
        echo "<td>".$row['Motion']."</td>";

        echo "</tr>";
    }//end of while
}//end of if

  if(isset($_POST['button2'])) { 
            echo "Home"; 			
			
			header('Location: index.php');



        } 




?>
</table>




<!-- Main Container Ends -->
</body>
</html>
