//INTER THREAD MAINLY CONSISTS OF WAIT AND NOTIFY
//WAIT MEANS -> IF THERE ARE TWO THREADS T1,T2 , FIRST T1 HOLDING LOCK
//IF WE USE WAIT IN T1 THEN T1 RELEASES LOCK AND T2 CAN RUN THE ITS THREAD
//T2 NOTIFIES THE T1 BY CALLING NOTIFY()
//THEN T1 WILL CONTINUE ITS WORK

class Bank{
    int balance;
    public Bank(int balance) {
        this.balance = balance;
    }
    public void getBalance(){
        System.out.println("Balance is : " + balance);
    }
    public synchronized void debit(int amount){
        System.out.println("Debiting on the way");
        if(amount > balance){
            System.out.println("No amount");
            try{
                wait();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        balance = balance - amount;
        System.out.println("Withdraw Completed");
        getBalance();
    }

    public synchronized void credit(int amount){
        System.out.println("Crediting on the way");
        balance = balance + amount;
        System.out.println("Credited");
        getBalance();
        notify();
    }
}


public class Interthread {
    public static void main(String[] args) {
        Bank b1 = new Bank(2500);

        new Thread(){
            public void run(){
                b1.debit(3000);
            }
        }.start();

        new Thread(){
            public void run(){
                b1.credit(3000);
            }
        }.start();
    }
}
