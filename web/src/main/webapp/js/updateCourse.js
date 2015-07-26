$(document).ready(function() {

    var form = $('#updateCourse');
    var id = $('#courseId').val();

    form.submit(function(ev) {
        $.ajax({
            type: "PUT",
            url: "/web/courses/modification/"+id,
            data: form.serialize(),
            success: function(data) {
                if(data === 'the course is exist') {

                    alert("您所修改的课程课程已存在，请重新操作");
                } else {
                    window.location = "/web/courses";
                }
            }
        });
        ev.preventDefault();
    });
});