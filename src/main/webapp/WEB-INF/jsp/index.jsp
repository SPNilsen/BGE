<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="/WEB-INF/jsp/main_header.jsp" />
                                <!--Bread Crumbs-->
                                <div class="bcrumbwpr">					
                                    <div class="breadcrumbs">
                                        <img src="${pageContext.servletContext.contextPath}/static/images/home-icon.png"><a href="${pageContext.servletContext.contextPath}/">Home</a>
                                    </div>
                                </div>
                                <!--End Bread Crumbs-->

                                <!--Main Content-->
                                <div id="PageHeading">
                                    <h1>Main Site</h1>
                                </div>
                                <div class="block"><hr />
                                    <p>Welcome the the Contact Center Management Web site.</p>
                                    <p>This site will provide capabilities on-demand to Business users for various features and functionality. This set of tools is expected to expand naturally over time but if you have a specific request for a feature you'd like to see here, please contact:</p>
                                    <p><a href="mailto:bfriedop@bgeltd.com?subject=Contact Center Portal Feedback">Brian Friedopfer</a></p>
                                </div>

                                <!--End Main Content-->
<jsp:include page="/WEB-INF/jsp/main_footer.jsp" />