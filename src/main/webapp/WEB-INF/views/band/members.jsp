<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>
	<div class="col-lg-12 clearfix p0">
	<span class="pull-left">Band Members</span>
	<span class="pull-right">Balance: <fmt:formatNumber value="${userBand[0].balance}" type="currency" /> </span>
	</div>
	<small>${userBand[0].band.name}</small>
</h3>
<div class="row">
   <div class="col-lg-12 pl0 pr0">
	   <div class="panel panel-flat radius-clear b animated fadeInUp">
	        <div class="panel-body">
	           <div class="table-responsive">
	              <table class="table table-striped">
	                 <thead>
	                    <tr>
	                       <th>Member Name</th>
	                       <th>Role</th>
	                       <th>Status</th>
	                    </tr>
	                 </thead>
	                 <tbody>
	                 <c:forEach items="${bandMembers}" var="bandMember">
	                 	<tr>
	                 		<td>${bandMember.user.username}</td>
	                 		<td>Musician</td>
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