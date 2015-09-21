<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="/WEB-INF/jsp/main_header.jsp" />
<div class="bcrumbwpr">					
    <div class="breadcrumbs">
        <img src="${pageContext.servletContext.contextPath}/static/images/home-icon.png"><a href="${pageContext.servletContext.contextPath}/">Home</a>
        <span class="default">&gt;</span><a href="${pageContext.servletContext.contextPath}/Allocation">Call Allocation</a>
    </div>
</div>

<!--Main Content-->
<div id="PageHeading">
    <h1></h1>
</div>
<div class="block"></div>
<div>

    <hr />
    <h1>Update</h1>

    <div class="pageMsg">${pageMsg}</div>


</div>

<!--End Main Content-->
<jsp:include page="/WEB-INF/jsp/main_footer.jsp" />