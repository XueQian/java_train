$(document).ready(function() {

    var form = $('#updateCustomer');
    var id = $('#customerId').val();

    form.submit(function(ev) {
        $.ajax({
            type: "PUT",
            url: "/web/customers/modification/" + id,
            data: form.serialize(),
            success: function() {
                window.location = "/web/customers";
            }
        });
        ev.preventDefault();
    });
});