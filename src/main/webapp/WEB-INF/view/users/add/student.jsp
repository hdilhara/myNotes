<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!--  Add student  -->

<%@ include file="../../fragments/page-top.jsp" %>
<%@ include file="../../fragments/sidebar.jsp" %>
		
		<div class="col-md-9">
		
		<div class="add-user-header">
        <svg style="margin-bottom: 11px;" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-plus-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm7.5-3a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
            <path fill-rule="evenodd" d="M13 7.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0v-2z"/>
          </svg>
        ADD NEW STUDENT</div>
        <hr>
        <div>
        	<form:form class="user-add-form" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/users/create/new/student" modelAttribute="student">
	            <div class="form-group ">
	              <label for="exampleInputEmail1">First Name</label>
	              <form:input path="firstName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
	             
	            </div>
	            <div class="form-group">
	              <label for="exampleInputPassword1">Last Name</label>
	              <form:input path="lastName" type="text" class="form-control" id="exampleInputPassword1"/>
	            </div>
	            <div class="form-group">
	                <label for="exampleInputPassword1">Date of birth</label>
	                <fmt:formatDate value="${yourObject.date}" var="dateString" pattern="dd/MM/yyyy" />
	                <form:input type="date" path="dob"  class="form-control" id="exampleInputPassword1" />
	            </div>
	            <div class="form-group">
	                <label for="">Address</label>
	                <fmt:formatDate value="${yourObject.date}" var="dateString" pattern="dd/MM/yyyy" />
	                <form:textarea path="address"  class="form-control" />
	            </div>
	            <div class="form-group">
	                <label for="exampleInputPassword1">Profile Picture</label>
	                <form:input path="profilePicture" type="file" class="form-control" id="exampleInputPassword1"/>
	                 <small class="form-text text-muted">Max size 2MB 1:1 image is refer </small>
	            </div>
	            <button type="submit" class="btn btn-primary">Submit</button>
          </form:form>
        </div>
        
</div>

<%@ include file="../../fragments/page-last.jsp" %>