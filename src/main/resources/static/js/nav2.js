$(document).ready(function(){
    $("#preview").attr("scrolling", "no"); 
	
	// Fullscreen preview
    $("#myModal").on('show.bs.modal', function(event){
        $(this).find(".modal-body").html('<iframe src="bootstrap/navbar-dropdown-login-and-signup-form-with-social-buttons.php" frameborder="0" class="fullscreen"></iframe>');
    });  
    
    $("#tabs").tabs();
    
    
});
