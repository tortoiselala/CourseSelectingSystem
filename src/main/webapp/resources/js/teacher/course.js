$(function (){
        $("input[id^='score-']").change(function(){
            const studentId = $(this).attr("id").match(/score-(\S*)/)[1];
            const newScore = $(this).val();
            const courseId = window.location.href.match("/([0-9]+)/")[1];
            console.log(window.location.href.match("/([0-9]+)/")[1]);
            $.ajax({
                url : '/teacher/updateScore',
                type : 'POST',
                data : {
                    'STUDENT_ID' : studentId,
                    'SCORE' : newScore,
                    'COURSE_ID' : courseId
                },
                success : function (result) {
                    if(result.success === false){
                        window.alert(result.message);
                    }
                }
            })
        });
    }

);