<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>课程详情</title>
    <%@include file="../common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>课程列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>课程</th>
                    <th>开课教师</th>
                    <th>学分</th>
                    <th>学时</th>
                    <th>人数</th>
                    <th>开课时间</th>
                    <th>结束时间</th>
                    <th>星期</th>
                    <th>周</th>
                    <th>上课时间</th>
                    <th>允许</th>
                    <th>课程简介</th>
                </tr>
                </thead>
                <tbody>

                    <tr>
                        <td>${COURSE_DETAIL.name}</td>
                        <td>${COURSE_DETAIL.teacherName}</td>
                        <td>${COURSE_DETAIL.creditPoint}</td>
                        <td>${COURSE_DETAIL.creditHours}</td>
                        <td>${COURSE_DETAIL.currentNumber}/${COURSE_DETAIL.maxNumber}</td>
                        <td>
                            <fmt:formatDate value="${COURSE_DETAIL.startTime}" pattern="yyyy-MM-dd" />
                        </td>
                        <td>
                            <fmt:formatDate value="${COURSE_DETAIL.endTime}" pattern="yyyy-MM-dd" />
                        </td>
                        <td>${COURSE_DETAIL.days}</td>
                        <td>${COURSE_DETAIL.weeks}</td>
                        <td>${COURSE_DETAIL.classTime}</td>
                        <td>${COURSE_DETAIL.allowGrade}</td>
                        <td>${COURSE_DETAIL.detail}</td>
                        <td><a class="btn btn-info" href="/student/course/${COURSE_DETAIL.id}/select" target="_blank">选择</a></td>
                    </tr>
                </tbody>
            </table>

        </div>
    </div>
</div>

</body>
<%--jQery文件,务必在bootstrap.min.js之前引入--%>
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<%--使用CDN 获取公共js http://www.bootcdn.cn/--%>
<%--jQuery Cookie操作插件--%>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<%--jQuery countDown倒计时插件--%>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>

</html>