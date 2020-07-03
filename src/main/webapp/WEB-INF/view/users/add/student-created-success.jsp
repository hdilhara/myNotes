<!--  Add student  -->

<%@ include file="../../fragments/page-top.jsp" %>
<%@ include file="../../fragments/sidebar.jsp" %>
		
		<div class="col-md-9">
		
		
		
		
		
		
		
		
		
		
		
	<!-- Back to student page -->
	<a href="${pageContext.request.contextPath}/users/students"><button type="button" class=" btn btn-secondary back-btn">
		<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-90deg-left" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
		  <path fill-rule="evenodd" d="M6.104 2.396a.5.5 0 0 1 0 .708L3.457 5.75l2.647 2.646a.5.5 0 1 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 0 1 .708 0z"/>
		  <path fill-rule="evenodd" d="M2.75 5.75a.5.5 0 0 1 .5-.5h6.5a2.5 2.5 0 0 1 2.5 2.5v5.5a.5.5 0 0 1-1 0v-5.5a1.5 1.5 0 0 0-1.5-1.5h-6.5a.5.5 0 0 1-.5-.5z"/>
		</svg>
	BACK</button></a>
	
	
	<div class="alert alert-success" role="alert">
	  <h4 class="alert-heading">Well done!</h4>
	  <p>New Student Created Successfully!, the new student details as follows.</p>
	  <hr>
	  <p class="mb-0">
	  <!-- Add Stdent Details -->
	  	<table style="font-size: 18px;">
	  		<tr>
	  			<td>First Name:</td>
	  			<td>${student.firstName}</td>
	  		</tr>
	  		<tr>
	  			<td>Last Name:</td>
	  			<td>${student.lastName}</td>
	  		</tr>
	  		<tr>
	  			<td>Date of Birth:</td>
	  			<td>${student.dob}</td>
	  		</tr>
	  		<tr>
	  			<td>Addresse:</td>
	  			<td>${student.address}</td>
	  		</tr>
	  
	 	</table>	  
	 	<h3 style="text-align: center;">Please Add Parent Details</h3>    
	 	
	 		<!-- Parent Details -->
		 
        <form action="${pageContext.request.contextPath}/users/create/${student.studentId}/parent" method="post">
			  <div class="form-group">
			    <label for="">First Name</label>
			    <input name="firstName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
			  </div>
			  <div class="form-group">
			    <label for="">Last Name</label>
			    <input name="lastName" type="text" class="form-control" id="exampleInputPassword1">
			  </div>
			  <div class="form-group">
			    <label for="">Occupation</label>
			    <input name="occupation" type="text" class="form-control" id="exampleInputPassword1">
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
			    <input name="contactNumber" type="number" class="form-control" id="exampleInputPassword1" required>
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
        </form>
	  </p>
	</div>
	


        
        
        
              
        
        
        
        
        
        
		</div>

<%@ include file="../../fragments/page-last.jsp" %>