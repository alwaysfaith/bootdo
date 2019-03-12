var prefix = "/common/score"
$(function () {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable({
            method: 'get', // 服务器数据的请求方式 get or post
            url: prefix + "/list", // 服务器数据的加载地址
            //	showRefresh : true,
            //	showToggle : true,
            //	showColumns : true,
            iconSize: 'outline',
            toolbar: '#exampleToolbar',
            // striped : true, // 设置为true会有隔行变色效果
            dataType: "json", // 服务器返回的数据类型
            pagination: true, // 设置为true会在底部显示分页条
            // queryParamsType : "limit",
            // //设置为limit则会发送符合RESTFull格式的参数
            singleSelect: false, // 设置为true将禁止多选
            // contentType : "application/x-www-form-urlencoded",
            // //发送到服务器的数据编码类型
            pageSize: 10, // 如果设置了分页，每页数据条数
            pageNumber: 1, // 如果设置了分布，首页页码
            //search : true, // 是否显示搜索框
            showColumns: false, // 是否显示内容下拉框（选择显示的列）
            sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
            queryParams: function (params) {
                return {
                    //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                    limit: params.limit,
                    offset: params.offset,
                    betWeek: $('#betWeek').val(),
                    betLeague: $('#betLeague').val(),
                    betTime: $('#betTime').val(),
                    hostRank: $('#hostRank').val(),
                    hostTeam: $('#hostTeam').val(),
                    guestRank: $('#guestRank').val(),
                    guestTeam: $('#guestTeam').val(),
                    betScore: $('#betScore').val(),
                    hostRedCard: $('#hostRedCard').val(),
                    guestRedCard: $('#guestRedCard').val(),
                    hostYellowCard: $('#hostYellowCard').val(),
                    guestYellowCard: $('#guestYellowCard').val(),
                    betScoreHalf: $('#betScoreHalf').val(),
                    drawPoint: $('#drawPoint').val(),
                    drawWinOdds: $('#drawWinOdds').val(),
                    drawDrowOdds: $('#drawDrowOdds').val(),
                    drawLoseOdds: $('#drawLoseOdds').val(),
                    letPoint: $('#letPoint').val(),
                    letWinOdds: $('#letWinOdds').val(),
                    letDrowOdds: $('#letDrowOdds').val(),
                    letLoseOdds: $('#letLoseOdds').val(),
                    drawActive: $('#drawActive').val(),
                    letActive: $('#letActive').val()
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
                    checkbox: true
                },
                {
                    field: 'betId',
                    title: '比赛ID',
                    visible: false
                },
                {
                    field: 'betWeek',
                    title: '比赛周次'
                },
                {
                    field: 'betLeague',
                    title: '比赛赛事',
                    formatter: function (value, row) {
                        return'<span style="display: inline-block;width: 88px;line-height: 38px;'+row.betLeagueStyle+'">' + row.betLeague + '</span>';
                    }
                },
                {
                    field: 'betTime',
                    title: '比赛日期'
                },
                {
                    field: 'startTime',
                    title: '开始时间'
                },
                {
                    field: 'hostRank',
                    title: '主队排名',
                    visible: false
                },
                {
                    field: 'hostRedCard',
                    title: '主队红牌',
                    visible: false
                },
                {
                    field: 'guestRedCard',
                    title: '客队红牌',
                    visible: false
                },
                {
                    field: 'hostYellowCard',
                    title: '主队黄牌',
                    visible: false
                },
                {
                    field: 'guestYellowCard',
                    title: '客队黄牌',
                    visible: false
                },
                {
                    field: 'guestRank',
                    title: '客队排名',
                    visible: false
                },
                {
                    field: 'hostTeam',
                    title: '主队',
                    formatter: function (value, row) {
                        var a = '<span class="hostTeam">' +
                            '<i class="hostYellowCard" title="黄牌">' + row.hostYellowCard + '</i>' +
                            '<i class="hostRedCard"  title="红牌">' + row.hostRedCard + '</i>' +
                            '<i class="hostRank"  title="排名" >[' + row.hostRank + ']</i>' +
                            '' + row.hostTeam + '</span>',
                            b = '<span class="hostTeam">' +
                                '<i class="hostYellowCard"  title="黄牌">' + row.hostYellowCard + '</i>' +
                                '<i class="hostRedCard"  title="红牌">' + row.hostRedCard + '</i>' +
                                '' + row.hostTeam + '</span>',
                            c = '<span class="hostTeam">' +
                                '<i class="hostYellowCard"  title="黄牌">' + row.hostYellowCard + '</i>' +
                                '<i class="hostRank"  title="排名">[' + row.hostRank + ']</i>' +
                                '' + row.hostTeam + '</span>',
                            d = '<span class="hostTeam">' +
                                '<i class="hostYellowCard "  title="黄牌">' + row.hostYellowCard + '</i>' +
                                '' + row.hostTeam + '</span>',
                            e = '<span class="hostTeam">' +
                                '<i class="hostRedCard "  title="红牌">' + row.hostRedCard + '</i>' +
                                '<i class="hostRank"  title="排名">[' + row.hostRank + ']</i>' +
                                '' + row.hostTeam + '</span>',
                            f = '<span class="hostTeam">' +
                                '<i class="hostRedCard " title="红牌">' + row.hostRedCard + '</i>' +
                                '' + row.hostTeam + '</span>',
                            g = '<span class="hostTeam">' +
                                '<i class="hostRank"  title="排名">[' + row.hostRank + ']</i>' +
                                '' + row.hostTeam + '</span>',
                            h = '<span class="hostTeam">' + row.hostTeam + '</span>';
                        if (row.hostYellowCard != 0 && row.hostRedCard != 0 && row.hostRank != 0) {
                            return a;
                        } else if (row.hostYellowCard != 0 && row.hostRedCard != 0 && row.hostRank == 0) {
                            return b;
                        } else if (row.hostYellowCard != 0 && row.hostRedCard == 0 && row.hostRank != 0) {
                            return c;
                        } else if (row.hostYellowCard != 0 && row.hostRedCard == 0 && row.hostRank == 0) {
                            return d;
                        } else if (row.hostYellowCard == 0 && row.hostRedCard != 0 && row.hostRank != 0) {
                            return e;
                        } else if (row.hostYellowCard == 0 && row.hostRedCard != 0 && row.hostRank == 0) {
                            return f;
                        } else if (row.hostYellowCard == 0 && row.hostRedCard == 0 && row.hostRank != 0) {
                            return g;
                        } else if (row.hostYellowCard == 0 && row.hostRedCard == 0 && row.hostRank == 0) {
                            return h;
                        }
                    }
                },
                {
                    field: 'betScore',
                    title: '比分',
                    formatter: function (value, row) {
                        return '<span class="betScore">' + row.betScore + '</span>';
                    }
                },
                {
                    field: 'guestTeam',
                    title: '客队',
                    formatter: function (value, row) {
                        var a = '<span class="guestTeam">' + row.guestTeam + '' +
                            '<i class="guestRank"  title="排名">[' + row.guestRank + ']</i>' +
                            '<i class="guestRedCard" title="红牌">' + row.guestRedCard + '</i>' +
                            '<i class="guestYellowCard"  title="黄牌">' + row.guestYellowCard + '</i>' +
                            '</span>',
                            b = '<span class="guestTeam">' + row.guestTeam + '' +
                                '<i class="guestRedCard" title="红牌">' + row.guestRedCard + '</i>' +
                                '<i class="guestYellowCard"  title="黄牌">' + row.guestYellowCard + '</i>' +
                                '</span>',
                            c = '<span class="guestTeam">' + row.guestTeam + '' +
                                '<i class="guestRank"  title="排名">[' + row.guestRank + ']</i>' +
                                '<i class="guestYellowCard"  title="黄牌">' + row.guestYellowCard + '</i>' +
                                '</span>',
                            d = '<span class="guestTeam">' + row.guestTeam + '' +
                                '<i class="guestYellowCard "  title="黄牌">' + row.guestYellowCard + '</i>' +
                                '</span>',
                            e = '<span class="guestTeam">' + row.guestTeam + '' +
                                '<i class="guestRank"  title="排名">[' + row.guestRank + ']</i>' +
                                '<i class="guestRedCard " title="红牌">' + row.guestRedCard + '</i>' +
                                '</span>',
                            f = '<span class="guestTeam">' + row.guestTeam + '' +
                                '<i class="guestRedCard " title="红牌">' + row.guestRedCard + '</i>' +
                                '</span>',
                            g = '<span class="guestTeam">' + row.guestTeam + '' +
                                '<i class="guestRank"  title="排名">[' + row.guestRank + ']</i>' +
                                '</span>',
                            h = '<span class="guestTeam">' + row.guestTeam + '</span>';
                        if (row.guestYellowCard != 0 && row.guestRedCard != 0 && row.guestRank != 0) {
                            return a;
                        } else if (row.guestYellowCard != 0 && row.guestRedCard != 0 && row.guestRank == 0) {
                            return b;
                        } else if (row.guestYellowCard != 0 && row.guestRedCard == 0 && row.guestRank != 0) {
                            return c;
                        } else if (row.guestYellowCard != 0 && row.guestRedCard == 0 && row.guestRank == 0) {
                            return d;
                        } else if (row.guestYellowCard == 0 && row.guestRedCard != 0 && row.guestRank != 0) {
                            return e;
                        } else if (row.guestYellowCard == 0 && row.guestRedCard != 0 && row.guestRank == 0) {
                            return f;
                        } else if (row.guestYellowCard == 0 && row.guestRedCard == 0 && row.guestRank != 0) {
                            return g;
                        } else if (row.guestYellowCard == 0 && row.guestRedCard == 0 && row.guestRank == 0) {
                            return h;
                        }
                    }
                },
                {
                    field: 'betScoreHalf',
                    title: '半场比分',
                    formatter: function (value, row) {
                        return '<span class="betScore">' + row.betScore + '</span>';
                    }
                },
                {
                    field: 'drawPoint',
                    title: '平手盘',
                    formatter: function (value, row) {
                        var nbsp = '<div class="tdDiv"><p class="drawPoint" style="border-bottom: 1px solid #D9D9D9;">' + row.drawPoint + '</p><p class="letPoint"><span class="let-space">' + row.letPoint + '</span></p></div>',
                            nonbsp = '<div class="tdDiv"><p class="drawPoint" style="border-bottom: 1px solid #D9D9D9;">' + row.drawPoint + '</p><p class="letPoint">' + row.letPoint + '</p></div>';
                        if (row.letPoint < 0) {
                            return nbsp;
                        } else {
                            return nonbsp;
                        }
                    }
                },
                {
                    field: 'letPoint',
                    title: '让球盘',
                    visible: false
                },
                {
                    field: 'drawWinOdds',
                    title: '平手盘主队',
                    formatter: function (value, row) {
                        var e = '<div class="tdDiv">' +
                            '<p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                            '<i class="drawWinOdds"><span  style="background-color: rgb(21, 110, 202);color: #fff">' + row.drawWinOdds + '</span></i>' +
                            '<i class="drawDrowOdds"><span>' + row.drawDrowOdds + '</span></i>' +
                            '<i class="drawLoseOdds"><span>' + row.drawLoseOdds + '</span></i>' +
                            '</p>' +
                            '<p class="letPoint">' +
                            '<i class="letWinOdds"  ><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letWinOdds + '</span></i>' +
                            '<i class="letDrowOdds"><span>' + row.letDrowOdds + '</span></i>' +
                            '<i class="letLoseOdds"><span>' + row.letLoseOdds + '</span></i>' +
                            '</p>' +
                            '</div>',
                            f = '<div class="tdDiv">' +
                                '<p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"  ><span style="background-color: rgb(21, 110, 202);color: #fff">' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds"><span>' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds"><span>' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"><span>' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds" ><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds"><span>' + row.letLoseOdds + '</span></i>' +
                                '</p></div>',
                            g = '<div class="tdDiv">' +
                                '<p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"><span style="background-color: rgb(21, 110, 202);color: #fff">' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds"><span>' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds"><span>' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"><span>' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds"><span>' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds"><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letLoseOdds + '</span></i>' +
                                '</p>' +
                                '</div>',
                            h = '<div class="tdDiv"><p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"><span>' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds"><span style="background-color: rgb(21, 110, 202);color: #fff">' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds"><span>' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"  ><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds "><span>' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds "><span>' + row.letLoseOdds + '</span></i>' +
                                '</p></div>',
                            i = '<div class="tdDiv"><p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"><span>' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds "><span  style="background-color: rgb(21, 110, 202);color: #fff">' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds"><span>' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"><span>' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds"  ><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds "><span>' + row.letLoseOdds + '</span></i>' +
                                '</p></div>',
                            j = '<div class="tdDiv">' +
                                '<p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"><span>' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds " ><span style="background-color: rgb(21, 110, 202);color: #fff">' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds"><span>' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"><span>' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds"><span>' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds" ><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letLoseOdds + '</span></i>' +
                                '</p>' +
                                '</div>',
                            k = '<div class="tdDiv">' +
                                '<p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"><span>' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds"><span>' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds "  ><span style="background-color: rgb(21, 110, 202);color: #fff">' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"  ><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds "><span>' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds"><span>' + row.letLoseOdds + '</span></i>' +
                                '</p></div>',
                            l = '<div class="tdDiv">' +
                                '<p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"><span>' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds"><span>' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds "  ><span style="background-color: rgb(21, 110, 202);color: #fff">' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"><span>' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds"><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds"><span>' + row.letLoseOdds + '</span></i>' +
                                '</p></div>',
                            m = '<div class="tdDiv">' +
                                '<p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"><span>' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds"><span>' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds "  ><span style="background-color: rgb(21, 110, 202);color: #fff">' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"><span>' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds"><span>' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds"><span  style="background-color: rgb(255, 69, 0);color: #fff">' + row.letLoseOdds + '</span></i>' +
                                '</p></div>',
                            n = '<div class="tdDiv">' +
                                '<p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"><span>' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds"><span>' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds "  ><span>' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds"><span>' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds"><span>' + row.letLoseOdds + '</span></i>' +
                                '</p></div>',
                            o = '<div class="tdDiv">' +
                                '<p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"><span>' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds"><span>' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds "  ><span>' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"><span>' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds"><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds"><span>' + row.letLoseOdds + '</span></i>' +
                                '</p></div>',
                            p = '<div class="tdDiv">' +
                                '<p class="drawPoint" style="border-bottom: 1px solid #e4eaec;">' +
                                '<i class="drawWinOdds"><span>' + row.drawWinOdds + '</span></i>' +
                                '<i class="drawDrowOdds"><span>' + row.drawDrowOdds + '</span></i>' +
                                '<i class="drawLoseOdds "  ><span>' + row.drawLoseOdds + '</span></i>' +
                                '</p>' +
                                '<p class="letPoint">' +
                                '<i class="letWinOdds"><span>' + row.letWinOdds + '</span></i>' +
                                '<i class="letDrowOdds"><span>' + row.letDrowOdds + '</span></i>' +
                                '<i class="letLoseOdds"><span style="background-color: rgb(255, 69, 0);color: #fff">' + row.letLoseOdds + '</span></i>' +
                                '</p></div>';
                        if (row.drawActive == 3 && row.letActive == 3) {
                            return e;
                        } else if (row.drawActive == 3 && row.letActive == 1) {
                            return f;
                        } else if (row.drawActive == 3 && row.letActive == 0) {
                            return g;
                        } else if (row.drawActive == 1 && row.letActive == 3) {
                            return h;
                        } else if (row.drawActive == 1 && row.letActive == 1) {
                            return i;
                        } else if (row.drawActive == 1 && row.letActive == 0) {
                            return j;
                        } else if (row.drawActive == 0 && row.letActive == 3) {
                            return k;
                        } else if (row.drawActive == 0 && row.letActive == 1) {
                            return l;
                        } else if (row.drawActive == 0 && row.letActive == 0) {
                            return m;
                        } else if (row.drawWinOdds == "--" && row.drawDrowOdds == "--" && row.drawLoseOdds == "--") {
                            if (row.letActive == 3) {
                                return n;
                            } else if (row.letActive == 1) {
                                return o;
                            } else if (row.letActive == 0) {
                                return p;
                            }
                        }
                    }
                },
                {
                    field: 'drawDrowOdds',
                    title: '平手盘平手',
                    visible: false
                },
                {
                    field: 'drawLoseOdds',
                    title: '平手盘客队',
                    visible: false
                },
                {
                    field: 'letWinOdds',
                    title: '让球盘主队',
                    visible: false
                },
                {
                    field: 'letDrowOdds',
                    title: '让球盘平手',
                    visible: false
                },
                {
                    field: 'letLoseOdds',
                    title: '让球盘客队',
                    visible: false
                },
                {
                    field: 'drawActive',
                    title: '平手盘打出3主队赢1平手0客队赢',
                    visible: false
                },
                {
                    field: 'letActive',
                    title: '让球盘打出3主队赢1平手0客队赢',
                    visible: false
                },
                {
                    field: 'dataId',
                    title: '数据ID',
                    visible: false
                },
                {
                    title: '操作',
                    field: 'id',
                    align: 'center',
                    formatter: function (value, row, index) {
                        var e = '<a class="btn btn-primary btn-sm " href="#" mce_href="#" title="编辑" onclick="edit(\''
                            + row.betId
                            + '\')"><i class="fa fa-edit"></i></a> ';
                        var d = '<a class="btn-danger btn-sm" href="#" title="删除"  mce_href="#" onclick="remove(\''
                            + row.betId
                            + '\')"><i class="fa fa-remove"></i></a> ';
                        var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                            + row.betId
                            + '\')"><i class="fa fa-key"></i></a> ';
                        return d;
                    }
                }],
            onPostBody: function () {
                //改变复选框样式
                $('#exampleTable').find("input:checkbox").each(function (i) {
                    var $check = $(this);
                    if ($check.attr("id") && $check.next("label")) {
                        return;
                    }
                    var name = $check.attr("name");
                    var id = name + "-" + i;
                    var $label = $('<label for="' + id + '"></label>');
                    $check.attr("id", id).parent().addClass("bella-checkbox").append($label);
                });
            }
        });
}

function add() {
    layer.open({
        type: 2,
        title: '增加',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/add' // iframe的url
    });
}

function edit(id) {
    layer.open({
        type: 2,
        title: '编辑',
        maxmin: true,
        shadeClose: false, // 点击遮罩关闭层
        area: ['800px', '520px'],
        content: prefix + '/edit/' + id // iframe的url
    });
}

function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn: ['确定', '取消']
    }, function () {
        $.ajax({
            url: prefix + "/remove",
            type: "post",
            data: {
                'betId': id
            },
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}

function reLoad() {
    var opt = {
        queryParams: function (params) {
            return {
                //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                limit: params.limit,
                offset: params.offset,
                betWeek: $('#betWeek').val(),
                betLeague: $('#betLeague').val(),
                betTime: $('#betTime').val(),
                hostRank: $('#hostRank').val(),
                hostTeam: $('#hostTeam').val(),
                guestRank: $('#guestRank').val(),
                guestTeam: $('#guestTeam').val(),
                betScore: $('#betScore').val(),
                hostRedCard: $('#hostRedCard').val(),
                guestRedCard: $('#guestRedCard').val(),
                hostYellowCard: $('#hostYellowCard').val(),
                guestYellowCard: $('#guestYellowCard').val(),
                betScoreHalf: $('#betScoreHalf').val(),
                drawPoint: $('#drawPoint').val(),
                drawWinOdds: $('#drawWinOdds').val(),
                drawDrowOdds: $('#drawDrowOdds').val(),
                drawLoseOdds: $('#drawLoseOdds').val(),
                letPoint: $('#letPoint').val(),
                letWinOdds: $('#letWinOdds').val(),
                letDrowOdds: $('#letDrowOdds').val(),
                letLoseOdds: $('#letLoseOdds').val(),
                drawActive: $('#drawActive').val(),
                letActive: $('#letActive').val()
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

function batchRemove() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn: ['确定', '取消']
        // 按钮
    }, function () {
        var ids = new Array();
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function (i, row) {
            ids[i] = row['betId'];
        });
        $.ajax({
            type: 'POST',
            data: {
                "ids": ids
            },
            url: prefix + '/batchRemove',
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function () {

    });
}