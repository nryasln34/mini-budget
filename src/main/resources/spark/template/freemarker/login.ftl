<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Sign In">
    <#if message??>
    	<div class="alert alert-success">
    		${message}
    	</div>
    </#if>
    <#if error??>
    	<div class="alert alert-danger">
    		<strong>Error:</strong> ${error}
    	</div>
    </#if>

    <h3>Sign In</h3>

    <form class="form-horizontal" action="/login" role="form" method="post">

        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email: </label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="email" id="email" placeholder="Email" value="${email!}" />
            </div>
        </div>

        <div class="form-group">
            <label for="userPassword" class="col-sm-2 control-label">Password: </label>
            <div class="col-sm-10">
                <input type="password" class="form-control" name="password" placeholder="Password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Sign In</button>
            </div>
        </div>

	 </form>
</@layout.masterTemplate>