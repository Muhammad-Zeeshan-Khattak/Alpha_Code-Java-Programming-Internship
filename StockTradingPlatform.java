import java.time.LocalDateTime;
import java.util.*;

abstract class Asset {
    private String assetId;
    private String symbol;
    private double currentPrice;

    Asset(String assetId, String symbol, double currentPrice) {
        this.assetId = assetId;
        this.symbol = symbol;
        this.currentPrice = currentPrice;
    }

    // Fixed: Now accepts a parameter
    void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    String getAssetId() {
        return assetId;
    }

    // Fixed: Returns just the raw symbol string
    String getSymbol() {
        return symbol;
    }

    void setCurrentPrice(double price) {
        this.currentPrice = price;
    }

    double getCurrentPrice() {
        return currentPrice;
    }

    abstract void displayInfo();
}

class Stock extends Asset {
    private String companyName;
    private String sector;

    Stock(String assetId, String symbol, double currentPrice, String name, String sector) {
        super(assetId, symbol, currentPrice);
        this.companyName = name;
        this.sector = sector;
    }

    String getCompanyName() {
        return companyName;
    }

    void displayInfo() {
        System.out.println("Asset ID: " + getAssetId());
        System.out.println("Symbol: " + getSymbol());
        System.out.println("Current Price: " + getCurrentPrice());
        System.out.println("Name: " + companyName);
        System.out.println("Sector: " + sector);
    }
}

interface Tradable {
    void buyStock(Stock stock, int quantity);
    void sellStock(Stock stock, int quantity);
}

class Transaction {
    private int transactionId;
    private String stockSymbol;
    private int quantity;
    private double stockPrice;
    private String transactionType; 
    private LocalDateTime transactionDate;

    public Transaction(int transactionId, String stockSymbol, int quantity, double stockPrice, String transactionType) {
        this.transactionId = transactionId;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.stockPrice = stockPrice;
        this.transactionType = transactionType;
        this.transactionDate = LocalDateTime.now();
    }

    public int getTransactionId() {
         return transactionId; 
         }
    public String getStockSymbol() {
         return stockSymbol; 
         }
    public int getQuantity() { 
        return quantity; 
        }
    public double getStockPrice() { 
        return stockPrice;
       }
    public String getTransactionType() { 
        return transactionType; 
        }
    public LocalDateTime getTransactionDate() {
         return transactionDate; 
         }

    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
        }
    public void setStockPrice(double stockPrice) { 
        this.stockPrice = stockPrice;
         }

    public double calculateTotal() {
        return quantity * stockPrice;
    }

    public void displayTransaction() {
        System.out.println("Transaction ID : " + transactionId);
        System.out.println("Type           : " + transactionType);
        System.out.println("Stock Symbol   : " + stockSymbol);
        System.out.println("Quantity       : " + quantity);
        System.out.println("Price/Share    : $" + stockPrice);
        System.out.println("Total Amount   : $" + calculateTotal());
        System.out.println("Date & Time    : " + transactionDate);
    }
}

class User implements Tradable {
    private int userId;
    private String name;
    private double balance;

    private Stock[] ownedStocks;
    private int[] quantities;
    private int stockCount;

    private Transaction[] transactions;
    private int transactionCount;

    User(int userId, String name, double balance) {
        this.userId = userId;
        this.name = name;
        this.balance = balance;
        ownedStocks = new Stock[100];
        quantities = new int[100];
        transactions = new Transaction[500];
        stockCount = 0;
        transactionCount = 0;
    }

    public int getUserId() { 
        return userId; 
        }
    public String getName() { 
        return name; 
        }
    public double getBalance() { 
        return balance; 
        }

    public void deposit(double amount) {
        balance += amount;
    }

    public void displayOwnedStocks() {
        System.out.println("----- Holdings -----");
        for (int i = 0; i < stockCount; i++) {
            System.out.println(ownedStocks[i].getSymbol() + " : " + quantities[i] + " shares");
        }
    }

    public void displayTransactions() {
        System.out.println("----- Transactions -----");
        for (int i = 0; i < transactionCount; i++) {
            transactions[i].displayTransaction();
            System.out.println("------------------------");
        }
    }

