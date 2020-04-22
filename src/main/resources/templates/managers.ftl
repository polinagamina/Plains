<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<#import "interfaceParts/bootstrapHeaderLinks.ftl" as bootstrapHeaderLinks>
<#import "interfaceParts/bootstrapNavBarWithSignBtn.ftl" as navBarWithSignBtn>
<#import "interfaceParts/bootstrapFooterScripts.ftl" as bootstrapFooterScripts>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <@bootstrapHeaderLinks.bootstrapHeaderLinks/>
    <title>Диспетчеры</title>
</head>
<body>
<@navBarWithSignBtn.bootstrapNavbarWithSignBtn/>
<div class="container" style="height: 70px">
</div>
<div class="jumbotron card card-image"
     style="background-image: url(https://mdbootstrap.com/img/Photos/Others/gradient1.jpg);">
    <div class="text-black text-center py-5 px-4">
        <div>
            <h1 class="card-title h1-responsive pt-3 mb-5 font-bold"><strong>Диспетчерская</strong></h1>
        </div>
    </div>
</div>
<div class="container mt-5 ml-5">
    <#if filterCheck??>
        <div class="alert alert-danger alert-dismissible fade show" role="alert" style="width: 736px">
            ${filterCheck!}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form action="/managersFilter" method="post" class="form-inline">
                <div class="form-group row">
                    <div class="md-form form-lg ml-4">
                        <input type="text" name="managerId" id="input" class="form-control form-control-lg">
                        <label for="input">Найти по ID...</label>
                    </div>
                    <div class="md-form form-lg ml-3">
                        <input type="text" name="firstName" id="inpu" class="form-control form-control-lg">
                        <label for="inpu">Найти по имени...</label>
                    </div>
                    <div class="md-form form-lg ml-3">
                        <input type="text" name="lastName" id="inp" class="form-control form-control-lg">
                        <label for="inp">Найти по фамилии...</label>
                    </div>
                    <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                    <div>
                        <button type="submit" class="btn btn-primary ml-3">Найти</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container ml-5">
    <#if deleteIdCheck??>
        <div class="alert alert-danger alert-dismissible fade show" role="alert" style="width: 305px">
            ${deleteIdCheck!}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form action="/managersDelete" method="post" class="form-inline">
                <div class="form-group row">
                    <div class="md-form form-lg ml-4">
                        <input type="text" name="managerId" id="in" class="form-control form-control-lg">
                        <label for="in">Удалить по ID...</label>
                    </div>
                    <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                    <button type="submit" class="btn btn-primary ml-3">Удалить</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container mt-3 ml-5">
    <#if updateIdCheck??>
        <div class="alert alert-danger alert-dismissible fade show" role="alert" style="width: 589px">
            ${updateIdCheck!}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </#if>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapse1" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Открыть меню изменения информации о существующем в системе диспетчера
    </a>
    <div class="collapse" id="collapse1">
        <div class="form-group mt-3">
            <form action="/managersUpdate" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="managerId"
                           placeholder="Введите ID диспетчера, информацию о котором нужно изменить..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="firstName" placeholder="Изменить имя диспетчера..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="lastName"
                           placeholder="Изменить фамилию диспетчера..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="email" placeholder="Изменить e-mail диспетчера..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="phoneNumber"
                           placeholder="Изменить телефон диспетчера..."/>
                </div>
                <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Изменить</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container mt-5 ml-5">
    <a class="btn btn-primary" data-toggle="collapse" href="#collapse2" role="button" aria-expanded="false"
       aria-controls="collapse2">
        Открыть меню добавления нового диспетчера в систему
    </a>
    <div class="collapse" id="collapse2">
        <div class="form-group mt-3">
            <form action="/managers" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="firstName" placeholder="Введите имя диспетчера..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="lastName" placeholder="Введите фамилию диспетчера..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="email" placeholder="Введите e-mail диспетчера..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="phoneNumber"
                           placeholder="Введите телефон диспетчера..."/>
                </div>

                <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container mt-5 ml-5">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Имя</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Почта</th>
            <th scope="col">Сотовый</th>
            <th scope="col">Автор</th>
        </tr>
        </thead>
        <tbody>
        <#list managers as manager>
            <tr>
                <th scope="row">${manager.managerId}</th>
                <td>${manager.firstName}</td>
                <td>${manager.lastName}</td>
                <td>${manager.email}</td>
                <td>${manager.phoneNumber}</td>
                <td>${manager.authorName}</td>
            </tr>
        <#else>
            <tr>
                <th scope="row">Пока еще нет ни одного диспетчера!</th>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
<div class="container" style="height: 500px">
</div>
<footer class="page-footer font-small black">
    <div class="footer-copyright text-center py-3">© Центр отслеживания полетов, 2020</div>
</footer>
<@bootstrapFooterScripts.bootstrapFooterScripts/>
</body>
</html>