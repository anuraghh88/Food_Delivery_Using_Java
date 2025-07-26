<%
    String selectedItem = request.getParameter("item");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment</title>
</head>
<body>
    <h1>Select Payment Method</h1>
    <p><strong>For Item:</strong> <%= selectedItem != null ? selectedItem : "Unknown" %></p>

    <form action="PaymentController" method="POST">
        <input type="hidden" name="item" value="<%= selectedItem %>">
        <input type="radio" name="paymentMethod" value="CreditCard" required> Credit Card<br>
        <input type="radio" name="paymentMethod" value="Paypal"> PayPal<br>
        <input type="radio" name="paymentMethod" value="COD"> Cash on Delivery<br>
        <button type="submit">Confirm Payment</button>
    </form>
</body>
</html>
