var prefix = "/common/dsScoreMatch"
$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method: 'get', // 服务器数据的请求方式 get or post
                url: prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize: 'outline',
                toolbar: '#exampleToolbar',
                striped: false, // 设置为true会有隔行变色效果
                dataType: "json", // 服务器返回的数据类型
                pagination: true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect: false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize: 15, // 如果设置了分页，每页数据条数
                pageNumber: 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns: false, // 是否显示内容下拉框（选择显示的列）
                sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams: function (params) {
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset: params.offset,
                        selection: $('#selection').val(),
                        startTime: $('#startTime').val(),
                        overScore: $('#overScore').val(),
                        halfScore: $('#halfScore').val(),
                        letBall: $('#letBall').val(),
                        sizeBall: $('#sizeBall').val(),
                        cornerBall: $('#cornerBall').val(),
                        halfCorner: $('#halfCorner').val(),
                        overCorner: $('#overCorner').val(),

                        match: $('#match').val(),
                        hostTeam: $('#hostTeam').val(),
                        hostRank: $('#hostRank').val(),
                        hostRed: $('#hostRed').val(),
                        hostYellow: $('#hostYellow').val(),
                        guestTeam: $('#guestTeam').val(),
                        guestRank: $('#guestRank').val(),
                        guestRed: $('#guestRed').val(),
                        guestYellow: $('#guestYellow').val()

                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns: [
                    {
                        field: 'id',
                        title: '主键'
                    },
                    {
                        field: 'match',
                        title: '赛事',
                        formatter: function (value, row) {
                            return '<span class=' + row.matchBg + '>' + value + '</span>';
                        }
                    },
                    {
                        field: 'selection',
                        title: '精选'
                    },
                    {
                        field: 'startTime',
                        title: '开赛时间'
                    },
                    {
                        field: 'hostTeam',
                        title: '主队',
                        formatter: function (value, row) {
                            var a = '<span class=redCard>' + row.hostRed + '</span><span class=yellowCard>' + row.hostYellow + '</span><span class=leagueRank>' + row.hostRank + '</span>' + value;
                            var b = '<span class=redCard>' + row.hostRed + '</span><span class=yellowCard>' + row.hostYellow + '</span>' + value;
                            var c = '<span class=redCard>' + row.hostRed + '</span><span class=leagueRank>' + row.hostRank + '</span>' + value;

                            var d = '<span class=yellowCard>' + row.hostYellow + '</span><span class=leagueRank>' + row.hostRank + '</span>' + value;
                            var e = '<span class=redCard>' + row.hostRed + '</span>' + value;
                            var f = '<span class=yellowCard>' + row.hostYellow + '</span>' + value;
                            var g = '<span class=leagueRank>' + row.hostRank + '</span>' + value;
                            var h = value;
                            if (row.hostRed != null && row.hostYellow != null && row.hostRank != null) {
                                return a;
                            }
                            if (row.hostRed != null && row.hostYellow != null && row.hostRank == null) {
                                return b;
                            }
                            if (row.hostRed != null && row.hostYellow == null && row.hostRank != null) {
                                return c;
                            }
                            if (row.hostRed == null && row.hostYellow != null && row.hostRank != null) {
                                return d;
                            }
                            if (row.hostRed != null && row.hostYellow == null && row.hostRank == null) {
                                return e;
                            }
                            if (row.hostRed == null && row.hostYellow != null && row.hostRank == null) {
                                return f;
                            }
                            if (row.hostRed == null && row.hostYellow == null && row.hostRank != null) {
                                return g;
                            }
                            if (row.hostRed == null && row.hostYellow == null && row.hostRank == null) {
                                return h;
                            }
                        }
                    },
                    // {
                    //     field: 'hostRank',
                    //     title: '主队排名'
                    // },
                    // {
                    //     field: 'hostRed',
                    //     title: '主队红牌'
                    // },
                    // {
                    //     field: 'hostYellow',
                    //     title: '主队黄牌'
                    // },
                    {
                        field: 'overScore',
                        title: '全场比分'
                    },
                    {
                        field: 'guestTeam',
                        title: '客队',
                        formatter: function (value, row) {
                            var a = value + '<span class=redCard>' + row.guestRed + '</span><span class=yellowCard>' + row.guestYellow + '</span><span class=leagueRank>' + row.guestRank + '</span>';
                            var b = value + '<span class=redCard>' + row.guestRed + '</span><span class=yellowCard>' + row.guestYellow + '</span>';
                            var c = value + '<span class=redCard>' + row.guestRed + '</span><span class=leagueRank>' + row.guestRank + '</span>';

                            var d = value + '<span class=yellowCard>' + row.guestYellow + '</span><span class=leagueRank>' + row.guestRank + '</span>';
                            var e = value + '<span class=redCard>' + row.guestRed + '</span>';
                            var f = value + '<span class=yellowCard>' + row.guestYellow + '</span>';
                            var g = value + '<span class=leagueRank>' + row.guestRank + '</span>';
                            var h = value;
                            if (row.guestRed != null && row.guestYellow != null && row.guestRank != null) {
                                return a;
                            }
                            if (row.guestRed != null && row.guestYellow != null && row.guestRank == null) {
                                return b;
                            }
                            if (row.guestRed != null && row.guestYellow == null && row.guestRank != null) {
                                return c;
                            }
                            if (row.guestRed == null && row.guestYellow != null && row.guestRank != null) {
                                return d;
                            }
                            if (row.guestRed != null && row.guestYellow == null && row.guestRank == null) {
                                return e;
                            }
                            if (row.guestRed == null && row.guestYellow != null && row.guestRank == null) {
                                return f;
                            }
                            if (row.guestRed == null && row.guestYellow == null && row.guestRank != null) {
                                return g;
                            }
                            if (row.guestRed == null && row.guestYellow == null && row.guestRank == null) {
                                return h;
                            }
                        }
                    },
                    // {
                    //     field: 'guestRank',
                    //     title: '客队排名'
                    // },
                    // {
                    //     field: 'guestRed',
                    //     title: '客队红牌'
                    // },
                    // {
                    //     field: 'guestYellow',
                    //     title: '客队黄牌'
                    // },
                    {
                        field: 'halfScore',
                        title: '半场比分'
                    },
                    {
                        field: 'letBall',
                        title: '初让球'
                    },
                    {
                        field: 'sizeBall',
                        title: '初大小球'
                    },
                    {
                        field: 'cornerBall',
                        title: '初角球'
                    },
                    {
                        field: 'halfCorner',
                        title: '半场角球比分'
                    },
                    {
                        field: 'overCorner',
                        title: '全场角球比分'
                    },
                    {
                        field: 'matchTime',
                        title: '赛事日期时间'
                    }
                    // 								{
                    // 	title : '操作',
                    // 	field : 'id',
                    // 	align : 'center',
                    // 	formatter : function(value, row, index) {
                    // 		var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
                    // 				+ row.id
                    // 				+ '\')"><i class="fa fa-edit"></i></a> ';
                    // 		var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                    // 				+ row.id
                    // 				+ '\')"><i class="fa fa-remove"></i></a> ';
                    // 		var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                    // 				+ row.id
                    // 				+ '\')"><i class="fa fa-key"></i></a> ';
                    // 		return e + d ;
                    // 	}
                    // }
                ]
            });
}

