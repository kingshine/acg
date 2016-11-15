<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>小说列表</title>
</head>
<body>
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
    <c:forEach items="${novelList}" var="novel">
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
      </c:forEach>

   </table>
</body>
</html>