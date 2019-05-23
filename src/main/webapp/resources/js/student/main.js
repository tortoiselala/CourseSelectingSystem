$(function () {
    const pageSize = 20;
    let totalPages = 0;
    $.ajax({
        url : '/student/getCourseNum',
        async : false,
        success : function (result) {
            if(result.success === true){
                totalPages = Math.ceil(result.data / pageSize);
                console.log('get total pages : ' + totalPages);
            }
        }
    });
    $("#pagination_container").jqPaginator({
        totalPages: totalPages,
        visiblePages: 10,
        currentPage: 1,
        first: '<li class="first"><a href="javascript:void(0);">First<\/a><\/li>',
        prev: '<li class="prev"><a href="javascript:void(0);">Previous<\/a><\/li>',
        next: '<li class="next"><a href="javascript:void(0);">Next<\/a><\/li>',
        last: '<li class="last"><a href="javascript:void(0);">Last<\/a><\/li>',
        page: '<li class="page"><a href="javascript:void(0);">{{page}}<\/a><\/li>',
        onPageChange: function (n) {
            const offset = (n - 1) * pageSize;
            $.ajax({
                url : '/student/courseList',
                data : {
                    'offset' : offset,
                    'limit' : pageSize
                },
                type : 'GET',
                dataType : 'json',
                success : function (result) {
                    if(result.success === true){

                        var html = '';
                        var itemCount = result.data.length;
                        for(var i = 0; i < itemCount; ++i){

                            html += '<tr>';
                            html += '<td>' + result.data[i].name + '</td>';
                            html += '<td>' + result.data[i].creditPoint + '</td>';
                            html += '<td>' + result.data[i].creditHours + '</td>';
                            html += '<td>' + result.data[i].currentNumber +'/' + result.data[i].maxNumber + '</td>';

                            const start = new Date(result.data[i].startTime);
                            const end = new Date(result.data[i].endTime);
                            html += '<td>' + start.getFullYear() + '/' + start.getMonth() + '/' + start.getDate() + '</td>';
                            html += '<td>' + end.getFullYear() + '/' + end.getMonth() + '/' + end.getDate() + '</td>';
                            html += '<td>' + result.data[i].days + '</td>';
                            html += '<td>' + result.data[i].weeks + '</td>';
                            html += '<td>' + result.data[i].classTime + '</td>';
                            html += '<td>' + result.data[i].allowGrade + '</td>';
                            html += '<td>' + result.data[i].detail + '</td>';
                            html += '<td><a class="btn btn-primary select-course" id = "' + result.data[i].id + '">选课</a></td>';
                            html += '</tr>';
                        }
                        $('#course_list').html(html);
                        $('.select-course').on('click', function () {
                            const courseId = $(this).attr("id");
                            console.log('user clicked :' + courseId);
                            $.ajax({
                                url : '/student/course/' + courseId + '/exposer',
                                success : function (result) {
                                    if(result.success === true){
                                        console.log('成功获取md5:' + result.message);
                                        $.ajax({
                                            url : '/student/course/' + courseId + '/' + result.message + '/select',
                                            type : 'POST',
                                            success : function (r) {
                                                if(r.success === true){
                                                    alert('选课成功');
                                                }else{
                                                    alert('选课失败， message :' + r.message);
                                                }
                                            }
                                        })
                                    }else{
                                        alert("false, message :" + result.message);
                                    }
                                }
                            });
                        });
                    }
                }
            });
        }
    });



});


/* 20 + 40
40 = 57*0.7
100 - 18 - 20

25 + 35
35 = 50 * 0.7
100 - 8 - 20 -22*/