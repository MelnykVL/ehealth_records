<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Профіль</title>
    <link rel="stylesheet" href="ui/css/profile_style.css">
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

        <div id="profile">

                <h1 id="profile-name">${patient.fullName}</h1>

                <div class="profile-content-wrap">

                    <div id="profile-content">

                        <span class="profile-content-item">
                            <h4>Стать:</h4>
                            <p>${patient.sex}</p>
                        </span>

                        <span class="profile-content-item">
                            <h4>Група крові:</h4>
                            <p>${patient.bloodType}</p>
                        </span>

                        <span class="profile-content-item">
                            <h4>Дата народження:</h4>
                            <p>${patient.birthday}</p>
                        </span>

                        <span class="profile-content-item">
                            <h4>Зріст:</h4>
                            <p>${patient.height} см</p>
                        </span>

                        <span class="profile-content-item">
                            <h4>Вага:</h4>
                            <p>${patient.weight} кг</p>
                        </span>

                    </div>

                    <div id="profile-info">

                        <div class="profile-info-item">
                            <h4>Адреса проживання:</h4>
                            <p>${patient.addressOfResidence}</p>
                        </div>

                        <div class="profile-info-item">
                            <h4>Професія:</h4>
                            <p>${patient.profession}</p>
                        </div>

                        <div class="profile-info-item">
                            <h4>Місце праці (навчання):</h4>
                            <p>${patient.addressOfWork}</p>
                        </div>

                    </div>

                </div>

                <a href="#openModal" id="profile-edit">Редагувати</a>

            </div>

            <span id="openModal">

                    <form action="profileServlet" method="POST">

                                    <h3>Редагування профілю</h3>

                                    <content>

                                        <span class="part-form">

                                            <label for="">
                                                <h4>ПІБ:</h4>
                                                <input type="text" name="full-name" value="${patient.fullName}" required>
                                            </label>

                                            <label for="">
                                                <h4>Професія:</h4>
                                                <input type="text" name="profession" value="${patient.profession}" required>
                                            </label>

                                        </span>

                                        <span class="part-form">

                                            <label for="">
                                                <h4>Зріст:</h4>
                                                <input type="number" name="height" value="${patient.height}" required>
                                            </label>

                                            <label for="">
                                                <h4>Вага:</h4>
                                                <input type="number" name="weight" value="${patient.weight}" required>
                                            </label>

                                        </span>

                                        <span class="part-form">

                                            <label for="">
                                                <h4>Адреса проживання:</h4>
                                                <input type="text" name="address-of-residence" value="${patient.addressOfResidence}" required>
                                            </label>

                                            <label for="">
                                                <h4>Адреса роботи:</h4>
                                                <input type="text" name="address-of-work" value="${patient.addressOfWork}">
                                            </label>

                                        </span>

                                    </content>

                                    <button type="submit">Зберегти зміни</button>

                    </form>
                </span>

</body>
</html>