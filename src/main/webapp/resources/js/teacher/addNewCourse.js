$(function () {
    laydate.render({
        elem: '#startTime',
        trigger: 'click'
    });

    laydate.render({
        elem :  '#endTime',
        trigger: 'click'
    });

    $('#submit').click(function () {
        let courseName = $('#name').val();
        let creditPoint = $('#creditPoint').val();
        let maxNumber = $('#maxNumber').val();
        let startTime = $('#startTime').html();
        let endTime = $('#endTime').html();
        var mark = 1;
        let weeks = 0;
        let days = 0;
        let classTime = 0;
        let allowGrade = 0;
        for(let i = 0; i < 20; ++i){
            if($('#weeks-' + (i + 1)).is(':checked')){
                weeks |= (mark + i);
            }
        }

        for(let i = 0; i < 7; ++i){
            if($('#days-' + (i + 1)).is('checked')){
                days |= (mark + i);
            }
        }

        for(let i = 0; i < 12; ++i){
           if($('#class-' + (i + 1)).is(':checked')){
                classTime |= (mark << i);
           }
        }
        for(let i = 0; i < 4; ++i){
            if($('#grade-' + (i + 1)).is(':checked')){
                allowGrade |= (mark << i);
            }
        }
        let detail = $('#detail').val();

        console.log(courseName);

        $.ajax({
            url : '/teacher/addCourse',
            type : 'POST',
            data : {
                'courseName' : courseName,
                'creditPoint' : creditPoint,
                'maxNumber' : maxNumber,
                'startTime' : startTime,
                'endTime' : endTime,
                'weeks' : weeks,
                'days' : days,
                'classTime' : classTime,
                'allowGrade' : allowGrade,
                'detail' : detail
            },
            success : function (result) {
                if(result.success === true){
                    alert('succeed');
                }else{
                    alert('failed, message :' + result.message);
                }
            }
        })
    })
});