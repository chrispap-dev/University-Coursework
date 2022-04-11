import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class NetBenefit {
    public static void main(String[] args) throws FileNotFoundException {
        int totalStocks = 0; //Total stocks we have bought
        int profit = 0;
        IntQueueImpl<Transaction> transactionList = new IntQueueImpl<Transaction>();

        try {//read the file.
            FileReader file = new FileReader(args[0]);
            BufferedReader buffer = new BufferedReader(file);

            //start parsing, line by line.
            String currentLine;
            while ((currentLine = buffer.readLine()) != null) {
                String[] splitted = currentLine.split(" ");

                if (splitted[0].equals("buy")) {                                //If we are buying,add new transactions to the Queue
                    int toBuy = Integer.parseInt(splitted[1]);
                    int toBuyPrice = Integer.parseInt(splitted[3]);
                    Transaction newtrans = new Transaction(toBuy, toBuyPrice);
                    transactionList.put(newtrans);
                    totalStocks += toBuy;


                } else {
                    int toSell = Integer.valueOf(splitted[1]);                  //If we are selling, check if we have enough Stocks
                    int toSellPrice = Integer.valueOf(splitted[3]);             //and then start removing Stocks from the queue
                    if (toSell > totalStocks) {
                        System.out.println("Not enough stocks");
                        break;
                    }
                    while (toSell > 0) {                                        //Sell stocks until we don't want to sell anymore.
                        if (toSell >= transactionList.peek().getStocks()) {
                            totalStocks -= transactionList.peek().getStocks();
                            profit += transactionList.peek().getStocks() * (toSellPrice - transactionList.peek().getPrice());
                            toSell -= transactionList.get().getStocks();
                        } else {
                            totalStocks -= toSell;
                            profit += toSell * (toSellPrice - transactionList.peek().getPrice());
                            transactionList.peek().removeStocks(toSell);
                            toSell = 0;
                        }
                    }
                }
            }
            System.out.println("Total profit is " + profit );
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No argument given.");
            e.printStackTrace();
        }
    }
}