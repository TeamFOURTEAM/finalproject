<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp"%>
<body id="scrollLock">
                <link rel="stylesheet" href="<c:url value="/resources/css/CompanyMap/CompanyMap.css"/>">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
                <script src="<c:url value="resources/js/jquery.js"/>"></script>
                <section id="opacityBlock">
                    <div id="MapContainer">
                        <div id="CompanyName">
                        	<form action="#">
		                        <c:if test="${!empty company_names}">
		                        	<c:forEach var="CName" items="${company_names}">                                               
		                            	<input id="CompanyBtn" class="CompanyBtn" type="button" value="${CName.company_name}" onclick="MapInfo('${CName.company_name}');">                            
		                            </c:forEach>
		                        </c:if>
		                    </form>
                        </div>
            
                        <div id="MapArea">
            
                        </div>
            
                    <!-- 관리자일 경우 실행 -->
                    <!-- 추가 할 지점 지도 등록 -->
                    <span class="addLocation"><input id="adminAddMap" type="button" onclick="admin_add_CompanyMap();"><i class="fas fa-plus-square fa-2x"></i></span>
                    </div>
                </section>
                <!-- 버튼 눌렀을 경우 보일 display 영역 -->
                <form id="frm" action="#" enctype="multipart/form-data" method="post">
                    <div id="addCompany" class="addCompany">
                        <input name="company_name" id="company_name" class="textInput" type="text" placeholder="회사명">
                        <input name="company_x" id="company_x" class="textInput" type="text" placeholder="위도">
                        <input name="company_y" id="company_y" class="textInput" type="text" placeholder="경도">
                        <input name="company_addr" id="company_addr" class="textInput" type="text" placeholder="주소">
                        <input name="company_image" id="company_image" class="textInput" type="file" placeholder="image">
                        <input class="buttonInput" type="button" value="확인" onclick="fn_check();">
                        <input class="buttonInput" type="button" value="취소" onclick="admin_add_CompanyMap();">
                    </div>
                </form>
            </body>

        <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7152889429cbed9c5679a348746e9d44"></script>
                <script src="<c:url value="/resources/js/CompanyMap/CompanyMap.js"/>"></script>
</body>
<jsp:include page="../include/footer.jsp" />