var oldSupplierContactNo='';
var oldSupplierContactPerson='';
var oldSupplierDetails='';
var oldSupplierName='';
$(document).ready(function() {

	$('#dynerr').empty();
	
	$("#supplierForm").validate({
		rules: {
			supplierName: "required",
			contactPerson: "required",
			contact: {required:true,number: true}
		},
		messages: {
			supplierName: "Please enter supplier name",
			contact: "Please enter contact number",
			contactPerson: "Please enter contact person"
		}
	});
	
	
	$( "#supplierName" ).autocomplete({
		source: 'get_supplier_name',
			select: function(event, ui) {
	            $.ajax({
					   dataType: "json", 
		    	       type: "GET",  
		    	       url: 'get_suppliers_by_name',  
		    	       data : {supplierName:ui.item.value }, 
		    	       success: function(response){ 
		    	    	   oldSupplierName=response[0].supplierName;
		    	    	   oldSupplierContactNo = response[0].supplierContactNo;
		    	    	   oldSupplierContactPerson = response[0].supplierContactPerson;
		    	    	   oldSupplierDetails=response[0].supplierDetails;
		    	    	   
		    	    	   $('#contact').val(response[0].supplierContactNo); 
		    	    	   $('#contactPerson').val(response[0].supplierContactPerson); 
		    	    	   $('#supplierDetails').val(response[0].supplierDetails); 
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
   	 var supplierName = $("#supplierName").val();
	 var contact = $("#contact").val();
	 var contactPerson = $("#contactPerson").val();
	 var supplierDetails = $("#supplierDetails").val();
	 
	 
	 if(oldSupplierName == supplierName && oldSupplierContactNo==contact && oldSupplierContactPerson==contactPerson && oldSupplierDetails==supplierDetails){
		 $('#dynerr').empty();
         $('#dynerr').append('<div><font color=\"red\"><b>Record already exists</b></font></div>');
         return false;
	 }
	
	
	 if(oldSupplierName == supplierName){
		 alert('update');
		 $.ajax({
		       type: "GET",  
		       url: 'update_suppliers',  
		       data : {supplierName:supplierName, contact:contact, contactPerson:contactPerson,supplierDetails:supplierDetails }, 
		       success: function(response){ 
		    	   if(response=='Success'){
		    		   $('#dynerr').empty();
	                   $('#dynerr').append('<div><font color=\"green\"><b>' +response+ '</b></font></div>');
		    	   }else{
		    		   $('#dynerr').empty();
	                   $('#dynerr').append('<div><font color=\"red\"><b>' +response+ '</b></font></div>'); 
		    	   }
		    	 
		    	   },  
		       error: function(xhr, ajaxOptions, thrownError) {
		           alert("err : "+thrownError+xhr.responseText);
		         }
		     });

	 } else {
		 alert('insert');
		 $.ajax({
		       type: "GET",  
		       url: 'insert_suppliers',  
		       data : {supplierName:supplierName, contact:contact, contactPerson:contactPerson,supplierDetails:supplierDetails }, 
		       success: function(response){ 
		    	   if(response=='Success'){
		    		   $('#dynerr').empty();
	                   $('#dynerr').append('<div><font color=\"green\"><b>' +response+ '</b></font></div>');
		    	   }else{
		    		   $('#dynerr').empty();
	                   $('#dynerr').append('<div><font color=\"red\"><b>' +response+ '</b></font></div>'); 
		    	   }
		    	 
		    	   },  
		       error: function(xhr, ajaxOptions, thrownError) {
		           alert("err : "+thrownError+xhr.responseText);
		         }
		     });

	 }
	 
	return false;
	}
});