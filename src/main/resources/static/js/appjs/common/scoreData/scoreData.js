
var prefix = "/common/scoreData";
$(function() {
	load();
});

function load() {
	$('#exampleTable')
			.bootstrapTable({
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
                                dataId:$('#dataId').val(),
                                dataTime:$('#dataTime').val(),
                                dataTable:$('#dataTable').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
								{
									field : 'dataId', 
									title : '数据ID',
                                    width: 160,
								},
								{
									field : 'dataStatus',
									title : '数据状态',
									width: 100,
                                    visible:false
								},
								{
									field : 'dataTime', 
									title : '数据时间',
                                    width: 100,
									visible:false
								},
								{
									field : 'dataTable', 
									title : '数据HTML',
									width: 800
								},
								{
									title : '操作',
									field : 'id',
									align : 'center',
                                    width: 100,
									formatter : function(value, row) {
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.dataId
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="解析"  mce_href="#" onclick="resetPwd(\''
												+ row.dataId
												+ '\')"><i class="fa fa-futbol-o"></i></a> ';
										if(row.dataStatus==0){
											return f+d;
										}else if(row.dataStatus==1){
                                            return d;
										}
									}
								} ]
					});
}

function reLoad() {
    var opt = {
        queryParams: function (params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                offset: params.offset,
                workId: $('#workId').val(),
                department: $('#department').val(),
                workProvince: $('#workProvince').val(),
                workCity: $('#workCity').val()
            };
        }
    };
    // load();
    $("#exampleTable").bootstrapTable('refreshOptions', {pageNumber: 1});
    $('#exampleTable').bootstrapTable('refresh', opt);
}
function add() {
   var index= layer.open({
		type : 2,
        area : [ '100%', '100%' ],
		shadeClose : false, // 点击遮罩关闭层
		content : prefix + '/add' // iframe的url
	});
    layer.full(index);
}
function edit(id) {
    var index = layer.open({
        type : 2,
        area : [ '100%', '100%' ],
        shadeClose : false, // 点击遮罩关闭层
        content : prefix + '/edit/' + id // iframe的url
    });
    layer.full(index);
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'dataId' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id){
    $.ajax({
        type : 'POST',
        data : {
            "dataId" : id
        },
        url : prefix + '/resolve',
        success : function(r) {
            if (r.code == 0) {
                layer.msg(r.msg);
                reLoad();
            } else {
                layer.msg(r.msg);
            }
        }
    });
}


//重置搜索
function resetSearch() {
    $('#query-form').find('[name]').each(function () {
        $(this).val('');
    });
    reLoad();
}

function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['dataId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}