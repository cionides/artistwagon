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
			$('#firstName').focus();
		}, 800);
		
	});
	
	//GO TO STEP 3 FUNCTION
	$('#goToStep3').click(function() {
		
		$('#step2Panel').addClass('bounceOutLeft');

		setTimeout(function() 
		{
			$('#step2Panel').addClass('hidden');
			$('#step3Panel').removeClass('hidden');
		}, 400);
	});
	
	//GO TO STEP 4 FUNCTION
	$('#goToStep4').click(function() {
		
		$('#step3Panel').addClass('bounceOutLeft');

		setTimeout(function() 
		{
			$('#step3Panel').addClass('hidden');
			$('#step4Panel').removeClass('hidden');
		}, 400);
		
		setTimeout(function() 
				{
					$('#routingNumber').focus();
				}, 800);
	});
	
	//GO TO STEP 5 FUNCTION
	$('#goToStep5').click(function() {
		
		$('#step4Panel').addClass('bounceOutLeft');

		setTimeout(function() 
		{
			$('#step4Panel').addClass('hidden');
			$('#step5Panel').removeClass('hidden');
		}, 400);
		
		setTimeout(function() 
				{
					$('#bandName').focus();
				}, 800);
	});
	
});