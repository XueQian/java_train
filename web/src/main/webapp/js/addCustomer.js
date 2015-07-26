$(document).ready(function() {

    var form = $('#addCustomer');

    form.submit(function(ev) {
        $.ajax({
            type: "POST",
            url: "/web/customers/creation",
            data: form.serialize(),
            success: function(data) {
                if(data === 'the customer is exist') {

                    alert("该客户已存在，请重新操作");
                } else {
                    window.location = "../web/customers";
                }
            }
        });
        ev.preventDefault();
    });

});