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
			<div class="row">
	   		<div class="form-group col-md-3 ml-lg">
					<form:label path="date">Date</form:label>
				  <form:input path="date" type="text" placeholder="Enter date" 
				   	autocomplete="off" autofocus="autofocus" data-inputmask="'mask': '99/99/9999'"
				   	 class="form-control input-lg radius-clear" />
	    	</div>
	    </div>
			<div class="row">
				<div class="form-group ml-lg clearfix">
					<div class="col-md-5 pr0">
						<form:label path="payer">Venue/Promoter <small>(Payer)</small></form:label>
						<form:select path="payer" class="form-control input-lg radius-clear">
							<option>--- Select ---</option>
	    				<form:options items="${payerDropdownList}" itemValue="id" itemLabel="name" />
						</form:select>
					</div>
		    </div>
		  </div>
		  <div class="row">
		    <div class="form-group ml-lg clearfix">
					<div id="eventPayees" class="col-md-12">
						<div class="row">
							<p class="pl-lg mt-sm mb-lg"><strong>Note:</strong> Leave agency fee blank if it does not apply.</p>
							<div class="col-md-5">
								<form:label path="payees">Artist(s) <small>(Payees)</small></form:label>
							</div>
							<div class="col-md-3 pr0">
								<form:label path="payees">Amount</form:label>
							</div>
							<div class="col-md-3 pr0">
								<form:label path="payees">Agency Fee</form:label>
							</div>
						</div>
	        	<div class="row list-item">
		        	<div class="col-md-5 pr0">
								<form:select path="payees[0].groupId" class="form-control input-lg radius-clear mb-sm">
									<option>--- Select ---</option>
		    					<form:options items="${payeesDropdownList}" itemValue="id" itemLabel="name" />
								</form:select>
							</div>
							<div class="col-md-3 pr0">
								<form:input path="payees[0].amount" type="text" placeholder="Enter amount" 
					   			autocomplete="off" class="form-control input-lg radius-clear cost-input" />
							</div>
							<div class="col-md-3 pr0">
								<form:input path="payees[0].agencyFee" type="text" placeholder="Enter fee" 
					   			autocomplete="off" class="form-control input-lg radius-clear cost-input" />
							</div>
							<div class="col-md-1 mt-sm pt-sm">
								<a href="#" class="list-remove text-danger">
									X
								</a> 
							</div>
	        	</div>
	        	<div class="col-md-12 pl-sm">
							<a id="addPayee" class="list-add" href="">Add Another Artist</a>
						</div>
					</div>
		    </div>
		  </div>
      <hr />
      	<h3 class="ml-lg">Total Amount: <span id="totalAmount">$0</span></h3>
      <hr />
	    <div class="col-md-12 mt-lg">
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