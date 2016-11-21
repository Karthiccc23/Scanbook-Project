

//SEARCH BUTTON TO VALIDATE AND CALL API

$(document).ready(function(){


  $("#sub").click(function()
  {
   var isbn= $('#isbn').val();	
   var isbnnew =isbn.replace(/[^0-9X]/gi,'');
   document.getElementById('errordisplay').innerHTML ="< < < < LOADING > > > >";
   $('.warning').show();

   var val = validateForm(isbnnew);


   if (val==false)
   {
    document.getElementById('errordisplay').innerHTML ="Invalid ISBN";
    $('.warning').show().delay(2000).fadeOut();

  }
  else
  {

                 
                   $.ajax({
                    type:"POST",
                    url:"search.php",
                    data : {isbnn:isbnnew},


                  //RESPONSE - JSON FORMAT PARSED AND SET IN HTML FORM

                  success:function(response)
                  {
                    $('.warning').hide();
                     document.getElementById('Title').innerHTML ="";
                     document.getElementById('author').innerHTML =""
                     document.getElementById('noofpages').innerHTML ="" ;
                     document.getElementById('notes').innerHTML ="Enter notes here" ;


                     document.getElementById('publisher').innerHTML ="" ;

                     document.getElementById('description').innerHTML ="";
                     $('#searchbookdetails').show();


                     var b=$.parseJSON(response);
                     var isread=b['isRead'] ;

                     document.getElementById('Title').innerHTML =b['title'] ;
                     document.getElementById('author').innerHTML =b['author'] ;
                     document.getElementById('noofpages').innerHTML =b['noofpages'];

                     document.getElementById('publisher').innerHTML =b['publisher'] ;
                     document.getElementById('description').innerHTML =b['description'] ;

                     if(isread=='Y')
                     {
                      $('#checkboxie').attr('checked', true);

                    }
                    else
                    {
                     $('#checkboxie').attr('checked', false);
                   }

                   if(b['notes']=="" ||b['notes']==null)
                   {
                    document.getElementById('notes').innerHTML ="Enter notes here" ;

                  }
                  else
                  {
                    document.getElementById('notes').innerHTML =b['notes'] ;

                  }




                }
              });

                 }

               });

              // CONNECTION ERROR CHECK 


              $(document).ajaxError(function(e, xhr, opt,exception){

               if (xhr.status === 0) {
                 alert ('Not connected.\nPlease verify your network connection.');
               }
               else {
                 alert ('Uncaught Error.\n' + xhr.response.statusText);
               }
             });

            });
