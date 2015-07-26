$(document).ready(function() {

    var form = $('#login');

    form.submit(function(ev) {
        $.ajax({
            type: "POST",
            url: "/web/login/",
            data: form.serialize(),
            success: function(data) {

                if(data === 'the user is not exist') {

                    alert("该用户不存在，请重新操作");
                } else if(data === 'the password is incorrect') {

                    alert("密码错误，请重新操作");
                } else {

                    window.location = "/web/schedules";
                }
            }
        });
        ev.preventDefault();
    });
});