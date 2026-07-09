import java.awt.*;
import java.awt.event.*;
import java.time.*;
import javax.swing.*;

class Main {

    // Welcome Message (Your exact original string)
    static String printMenu() {
        return "=============================================\n"
                + "        WELCOME TO RULE-BASED AI CHATBOT\n"
                + "=============================================\n\n"
                + "Hello! I am your virtual assistant.\n\n"
                + "I can help you with:\n"
                + "• Greetings\n"
                + "• Basic conversations\n"
                + "• Information about AI and Programming\n"
                + "• Date and Time\n"
                + "• Jokes and Fun Facts\n"
                + "• Motivation and Study Tips\n"
                + "• General Knowledge Questions\n\n"
                + "Type \"help\" to see this menu again.\n"
                + "Type \"exit\" or \"bye\" to end the conversation.\n";
    }

    // Greeting Method (Your exact original method)
    static String greeting(String str) {
        String[] greetings = {
                "hi", "hello", "hey", "heyy",
                "good morning", "good afternoon",
                "good evening", "hi there",
                "hello there"
        };

        boolean isGreeting = false;

        for (String greet : greetings) {
            if (greet.equals(str)) {
                isGreeting = true;
                break;
            }
        }

        if (isGreeting) {
            return "Bot: " + str + "! How can I assist you?";
        }
        return "";
    }

    // Commands List (Your exact original method)
    static String commands() {
        return "\n========== AVAILABLE COMMANDS ==========\n\n"
                + "🔹 Greetings:\n"
                + "hi, hello, hey, good morning, good evening\n\n"
                + "🔹 Basic Info:\n"
                + "what is your name, who are you, who created you\n"
                + "how old are you, what is your purpose\n\n"
                + "🔹 Date & Time:\n"
                + "date, time, day\n\n"
                + "🔹 Programming:\n"
                + "what is ai, what is java, what is python, what is programming\n\n"
                + "🔹 Math Operations:\n"
                + "addition, subtraction, multiplication, division\n"
                + "percentage, square, cube, square root\n\n"
                + "🔹 Number Logic:\n"
                + "palindrome, even or odd, prime, leap year\n"
                + "largest number, smallest number\n"
                + "random number, coin toss, dice\n\n"
                + "🔹 Fun & Entertainment:\n"
                + "joke, riddle, poem, story, fact\n\n"
                + "🔹 Motivation & Study:\n"
                + "motivation, study tip, exam tips, coding tips\n\n"
                + "🔹 General Knowledge:\n"
                + "capital of pakistan, india, usa, uk\n\n"
                + "🔹 Life Topics:\n"
                + "happiness, friendship, success, love, health\n\n"
                + "🔹 Utility:\n"
                + "help, commands, exit, bye\n\n"
                + "========================================";
    }

