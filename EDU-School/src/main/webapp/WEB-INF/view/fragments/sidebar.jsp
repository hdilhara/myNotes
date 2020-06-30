<%@ include file="./page-top.jsp" %>
    <div class="row">
    <div class="col-md-3 side-bar">

        <div class="head-item">
            <img class="logo" src="${pageContext.request.contextPath}/resources/images/logo.png" alt="">
            <img class="user" src="${pageContext.request.contextPath}/resources/images/profile-img.png" >
            <h6>name</h6>
            <p>role</p>

        </div>
        <div class="list-group">
              <a href="${pageContext.request.contextPath}/dashboard/" class="list-group-item list-group-item-action">
                <svg class="bi bi-house-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M8 3.293l6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
                  <path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
                </svg>
                Dashboard
              </a>
            <a href="${pageContext.request.contextPath}/users/" class="list-group-item list-group-item-action">
                <svg class="bi bi-person-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                </svg>
                Users
            </a>
            <a href="${pageContext.request.contextPath}/attendence/" class="list-group-item list-group-item-action">
                <svg class="bi bi-table" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path fill-rule="evenodd" d="M14 1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                    <path fill-rule="evenodd" d="M15 4H1V3h14v1z"/>
                    <path fill-rule="evenodd" d="M5 15.5v-14h1v14H5zm5 0v-14h1v14h-1z"/>
                    <path fill-rule="evenodd" d="M15 8H1V7h14v1zm0 4H1v-1h14v1z"/>
                    <path d="M0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v2H0V2z"/>
                </svg>
                Attendence
            </a>
            <a href="${pageContext.request.contextPath}/marks/" class="list-group-item list-group-item-action">
                <svg class="bi bi-pie-chart-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                    <path d="M15.985 8.5H8.207l-5.5 5.5a8 8 0 0 0 13.277-5.5zM2 13.292A8 8 0 0 1 7.5.015v7.778l-5.5 5.5zM8.5.015V7.5h7.485A8.001 8.001 0 0 0 8.5.015z"/>
                </svg>
                Marks
            </a>    
            <a href="${pageContext.request.contextPath}/notice-board/" class="list-group-item list-group-item-action">
                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-earmark-ruled-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
				 <path fill-rule="evenodd" d="M2 3a2 2 0 0 1 2-2h5.293a1 1 0 0 1 .707.293L13.707 5a1 1 0 0 1 .293.707V13a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3zm7 2V2l4 4h-3a1 1 0 0 1-1-1zM3 8v1h2v2H3v1h2v2h1v-2h7v-1H6V9h7V8H3z"/>
				</svg>
                Notice-Board
            </a> 
        </div>

    </div>
    <!-- end of side-bar  -->