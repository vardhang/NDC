$(document).ready(function() {
	/*var productId = $("#productId").val();*/
	var productId = queryParameters().productId;
	/*	 $.ajax({
  	       dataType: "json",  
  	       type: "GET",  
  	       url: 'get_suppliers',  
  	     data : '', 
	       success: function(data){ 
	    	   var includedColumns = [{"sTitle": "Product Code", "mData": "productCode" }];
	    	   includedColumns.push({"sTitle": "Product Name", "mData": "productName" });
	    	   for ( var  i= 0; i < data.length; i++) {
	    		   includedColumns.push({"sTitle": data[i].supplierName, "mData": "rate" });
	    	   }
	    	   oTable = $('#allProducts').dataTable(
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
	    					"sAjaxSource" : 'get_supplier_product_rates',
	    					"aoColumns" : includedColumns,
	    					"fnServerData" : function(sSource, aoData, fnCallback) {
	    						$.ajax({
	    									dataType : 'json',
	    									type : "GET",
	    									url : 'get_supplier_product_rates',
	    									data : {productId:productId}, 
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

	       },  
	       error: function(xhr, ajaxOptions, thrownError) {
	           alert("err"+thrownError+xhr.responseText);
	         }
  	     });
*/		 
	
	
	$.ajax({
	       dataType: "json",  
	       type: "GET",  
	       url: 'get_supplier_product_rates',  
	       data : {productId:'100'}, 
	       success: function(data){ 
	    	 var str= "<tr><th>Product Code</th><th>Product Name</th>";
	    		   for ( var  i= 0; i < data.length; i++) {
	    			 str = str+"<th>"+data[i].supplierName+"</th>";
	    		   }
	    		 str = str+"<th>Best Rate</th></tr><tr><td>"+ data[0].productCode+"</td><td>"+ data[0].productName+"</td>";
	    		 
	    		for ( var  i= 0; i < data.length; i++) {
	    			str = str+"<td>"+data[i].rate+"</td>";
	    		   }
	    		str=str+"<td>"+data[0].rate+"</td>";
	    		$("#allProducts").html(str);
	    		$('#allProducts').append('<br />');
	       },  
	       error: function(xhr, ajaxOptions, thrownError) {
	           alert("err"+thrownError+xhr.responseText);
	         }
	     });
});


function queryParameters () {
    var result = {};

    var params = window.location.search.split(/\?|\&/);

    params.forEach( function(it) {
        if (it) {
            var param = it.split("=");
            result[param[0]] = param[1];
        }
    });

    return result;
}