<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: tortoiselala
  Date: 2019-05-19
  Time: 02:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.tortoise.constant.CommonConstant" %>
<html>
<head>
    <title>课程详情 | 选课系统</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="<c:url value="/resources/js/teacher/course.js"/>"></script>
</head>
<body>
<div>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="<c:url value="/teacher/main.html"/>">课程中心</a>
            </div>
            <div class="collapse navbar-collapse" id="example-navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="<c:url value="/teacher/addNewCourse.html"/>"><span class="glyphicon glyphicon-user"></span>增加新课程</a></li>
                    <li><a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-in"></span>注销</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!-- 课程信息简介-->
<div class="container">
    <div class="row">
        <div class="span2"></div>
        <div class="span8">
            <caption>您发布的课程</caption>
            <table class="table table-hover">

                <thead>
                <tr>
                    <th>课程</th>
                    <th>学分</th>
                    <th>学时</th>
                    <th>人数</th>
                    <th>星期</th>
                    <th>周</th>
                    <th>上课时间</th>
                    <th>允许</th>
                    <th>课程简介</th>
                </tr>
                </thead>
                <tbody class="table table-hover" id="course_list">
                <tr>
                    <td>${COURSE.name}</td>
                    <td>${COURSE.creditPoint}</td>
                    <td>${COURSE.creditHours}</td>
                    <td>${COURSE.currentNumber} / ${COURSE.maxNumber}</td>
                    <td>${COURSE.days}</td>
                    <td>${COURSE.weeks}</td>
                    <td>${COURSE.classTime}</td>
                    <td>${COURSE.allowGrade}</td>
                    <td>${COURSE.detail}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="span2"></div>
        <div class="span8"></div>
            <table class="table table-hover">
                <caption>学生列表</caption>
                <thead><tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>年级</th>
                    <th>专业</th>
                    <th>学院</th>
                    <th>分数</th>
                </tr></thead>
                <tbody class="table table-hover" id="student_list">
                <tr>

                    <c:forEach items="${STUDENT_LIST}" var="col">
                        <td>${col.id}</td>
                        <td>${col.name}</td>
                        <td>${col.sex}</td>
                        <td>${col.grade}</td>
                        <td>${col.majorName}</td>
                        <td>${col.schoolName}</td>
                        <td><label>
                            <input type="number" min="0" max="100" class="form-control input-sm input-group" value="${col.score}" id="score-${col.id}">
                        </label></td>
                    </c:forEach>
                </tr>
                </tbody>
            </table>
        <div class="span2"></div>
        </div>
</div>

</body>
</html>
