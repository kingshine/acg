<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除小说</title>
</head>
<body>
    <jsp:include page="title.jsp"></jsp:include>
    <font color="red">${requestScope.error}</font>
    <div>
       <form action="delNovel" method="post" >   
           <p><input type="text" name="name" /></p>
           <p><input type="submit" name ="choice" value="查询" />
              <input type="reset" value="重置" /></p>
       </form>
       <form action="delNovel" method="post" >   
           <p>确定要删除：<input type="text" name="name" value="${novel.name}" readonly />
              <input type="submit" name ="choice" value="确定删除" /></p>
       </form>
   </div>
   <table border="1">
    <tr>
                    <td>名称</td>
                    <td>作者</td>  
                    <td>插画</td>
                    <td>出版社</td>
                    <td>主角</td>
                    <td>简介</td>
                    <td>卷数</td>
                    <td>评分</td>
                    <td>备注</td>   
         </tr>
         <tr>
                    <td>${novel.name}</td>
                    <td>${novel.author}</td>  
                    <td>${novel.illustrator}</td>
                    <td>${novel.library}</td>
                    <td>${novel.character}</td>
                    <td>${novel.synopsis}</td>
                    <td>${novel.number}</td>
                    <td>${novel.score}</td>
                    <td>${novel.remarks}</td>                                   
         </tr>
   </table>  
</body>
</html>