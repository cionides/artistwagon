<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>Snapshot <small>Cowboy Jukebox</small></h3>
<div class="row">
   <div class="col-lg-8">
      <div class="panel panel-default panel-flat ba radius-clear">
      	<div class="panel-heading">
      		<div class="panel-title">Recent Transactions</div>
      	</div>
        <div class="panel-body">
           <div class="table-responsive">
              <table class="table table-striped">
                 <thead>
                    <tr>
                       <th>Date</th>
                       <th>Type</th>
                       <th>Description</th>
                       <th>Amount</th>
                       <th>Status</th>
                    </tr>
                 </thead>
                 <tbody>
                 </tbody>
              </table>
           </div>
        </div>
        <div class="panel-footer">
        	<div class="row">
        		<div class="col-lg-9"></div>
          	<div class="col-lg-3">
          		<a href="${pageContext.request.contextPath}/app/groups/1/transactions" class="btn btn-primary btn-block">All Transactions</a>
            </div>
        	</div>
     		</div>
     </div>	
   </div>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>