<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>My Groups <small>Artist Wagon</small></h3>
<div class="row">
	<c:forEach items="${userGroups}" var="userGroup" varStatus="loop">
		<div class="col-lg-4">
			<div class="panel panel-default panel-flat ba radius-clear">
	        <div class="panel-body">
	        	<h4>${userGroup.group.name}
		        	<small class="pull-right mt-sm">
		        		<a href="${pageContext.request.contextPath}/app/groups/${userGroup.id}">View Group</a>
		        	</small>
	        	</h4>
	        	<table class="table table-bordered mb-lg">
	        		<tr>
	        			<td><strong>Balance</strong></td>
	        			<td class="text-right"><fmt:formatNumber value="${userGroup.balance}" type="currency" /></td>
	        		</tr>
	        		<tr>
	        			<td><strong>Members</strong></td>
	        			<td class="text-right">5</td>
	        		</tr>
	        	</table>
	        	<ul class="nav nav-pills nav-justified">
						  <li role="presentation">
						  	<a href="${pageContext.request.contextPath}/app/groups/${userGroup.id}/add">Add Money</a>
						  </li>
						  <li role="presentation">
						  	<a href="${pageContext.request.contextPath}/app/groups/${userGroup.id}/withdraw">Withdraw Money</a>
						  </li>
						  <li role="presentation">
						  	<a href="#">Request Money</a>
						  </li>
						</ul>
	        </div>
	     </div>
		</div>
		<c:if test="${not loop.first and (loop.index + 1) % 3  == 0}">
			</div>
			<div class="row mt-lg">
		</c:if>
	</c:forEach>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>