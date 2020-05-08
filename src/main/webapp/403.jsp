<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/main_header.jsp" />
    <H1>Oops! You are not authorized!</H1>
        <p><a href="<c:url value='/login'/>">Back to Login</a></p>
<jsp:include page="/WEB-INF/jsp/main_footer.jsp" />