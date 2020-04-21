<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<#import "interfaceParts/bootstrapHeaderLinks.ftl" as bootstrapHeaderLinks>
<#import "interfaceParts/bootstrapNavBarWithSignBtn.ftl" as navBarWithSignBtn>
<#import "interfaceParts/bootstrapFooterScripts.ftl" as bootstrapFooterScripts>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <@bootstrapHeaderLinks.bootstrapHeaderLinks/>
    <title>Plains</title>
</head>
<body>
<@navBarWithSignBtn.bootstrapNavbarWithSignBtn/>
<div class="container" style="height: 70px">
</div>
<div class="jumbotron card card-image"
     style="background-image: url(https://mdbootstrap.com/img/Photos/Others/gradient1.jpg);">
    <div class="text-black text-center py-5 px-4">
        <div>
            <h1 class="card-title h1-responsive pt-3 mb-5 font-bold"><strong>Plains page</strong></h1>
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
            <form action="/plainsFilter" method="post" class="form-inline">
                <div class="form-group row">
                    <div class="md-form form-lg ml-4">
                        <input type="text" name="plainId" id="input" class="form-control form-control-lg">
                        <label for="input">Найти по ID...</label>
                    </div>
                    <div class="md-form form-lg ml-3">
                        <input type="text" name="hexId" id="inpu" class="form-control form-control-lg">
                        <label for="inpu">Найти по Hex номеру...</label>
                    </div>
                    <div class="md-form form-lg ml-3">
                        <input type="text" name="flight" id="inp" class="form-control form-control-lg">
                        <label for="inp">Найти по рейсу...</label>
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
            <form action="/plainsDelete" method="post" class="form-inline">
                <div class="form-group row">
                    <div class="md-form form-lg ml-4">
                        <input type="text" name="plainId" id="in" class="form-control form-control-lg">
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
        Открыть меню изменения информации о существующем в системе самолете
    </a>
    <div class="collapse" id="collapse1">
        <div class="form-group mt-3">
            <form action="/plainsUpdate" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="plainId"
                           placeholder="Введите ID самолета, информацию о котором нужно изменить..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="hexId" placeholder="Изменить hexId самолета..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="flight"
                           placeholder="Изменить рейс..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="altitude" placeholder="Изменить высоту самолета..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="speed"
                           placeholder="Изменить скорость самолета..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="latitude"
                           placeholder="Изменить широту самолета..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="longitude"
                           placeholder="Изменить долготу самолета..."/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="track"
                           placeholder="Изменить трек-номер самолета..."/>
                </div>
                <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Изменить</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--div>
    <form method="post">
        <input type="text" name="plainId" placeholder="Введите уникальный идентификатор самолета"/>
        <input type="text" name="HexId" placeholder="Введите уникальный идентификатор"/>
        <input type="text" name="flight" placeholder="Введите рейс"/>
        <input type="text" name="altitude" placeholder="Введите высоту"/>
        <input type="text" name="speed" placeholder="Введите скорость"/>
        <input type="text" name="latitude" placeholder="Введите широту"/>
        <input type="text" name="longitude" placeholder="Введите долготу"/>
        <input type="text" name="track" placeholder="Введите трэк"/>
        <input type="text" name="messages" placeholder="Введите сообщение"/>
        <button type="submit">Добавить</button>
    </form>
</div-->
<div class="container mt-5 ml-5">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">HexID</th>
            <th scope="col">Рейс</th>
            <th scope="col">Высота</th>
            <th scope="col">Скорость</th>
            <th scope="col">Широта</th>
            <th scope="col">Долгота</th>
            <th scope="col">Трек-номер</th>
        </tr>
        </thead>
        <tbody>
        <#list plains as plain>
            <tr>
                <th scope="row">${plain.plainId}</th>
                <td>${plain.hexId}</td>
                <td>${plain.flight}</td>
                <td>${plain.altitude}</td>
                <td>${plain.speed}</td>
                <td>${plain.latitude}</td>
                <td>${plain.longitude}</td>
                <td>${plain.track}</td>
            </tr>
        <#else>
            <tr>
                <th scope="row">List of plains is empty yet!</th>
                <td></td>
                <td></td>
                <td></td>
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
    <div class="footer-copyright text-center py-3">© ЦОП, 2020:</div>
</footer>
<@bootstrapFooterScripts.bootstrapFooterScripts/>
</body>
</html>