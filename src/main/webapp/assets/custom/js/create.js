$(document).ready(function() {
	
	//Loads any input masks on the create page.
	$(':input').inputmask();
	
	//Loads Dynamic List For Payee's
    $('#eventPayees').dynamiclist();
    
    //Toggles Agency Fee amount
    $('#agencyFeeCheckbox').change(function(){
    	
        $('#amountGroup').toggleClass('hidden');
        
    });
    
    //Calculates Total Price
    $(document).on('keyup', '.cost-input', function() {
    	
    	totalAmount = 0;
    	var allCostInputs = $('.cost-input');
    	var agencyFee = $('#agency-fee');
  
    	
    	$.each(allCostInputs, function(key,value) {
    		totalAmount = totalAmount + Number(value.value);
    	});
    	
    	if(agencyFee.value != null) {
        	totalAmount = totalAmount + Number(agencyFee.value);
    	}
    	
    	$('#totalAmount').text('$' + totalAmount);
    	
    });

});