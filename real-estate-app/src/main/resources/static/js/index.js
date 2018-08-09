// $(document).ready(function () {
//     $.get( "http://localhost:8080/latest", function( data ) {
//         $row = $("<div class = 'row'></div>");
//         console.log(data);
//         for (var i = 0; i < 3; i++) {
//             $anchor = $("<a href=\"#\"> </a>");
//             $cardList =$("<div class=\"card card-list\"></div>");
//
//             $cardFooter = $("<div class=\"card-footer\"></div>")
//             $spanBeds = $("<span><i class=\"mdi mdi-sofa\"></i> Beds : <strong>" + data[i].beds + "</strong></span>");
//             $spanBaths = $("<span><i class=\"mdi mdi-scale-bathroom\"></i> Baths : <strong>" + data[i].baths + "</strong></span>");
//             $spanSize = $("<span><i class=\"mdi mdi-move-resize-variant\"></i> Area : <strong>" + data[i].size + "</strong></span>")
//             $cardFooter.append($spanBeds);
//             $cardFooter.append($spanBaths);
//             $cardFooter.append($spanSize);
//
//             $cardBody = $("<div class=\"card-body\"></div>")
//             $price = $("<h2 class=\"text-success mb-0 mt-3\">"+ data[i].price + "<small>/month</small> </h2>");
//             $address = $("<h6 class=\"card-subtitle mb-2 text-muted\"><i class=\"mdi mdi-home-map-marker\"></i>" + data[i].address +  "</h6>");
//             $description = $("<h5 class=\"card-title\">" + data[i].description +   "</h5>");
//             $cardBody.append($price);
//             $cardBody.append($address);
//             $cardBody.append($description);
//
//             $image = $("<img class=\"card-img-top\" src=" + data[i].imgSrc  + " alt=\"Card image cap\">")
//             $badge = $("<span class=\"badge badge-success\">For Sale</span>");
//             $anchor.append($badge);
//             $anchor.append($image);
//             $anchor.append($cardBody);
//             $anchor.append($cardFooter);
//             $cardList.append($anchor);
//
//             $cardCol = $("<div class=\"col-lg-4 col-md-4\"> </div>");
//             $cardCol.append($cardList);
//
//         }
//         $row.append($cardCol);
//     });
// })