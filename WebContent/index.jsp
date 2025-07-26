<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>  <!-- Add this import -->
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
            width: 200px; /* Adjust image size as needed */
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

            // If foodItems is null or empty, define a default list of food items
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

            // Loop through the foodItems and display images and buttons for selection
            for (String item : foodItems) {
                // Assuming the image URL is the same as the item name (you can modify this to match your image path)
                String imageUrl = "/images/" + item + ".jpg"; 
        %>
                <div class="food-item">
                    <img src="<%= imageUrl %>" alt="<%= item %>">
                    <br>
                   <button onclick="window.location.href='registration.jsp?item=<%= item %>'">Select</button>


                </div>
        <% 
            }
        %>
    </div>
</body>
</html>
