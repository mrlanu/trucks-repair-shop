
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

    $('.table .eBtn').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');

            $.get(href, function(list){
                $("#breaking2 tr").remove();
                var i = '';
                $.each(list, function(key, value){
                    i += '<tr>';
                    i += '<td>' + value.name + '</td>';
                    i += '<td>' + value.description + '</td>';
                    i += '<td class="text-center">'+ '<a href="#" class="btn btn-success btn-sm">Fix it</a>' + '</td>';
                    i += '</tr>';
                });
                $('#breaking2').append(i);
            });
        $('.myForm #exampleModal').modal();



    });
});




