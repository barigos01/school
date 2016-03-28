/**
 * jQuery 속성 예제
 */

var attr = {
	attrDemo : function(imgPath) {
		$('<img/>', {src:imgPath, width: '100%', height: '90%'}).appendTo($('#sampleBox').empty());
	},
	
	htmlDemo : function(target) {
		$('<div id="htmlBox"></div>').appendTo($(target).empty());
		$('#htmlBox').html('<div style="background: yellow; width:100px; height:100px;">노란박스</div>');
	},
	
	textDemo : function(target) {
		$('<div id="htmlBox"></div>').appendTo($(target).empty());
		$('#sampleBox3').text('노란박스');
	}
}