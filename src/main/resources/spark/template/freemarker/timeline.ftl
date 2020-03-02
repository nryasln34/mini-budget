<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Dashbboard">

<div class="row">
    <div class="col-xs-11">
        <h3>${pageTitle}</h3>

        <#if user??>
            <#if pageTitle != 'Dashboard'>
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">What's on your mind ${user.name}?</h3>
                    </div>

                    <div class="panel-body">
                        <form class="form-horizontal" action="/message" method="post">
                            <div class="input-group">
                                <input type="text" name="text" class="form-control" required/>
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit"> Share </button>
                                </span>
                            </div>
                        </form>
                    </div>
                </div>
            </#if>
        </#if>
    </div>
</div>

<div class="row">
    <div class="col-xs-11">
        <div id="media-list" class="row">
            <#if messages??>
                <#list messages as message>
                    <hr/>

                    <div class="media">
                        <a class="pull-left" href="/t/${message.username}">
                            <img class="media-object" src="${message.gravatar}"/>
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">
                                <a href="/t/${message.username}">
                                ${message.username}
                                </a>
                            </h4>

                        ${message.text} <br/>

                            <small>&mdash; ${message.pubDateStr}</small>
                        </div>
                    </div>
                <#else>
                    <hr/>
                    <div class="well">
                        Keep your money in your pocket
                    </div>
                </#list>
            <#else>
                <hr/>
                <div class="well">
                      Keep your money in your pocket
                </div>
            </#if>
        </div>
    </div>
</div>

</@layout.masterTemplate>