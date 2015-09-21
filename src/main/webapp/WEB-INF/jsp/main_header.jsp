<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Contact Center Portal</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache">
        <meta http-equiv="Expires" content="Mon, 22 Jul 1970 11:12:01 GMT">
        <link href="<c:url value='/static/favicon.ico'/>" rel="shortcut icon">
        <link href="<c:url value='/static/css/site.css'/>" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="mainbody_int">
            <div class="corwrpr">
                <div class="hdrwrpr">
                    <div class="header">
                        <div class="tagline"><h1>&nbsp;</h1></div>
                        <a class="sitelogo" alt=" " href="/">
                            <img src=<c:url value='/static/images/Bradford-logo.png'/>></a>
                            <!--<img src=<c:url value='/static/theme/ham/img/logo.png'/>></a>-->
                        <div class="clear"></div>
                    </div>    
                    <div class="mainNav">  
                        <ul class="sf-menu sfHover">
                            <li id="firstLiItem" class="firstnavitemli">
                                <a href="${pageContext.servletContext.contextPath}/Allocation" id="lnkLink1" class="firstnavitema">Call Allocation</a>
                            </li>
                            <sec:authorize access="hasRole('ROLE_ADMIN')">
                                <li id="secondLiItem" class="firstnavitemli">
                                    <a href="<c:url value='/admin'/>">Admin Screen</a>
                                </li>
                            </sec:authorize>
                        </ul>
                    </div>

                </div>
                <div class="clear"></div>
                <div class="pagetoolsblock floatRight">
                    <div class="floatRight">
                        <p class="floatRight">
                            <a href="<c:url value='/logout'/>"><sec:authentication property="principal.username" />, Logout</a>    	
                        </p>
                    </div>
                </div> 
                <div class="block">
                    <div class="mainintwpr">
                        <!--                        <div class="intleft">
                                                    <div id="CT_HeaderLeft_0_divPlaceholder" style="width: 224px;">&nbsp;</div>
                                                                                <div class="navbanner">
                                                                                    <h1>                                    <a href="/contact-us/">Contact Us</a></h1>
                                                                                </div>
                                                </div>	-->
                        <div class="intright">
                            <div class="inter2clmrightin">