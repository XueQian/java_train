$(document).ready(function() {

    var form = $('#updateEmployee');
    var id = $('#employeeId').val();

    form.submit(function(ev) {
        $.ajax({
            type: "PUT",
            url: "/web/employees/modification/" + id,
            data: form.serialize(),
            success: function() {
                window.location = "/web/employees";
            }
        });
        ev.preventDefault();
    });
});