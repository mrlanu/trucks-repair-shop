
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

    $.enabledDescription = function () {

        var arr = $(".checkBox");

        arr.bind('click', function () {
            arr.each(function () {
                var id = $('#id_desc_' + $(this).prop('id'));
                if ($(this).prop("checked")) {
                    id.prop("readonly", false);
                }else {
                    id.prop("readonly", true);
                    id.val(null);
                }
            })
        });
    };

    $.breakingDetails = function () {
        $('.table .eBtn').on('click',function(event){
            event.preventDefault();
            var href = $(this).attr('href');

            $.get(href, function(list){
                $("#breakingDetails tr").remove();
                var i = '';
                $.each(list, function(key, value){
                    i += '<tr>';
                    i += '<td>' + value.name + '</td>';
                    i += '<td>' + value.description + '</td>';
                    i += '<td class="text-center">'+ '<a href="#" class="btn btn-success btn-smj">Fix it</a>' + '</td>';
                    i += '</tr>';
                });
                $('#breakingDetails').append(i);
            });
            $('.myForm #exampleModal').modal();
        });
    };

    $.deleteConfirm = function () {
        $('.table .delBtn').on('click',function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $('#myModal #delRef').attr('href',href);
            $('#myModal').modal();
        });
    };

}(jQuery));

$(document).ready(function() {
    $.toggleShowPassword({
        field: '#password',
        control: "#showPassword"
    });

    $.enabledDescription();

    $.breakingDetails();

    $.deleteConfirm();

});




