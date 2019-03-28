var prefix = "/sys/table";
$(function () {
    loadProvince();
    loadCity();
    loadTotal();
    $('#exampleTable-city').find('tr');
    console.log($('#exampleTable-city').find('tr').html());
});

function loadProvince() {
    $('#exampleTable-province').bootstrapTable({
        method: 'get', // 服务器数据的请求方式 get or post
        url: prefix + "/countPro", // 服务器数据的加载地址
        //	showRefresh : true,
        //	showToggle : true,
        //	showColumns : true,
        iconSize: 'outline',
        align: 'center',
        // toolbar: '#exampleToolbar1',
        // striped: true, // 设置为true会有隔行变色效果
        dataType: "json", // 服务器返回的数据类型
        // pagination: true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // //设置为limit则会发送符合RESTFull格式的参数
        singleSelect: false, // 设置为true将禁止多选
        // contentType : "application/x-www-form-urlencoded",
        // //发送到服务器的数据编码类型
        pageSize: 10, // 如果设置了分页，每页数据条数
        pageNumber: 1, // 如果设置了分布，首页页码
        //search : true, // 是否显示搜索框
        showColumns: false, // 是否显示内容下拉框（选择显示的列）
        // sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        columns: [
            {
                field: 'name',
                title: '工作省份',
                align: 'center'
            },
            {
                field: 'male',
                title: '男生(人)',
                align: 'center'
            },
            {
                field: 'female',
                title: '女生(人)',
                align: 'center'
            },
            {
                field: 'maleRate',
                title: '男生占比(%)',
                align: 'center',
                formatter: function (value) {
                    return value + "%";
                }
            },
            {
                field: 'femaleRate',
                title: '女生占比(%)',
                align: 'center',
                formatter: function (value) {
                    return value + "%";
                }
            },
            {
                field: 'total',
                title: '总人数(人)',
                align: 'center'
            }
        ]
    });
}

function loadCity() {
    $('#exampleTable-city').bootstrapTable({
        method: 'get', // 服务器数据的请求方式 get or post
        url: prefix + "/countCity", // 服务器数据的加载地址
        //	showRefresh : true,
        //	showToggle : true,
        //	showColumns : true,
        iconSize: 'outline',
        align: 'center',
        // toolbar: '#exampleToolbar1',
        // striped: true, // 设置为true会有隔行变色效果
        dataType: "json", // 服务器返回的数据类型
        // pagination: true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // //设置为limit则会发送符合RESTFull格式的参数
        singleSelect: false, // 设置为true将禁止多选
        // contentType : "application/x-www-form-urlencoded",
        // //发送到服务器的数据编码类型
        pageSize: 10, // 如果设置了分页，每页数据条数
        pageNumber: 1, // 如果设置了分布，首页页码
        //search : true, // 是否显示搜索框
        showColumns: false, // 是否显示内容下拉框（选择显示的列）
        // sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        columns: [
            {
                field: 'name',
                title: '工作城市',
                align: 'center',
            },
            {
                field: 'male',
                title: '男生(人)',
                align: 'center'
            },
            {
                field: 'female',
                title: '女生(人)',
                align: 'center'
            },
            {
                field: 'maleRate',
                title: '男生占比(%)',
                align: 'center',
                formatter: function (value) {
                    return value + "%";
                }
            },
            {
                field: 'femaleRate',
                title: '女生占比(%)',
                align: 'center',
                formatter: function (value) {
                    return value + "%";
                }
            },
            {
                field: 'total',
                title: '总人数(人)',
                align: 'center'
            }
        ]
    });
    $('#exampleTable-city').find('tr').hide()
}

function loadTotal() {
    $('#exampleTable-total').bootstrapTable({
        method: 'get', // 服务器数据的请求方式 get or post
        url: prefix + "/count", // 服务器数据的加载地址
        //	showRefresh : true,
        //	showToggle : true,
        //	showColumns : true,
        iconSize: 'outline',
        align: 'center',
        // toolbar: '#exampleToolbar1',
        // striped: true, // 设置为true会有隔行变色效果
        dataType: "json", // 服务器返回的数据类型
        // pagination: true, // 设置为true会在底部显示分页条
        // queryParamsType : "limit",
        // //设置为limit则会发送符合RESTFull格式的参数
        singleSelect: false, // 设置为true将禁止多选
        // contentType : "application/x-www-form-urlencoded",
        // //发送到服务器的数据编码类型
        pageSize: 10, // 如果设置了分页，每页数据条数
        pageNumber: 1, // 如果设置了分布，首页页码
        //search : true, // 是否显示搜索框
        showColumns: false, // 是否显示内容下拉框（选择显示的列）
        // sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
        columns: [
            {
                field: 'male',
                title: '男生(人)',
                align: 'center'
            },
            {
                field: 'female',
                title: '女生(人)',
                align: 'center'
            },
            {
                field: 'maleRate',
                title: '男生占比(%)',
                align: 'center',
                formatter: function (value) {
                    return value + "%";
                }
            },
            {
                field: 'femaleRate',
                title: '女生占比(%)',
                align: 'center',
                formatter: function (value) {
                    return value + "%";
                }
            },
            {
                field: 'total',
                title: '总人数(人)',
                align: 'center'
            }
        ]
    });
}


