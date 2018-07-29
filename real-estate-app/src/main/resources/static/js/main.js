$.get( "/api/users/", function( data ) {
    $( ".body" ).html( data );
    alert( "Load was performed." );
});