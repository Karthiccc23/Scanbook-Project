<?php

//POST METHOD TO ADD NOTES TO EACH EXISTING BOOK


$url = 'http://localhost:8080/Scanbook-server/addnotes';
$data2 = array('Isbn'=>$_POST['isbnn'],'notes'=>$_POST['notess'],'isread'=>$_POST['isreadd']);
$options = array(
	'http' => array(
		'header'  => "Content-type: application/x-www-form-urlencoded\r\n",
		'method'  => 'POST',
		'content' => http_build_query($data2),
		),
	);
$context  = stream_context_create($options);
$result = @file_get_contents($url, false, $context);

if($result==false)
{
	echo "(Server not up)- notes not saved";
}
else
{
	echo "(success)- notes saved";
}
?>