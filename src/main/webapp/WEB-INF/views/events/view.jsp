<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>


<div class="row">
	<div class="col-lg-8 col-lg-offset-2">
		<div class="panel radius-clear b animated bounceInDown">
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
						<td>${event.payer}</td>
					</tr>
					<tr>
						<td class="col-lg-3"><strong>Artist</strong></td>
						<td>${event.payee}</td>
					</tr>
					<tr>
						<td class="col-lg-3"><strong>Price</strong></td>
						<td><fmt:formatNumber value="${event.price}" type="currency" /></td>
					</tr>
				</tbody>
			</table>
				<c:if test="${currentUser.isPayer() && !event.isPaid()}">
					<a href="${pageContext.request.contextPath}/app/events/${event.id}/makePayment" class="btn btn-success btn-block btn-lg">Pay Now</a>
				</c:if>
				<c:if test="${currentUser.isPayee() && event.isPaid()}">
					<div class="col-lg-6">
						<a href="" class="btn btn-primary btn-block btn-lg">Split</a>
					</div>
					<div class="col-lg-6">
						<a href="" class="btn btn-primary btn-block btn-lg">Cash Out</a>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>

	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>