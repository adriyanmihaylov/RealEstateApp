var $loader =  $("#loader");
var $main = $("#main-content")
var displayLoader = function(){
    $loader.css("display", "block");
}



$(document).ready(function () {
    $("#search").click(function () {
        displayLoader();
        $loader.fadeOut(3000)
        $.get("http://localhost:8080/api/posts/latest5", function (data) {
            data.forEach(function (element) {
                var id = element.id;
                var button1 = $("<button type='button' class='btn btn-sm btn-outline-secondary'>" + "View" + "</button>")
                var button2 = $("<button type='button' class='btn btn-sm btn-outline-secondary' id=id>" + "Edit" + "</button>")
                var btnGroup = $("<div class = 'btn-group'>" + "</div>");

                btnGroup.append(button2, button1);
                var d_flexDiv = $("<div class='d-flex justify-content-between align-items-center'></div>");
                d_flexDiv.append(btnGroup);
                var textParagraph = $("<p class='card-text'>" + element.title + element.author.lastName
                    + element.description + "</p>");

                var divCardBody = $("<div class = card-body> </div>");
                divCardBody.append(textParagraph, d_flexDiv);
                var img = $("<img class='card-img-top' src='img/9.jpg' alt='Card image cap'>");

                var divCard = $("<div class='card mb-4 box-shadow'></div>");
                divCard.append(img, divCardBody);
                var divCol = $("<div class=\"col-md-4\"></div>")
                divCol.append(divCard);

                $("#posts").append(divCol);

            })
        })
       $.get( "http://localhost:8080/api/posts/", function( data ) {
            data.forEach(function (element) {
                var button1 = $("<button type='button' class='btn btn-sm btn-outline-secondary'>" + "View" + "</button>" )
                var button2 = $("<button type='button' class='btn btn-sm btn-outline-secondary'>" + "Edit" + "</button>" )
                var btnGroup = $("<div class = 'btn-group'>" + "</div>");

                btnGroup.append(button2, button1);
                var d_flexDiv = $("<div class='d-flex justify-content-between align-items-center'></div>");
                d_flexDiv.append(btnGroup);
                var textParagraph = $("<p class='card-text'>" + element.title + element.author.lastName
                    + element.description + "</p>");

                var divCardBody = $("<div class = card-body> </div>");
                divCardBody.append(textParagraph, d_flexDiv);
                var img = $("<img class='card-img-top' src='img/9.jpg' alt='Card image cap'>");

                var divCard = $("<div class='card mb-4 box-shadow'></div>");
                divCard.append(img, divCardBody);
                var divCol =$("<div class=\"col-md-4\"></div>")
                divCol.append(divCard);

                $("#allPosts").append(divCol);

            })
        });
        $main.fadeIn(3050);
    })
})