<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>
	<div class="col-lg-12 clearfix p0">
	<span class="pull-left">${userGroup[0].group.name} <a href="#">Change Band</a></span>
	<span class="pull-right">Balance: <fmt:formatNumber value="${userGroup[0].balance}" type="currency" /> </span>
	</div>
	<small>Band Members</small>
</h3>
<div class="row">
   <div class="col-lg-12 pl0 pr0">
	   <div class="panel panel-default panel-flat ba radius-clear animated fadeInUp">
	        <div class="panel-body">
	           <div class="table-responsive">
	              <table class="table table-striped">
	                 <thead>
	                    <tr>
	                       <th>Member Name</th>
	                       <th>Status</th>
	                    </tr>
	                 </thead>
	                 <tbody>
	                 <c:forEach items="${groupMembers}" var="groupMember">
	                 	<tr>
	                 		<td>${groupMember.user.fullName}</td>
	                 		<td>Active</td>
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