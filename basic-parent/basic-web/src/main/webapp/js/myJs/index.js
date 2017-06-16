var ctx = $('#ctxValue').val();
!function($) {
	/***为左边菜单栏添加事件***/
	$(document).on('click', '#side-menu #MenutopIten', function() {
		var parent = $(this).parents('#menuButton');
		parent.find('li #MenutopIten').removeClass('active');
		parent.find('li #MenutopIten').css('fontWeight', 'normal');
		$(this).css('fontWeight', 'bold');
		$(this).attr('class', 'active');
		parent.find('li #menuItem').css('fontWeight', 'normal');
	});

	$(document).on('click', '#menuItem', function() {
		var parent = $(this).parents('#menuButton');
		parent.find('li #menuItem').css('fontWeight', 'normal');
		$(this).css('fontWeight', 'bold');
	});
	/***end 为左边菜单栏添加事件***/
}(window.jQuery);

/**iframe自适应高度**/
function changeFrameHeight(){
    var ifm= document.getElementById("content"); 
    ifm.height=document.documentElement.clientHeight;
}
window.onresize=function(){  
     changeFrameHeight();  
} 
/**end iframe自适应高度**/


/** dialog相关 **/
function openDialog(id,width,height,title,srcUrl){
	
	$('#'+id+'DialogModal').modal({backdrop: 'static', keyboard: false});
	
	$('#'+id+'DialogFrame').height(height);
	
	$('#'+id+'Dialog').width(width);
	
	$('#'+id+'DialogLabel').text(title);
	
	$('#'+id+'DialogFrame').attr("src",srcUrl); 
}


function closeDialog(id){
	$('#'+id+'DialogModal').modal('hide');
	$('#'+id+'DialogFrame').attr("src",ctx+'/index/goPage.view?pathName=blank'); 
}
/** end dialog相关 **/


function evalFun(funStr){
	eval("window.content."+funStr);
}






