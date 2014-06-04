<#import "/spring.ftl" as spring />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<#assign titleString>Index</#assign>

<#assign content>
<h1><@spring.message "label.welcome"/></h1>
<p><@spring.message "label.non.secured.page"/></p> 
</#assign>

<#include "wrapper.ftl" />