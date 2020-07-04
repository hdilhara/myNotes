<%@page import="com.hdilhara.edu.entity.Parent"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="./fragments/sidebar.jsp" %>
<%@ page isELIgnored="false" %>


    <div class="col-md-9 ">
    <!-- start of content  -->
		<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col"> Grade</th>
			      <th scope="col">Section</th>
			      <th scope="col">Year</th>
			    </tr>
			  </thead>
			  <tbody>
			
				<c:forEach var="class" items="${classes}" >
			<tr>
				<td>${class.grade}</td>
				<td>${class.section}</td>
				<td>${class.year}</td>
				<td><a href="${pageContext.request.contextPath}/classes/${class.classId}/enrolled/students"><button class="btn btn-success">add/view students</button></a></td>
			</tr>
			</c:forEach>
			</tbody>
      </table>
    <!-- end of content  -->

 </div>


<!-- add end section of page  -->
<%@ include file="./fragments/page-last.jsp" %>