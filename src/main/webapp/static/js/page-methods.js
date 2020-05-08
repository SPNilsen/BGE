var pathname = window.location.pathname;
console.log("pathname: " + pathname);
$(document).ready(function(){
    if (pathname == "/CCPortal/Allocation"){
                
    }
    
    $("#oeOverflow2").change(function(){
        var selectedOption = $("#oeOverflow2 option:selected").val();
        $("#oeITEL").text(100-selectedOption);
    });
    
    $("#osOverflow2").change(function(){
        var selectedOption = $("#osOverflow2 option:selected").val();
        $("#osITEL").text(100-selectedOption);
    });
    
    $("#csOverflow2").change(function(){
        var selectedOption = $("#csOverflow2 option:selected").val();
        $("#csITEL").text(100-selectedOption);
    });
});