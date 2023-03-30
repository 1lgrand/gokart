public class Main {
    public static void main(String...args) throws InterruptedException {
        for (int i=0;i<4;i++){
            Pilota p = new Pilota(String.valueOf(i));
            p.start();
        }
    }
}
