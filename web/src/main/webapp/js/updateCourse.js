$(document).ready(function() {

    var form = $('#updateCourse');
    var id = $('#courseId').val();

    form.submit(function(ev) {
        $.ajax({
            type: "PUT",
            url: "/web/courses/modification/" + id,
            data: form.serialize(),
            success: function() {
                window.location = "/web/courses";
            }
        });
        ev.preventDefault();
    });
});