$(document).ready(function() {

    var form = $('#updateSchedule');
    var id = $('#scheduleId').val();

    form.submit(function(ev) {
        $.ajax({
            type: "PUT",
            url: "/web/schedules/modification/"+id,
            data: form.serialize(),
            success: function(data) {
                if(data === 'the coach is busy') {

                    alert("您所添加的教练时间冲突，请重新操作");
                } else {
                    window.location = "/web/schedules";
                }
            }
        });
        ev.preventDefault();
    });
});