public class Multitextends extends Thread{

    public void run(){//THI IS LIKE A CRITICAL STATE
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + " : " +  i + " and the priority is : " + Thread.currentThread().getPriority());
            try{
                Thread.sleep(100);//IMPLEMENTING SLEEP THREAD
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Multitextends m1 = new Multitextends();//this class name  ->> ENTER INTO A NEW STATE
        m1.start(); // ENTER INTO RUN STATE -> THE IT WILL GOES INTO CRITICAL SECTION OR RUNNING STATE WHICH IS EXECUTED BY RUN METHOD ABOVE
        //AFTER THIS THERE ARE TWO PARALLEL THREADS. ONE IS MAIN THREAD AND ANOTHER IS RUN THREAD OR M1 THREAD
        //ONCE HECK THE OUPTU AFTER RUNNING TWO TO THREE TIMES
        m1.join(); //MI COMPLETES ITS TASK AFTER WARD IT WILL ALOWW M2,M3 TO WORK PARALLELLY
        m1.setPriority(10);//10 is the max priority ; 1 is the less priority
        Multitextends m2 = new Multitextends();
        m2.setName("Thread - 2");
        m2.start();

        Multitextends m3 = new Multitextends();
        m3.setName("Thread - 3");
        m3.start();
    }
}
