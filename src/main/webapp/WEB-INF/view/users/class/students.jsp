<%@page import="com.hdilhara.edu.entity.Parent"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../../fragments/sidebar.jsp" %>
<%@ page isELIgnored="false" %>


    <div class="col-md-9 ">
    <!-- start of content  -->
    
    
    	<!-- Back to student page -->
	<a href="${pageContext.request.contextPath}/classes"><button type="button" class=" btn btn-secondary back-btn">
		<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-90deg-left" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
		  <path fill-rule="evenodd" d="M6.104 2.396a.5.5 0 0 1 0 .708L3.457 5.75l2.647 2.646a.5.5 0 1 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 0 1 .708 0z"/>
		  <path fill-rule="evenodd" d="M2.75 5.75a.5.5 0 0 1 .5-.5h6.5a2.5 2.5 0 0 1 2.5 2.5v5.5a.5.5 0 0 1-1 0v-5.5a1.5 1.5 0 0 0-1.5-1.5h-6.5a.5.5 0 0 1-.5-.5z"/>
		</svg>
	BACK</button></a>
	
	
	
	<h3><b>${class.year} </b> CLASS: ${class.grade} - ${class.section}  </h3>
	
			<h5>ENROLL A NEW STUDENT</h5> 
		    <%if(request.getAttribute("e")=="error"){ %>
		    	You have entered invalid enroll no...
		    <%} %>
	<form action="${pageContext.request.contextPath}/classes/${class.classId}/add/student" >
		<label>Student Roll No:</label>
		<input type="number" name="studentRollNo" >
		<button type="submit">Enroll</button>
	</form>
	
	<h5>ENROLLED STUDENTS</h5> 
	
	<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">RollNo</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="student" items="${students}" >
    <tr>
      <td>${student.studentId}</td>
      <td>${student.firstName}</td>
      <td>${student.lastName}</td>
      <td><a href="${pageContext.request.contextPath}/classes/${class.classId}/${student.studentId}/unenroll/student"><button class="btn btn-danger">UNENROLL</button></a></td>
    </tr>
	</c:forEach>
  </tbody>
</table>
	
		 
	

	
	
	
	
	
	
	
	
	    <!-- end of content  -->

 </div>


<!-- add end section of page  -->
<%@ include file="../../fragments/page-last.jsp" %>