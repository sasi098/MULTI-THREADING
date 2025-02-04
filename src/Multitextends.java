public class Multitextends extends Thread{

    public void run(){//THI IS LIKE A CRITICAL STATE
        for(int i=0;i<10;i++){
            System.out.println("hey this i user thread");
            try{
                Thread.sleep(100);//IMPLEMENTING SLEEP THREAD
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Multitextends m1 = new Multitextends();//this class name  ->> ENTER INTO A NEW STATE
        m1.start(); // ENTER INTO RUN STATE -> THE IT WILL GOES INTO CRITICAL SECTION OR RUNNING STATE WHICH IS EXECUTED BY RUN METHOD ABOVE
        //AFTER THIS THERE ARE TWO PARALLEL THREADS. ONE IS MAIN THREAD AND ANOTHER IS RUN THREAD OR M1 THREAD
        //ONCE HECK THE OUPTU AFTER RUNNING TWO TO THREE TIMES
        for(int i=0;i<10;i++){
            System.out.println("hey this i main thread");
        }
    }
}
