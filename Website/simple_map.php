<!DOCTYPE html>


 <?php  
 $LAT = $_POST['LAT'];
  $LON = $_POST['LON'];
 ?>  
<html>
<head>

	<title>Map</title>
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
	<meta charset="utf-8">
	<style>
      /* Always set the map height explicitly to define the size of the div
      * element that contains the map. */
      #map {
      	height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
      	height: 100%;
      	margin: 0;
      	padding: 0;
      }
      #floating-panel {
      	position: absolute;
      	top: 0;
      	left: 0%;
      	z-index: 0;
      	background-color: #fff;
      	padding: 5px;
      	border: 1px solid #999;
      	text-align: center;
      	font-family: 'Roboto','sans-serif';
      	line-height: 30px;
      	padding-left: 10px;
      }
  </style>
</head>
<body>
<br>
Latitude <?php echo $_POST["LAT"]; ?>
 Longitude <?php echo $_POST["LON"]; ?>
<br />

	<div id="map"></div>
	<script>
		function initMap() {
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom: 8,
				center: {lat: <?php echo $LAT; ?> , lng:<?php echo $LON; ?> }
				//center: {lat: 2, lng: 1 }

			});
			var geocoder = new google.maps.Geocoder();

			document.getElementById('submit').addEventListener('click', function() {
				geocodeAddress(geocoder, map);
			});
		}

		function geocodeAddress(geocoder, resultsMap) {
			var address = document.getElementById('address').value;
			geocoder.geocode({'address': address}, function(results, status) {
				if (status === 'OK') {
					resultsMap.setCenter(results[0].geometry.location);
					var marker = new google.maps.Marker({
						map: resultsMap,
						position: results[0].geometry.location
					});
				} else {
					alert('Geocode was not successful for the following reason: ' + status);
				}
			});
		}
	</script>
	<script async defer
	
	src="https://maps.googleapis.com/maps/api/js?key=INSERTKEY=initMap">
</script>


  



</body>
</html>