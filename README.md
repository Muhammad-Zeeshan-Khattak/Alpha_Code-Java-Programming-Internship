## AlphCode JAva Internship

## Student Grade Tracker

This is my **first project** as part of the **CodeAlpha Java Programming Internship**.  
It is a **console-based Java application** designed to manage and analyze student grades efficiently.

---

## Project Description

The Student Grade Management System allows users to:

- Input multiple students
- Store multiple subjects and marks for each student
- Calculate:
  - Total marks
  - Average marks
  - Highest score
  - Lowest score
- Display a complete student report
- Show a class summary with the top-performing student

---

## Technologies Used

- Java (Core Java)
- Arrays
- Scanner class (for user input)
- Console-based interface

---

## Features

✔ Add multiple students  
✔ Add multiple subjects per student  
✔ Calculate performance automatically  
✔ Display detailed student report  
✔ Class summary with top student  
✔ Simple and easy-to-use console interface  

---

## Concepts Used

- Arrays
- Object-Oriented Programming (OOP)
- Classes and Objects
- Loops (for, enhanced for loop)
- Conditional statements (if-else)
- Methods

---

## Sample Output
===== STUDENT GRADE MANAGEMENT SYSTEM =====
Enter number of students: 2

Enter details for Student 1
Name: Ali khan
Number of subjects: 2
Enter subject 1: Physics
Enter marks: 90
Enter subject 2: Chemistry
Enter marks: 87

Enter details for Student 2
Name: Muhammad Zeeshan
Number of subjects: 2
Enter subject 1: Physics
Enter marks: 67
Enter subject 2: Chemistry
Enter marks: 88


========== ALL STUDENTS REPORT ==========

===============================
Student Name: Ali khan
Physics : 90
Chemistry : 87
Total Marks: 177
Average    : 88.50
Highest    : 90
Lowest     : 87
===============================

===============================
Student Name: Muhammad Zeeshan
Physics : 67
Chemistry : 88
Total Marks: 155
Average    : 77.50
Highest    : 88

## Project :2 (Stock Trading Platform)

## Project Description

The Stock Trading System is a console-based Java application developed as **Task 2** of my **CodeAlpha Java Programming Internship**. It allows users to view available stocks, buy and sell shares, manage their portfolio, check account balance, and view transaction history. The project demonstrates the implementation of Object-Oriented Programming (OOP) concepts in Java.

## Technologies Used

* Java
* Scanner Class
* LocalDateTime API
* Object-Oriented Programming (OOP)

## Features

* View available stocks in the market
* Buy stocks
* Sell stocks
* Display owned stocks
* View transaction history
* Check account balance
* Menu-driven console interface

## Concepts Used

* Abstraction
* Inheritance
* Encapsulation
* Polymorphism
* Interface
* Arrays
* Classes and Objects

## Sample Output

===== STOCK TRADING SYSTEM =====
1. View Market
2. Buy Stock
3. Sell Stock
4. View Holdings
5. View Transactions
6. View Balance
7. Exit
Enter choice: 1
Symbol: AAPL
Price: $180.5
Company Name: Apple Inc
------------------------
Symbol: TSLA
Price: $250.0
Company Name: Tesla Inc
------------------------
Symbol: GOOG
Price: $2900.0
Company Name: Google
------------------------
Symbol: AMZN
Price: $3400.0
Company Name: Amazon
------------------------

===== STOCK TRADING SYSTEM =====
1. View Market
2. Buy Stock
3. Sell Stock
4. View Holdings
5. View Transactions
6. View Balance
7. Exit
Enter choice: 2
Enter stock symbol: AAPL
Enter quantity: 5
Stock purchased successfully!

===== STOCK TRADING SYSTEM =====
1. View Market
2. Buy Stock
3. Sell Stock
4. View Holdings
5. View Transactions
6. View Balance
7. Exit
Enter choice: 14
Invalid choice!

===== STOCK TRADING SYSTEM =====
1. View Market
2. Buy Stock
3. Sell Stock
4. View Holdings
5. View Transactions
6. View Balance
7. Exit
Enter choice: 4
----- Holdings -----
AAPL : 5 shares

