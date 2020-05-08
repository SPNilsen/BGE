<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="/WEB-INF/jsp/main_header.jsp" />
<div class="bcrumbwpr">					
    <div class="breadcrumbs">
        <img src="${pageContext.servletContext.contextPath}/static/images/home-icon.png"><a href="${pageContext.servletContext.contextPath}/">Home</a>
        <span class="default">&gt;</span>Call Allocation
    </div>
</div>

<!--Main Content-->
<div id="PageHeading">
</div>
<div class="block"></div>
<div>
    <div class="pageMsg">${pageMsg}</div>
    <hr />
    <h1>Global Settings</h1>

    <form action="${pageContext.servletContext.contextPath}/Allocation/Global" method="POST" modelAttribute="globalSettings">
        <table>
            <tr>
                <td>Emergency</td>
                <td>
                    <c:choose>
                        <c:when test="${globalFlag.emergency}">
                            <input name='emergency' type='checkbox' checked>
                        </c:when>
                        <c:otherwise>
                            <input name='emergency' type='checkbox'>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr><td>Weather</td>
                <td>
                    <c:choose>
                        <c:when test="${globalFlag.weather}">
                            <input name='weather' type='checkbox' checked>
                        </c:when>
                        <c:otherwise>
                            <input name='weather' type='checkbox'>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
        <input type="hidden" name="id" value="${globalFlag.id}">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <p  class='marginMedium'><input type="submit" value="Change Global Settings" /></p>
    </form>
    <hr />
    <div class='inter2clmrightin'>
        <h1>Order Entry</h1>
        <form action="${pageContext.servletContext.contextPath}/Allocation/OE" method="POST" modelAttribute="oeAllocation">
            <table class="allocTable">
                <tr>
                    <td>Force Open</td>
                    <td>
                        <c:choose>
                            <c:when test="${oeAllocation.force_open}">
                                <input name='force_open' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='force_open' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr><td>Force Closed</td>
                    <td>
                        <c:choose>
                            <c:when test="${oeAllocation.force_close}">
                                <input name='force_close' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='force_close' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr><td>Meeting</td>
                    <td>
                        <c:choose>
                            <c:when test="${oeAllocation.meeting}">
                                <input name='meeting' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='meeting' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td>Overflow Call Volume</td>
                    <td>
                        <select name='overflow'>
                            <c:forEach var="i" begin="0" end="100" step="5">
                                <c:choose>
                                    <c:when test="${i == oeAllocation.overflow}">
                                        <option value="${i}" selected><c:out value="${i}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${i}"><c:out value="${i}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>TBPO Call Volume</td>
                    <td>
                        <select name='overflow2' id="oeOverflow2">
                            <c:forEach var="i" begin="0" end="100" step="5">
                                <c:choose>
                                    <c:when test="${i == oeAllocation.overflow2}">
                                        <option value="${i}" selected><c:out value="${i}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${i}"><c:out value="${i}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>ITEL Call Volume</td>
                    <td id="oeITEL"> <c:out value="${100 - oeAllocation.overflow2}" /></td>
                </tr>
            </table>
            <p  class='marginMedium'><input type="submit" value=" Change OE "></p>
            <input type="hidden" name="product" value="${oeAllocation.product}"/>
            <input type="hidden" name="product_name" value="${oeAllocation.product_name}"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
        
