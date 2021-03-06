<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 25/04/2022
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>

<%@include file="AdminHeader.jsp" %>

<div class="content-header">
    <div>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="#">Home</a></li>
                <li class="breadcrumb-item"><a href="#">Pages</a></li>
                <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
            </ol>
        </nav>
        <h4 class="content-title content-title-xs">Dashboard, Charts and Analytics</h4>
    </div>
</div>
<!-- content-header -->
<div class="content-body">
    <div class="stat-profile">
        <div class="stat-profile-body">
            <div class="row row-xs">
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-primary-light">
                        <h1 class="tx-light tx-sans tx-spacing--4 tx-primary mg-b-5">${util.unmilledBatches}</h1>
                        <p class="tx-13 tx-lg-14 tx-color-02 mg-b-0">Harvests to be Milled</p>
                    </div>
                </div>
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-teal-light">
                        <h1 class="mg-b-5 tx-sans tx-spacing--2 tx-light tx-teal">${util.milledBatches}</h1>
                        <p class="tx-13 tx-lg-14 tx-color-03 mg-b-0">Milled Harvests</p>
                    </div>
                </div>
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-pink-light">
                        <h1 class="mg-b-5 tx-sans tx-spacing--2 tx-light tx-pink">${util.month}</h1>
                        <p class="tx-13 tx-lg-14 tx-color-03 mg-b-0">Current Batch Month</p>
                    </div>
                </div>
                <hr class="hr-component-section"/>
            </div><!-- row -->
            <div class="row row-xs">
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-primary-light">
                        <h1 class="tx-light tx-sans tx-spacing--4 tx-primary mg-b-5">${millingProduct.palmOilCan}</h1>
                        <p class="tx-13 tx-lg-14 tx-color-02 mg-b-0">Palm Oil (Cans)</p>
                    </div>
                </div>
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-teal-light">
                        <h1 class="mg-b-5 tx-sans tx-spacing--2 tx-light tx-teal">${millingProduct.fibreOilCan}</h1>
                        <p class="tx-13 tx-lg-14 tx-color-03 mg-b-0">Fibre Oil (Cans)</p>
                    </div>
                </div>
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-pink-light">
                        <h1 class="mg-b-5 tx-sans tx-spacing--2 tx-light tx-pink">${millingProduct.palmOilDrum}</h1>
                        <p class="tx-13 tx-lg-14 tx-color-03 mg-b-0">Palm Oil (Drums)</p>
                    </div>
                </div>
            </div><!-- row -->
            <div class="row row-xs">
                <fmt:setLocale value="en_NG"/>
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-primary-light">
                        <h1 class="tx-light tx-sans tx-spacing--4 tx-primary mg-b-5"><fmt:formatNumber value = "${util.totalIncome}" type = "currency"/></h1>
                        <p class="tx-13 tx-lg-14 tx-color-02 mg-b-0">Total Income</p>
                    </div>
                </div>
                <div class="col">

                        <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-teal-light">
                 <h1 class="mg-b-5 tx-sans tx-spacing--2 tx-light tx-pink"><fmt:formatNumber value = "${util.totalHarvestStockCost}" type = "currency"/></h1>
                        <p class="tx-13 tx-lg-14 tx-color-03 mg-b-0">Total Harvest Stock Cost</p>
                    </div>
                </div>
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-pink-light">
                 <h1 class="mg-b-5 tx-sans tx-spacing--2 tx-light tx-pink">${stockRemaining}</h1>
                        <p class="tx-13 tx-lg-14 tx-color-03 mg-b-0">Total Stock left</p>
                    </div>
                </div>
            </div><!-- row -->          <div class="row row-xs">
                <fmt:setLocale value="en_NG"/>
            <div class="col">
                <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-primary-light">
                    <h1 class="tx-light tx-sans tx-spacing--4 tx-primary mg-b-5"><fmt:formatNumber value = "${util.totalExpenses}" type = "currency"/></h1>
                    <p class="tx-13 tx-lg-14 tx-color-02 mg-b-0">Total Expenses (excluding harvest stock purchase)</p>
                </div>
            </div>
                <div class="col">

                        <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-teal-light">
                 <h1 class="mg-b-5 tx-sans tx-spacing--2 tx-light tx-pink"><fmt:formatNumber value = "${util.profitOrLoss}" type = "currency"/></h1>
                        <p class="tx-13 tx-lg-14 tx-color-03 mg-b-0">Profit / Loss</p>
                    </div>
                </div>
                <div class="col">
                    <div class="card card-body pd-10 pd-md-15 bd-0 shadow-none bg-pink-light">
                 <h1 class="mg-b-5 tx-sans tx-spacing--2 tx-light tx-pink"><fmt:formatNumber value = "${util.profitMargin}" type = "percent"/></h1>
                        <p class="tx-13 tx-lg-14 tx-color-03 mg-b-0">Profit Margin</p>
                    </div>
                </div>
            </div><!-- row -->
        </div><!-- stat-profile-body -->
    </div><!-- stat-profile -->
    <div class="row">
        <div class="col">
            <label class="chart-label col-form-label-lg" for="expenseCategoryPlot">Expense vs Category</label>
            <canvas class="col" id="expenseCategoryPlot"></canvas>
        </div>
        <div class="col">
            <label class="chart-label col-form-label-lg" for="harvestAndStock">Batches vs Harvest Stock</label>

            <canvas class="col" id="harvestAndStock"></canvas>
        </div>
    </div>
    <div class="row">
        <div class="col">

            <canvas class="col" id="incomeVsSource"></canvas>
        </div>


        <div class="col">
            <canvas class="col" id="chart2"></canvas>
        </div>
    </div>


    <script>
        let jsonfile =
        ${incomeCostPlot}

        const labels = jsonfile.map(function (e) {
            return e.x;
        });
        const data = jsonfile.map(function (e) {
            return e.y;
        });

        const ctx = document.getElementById('incomeVsSource').getContext('2d');
        const config = {
            type: 'line',
            data: {
                labels: labels,
                datasets: [{
                    label: 'Income vs Source',
                    data: data,
                    backgroundColor: 'rgba(29,152,213,0.3)'
                }]
            }
        };

        const chart = new Chart(ctx, config);
    </script>
    <script>
        let jsonfile2 =
        ${incomeDatePlot}

        const labels2 = jsonfile2.map(function (e) {
            return e.x;
        });
        const data2 = jsonfile2.map(function (e) {
            return e.y;
        });

        const ctx2 = document.getElementById('chart2').getContext('2d');
        const config2 = {
            type: 'line',
            data: {
                labels: labels2,
                datasets: [{
                    label: 'Income vs Date',
                    data: data2,
                    backgroundColor: 'rgba(0, 119, 204, 0.3)'
                }]
            }
        };

        const chart2 = new Chart(ctx2, config2);
    </script>
    <script>
        let jsonfile3 = ${expenseCategoryPlot}

        const labels3 = jsonfile3.map(function (e) {
            return e.x;
        });
        const data3 = jsonfile3.map(function (e) {
            return e.y;
        });
        var coloR = [];

        var dynamicColors = function() {
            var r = Math.floor(Math.random() * 255);
            var g = Math.floor(Math.random() * 255);
            var b = Math.floor(Math.random() * 255);
            return "rgb(" + r + "," + g + "," + b + ")";
        };

        for (var i in data3 ) {

            coloR.push(dynamicColors());
        }
        const ctx3 = document.getElementById('expenseCategoryPlot').getContext('2d');
        const config3 = {
            type: 'pie',
            data: {
                labels: labels3,
                datasets: [{
                    label: 'Expense Categories',
                    data: data3,
                    backgroundColor: coloR,

                    borderColor: 'rgba(200, 200, 200, 0.75)',
                    hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
                    hoverBorderColor: 'rgba(200, 200, 200, 1)',
                }]
            }
        };

        const chart3 = new Chart(ctx3, config3);
    </script>
    <script>
        let jsonfile4 = ${harvestAndStock}

        const labels4 = jsonfile4.map(function (e) {
            return e.x;
        });
        const data4 = jsonfile4.map(function (e) {
            return e.y;
        });
        var coloR = [];

        var dynamicColors = function() {
            var r = Math.floor(Math.random() * 255);
            var g = Math.floor(Math.random() * 255);
            var b = Math.floor(Math.random() * 255);
            return "rgb(" + r + "," + g + "," + b + ")";
        };

        for (var i in data4 ) {

            coloR.push(dynamicColors());
        }
        const ctx4 = document.getElementById('harvestAndStock').getContext('2d');
        const config4 = {
            type: 'pie',
            data: {
                labels: labels4,
                datasets: [{
                    label: 'Expense Categories',
                    data: data4,
                    backgroundColor: coloR,
                    borderColor: 'rgba(200, 200, 200, 0.75)',
                    hoverBackgroundColor: 'rgba(200, 200, 200, 1)',
                    hoverBorderColor: 'rgba(200, 200, 200, 1)',
                }]
            }
        };
        const chart4 = new Chart(ctx4, config4);
    </script>

</div>
<!-- content-body -->
</div><!-- content -->
<%@include file="AdminFooter.jsp" %>

