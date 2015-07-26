
$(document).ready(function() {

    var form = $('#addSchedule');

    form.submit(function (ev) {
        $.ajax({
            type: "POST",
            url: "/web/schedules/creation",
            data: form.serialize(),
            success: function (result) {
                if(result == 'coach is busy'){

                    alert("您所添加的");
                }else{
                    window.location = "../web/schedules";
                }
            }
        });
        ev.preventDefault();
    });
});