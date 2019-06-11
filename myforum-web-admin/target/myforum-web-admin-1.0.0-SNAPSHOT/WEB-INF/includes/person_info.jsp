<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:if test="${user==null}">
    <div class="user-info-wrap pull-right clearfix">
        <div>请先<a href="/login">登录</a>或</div>
        <div><a href="/register">注册</a></div>
    </div>
</c:if>

<c:if test="${user!=null}">
    <%--个人登录面板 start--%>
    <div class="user-info-wrap clearfix">
        <div class="user-info-avatar pull-right">
            <img src="../../static/assets/img/avatar.jpg" alt="avatar" class="img-responsive" />
        </div>
        <div class="user-info-detail pull-right">
            <div class="detail-top">
                <strong>
                    <i class="iconfont"></i>
                    <c:choose>
                        <c:when test="${user.role==1}">
                            <a  href="/user/adminInfo">${user.username}</a>
                        </c:when>
                        <c:otherwise>
                            <a  href="/user/userInfo">${user.username}</a>
                        </c:otherwise>
                    </c:choose>
                </strong>
                <span>|</span>
                <div class="dropdown" >
                    <a id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
                       aria-expanded="true">
                        我的
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                        <li>
                            <a href="#">帖子</a>
                        </li>
                        <li>
                            <a href="#">收藏</a>
                        </li>
                    </ul>
                </div>
                <span>|</span>
                <a href="">消息</a>
            </div>
            <div class="detail-bottom">
                <div class="dropdown">
                    <h0  id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true"
                         aria-expanded="true">
                        设置
                        <span class="caret"></span>
                    </h0>
                </div>
                <span>|</span>

                <div class="dropdown">
                    <a href="/logout">
                        退出
                    </a>
                </div>
                <span>|</span>
                <div class="dropdown">
                    <a href="/main">
                        首页
                    </a>
                </div>
            </div>
        </div>
            <%--个人登录面板 end--%>
    </div>
</c:if>

<div class="search-wrap">
    <div class="input-group">
        <form action="/searchByContent" method="post">
            <div class="row">
                    <div class="col-xs-10">
                        <input type="text" name="content" Class="form-control"  placeholder="内容" />
                    </div>
                    <div class="col-xs-2">
                        <button type="submit" class="btn btn-info">搜索</button>
                    </div>
            </div>
        </form>

    </div>
</div>