<#macro bootstrapNavBar>
    <#include "security.ftl">
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark scrolling-navbar">
        <a class="navbar-brand" href="/"><strong>ЦОП</strong></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">На главную</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Войти на сайт</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/registration">Зарегистрироваться</a>
                </li>
                <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Пользователи</a>
                </li>
                </#if>
                <li class="nav-item">
                    <a class="nav-link" href="/plains">Самолеты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/managers">Диспетчеры</a>
                </li>
            </ul>
            <#if isAdmin>
                <div class="navbar-text mr-3">Добро пожаловать, ${name}!</div>
                <div>
                    <form action="/logout" method="post">
                        <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                        <button type="submit" class="btn btn-outline-info waves-effect">Выйти</button>
                    </form>
                </div>
            </#if>
        </div>
    </nav>
</#macro>
