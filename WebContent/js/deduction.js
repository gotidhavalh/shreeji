$(document).ready(function(e) {
	
		$('#customeDate').datepicker({
			
            format: "mm/yyyy",
            language: "es",
            autoclose: true,
            todayHighlight: true
        });

	$('#listDeduction').DataTable({

		dom : 'l<"toolbar">frtip',
		ajax : {
			url : "MainController",
			type : "POST",
			data : {
				action : "listDeductionJSON",
			},
		},
		columns : [ {
			data : "FirstName"
		}, {
			data : "Leave"
		}, {
			data : "Asset"
		}, {
			data : "EmpCode",
			"visible" : false
		},{
			data :"ID",
			"visible" : false
		},
		{
			data: null,
			bSortable: false,
			className: "center",
			render : function(data, type, row)
			{
				return '<button onclick="viewDeduct(' + row.ID + ')" class="btn	btn-primary"> View </button>';
			}
		}
		, {
			data: null,
			bSortable: false,
			className: "center",
			render : function(data, type, row)
			{
				return '<button onclick="editDeduct(' + row.ID + ')" class="btn	btn-primary"> Edit </button>';
			}
		},{
			data: null,
			bSortable: false,
			className: "center",
			render : function(data, type, row)
			{
				return '<button onclick="deleteDeduct(' + row.ID + ')" class="btn btn-primary"> Delete </button>';
			}
		}]
//		]

	});
});

function editDeduct(deductID)
{
	var form = document.createElement("form");
  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="viewDeduct";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value=deductID;
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
function viewDeduct(deductID)
{
	var form = document.createElement("form");
  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="viewDeduct";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value=deductID;
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

function deleteDeduct(deductID)
{
	var form = document.createElement("form");
  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="deleteDeduct";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value=deductID;
	element2.name="id";
	form.appendChild(element2); 
	    
    document.body.appendChild(form);
   	form.submit();
}