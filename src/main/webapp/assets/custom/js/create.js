$(document).ready(function() {
	
	//Loads any input masks on the create page.
	$(":input").inputmask();
	
	//Loads Dynamic List For Payee's
    $("#eventPayees").dynamiclist();

});