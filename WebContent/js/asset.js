$(document).ready(
		function(e) {

			
			$("#assetList").DataTable({
				
				ajax : {
					url : "MainController",
					type : "POST",
					data : {
						action : "getAssetListJSON"
					}
				},
				columns : [ {
					data : "AssetName",
					className: "center"
				}, {
					data : "HolderName",
					className: "center"
				},{
					data : "ID",
					"visible": false,
					className: "center"
				},
				{
	                data: null,
	                bSortable: false,
	                className: "img-center",
	                render : function(data, type, row)
	                {
	                  return '<div class="assets-img"><img  src="images/Asset_'+ row.ID+'.jpg" alt=""></div>';                  
	                }
	            },
				{
	                data: null,
	                bSortable: false,
	                className: "text-center",
	                render : function(data, type, row)
	                {
	                  return '<a onclick="viewAsset(' + row.ID + ')" class="text-secondary" data-toggle="tooltip" title="View"> <span class="icon icon-eye"></span> </a><a onclick="editAsset(' + row.ID + ')" class="text-secondary" data-toggle="tooltip" title="Edit"> <span class="icon icon-edite"></span> </a><a onclick="deleteAsset(' + row.ID + ')" class="text-secondary" data-toggle="tooltip" title="Delete"> <span class="icon icon-delete"></span> </a>';                  
	                }
	            }
//				{
//	                data: null,
//	                bSortable: false,
//	                className: "center",
//	                render : function(data, type, row)
//	                {
//	                  return '<a onclick="editAsset(' + row.ID + ')" class="text-secondary" data-toggle="tooltip" title="View"> <span class="icon icon-edite"></span> </a>';
////	                  <a onclick="editEmployee(' + row.EmpCode + ','+row.DesignationID+')" class="text-secondary"  data-toggle="tooltip" title="Edit"> <span class="icon icon-edite"></span> </a>
////	                  <a onclick="deleteEmployee(' + row.EmpCode + ')" class="text-secondary" data-toggle="tooltip" title="Delete"> <span class="icon icon-delete"></span> </a>
//	                }
//	            },
//	            {
//	                data: null,
//	                bSortable: false,
//	                className: "center",
//	                render : function(data, type, row)
//	                {
//	                  return '<a onclick="deleteAsset(' + row.ID + ')" class="text-secondary" data-toggle="tooltip" title="Delete"> <span class="icon icon-delete"></span> </a>';                  
//	                }
//	            }
	            ]
			});
		    
		});


function addAsset()
{
	console.log( " In Add Asset ");
	
	var form = document.createElement("form");
	  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="asset";
	element1.name="action";
	form.appendChild(element1);
	
    document.body.appendChild(form);
   	form.submit();
}

function viewAsset(assetID)
{
	var form = document.createElement("form");
  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="viewAsset";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value=assetID;
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

function editAsset(assetID)
{
	var form = document.createElement("form");
  
  	form.method = "POST";
	form.action = "MainController";
    
	var element1 = document.createElement("input");
	element1.type="hidden";
	element1.value="viewAsset";
	element1.name="action";
	form.appendChild(element1);
	
	var element2 = document.createElement("input");  
	element2.type="hidden";
	element2.value=assetID;
	element2.name="id";
	form.appendChild(element2); 

	var element3 = document.createElement("input");  
	element3.value="edit";
	element3.name="view";
	form.appendChild(element3); 
	    
    document.body.appendChild(form);
   	form.submit();
}

function deleteAsset(assetID)
{
	if(confirm(" Are you sure you want to delete this Asset?"))
	{
		var form = document.createElement("form");
		  
	  	form.method = "POST";
		form.action = "MainController";
	    
		var element1 = document.createElement("input");
		element1.type="hidden";
		element1.value="deleteAsset";
		element1.name="action";
		form.appendChild(element1);
		
		var element2 = document.createElement("input");  
		element2.type="hidden";
		element2.value=assetID;
		element2.name="id";
		form.appendChild(element2); 

	    document.body.appendChild(form);
	   	form.submit();
	}
}