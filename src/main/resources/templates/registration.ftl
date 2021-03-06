<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<#import "interfaceParts/bootstrapHeaderLinks.ftl" as bootstrapHeaderLinks>
<#import "interfaceParts/bootstrapNavBar.ftl" as navBar>
<#import "interfaceParts/bootstrapNavBarWithSignBtn.ftl" as navBarWithSignBtn>
<#import "interfaceParts/bootstrapFooterScripts.ftl" as bootstrapFooterScripts>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <@bootstrapHeaderLinks.bootstrapHeaderLinks/>
    <title>Registration</title>
</head>
<body>
<@navBarWithSignBtn.bootstrapNavbarWithSignBtn/>
<div class="container" style="height: 75px">
</div>
<div class="container mt-5 ml-5" style="width: 500px">
    <div class="card">
        <h3 class="card-header info-color white-text text-center py-4">
            <strong>Регистрация</strong>
        </h3>
        <div class="card-body">

            <#if errorMessage??>
                <div class="alert alert-danger alert-dismissible fade show mt-3 ml-2" role="alert" style="width: 413px">
                    ${errorMessage!}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </#if>

            <#if successMessage??>
                <div class="alert alert-success alert-dismissible fade show mt-3 ml-2" role="alert"
                     style="width: 413px">
                    <span>${successMessage!}<br> Нажмите <a href="/login" class="alert-link"> здесь</a> для того, чтобы войти на сайт</span>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </#if>

            <form action="/registration" method="post">
                <div class="md-form">
                    <i class="fa fa-user prefix grey-text"></i>
                    <input type="text" name="username" id="materialFormCardNameEx" class="form-control">
                    <label for="materialFormCardNameEx" class="font-weight-light">Ваш логин...</label>
                </div>

                <div class="md-form">
                    <i class="fa fa-lock prefix grey-text"></i>
                    <input type="password" name="password" id="materialFormCardPasswordEx" class="form-control">
                    <label for="materialFormCardPasswordEx" class="font-weight-light">Ваш пароль...</label>
                </div>

                <#--<input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
                <div class="text-center py-4 mt-3">
                    <button class="btn btn-outline-info" type="submit">Выйти</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container" style="height: 500px">
</div>
<footer class="page-footer font-small black">
    <div class="footer-copyright text-center py-3">© Центр отслеживания полетов,2020</div>
</footer>
<@bootstrapFooterScripts.bootstrapFooterScripts/>
</body>
</html>