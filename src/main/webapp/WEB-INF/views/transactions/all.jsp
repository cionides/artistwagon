<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>
	<div class="col-lg-12 clearfix p0">
	<span class="pull-left">Transactions</span>
	<span class="pull-right">Balance: <fmt:formatNumber value="${userBand[0].balance}" type="currency" /> </span>
	</div>
	<small>${userBand[0].band.name}</small>
</h3>
<div class="row">
   <div class="col-lg-9 pl0">
      <div class="panel panel-flat radius-clear b animated fadeInUp">
      	<div class="panel-body bb">
      			<div class="col-lg-8 pl0">
      				<input type="text" class="form-control" placeholder="Search Transactions..." />
      			</div>
      	</div>
      	<div class="panel-body text-center text-muted bb p0">
        	<h2>Pending Transactions</h2>
        </div>
        <c:forEach items="${pendingTransactions}" var="transaction">
        	<div class="panel-body bb">
        		<div class="col-lg-1 text-muted">
        			<h4 class="m0">05</h4>
        			<h5 class="m0">NOV</h5>
        		</div>
        		<div class="col-lg-5">
        			<h4>${transaction.description}</h4>
        		</div>
        		<div class="col-lg-2">
        			<h4>${transaction.type}</h4>
        		</div>
        		<div class="col-lg-2">
        			<h4 class="${transaction.type == 'Deposit' ? 'text-success' : 'text-danger'}">
        			<i class="mr-sm fa ${transaction.type == 'Deposit' ? 'fa-plus' : 'fa-minus'}"></i>
        				<fmt:formatNumber value="${transaction.amount}" type="currency" />
        			</h4>
        		</div>
        		<div class="col-lg-2 p0">
        			<a href="${pageContext.request.contextPath}/bank/bands/${userBand[0].id}/transactions/${transaction.id}/split" class="btn btn-block btn-primary btn-lg mt-sm">Split ${transaction.type}</a>
        		</div>
        	</div>
		   </c:forEach>
        <div class="panel-body text-center text-muted bb p0">
        	<h2>Completed Transactions</h2>
        </div>
        <c:forEach items="${completeTransactions}" var="transaction">
        	<div class="panel-body bb">
        		<div class="col-lg-1 text-muted">
        			<h4 class="m0">05</h4>
        			<h5 class="m0">NOV</h5>
        		</div>
        		<div class="col-lg-5">
        			<h4>${transaction.description}</h4>
        		</div>
        		<div class="col-lg-2">
        			<h4>${transaction.type}</h4>
        		</div>
        		<div class="col-lg-2">
        			<h4 class="${transaction.type == 'Deposit' ? 'text-success' : 'text-danger'}">
        				<i class="mr-sm fa ${transaction.type == 'Deposit' ? 'fa-plus' : 'fa-minus'}"></i>
        				<fmt:formatNumber value="${transaction.amount}" type="currency" />
        			</h4>
        		</div>
        		<div class="col-lg-2 p0">
        			<a href="${pageContext.request.contextPath}/bank/bands/${userBand[0].id}/transactions/${transaction.id}/split" class="btn btn-block btn-primary btn-lg mt-sm">Split ${transaction.type}</a>
        		</div>
        	</div>
		   </c:forEach>
     </div>
   </div>
   <div class="col-lg-3 pr0">
   	<div class="panel panel-flat radius-clear b animated fadeInUp">
   		<div class="panel-body">
   			<h3 class="text-center bb pb-lg">Transaction Details</h3>
   			<img src="http://www.garethjmsaunders.co.uk/blueprint/placeholders/gif/extras/google-map/map-medium.gif" alt="..." class="mb-lg img-thumbnail">
   			<form class="form-inline bt pt-lg">
				  <div class="form-group">
               <label class="col-lg-8 control-label">Write This Off?</label>
               <div class="col-lg-4">
                  <label class="switch switch-lg">
                     <input class="pull-right" type="checkbox">
                     <span></span>
                  </label>
               </div>
            </div>
				</form>
   		</div>
   	</div>
   </div>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>