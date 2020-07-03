<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../fragments/sidebar.jsp"%>

<%@ page isELIgnored="false"%>

<!-- start of content  -->
<div class="col-md-9 ">
	<div class="users-top-nav">
		<a href="${pageContext.request.contextPath}/users/admins"><div
				class="users-top-nav-item" id="admins">
				<svg width="1em" height="1em" viewBox="0 0 16 16"
					class="bi bi-person users-top-nav-item-icon" fill="currentColor"
					xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
						d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
</svg>
				<br> ADMINS
			</div></a> <a href="${pageContext.request.contextPath}/users/teachers"><div
				class="users-top-nav-item users-top-nav-active" id="teachers">
				<svg width="1em" height="1em" viewBox="0 0 16 16"
					class="bi bi-person users-top-nav-item-icon" fill="currentColor"
					xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
						d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
</svg>
				<br> TEACHERS
			</div></a> <a href="${pageContext.request.contextPath}/users/students"><div
				class="users-top-nav-item">
				<svg width="1em" height="1em" viewBox="0 0 16 16"
					class="bi bi-person users-top-nav-item-icon" fill="currentColor"
					xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
						d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
</svg>
				<br> STUDENTS
			</div></a> <a href="${pageContext.request.contextPath}/users/parents"><div
				class="users-top-nav-item">
				<svg width="1em" height="1em" viewBox="0 0 16 16"
					class="bi bi-person users-top-nav-item-icon" fill="currentColor"
					xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd"
						d="M13 14s1 0 1-1-1-4-6-4-6 3-6 4 1 1 1 1h10zm-9.995-.944v-.002.002zM3.022 13h9.956a.274.274 0 0 0 .014-.002l.008-.002c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664a1.05 1.05 0 0 0 .022.004zm9.974.056v-.002.002zM8 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4zm3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
</svg>
				<br> PARENTS
			</div></a>
	</div>
	<hr>
	<!-- Add body of this user content -->

	<a href="${pageContext.request.contextPath}/users/add/teacher"><button
			class="btn btn-outline-dark teacher-manage-btn">ADD NEW
			TEACHER</button></a>



	<!-- loaded Teachers  -->
	<div class="student-load-results">
		<!-- add cards here  -->
		<!-- student card  -->
		<c:forEach var="teacher" items="${teachers}" varStatus="loop">
		
			<div class="card student-load-result" style="width: 175px;">

				<img src="data:image/png;base64, ${teacher.stringProfilePicture}"
					class="card-img-top" alt="...">

				<div class="card-body">
					<p class="card-text loaded-student-details">
						<b>${teacher.firstName}</b><br> ${teacher.lastName}<br>
						${teacher.dob}<br> section
					</p>
					<!-- Trigger Model Here -->
					<a href="${pageContext.request.contextPath}/users/teacher/${teacher.teacherId}/profile"><button type="button" class="btn btn-outline-dark std-manage-btn" >PROFILE</button></a>
				</div>
				
			</div>
		</c:forEach>
	</div>
	<!-- end of dynamic students -->

<!-- end of content  -->

</div>
<!--  End of div class col-md-9 -->


<!-- add end section of page  -->
<%@ include file="../fragments/page-last.jsp"%>
