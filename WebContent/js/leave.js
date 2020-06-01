$(document).ready(function(e) {
	
	$("#submit").click(function(){
		
		var isChecked = jQuery("input[name = Day]:checked").val();
		if(!isChecked){
			
			alert("Please Select Day Half or Full");
			return false;
		}
	})
	
	$("#leaveTable").DataTable({
		
		ajax: {
			url : "MainController",
			type : "POST",
			data : {
				action : "getLeaveListJSON"
			}
		},
		columns : [	{
				data : "ID",
				"visible": false
		},{
			data : "EmpCode",
			"visible": false
		},{
			data : "EmpName"
		}, {
			data : "FromDate"
		}, {
			data : "ToDate"
		},
		{
			data : "ApproverName",
			defaultContent: "No Approver"
		},
		{
			data : "Status",
			render : function(data, type, row)
			{	
				if(data == 'Pending'){
					
					return'<span class="badge badge-pending">Pending</span>';
				}
				else if(data == 'Approved'){
					return'<span class="badge badge-approved">Approved</span>';
				}
				else{
					return'<span class="badge badge-cancel">Rejected</span>';
				}
			}
		},
		{
            data: null,
            className: "center",
            render : function(data, type, row)
            {
              return '<a onclick="actionForLeave('+row.EmpCode+', '+row.ID +')" class="text-secondary" data-toggle="tooltip" title="Edit"> <span class="icon icon-edite"></span></a>';                  
            }
        }]
	});

});

function actionForLeave(empCode, id)
{
	console.log( " In Leave Action ");
	
	var form = document.createElement("form");
	  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="viewLeave";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");
	element2.type="hidden";
	element2.value=id;
	element2.name="id";
	form.appendChild(element2);
	
	var element3 = document.createElement("input");
	element3.type="hidden";
	element3.value=empCode;
	element3.name="empcode";
	form.appendChild(element3);
	
    document.body.appendChild(form);
   	form.submit();
}