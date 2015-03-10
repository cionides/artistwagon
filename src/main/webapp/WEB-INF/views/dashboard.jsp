<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>
	<div class="col-lg-12 clearfix p0">
	<span class="pull-left">${userBand[0].group.name} <a href="#">Change Band</a></span>
	<span class="pull-right">Balance: <fmt:formatNumber value="${userBand[0].balance}" type="currency" /> </span>
	</div>
	<small>Dashboard</small>
</h3>
<div class="row">
   <div class="col-lg-4 pl0">
	   <div class="panel panel-default panel-flat ba mb-xl radius-clear animated fadeInUp">
		   <div class="panel-heading">
		      <div class="panel-title">Active IOU's</div>
		   </div>
		       <!-- START list group-->
		       <div class="list-group">
					 <!-- START list group item-->
		          <div class="list-group-item">
		             <div class="media-box">
		                <div class="pull-left">
		                   <span class="fa-stack">
		                      <em class="fa fa-circle fa-stack-2x text-warning"></em>
		                      <em class="fa fa-tasks fa-stack-1x fa-inverse text-white"></em>
		                   </span>
		                </div>
		                <div class="media-box-body clearfix">
		                   <small class="text-muted pull-right ml">$78.00 / $120.00</small>
		                   <div class="media-box-heading"><a href="#" class="text-warning m0">Guitar Strings For Adam</a>
		                   </div>
		                   <div class="progress progress-xs m0">
		                      <div role="progressbar" aria-valuenow="68" aria-valuemin="0" aria-valuemax="100" style="width: 68%" class="progress-bar progress-bar-warning progress-bar-striped">
		                         <span class="sr-only">22% Complete</span>
		                      </div>
		                   </div>
		                </div>
		             </div>
		          </div>
		          <!-- END list group item-->
		          <!-- START list group item-->
		          <div class="list-group-item">
		             <div class="media-box">
		                <div class="pull-left">
		                   <span class="fa-stack">
		                      <em class="fa fa-circle fa-stack-2x text-info"></em>
		                      <em class="fa fa-tasks fa-stack-1x fa-inverse text-white"></em>
		                   </span>
		                </div>
		                <div class="media-box-body clearfix">
		                   <small class="text-muted pull-right ml">1w</small>
		                   <div class="media-box-heading"><a href="#" class="text-info m0">Doug's iPad Holder</a>
		                   </div>
		                   <div class="progress progress-xs m0">
		                      <div role="progressbar" aria-valuenow="36" aria-valuemin="0" aria-valuemax="100" style="width: 36%" class="progress-bar progress-bar-info progress-bar-striped">
		                         <span class="sr-only">22% Complete</span>
		                      </div>
		                   </div>
		                </div>
		             </div>
		          </div>
		          <!-- END list group item-->
		       </div>
		       <!-- END list group-->
		       <!-- START panel footer-->
		       <div class="panel-footer clearfix">
		          <a href="#" class="pull-right">
		             View All
		          </a>
		       </div>
		       <!-- END panel-footer-->
		    </div>
   </div>
      <div class="col-lg-8 pr0">
      <div class="panel panel-default panel-flat ba mb-xl radius-clear animated fadeInUp">
        <div class="panel-heading">
           <div class="panel-title">Latest activities</div>
        </div>
        <!-- START list group-->
        <div class="list-group">
           <!-- START list group item-->
           <div class="list-group-item">
              <div class="media-box">
                 <div class="pull-left">
                    <span class="fa-stack">
                       <em class="fa fa-circle fa-stack-2x"></em>
                       <em class="fa fa-cloud-upload fa-stack-1x fa-inverse text-white"></em>
                    </span>
                 </div>
                 <div class="media-box-body clearfix">
                    <small class="text-muted pull-right ml">15 Minutes Ago</small>
                    <div class="media-box-heading">ACTIVITY
                    </div>
                    <p class="m0">
                       <small>Member</small>
                    </p>
                 </div>
              </div>
           </div>
           <!-- END list group item-->
           <!-- START list group item-->
           <div class="list-group-item">
              <div class="media-box">
                 <div class="pull-left">
                    <span class="fa-stack">
                       <em class="fa fa-circle fa-stack-2x"></em>
                       <em class="fa fa-cloud-upload fa-stack-1x fa-inverse text-white"></em>
                    </span>
                 </div>
                 <div class="media-box-body clearfix">
                    <small class="text-muted pull-right ml">4 Hours Ago</small>
                    <div class="media-box-heading">ACTIVITY
                    </div>
                    <p class="m0">
                       <small>Member</small>
                    </p>
                 </div>
              </div>
           </div>
           <!-- END list group item-->
           <!-- START list group item-->
           <div class="list-group-item">
              <div class="media-box">
                 <div class="pull-left">
                    <span class="fa-stack">
                       <em class="fa fa-circle fa-stack-2x"></em>
                       <em class="fa fa-cloud-upload fa-stack-1x fa-inverse text-white"></em>
                    </span>
                 </div>
                 <div class="media-box-body clearfix">
                    <small class="text-muted pull-right ml">1 Day Ago</small>
                    <div class="media-box-heading">ACTIVITY
                    </div>
                    <p class="m0">
                       <small>Member</small>
                    </p>
                 </div>
              </div>
           </div>
           <!-- END list group item-->
					 <!-- START list group item-->
           <div class="list-group-item">
              <div class="media-box">
                 <div class="pull-left">
                    <span class="fa-stack">
                       <em class="fa fa-circle fa-stack-2x"></em>
                       <em class="fa fa-cloud-upload fa-stack-1x fa-inverse text-white"></em>
                    </span>
                 </div>
                 <div class="media-box-body clearfix">
                    <small class="text-muted pull-right ml">2 Days Ago</small>
                    <div class="media-box-heading">ACTIVITY
                    </div>
                    <p class="m0">
                       <small>Member</small>
                    </p>
                 </div>
              </div>
           </div>
           <!-- END list group item-->
        </div>
        <!-- END list group-->
        <!-- START panel footer-->
        <div class="panel-footer clearfix">
           <a href="#" class="pull-right">
              View All
           </a>
        </div>
        <!-- END panel-footer-->
     </div>
      <div class="panel panel-default panel-flat ba mb-xl radius-clear animated fadeInUp">
      	<div class="panel-heading">
      		<div class="panel-title">Recent Transactions</div>
      	</div>
        <div class="panel-body bb">
        		<div class="col-lg-1 text-muted">
        			<h4 class="m0">05</h4>
        			<h5 class="m0">NOV</h5>
        		</div>
        		<div class="col-lg-5">
        			<h4>Guitar Center</h4>
        		</div>
        		<div class="col-lg-2">
        			<h4>Debit</h4>
        		</div>
        		<div class="col-lg-2">
        				<h4><fmt:formatNumber value="123" type="currency" /></h4>
        			</h4>
        		</div>
        		<div class="col-lg-2">
							<h4>Pending</h4>
        		</div>
        	</div>
        	<div class="panel-body bb">
        		<div class="col-lg-1 text-muted">
        			<h4 class="m0">05</h4>
        			<h5 class="m0">NOV</h5>
        		</div>
        		<div class="col-lg-5">
        			<h4>Guitar Center</h4>
        		</div>
        		<div class="col-lg-2">
        			<h4>Debit</h4>
        		</div>
        		<div class="col-lg-2">
        				<h4><fmt:formatNumber value="123" type="currency" /></h4>
        			</h4>
        		</div>
        		<div class="col-lg-2">
							<h4>Pending</h4>
        		</div>
        	</div>
        	<div class="panel-body bb">
        		<div class="col-lg-1 text-muted">
        			<h4 class="m0">05</h4>
        			<h5 class="m0">NOV</h5>
        		</div>
        		<div class="col-lg-5">
        			<h4>Guitar Center</h4>
        		</div>
        		<div class="col-lg-2">
        			<h4>Debit</h4>
        		</div>
        		<div class="col-lg-2">
        				<h4><fmt:formatNumber value="123" type="currency" /></h4>
        			</h4>
        		</div>
        		<div class="col-lg-2">
							<h4>Pending</h4>
        		</div>
        	</div>
        <div class="panel-footer clearfix">
	        <a href="${pageContext.request.contextPath}/bank/bands/${userBand[0].id}/transactions" class="pull-right">
	           View All
	        </a>
        </div>
     </div>
   </div>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>