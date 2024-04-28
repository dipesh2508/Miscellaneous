<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .calculator {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
            text-align: center;
        }
        input[type="text"], button {
            width: 50px;
            height: 50px;
            margin: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 20px;
        }
        input[type="text"] {
            width: 80%;
            padding: 10px;
            font-size: 24px;
            margin-bottom: 10px;
        }
        button {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
            font-weight: bold;
            transition: background-color 0.3s;
            width: 100%;
            height: 40px; /* Adjust button height */
            font-size: 16px; /* Adjust button font size */
            border: none;
        }
        button:hover {
            background-color: #45a049;
        }
        #result {
            font-size: 24px;
            font-weight: bold;
            margin-top: 10px;
        }
        .row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 5px; /* Add margin between rows */
        }
    </style>
</head>
<body>
    <div class="calculator">
        <h2>Simple Calculator</h2>
        <form action="calculator.jsp" method="post">
            <input type="text" name="num1" placeholder="Enter first number" required><br>
            <input type="text" name="num2" placeholder="Enter second number" required><br>
            <div class="row">
                <button type="submit" name="operation" value="addition">+</button>
                <button type="submit" name="operation" value="subtraction">-</button>
            </div>
            <div class="row">
                <button type="submit" name="operation" value="multiplication">*</button>
                <button type="submit" name="operation" value="division">/</button>
            </div>
        </form>

        <% 
            String num1Str = request.getParameter("num1");
            String num2Str = request.getParameter("num2");
            String operation = request.getParameter("operation");
            if (num1Str != null && num2Str != null && operation != null) {
                double num1 = Double.parseDouble(num1Str);
                double num2 = Double.parseDouble(num2Str);
                double result = 0;
                if (operation.equals("addition")) {
                    result = num1 + num2;
                } else if (operation.equals("subtraction")) {
                    result = num1 - num2;
                } else if (operation.equals("multiplication")) {
                    result = num1 * num2;
                } else if (operation.equals("division")) {
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        out.println("Error: Division by zero!");
                    }
                }
                out.println("<div id='result'>Result: " + result + "</div>");
            }
        %>
    </div>
</body>
</html>
