<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>My Groups <small>Artist Wagon</small></h3>
<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
        <div class="panel-body">
           <div class="table-responsive">
              <table class="table table-striped">
                 <thead>
                    <tr>
                       <th class="col-lg-6">Group Name</th>
                       <th class="col-lg-2">Role</th>
                       <th class="col-lg-2">Balance</th>
                       <th class="col-lg-2">Options</th>
                    </tr>
                 </thead>
                 <tbody>
                 <c:forEach items="${groups}" var="group">
   									<tr>
                       <td>${group.name}</td>
                       <td>Owner</td>
                       <td>$123</td>
                       <td><a href="${pageContext.request.contextPath}/groups/1" class="btn btn-primary">Open Snapshot</a>
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