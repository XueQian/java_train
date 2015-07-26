$(document).ready(function() {

    var form = $('#updateUser');
    var id = $('#userId').val();

    form.submit(function(ev) {
        $.ajax({
            type: "PUT",
            url: "/web/users/modification/" + id,
            data: form.serialize(),
            success: function() {

                window.location = "/web/users";
            }
        });
        ev.preventDefault();
    });
});