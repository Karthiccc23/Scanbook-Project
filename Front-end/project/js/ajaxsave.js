

//SAVE NOTES BUTTON TO ADD NOTES TO EACH BOOK

$(document).ready(function(){
	$("#save").click(function()
	{
		var isbn= $('#isbn').val();	
		var title = document.getElementById('Title').textContent;
		var notes = $('#notes').val();
		if (!$("#checkboxie").is(":checked"))
		{

			var isread='N';
		}
		else
		{
			var isread='Y';
		}

		$.ajax({
			type:"POST",
			url:"Addnotes.php",
			data : {isbnn:isbn,notess:notes,isreadd:isread},

			success:function(response)
			{
			
				alert(response);
			}
		});




	});

});