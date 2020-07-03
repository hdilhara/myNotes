<%@ include file="../../fragments/sidebar.jsp" %>
<%@ page isELIgnored="false" %>


    <div class="col-md-9 ">
    <!-- start of content  -->
    
    
    
    
    
    <img src="data:image/png;base64, ${teacher.stringProfilePicture}" class="card-img-top model-card-img-top" alt="Plaease Add Profile Picture">
					  <form class="user-add-form" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/users/updated/teacher" >
							 <div  class="id-read-only"><b>Roll No</b>
									 <input type="text" name="teacherID" value="${teacher.teacherId}" readonly> 
							 </div>
							  <div class="form-group ">
								<label for="exampleInputEmail1">First Name</label>
							  <input name="firstName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="${teacher.firstName}"/>
							   
						   </div>
								<div class="form-group">
								<label for="exampleInputPassword1">Last Name</label>
								<input value="${teacher.lastName}" name="lastName" type="text" class="form-control" id="exampleInputPassword1"/>
							  </div>
								<div class="form-group">
								  <label for="exampleInputPassword1">Date of birth</label>
								  <input value="${teacher.dob}" type="date" name="dob"  class="form-control" id="exampleInputPassword1"/>
							  </div>
							  <div class="form-group">
								  <label for="">Contact No</label>
								  <input type="text" value="${teacher.contactNumber}" name="contactNumber"  class="form-control" />
							  </div>
							 <div class="form-group">
								  <label for="">Address</label>
								  <textarea  name="address"  class="form-control" >${teacher.address}</textarea>
							  </div>
							  <div class="form-group">
								  <label for="exampleInputPassword1">Profile Picture</label>
								  <input name="profilePicture" type="file" class="form-control" id="exampleInputPassword1"/>
								   <small class="form-text text-muted">Max size 2MB 1:1 image is refer </small>
							  </div>
							  <button type="submit" class="btn btn-primary update-delete-btn">Update</button>
							
						</form>
						  <form method="post" action="${pageContext.request.contextPath}/users/deleted/teacher">
						   <input type="text" name="teacherId" value="${teacher.teacherId}" hidden/> 
						   <button type="submit" class="btn btn-danger update-delete-btn">Delete</button>
					   </form>
    
    
    
    
    
      
    <!-- end of content  -->

 </div>


<!-- add end section of page  -->
<%@ include file="../../fragments/page-last.jsp" %>