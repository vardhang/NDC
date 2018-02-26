var productId= '';
var bestRate='';
$(document).ready(function() {
	$('#searchForm').validate();
	/*$('a[rel*=leanModal]').leanModal({ top : 200, closeButton: ".modal_close" });*/
	
	
	$( "#productName" ).autocomplete({
		source: 'get_search_Name',
			select: function(event, ui) {
	            $.ajax({
					   dataType: "json", 
		    	       type: "GET",  
		    	       url: 'get_product',  
		    	       data : {code:'', name:ui.item.value }, 
		    	       success: function(response){ 
		    	    	   $('#productCode').val(response[0].productCode); 
		    	       },  
		    	       error: function(xhr, ajaxOptions, thrownError) {
		    	           alert("err : "+thrownError+xhr.responseText);
		    	         }
		    	     });

	       }
	});
	
	 $('#showAllProducts').click(function(event){
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
				"sScrollY"		: "200px",
				"bInfo" : false,
				"sAjaxSource" : 'get_all_products',
				"aoColumns" : [
						{
							"sTitle": "Product Id",
							"sWidth" : "150px",
							"bSortable" : true,
							"mDataProp" : "productId"
						},
						{
							"sTitle": "Product Name",
							"sWidth" : "150px",
							"bSortable" : true,
							"mDataProp" : "productName"
						},
						{
							"sTitle": "Product Details",
							"sWidth" : "150px",
							"bSortable" : true,
							"mDataProp" : "productDetails"
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

/*    $('#signup').click(function(){
    	 $.ajax({
  	       dataType: "json",  
  	       type: "GET",  
  	       url: 'get_supplier_product_rates',  
  	       data : {productId:productId}, 
  	       success: function(data){ 
  	    	 var str= "<tr><th>Product Code</th><th>Product Name</th>";
  	    	 $("#searchAllProducts").html("<tr><th>Product Code</th><th>Product Name</th>");
  	    		   for ( var  i= 0; i < data.length; i++) {
  	    			 str = str+"<th>"+data[i].supplierName+"</th>";
  	    		   }
  	    		 str = str+"<th>Best Rate</th></tr><tr><td>"+ data[0].productCode+"</td><td>"+ data[0].productName+"</td>";
  	    		 
  	    		for ( var  i= 0; i < data.length; i++) {
  	    			str = str+"<td>"+data[i].rate+"</td>";
 	    		   }
  	    		str=str+"<td>"+bestRate+"</td>";
  	    		$("#searchAllProducts").html(str);
  	    		$('#searchAllProducts').append('<br />');
  	       },  
  	       error: function(xhr, ajaxOptions, thrownError) {
  	           alert("err"+thrownError+xhr.responseText);
  	         }
  	     });
    });*/

    
    
    $('.popup').popupWindow({ 
    	height:500, 
    	width:800, 
    	top:50, 
    	left:50 
    	}); 
    
});


$.validator.setDefaults({
	submitHandler: function() {
	 	 var productName = $("#productName").val();
    	 var productCode = $("#productCode").val();
    	 
    	if(productName=="" && productCode=="" ){
   		  $('#dynerr').empty();
             $('#dynerr').append('<div><font color=\"red\"><b>Please enter the product code or name</b></font></div>');
   		 return false;
    	 } else{
    		 $('#dynerr').empty();
    	 }
    	var dataToServer='';
    	if(productCode!="" && productName=="" ){
    		alert(' product name is null');
    		dataToServer = {productCode:productCode,productName:''};
    	}else if(productCode=="" && productName!="" ){
    		alert(' product code is null');
    		dataToServer = {productCode:'',productName:productName};
    	}
    	 
    	 $.ajax({
  	       dataType: "json",  
  	       type: "GET",  
  	       url: 'get_product_rates',  
  	       data : dataToServer, 
  	       success: function(data){ 
  	    	   if(data!=""){
  	    		   productId = data[0].productId;
  	    		   bestRate = data[0].rate;
  	    	   $("#searchProducts").html("<tr><td>Product Code</td><td>"+data[0].productCode+"</td></tr><tr><td>Product Name</td><td>"+data[0].productName+"</td></tr>" +
  	    	   		"<tr><td>Supplier Name</td><td>"+data[0].supplierName+"</td></tr><tr><td>Best Rate</td><td>"+data[0].rate+"</td></tr>");
  	    	   $('#searchProducts').append('<br />');
  	    	   $('#allproducts').hide();
  	    	   $('#compare').show();
  	    	   
  	       }else{
  	    	   $('#dynerr').empty();
  	           $('#dynerr').append('<div><font color=\"red\"><b>Please enter the correct product code or name</b></font></div>');
  	       }
  	       
  	       },  
  	       error: function(xhr, ajaxOptions, thrownError) {
  	           alert("err"+thrownError+xhr.responseText);
  	         }
  	     });
    	
    	return false;

	}
});