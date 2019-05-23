$(function (){
    $('#username').change(
        function () {
            $('.invalid-feedback').hide();
        }
    );

    $('#studentLogin').click(function () {
            let username = $('#username').val();
            let password = $('#password').val();
            login(username, password, true);
        }
    );

    $('#teacherLogin').click(function () {
            let username = $('#username').val();
            let password = $('#password').val();
            login(username, password, false);
        }
    );

});

function login(username, password, student) {
    console.log('准备登录， 用户信息\n' + '用户名 ： ' + username + '\n' + '密码 ： ' + password + '\n' + '用户类型 ： ' + student);
    $.ajax({
        url: 'login',
        type: 'POST',
        data: {
            'username': username,
            'password': password,
            'student': student,
        },
        success: function (result) {
            if(result.success && student){
                window.location.assign("/student/main.html");
            }else if(result.success && !student){
                window.location.assign("/teacher/main.html");
            }else{
                $('.invalid-feedback').show();
            }
        },
        dataType: 'json'
    })
};