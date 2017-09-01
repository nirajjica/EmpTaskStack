var datatable;
var dataArray = []
$(document).ready(function () {
	
    $('#fileUploadForm').submit(function(evt) {

        evt.preventDefault();
        var oMyForm = new FormData($(this)[0]);
        
        $.ajax({
        type: 'POST',
        enctype: 'multipart/form-data',
        url: "api/upload",
        data:oMyForm,
        cache:false,
        contentType: false,
        processData: false,
        success: function(data) {
           alert('success');
           getAllDatas();
           var pdfWin = window.open("data:application/pdf;base64, " + data.value);
        },
        error: function(data) {
            alert('failed');
            getAllDatas();
        }
        });
    });
    
    $('#myModal').on('shown.bs.modal', function () {
    	  $('input').focus()
    });

});

function getAllDatas(){
	dataDetails.getAllDataDetails();
	dataDetails.getWaitingUploadedData();
	dataDetails.getCompletedUploadedData();
	dataDetails.getDeletedData();
}


var dataDetails = {
		getAllDataDetails : function(){
			  $.ajax({
			        type: 'GET',
			        url: "api/getAllUploadedData",
			        async: true,
		            cache: false,
		            dataType : "json",
		            contentType: "application/json",
			        success: function(data) {
			        	dataDetails.set(data,"dataDetailTable");
			        },
			        error: function(data) {
			            console.log("failed")
			        }
			});
		},
		
		getWaitingUploadedData : function(){
			  $.ajax({
			        type: 'GET',
			        url: "api/getWaitingUploadedData",
			        async: true,
		            cache: false,
		            contentType: "application/json",
			        success: function(data) {
			        	dataDetails.set(data,"dataWaitingDetailTable");
			        },
			        error: function(data) {
			            console.log("failed")
			        }
			});
		},
		
		getCompletedUploadedData : function(){
			  $.ajax({
			        type: 'GET',
			        url: "api/getCompletedUploadedData",
			        async: true,
		            cache: false,
		            contentType: "application/json",
			        success: function(data) {
			        	dataDetails.set(data,'dataCompletedDetailTable');
			        	console.log(data);
			        },
			        error: function(data) {
			            console.log("failed")
			        }
			});
		},
		
		getDeletedData : function(){
			  $.ajax({
			        type: 'GET',
			        url: "api/getAllDeletedData",
			        async: true,
		            cache: false,
		            contentType: "application/json",
			        success: function(data) {
			        	dataDetails.set(data,'dataDeletedDetailTable');
			        	console.log(data);
			        },
			        error: function(data) {
			            console.log("failed")
			        }
			});
		},
		
		set : function(dataList,tableName){
			
			dataArray = [];
        	$.each(dataList,function(key,obj){
        		dataArray[obj.id] = obj;
        	});
        	
			var dataTableTemp;
			if ($.fn.dataTable.isDataTable('#'+tableName)) {
				dataTableTemp = $('#'+tableName).DataTable();
				dataTableTemp.destroy();
            }
			
			dataTableTemp = $('#'+tableName).DataTable({
                "bProcessing": false,
                "bServerSide": false,
                "aaData": dataList,
                "bJQueryUI": true,
                "aoColumns": [
                    {"mData": "id"},
                    {"mData": "scheme"},
                    { "mData": "category" },
                    { "mData": "applno" },
                    { "mData": "name" },
                    { "mData": "address" },
                    { "mData": "houseNo" },
                    { "mData": "mobileNo" },
                    { "mData": "status" },
                    { "mData": "isDeleted" },
                    { "mData": null,
                    	 "render": function ( data, type, row ) {
                    	     return '<button class="btn btn-lg btn-primary" onclick=dataDetails.edit("'+row.id+'") type="button">Edit</button>';
                    	  }
                    },
                    { "mData": null,
                   	 "render": function ( data, type, row ) {
                   	     return '<button class="btn btn-lg btn-danger" onclick=dataDetails.del("'+row.id+'") type="button"> Delete </button>';
                   	  }
                   }
                ]
            });
			
			if(tableName == "dataDeletedDetailTable"){
				dataTableTemp.column(10).visible(false);
				dataTableTemp.column(11).visible(false);
			}
		},
		
		edit : function(rowId){
			$('#myModal').find("#postDetailsDataForm").get(0).reset();
			var sectionDiv = $('#myModal').find("#postDetailsDataForm");
			var object = dataArray[rowId];
			for(key in object){
				sectionDiv.find("input[name='"+key+"']").focus().click().val(object[key]);
			}
			$('#myModal').modal('toggle')
		},
		
		del : function(rowId){
			$.ajax({
				type : 'POST',
				url: "api/deleteUploadedData",
				async : true,
				data : {rowId:rowId},
				success : function(data) {
					getAllDatas();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					getAllDataDetails();
				}
			});
		},
		
		update : function(){
			 	var formData  = $('#postDetailsDataForm').serializeJSON();
				$.ajax({
					type : 'POST',
					contentType : 'application/json',
					url: "api/updateUploadedData",
					async : true,
					data : formData,
					dataType :"json",
					success : function(data) {
						$('#resetUpdateDetails').click();
						getAllDatas();
						$('#closeModel').click();
					},
					error : function(jqXHR, textStatus, errorThrown) {
						$('#resetUpdateDetails').click();
						getAllDatas();
						 $('#closeModel').click();
					}
				});
		},
		
		print : function(){
			$.ajax({
				type : 'GET',
				contentType : 'application/json',
				url: "api/printUploadedData",
				async : true,
				success : function(data, textStatus, jqXHR) {
					var pdfWin = window.open("data:application/pdf;base64, " + data.value);
				},
				error : function(jqXHR, textStatus, errorThrown) {
				}
			});
	},
	
};