<%@page import="com.hdilhara.edu.entity.Parent"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ include file="../../fragments/sidebar.jsp" %>
<%@ page isELIgnored="false" %>


    <div class="col-md-9 ">
    <!-- start of content  -->
    
    



    <img src="data:image/png;base64, ${student.stringProfilePicture}" class="card-img-top model-card-img-top" alt="Plaease Add Profile Picture">
			        <form class="user-add-form" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/users/updated/student" >
				           <div  class="id-read-only"><b>Roll No</b>
				           		<input type="text" name="studentId" value="${student.studentId}" readonly> 
				           </div>
				           
				             <div class="form-group ">
				              <label for="exampleInputEmail1">First Name</label>
				            <input name="firstName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${student.firstName}"/>
				             
				         </div>
				             <div class="form-group">
				              <label for="exampleInputPassword1">Last Name</label>
				              <input value="${student.lastName}" name="lastName" type="text" class="form-control" id="exampleInputPassword1"/>
				            </div>
				             <div class="form-group">
				                <label for="exampleInputPassword1">Date of birth</label>
				                <input value="${student.dob}" type="date" name="dob"  class="form-control" id="exampleInputPassword1"/>
				            </div>

				           <div class="form-group">
				                <label for="">Address</label>
				                <textarea  name="address"  class="form-control" >${student.address}</textarea>
				            </div>
				            <div class="form-group">
				                <label for="exampleInputPassword1">Profile Picture</label>
				                <input name="profilePicture" type="file" class="form-control" id="exampleInputPassword1"/>
				                 <small class="form-text text-muted">Max size 2MB 1:1 image is refer </small>
				            </div>
				            <button type="submit" class="btn btn-primary update-delete-btn">Update</button>
			          </form>
			          <form method="post" action="${pageContext.request.contextPath}/users/deleted/student">
			          	<input type="text" name="studentId" value="${student.studentId}" hidden> 
			          	<button type="submit" class="btn btn-danger update-delete-btn">Delete</button>
			          </form>
    <!-- Parent Details -->
    				<h4 style="text-align: center; margin-top:10px; background-color: blue;    background-color: indigo; color: white; padding: 10px;">Parent Details</h4>
    				<form  action=
    					<% if(request.getAttribute("parent")!= null) { %>
    					 "${pageContext.request.contextPath}/users/update/${student.studentId}/parent"
    				 	<% }else{ %>
    						"${pageContext.request.contextPath}/users/create/${student.studentId}/parent"
    					<%} %>
    					 method="post" class="user-add-form" >
			    		<div class="form-group">
						    <label for="">First Name</label>
						    <input name="firstName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${parent.firstName}" >
						  </div>
						  <div class="form-group">
						    <label for="">Last Name</label>
						    <input name="lastName" type="text" class="form-control" id="exampleInputPassword1" value="${parent.lastName}">
						  </div>
						  <div class="form-group">
						    <label for="">Occupation</label>
						    <input name="occupation" type="text" class="form-control" id="exampleInputPassword1" value="${parent.occupation}" >
						  </div>
						  <div class="form-group">
						    <label for="">Relation to student :</label>
						    <select name="relationship">
						    	<option value="Mother">Mother</option>
						    	<option value="Father">Father</option>
						    	<option value="Other">Other</option>
						    </select>
						  </div>
						  <div class="form-group">
						    <label for="">Contact No</label>
						    <input name="contactNumber" type="number" class="form-control" id="exampleInputPassword1" required value="${parent.contactNumber}">
						  </div>
    					<% if(request.getAttribute("parent")!= null) { %>
    						<button type="submit" class="btn btn-primary update-delete-btn">Update</button>
    					<% }else{ %>
    						<button type="submit" class="btn btn-primary update-delete-btn">Add Parent</button>
    					<%} %>
    				</form>
    
    
    
    
    
    <!-- end of content  -->

 </div>


<!-- add end section of page  -->
<%@ include file="../../fragments/page-last.jsp" %>