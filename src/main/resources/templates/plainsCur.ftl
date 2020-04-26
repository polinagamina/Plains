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
<!--script>
    setTimeout(function () {
    location.reload();
    },30000);
    </script-->
<body>
<@navBarWithSignBtn.bootstrapNavbarWithSignBtn/>
<div class="container" style="height: 70px">
</div>
<div class="jumbotron card card-image"
     style="background-image: url(https://mdbootstrap.com/img/Photos/Others/gradient1.jpg);">
    <div class="text-black text-center py-5 px-4">
        <div>
            <h1 class="card-title h1-responsive pt-3 mb-5 font-bold"><strong>Информация о самолетах</strong></h1>
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
            <form action="/plainsFilt" method="post" class="form-inline">
                <div class="form-group row">
                    <div class="md-form form-lg ml-3">
                        <input type="text" name="hex" id="input" class="form-control form-control-lg">
                        <label for="input">Найти по Hex номеру...</label>
                    </div>
                    <div class="md-form form-lg ml-3">
                        <input type="text" name="flight" id="inpu" class="form-control form-control-lg">
                        <label for="inpu">Найти по рейсу...</label>
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
<div>
    <a class="btn btn-primary" href="http://192.168.1.54:8080" target="_blank" role="button">Посмотреть самолеты</a>
</div>
<div class="container mt-5 ml-5">
    <table class="table table-striped">
        <thead>
        <tr>
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
        <#list plainsCur as plain>
            <tr>
                <th scope="row">${plain.hexId}</th>
                <td>${plain.flight}</td>
                <td>${plain.altitude}</td>
                <td>${plain.speed}</td>
                <td>${plain.latitude}</td>
                <td>${plain.longitude}</td>
                <td>${plain.track}</td>
            </tr>
        <#else>
            <tr>
                <th scope="row">Пока в системе нет одного самолета!</th>
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
    <div class="footer-copyright text-center py-3">© Центр отслеживания полетов,2020:</div>
</footer>
<@bootstrapFooterScripts.bootstrapFooterScripts/>
</body>
</html>