<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
		phpinfo();
        // connect to mongodb
        $m = new MongoClient();
	
        echo "Connection to database successfully";
        // select a database
        //$db = $m->mydb;
	
        //echo "Database mydb selected";
        ?>
    </body>
</html>
