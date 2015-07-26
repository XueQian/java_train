$(document).ready(function() {

    var form = $('#addCourse');

    form.submit(function(ev) {
        $.ajax({
            type: "POST",
            url: "/web/courses/creation",
            data: form.serialize(),
            success: function(data) {
                if(data === 'the course is exist') {

                    alert("该课程已存在，请重新操作");
                } else {
                    window.location = "../web/courses";
                }
            }
        });
        ev.preventDefault();
    });

});