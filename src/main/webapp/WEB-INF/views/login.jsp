<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/header.jsp" %>
<style>
div>label.invalid {
	transform: translateY(100%);
	font-size:x-small;
}
</style>
<div class="d-flex justify-content-center align-items-center">
<div class="container card-container col-md-6 col-xl-5 mb-4">

<!-- Card -->
<div class="card">

    <!-- Card body -->
    <div class="card-body">

        <!-- Material form register -->
        <form method="post" role="form" id="login">
            <p class="h4 text-center py-4">Login</p>

            <!-- Material input email -->
            <div class="md-form">
                <i class="fa fa-envelope prefix grey-text"></i>
                <label for="email" class="font-weight-light">Your email</label>
                <input type="email" id="email" name="email" class="form-control">
                <div id="email" class="text-info"></div>
            </div>

            <!-- Material input password -->
            <div class="md-form">
                <i class="fa fa-lock prefix grey-text"></i>
                <input type="password" id="password" name="password" class="form-control validate">
                <label for="password" class="font-weight-light" >Your password</label>
                 <div id="password" class="text-info"></div>
            </div>
            
            <div class="text-center py-4 mt-3">
                <button class="btn btn-cyan" type="submit">Login</button>
            </div>
        </form>
        <!-- Material form register -->

    </div>
    <!-- Card body -->

</div>
<!-- Card -->
</div>
</div>

<%@include file="includes/basicModal.jsp" %>
<%@include file="includes/footer.jsp" %>
<script>
	$(function(){
		if(${not empty error}) {
			$(".modal-title").html("로그인 실패")
			$("#errorModal").modal('show')
		}
	})
</script>
<!-- JQuery Validate -->
<!-- <script src="/resources/js/jquery.validate.js"></script>
<script src="/resources/js/register.validate.js"></script>
 -->