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
				<c:if test="${currentUser.isPayer() }">
					<a href="" class="btn btn-success btn-block btn-lg">Pay Now</a>
				</c:if>
				<c:if test="${currentUser.isPayee() }">
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