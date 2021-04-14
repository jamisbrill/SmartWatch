
 <?php  
 $connect = mysqli_connect("192.168.1.133", "Sam", "", "smart_watch");  
 $query = "SELECT DISTINCT ID, Temperature, Pressure, Motion FROM Log";  
$chartType = "LineChart";
 $result = mysqli_query($connect, $query);  
 ?>  
 
 <!DOCTYPE html>  
 <html>  
      <head>  
           <title>Chart Analysis</title>  
		   
		   		<p> Enter User ID to view </p>
	<form action="/action_page.php" method="post">
			
		<input type="text" id="ID" name="ID">
			<input type="submit" value="Submit">		
				
    </form> 
		   
		   
           <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>  
           <script type="text/javascript">  
           google.charts.load('current', {'packages':['corechart']});  
           google.charts.setOnLoadCallback(drawChart);  
         
		 function drawChart()  
           {  
                var data = google.visualization.arrayToDataTable([  
                          ['ID', 'Temperature','Pressure','Motion' ],  
                          <?php  
                          while($row = mysqli_fetch_array($result))  
                          {  
             echo "['".$row["ID"]."', ".$row["Temperature"].",".$row["Pressure"].",".$row["Motion"]."],"; 

                          }  
                          ?>  
                     ]);  
                var options = {  
                      title: 'Data of each Client',  
                      is3D:true,  
					    hAxis: {
          title: 'Value (C,hpa,Newtons)',
          minValue: 0
        },
        vAxis: {
          title: 'Client ID'
        }	
                     };  
							 
    var chart = new google.visualization.BarChart(document.getElementById('BarChart'));  				
					 
                chart.draw(data, options);  					 
           }  
		   		 
           </script>
		   
      </head>  
      <body>  
           <br /><br />  
           <div style="width:900px;">  
                <h3 align="center">Current Data of  Clients</h3>  
                <br />  
			
                <div id="BarChart" style="width: 900px; height: 500px;"></div>     
		   </div>  
		   
		   
		   <form method="post"> 
        <input type="submit" name="button1"
                value="Change Chart Style"/> 
          
        <input type="submit" name="button2"
                value="View Raw Database"/> 
				    </form> 

		
	
		<p> Enter map coordinates of the patient </p>
	<form action="/simple_map.php" method="post">
			
		<input type="text" id="LAT" name="LAT">
				<input type="text" id="LON" name="LON">

			<input type="submit" value="Submit">		
				
    </form> 	
		


	<?php
      
        if(isset($_POST['button1'])) { 
            echo "Redirecting";
						$chartType = "LineChart";
				echo "$chartType"; 
							header('Location: OtherChart.php');


        } 
        if(isset($_POST['button2'])) { 
            echo "This is Button2 that is selected"; 
		$chartType = "BarChart";
			echo "$chartType"; 
			$chartType = "BarChart";	
			header('Location: indexll.php');
		

        }


				
    ?> 
		   
      </body>  
 </html>  