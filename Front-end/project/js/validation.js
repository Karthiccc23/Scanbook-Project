function validateForm(isbnvalidate) {
     var y =isbnvalidate.toString();


//WEIGHTED CHECK SUM
     var sum = 0;
        for (var i = 0; i < 12; i++) {
            var digit = parseInt(y[i]);
            if (i % 2 == 1) {
                 sum +=3*digit;
            } else {
                  sum +=digit;
            }
        }
        var check = (10 - (sum % 10)) % 10;
  

 // VALIDATION - NULL AND CHECK DIGIT
 
    if (isbnvalidate== null || !(check==y[12]))
    {
    	return false;
    }
    


}