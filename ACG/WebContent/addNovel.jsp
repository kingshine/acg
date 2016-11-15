<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加小说</title>
</head>
<body>
    <jsp:include page="title.jsp"></jsp:include>
    <font color="red">${requestScope.error}</font>
    <form action="addNovel" method="post" >
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
                    <td><input type="text" name="name" /></td>
                    <td><input type="text" name="author" /></td>  
                    <td><input type="text" name="illustrator" /></td>
                    <td><input type="text" name="library" /></td>
                    <td><input type="text" name="character" /></td>
                    <td><input type="text" name="synopsis" /></td>
                    <td><input type="text" name="number" /></td>
                    <td><input type="text" name="score" /></td>
                    <td><input type="text" name="remarks" /></td>     
                                      
         </tr>
   </table>
   <p><input type="submit" value="添加" />
      <input type="reset" value="重置" /></p>
   </form>
</body>
</html>