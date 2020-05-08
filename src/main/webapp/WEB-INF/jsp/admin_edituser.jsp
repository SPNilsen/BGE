<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="/WEB-INF/jsp/main_header.jsp" />
<div class="bcrumbwpr">					
    <div class="breadcrumbs">
        <img src="${pageContext.servletContext.contextPath}/static/images/home-icon.png">
        <a href="${pageContext.servletContext.contextPath}/">Home</a>
        <span class="default">&gt;</span><a href="${pageContext.servletContext.contextPath}/admin">Admin</a>
        <span class="default">&gt;</span><a href="${pageContext.servletContext.contextPath}/admin/EditUser">Edit User</a>
    </div>
</div>

<!--Main Content-->
<div id="PageHeading">
    <h1></h1>
</div>
<div class="block"></div>
<div>
    <div class="pageMsg">${pageMsg}</div>
    <hr />
    <h1>User Settings</h1>

    <form action="${pageContext.servletContext.contextPath}/admin/EditUser" 
          method="POST" 
          autocomplete ="false"
          modelAttribute="globalSettings">
        <table>
            <tr>
                <td>User Name</td><td>Password</td><td>Enabled</td>
            </tr>
            <tr>
                <td>
                    <input name="username" type="text" placeholder="Username" value="${user.username}">
                </td>
                <td>
                    <input name="password" type="password" placeholder="Password" value="${user.password}">
                </td>
                <td>
                    <c:choose>
                        <c:when test="${user.enabled}">
                            <input name="enabled" type="checkbox" checked />
                        </c:when>
                        <c:otherwise>
                            <input name="enabled" type="checkbox" />
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
        <p  class='marginMedium'></p>
        <input type="submit" value="Update User" name = "userUpdate"/>
    </form>
    <hr />
</div>

<!--End Main Content-->
<jsp:include page="/WEB-INF/jsp/main_footer.jsp" />