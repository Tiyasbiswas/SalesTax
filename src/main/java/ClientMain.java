import java.util.*;

public class ClientMain{
    public static void main(String[] args) {
        char         choice     = '\0';
        String       itemDetails= "";
        List<String> listItems  = new ArrayList<>();
        Scanner      scan       = new Scanner(System.in);
        System.out.println("Welcome !! Please enter the Product one by one ");
        do {
            itemDetails= scan.nextLine();
            listItems.add(itemDetails);
            System.out.print("Want to add more items? (y or n): ");
            //reads a character Y or N
            choice = scan.next().charAt(0);
            scan.nextLine();
        }
        while (choice == 'y' || choice == 'Y');
        System.out.println("List of items "+listItems);

        // finding the Correct catagory
        FindCorrectItemService fc = new FindCorrectItemService();
        fc.categorybasedItem(listItems);

    }
}
