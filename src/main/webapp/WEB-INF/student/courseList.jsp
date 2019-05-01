<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>课程列表</title>
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
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${COURSE_LIST}" var="col">
                    <tr>
                        <td>${col.name}</td>
                        <td>${col.teacherName}</td>
                        <td>${col.creditPoint}</td>
                        <td>${col.creditHours}</td>
                        <td>${col.currentNumber}/${col.maxNumber}</td>
                        <td>
                            <fmt:formatDate value="${col.startTime}" pattern="yyyy-MM-dd" />
                        </td>
                        <td>
                            <fmt:formatDate value="${col.endTime}" pattern="yyyy-MM-dd" />
                        </td>
                        <td>${col.days}</td>
                        <td>${col.weeks}</td>
                        <td>${col.classTime}</td>
                        <td>${col.allowGrade}</td>
                        <td><a class="btn btn-info" href="/student/course/${col.id}/detail" target="_blank">详情</a></td>
                        <td><a class="btn btn-info" href="/student/course/${col.id}/select" target="_blank">选择</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>