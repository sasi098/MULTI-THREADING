public class Multiimplements implements Runnable {
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("hey this i user thread");
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new Multiimplements();
        Runnable r2 = new Multiimplements();

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start(); // it enters into a runnable state
        t2.start();
    }
}
