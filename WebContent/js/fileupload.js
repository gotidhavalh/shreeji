$(document).ready(function() {
	$("#empImageName").change(function() {
		readURL(this);
	});
	
	$("#inputFileDiv").change(function() {
		setsrcAttribForAssetImage(this);
	});
});

function readURL(input) {
	
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#empImage').attr('src', e.target.result);
		}

		reader.readAsDataURL(input.files[0]);
	}
}

function setsrcAttribForAssetImage(imagepath) {
	
	if (imagepath.files && imagepath.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#assetImage').attr('src', e.target.result);
		}
		reader.readAsDataURL(imagepath.files[0]);
	}
}