    public static void main(String[] args) {
        // --- SIMPLE SWING INTERFACE SETUP ---
        JFrame frame = new JFrame("AI Chatbot");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Chat Display Area
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Input Panel at the bottom
        JPanel inputPanel = new JPanel(new BorderLayout());
        JTextField inputField = new JTextField();
        JButton sendButton = new JButton("Send");
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        frame.add(inputPanel, BorderLayout.SOUTH);

        // Show the window
        frame.setVisible(true);

        // Print welcome message initially
        chatArea.append(printMenu() + "\n");

        // Action listener when user interacts with the GUI
        ActionListener submitAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str = inputField.getText().toLowerCase().trim();
                if (str.isEmpty()) return;

                // Display what user typed
                chatArea.append("\nYou: " + inputField.getText() + "\n");
                inputField.setText("");

                // --- YOUR EXACT ORIGINAL IF-ELSE LOGIC START ---
                if (str.isEmpty()) {
                    chatArea.append("Bot: Please enter something!\n");
                }

                else if (str.equals("help")) {
                    chatArea.append(printMenu() + "\n");
                }

                else if (str.equals("exit") || str.equals("bye") || str.equals("quit")) {
                    chatArea.append("Bot: Goodbye! Have a nice day.\n");
javax.swing.Timer timer = new javax.swing.Timer(1000, event -> System.exit(0));                    timer.setRepeats(false);
                    timer.start();
                }

                // Greetings
                else if (str.equals("hi") || str.equals("hello") || str.equals("hey")
                        || str.equals("heyy") || str.equals("good morning")
                        || str.equals("good afternoon") || str.equals("good evening")
                        || str.equals("hi there") || str.equals("hello there")) {

                    chatArea.append(greeting(str) + "\n");
                }

                // Command
                else if(str.equals("commands")){
                    chatArea.append(Main.commands() + "\n");
                }

                // Name
                else if (str.equals("what is your name")
                        || str.equals("who are you")
                        || str.equals("your name")) {

                    chatArea.append("Bot: My name is RuleBot.\n");
                    chatArea.append("I am a Rule-Based AI Chatbot developed in Java.\n");
                }

                // Creator
                else if (str.equals("who created you")
                        || str.equals("who made you")
                        || str.equals("your creator")) {

                    chatArea.append("Bot: I was created by a Java developer\n");
                    chatArea.append("as part of an Artificial Intelligence project\n");
                    chatArea.append("using rule-based programming.\n");
                }

                // Age
                else if (str.equals("how old are you")
                        || str.equals("what is your age")) {

                    chatArea.append("Bot: I don't have a real age.\n");
                    chatArea.append("I exist as a computer program.\n");
                    chatArea.append("I can help you anytime.\n");
                }

                // Purpose
                else if (str.equals("what is your purpose")
                        || str.equals("why are you here")
                        || str.equals("what can you do")) {

                    chatArea.append("Bot: My purpose is to assist users\n");
                    chatArea.append("by answering predefined questions,\n");
                    chatArea.append("providing useful information, and\n");
                    chatArea.append("demonstrating rule-based AI using Java.\n");
                }

                // Date
                else if (str.equals("what is today's date")
                        || str.equals("date")
                        || str.equals("today's date")) {

                    LocalDate today = LocalDate.now();
                    chatArea.append("Bot: Today's date is " + today + "\n");
                }

                // Time
                else if (str.equals("what time is it")
                        || str.equals("time")
                        || str.equals("current time")) {

                    LocalTime time = LocalTime.now();
                    chatArea.append("Bot: Current time is " + time.withNano(0) + "\n");
                }

                // Day
                else if (str.equals("what day is it")
                        || str.equals("day")
                        || str.equals("today")) {

                    DayOfWeek day = LocalDate.now().getDayOfWeek();
                    chatArea.append("Bot: Today is " + day + "\n");
                }

                // AI
                else if (str.equals("what is ai")) {

                    chatArea.append("Bot: Artificial Intelligence (AI) is the\n");
                    chatArea.append("simulation of human intelligence by machines\n");
                    chatArea.append("that can learn, reason, and solve problems.\n");
                }

                // Machine Learning
                else if (str.equals("what is machine learning") || str.equals("machine learning")) {
                    chatArea.append("Bot: Machine Learning (ML) is a branch of Artificial Intelligence that enables computers to learn from data and make predictions without being explicitly programmed.\n");
                }

                // Java
                else if (str.equals("what is java") || str.equals("java")) {
                    chatArea.append("Bot: Java is a high-level, object-oriented programming language used for developing desktop, web, mobile, and enterprise applications.\n");
                }

                // Python
                else if (str.equals("what is python") || str.equals("python")) {
                    chatArea.append("Bot: Python is a simple and powerful programming language widely used in AI, machine learning, web development, and automation.\n");
                }

                // Programming
                else if (str.equals("what is programming") || str.equals("programming")) {
                    chatArea.append("Bot: Programming is the process of writing instructions (code) that tell a computer how to perform specific tasks.\n");
                }

                // Weather
                else if (str.equals("weather") || str.equals("what is the weather")) {
                    chatArea.append("Bot: Sorry, I cannot access live weather information.\n");
                }

                // Location
                else if (str.equals("where am i") || str.equals("my location") || str.equals("location")) {
                    chatArea.append("Bot: I don't have access to your current location.\n");
                }

                // Favorite Color
                else if (str.equals("what is your favorite color") || str.equals("favorite color")) {
                    chatArea.append("Bot: I like blue because it represents knowledge and trust.\n");
                }

                // Favorite Food
                else if (str.equals("what is your favorite food") || str.equals("favorite food")) {
                    chatArea.append("Bot: I don't eat, but if I could choose, I'd say pizza!\n");
                }

                // Favorite Movie
                else if (str.equals("what is your favorite movie") || str.equals("favorite movie")) {
                    chatArea.append("Bot: I enjoy science fiction movies like Interstellar.\n");
                }

                // Favorite Sport
                else if (str.equals("what is your favorite sport") || str.equals("favorite sport")) {
                    chatArea.append("Bot: I like cricket and football because they bring people together.\n");
                }

                // Thank You
                else if (str.equals("thank you") || str.equals("thanks")) {
                    chatArea.append("Bot: You're welcome! Happy to help.\n");
                }

                // Sorry
                else if (str.equals("sorry")) {
                    chatArea.append("Bot: No problem! Let's continue.\n");
                }

                // Can you help
                else if (str.equals("can you help") || str.equals("help me")) {
                    chatArea.append("Bot: Yes! I'll do my best to answer your questions.\n");
                }

                // Tell a fact
                else if (str.equals("tell me a fact") || str.equals("fact")) {
                    chatArea.append("Bot: Fun Fact: The first computer programmer was Ada Lovelace.\n");
                }

                // Capital of Pakistan
                else if (str.equals("capital of pakistan") || str.equals("what is the capital of pakistan")) {
                    chatArea.append("Bot: The capital of Pakistan is Islamabad.\n");
                }

                // Capital of India
                else if (str.equals("capital of india") || str.equals("what is the capital of india")) {
                    chatArea.append("Bot: The capital of India is New Delhi.\n");
                }

                // Capital of USA
                else if (str.equals("capital of usa") || str.equals("what is the capital of united states")) {
                    chatArea.append("Bot: The capital of the USA is Washington, D.C.\n");
                }

                // Capital of UK
                else if (str.equals("capital of uk") || str.equals("what is the capital of united kingdom")) {
                    chatArea.append("Bot: The capital of the United Kingdom is London.\n");
                }

                // Joke
                else if (str.equals("tell me a joke") || str.equals("joke")) {
                    chatArea.append("Bot: Why do programmers prefer dark mode?\nBecause light attracts bugs!\n");
                }

                // Motivation
                else if (str.equals("motivate me") || str.equals("motivation")) {
                    chatArea.append("Bot: Success comes from consistency.\nKeep learning and never stop practicing!\n");
                }

                // Study Tip
                else if (str.equals("study tip") || str.equals("give me a study tip")) {
                    chatArea.append("Bot: Study for 25-30 minutes with full focus,\nthen take a 5-minute break.\n");
                }

                // STORY
                else if (str.equals("tell story")) {
                    chatArea.append("Bot: Once a student built a Java chatbot with hard work and became a successful programmer.\n");
                }

                // POEM
                else if (str.equals("poem")) {
                    chatArea.append("Bot: Roses are red,\nViolets are blue,\nCode every day,\nSuccess follows you.\n");
                }

                // RIDDLE
                else if (str.equals("riddle")) {
                    chatArea.append("Bot: What has keys but can't open locks? Think carefully!\n");
                }

                // RIDDLE ANSWER
                else if (str.equals("answer")) {
                    chatArea.append("Bot: The answer is: A Piano.\n");
                }

                // TODAY'S TIP
                else if (str.equals("today's tip")) {
                    chatArea.append("Bot: Small improvements every day lead to big success.\n");
                }

                // STUDY ADVICE
                else if (str.equals("study advice")) {
                    chatArea.append("Bot: Study regularly, revise often, and practice problems.\n");
                }

                // EXAM TIPS
                else if (str.equals("exam tips")) {
                    chatArea.append("Bot: Stay calm, manage your time well, and read questions carefully.\n");
                }

                // CODING TIPS
                else if (str.equals("coding tips")) {
                    chatArea.append("Bot: Practice coding daily and learn from your mistakes.\n");
                }

                // HAPPINESS
                else if (str.equals("happiness")) {
                    chatArea.append("Bot: Happiness comes from gratitude and helping others.\n");
                }

                // FRIENDSHIP
                else if (str.equals("friendship")) {
                    chatArea.append("Bot: A true friend is someone who stands by you in every situation.\n");
                }

                // SUCCESS
                else if (str.equals("success")) {
                    chatArea.append("Bot: Success is earned through consistency and determination.\n");
                }

                // LOVE
                else if (str.equals("love")) {
                    chatArea.append("Bot: Love is based on trust, care, and understanding.\n");
                }

                // HEALTH
                else if (str.equals("health")) {
                    chatArea.append("Bot: Eat healthy food, drink water, exercise, and sleep well.\n");
                }

                // SLEEP
                else if (str.equals("sleep")) {
                    chatArea.append("Bot: Adults should get around 7 to 9 hours of sleep each night.\n");
                }

                // EXERCISE
                else if (str.equals("exercise")) {
                    chatArea.append("Bot: At least 30 minutes of daily exercise is good for your health.\n");
                }

                // CHATBOT ABILITIES
                else if (str.equals("chatbot abilities")) {
                    chatArea.append("Bot: I can answer predefined questions, perform simple calculations, tell jokes, and provide useful information.\n");
                }

                // LIMITATIONS
                else if (str.equals("limitations")) {
                    chatArea.append("Bot: I cannot browse the internet or answer questions outside my programmed knowledge.\n");
                }

                // DEFAULT
                else {
                    chatArea.append("Bot: Sorry, I don't understand that.\nTry asking about:\n- Greetings\n- AI\n- Programming\n- Date\n- Time\n");
                }
                // --- YOUR EXACT ORIGINAL IF-ELSE LOGIC END ---
            }
        };

        // Attach the action listener to both the click of the button and pressing enter
        sendButton.addActionListener(submitAction);
        inputField.addActionListener(submitAction);
    }
}