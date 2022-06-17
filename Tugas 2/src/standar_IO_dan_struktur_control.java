import java.io.IOException;
import java.util.Scanner;

public class standar_IO_dan_struktur_control {
    public static void main(String[] args) throws IOException {
        Scanner terminalInput = new Scanner(System.in);
        String pilihan;
        boolean isLanjutkan = true;

        while (isLanjutkan) {
            clearScreen();
            System.out.println("Menu\n");
            System.out.println("1. Tampilkan Case Satu");
            System.out.println("2. Tampilkan Case Dua ");
            System.out.println("3. Tampilkan Case Tiga");
            System.out.print("\nPilihan anda: ");
            pilihan = terminalInput.next();
            switch (pilihan) {
                case "1":
                    clearScreen();
                    System.out.println("Menu Case 1\n");
                    System.out.println("1. Percabangan If     ");
                    System.out.println("2. Percabangan Else If");
                    System.out.print("\nPilihan anda: ");
                    Scanner input1 = new Scanner(System.in);
                    int pil1 = input1.nextInt();
                    if (pil1 == 1){
                        C1P1();
                    } else if (pil1 == 2){
                        C1P2();
                    }
                    else {
                        System.out.println("\nPercabangan Else");
                    }
                    break;
                case "2":
                    clearScreen();
                    System.out.println("Menu Case 2\n");
                    System.out.println("1. Percabangan If      ");
                    System.out.println("2. Percabangan Else If ");
                    System.out.print("\nPilihan anda: ");
                    Scanner input2 = new Scanner(System.in);
                    int pil2 = input2.nextInt();
                    if (pil2 == 1){
                        C2P1();
                    } else if (pil2 == 2){
                        C2P2();
                    }
                    else {
                        System.out.println("\nPercabangan Else");
                    }
                    break;
                case "3":
                    clearScreen();
                    System.out.println("Menu Case 3\n");
                    System.out.println("1. Pecabangan If      ");
                    System.out.println("2. Percabangan Else If");
                    System.out.print("\nPilihan anda: ");
                    Scanner input3 = new Scanner(System.in);
                    int pil3 = input3.nextInt();
                    if (pil3 == 1){
                        C3P1();
                    } else if (pil3 == 2){
                        C3P2();
                    }
                    else {
                        System.out.println("\nPercabangan Else");
                    }
                    break;
                default:
                    System.err.println("\nInput anda tidak ditemukan\nSilahkan pilih [1-3]");
            }

            isLanjutkan = getYesorNo("Apakah Anda ingin melanjutkan");
        }
    }

    //Case 1 Pecabangan
    private static void C1P1(){
        System.out.println("\nCase 1 Pilihan 1");
    }
    private static void C1P2(){
        System.out.println("\nCase 1 Pilihan 2");
    }
    //Akhir Case 1 Pecabangan

    //Case 2 Pecabangan
    private static void C2P1(){
        System.out.println("\nCase 2 Pilihan 1");
    }
    private static void C2P2(){
        System.out.println("\nCase 2 Pilihan 2");
    }
    //Akhir Case 2 Pecabangan

    //Case 3 Pecabangan
    private static void C3P1(){
        System.out.println("\nCase 3 Pilihan 1");
    }
    private static void C3P2(){
        System.out.println("\nCase 3 Pilihan 2");
    }
    //Akhir Case 3 Pecabangan

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