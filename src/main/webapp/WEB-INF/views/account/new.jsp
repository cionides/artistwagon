<%@include file="/WEB-INF/views/layout/include.jspf"%>
<%@include file="/WEB-INF/views/layout/header.jspf"%>

<h3>Create New Account <small>Artist Wagon</small></h3>
<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
               <div class="panel-body">
                  <form method="get" action="/" class="form-horizontal">
                  	  <fieldset>
                  	    <legend>General Information</legend>
                        <div class="form-group">
                           <label class="col-sm-2 control-label">Type</label>
                           <div class="col-sm-10">
                              <div class="radio pb-sm">
                                 <label>
                                    <input id="typeRadiosNew" type="radio" 
                                    	name="typeRadios" value="new">New Group Account</label>
                              </div>
                              <div class="radio">
                                 <label>
                                    <input id="typeRadiosExisting" type="radio" 
                                    	name="typeRadios" value="existing">Existing Group Account</label>
                              </div>
                           </div>
                        </div>
                     </fieldset>
                     <div id="newGroupContainer" class="hidden">
                     	<fieldset>
                        <div class="form-group">
                           <label for="input-id-1" class="col-lg-2 control-label">Group Name</label>
                           <div class="col-lg-9">
                              <input id="input-id-1" type="text" class="form-control input-lg">
                           </div>
                        </div>
                     	</fieldset>
                     </div>
                     <div id="existingGroupContainer" class="hidden">
                     	<fieldset>
                        <div class="form-group">
                           <label for="input-id-1" class="col-lg-2 control-label">Select Group</label>
                           <div class="col-lg-9">
                              <select name="input-id-1" class="form-control input-lg">
                                 <option>Select Group...</option>
                                 <option>Cowboy Jukebox</option>
                                 <option>Adam's Artbox</option>
                              </select>
                           </div>
                        </div>
                     	</fieldset>
                     </div>
                   	 <button type="submit" class="btn btn-primary pull-right">Submit</button>
                  </form>
               </div>
            </div>
   </div>
</div>
	
<%@include file="/WEB-INF/views/layout/footer.jspf"%>

<script src="${pageContext.request.contextPath}/assets/app/js/custom/newAccount.js"></script>


