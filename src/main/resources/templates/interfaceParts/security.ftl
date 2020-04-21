<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    isAdmin = user.isAdmin()
    isUser = user.isUser()
    isManager = user.isManager()
    >
<#else>
    <#assign
    name = "Guest"
    isAdmin = false
    isUser = false
    isManager = false
    >
</#if>