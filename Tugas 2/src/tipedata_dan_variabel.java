/*nama class*/
public class tipedata_dan_variabel {
    String  variabel1; //dapat menyimpan banyak karakter
    char    variabel2; //dapat menyimpan sebuah karakter
    int     variabel3; //dapat menyimpan sebuah bilangan bulat
    float   variabel4; //dapat menyimpan bilangan pecahan
    double  variabel5; //dapat menyimpan banyak bilangan pecahan
    boolean variabel6; //dapat menyimpan nilai true atau false

    /*nama dan isi variabel*/
    public tipedata_dan_variabel(){ //konstruktor default
        variabel1 = "Ahmad Ruslandia Papua";
        variabel2 = 'A';
        variabel3 = 1;
        variabel4 = 3.8F;
        variabel5 = 3.89;
        variabel6 = true;
    }

    /*tampilan pada program*/
    public static void main (String[] args){
        tipedata_dan_variabel i = new tipedata_dan_variabel();

        System.out.println("Nama    : " + i.variabel1);
        System.out.println("Kelas   : " + i.variabel2 + i.variabel3);
        System.out.println("IPS     : " + i.variabel4);
        System.out.println("IPK     : " + i.variabel5);
        System.out.println("Status  : " + i.variabel6);
    }
}

