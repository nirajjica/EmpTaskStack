var baseUrl; 
var table;
var deptArr = [];
var roleArr = [];
var employeeArr = [];

var deptArrSe = [];
var roleArrSe = [];
var employeeArrSe = [];

$(document).ready(function(){
	validateAttachForm($('#departmentForm'));
	/*$('#datepicker input ').bootstrapMaterialDatePicker({
		format: 'DD/MM/YYYY',
		clearButton: true,
		weekStart: 1,
		time: false
	});
	*/
	$('.menu span').click(function() {
		  $('.navLinks').hide().filter(this.getAttribute('divName')).show();
	});
});
var department = {
		save : function(){
			var valid = $('#departmentForm').validationEngine('validate'); 
			if(!valid){
				return;	
			}else{
				console.log($('#departmentForm').serialize()); 
				$.post({
					url : baseUrl+'/department/create-department',
					data : $('form[id=departmentForm]').serialize(),
					success : function(res) {
						department.get();
						$('#departmentForm').get(0).reset();
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert("Error");
					}
				});
			}
		},

		get : function(){
			
			
			deptArr = [];
			roleArr = [];
			employeeArr = [];

			deptArrSe = [];
			roleArrSe = [];
			employeeArrSe = [];
			
			$('#departmentForm').get(0).reset();

			
			table =  $('#deptTable').dataTable({
			        "sPaginationType": "full_numbers",
			        "bServerSide": true,
			        "bPaginate": true,
			        "autoWidth":false,
			        "bProcessing": true,
			        "sAjaxSource":baseUrl+"/department/get-departments",
			        "bDestroy": true,
			        "aoColumns": [
			        	{"mData": "id"},
			        	{"mData": "code"},
			            {"mData": "name"},
			            {"mData": null,
			                "bSortable": false,
			                "mRender": function (data, type, item) {
			                	deptArr[item.id] = item;
			                	deptArrSe.push(item);
			                    return '<button class="btn btn-primary" onclick="department.deleteDept(\'' + item.id + '\')">Delete</button>&nbsp;<button class="btn btn-primary" onclick=department.edit(\'' + item.id + '\');>Edit</button>';
			                }
			            }
			        ],
			        "columnDefs": [
			            { "width": "150px", "targets": 0 },
			            { "width": "150px", "targets": 1 },
			            { "width": "100px", "targets": 2 },
			            { "width": "200px", "targets": 3 },
			        ]
			    });
		},
		
		edit : function(id){
			var obj = deptArr[id];
			$('#departmentForm').find('#name').click().focus().val(obj.name);
			$('#departmentForm').find('#code').click().focus().val(obj.code);
			$('#departmentForm').find('#id').click().focus().val(obj.id);
		}
};

var role = {
		save : function(){
			$('#roleForm').find('input').attr('disabled',false);
			var valid = $('#roleForm').validationEngine('validate'); 
			if(!valid){
				return;	
			}else{
				
				$.post({
					url : baseUrl+'/role/create-role',
					data : $('form[id=roleForm]').serialize(),
					success : function(res) {
						role.get();
						$('#roleForm').get(0).reset();
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert("Error");
					}
				});
			}
		},

		get : function(){
			
			$('#roleForm').get(0).reset();
			deptArr = [];
			roleArr = [];
			employeeArr = [];

			deptArrSe = [];
			roleArrSe = [];
			employeeArrSe = [];

			
			table =  $('#roleTable').dataTable({
			        "sPaginationType": "full_numbers",
			        "bServerSide": true,
			        "bPaginate": true,
			        "autoWidth":false,
			        "bProcessing": true,
			        "sAjaxSource":baseUrl+"/role/get-role",
			        "bDestroy": true,
			        "aoColumns": [
			        	{"mData": "name"},
			        	{"mData": "menus"},
			            {"mData": null,
			                "bSortable": false,
			                "mRender": function (data, type, item) {
			                	roleArr[item.name] = item;
			                	roleArrSe.push(item);
			                	return '<button class="btn btn-primary" onclick="role.deleteDept(\'' + item.name + '\')">Delete</button>&nbsp;<button class="btn btn-primary" onclick=role.edit(\'' + item.name + '\');>Edit</button>';
			                }
			            }
			        ],
			        "columnDefs": [
			            { "width": "150px", "targets": 0 },
			            { "width": "150px", "targets": 1 },
			            { "width": "100px", "targets": 2 },
			        ]
			    });
		},
		
		edit : function(name){
			var obj = roleArr[name];
			$('#roleForm').find('#name').click().focus().val(obj.name).attr('disabled',true);
			$('#roleForm').find('#menu').click().focus().val(obj.menus);
		}
};

