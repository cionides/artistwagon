<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>


<div class="row">
	<div class="col-lg-8 col-lg-offset-2">
		<div class="panel radius-clear b animated bounceInDown mt-xl">
			<div class="panel-heading text-center">
				<h1>Event Details</h1>
				<h5>Put some text here about event details.</h5>
			</div>
			<div class="panel-body">
			<table class="table mb-xl">
				<tbody>
					<tr>
						<td class="col-lg-3"><strong>Status</strong></td>
						<td>${event.status}</td>
					</tr>
					<tr>
						<td class="col-lg-3"><strong>Date</strong></td>
						<td>${event.date}</td>
					</tr>
					<tr>
						<td class="col-lg-3"><strong>Venue/Promoter</strong></td>
						<td>${event.payer.name}</td>
					</tr>
					<tr>
						<td class="col-lg-3"><strong>Artist<c:if test="${event.payees.size() > 1}">(s)</c:if></strong></td>
						<td>
							<c:forEach items="${event.payees}" var="payee">
    							${payee.group.name} 
    							<c:if test="${!currentUser.isVenue()}"> <br/>
    								 <small class="ml-lg">Amount: <fmt:formatNumber value="${payee.amount}" type="currency" /></small> <br/>
    								 <small class="ml-lg">Agency Fee: <fmt:formatNumber value="${payee.agencyFee}" type="currency" /></small>
    							</c:if>
    							<br />
    					</c:forEach>
    				</td>
					</tr>
					<tr>
						<td class="col-lg-3"><strong>Total Amount</strong></td>
						<td><fmt:formatNumber value="${event.totalAmount}" type="currency" /></td>
					</tr>
				</tbody>
			</table>
				<c:if test="${currentUser.isPayer() && !event.isPaid()}">
					<a href="${pageContext.request.contextPath}/app/events/${event.id}/makePayment" class="btn btn-success btn-block btn-lg">Pay Now</a>
				</c:if>
			</div>
		</div>
	</div>
</div>

	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>