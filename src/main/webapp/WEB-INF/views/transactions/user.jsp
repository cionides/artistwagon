<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>Transactions <small>${group[0].name}</small></h3>
<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
      	<div class="panel-heading">
      		<div class="panel-title">Transactions</div>
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
                       <th>Options</th>
                    </tr>
                 </thead>
                 <tbody>
                 <c:forEach items="${transactions}" var="transaction">
   									<tr>
                     <td>${transaction.date}</td>
                     <td>${transaction.type}</td>
                     <td>${transaction.description}</td>
                     <td><fmt:formatNumber value="${transaction.amount}" type="currency" /></td>
                     <td>${transaction.status}</td>
                     <td><a href="${pageContext.request.contextPath}/groups/${userGroup[0].id}/transactions/${transaction.id}/split" class="btn btn-primary">Split</a>
                    </tr>
   							 </c:forEach>
                 </tbody>
              </table>
           </div>
        </div>
     </div>
   </div>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>