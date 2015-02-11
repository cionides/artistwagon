<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>Snapshot <small>Cowboy Jukebox</small></h3>
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
                    	 <th>User</th>
                       <th>Type</th>
                       <th>Description</th>
                       <th>Amount</th>
                       <th>Status</th>
                    </tr>
                 </thead>
                 <tbody>
                    <tr>
                       <td>01/30/2015</td>
                       <td>Adam Michaels</td>
                       <td>Debit</td>
                       <td>Guitar Center - 123 Main St</td>
                       <td>$42.53</td>
                       <td>Approved</td>
                    </tr>
                    <tr>
                       <td>01/30/2015</td>
                       <td>Adam Michaels</td>
                       <td>Debit</td>
                       <td>Guitar Center - 123 Main St</td>
                       <td>$42.53</td>
                       <td>Approved</td>
                    </tr>
                       <td>01/30/2015</td>
                       <td>Adam Michaels</td>
                       <td>Debit</td>
                       <td>Guitar Center - 123 Main St</td>
                       <td>$42.53</td>
                       <td>Approved</td>
                    </tr>
                       <td>01/30/2015</td>
                       <td>Adam Michaels</td>
                       <td>Debit</td>
                       <td>Guitar Center - 123 Main St</td>
                       <td>$42.53</td>
                       <td>Approved</td>
                    </tr>
                       <td>01/30/2015</td>
                       <td>Adam Michaels</td>
                       <td>Debit</td>
                       <td>Guitar Center - 123 Main St</td>
                       <td>$42.53</td>
                       <td>Approved</td>
                    </tr>
                 </tbody>
              </table>
           </div>
        </div>
        <div class="panel-footer">
        	<div class="row">
        		<div class="col-lg-9"></div>
          	<div class="col-lg-3">
          		<a href="${pageContext.request.contextPath}/groups/1/transactions" class="btn btn-primary btn-block">All Transactions</a>
            </div>
        	</div>
     		</div>
     </div>	
   </div>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>