===== STOCK TRADING SYSTEM =====
1. View Market
2. Buy Stock
3. Sell Stock
4. View Holdings
5. View Transactions
6. View Balance
7. Exit
Enter choice: 5
----- Transactions -----
Transaction ID : 1
Type           : BUY
Stock Symbol   : AAPL
Quantity       : 5
Price/Share    : $180.5
Total Amount   : $902.5
Date & Time    : 2026-06-27T09:38:58.925732900
------------------------

===== STOCK TRADING SYSTEM =====
1. View Market
2. Buy Stock
3. Sell Stock
4. View Holdings
5. View Transactions
6. View Balance
7. Exit
Enter choice: 6
Balance: $9097.5

===== STOCK TRADING SYSTEM =====
1. View Market
2. Buy Stock
3. Sell Stock
4. View Holdings
5. View Transactions
6. View Balance
7. Exit
Enter choice: 7
Exiting system...
## Project 3 (ChatBot)

## Project Description

The **Rule-Based AI Chatbot** is a Java desktop application developed using the **Swing** framework. It is designed to simulate a simple chatbot that interacts with users through predefined rules. Instead of using Machine Learning or Natural Language Processing (NLP), the chatbot processes user input using a series of conditional statements (`if-else`) and returns appropriate responses based on matching commands.

The chatbot provides information about Artificial Intelligence, programming languages, date and time, general knowledge, motivation, study tips, jokes, poems, riddles, and other common conversational topics. It offers an interactive graphical user interface (GUI), making it easy and user-friendly to communicate with the chatbot.

---

## Technologies Used

- **Programming Language:** Java
- **GUI Framework:** Java Swing
- **GUI Components:** AWT
- **Date & Time API:** `java.time`
- **Event Handling:** ActionListener
- **IDE:** IntelliJ IDEA / Eclipse / NetBeans (Any Java IDE)
- **Programming Paradigm:** Object-Oriented Programming (OOP)

---

## Features

- Interactive Swing-based graphical user interface
- Responds to greetings such as *Hi*, *Hello*, and *Good Morning*
- Displays help menu and available commands
- Provides information about:
  - Artificial Intelligence
  - Machine Learning
  - Java
  - Python
  - Programming
- Displays current date, time, and day
- Answers general knowledge questions
- Tells jokes, poems, stories, and riddles
- Provides motivation, study tips, coding tips, and exam tips
- Gives health and lifestyle advice
- Handles unknown inputs with a default response
- Supports exit commands (`exit`, `bye`, `quit`)
- Simple and user-friendly chat interface

---

## Concepts Used

The project demonstrates the following concepts:

- Rule-Based Artificial Intelligence
- Java Swing GUI Development
- Object-Oriented Programming (OOP)
- Event-Driven Programming
- Conditional Statements (`if-else`)
- Arrays
- Methods and Functions
- String Manipulation
- Loops
- Java Time API (`LocalDate`, `LocalTime`, `DayOfWeek`)
- User Input Handling
- Desktop Application Development

---

## Sample Output

```
=============================================
        WELCOME TO RULE-BASED AI CHATBOT
=============================================

Hello! I am your virtual assistant.

I can help you with:
• Greetings
• Basic conversations
• Information about AI and Programming
• Date and Time
• Jokes and Fun Facts
• Motivation and Study Tips
• General Knowledge Questions

Type "help" to see this menu again.
Type "exit" or "bye" to end the conversation.
```

### Example Conversation

```
You: hi

Bot: hi! How can I assist you?

----------------------------------------

You: what is ai

Bot: Artificial Intelligence (AI) is the
simulation of human intelligence by machines
that can learn, reason, and solve problems.

----------------------------------------

You: time

Bot: Current time is 10:45:20

----------------------------------------

You: joke

Bot: Why do programmers prefer dark mode?
Because light attracts bugs!

----------------------------------------

You: motivation

Bot: Success comes from consistency.
Keep learning and never stop practicing!

----------------------------------------

You: exit

Bot: Goodbye! Have a nice day.
```




