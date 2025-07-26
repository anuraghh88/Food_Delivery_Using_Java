<%
    String item = request.getParameter("item");
    String method = request.getParameter("method");
%>
<!DOCTYPE html>
<html>
<head><title>Order Confirmed</title></head>
<body>
    <h1>Order Placed Successfully!</h1>
    <p>You ordered: <strong><%= item %></strong></p>
    <p>Payment Method: <strong><%= method %></strong></p>
</body>
</html>
