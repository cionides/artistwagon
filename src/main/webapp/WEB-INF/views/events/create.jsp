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
	   		<div class="form-group col-md-4 ml-lg">
					<form:label path="date">Date</form:label>
				  <form:input path="date" type="text" placeholder="Enter date" 
				   	autocomplete="off" autofocus="autofocus" data-inputmask="'mask': '99/99/9999'"
				   	 class="form-control input-lg radius-clear" />
	    	</div>
	    </div>
			<div class="row">
				<div class="form-group ml-lg clearfix">
					<div class="col-md-7">
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
						<div class="col-md-7 pl0">
							<form:label path="payees">Artist(s) <small>(Payees)</small></form:label>
						</div>
						<div class="col-md-3 pr0">
							<form:label path="payees">Amount</form:label>
						</div>
	        	<div class="list-item">
		        	<div class="col-md-7 pl0">
								<form:select path="payees[0].groupId" class="form-control input-lg radius-clear mb-sm">
									<option>--- Select ---</option>
		    					<form:options items="${payeesDropdownList}" itemValue="id" itemLabel="name" />
								</form:select>
							</div>
							<div class="col-md-3 pr0">
								<form:input path="payees[0].cost" type="text" placeholder="Enter amount" 
					   			autocomplete="off" class="form-control input-lg radius-clear cost-input" />
							</div>
							<div class="col-md-2 mt-sm pt-sm">
								<a href="#" class="list-remove text-danger">
									Remove
								</a> 
							</div>
	        	</div>
	        	<div class="col-md-12 pl-sm">
							<a id="addPayee" class="list-add" href="">Add Another Artist</a>
						</div>
					</div>
		    </div>
		  </div>
	    <div class="row">
		    <div class="form-group col-md-3 ml-lg mb-sm">
					<label>Agency Fee</label>
				  <div class="checkbox c-checkbox mt-lg">
		        <label>
		          <input id="agencyFeeCheckbox" type="checkbox" />
		          <span class="fa fa-check"></span>
		        </label>
	      	</div> 
	      </div>
      </div>
      <div class="row">
		    <div id="amountGroup" class="form-group col-md-3 ml-lg hidden">
					<form:label path="agencyFee">Amount</form:label>
		      <form:input path="agencyFee" placeholder="Enter amount" class="form-control input-lg radius-clear cost-input" type="text" />
	      </div>
      </div>
      <hr />
      	<h3 class="ml-lg">Total Amount: <span id="totalAmount"></span></h3>
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