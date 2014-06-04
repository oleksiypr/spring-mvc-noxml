<#import "/spring.ftl" as spring />
<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"] />

<#assign pageInnards>
 <div class="wrap">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
	    	<div class="container-fluid">
	        	<div class="nav-collapse collapse">
	        		<@sec.authorize access="isAuthenticated()">
	        		<p class="navbar-text pull-right">
              			<a class="navbar-link" href="<@spring.url "/logout"/>"><@spring.message "label.logout"/></a>
            		</p>
            		</@sec.authorize>
            		
		            <ul class="nav">
		            	<li class="active"><a href="<@spring.url "/home"/>"><@spring.message "label.home"/></a></li>
		              	<#if user?exists>
		              		<li><a href="<@spring.url "/user/${user.id!}"/>"><@spring.message "label.user"/></a></li>
		              	</#if>	
		              	<li><a href="<@spring.url "/admin"/>"><@sec.authorize access="hasRole('ROLE_ADMIN')"><@spring.message "label.admin"/></@sec.authorize></a></li>
		            </ul>
	        	</div>
	    	</div>
		</div>
	</div>

	<div class="row">
    	<div class="container">
        	<div class="span12">
		  		<div class="hero-unit">${content}</div>
	    	</div>
		</div>
	</div>
</div>
</#assign>

<#include "wrapper-head.ftl" />