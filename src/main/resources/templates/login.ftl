<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<#import "interfaceParts/bootstrapHeaderLinks.ftl" as bootstrapHeaderLinks>
<#import "interfaceParts/bootstrapNavBar.ftl" as navBar>
<#import "interfaceParts/bootstrapNavBarWithSignBtn.ftl" as navBarWithSignBtn>
<#import "interfaceParts/bootstrapFooterScripts.ftl" as bootstrapFooterScripts>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <@bootstrapHeaderLinks.bootstrapHeaderLinks/>
    <title>Authorization</title>
</head>
<body>
<@navBarWithSignBtn.bootstrapNavbarWithSignBtn/>
<div class="container" style="height: 75px">
</div>
<div class="container mt-5 ml-5" style="width: 500px">
    <div class="card">
        <h3 class="card-header info-color white-text text-center py-4">
            <strong>Authorization</strong>
        </h3>
        <div class="card-body">
            <#if error??>
                <div class="alert alert-danger alert-dismissible fade show mt-3 ml-2" role="alert" style="width: 414px">
                    <span>  Invalid username or password. Please, <a href="/registration"
                                                                     class="alert-link">register</a>, if you haven’t done so yet.</span>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </#if>
            <#if logout??>
                <div class="alert alert-info alert-dismissible fade show mt-3 ml-2" role="alert" style="width: 414px">
                    You have been logged out.
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </#if>

            <form action="/login" method="post">

                <div class="md-form">
                    <i class="fa fa-user prefix grey-text"></i>
                    <input type="text" name="username" id="materialFormCardNameEx" class="form-control">
                    <label for="materialFormCardNameEx" class="font-weight-light">Your name...</label>
                </div>

                <div class="md-form">
                    <i class="fa fa-lock prefix grey-text"></i>
                    <input type="password" name="password" id="materialFormCardPasswordEx" class="form-control">
                    <label for="materialFormCardPasswordEx" class="font-weight-light">Your password...</label>
                </div>

                <#--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
                <div class="text-center py-4 mt-3">
                    <button class="btn btn-outline-info" type="submit">Sign In</button>
                </div>

                <div class="text-center">
                    <p>Not a member?
                        <a href="/registration">Register</a>
                    </p>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container" style="height: 500px">
</div>
<footer class="page-footer font-small black">
    <div class="footer-copyright text-center py-3">© Delivery Service, 2019:</div>
</footer>
<@bootstrapFooterScripts.bootstrapFooterScripts/>
</body>
</html>