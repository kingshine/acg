<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改小说</title>
</head>
<body>
     <jsp:include page="title.jsp"></jsp:include>
    <font color="red">${requestScope.error}</font>
    <div>
       <form action="updNovel" method="post" >   
           <p><input type="text" name="name" /></p>
           <p><input type="submit" name ="choice" value="查询" />
              <input type="reset" value="重置" /></p>
       </form>
       </div>
   <form action="updNovel" method="post" >          
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
                    <td><input type="text" name="name" value="${novel.name}" readonly /></td>
                    <td><input type="text" name="author" value="${novel.author}" /></td>  
                    <td><input type="text" name="illustrator" value="${novel.illustrator}" /></td>
                    <td><input type="text" name="library" value="${novel.library}" /></td>
                    <td><input type="text" name="character" value="${novel.character}" /></td>
                    <td><input type="text" name="synopsis" value="${novel.synopsis}" /></td>
                    <td><input type="text" name="number" value="${novel.number}" /></td>
                    <td><input type="text" name="score" value="${novel.score}" /></td>
                    <td><input type="text" name="remarks" value="${novel.remarks}" /></td>                                   
         </tr>
   </table>              
              <p><input type="submit" name ="choice" value="确定修改" /></p>
   </form>
</body>
</html>