<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<div class="row">
<div class="col-lg-8 col-lg-offset-2">
 <div class="panel radius-clear b animated bounceInDown mt-xl">
	<div class="panel-heading text-center">
		<h1>Create Event</h1>
		<h5>Put some text here that eventually explains all the rules about creating an event.</h5>
	</div>
	<div class="panel-body">
		<form:form method="POST" action="${pageContext.request.contextPath}/app/events/save">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="form-group clearfix">
				<div class="col-md-12">
					<form:label path="payer">Venue/Promoter <small>(Payer)</small></form:label>
					<form:select path="payer" class="form-control input-lg radius-clear">
						<option>--- Select ---</option>
    				<form:options items="${payerDropdownList}" itemValue="id" itemLabel="name" />
					</form:select>
				</div>
	    </div>
	    <div class="form-group clearfix">
				<div id="eventPayees" class="col-md-12">
					<form:label path="payees">Artist/Agent <small>(Payees)</small></form:label>
        	<div class="list-item">
						<form:select path="payees[0]" class="form-control input-lg radius-clear mb-sm">
							<option>--- Select ---</option>
    					<form:options items="${payeesDropdownList}" itemValue="name" itemLabel="name" />
						</form:select>
            <!-- <a href="#" class="list-remove">Remove</a> -->
        	</div>
					<a id="addPayee" class="pl-sm list-add" href="">Add Another Artist/Agent</a>
				</div>
	    </div>
	    <div class="form-group col-md-6">
				<form:label path="date">Date</form:label>
			  <form:input path="date" type="text" placeholder="Enter date" 
			   	autocomplete="off" data-inputmask="'mask': '99/99/9999'"
			   	 class="form-control input-lg radius-clear" />
	    </div>
	    <div class="form-group col-md-6">
				<form:label path="price">Price</form:label>
			  <form:input path="price" type="text" placeholder="Enter price" 
			   	autocomplete="off" class="form-control input-lg radius-clear" />
	    </div>
	    <div class="col-lg-12 mt-lg">
	    	<div class="pull-right">
			  	<button type=submit class="btn btn-lg btn-primary radius-clear mr-sm">Create</button>
			  	<a href="${pageContext.request.contextPath}/app/events">Cancel</a>
		  	</div>
		  </div>
	   </form:form>
	</div>
</div>
</div>
</div>

	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>