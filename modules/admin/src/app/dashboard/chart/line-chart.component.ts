import { Component, ViewEncapsulation } from '@angular/core';

import { LineChartService } from './line-chart.service';
import { Input } from '@angular/core/src/metadata/directives';
import { DashboardService } from '../dashboard.service';

@Component({
    selector: 'line-chart',
    encapsulation: ViewEncapsulation.None,
    styleUrls: ['./line-chart.scss'],
    templateUrl: './line-chart.html'
})
export class LineChart {
    @Input()
    chartType: string;

    @Input()
    dashboardTypeRid: string;

    showAllBtn: boolean = false;
    //  Chart type where can use "Show all" button
    showAllBtnList: Array<string> = ['Serial chart'];
    chartData: Object;
    chart: any;

    constructor(private _lineChartService: LineChartService,
                private dashboardService: DashboardService) {
    }

    ngOnInit() {
        this.chartData = this._lineChartService.getData(this.chartType, []);

        let showAll = this.showAllBtnList['find']((element) => {
            if (this.chartType === element) {
                return true;
            } else {
                return false;
            }
        });

        if (showAll) {
            this.showAllBtn = true;
        }
    };

    initChart(chart: any) {
        this.chart = chart;

        let zoomChart = () => {
            // chart.zoomToDates(new Date(2013, 3), new Date(2014, 0));
        };

        chart.addListener('rendered', zoomChart);
        zoomChart();

        if (chart.zoomChart) {
            chart.zoomChart();
        }

        /*
        //  Update data after load data from DB
        this.chart.dataProvider = res;
        this.chart.validateData();*/
    }

    public showAll() {
        this.chart.zoomOut();
    }
}
