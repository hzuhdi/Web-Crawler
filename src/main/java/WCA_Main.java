import java.util.Scanner;

public class WCA_Main {

    WCA_Controller wca_controller = new WCA_Controller();

    public static void main(String agrs[]){

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("------Welcome to Web Crawler Application TCI ------");
            System.out.println("--Make sure that your local web server is running--");
            System.out.println("---------------------------------------------------");
            System.out.println("Please choose a number");
            System.out.println("1. Crawl All");
            System.out.println("2. Crawl Specific");
            System.out.println("3. Exit");
            int x = sc.nextInt();
            if(x==3){
                break;
            }
        }


    }
}
