$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/common/scoreData/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}
		}
	});
}

function generator(){
    var index=parent.layer.open({
        type : 1,
        area : [ '100%', '100%' ],
        shadeClose : false, // 点击遮罩关闭层
        content :$('#ssTable').val()
    });
    layer.full(index);
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            dataTable : {
				required : true
			}
		},
		messages : {
            dataTable : {
        	required : icon + "请导入数据"
     }
   }
})
}