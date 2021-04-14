
 <?php  
 $ID = $_POST['ID'];
 $connect = mysqli_connect("192.168.1.133", "Sam", "", "smart_watch");  

if (is_numeric($ID) && $ID <7) {

}
else {
	
	
    header('Location: index.php');

	
}



 $query = "SELECT * FROM `Log` WHERE `ID` = $ID";  
 // $query = "SELECT ID, count(*) as number FROM Log GROUP BY ID";  

//$chartType = "BarChart";
$chartType = "LineChart";



 $result = mysqli_query($connect, $query);  
 ?>  





<head>
<title>Selected Chart</title>
</head>
<body>
ID Selected: <?php echo $_POST["ID"]; ?><br />

  <title>Chart Analysis</title>  
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
				    //    chartArea: {width: '50%'},



                      title: 'Data of Client selected',  
                      //is3D:true,  
                      //pieHole: 0.4  
					  
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
                <h3 align="center">Current Data of Client ID:<?php echo $ID;  ?> </h3>  
                <br />  
			
                <div id="BarChart" style="width: 900px; height: 500px;"></div>  

		   
		   </div>  
		   
		<form method="post"> 
       
	<input type="submit" name="button2"
                value="HOME"/>
	
	
	 <?php
      
       if(isset($_POST['button2'])) { 
            echo "Home"; 			
			
			header('Location: index.php');
  }



        
    ?> 






</body>
</html>