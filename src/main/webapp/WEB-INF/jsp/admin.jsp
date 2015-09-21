<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="/WEB-INF/jsp/main_header.jsp" />
<div class="bcrumbwpr">					
    <div class="breadcrumbs">
        <img src="${pageContext.servletContext.contextPath}/static/images/home-icon.png">
        <a href="${pageContext.servletContext.contextPath}/">Home</a>
        <span class="default">&gt;</span><a href="${pageContext.servletContext.contextPath}/admin">Admin</a>
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

    <form action="${pageContext.servletContext.contextPath}/admin/AddUser" 
          method="POST"
          autocomplete ="false"
          modelAttribute="globalSettings">
        <table>
            <tr>
                <td>User Name</td><td>Password</td><td>Enabled</td>
            </tr>
            <tr>
                <td>
                    <input type="text" name="prevent_autofill" id="prevent_autofill" value="" style="display:none;" />
                    <input type="password" name="password_fake" id="password_fake" value="" style="display:none;" />
                    <input name="username" type="text" placeholder="Username" value="" autocomplete ="false">
                </td>
                <td>
                    <input name="password" type="password" placeholder="Password" value="" autocomplete ="false">
                </td>
                <td>
                    <input name="enabled" type="checkbox" autocomplete ="false">
                </td>
            </tr>
        </table>
        <p  class='marginMedium'></p>
        <input type="submit" value="Add User" />
    </form>
    <hr />
    <div class='inter2clmrightin'>
        <h1>User List</h1>
        <table>
            <tr>
                <td>User Name</td><td>Password</td><td>Enabled</td>
            </tr>
            <c:forEach var="user" items="${userList}">
                <form action="${pageContext.servletContext.contextPath}/admin/EditUser" method ="POST">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>
                            <c:choose>
                                <c:when test="${user.enabled}">
                                    <input type="checkbox" checked disabled="disabled=" />
                                </c:when>
                                <c:otherwise>
                                    <input type="checkbox"  disabled="disabled=" />
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <input type="submit" value ="Edit" name="userEdit" class="buttonLink"> | <input type="submit" value ="Delete" name="userDelete" class="buttonLink">
                            <input type="hidden" value="${user.username}" name="username" />
                        </td>
                    </tr>
                </form>
            </c:forEach>
        </table>
    </div>
</div>

<!--End Main Content-->
<jsp:include page="/WEB-INF/jsp/main_footer.jsp" />