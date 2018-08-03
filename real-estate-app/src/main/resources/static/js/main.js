var $loader =  $("#loader");

var displayLoader = function(){
    $loader.css("display", "block");
}

var hideLoader = function(){
    $loader.css("display", "none");

}
$(document).ready(function () {

    $("#search").click(function () {
        displayLoader();
        setTimeout(hideLoader(), 50000);
    })
})