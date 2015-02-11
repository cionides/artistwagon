$(document).ready(function() {
	
	$('input[name="typeRadios"]').click(function() {
				
		if($('input[name="typeRadios"]:checked').val() == 'new') {
			$('#newGroupContainer').removeClass('hidden');
			$('#existingGroupContainer').addClass('hidden');
		};
		
		if($('input[name="typeRadios"]:checked').val() == 'existing') {
			$('#existingGroupContainer').removeClass('hidden');
			$('#newGroupContainer').addClass('hidden');
		};
		
	});
	
});