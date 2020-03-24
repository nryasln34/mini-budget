<#import "masterTemplate.ftl" as layout />
<#setting number_format="computer">
<@layout.masterTemplate title="Kişisel Finans Takip Sistemi">

    <div class="row">
      <label><b>GİDER TABLOM</b></label><br>
        <#list expenses as expense>
            ${expense.amount} ${expense.currency} ${expense.type} <br>
        </#list>

        <label><b>GELİR TABLOM</b></label><br>
        <#list incomes as income>
            ${income.amount} ${income.currency} ${income.type} <br>
        </#list>
    </div>


    <h3>${fromDate} ile ${toDate} arasındaki gelir-gider grafikleriniz;</h3>
    <h3>TOPLAM GELİR: ${totalIncomeAmount}</h3>
    <h3>TOPLAM GİDER: ${totalExpenseAmount}</h3>
    <div class="row">
        <canvas id="myChart" width="400" height="400"></canvas>
        <script>
            var ctx = document.getElementById('myChart').getContext('2d');
            var myChart = new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: ['Gider', 'Gelir'],
                    datasets: [{
                        label: '# of Votes',
                        data: [parseInt(${totalExpenseAmount}), parseInt(${totalIncomeAmount})],
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)'
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
        </script>
    </div>

</@layout.masterTemplate>