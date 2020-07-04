<%@page import="com.hdilhara.edu.entity.Parent"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ include file="../../fragments/sidebar.jsp" %>
<%@ page isELIgnored="false" %>


    <div class="col-md-9 ">
    <!-- start of content  -->
    
    
    	<!-- Back to student page -->
	<a href="${pageContext.request.contextPath}/users/parents"><button type="button" class=" btn btn-secondary back-btn">
		<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-90deg-left" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
		  <path fill-rule="evenodd" d="M6.104 2.396a.5.5 0 0 1 0 .708L3.457 5.75l2.647 2.646a.5.5 0 1 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 0 1 .708 0z"/>
		  <path fill-rule="evenodd" d="M2.75 5.75a.5.5 0 0 1 .5-.5h6.5a2.5 2.5 0 0 1 2.5 2.5v5.5a.5.5 0 0 1-1 0v-5.5a1.5 1.5 0 0 0-1.5-1.5h-6.5a.5.5 0 0 1-.5-.5z"/>
		</svg>
	BACK</button></a>
    
    <div class="alert alert-success parent-profile-page">
	    <h3>Parent Details</h3>
	    <hr>
	    	<table>
	    		<tr><td>First Name: </td><td>${parent.firstName}</td></tr>
	    		<tr><td>Last Name: </td><td>${parent.lastName}</td></tr>
	    		<tr><td>Contact No: </td><td>${parent.contactNumber}</td></tr>
	    		<tr><td>Occupation: </td><td>${parent.occupation}</td></tr>
	    		<tr><td>Relationship: </td><td>${parent.relationship}</td></tr>
	    	</table>
	    <h3>Student Details</h3> 
	    <hr>
	    	<table>
	    		<tr><td>Roll No: </td><td>${student.studentId}</td></tr>
	    		<tr><td>First Name: </td><td>${student.firstName}</td></tr>
	    		<tr><td>Last Name: </td><td>${student.lastName}</td></tr>
	    		<tr><td>Date of Birth: </td><td>${student.dob}</td></tr>
	    		<tr><td>Address: </td><td>${student.address}</td></tr>
	    </table>
	    <br><br>
	    <a href="${pageContext.request.contextPath}/users/student/${student.studentId}/profile"><button type="button"  class="btn btn-primary std-manage-btn" >GOTO STUDENT PROFILE</button></a>
    </div>
    
    
    
    
    
    
    
    
      
    <!-- end of content  -->

 </div>


<!-- add end section of page  -->
<%@ include file="../../fragments/page-last.jsp" %>