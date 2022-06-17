import java.io.IOException;
import java.util.Scanner;

public class konversi_waktu {
        public static void main(String[] args) throws IOException {
                Scanner terminalInput = new Scanner(System.in);
                String pilihan;
                boolean isLanjutkan = true;

                while (isLanjutkan) {
                        clearScreen();
                        System.out.println("Menu\n");
                        System.out.println("1. Konversi Detik");
                        System.out.println("2. Konversi Menit");
                        System.out.println("3. Konversi Jam  ");
                        System.out.print("\nPilihan anda: ");
                        pilihan = terminalInput.next();
                        switch (pilihan) {
                                case "1":
                                        clearScreen();
                                        System.out.println("Menu\n");
                                        System.out.println("1. Detik Ke Menit");
                                        System.out.println("2. Detik Ke Jam  ");
                                        System.out.print("\nPilihan anda: ");
                                        Scanner input1 = new Scanner(System.in);
                                        int pil1 = input1.nextInt();
                                        if (pil1 == 1){
                                                detikmenit();
                                        } else if (pil1 == 2){
                                                detikjam();
                                        }
                                        else {
                                                System.out.println("\nPilihan tidak tersedia");
                                        }
                                        break;
                                case "2":
                                        clearScreen();
                                        System.out.println("Menu\n");
                                        System.out.println("1. Menit Ke Detik");
                                        System.out.println("2. Menit Ke Jam  ");
                                        System.out.print("\nPilihan anda: ");
                                        Scanner input2 = new Scanner(System.in);
                                        int pil2 = input2.nextInt();
                                        if (pil2 == 1){
                                                menitdetik();
                                        } else if (pil2 == 2){
                                                menitjam();
                                        }
                                        else {
                                                System.out.println("\nPilihan tidak tersedia");
                                        }
                                        break;
                                case "3":
                                        clearScreen();
                                        System.out.println("Menu\n");
                                        System.out.println("1. Jam Ke Detik");
                                        System.out.println("2. Jam Ke Menit");
                                        System.out.print("\nPilihan anda: ");
                                        Scanner input3 = new Scanner(System.in);
                                        int pil3 = input3.nextInt();
                                        if (pil3 == 1){
                                                jamdetik();
                                        } else if (pil3 == 2){
                                                jammenit();
                                        }
                                        else {
                                                System.out.println("\nPilihan tidak tersedia");
                                        }
                                        break;
                                default:
                                        System.err.println("\nInput anda tidak ditemukan\nSilahkan pilih [1-3]");
                        }

                        isLanjutkan = getYesorNo("Apakah Anda ingin melanjutkan");
                }
        }

        //Konversi Detik
        private static void detikmenit() throws IOException{
                Scanner input = new Scanner(System.in);
                System.out.print("\nMasukkan Detik : ");
                int waktuDalamDetik = input.nextInt();
                int menit;
                if(waktuDalamDetik >=60) {
                        menit = waktuDalamDetik/60;
                }
                else {
                        menit = 0;
                }
                System.out.println("\nHasil Konversi\n\n" + menit + " Menit");
        }

        private static void detikjam() throws IOException{
                Scanner input = new Scanner(System.in);
                System.out.print("\nMasukkan Detik : ");
                int waktuDalamDetik = input.nextInt();
                int jam;
                if(waktuDalamDetik >= 3600) {
                        jam = waktuDalamDetik/3600;
                }
                else {
                        jam = 0;
                }
                System.out.println("\nHasil Konversi\n\n" + jam + " Jam");
        }
        //Akhir Konversi Detik

        //Konversi Menit
        private static void menitdetik() throws IOException{
                Scanner input = new Scanner(System.in);
                System.out.print("\nMasukkan Menit : ");
                int waktuDalamMenit = input.nextInt();
                int detik;
                if(waktuDalamMenit >=1) {
                        detik = waktuDalamMenit*60;
                }
                else {
                        detik = 0;
                }
                System.out.println("\nHasil Konversi\n\n" + detik + " Detik");
        }

        private static void menitjam() throws IOException{
                Scanner input = new Scanner(System.in);
                System.out.print("\nMasukkan Menit : ");
                int waktuDalamMenit = input.nextInt();
                int jam;
                if(waktuDalamMenit >= 60) {
                        jam = waktuDalamMenit/60;
                }
                else {
                        jam = 0;
                }
                System.out.println("\nHasil Konversi\n\n" + jam + " Jam");
        }
        //Akhir Konversi Menit

        //Konversi Jam
        private static void jamdetik() throws IOException{
                Scanner input = new Scanner(System.in);
                System.out.print("\nMasukkan Jam : ");
                int waktuDalamJam = input.nextInt();
                int detik;
                if(waktuDalamJam >=1) {
                        detik = waktuDalamJam*3600;
                }
                else {
                        detik = 0;
                }
                System.out.println("\nHasil Konversi\n\n" + detik + " Detik");
        }

        private static void jammenit() throws IOException{
                Scanner input = new Scanner(System.in);
                System.out.print("\nMasukkan Jam : ");
                int waktuDalamJam = input.nextInt();
                int menit;
                if(waktuDalamJam >=1) {
                        menit = waktuDalamJam*60;
                }
                else {
                        menit = 0;
                }
                System.out.println("\nHasil Konversi\n\n" + menit + " Menit");
        }
        //Akhir Konversi Jam

        private static boolean getYesorNo(String message){
                Scanner terminalInput = new Scanner(System.in);
                System.out.print("\n"+message+" (y/n)? ");
                String pilihan = terminalInput.next();

                while(!pilihan.equalsIgnoreCase("y") && !pilihan.equalsIgnoreCase("n")) {
                        System.err.println("Pilihan anda bukan y atau n");
                        System.out.print("\n"+message+" (y/n)? ");
                        pilihan = terminalInput.next();
                }

                return pilihan.equalsIgnoreCase("y");

        }


        private static void clearScreen(){
                try {
                        if (System.getProperty("os.name").contains("Windows")){
                                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                        } else {
                                System.out.print("\033\143");
                        }
                } catch (Exception ex){
                        System.err.println("clear screen tidak tersedia");
                }
        }

}