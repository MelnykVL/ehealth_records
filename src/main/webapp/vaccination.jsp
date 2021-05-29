<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1">
    <title>Вакцинування</title>
    <link rel="stylesheet" href="ui/css/menu_style.css">
    <link rel="stylesheet" href="ui/css/vaccine_style.css">
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

        <div style="display: flex; justify-content: flex-end;">
                <a style="padding: 10px; background: rgb(255, 255, 255); border-radius: 5px; border: 1px solid #000; margin: 10px; text-decoration: none; font-weight: bold; color: #000;" href="#openModal">
                    Новий запис
                </a>
            </div>

            <div id="wrap-vac">
            <c:if test="${not empty vaccinations}">
                <c:forEach var="vaccination" items="${vaccinations}">

                    <span class="vaccinations">

                            <h4 class="vaccinations-id">
                                ID: <c:out value="${vaccination.vaccinationId}" />
                            </h4>

                            <div class="content">
                                <div class="vaccinations-content">

                                    <span class="vaccinations-content-item">
                                        <h4>Назва вакцини:</h2>
                                        <p><c:out value="${vaccination.vaccineName}" /></p>
                                    </span>

                                    <span class="vaccinations-content-item">
                                        <h4>Реакція на вакцину:</h2>
                                        <p><c:out value="${vaccination.reaction}" /></p>
                                    </span>

                                    <span class="vaccinations-content-item">
                                        <h4>Адреса вакцинації:</h2>
                                        <p><c:out value="${vaccination.addressOfBuild}" /></p>
                                    </span>

                                </div>

                                <div class="vaccinations-info">
                                    <p class="created-in">Створено: <span><c:out value="${vaccination.vaccinated}" /></span></p>
                                </div>
                            </div>

                        </span>

                </c:forEach>
            </c:if>
            </div>

            <span id="openModal">

                <form action="vaccinationServlet" method="POST">

                                <h3>Новий запис</h3>


                                <content>

                                    <span class="part-form">

                                        <label for="">
                                            <h4>Назва вакцини:</h4>
                                            <input type="text" name="vaccine-name" required>
                                        </label>

                                        <label for="">
                                            <h4>Адреса вакцинації:</h4>
                                            <input type="text" name="address-of-build" required>
                                        </label>

                                    </span>

                                    <span class="part-form">

                                        <label for="">
                                            <h4>Реакція на вакцину:</h4>
                                            <textarea rows="5" cols="30" name="reaction"></textarea>
                                        </label>

                                    </span>

                                </content>

                                <button type="submit">Створити запис</button>

                </form>
            </span>

</body>
</html>