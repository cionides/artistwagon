<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<c:if test="${not empty success}">
	<div role="alert" class="alert alert-success alert-dismissible fade in">
     <button type="button" data-dismiss="alert" aria-label="Close" class="close">
        <span aria-hidden="true">×</span>
     </button>
     <strong>SUCCESS:</strong> ${success}
   </div>
</c:if>

<div class="row">
	<div class="col-md-12 mb-xl">
		<h1 class="mt0">Events</h1>
	</div>
	<div class="col-md-12 mb-lg pr0">
		<c:if test="${currentUser.isAgency()}">
			<a href="${pageContext.request.contextPath}/app/events/new" class="btn btn-primary btn-lg radius-clear">Create New Event</a>
		</c:if>
		<div class="col-md-6 pull-right">
			<input type="text" placeholder="Search events..." class="form-control input-lg pr0 radius-clear" />
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<table class="table table-responsive">
			<thead>
				<th>Date</th>
				<th>Artist(s)</th>
				<th>Venue/Promoter</th>
				<th>Amount</th>
				<th>Status</th>
				<th>Options</th>
			</thead>
			<tbody>
				<c:forEach items="${events}" var="event">
		    	<tr>
		    		<td>${event.date}</td>
		    		<td>
		    			<c:forEach items="${event.payees}" var="payee">
		    				${payee.group.name} <br />
		    			</c:forEach>
		    		</td>
		    		<td>${event.payer.name}</td>
		    		<td><fmt:formatNumber value="${event.totalAmount}" type="currency" /></td>
		    		<td>${event.status}</td>
		    		<td>
		    			<a href="${pageContext.request.contextPath}/app/events/${event.id}">
		    				<c:choose>
						      <c:when test="${currentUser.isPayer() && !event.isPaid()}">
						      	Pay Now
						      </c:when>
						      <c:otherwise>
						      	Open Event
						      </c:otherwise>
								</c:choose>
		    			</a>
		    		</td>
		    	</tr>
			  </c:forEach>
			</tbody>
		</table>
	</div>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>