var employee = {
		save : function(){
			$('#employeeForm').find('input').attr('disabled',false);
			var valid = $('#employeeForm').validationEngine('validate'); 
			if(!valid){
				return;	
			}else{
				
				$.post({
					url : baseUrl+'/employee/create-employee',
					data : $('form[id=employeeForm]').serialize(),
					success : function(res) {
						employee.get();
						$('#employeeForm').get(0).reset();
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert("Error");
					}
				});
			}
		},

		get : function(){
			$('#employeeForm').get(0).reset();
			deptArr = [];
			roleArr = [];
			employeeArr = [];

			deptArrSe = [];
			roleArrSe = [];
			employeeArrSe = [];

			table =  $('#empTable').dataTable({
			        "sPaginationType": "full_numbers",
			        "bServerSide": true,
			        "bPaginate": true,
			        "autoWidth":false,
			        "bProcessing": true,
			        "sAjaxSource":baseUrl+"/employee/list-employee",
			        "bDestroy": true,
			        "aoColumns": [
			        	{"mData": "id"},
			        	{"mData": "fname"},
			        	{"mData": "lname"},
			            {"mData": null,
			                "bSortable": false,
			                "mRender": function (data, type, item) {
			                	employeeArr[item.id] = item;
			                	employeeArrSe.push(item);
			                	return '<button class="btn btn-primary" onclick="employee.deleteDept(\'' + item.id + '\')">Delete</button>&nbsp;<button class="btn btn-primary" onclick=employee.edit(\'' + item.id + '\');>Edit</button>';
			                }
			            }
			        ],
			        "columnDefs": [
			            { "width": "150px", "targets": 0 },
			            { "width": "150px", "targets": 1 },
			            { "width": "100px", "targets": 2 },
			            { "width": "200px", "targets": 3 },
			        ]
			    });
			
				department.get();
				role.get();
				
				console.log(deptArr);
				console.log(roleArr);
				console.log(employeeArr);
				setTimeout(function(){
					$('#departmentId').html('');
					$('#departmentId').append('<option value="">Select department</option>');
					$.each(deptArrSe,function(key,obj){
						var str = '<option value ="'+obj.id+'">'+obj.name+'</option>';
						$('#departmentId').append(str);
					});
					
					
					$('#roleName').html('');
					$('#roleName').append('<option value="">Select rollname</option>');
					$.each(roleArrSe,function(key,obj){	
						var str = '<option value ="'+obj.name+'">'+obj.name+'</option>';
						$('#roleName').append(str);
					});
					
					$('#manager').html('');
					$('#manager').append('<option value="">Select manager</option>');
					$.each(employeeArrSe,function(key,obj){	
						var str = '<option value ="'+obj.id+'">'+obj.fname+'</option>';
						$('#manager').append(str);
					});	
				}, 1500);
				
			
				
		},
		
		edit : function(id){
			var obj = employeeArr[id];
			var sectionDiv = $('#employeeForm');
			for(key in obj){
				$(sectionDiv).find('input[name="'+key+'"]').focus().val(obj[key]);
				if(key == "departmentId"){
					$('#departmentId').val(obj[key]);
				}else if(key == "roleName"){
					$('#roleName').val(obj[key]);
				}else if(key == "manager"){
					$('#manager').val(obj[key]);
				}else if(key == "accounttype"){
					$('#accounttype').val(obj[key]);
				}
			}
			
		}
};


function validateAttachForm(blockObj){

	$(blockObj).validationEngine('attach', {
		scroll: false,
		promptPosition: "bottomLeft",
		showArrow: true,
		bind:false,
		autoHidePrompt : true,
		autoHideDelay : 4000,
		showArrowOnRadioAndCheckbox: true
	});

}

function validateForm(blockObj){
	var validateFlag = false;
	var validateObj = null;

	blockObj.find("input").each(function(){

		var validateInput = $(this).validationEngine('validate', {
			scroll: false,
			promptPosition: "bottomLeft",
			showArrow: true,
			bind:false,
			showArrowOnRadioAndCheckbox: true
		});

		if(validateInput)
		{
			validateFlag = true;
			if(validateObj == null)
				validateObj = $(this);
		}

	});

	blockObj.find("select").each(function(){

		var validateInput = $(this).validationEngine('validate', {
			scroll: false,
			promptPosition: "topRight",
			showArrow: true,
			bind:false,
			showArrowOnRadioAndCheckbox: true
		});

		if(validateInput)
		{
			validateFlag = true;
			if(validateObj == null)
				validateObj = $(this);
		}
	});

	blockObj.find("textarea").each(function(){
		var validateInput = $(this).validationEngine('validate', {
			scroll: false,
			promptPosition: "topRight",
			showArrow: true,
			bind:false,
			showArrowOnRadioAndCheckbox: true
		});

		if(validateInput)
		{
			validateFlag = true;
			if(validateObj == null)
				validateObj = $(this);
		}
	});

	console.log(validateObj);
	if(validateFlag)
	{
		validateObj.focus();
	}


	return validateFlag;
}
