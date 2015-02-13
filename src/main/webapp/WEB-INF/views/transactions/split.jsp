<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>Split ${transaction[0].type} <small>${userGroup[0].group.name}</small></h3>
<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
        <div class="panel-body">
           <form method="get" action="/" class="form-horizontal">
		         <fieldset>
	            <div class="form-group">
	               <label class="col-lg-2 control-label">${transaction[0].type} Amount</label>
	               <div class="col-lg-10">
	                  <p class="form-control-static">
	                  	<fmt:formatNumber value="${transaction[0].amount}" type="currency" />
	                  </p>
	               </div>
	             </div>
		          </fieldset>
           	  <fieldset>
                 <div class="form-group">
                    <label class="col-sm-2 control-label mr-lg">Select Members</label>
                    <div class="col-sm-8">
			                <label class="checkbox pb-sm">
			                   <input id="roundedcheckbox20" type="checkbox" />
			                   Nick Adelberger
			                </label>
			                <label class="checkbox pb-sm">
			                   <input id="roundedcheckbox20" type="checkbox" />
			                   Adam Michaels
			                </label>
			                <label class="checkbox pb-sm">
			                   <input id="roundedcheckbox20" type="checkbox" />
			                   Laura Savage
			                </label>
			                <label class="checkbox">
			                   <input id="roundedcheckbox20" type="checkbox" />
			                   Doug Pawlik
			                </label>
        						</div>
                 </div>
                </fieldset>
                <fieldset>
                 <div class="form-group">
                    <label class="col-sm-2 control-label">Split Evenly?</label>
                    <div class="col-sm-10">
                       <div class="radio pb-sm">
                          <label>
                             <input id="typeRadiosNew" type="radio" 
                             	name="typeRadios" value="new">Yes</label>
                       </div>
                       <div class="radio">
                          <label>
                             <input id="typeRadiosExisting" type="radio" 
                             	name="typeRadios" value="existing">No</label>
                       </div>
                    </div>
                 </div>
              </fieldset>
            	 <a href="${pageContext.request.contextPath}/groups/${userGroup[0].id}/transactions" class="btn btn-primary pull-right">Submit</a>
           </form>
        </div>
     </div>
   </div>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>