$(document).ready(function() {

    var form = $('#addUser');

    form.submit(function(ev) {
        $.ajax({
            type: "POST",
            url: "/web/users/creation",
            data: form.serialize(),
            success: function(data) {
                if(data === 'the user is exist') {

                    alert("该用户已存在，请重新操作");
                } else {
                    window.location = "../web/users";
                }
            }
        });
        ev.preventDefault();
    });
});