function reLoad() {
    var opt = {
        queryParams: function (params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                offset: params.offset,
                selection: $('#selection').val(),
                startTime: $('#startTime').val(),
                overScore: $('#overScore').val(),
                halfScore: $('#halfScore').val(),
                letBall: $('#letBall').val(),
                sizeBall: $('#sizeBall').val(),
                cornerBall: $('#cornerBall').val(),
                halfCorner: $('#halfCorner').val(),
                overCorner: $('#overCorner').val(),

                match: $('#match').val(),
                hostTeam: $('#hostTeam').val(),
                hostRank: $('#hostRank').val(),
                hostRed: $('#hostRed').val(),
                hostYellow: $('#hostYellow').val(),
                guestTeam: $('#guestTeam').val(),
                guestRank: $('#guestRank').val(),
                guestRed: $('#guestRed').val(),
                guestYellow: $('#guestYellow').val()
            };
        }
    };
    // load();
    $("#exampleTable").bootstrapTable('refreshOptions', {pageNumber: 1});
    $('#exampleTable').bootstrapTable('refresh', opt);
}

//重置搜索
function resetSearch() {
    $('#query-form').find('[name]').each(function () {
        $(this).val('');
    });
    reLoad();
}


// function add() {
// 	layer.open({
// 		type : 2,
// 		title : '增加',
// 		maxmin : true,
// 		shadeClose : false, // 点击遮罩关闭层
// 		area : [ '800px', '520px' ],
// 		content : prefix + '/add' // iframe的url
// 	});
// }
// function edit(id) {
// 	layer.open({
// 		type : 2,
// 		title : '编辑',
// 		maxmin : true,
// 		shadeClose : false, // 点击遮罩关闭层
// 		area : [ '800px', '520px' ],
// 		content : prefix + '/edit/' + id // iframe的url
// 	});
// }
// function remove(id) {
// 	layer.confirm('确定要删除选中的记录？', {
// 		btn : [ '确定', '取消' ]
// 	}, function() {
// 		$.ajax({
// 			url : prefix+"/remove",
// 			type : "post",
// 			data : {
// 				'id' : id
// 			},
// 			success : function(r) {
// 				if (r.code==0) {
// 					layer.msg(r.msg);
// 					reLoad();
// 				}else{
// 					layer.msg(r.msg);
// 				}
// 			}
// 		});
// 	})
// }

// function resetPwd(id) {
// }


// function batchRemove() {
// 	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
// 	if (rows.length == 0) {
// 		layer.msg("请选择要删除的数据");
// 		return;
// 	}
// 	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
// 		btn : [ '确定', '取消' ]
// 	// 按钮
// 	}, function() {
// 		var ids = new Array();
// 		// 遍历所有选择的行数据，取每条数据对应的ID
// 		$.each(rows, function(i, row) {
// 			ids[i] = row['id'];
// 		});
// 		$.ajax({
// 			type : 'POST',
// 			data : {
// 				"ids" : ids
// 			},
// 			url : prefix + '/batchRemove',
// 			success : function(r) {
// 				if (r.code == 0) {
// 					layer.msg(r.msg);
// 					reLoad();
// 				} else {
// 					layer.msg(r.msg);
// 				}
// 			}
// 		});
// 	}, function() {
//
// 	});
// }