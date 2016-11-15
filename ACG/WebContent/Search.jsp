<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>搜索小说</title>
</head>
<body>
   <jsp:include page="title.jsp"></jsp:include>
   <div id="search">
       <form action="Search" method="post" >
           <select id="item" name="item" >
           <option value="">请选择...</option>
           <option value="name">名字</option>
           <option value="score">分数</option>
           <option value="character">主角</option>
        </select>
           <p><input type="text" name="condition" /></p>
           <p><input type="submit" value="查询" />
              <input type="reset" value="重置" /></p>
       </form>
   </div>
   <div id="list">
       <form action="GetNovelList" method="post" >
           <p><input type="submit" value="查询所有" /></p>
       </form>
   </div>
   <div id="NovelList">
   <jsp:include page="NovelList.jsp"></jsp:include>
   </div>
   
</body>
</html>