class Display{
    public synchronized void printsmall(){
        for(int i=97;i<=122;i++){
            System.out.print((char) i + " ");
            try{
                Thread.sleep(100);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public synchronized void printlarge(){
        for(int i=65;i<=90;i++){
            System.out.print((char) i + " ");
            try{
                Thread.sleep(100);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

//ANONYMUS INNER CALSS MEANS WE CAN DEFINR THREAD INSIDE MAIN
public class Anonymusinner {
    public static void main (String[] args) {
        Display d1 = new Display();

        Thread t1 = new Thread(){
          public void run(){
              d1.printsmall();
          }
        };


        Thread t2 = new Thread(){
          public void run(){
              d1.printlarge();
          }
        };

        t1.start();
        t2.start();
    }
}