<!--    <div class='inter2clmrightin'>
        <h1>Order Status</h1>
        <form action="${pageContext.servletContext.contextPath}/Allocation/OS" method="POST" modelAttribute="osAllocation">
            <table class="allocTable">
                <tr>
                    <td>Force Open</td>
                    <td>
                        <c:choose>
                            <c:when test="${osAllocation.force_open}">
                                <input name='force_open' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='force_open' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr><td>Force Closed</td>
                    <td>
                        <c:choose>
                            <c:when test="${osAllocation.force_close}">
                                <input name='force_close' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='force_close' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr><td>Meeting</td>
                    <td>
                        <c:choose>
                            <c:when test="${osAllocation.meeting}">
                                <input name='meeting' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='meeting' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td>Overflow Call Volume</td>
                    <td>
                        <select name='overflow'>
                            <c:forEach var="i" begin="0" end="100" step="5">
                                <c:choose>
                                    <c:when test="${i == osAllocation.overflow}">
                                        <option value="${i}" selected><c:out value="${i}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${i}"><c:out value="${i}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>TBPO Call Volume</td>
                    <td>
                        <select name='overflow2' id='osOverflow2'>
                            <c:forEach var="i" begin="0" end="100" step="5">
                                <c:choose>
                                    <c:when test="${i == osAllocation.overflow2}">
                                        <option value="${i}" selected><c:out value="${i}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${i}"><c:out value="${i}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>ITEL Call Volume</td>
                    <td id="osITEL"> <c:out value="${100 - osAllocation.overflow2}" /></td>
                </tr>
            </table>
            <p  class='marginMedium'><input type="submit" value=" Change OS "></p>
            <input type="hidden" name="product" value="${osAllocation.product}"/>
            <input type="hidden" name="product_name" value="${osAllocation.product_name}"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>-->

        
    <div class='inter2clmrightin'>
        <h1>Customer Service</h1>
        <form action="${pageContext.servletContext.contextPath}/Allocation/CS" method="POST" modelAttribute="csAllocation">
            <table class="allocTable">
                <tr>
                    <td>Force Open</td>
                    <td>
                        <c:choose>
                            <c:when test="${csAllocation.force_open}">
                                <input name='force_open' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='force_open' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr><td>Force Closed</td>
                    <td>
                        <c:choose>
                            <c:when test="${csAllocation.force_close}">
                                <input name='force_close' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='force_close' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr><td>Meeting</td>
                    <td>
                        <c:choose>
                            <c:when test="${csAllocation.meeting}">
                                <input name='meeting' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='meeting' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td>Overflow Call Volume</td>
                    <td>
                        <select name='overflow'>
                            <c:forEach var="i" begin="0" end="100" step="5">
                                <c:choose>
                                    <c:when test="${i == csAllocation.overflow}">
                                        <option value="${i}" selected><c:out value="${i}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${i}"><c:out value="${i}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>TBPO Call Volume</td>
                    <td>
                        <select name='overflow2' id='csOverflow2'>
                            <c:forEach var="i" begin="0" end="100" step="5">
                                <c:choose>
                                    <c:when test="${i == csAllocation.overflow2}">
                                        <option value="${i}" selected><c:out value="${i}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${i}"><c:out value="${i}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>ITEL Call Volume</td>
                    <td id="csITEL"> <c:out value="${100 - csAllocation.overflow2}" /></td>
                </tr>
            </table>
            <p  class='marginMedium'><input type="submit" value=" Change CS "></p>
            <input type="hidden" name="product" value="${csAllocation.product}"/>
            <input type="hidden" name="product_name" value="${csAllocation.product_name}"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
        
     <div class='inter2clmrightin'>
        <h1>Spanish</h1>
        <form action="${pageContext.servletContext.contextPath}/Allocation/SP" method="POST" modelAttribute="spAllocation">
            <table class="allocTable">
                <tr>
                    <td>Force Open</td>
                    <td>
                        <c:choose>
                            <c:when test="${spAllocation.force_open}">
                                <input name='force_open' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='force_open' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr><td>Force Closed</td>
                    <td>
                        <c:choose>
                            <c:when test="${spAllocation.force_close}">
                                <input name='force_close' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='force_close' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr><td>Meeting</td>
                    <td>
                        <c:choose>
                            <c:when test="${spAllocation.meeting}">
                                <input name='meeting' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='meeting' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td>Overflow Call Volume</td>
                    <td>
                        <select name='overflow'>
                            <c:forEach var="i" begin="0" end="100" step="5">
                                <c:choose>
                                    <c:when test="${i == spAllocation.overflow}">
                                        <option value="${i}" selected><c:out value="${i}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${i}"><c:out value="${i}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
<!--                <tr>
                    <td>TBPO Call Volume</td>
                    <td>
                        <select name='overflow2' id='spOverflow2'>
                            <c:forEach var="i" begin="0" end="100" step="5">
                                <c:choose>
                                    <c:when test="${i == spAllocation.overflow2}">
                                        <option value="${i}" selected><c:out value="${i}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${i}"><c:out value="${i}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>-->
            </table>
            <p  class='marginMedium'><input type="submit" value=" Change SP "></p>
            <input type="hidden" name="product" value="${spAllocation.product}"/>
            <input type="hidden" name="product_name" value="${spAllocation.product_name}"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
<!--    <div class='inter2clmrightin'>
        <h1>NeoVox</h1>
        <form action="${pageContext.servletContext.contextPath}/Allocation/nv" method="POST" modelAttribute="nvAllocation">
            <table class="allocTable">
                <tr>
                    <td>Force Open</td>
                    <td>
                        <c:choose>
                            <c:when test="${nvAllocation.force_open}">
                                <input name='force_open' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='force_open' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr><td>Force Closed</td>
                    <td>
                        <c:choose>
                            <c:when test="${nvAllocation.force_close}">
                                <input name='force_close' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='force_close' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr><td>Meeting</td>
                    <td>
                        <c:choose>
                            <c:when test="${nvAllocation.meeting}">
                                <input name='meeting' type='checkbox' checked>
                            </c:when>
                            <c:otherwise>
                                <input name='meeting' type='checkbox'>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td>Overflow Call Volume</td>
                    <td>
                        <select name='overflow'>
                            <c:forEach var="i" begin="0" end="100" step="5">
                                <c:choose>
                                    <c:when test="${i == nvAllocation.overflow}">
                                        <option value="${i}" selected><c:out value="${i}"/></option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${i}"><c:out value="${i}"/></option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <p  class='marginMedium'><input type="submit" value=" Change NV "></p>
            <input type="hidden" name="product" value="${nvAllocation.product}"/>
            <input type="hidden" name="product_name" value="${nvAllocation.product_name}"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>-->

</div>

<!--End Main Content-->
<script src="<c:url value='/static/js/jquery-3.3.1.min.js'/>"></script>
<script src="<c:url value='/static/js/page-methods.js'/>"></script>
        
<jsp:include page="/WEB-INF/jsp/main_footer.jsp" />