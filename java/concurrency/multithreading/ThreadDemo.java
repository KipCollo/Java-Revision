
public class ThreadDemo implements Runnable{

    @Override
    public void run() {
       System.out.println("Downloading Movie.."+ Thread.currentThread().getName());
    

      try{
         Thread.sleep(5000);
      }catch(InterruptedException e){
      System.out.println("");
      e.printStackTrace();
     }
     System.out.println("Download complete" + Thread.currentThread().getName());
    }
}
