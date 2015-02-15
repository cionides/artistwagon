<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>Add New Group <small>Cowboy Jukebox</small></h3>
<div class="row">
   <div class="col-lg-12">
    <div class="panel panel-default">
    	<div class="panel-body">
		   	<form:form method="POST" action="${pageContext.request.contextPath}/app/groups/create/save" class="form-horizontal">
		    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    	<fieldset>
		    	<legend>Group Information</legend>
			      <div class="form-group">
			          <form:label class="col-sm-2 control-label" path="name">Name</form:label>
			         <div class="col-sm-10">
			            <form:input path="name" class="form-control" type="text" autofocus="autofocus" />
			         </div>
			      </div>
		      </fieldset>
		      <button type="submit" class="btn btn-primary pull-right">Create Group</button>
				</form:form>
			</div>
		</div>
  </div>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>