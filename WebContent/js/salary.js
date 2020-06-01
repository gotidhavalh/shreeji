$(document).ready(function(e){


	$('body').on('click','#saveVerify',function(){
		var id=$(this).val();
		var hra = $(this).closest('.modal-content').find('#basic').val();
		var deduct = $(this).closest('.modal-content').find('#leaveDeduct').val();
		var net= $(this).closest('.modal-content').find('#netSalary').val();
		var type = $(this).closest('.modal-content').find('#paymentTypeOption').val();
		var chequeNo = $(this).closest('.modal-content').find('#chequeNo').val();
		
		$.ajax({
			url : "MainController",
			type : "POST",
			datatype : "json",
			data : {
				action :"singleVerify",
				ID : id,
				salary :hra,
				deduct : deduct,
				netSalary : net,
				paymentType : type,
				Cheque : chequeNo
			},

			success : function(data) {
				console.log(" success");
				$('.salary'+id+'').modal('toggle');
				window.location.reload(true);
			},
			error : function(err) {

				console.log(err);
			}

		});
	
	});	

	
	// List Of Salary Key
	$('.salary_list').on('keyup', function (e) {
    let donateVal = $(this).val();
    this.value = this.value.replace(/[^0-9.]/g, '');
    $(this).closest('.custom-salary-slip').find('.subTotal').val(this.value);
    var leaveDeduct = $(this).closest('.custom-salary-slip').find('.leaveDeduct').val();
    var finalSalary = parseInt(this.value) - parseInt(leaveDeduct);
    $(this).closest('.custom-salary-slip').find('.finalTotalSalary').val(finalSalary);
  })
	
	
	//  Particular CheckBox Event
	var $checkboxes = $('.checkBoxCustom');
	
	$('body').on('click','.checkBoxCustom',function(){

		var $this = $(this);
		if($(this).prop("checked") == true){
            $(this).closest('tr').find('.verifyButton').prop("disabled",true);
        }
        else if($(this).prop("checked") == false){
        	$(this).closest('tr').find('.verifyButton').prop("disabled",false);
        }
      
		var check = $('.checkBoxCustom:checked').length;
        if(check ==0){
        	$("#select").hide();
        }
        else{
//        	$("#select").show().text(check+" Selected");
        	$("#select").show().val(check+" Selected");
        }
        var totalCheckBox = $('.checkBoxCustom').length;
        console.log("total->",totalCheckBox);
       
        if (check === totalCheckBox) {
            $('#select-all').prop('checked',true);
         }else{
        	 $('#select-all').prop('checked',false);
         }
    });
	
	//All CheckBox
	$("#select-all").click(function(e){
		var count=0;
		if(this.checked){
			$(':checkbox').each(function(){
				this.checked =true;
				count = count + 1;
				$('body').find('.verifyButton').prop("disabled",true);
			});
			$("#select").show().text(--count+" Selected");
		}
		else{
			$(':checkbox').each(function(){
				this.checked =false;
				$("#select").hide();
				$('body').find('.verifyButton').prop("disabled",false);
			});
		}
		
	});
	
	 $('body').on('change','#paymentTypeOption',function(){
		
		    if($(this).val() == 'bank'){
		    	$(this).next('#chequeNo').css('visibility','hidden');
		    }else if($(this).val() == 'cheque'){
		    	$(this).next('input').css('visibility','visible');
		    }else if($(this).val() == 'cash'){
		    	$(this).next('input').css('visibility','hidden');
		    }
	    });
	 
	 $('body').on('change','.dataTables_length',function(){
		 
		 alert("fd");
//		 var $row = $('body').closest("tr");    // Find the row
//		 var $text = $row.find(":button").val(); // Find the text
//		 console.log($text);
		 var v = $('body').find('.btn-sm').val();
		 alert(v);
		
	 });
		
	 
	$("#listSalary").DataTable({
		
		dom: 'l<"toolbar">frtip',
		ajax : {
			url : "MainController",
			type : "POST",
			data : {
				action : "listSalaryJSON",
			}
		},
		columns : [
			{
				data :"ID",
				render: function (data, type, row)
				{
					return '<input type="checkbox" class="checkBoxCustom" id="listCheckbox" name="test" value="'+data+'">';
				}
			},
//			{
//				data : "ID",
//				"visible": false
//			},
			{
				data : "FirstName"
			},{
				data : "salary"	
			},{
				data :"paymentType"
			},
			{
				data :"month"
			},
			{
				data :"status",
				"bSortable": false,
				className: "text-center",
				render : function(data, type, row)
				{	
					
					if(data == true)
					{
						console.log('if-->',row.DT_RowId);
//							$('#'+row.DT_RowId).find('.checkBoxCustom').prop("disabled", true);
							$('#'+row.DT_RowId).find('.checkBoxCustom').remove();
						return '<input type="button" value="Verified" class = "btn btn-sm btn-success test"  disabled=disabled>';
					}
					else{
						console.log('else---->',row.DT_RowId);
//						$('#'+row.DT_RowId).find('.checkBoxCustom').prop("disabled",false);
						 $('.checkBoxCustom').prop("disabled",false);
						return '<input type="button" class ="verifyButton btn btn-sm btn-primary" id="verifyid" data-toggle="modal" data-target=".salary'+row.ID+'" value="Verify"> ';
					}
//					return ' <input type="button" name="My button"  data-toggle="modal" data-target=".salary'+data+'"  value="Click" onClick="clic();">';
				}
			}
			]
		});
//		$("div.toolbar").html('<div class="row"><div class="col-2"><button class="btn btn-primary" id="select" onclick=" addEmp()" style="display :none">selected</button></div><div class="col-2 "></div>');
	});
