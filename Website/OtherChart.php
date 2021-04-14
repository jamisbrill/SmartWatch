<form method="post"> 
    
          
        <input type="submit" name="button2"
                value="HOME"/>
				



 <?php  
 
 
  if(isset($_POST['button2'])) { 
            echo "Home"; 			
			
			header('Location: index.php');
  }
 
 
 
 $connect = mysqli_connect("192.168.1.133", "Sam", "", "smart_watch");  
 $query = "SELECT DISTINCT ID, Temperature, Pressure, Motion FROM Log";  

 $result = mysqli_query($connect, $query);  
 ?>  
 <!DOCTYPE html>  
 <html>  
      <head>  
           <title> Chart Analysis </title>  
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
                    
					  
					    hAxis: {
          title: 'Value (C,hpa,Newtons)',
          minValue: 0
        },
        vAxis: {
          title: 'Client ID'
        }
		
		
                     };  
                var chart = new google.visualization.LineChart(document.getElementById('LineChart'));  
                chart.draw(data, options);  
           }  
           </script>  
      </head>  
      <body>  
           <br /><br />  
           <div style="width:900px;">  
                <h3 align="center">Current Data of  Clients</h3>  
                <br />  
                <div id="LineChart" style="width: 900px; height: 500px;"></div>  
           </div>  
      </body>  
 </html>  