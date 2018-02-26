//var oTable;
$(document).ready(function() {
	 
	/*$('a[rel*=leanModal]').leanModal({ top : 200, closeButton: ".modal_close" });*/
	$('#dynerr').empty();
	$( "#productName" ).autocomplete({
		source: 'get_product_name'
	});
	
	$( "#supplierName" ).autocomplete({
		source: 'get_supplier_name'
	});
	
	$("#ratesForm").validate({
		rules: {
			productName: "required",
			supplierName: "required",
			rate: {required:true,number: true}
		},
		messages: {
			productName: "Please enter product name",
			supplierName: "Please enter supplier name",
			
			rate: "Please enter a valid rate"
		}
	});
	
	//getSuppliers();
	
	/*$('#btnLookup').click(function(){
		 var lookupProductName = $("#lookupProductName").val();
		 oTable = $('#searchAllProducts').dataTable(
			      {
					"bJQueryUI" : true,
					"sPaginationType" : "full_numbers",
					"bSortCellsTop" : true,
					"sServerMethod" : "GET",
					"bServersSide" : true,
					"bAutoWidth" : false,
					"bRetrieve" : true,
					"bFilter" : false,
					"bProcessing" : true,
					"bPaginate" : true,
					"sScrollY"		: "150px",
					"bInfo" : false,
					"bLengthChange": false,
					"sAjaxSource" : 'get_all_products',
					"aoColumns" : [
							{
								"sTitle": "Select",
								"sWidth" : "10px",
								"bSortable" : false,
								"mDataProp" : null,
								"sDefaultContent" : '<input type=\"radio\" name=\"selectProductName\"  id=\"selectProductName\">'
									
							},
							{
								"sTitle": "Product Id",
								"sWidth" : "70px",
								"bSortable" : true,
								"mDataProp" : "productId"
									
							},
							{
								"sTitle": "Product Name",
								"sWidth" : "70px",
								"bSortable" : true,
								"mDataProp" : "productName"
							},
							{
								"sTitle": "Product Code",
								"sWidth" : "70px",
								"bSortable" : true,
								"mDataProp" : "productCode"
							}
						],
					"fnServerData" : function(sSource, aoData, fnCallback) {
						$.ajax({
									dataType : 'json',
									type : "GET",
									url : 'get_all_products',
									data : "",
									success : function(json) {
										fnCallback(json);
									},
									error : function(
											XMLHttpRequest,
											textStatus,
											errorThrown) {
										  alert("err"+errorThrown+XMLHttpRequest.responseText);
									}
								});
					}
				});
		    });
*/
	
    $('#btnCancel').live("click", function(event){	
    	window.location.reload();
    });
    
});


$.validator.setDefaults({
	submitHandler: function() {
		alert('Hello >> ');
   	/* var productName = $("#productName").val();
	 var supplierName = $("#supplierName").val();
	 var rate = $("#rate").val();
	 alert(' name : '+ productName+" supplier Name : "+ supplierName+ " rate : "+rate);
	*//* $.ajax({
	       type: "GET",  
	       url: 'insert_rates',  
	       data : {productName:productName, supplierName:supplierName,rate:rate }, 
	       success: function(response){ 
	    	   if(response=='Success'){
	    		   $('#dynerr').empty();
                   $('#dynerr').append('<div><font color=\"green\"><b>Successfully Inserted</b></font></div>');
	    	   }else{
	    		   $('#dynerr').empty();
                   $('#dynerr').append('<div><font color=\"red\"><b> Insertion Failed</b></font></div>'); 
	    	   }
	    	 
	    	   },  
	       error: function(xhr, ajaxOptions, thrownError) {
	           alert("err : "+thrownError+xhr.responseText);
	         }
	     });

	return false;
*/
	}
});