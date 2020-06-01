$(document).ready(function(e) {
		
	$("#editEmp").submit(function(){
		var myval = $("input[name=adharNumber]").val();
		if(myval.length <12){
			alert("Value must contain 12 Digits.");
			return false;
		}
		else if(myval.length >12){
	    	 alert("You Entered more than 12 Digits.");
	    	 return false;
	     }
	});
	$("input[name=adharNumber]").on("blur", function(e){
	     var myval = $(this).val();
	 
	     if(myval.length < 12) {
	          alert("Value must contain 12 Digits.");
	          return false;
	     }
	     else if(myval.length >12){
	    	 alert("You Entered more than 12 Digits.");
	    	 return false;
	     }
	});
	
	$("#userName").keyup(function() {
		var userName = $(this).val();

		$.ajax({
			url : "CheckUserName",
			type : "POST",
			datatype : "json",
			data : {
				username : userName,
			},

			success : function(data) {
			var divElement = $("#divElement");
			if (data.usernm) {
				console.log(data.usernm);
				divElement.text(userName + " Username already exists.");
				divElement.css('color', 'red');
				divElement.css('font-size', '20px');
			} else {
				console.log(data.usernm);
				divElement.text('');
			}
		},
		error : function(err) {
			console.log(err);
		}

		});
	});
	$("#code").keyup(function() {
		var empCode = $(this).val();

		$.ajax({

			url : "CheckUserName",
			type : "GET",
			datatype : "json",
			data : {
				userCode : empCode,
			},
			success : function(data) {
				var divElement = $("#Error1");
				
				if (data.userCode) {
					console.log(data.userCode);
					divElement.text(empCode + " Employee code already exists. ");
					divElement.css('color', 'red');
					divElement.css('font-size', '20px');
				} else {
					console.log(data.usernm);
					divElement.text('');
				}	
			},
			error : function(err) {
				console.log(err);
			}
		});
	});
	$("#btnUpload").click(function() {

		var allowedFiles = [ ".xlsx" ];
		var fileUpload = document.getElementById("fileUpload");
		var lblError = document.getElementById("lblError");
		var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+("+ allowedFiles.join('|') + ")$");
		if (!regex.test(fileUpload.value.toLowerCase())) 
		{
			alert("Please Upload only Excel Format File");
				return false;
		}
		lblError.innerHTML = "";
		return true;
	});
			
			$("#example").DataTable({
				
				ajax : {
					url : "MainController",
					type : "POST",
					data : {
						action : "getEmpListJSON"
					}
				},
				columns : [ {
					data : "EmpCode",
					className: "center",
					width: "10%"
				}, {
					data : "FirstName",
					 className: "text-center",
					 width: "25%"
				}, {
					data : "PhoneNum",
					 className: "text-center",
				},
				{
	                data: null,
	                className: "text-center",
	                "bSortable": false,
	                render : function(data, type, row)
	                {
	                  //return '<a onclick="viewEmployee(' + row.EmpCode + ','+row.DesignationID+')" class="text-secondary" data-toggle="tooltip" title="View"> <span class="icon icon-eye"></span> </a><a onclick="editEmployee(' + row.EmpCode + ','+row.DesignationID+')" class="text-secondary"  data-toggle="tooltip" title="Edit"> <span class="icon icon-edite"></span> </a><a onclick="deleteEmployee(' + row.EmpCode + ')" class="text-secondary" data-toggle="tooltip" title="Delete"> <span class="icon icon-delete"></span> </a>';                  
	                	return '<a href="viewEmployee/'+row.EmpCode+'/'+row.DesignationID+'" class="text-secondary" data-toggle="tooltip" title="View"> <span class="icon icon-eye"></span> </a><a onclick="editEmployee(' + row.EmpCode + ','+row.DesignationID+')" class="text-secondary"  data-toggle="tooltip" title="Edit"> <span class="icon icon-edite"></span> </a><a onclick="deleteEmployee(' + row.EmpCode + ')" class="text-secondary" data-toggle="tooltip" title="Delete"> <span class="icon icon-delete"></span> </a>';
	                }
	            }
//				{
//	                data: null,
//	                className: "center",
//	                render : function(data, type, row)
//	                {
//	                  return '<button onclick="editEmployee(' + row.EmpCode + ','+row.DesignationID+')" class="btn btn-primary"> Edit </button>';                  
//	                }
//	            },
//				{
//	                data: null,
//	                className: "center",
//	                render : function(data, type, row)
//	                {
//	                  return '<button onclick="deleteEmployee(' + row.EmpCode + ')" class="btn btn-primary"> Delete </button>';                  
//	                }
//	            }
	            ]
			});
		    
		});


function addEmp(empcode)
{
	var form = document.createElement("form");
	  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="designation";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value="Designation";
	element2.name="designation";
	form.appendChild(element2); 

    document.body.appendChild(form);
   	form.submit();
}

function viewEmployee(empcode , ID)
{
	var form = document.createElement("form");
  
  	form.method = "GET";
	form.action = "viewEmployee/"+empcode+"/"+ID+"";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="viewEmployee";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value=empcode;
	element2.name="empcode";
	form.appendChild(element2); 

	var element3 = document.createElement("input");  
	element3.type="hidden";
	element3.value="view";
	element3.name="view";
	form.appendChild(element3); 
	    
	var element4 = document.createElement("input");  
	element4.type="hidden";
	element4.value=ID;
	element4.name="designationID";
	form.appendChild(element4);
	
    document.body.appendChild(form);
   	form.submit();
}

function editEmployee(empcode, ID)
{
	var form = document.createElement("form");
  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="viewEmployee";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value=empcode;
	element2.name="empcode";
	form.appendChild(element2); 

	var element3 = document.createElement("input");  
	element3.type="hidden";
	element3.value="edit";
	element3.name="view";
	form.appendChild(element3);
	var element4 = document.createElement("input");  
	element4.type="hidden";
	element4.value=ID;
	element4.name="designationID";
	form.appendChild(element4);
	    
    document.body.appendChild(form);
   	form.submit();
}

function deleteEmployee(empcode)
{
	
	if(confirm(" Are you sure you want to delete this Employee ?"))
	{
		var form = document.createElement("form");
		  
	  	form.method = "POST";
		form.action = "MainController";
	    
		var element1 = document.createElement("input");
		element1.type="hidden";
		element1.value="deleteEmployee";
		element1.name="action";
		form.appendChild(element1);
		
		var element2 = document.createElement("input");  
		element2.type="hidden";
		element2.value=empcode;
		element2.name="empcode";
		form.appendChild(element2); 

	    document.body.appendChild(form);
	   	form.submit();
	}
	else
	{
		console.log(" In Else Section ");
	}
	
}
function isNumber(evt) {
    evt = (evt) ? evt : window.event;
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}