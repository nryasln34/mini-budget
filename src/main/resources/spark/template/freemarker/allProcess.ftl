<#import "masterTemplate.ftl" as layout />

<@layout.masterTemplate title="Kişisel Finans Takip Sistemi">

    <div class="row">
        <#list expenses as expense>
            ${expense.amount} ${expense.currency} <br>
        </#list>
    </div>

</@layout.masterTemplate>