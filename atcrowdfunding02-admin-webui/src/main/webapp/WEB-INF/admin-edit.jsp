<%--
  Created by IntelliJ IDEA.
  User: lhb
  Date: 2021/4/3
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="include-head.jsp" %>

<body>

<%@include file="include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="include-sidebar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <ol class="breadcrumb">
                <li><a href="#">首页</a></li>
                <li><a href="#">数据列表</a></li>
                <li class="active">修改</li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-heading">用户信息<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
                <div class="panel-body">
                    <form  action="admin/updateAdmin.html" method="post" role="form">
                        <input type="hidden" name="id" value="${requestScope.admin.id }">
                        <input type="hidden" name="pageNum" value="${param.pageNum }">
                        <input type="hidden" name="keyword" value="${param.keyword }">
                        <p>${requestScope.exception.message }</p>
                        <div class="form-group">
                            <label for="exampleInputPassword1">登陆账号</label>
                            <input name="loginAcct"
                                   type="text" class="form-control"
                                   id="exampleInputPassword1"
                                   value="${requestScope.admin.loginAcct}">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">用户名称</label>
                            <input name="userName"
                                   type="text" class="form-control"
                                   id="exampleInputPassword1"
                                   value="${requestScope.admin.userName}">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">邮箱地址</label>
                            <input name="email"
                                   type="email" class="form-control"
                                   id="exampleInputEmail1"
                                   value="${requestScope.admin.email}">
                            <p class="help-block label label-warning">请输入合法的邮箱地址, 格式为： xxxx@xxxx.com</p>
                        </div>
                        <button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-edit"></i> 修改</button>
                        <button type="reset" class="btn btn-danger"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
