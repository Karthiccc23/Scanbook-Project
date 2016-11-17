



// ON KEY VALIDATION


$(document).ready(function() {
  $("#isbn").keydown(function (e) {


   var isbn= $('#isbn').val();  

   var isbnnew =isbn.replace(/[^0-9X]/gi,'');

    
    if(e.keyCode!=16&&e.keyCode!=17&&e.keyCode!=18&&e.keyCode!=9&&e.keyCode!=27&&e.keyCode!=110&&
      e.keyCode!=190&&e.keyCode!=37&&e.keyCode!=38&&e.keyCode!=39&&e.keyCode!=40&&e.keyCode!=189&&e.keyCode!=8
      && isNaN(String.fromCharCode(e.keyCode)))
    {
      document.getElementById('errordisplay').innerHTML ="Please Enter numeric value";
      $('.warning').show().delay(3000).fadeOut();
      e.preventDefault();
    }

    


  });



  $("#isbn").keyup(function (e) {
   var input = e.currentTarget.value;
   var input2 =input.replace(/[^0-9X]/gi,'');
   if(e.keyCode!=8&&(input.search(/^9/) == -1)){
    document.getElementById('errordisplay').innerHTML ="Please Start with digit value 9";
    $('.warning').show().delay(3000).fadeOut();
  }

  if(input2.length>12)
  {
    document.getElementById('errordisplay').innerHTML ="Only 13 digits allowed";
    $('.warning').show().delay(3000).fadeOut();

  }
  

});
});

