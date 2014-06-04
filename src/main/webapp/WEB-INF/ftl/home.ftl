<#import "/spring.ftl" as spring />

<#assign titleString><@spring.message "label.home"/></#assign>

<#assign content>
<h1><@spring.message "label.welcome.home.page"/></h1>
<p><@spring.message "label.info.user.persisted"/></p> 
<p>${user}</p>
</#assign>

<#include "wrapper.ftl" />