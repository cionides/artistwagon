<%@include file="/WEB-INF/views/layout/include.jspf"%>
<!DOCTYPE html>
<html lang="en">

<head>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
   <meta name="description" content="Bootstrap Admin App + jQuery">
   <meta name="keywords" content="app, responsive, jquery, bootstrap, dashboard, admin">
   <title>Artist Wagon</title>
   <!-- =============== VENDOR STYLES ===============-->
   <!-- FONT AWESOME-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/font-awesome.min.css">
   <!-- SIMPLE LINE ICONS-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/simple-line-icons/css/simple-line-icons.css">
   <!-- ANIMATE.CSS-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/animate.css/animate.min.css">
   <!-- WHIRL (spinners)-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/vendor/whirl/dist/whirl.css">
   <!-- =============== PAGE VENDOR STYLES ===============-->
   <!-- =============== APP STYLES ===============-->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/app/css/app.css" id="maincss">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/custom/css/styles.css">
</head>

<body id="registerPage">
	<div class="container">				
			<form class="col-lg-8 col-lg-offset-2" role="form">
				<div id="step1Panel" class="panel registration-panel radius-clear b animated">
					<div class="panel-heading text-center">
						<h1>Lets Get Started</h1>
						<h5>Please enter an email and password.</h5>
					</div>
					<div class="panel-body">
			      <div class="form-group col-lg-12">
				      <label>Email address</label>
				      <input type="email" placeholder="Enter email" class="form-control input-lg radius-clear" autofocus="autofocus">
			      </div>
			      <div class="form-group col-lg-6">
				      <label>Password</label>
				      <input type="password" placeholder="Password" class="form-control input-lg radius-clear">
			      </div>
			      <div class="form-group col-lg-6">
				      <label>Reenter Password</label>
				      <input type="password" placeholder="Password" class="form-control input-lg radius-clear">
			      </div>
			      <div class="col-lg-12">
			      	<div class="pull-left">
			      		<h4>Step 1 of 5</h4>
			      	</div>
			      	<button id="goToStep2" type="button" class="btn btn-lg btn-primary pull-right">Next Step</button>
			      </div>
					</div>
				</div>
				<div id="step2Panel" class="panel registration-panel radius-clear b animated bounceInRight hidden">
					<div class="panel-heading text-center">
						<h1>Verify Your Identity</h1>
						<h5>Just need to make sure you are who you say you are.</h5>
					</div>
					<div class="panel-body">
						<div class="form-group col-lg-6">
				      <label>First Name</label>
				      <input type="text" id="firstName" placeholder="First Name" class="form-control input-lg radius-clear">
			      </div>
			      <div class="form-group col-lg-6">
				      <label>Last Name</label>
				      <input type="text" placeholder="Last Name" class="form-control input-lg radius-clear">
			      </div>
			      <div class="form-group col-lg-12">
				      <label>Address</label>
				      <input type="text" placeholder="Address" class="form-control input-lg radius-clear">
			      </div>
			      <div class="form-group col-lg-5">
				      <label>City</label>
				      <input type="text" placeholder="City" class="form-control input-lg radius-clear">
			      </div>
			      <div class="form-group col-lg-2 col-lg-offset-1">
				      <label>State</label>
				      <select class="form-control input-lg radius-clear">
				      	<option value =""></option>
				     	</select>
			      </div>
			      <div class="form-group col-lg-3 col-lg-offset-1">
				      <label>Zip Code</label>
				      <input type="text" placeholder="Zip Code" class="form-control input-lg radius-clear">
			      </div>
			      <div class="form-group col-lg-6">
				      <label>Date Of Birth</label>
				      <input type="text" placeholder="Date Of Birth" class="form-control input-lg radius-clear">
			      </div>
			      <div class="form-group col-lg-6">
				      <label>SSN</label>
				      <input type="text" placeholder="Social Security Number" class="form-control input-lg radius-clear">
			      </div>
			      <div class="col-lg-12">
			      	<div class="pull-left">
			      		<h4>Step 2 of 5</h4>
			      	</div>
			      	<button id="goToStep3" type="button" class="btn btn-lg btn-primary pull-right">Next Step</button>
			      </div>
					</div>
				</div>
				<div id="step3Panel" class="panel registration-panel radius-clear b animated bounceInRight hidden">
					<div class="panel-heading text-center">
						<h1>Debit Card</h1>
						<h5>By ordering an Artist Wagon debit card you will have access to your funds almost immediately.</h5>
					</div>
					<div class="panel-body">
						<div class="form-group col-lg-12">
				      <label>Would you like a debit card linked to your account?</label>
				      <div class="radio">
							  <label>
							    <input type="radio" name="optionsRadios" id="optionsRadios1" value="yes">
							    	Yes
							  </label>
							</div>
							<div class="radio">
							  <label>
							    <input type="radio" name="optionsRadios" id="optionsRadios2" value="no">
							    	No
							  </label>
							</div>
			      </div>
			      <div class="col-lg-12">
			      	<div class="pull-left">
			      		<h4>Step 3 of 5</h4>
			      	</div>
			      	<button id="goToStep4" type="button" class="btn btn-lg btn-primary pull-right">Next Step</button>
			      </div>
					</div>
				</div>
				<div id="step4Panel" class="panel registration-panel radius-clear b animated bounceInRight hidden">
					<div class="panel-heading text-center">
						<h1>Link External Account</h1>
						<h5>Linking an external account allows you to transfer money to and from your account with ease.</h5>
					</div>
					<div class="panel-body">
						<div class="form-group col-lg-6">
				      <label>Routing Number</label>
				      <input id="routingNumber" type="text" placeholder="Routing Number" class="form-control input-lg radius-clear">
			      </div>
			      <div class="form-group col-lg-6">
				      <label>Account Number</label>
				      <input type="text" placeholder="Account Number" class="form-control input-lg radius-clear">
			      </div>
			      <div class="form-group col-lg-12">
			      	<label>Account Type?</label>
			      	<div class="radio">
							  <label>
							    <input type="radio" name="checkingOrSaving" id="optionsRadios1" value="yes">
							    	Checking
							  </label>
							</div>
							<div class="radio">
							  <label>
							    <input type="radio" name="checkingOrSaving" id="optionsRadios2" value="no">
							    	Savings
							  </label>
							</div>
			      </div>
			      <div class="col-lg-12">
			      	<div class="pull-left">
			      		<h4>Step 4 of 5</h4>
			      	</div>
			      	<button id="goToStep5" type="button" class="btn btn-lg btn-primary pull-right">Next Step</button>
			      </div>
					</div>
				</div>
				<div id="step5Panel" class="panel registration-panel radius-clear b animated bounceInRight hidden">
					<div class="panel-heading text-center">
						<h1>Band Information</h1>
						<h5>Information about your band.</h5>
					</div>
					<div class="panel-body">
						<div class="form-group col-lg-12">
				      <label>Band Name</label>
				      <input id="bandName" type="text" placeholder="Band Name" class="form-control input-lg radius-clear">
			      </div>
			      <div class="col-lg-12">
			      	<div class="pull-left">
			      		<h4>Step 5 of 5</h4>
			      	</div>
			      	<button type=submit class="btn btn-lg btn-primary pull-right">Submit</button>
			      </div>
					</div>
				</div>
			</form>
	</div>


   <!-- =============== VENDOR SCRIPTS ===============-->
   <!-- MODERNIZR-->
   <script src="${pageContext.request.contextPath}/assets/vendor/modernizr/modernizr.js"></script>
   <!-- JQUERY-->
   <script src="${pageContext.request.contextPath}/assets/vendor/jquery/dist/jquery.js"></script>
   <!-- BOOTSTRAP-->
   <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/dist/js/bootstrap.js"></script>
   <!-- STORAGE API-->
   <script src="${pageContext.request.contextPath}/assets/vendor/jQuery-Storage-API/jquery.storageapi.js"></script>
   <!-- JQUERY EASING-->
   <script src="${pageContext.request.contextPath}/assets/vendor/jquery.easing/js/jquery.easing.js"></script>
   <!-- ANIMO-->
   <script src="${pageContext.request.contextPath}/assets/vendor/animo.js/animo.js"></script>
   <!-- SLIMSCROLL-->
   <script src="${pageContext.request.contextPath}/assets/vendor/slimScroll/jquery.slimscroll.min.js"></script>
   <!-- SCREENFULL-->
   <script src="${pageContext.request.contextPath}/assets/vendor/screenfull/dist/screenfull.min.js"></script>
   <!-- LOCALIZE-->
   <script src="${pageContext.request.contextPath}/assets/vendor/jquery-localize-i18n/dist/jquery.localize.js"></script>

   <!-- =============== PAGE VENDOR SCRIPTS ===============-->
   <!-- =============== APP SCRIPTS ===============-->
   <script src="${pageContext.request.contextPath}/assets/app/js/app.js"></script>
   <script src="${pageContext.request.contextPath}/assets/custom/js/registration.js"></script>
</body>

</html>
