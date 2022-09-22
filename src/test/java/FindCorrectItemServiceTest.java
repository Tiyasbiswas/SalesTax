import org.testng.annotations.Test;

import java.util.*;

public class FindCorrectItemServiceTest{

    @Test
    void FindCorrectCategorybasedonString (){

        // Input 1
        List<String> listItems = new ArrayList<>();

        listItems.add("1 book at 12.49");
        listItems.add("1 music CD at 14.99");
        listItems.add("1 chocolate bar at 0.85");
        FindCorrectItemService.categorybasedItem(listItems);
        //input 2
        List<String> listItems1 = new ArrayList<>();

        listItems1.add("1 imported box of chocolates at 10.00");
        listItems1.add("1 imported bottle of perfume at 47.50");
        FindCorrectItemService.categorybasedItem(listItems1);


        // Input 3
        List<String> listItems2= new ArrayList<>();

        listItems2.add("1 imported bottle of perfume at 27.99");
        listItems2.add("1 bottle of perfume at 18.99");
        listItems2.add("1 packet of headache pills at 9.75");
        listItems2.add("1 box of imported chocolates at 11.25");
        FindCorrectItemService.categorybasedItem(listItems2);


    }
}
