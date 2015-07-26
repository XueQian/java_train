$(document).ready(function() {

    var form = $('#addPrivateCoach');

    form.submit(function(ev) {
        $.ajax({
            type: "POST",
            url: "/web/schedules/private/creation",
            data: form.serialize(),
            success: function(data) {
                if(data === 'the customer has a private coach') {

                    alert("该顾客已经有私教，请重新操作");
                } else if(data === 'the coach is busy') {

                    alert("您所添加的教练时间冲突，请重新操作");
                } else {

                    window.location = "../web/schedules";
                }
            }
        });
        ev.preventDefault();
    });
});