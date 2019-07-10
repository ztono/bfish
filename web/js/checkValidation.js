window.onload = function () {
    $('form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            clientNo: {
                message: '用户名验证失败',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空！'
                    },
                    stringLength: {
                        min: 6,
                        max: 20,
                        message: '用户名长度必须在6到20位之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: '用户名只能包含大写、小写、数字和下划线'
                    }
                }
            },
            roomNo: {
                validators: {
                    notEmpty: {
                        message: '房间号不能为空！'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '房间号只能为整数'
                    }
                }
            },
            duration:{
                validators:{
                    notEmpty:{
                        message:'入住时长不能为空！'
                    },
                    regexp:{
                        regexp:/^[0-9]+$/,
                        message:'入住时长只能为整数'
                    }
                }
            }
        }
    });
}