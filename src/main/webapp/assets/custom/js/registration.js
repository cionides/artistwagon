$(document).ready(function() {
	
	
	//GO TO STEP 2 FUNCTION
	$('#goToStep2').click(function() {
		
		$('#step1Panel').addClass('bounceOutLeft');

		setTimeout(function() 
		{
			$('#step1Panel').addClass('hidden');
			$('#step2Panel').removeClass('hidden');
		}, 400);
		
		setTimeout(function() 
		{
			$('#routingNumber').focus();
		}, 800);
		
	});
	
});