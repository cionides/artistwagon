<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>
	<div class="col-lg-12 clearfix p0">
	<span class="pull-left">${userGroup[0].group.name} <a href="#">Change Band</a></span>
	<span class="pull-right">Balance: <fmt:formatNumber value="${userGroup[0].balance}" type="currency" /> </span>
	</div>
	<small>Add Money</small>
</h3>
<div class="row">
   <div class="col-lg-12">
      <form action="${pageContext.request.contextPath}/bank/bands/${userGroup[0].id}/add/submit" class="form-horizontal">
      	<fieldset>
      		<div class="form-group-lg">
	          <label class="col-lg-2 control-label">Bank Account</label>
	          <div class="col-lg-4">
	             <select class="form-control">
	             	<option>Select One...</option>
	             	<option>Checking XXXX-XXXX-XXXX-6978</option>
	             	<option>Saving XXXX-XXXX-XXXX-1598</option>
	             </select>
	          </div>
          </div>
      	</fieldset>
      	<fieldset>
      		<div class="form-group-lg">
	          <label class="col-lg-2 control-label">Enter Amount</label>
	          <div class="col-lg-2">
	             <div class="input-group">
                 <span class="input-group-addon">$</span>
                 <input type="text" class="form-control">
              </div>
	          </div>
          </div>
      	</fieldset>
				<div class="col-lg-offset-2 col-lg-10">
					<button type="submit" class="btn btn-lg btn-primary">Submit</button>
				</div>
      </form>
   </div>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>