import exception.YearException;

import java.io.IOException;
import java.util.Scanner;

public class WCA_Main {

    WCA_Controller wca_controller = new WCA_Controller();

    public static void main(String agrs[]) throws YearException, IOException {

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
            if(x==1){
                System.out.println("Please input the url you want to take a look for: e.g: http://localhost/sample_site_to_crawl/catalog.php" );
                String input = sc.next();
                WCA_Controller wca_controller = new WCA_Controller();
                String y = wca_controller.getAll(input);
                Long l = wca_controller.getTimeElapsedInMS();
                System.out.println(y);
                System.out.println("Time taken: " + l.toString() + "miliseconds");
                break;
            } else if(x==2){
                WCA_Controller wca_controller = new WCA_Controller();
                System.out.println("Please input the url you want to take a look for: e.g: http://localhost/sample_site_to_crawl/catalog.php" );
                String input = sc.next();
                System.out.println("Please input the keyword: e.g: Princess" );
                String word = sc.next();
                Object y = wca_controller.getSpecific(input, word);
                Long l = wca_controller.getTimeElapsedInMS();
                System.out.println(y);
                System.out.println("Time taken: " + l.toString() + "miliseconds");
            } if(x==3){
                break;
            } else {
                break;
            }
        }


    }
}
