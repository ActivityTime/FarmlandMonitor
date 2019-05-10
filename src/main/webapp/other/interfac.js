// getQueryString
var interfac = {
	title: $(".index-title"),
	context: $(".index-context"),
	target: getQueryString("target"),
	change: function() {
		if(this.target == "back") {
			this.context.load("/template/Index_back.html");
		} else if(this.target == "data") {
			this.context.load("/template/index_data.html");
		}

		//------------------------------
		else {
			this.context.load("/template/Index_back.html");
		}
	}
}

interfac.change();