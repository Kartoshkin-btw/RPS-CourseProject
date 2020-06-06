<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        <%@include file="/resources/style.css" %>
    </style>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Account</title>
</head>
<body>
<div class="headContainer">
    <header class="header">
        <a class="logo" href="listClothes">LOGO</a>
        <nav class="nav">
            <a class="nav_link" href="listClothes">Одежда</a>
            <a class="nav_link" href="listImages">Изображения</a>
            <a class="nav_link" href="listTemplates">Шаблоны</a>
            <a class="nav_link" href="listCombinations">Готовые комбинации</a>
        </nav>
        <nav class="nav">
            <sec:authorize access="isAuthenticated()">
                <a class="enter" href="cartPage">Корзина</a>  /
                <a class="enter" href="account">Личный кабинет</a>  /
                <a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <a class="enter" href="login">Войти</a> /
                <a class="enter" href="registration">Зарегистрироваться</a>
            </sec:authorize>
        </nav>
    </header>
</div>
<div class="container" style="margin: 3% 15%">
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <div class="acc-right">
            <d style="text-align: center; font-size: 25px"><a class="admin_nav" href="listUsers">Пользователи</a></d>
            <br><d style="text-align: center; font-size: 25px"><a class="admin_nav" href="listPrints">Принты</a></d>
            <br><d style="text-align: center; font-size: 25px"><a class="admin_nav" href="listOrders">Заказы</a></d>
        </div>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_PRINT')">
        <nav class="acc-right">
            <d style="text-align: center; font-size: 25px"><a class="admin_nav" href="listOrders">Заказы</a></d>
        </nav>
    </sec:authorize>
    <div class="acc-left">
        <d style="text-align: center; font-size: 25px"><a class = "admin_nav" style="margin: 0;" href="myOrders">Мои заказы</a></d>
        <sec:authorize access="!hasRole('ROLE_ADMIN')">
            <d style="text-align: center; font-size: 25px"><a class = "admin_nav" style="margin: 0;" href="myImages">Мои изображения</a></d>
        </sec:authorize>
        <br><br><d>${currentUser.login}</d>
        <br><d>First Name: ${currentUser.firstName}</d>
        <br><d>Last Name: ${currentUser.lastName}</d>
        <br><d>Email: ${currentUser.email}</d>
        <br><d>Address: ${currentUser.address}</d>
        <br><d>Balance: ${currentUser.balance}</d>
        <br><a class = "choose" href="editProfile?id=${currentUser.id}">Edit</a>
    </div>
</div>
</body>
</html>
