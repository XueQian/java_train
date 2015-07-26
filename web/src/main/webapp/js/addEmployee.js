$(document).ready(function() {

    var form = $('#addEmployee');

    form.submit(function(ev) {
        $.ajax({
            type: "POST",
            url: "/web/employees/creation",
            data: form.serialize(),
            success: function(data) {
                if(data === 'the employee is exist') {

                    alert("该雇员已存在，请重新操作");
                } else {
                    window.location = "../web/employees";
                }
            }
        });
        ev.preventDefault();
    });

});