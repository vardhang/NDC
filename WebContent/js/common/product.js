var oldProductName='';
	var oldProductDetails='';
	var oldProductCode='';

$(document).ready(function() {

	$("#productForm").validate({
		rules: {
			productCode: "required",
			productName: "required"
		},
		messages: {
			productCode: "Please enter product code",
			productName: "Please enter product name"
		}
	});
	
	$('#dynerr').empty();
	$( "#productName" ).autocomplete({
			source: 'get_product_name',
			select: function(event, ui) {
				
	            $.ajax({
					   dataType: "json", 
		    	       type: "GET",  
		    	       url: 'get_product',  
		    	       data : {code:'', name:ui.item.value }, 
		    	       success: function(response){ 
		    	    	   oldProductCode=response[0].productCode;
		    	    	   oldProductName = response[0].productName;
		    	    	   oldProductDetails = response[0].productDetails;

		    	    	   $('#productCode').val(response[0].productCode); 
		    	    	   $('#productDetails').val(response[0].productDetails); 
		    	    	   $("#btnSubmit").prop('value', 'Update');
		    	       },  
		    	       error: function(xhr, ajaxOptions, thrownError) {
		    	           alert("err : "+thrownError+xhr.responseText);
		    	         }
		    	     });

	       }

	});
	
	
	
	$( "#productCode" ).autocomplete({
		source: 'get_product_code',
			select: function(event, ui) {
	            $.ajax({
					   dataType: "json", 
		    	       type: "GET",  
		    	       url: 'get_product',  
		    	       data : {code:ui.item.value, name:'' }, 
		    	       success: function(response){ 
		    	    	   oldProductCode=response[0].productCode;
		    	    	   oldProductName = response[0].productName;
		    	    	   oldProductDetails = response[0].productDetails;

		    	    	   $('#productName').val(response[0].productName); 
		    	    	   $('#productDetails').val(response[0].productDetails); 
		    	    	   $("#btnSubmit").prop('value', 'Update');
		    	       },  
		    	       error: function(xhr, ajaxOptions, thrownError) {
		    	           alert("err : "+thrownError+xhr.responseText);
		    	         }
		    	     });

	       }
	});
	
    $('#btnCancel').live("click", function(event){	
    	window.location.reload();
    });
	
});


$.validator.setDefaults({
	submitHandler: function() {
	 	 var productCode = $("#productCode").val();
    	 var productName = $("#productName").val();
    	 var productDetails = $("#productDetails").val();
    	 alert("oldProductCode >>> "+ oldProductCode);
    	 alert("productCode >>> "+ productCode);
   	 if(oldProductCode!==productCode){
		    	$('#dynerr').empty();
		    	$.ajax({
		  	       type: "GET",  
		  	       url: 'insert_products',  
		  	       data : {productCode:productCode, productName:productName, productDetails:productDetails }, 
		  	       success: function(response){ 
		  	    	   if(response=='Success'){
		  	    		   $('#dynerr').empty();
		                     $('#dynerr').append('<div><font color=\"green\"><b>Successfully Inserted</b></font></div><br>');
		  	    	   }else{
		  	    		   $('#dynerr').empty();
		                     $('#dynerr').append('<div><font color=\"red\"><b>' +response+ '</b></font></div><br>'); 
		  	    	   }
		  	    	 
		  	    	   },  
		  	       error: function(xhr, ajaxOptions, thrownError) {
		  	           alert("err : "+thrownError+xhr.responseText);
		  	         }
		  	     });

    		 return false;
    	 }else if(oldProductName!==productName ||  oldProductDetails!==productDetails){
    		 $('#dynerr').empty();
    		 $.ajax({
		  	       type: "GET",  
		  	       url: 'update_products',  
		  	       data : {productCode:productCode, productName:productName, productDetails:productDetails }, 
		  	       success: function(response){ 
		  	    	   if(response=='Success'){
		  	    		   $('#dynerr').empty();
		                     $('#dynerr').append('<div><font color=\"green\"><b>Successfully Updated</b></font></div><br>');
		  	    	   }else{
		  	    		   $('#dynerr').empty();
		                     $('#dynerr').append('<div><font color=\"red\"><b>' +response+ '</b></font></div><br>'); 
		  	    	   }
		  	    	 
		  	    	   },  
		  	       error: function(xhr, ajaxOptions, thrownError) {
		  	           alert("err : "+thrownError+xhr.responseText);
		  	         }
		  	     });
    		 return false;
    	 }else if(oldProductCode==productCode && oldProductName==productName &&  oldProductDetails==productDetails){
    		 $('#dynerr').empty();
    		 $('#dynerr').append('<div><font color=\"red\"><b>Records are already exists</b></font></div><br>');
    		 return false;
    	 }
    	 
   	return false;

	}
});