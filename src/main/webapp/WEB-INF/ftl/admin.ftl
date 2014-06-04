<#import "/spring.ftl" as spring />

<#assign titleString><@spring.message "label.admin"/></#assign>

<#assign content>
<h1><@spring.message "label.welcome.admin.page"/></h1>
<p><@spring.message "label.info.admin.can.see.users"/></p>

<table>
<#list users as u>
	<tr>
		<td>${u.id}</td>
		<td>${u.name}</td>
		<td>${u.address}</td>
	</tr>
</#list>
</table>
</#assign>

<#include "wrapper.ftl" />
