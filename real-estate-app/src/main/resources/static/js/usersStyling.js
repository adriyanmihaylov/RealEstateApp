$.get("api/users"),function (users) {
    users.forEach(function (user) {
        $("<div>")
            .html(user)
            .appendTo(document.body);
    });
}