
import java.io.IOException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Management t = new Management();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("---------LIST----------------");
        System.out.println("1.Load data from file");
        System.out.println("2. Input & inseart data");
        System.out.println("3.In-order traverse");
        System.out.println("4.Breadth-first traverse");
        System.out.println("5.In-order traverse to file");
        System.out.println("6.Search by pcode");
        System.out.println("7.Delete by pcode by copying");
        System.out.println("8.Simply balancing");
        System.out.println("9.Count number of buses");
        do {
            System.out.println("Choose your option: ");
            int choice = Integer.parseInt(sc.nextLine());
            String fname = "bus.txt";
            switch (choice) {
                case 1: {
                    
                    t.loadFile(fname);
                    System.out.println();
                    break;
                }
                
                case 3: {
                    t.inOrder(t.root);
                    break;
                }
                case 4: {
                    t.breadth(t.root);
                    break;
                }
                case 5: {
                    t.inOrder(t.root);
                    break;
                }
                case 6: {
                    System.out.println("Enter the code you want to search: ");
                    String xbcode = sc.nextLine();
                    t.search(t.root, xbcode);
                    break;
                }
                case 7: {
                    t.deleByCopy("1");
                    t.breadth(t.root);
                    System.out.println();
                }
                case 11: {
                    t.clear();
                    t.loadFile(fname);
                    t.f6();
                                        System.out.println();

                    //t.breadth(t.root);
                    
                }
                case 12: {
                    t.clear();
                    t.loadFile(fname);
                    t.f3();
                                        System.out.println();

                    t.breadth(t.root);
                }
                case 13: {
                    t.clear();
                    t.loadFile(fname);
                }
                case 14: {
                    t.clear();
                    t.loadFile(fname);
                    //BusBooking x = new BusBooking("8", "T", 3, 2, 1, 2);
                    t.insert1();
                    t.breadth(t.root);
                }
                case 15: {
                    //System.out.println("")
                }
            }
        } while (true);
    }
}
