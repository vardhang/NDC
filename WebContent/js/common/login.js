 $(document).ready(function(){

	   $(".showpassword").each(function(index,input) {
	        var $input = $(input);
	        $("<p class='opt'/>").append(
	            $("<input type='checkbox' class='showpasswordcheckbox' id='showPassword' />").click(function() {
	                var change = $(this).is(":checked") ? "text" : "password";
	                var rep = $("<input placeholder='Password' type='" + change + "' />")
	                    .attr("id", $input.attr("id"))
	                    .attr("name", $input.attr("name"))
	                    .attr('class', $input.attr('class'))
	                    .val($input.val())
	                    .insertBefore($input);
	                $input.remove();
	                $input = rep;
	             })
	        ).append($("<label for='showPassword'/>").text("Show password")).insertAfter($input.parent());
	    });

	    $('#showPassword').click(function(){
			if($("#showPassword").is(":checked")) {
				$('.icon-lock').addClass('icon-unlock');
				$('.icon-unlock').removeClass('icon-lock');    
			} else {
				$('.icon-unlock').addClass('icon-lock');
				$('.icon-lock').removeClass('icon-unlock');
			}
	    });
	    
	    
	    $('#btnSubmit').click(function(){
	   	 alert(' Hi ');
	   		var login = $('#login').val();
	   		var password = $('#password').val();
	   	  
	   		if( login =='' || password ==''){
	   			$('input[type="text"],input[type="login"]').css("border","2px solid red");
	   			$('input[type="text"],input[type="password"]').css("box-shadow","0 0 3px red");
	   			alert("Please fill all fields...!!!!!!");
	   		}
	   	  return false;
	   	  /*$.ajax({  
	   	       type: "GET",  
	   	       url: 'login',  
	   	       data: {login:login, password:password },  
	   	       success: function(response){
	   	    	 alert(" response >> "+ response)
	   	          if(response != null) {
	   	        	 
	   	                 $('#dynerr').empty();
	   	                 $('#dynerr').append('<div><font color=\"red\"><b>' +response+ '</b></font></div>');
	   	          }
	   	      },  
	   	       error: function(xhr, ajaxOptions, thrownError) {
	   	           alert("err"+thrownError+xhr.responseText);
	   	         }
	   	     }); 
	   	  */

	   	});
});
 
