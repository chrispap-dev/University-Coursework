public class Transaction {
    private int stocks;
    private int price;

    public Transaction(int stocks, int price) {
        this.stocks = stocks;
        this.price = price;
    }

    public int getStocks() {
        return this.stocks;
    }

    public void removeStocks(int stocks) {
        this.stocks -= stocks;
    }

    public int getPrice() {
        return this.price;
    }

}


//    public static void PutToQueue(int stocks,int price){
//        transaction newtransaction = new transaction(stocks,price);
//        transactions.put(newtransaction);
//    }
//    public static Object GetFromQueue(int i){
//        transaction got = new transactions.get();
//
//        Object gotprice = got.get;
//        Object gotstocks = transactions.get();
//
//       if(i==1){
//
//            return
//
//        }
//        return got;
//    }
//}

