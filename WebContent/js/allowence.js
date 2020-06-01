$(document).ready(function(e) {
	
	$('#customeDate').datepicker({
		
        format: "mm/yyyy",
        language: "es",
        autoclose: true,
        todayHighlight: true
    });

	$('#listAllowence').DataTable({

		dom : 'l<"toolbar">frtip',
		ajax : {
			url : "MainController",
			type : "POST",
			data : {
				action : "listAllowenceJson",
			},
		},
		columns : [ {
			data : "ID",
			"visible" : false
		}, {
			data : "EmpCode",
			"visible" : false
		}, {
			data : "Name"
		}, {
			data :"Fual"
		},
		{
			data :"OverTime"
		},{
			data :"Month"
		}
		,
		{
			data: null,
			bSortable: false,
			className: "center",
			render : function(data, type, row)
			{
				return '<button onclick="viewAllowence(' + row.ID + ')" class="btn	btn-primary"> View </button>';
			}
		}
		, {
			data: null,
			bSortable: false,
			className: "center",
			render : function(data, type, row)
			{
				return '<button onclick="editAllowence(' + row.ID + ')" class="btn	btn-primary"> Edit </button>';
			}
		},{
			data: null,
			bSortable: false,
			className: "center",
			render : function(data, type, row)
			{
				return '<button onclick="deleteAllowence(' + row.ID + ')" class="btn btn-primary"> Delete </button>';
			}
		}]
	});
});

function viewAllowence(allowID){
	
	var form = document.createElement("form");
	  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="viewAllowence";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value=allowID;
	element2.name="id";
	form.appendChild(element2); 

	var element3 = document.createElement("input");  
	element3.type="hidden";
	element3.value="view";
	element3.name="view";
	form.appendChild(element3); 
	    
    document.body.appendChild(form);
   	form.submit();
}

function editAllowence(allowID){
	
	var form = document.createElement("form");
	  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="viewAllowence";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value=allowID;
	element2.name="id";
	form.appendChild(element2); 

	var element3 = document.createElement("input");  
	element3.type="hidden";
	element3.value="edit";
	element3.name="view";
	form.appendChild(element3); 
	    
    document.body.appendChild(form);
   	form.submit();
}
function deleteAllowence(allowID){
	
	var form = document.createElement("form");
	  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="deleteAllowence";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value=allowID;
	element2.name="id";
	form.appendChild(element2); 

    document.body.appendChild(form);
   	form.submit();
}