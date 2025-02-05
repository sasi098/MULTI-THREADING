//WE CAN USE ANONYMUS INNER CLASS INSTEAD OF CREATING MULTIPLE THREADS
class Multiplier{
    public synchronized void multiply(int k){
        for(int i=1;i<=10;i++){
            System.out.println(k + " * " + i + " : " + (k*i));
            try{
                Thread.sleep(100);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}


class Multiplier1 extends Thread{
    Multiplier m1;
    public Multiplier1(Multiplier m1){
        this.m1 = m1;
    }
    int k = 0;
    public void number(int k){
        this.k = k;
    }
    public void run(){
        m1.multiply(k);
    }
}


public class Synchronization {
    public static void main(String[] args) {
        Multiplier m = new Multiplier();
        Multiplier1 m1 = new Multiplier1(m);
        m1.number(10);
        m1.start();

        Multiplier1 m2 = new Multiplier1(m);
        m2.number(15);
        m2.start();

        Multiplier1 m3 = new Multiplier1(m);
        m3.number(20);
        m3.start();
    }
}
