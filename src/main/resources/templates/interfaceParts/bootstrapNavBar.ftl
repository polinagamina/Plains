<#macro bootstrapNavBar>
    <#include "security.ftl">
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark scrolling-navbar">
        <a class="navbar-brand" href="/"><strong>Delivery Service</strong></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Sign In</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/registration">Sign Up</a>
                </li>
                <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Users</a>
                </li>
                </#if>
                <li class="nav-item">
                    <a class="nav-link" href="/plains">Plains</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/managers">Диспетчеры</a>
                </li>
            </ul>
            <div class="navbar-text">${name}</div>
        </div>
    </nav>
</#macro>
