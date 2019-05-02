<?php
$manager = new MongoDB\Driver\Manager("mongodb://localhost:27017");
var_dump($manager);
echo "MongoDB Verbindung war erfolgreich!";
?>
