<#macro masterTemplate title="Welcome">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>${title} | MiniBudget</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle"
                    data-toggle="collapse" data-target="#example-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="/">Bütçeni Bil</a>
        </div>

        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <#if user??>
                    <li><a href="/">Hoşgeldiniz</a></li>
                    <li><a href="/allProcess">Net Durum Tablom</a></li>
                    <li><a href="/logout">Çıkış Yap [${user.name}]</a></li>
                <#else>
                    <li><a href="/register">Kayıt Ol</a></li>
                    <li><a href="/login">Giriş Yap</a></li>
                </#if>
            </ul>
        </div>
    </nav>

    <div class="container">
        <#nested />
    </div>

    <footer class="footer">
        <p>MiniBudget &mdash; A Spark-Java Application - Develop By nirayaslan</p>
    </footer>
</div><!-- /container -->
</body>
</html>
</#macro>