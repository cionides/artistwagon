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

<div class="row mt-lg">
	<div class="col-md-2">
		<p class="mb-sm">Current Balance</p>
		<h2 class="mt0"><fmt:formatNumber value="${currentUser.balance}" type="currency" /></h2>
		<a href="#">Withdraw</a>
	</div>
	<div class="col-md-10 bl">
		<div class="col-md-6 mt-sm">
			<h1 class="mt0">Events</h1>
		</div>
		<div class="col-md-6">
			<c:if test="${currentUser.isAgency()}">
				<a href="${pageContext.request.contextPath}/app/events/new" class="pull-right btn btn-primary btn-lg radius-clear">Create New Event</a>
			</c:if>
		</div>
		<div class="col-md-12 mt-xl">
			<table class="table table-responsive">
				<thead>
					<th>Date</th>
					<c:if test="${!currentUser.isArtist()}">
					<th>Artist(s)</th>
					</c:if>
					<th>Venue/Promoter</th>
					<th>Amount</th>
					<th>Status</th>
					<th>Options</th>
				</thead>
				<tbody>
				<c:forEach items="${events}" var="event">
		    	<tr>
		    		<td>${event.date}</td>
		    		<c:if test="${!currentUser.isArtist()}">
		    		<td>
		    			<c:forEach items="${event.payees}" var="payee">
		    				${payee.group.name} <br />
		    			</c:forEach>
		    		</td>
		    		</c:if>
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
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>