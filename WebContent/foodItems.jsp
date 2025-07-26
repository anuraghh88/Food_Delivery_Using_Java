<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Food Items</title>
    <style>
        .food-item {
            display: inline-block;
            margin: 20px;
            text-align: center;
        }
        .food-item img {
            width: 200px;
            height: 200px;
        }
        .food-item button {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h2>Food Items</h2>
    <div class="food-items-container">
        <%
            List<String> foodItems = (List<String>) request.getAttribute("foodItems");
            if (foodItems == null || foodItems.isEmpty()) {
                foodItems = new ArrayList<>();
                foodItems.add("Pizza");
                foodItems.add("Burger");
                foodItems.add("Pasta");
                foodItems.add("Salad");
                foodItems.add("Sushi");
                foodItems.add("Tacos");
                foodItems.add("Steak");
                foodItems.add("Sandwich");
            }

            for (String item : foodItems) {
                String imageUrl = "/images/" + item + ".jpg";
        %>
            <div class="food-item">
                <img src="<%= imageUrl %>" alt="<%= item %>">
                <br>
                <form action="registration.jsp" method="GET">
                    <input type="hidden" name="item" value="<%= item %>">
                    <button type="submit">Select</button>
                </form>
            </div>
        <% } %>
    </div>
</body>
</html>
