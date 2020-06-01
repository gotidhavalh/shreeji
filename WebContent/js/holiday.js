$(document).ready(function(e) {
	
	$("#holidayTable").DataTable({
		
		ajax: {
			url : "MainController",
			type : "POST",
			data : {
				action : "getHolidayListJSON"
			}
		},
		columns : [	{
			data : "HolidayName"
		}, {
			data : "Day"
		}, {
			data : "Date"
		}, {
            data: null,
            className: "text-center",
            render : function(data, type, row)
            {
              return '<a onclick="viewHoliday('+row.ID +')" class="text-secondary" data-toggle="tooltip" title="View"> <span class="icon icon-edite"></span> </a><a onclick="deleteHoliday('+row.ID +')" class="text-secondary" data-toggle="tooltip" title="Delete"> <span class="icon icon-delete"></span> </a>';                  
            }
        }]
	});

});

function viewHoliday(id)
{
	console.log( " In View Holiday Action ");
	
	var form = document.createElement("form");
	  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="viewHoliDays";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");
	element2.type="hidden";
	element2.value=id;
	element2.name="id";
	form.appendChild(element2);
	
    document.body.appendChild(form);
   	form.submit();
}

function deleteHoliday(id)
{
	console.log( " In Delete Holiday Action ");
	
	if(confirm(" Are you sure you want to delete this Holiday ?"))
	{
		var form = document.createElement("form");
		  
	  	form.method = "POST";
		form.action = "MainController";
	    
		var element1 = document.createElement("input");
		element1.type="hidden";
		element1.value="deleteHoliday";
		element1.name="action";
		form.appendChild(element1);
		
		var element2 = document.createElement("input");
		element2.type="hidden";
		element2.value=id;
		element2.name="id";
		form.appendChild(element2);
		
	    document.body.appendChild(form);
	   	form.submit();
	}
}