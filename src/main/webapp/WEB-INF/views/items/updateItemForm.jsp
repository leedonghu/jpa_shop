<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/items/${item.id}/edit" method="post">
        <input type="text" value="${item.id}" name="id" hidden>
        상품명
        <input type="text" name="name" value="${item.name}">
        가격
        <input type="text" name="price" value="${item.price}">
        수량
        <input type="text" name="stockQuantity" value="${item.stockQuantity}">
        <button type="submit">submit</button>
    </form>
</body>
</html>
