<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <title>Аналізи</title>
    <link rel="stylesheet" href="ui/css/results_style.css">
    <link rel="stylesheet" href="ui/css/menu_style.css">
</head>
<body>

    <div id="bg-image"></div>

    <header>

            <h1 id="logo">Медична картка амбулаторного хворого</h1>

            <input type="checkbox" id="hmt" class="hidden-menu-ticker">
                <label class="btn-menu" for="hmt">
                    <span class="first"></span>
                    <span class="second"></span>
                    <span class="third"></span>
                </label>
                <ul class="hidden-menu">
                    <li style="display: flex; flex-direction: column;">
                                            <a href="profileServlet">Профіль</a>
                                            <a href="recordsServlet">Записи</a>
                                            <a href="vaccinationServlet">Вакцинація</a>
                                            <a href="resultsServlet">Аналізи</a>
                                            <a href="logoutServlet" id="logout">Вихід</a>
                                        </li>
                </ul>

        </header>

        <div style="display: flex; justify-content: center;">
                        <a style="padding: 10px; background: rgb(255, 255, 255); border-radius: 5px; border: 1px solid #000; margin: 10px; text-decoration: none; font-weight: bold; color: #000;" href="#openModal">
                            Завантажити файл на сайт
                        </a>
                    </div>

                    <div id="wrap-vac">
                    <c:if test="${not empty results}">
                        <c:forEach var="file" items="${results}">

                            <span class="vaccinations">

                                    <h4 class="vaccinations-id">
                                        ID: <c:out value="${file.resultId}" />
                                    </h4>

                                    <div class="content">
                                        <div class="vaccinations-content">

                                        <span class="vaccinations-content-item">
                                            <h4>Назва файлу:</h2>
                                            <p><c:out value="${file.name}" /></p>
                                        </span>

                                            <span class="vaccinations-content-item">
                                                <p>
                                                    <a href="<c:out value="${file.filePath}" />" target="_blank">Відкрити</a>
                                                    <a href="<c:out value="${file.filePath}" />" download>Завантажити</a>
                                                </p>
                                            </span>

                                        </div>

                                        <div class="vaccinations-info">
                                            <p class="created-in">Створено: <span><c:out value="${file.createdIn}" /></span></p>
                                        </div>
                                    </div>

                                </span>

                        </c:forEach>
                    </c:if>
                    </div>

                        <c:forEach var="file" items="${files}">
                            <h3>
                                <a href="<c:out value="${path}" /><c:out value="${file}" />">FileTXT</a>

                            </h3>
                        </c:forEach>



                    <span id="openModal">

                        <form action="resultsServlet" action="upload" method="POST" enctype="multipart/form-data">

                                        <h3>Завантажити файл</h3>

                                        <content>

                                            <span class="part-form">

                                                <label for="">
                                                    <input type="file" name="file" required/>
                                                </label>

                                            </span>

                                        </content>

                                        <button type="submit">Завантажити</button>

                        </form>
                    </span>

</body>
</html>