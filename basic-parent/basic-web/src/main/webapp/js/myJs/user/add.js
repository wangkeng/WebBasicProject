var ctx;
$(function() {
	ctx = $('#ctxValue').val();
    $('#defaultForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	account :{
        		validators: {
        			notEmpty: {
        				 message: '手机号不能为空哦~'
        			},
                    regexp: {
                        regexp: /^1[3|4|5|7|8][0-9]{9}$/,
                        message: '请输入正确的手机号'
                    }
                }
        	},
            name: {
                validators: {
                	notEmpty: {
               		    message: '昵称不能为空哦~'
      				},
                    regexp: {
                        regexp: /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{6,10}$/,
                        message: '6-10位的字母或者数字,并且至少有一个数字或者字母'
                    }
                }
            },
            category: {
                validators: {
                    notEmpty: {
                        message: '请选择分类'
                    }
                }
            },mail:{
            	 validators: {
            		 regexp: {
                         regexp: /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,
                         message: '请输入正确的邮箱格式'
                     }
                 } 
            }
           
        }
    });
    
    $('#cancelBtn').click(function () {  
		parent.closeDialog('first');
    });  
    
    $('#submitBtn').click(function () {  
    	$('#defaultForm').data('bootstrapValidator').validate();
    	if(!$('#defaultForm').data('bootstrapValidator').isValid()){  
    		parent.swal({title: '您填写的信息不完整',    text: '"*"号的列需要填写哦', type :'error', confirmButtonText :'确定' });
    	} else {
    		var postData = $('#defaultForm').serialize();
    		
    		$.ajax({
    			type : 'POST',
    			url : ctx+'/user/add.json',
    			data : postData,
    			dataType : 'json',
    			success : function(result) {
    				parent.evalFun('refreshTable()');
    				parent.closeDialog('first');
    		    	parent.swal({title: '保存成功', text: '正在刷新数据', type :'success', timer: 1000,showConfirmButton: false  });
    			},
    			error : function(result) {
    				parent.swal({title: '保存失败',text: '服务器傻掉啦~', type :'error', confirmButtonText :'确定' });
    			}
    		});
    	  
    	}
    }); 
    
    
   
    
    $('#cc').combotree({
        url:ctx+'/userCategory/getList.json',
        panelHeight:100
    });

});