<?php

$isbnentered=$_POST['isbnn'];

$Api1=myRestapiGET($isbnentered);
if($Api1=="[]" || $Api1=="" || $Api1==null)
{
	$Api2=GooglebooksAPI($isbnentered);



	echo $Api2;
}
else
{
	echo $Api1;
}







//My RESTAPIGET CALL

function myRestapiGET($isbn)
{
	$result="";
	$url = 'http://localhost:8080/Scanbook-server/books/'.$isbn;
	$options = array(
		'http' => array(
			'method'  => 'GET'
			),
		);
	$context  = stream_context_create($options);
	$result = @file_get_contents($url, false, $context);
	$result=str_replace(array('[', ']'), '', htmlspecialchars($result, ENT_NOQUOTES));

	
	return $result;

}

//GOOGLE API CALL

function GooglebooksAPI($isbn)
{
	$temp=$isbn;
	$API_KEY = 'AIzaSyCcbz-G_MwoPiNvVJdKSH3APtUds9KfBe0';

	require_once 'google-api-php-client-2.1.0_PHP54/vendor/autoload.php';

	$client = new Google_Client();
	$client->setApplicationName("Google Books");
	$client->setDeveloperKey( $API_KEY );

	$service = new Google_Service_Books($client);

	$optParams = ['q'=>'isbn:'.$isbn];

	$results = $service->volumes->listVolumes('', $optParams);

	foreach ( $results as $item ) {

		$title=$item['volumeInfo']['title'];
		$publisher=$item['volumeInfo']['publisher'];
		$pagecount=$item['volumeInfo']['pageCount'];
		$description=$item['volumeInfo']['description'];


	}

	$prefix = $autho ='';
	foreach($item['volumeInfo']['authors']as $item2)
	{
		if(sizeof($item['volumeInfo']['authors'])==1)
		{
			$autho=$item2;
		}
		else
		{
			$autho .=$prefix. '"' .$item2 . '"';
			$prefix = ',';

		}

	}

	if($publisher==null||$publisher=="")
	{
		$publisher="not known";
	}

	$list=array('title'=>$title,'author'=>$autho,'publisher'=>$publisher,'noofpages'=>$pagecount,'description'=>$description);

	$list2=json_encode($list);
	
	myRestAPIPOST($temp,$title,$autho,$publisher,$pagecount,$description);

	return $list2;

}

//MYRESTAPIPOST METHOD IS AUTOMATICALLY CALLED WHEN THE BOOK IS FETCHED FROM GOOGLE API TO STORE IN MY OWN RESTAPI

function myRestAPIPOST($isbnn,$titlee,$authorr,$publisherr,$pagecountt,$descriptionn)
{

	$url = 'http://localhost:8080/Scanbook-server/books';
	$data2 = array('Isbn'=>$isbnn,'Title'=>$titlee,'author'=>$authorr,'publisher'=>$publisherr,'description'=>$descriptionn,'noofpages'=>$pagecountt,'notes'=>'Enter notes here','isread'=>'N');
	$options = array(
		'http' => array(
			'header'  => "Content-type: application/x-www-form-urlencoded\r\n",
			'method'  => 'POST',
			'content' => http_build_query($data2),
			),
		);
	$context  = stream_context_create($options);
	$result = @file_get_contents($url, false, $context);
	return;

}


?>