    @Override
    public void buyStock(Stock stock, int quantity) {
        double totalCost = stock.getCurrentPrice() * quantity;

        if (balance < totalCost) {
            System.out.println("Insufficient balance!");
            return;
        }

        balance -= totalCost;
        boolean found = false;

        // Step 1: Check if already owned
        for (int i = 0; i < stockCount; i++) {
            if (ownedStocks[i].getSymbol().equalsIgnoreCase(stock.getSymbol())) {
                quantities[i] += quantity;
                found = true;
                break;
            }
        }

        // Fixed: Moved outside the for-loop so it evaluates correctly
        if (!found) {
            if (stockCount < ownedStocks.length) {
                ownedStocks[stockCount] = stock;
                quantities[stockCount] = quantity;
                stockCount++;
            } 
            else {
                System.out.println("Portfolio full! Cannot buy new unique stocks.");
                balance += totalCost; // refund
                return;
            }
        }

        Transaction t = new Transaction(
                transactionCount + 1,
                stock.getSymbol(),
                quantity,
                stock.getCurrentPrice(),
                "BUY"
        );

        transactions[transactionCount] = t;
        transactionCount++;

        System.out.println("Stock purchased successfully!");
    }

    @Override
    public void sellStock(Stock stock, int quantity) {
        for (int i = 0; i < stockCount; i++) {
            if (ownedStocks[i].getSymbol().equalsIgnoreCase(stock.getSymbol())) {

                if (quantities[i] < quantity) {
                    System.out.println("Not enough shares to sell!");
                    return;
                }

                double totalAmount = stock.getCurrentPrice() * quantity;
                balance += totalAmount;
                quantities[i] -= quantity;

                if (quantities[i] == 0) {
                    for (int j = i; j < stockCount - 1; j++) {
                        ownedStocks[j] = ownedStocks[j + 1];
                        quantities[j] = quantities[j + 1];
                    }
                    stockCount--;
                }

                Transaction t = new Transaction(
                        transactionCount + 1,
                        stock.getSymbol(),
                        quantity,
                        stock.getCurrentPrice(),
                        "SELL"
                );

                transactions[transactionCount] = t;
                transactionCount++;

                System.out.println("Stock sold successfully!");
                return;
            }
        }
        System.out.println("Stock not found in portfolio!");
    }
}

class Market {
    private Stock[] stocks;
    private int stockCount;

    Market() {
        stocks = new Stock[100];
        stockCount = 0;
    }

    void addStock(Stock s) {
        stocks[stockCount] = s;
        stockCount++;
        System.out.println("Stock registered successfully!");
    }

    void displayStock() {
        for (int i = 0; i < stockCount; i++) {
            System.out.println("Symbol: " + stocks[i].getSymbol());
            System.out.println("Price: $" + stocks[i].getCurrentPrice());
            System.out.println("Company Name: " + stocks[i].getCompanyName());
            System.out.println("Quantity : "+stocks[i].getQuantity());
            System.out.println("------------------------");
        }
    }

    Stock searchStock(String symbol) {
        for (int i = 0; i < stockCount; i++) {
            if (stocks[i].getSymbol().equalsIgnoreCase(symbol)) {
                return stocks[i];
            }
        }
        return null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Market market = new Market();

        market.addStock(new Stock("A001", "AAPL", 180.5, "Apple Inc", "Technology"));
        market.addStock(new Stock("A002", "TSLA", 250.0, "Tesla Inc", "Automobile"));
        market.addStock(new Stock("A003", "GOOG", 2900.0, "Google", "Technology"));
        market.addStock(new Stock("A004", "AMZN", 3400.0, "Amazon", "E-commerce"));

        User user = new User(1, "Ali", 10000);

        while (true) {
            System.out.println("\n===== STOCK TRADING SYSTEM =====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Holdings");
            System.out.println("5. View Transactions");
            System.out.println("6. View Balance");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                market.displayStock();
            } 
            else if (choice == 2) {
                System.out.print("Enter stock symbol: ");
                String symbol = sc.next();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                Stock stock = market.searchStock(symbol);
                if (stock != null) {
                    user.buyStock(stock, qty);
                }
                else {
                    System.out.println("Stock not found!");
                }
            } 
            else if (choice == 3) {
                System.out.print("Enter stock symbol: ");
                String symbol = sc.next();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                Stock stock = market.searchStock(symbol);
                if (stock != null) {
                    user.sellStock(stock, qty);
                } 
                else {
                    System.out.println("Stock not found!");
                }
            } 
            else if (choice == 4) {
                user.displayOwnedStocks();
            } 
            else if (choice == 5) {
                user.displayTransactions();
            } 
            else if (choice == 6) {
                System.out.println("Balance: $" + user.getBalance());
            } 
            else if (choice == 7) {
                System.out.println("Exiting system...");
                break;
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}