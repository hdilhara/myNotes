	<%@ include file="./fragments/sidebar.jsp" %>
	<%@ page isELIgnored="false" %>
	
    <!-- start of content  -->
    <div class="col-md-9 contents-body">
        <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active" data-interval="10000">
                <img src="/images/sch3.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item" data-interval="2000">
                <img src="/images/sch1.jpg" class="d-block w-100" alt="...">
              </div>
              <div class="carousel-item">
                <img src="/images/sch2.jpg" class="d-block w-100" alt="...">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <!-- counts  -->
          <div class="count ">
              <div class="counts  "> <span class="num" >4</span><br> ADMINS</div>
              <div class="counts  "> <span class="num" >4</span><br> TEACHERS</div>
              <div class="counts  "> <span class="num" >4</span><br> STUDENTS</div>
              <div class="counts  "> <span class="num" >4</span><br> PARENTS</div>   
          </div>
      
          <!-- noticeboard -->
          <div class="alert alert-success" role="alert">
              NOTICEBOARD
          </div>
          <div class="notices">
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="card-link">Card link</a>
                  <a href="#" class="card-link">Another link</a>
                </div>
              </div>
              <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">Card title</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                  <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                  <a href="#" class="card-link">Card link</a>
                  <a href="#" class="card-link">Another link</a>
                </div>
              </div>
          </div>
          

    </div>


  </div>

    <!-- end of content  -->
  <%@ include file="./fragments/page-last.jsp" %>