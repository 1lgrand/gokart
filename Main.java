public class Main {

    public static final int NPILOTI = 8;

    public static void main(String[] args){

        Thread[] piloti = new Thread[NPILOTI];
        int i;

        System.out.println("*== I ragazzi entrano ==*");

        for (i=0;i<NPILOTI;i++){
            Pilota p = new Pilota(String.valueOf(i));
            piloti[i] = new Thread(p);
            piloti[i].start();
        }




    }
}



