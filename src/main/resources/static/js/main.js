
(function ($) {
    $.toggleShowPassword = function (options) {
        var settings = $.extend({
            field: "#password",
            control: "#toggle_show_password",
        }, options);

        var control = $(settings.control);
        var field = $(settings.field)

        control.bind('click', function () {
            if (control.is(':checked')) {
                field.attr('type', 'text');
            } else {
                field.attr('type', 'password');
            }
        })
    };

    /*$.enabledDescription = function () {
        var control, i = 1;

            control = $("#id_check_" + i);
            control.bind('click', function () {
                if (control.is(':checked')) {
                    document.getElementById("id_desc_" + i).readOnly = false;

                } else {
                    document.getElementById("id_desc_" + i).readOnly = true;
                    $('#id_desc_' + i).val(null);

                }
            })

    };*/

}(jQuery));

$(document).ready(function() {
    $.toggleShowPassword({
        field: '#password',
        control: "#showPassword"
    });

    /*$.enabledDescription();*/

    $('.table .delBtn').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href',href);
        $('#myModal').modal();
    });
});




