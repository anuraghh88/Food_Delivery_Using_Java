<%
    String selectedItem = request.getParameter("item");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add to Cart</title>
</head>
<body>
    <h1>Your Selected Food Item</h1>
    <p><strong>Item:</strong> <%= selectedItem != null ? selectedItem : "None" %></p>

    <form action="payment.jsp" method="GET">
        <input type="hidden" name="item" value="<%= selectedItem != null ? selectedItem : "" %>">
        <button type="submit">Proceed to Payment</button>
    </form>
</body>
</html>
