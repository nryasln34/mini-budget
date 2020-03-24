<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Kişisel Finans Takip Sistemi">

<div class="row">
    <div class="col-xs-11">
        <h3>${pageTitle}</h3>

        <#if user??>
            <#if pageTitle != 'Dashboard'>
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">Bugün ne kazandın ${user.name}?</h3>
                    </div>

                    <div class="panel-body">
                        <form class="form-horizontal" action="/addIncome" method="post">
                            <div class="input-group">
                                <input type="text" name="amount" class="form-control" placeholder="amount" required/>
                                <input type="text" name="currency" class="form-control" placeholder="currency" required/>
<#--                                <input type="text" name="type" class="form-control" placeholder="type" required/>-->
                                <label for="type">Choose a type:</label>
                                <select id="type" name="type">
                                    <#list incomeEnum as item>
                                        <option value="${item}">${item}</option>
                                    </#list>
                                </select>
                                <input type="text" name="note" class="form-control" placeholder="note" required/>
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit"> Insert </button>
                                </span>
                            </div>
                        </form>
                    </div>
                </div>
            </#if>
        </#if>


        <#if user??>
            <#if pageTitle != 'Dashboard'>
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">Bugün ne harcadın ${user.name}?</h3>
                    </div>

                    <div class="panel-body">
                        <form class="form-horizontal" action="/addExpense" method="post">
                            <div class="input-group">
                                <input type="text" name="amount" class="form-control" placeholder="amount" required/>
                                <input type="text" name="currency" class="form-control" placeholder="currency" required/>
<#--                                <input type="text" name="type" class="form-control" placeholder="type" required/>-->
                                <label for="type">Choose a type:</label>
                                <select id="type" name="type">
                                    <#list expenseEnum as item>
                                        <option value="${item}">${item}</option>
                                    </#list>
                                </select>
                                <input type="text" name="note" class="form-control" placeholder="note" required/>
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit"> Insert </button>
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
            <#if incomes??>
                <#list incomes as income>
                    <hr/>

                    <div class="media">
                        <a class="pull-left" href="/t/${income.username}">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">
                                <a href="/t/${income.username}">
                                ${income.username}
                                </a>
                            </h4>

                            <small>&mdash; ${income.amount}</small>
                            <small>&mdash; ${income.type}</small>

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

    <div class="col-xs-11">
        <div id="media-list" class="row">
            <#if expenses??>
                <#list espenses as expense>
                    <hr/>

                    <div class="media">
                        <a class="pull-left" href="/t/${expense.username}">
                        </a>
                        <div class="media-body">
                            <h4 class="media-heading">
                                <a href="/t/${expense.username}">
                                    ${expense.username}
                                </a>
                            </h4>

                            <small>&mdash; ${expense.amount}</small>
                            <small>&mdash; ${expense.type}</small>

                        </div>
                    </div>
                <#else>
                    <hr/>
                  <#--  <div class="well">
                        Keep your money in your pocket
                    </div>-->
                </#list>
            <#else>
                <hr/>
               <#-- <div class="well">
                    Keep your money in your pocket
                </div>-->
            </#if>
        </div>
    </div>

</div>

</@layout.masterTemplate>