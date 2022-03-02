
var ChartsAmcharts = function(ShopMapForBarCharts) {
	
    var initChartSample1 = function(ShopMapForBarCharts) {
    	var dataProvider = {
    		    data: []
    		};
    	
    	for (var key in ShopMapForBarCharts) {
    	    if (ShopMapForBarCharts.hasOwnProperty(key)) {
    	    	dataProvider.data.push({
        			"ShopName": key,
        			"Total": ShopMapForBarCharts[key]
        		})
    	    }
    	}
    	
    	
        var chart = AmCharts.makeChart("chart_1", {
            "type": "serial",
            "theme": "light",
            "pathToImages": Metronic.getGlobalPluginsPath() + "amcharts/amcharts/images/",
            "autoMargins": false,
            "marginLeft": 30,
            "marginRight": 8,
            "marginTop": 10,
            "marginBottom": 26,

            "fontFamily": 'Open Sans',            
            "color":    '#888',
            
            "dataProvider": dataProvider.data,
            	
            "valueAxes": [{
                "axisAlpha": 0,
                "position": "left"
            }],
            "startDuration": 1,
            "graphs": [{
                "alphaField": "alpha",
                "balloonText": "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b></span>",
                "fillAlphas": 1,
                "title": "Amount",
                "type": "column",
                "valueField": "Total"
            }],
            "categoryField": "ShopName",
            "categoryAxis": {
                "gridPosition": "start",
                "axisAlpha": 0,
                "tickLength": 0
            }
        });

        $('#chart_1').closest('.portlet').find('.fullscreen').click(function() {
            chart.invalidateSize();
        });
    }

    var initChartSample6 = function(ShopMapForBarCharts) {
    	var dataProvider = {
    		    data: []
    		};
    	
    	for (var key in ShopMapForBarCharts) {
    	    if (ShopMapForBarCharts.hasOwnProperty(key)) {
    	    	dataProvider.data.push({
        			"ShopName": key,
        			"Total": ShopMapForBarCharts[key]
        		})
    	    }
    	}
    	
        var chart = AmCharts.makeChart("chart_6", {
            "type": "pie",
            "theme": "light",

            "fontFamily": 'Open Sans',
            
            "color":    '#888',

            "dataProvider": dataProvider.data,
            	
            "valueField": "Total",
            "titleField": "ShopName",
            "exportConfig": {
                menuItems: [{
                    icon: Metronic.getGlobalPluginsPath() + "amcharts/amcharts/images/export.png",
                    format: 'png'
                }]
            }
        });

        $('#chart_6').closest('.portlet').find('.fullscreen').click(function() {
            chart.invalidateSize();
        });
    }

    return {
        //main function to initiate the module

        init: function(ShopMapForBarCharts) {

            initChartSample1(ShopMapForBarCharts);
            initChartSample6(ShopMapForBarCharts);
        }

    };

}();