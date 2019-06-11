<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
    <div class="col-xs-6">
        <dl>
            <dt>邮箱：</dt>
            <dd>${tbUser.email}</dd>
            <br />

            <dt>用户名：</dt>
            <dd>${tbUser.username}</dd>
            <br />

        </dl>
    </div>

    <div class="col-xs-6">
        <dl>
            <dt>创建时间：</dt>
            <dd>${tbUser.time_start}</dd>
            <br />

            <dt>更新时间：</dt>
            <dd>${tbUser.time_end}</dd>
        </dl>
    </div>
</div>