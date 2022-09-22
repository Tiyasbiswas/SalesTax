
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.math.RoundingMode;

    enum Category {BOOK, FOOD, MEDICAL, OTHER};

    public class FindCorrectItemService{
        public static void categorybasedItem(List  listItems){

            CalculateAllTypeTax cat = new CalculateAllTypeTax();

            Boolean isImport= false;
            Boolean isExtem=false;
            BigDecimal salesTax;

            BigDecimal totalPrice = BigDecimal.ZERO;
            BigDecimal totalTaxes = BigDecimal.ZERO;
            final DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(" ---------------------------Reciept---------------------------------");

            for( int i= 0 ;i <listItems.size();i++ ){
                String data= listItems.get(i).toString().strip();
                String[] splitedLine = data.split(" at ");

                // Divide the quantity and name from the extracted data.
                String[] quantityAndName = splitedLine[0].split(" ", 2);
                String itemname = quantityAndName[1];
                String itemcatagory="";
                int itemQuantity= Integer.parseInt(quantityAndName[0]);

                double item_price = Double.parseDouble(splitedLine[1]);
                double itemValue= item_price *itemQuantity;

                // Setting the category based on Item

                if (itemname.contains("chocolate bar")||itemname.contains("chocolates")||itemname.contains("sweet")||itemname.contains("sandwitch")){
                    itemcatagory= String.valueOf(Category.FOOD);
                }
                else if (itemname.contains("medical")||itemname.contains("headache pills")||itemname.contains("oinment")||itemname.contains("parasitamol")) {
                    itemcatagory= String.valueOf(Category.MEDICAL);
                }
                else if (itemname.contains("book")||itemname.contains("note")||itemname.contains("copy")) {
                    itemcatagory= String.valueOf(Category.BOOK);
                }
                else{
                    itemcatagory= String.valueOf(Category.OTHER);
                }

                // Calculate The tax Based on category and item Quantity
                if ((itemname.contains("imported") &&
                        (itemcatagory.equalsIgnoreCase("food") ||
                                itemcatagory.equalsIgnoreCase("book")|| itemcatagory.equalsIgnoreCase("medical"))) ){
                    isExtem= true; isImport=true;

                    salesTax=cat.calculateTaxes(BigDecimal.valueOf(0.05),BigDecimal.valueOf(itemValue));
                }
                else if (itemname.contains("imported") && itemcatagory.equalsIgnoreCase("other")){
                    isImport=true;
                    salesTax=cat.calculateTaxes(BigDecimal.valueOf(0.15),BigDecimal.valueOf(itemValue));

                }
                else if(itemcatagory.equalsIgnoreCase("food") ||
                        itemcatagory.equalsIgnoreCase("book")|| itemcatagory.equalsIgnoreCase("medical")){
                    isExtem= true;
                    salesTax=cat.calculateTaxes(BigDecimal.valueOf(0.00),BigDecimal.valueOf(itemValue));

                }else {
                    salesTax=cat.calculateTaxes(BigDecimal.valueOf(0.10),BigDecimal.valueOf(itemValue));

                }
                df.setRoundingMode(RoundingMode.UP);
                item_price= Double.parseDouble(df.format(item_price+ Double.valueOf(String.valueOf(salesTax))));


                totalTaxes  = totalTaxes.add(salesTax);
                totalPrice = totalPrice.add(BigDecimal.valueOf(itemValue)).add(salesTax);


                // Printing the items
                System.out.print(String.valueOf(itemQuantity)+" " +itemname +" :" +String.valueOf(item_price));
                System.out.println(" ");
            }
            System.out.println("=======================================================================================");
            System.out.println("Sales Taxes: "+totalTaxes);
            System.out.println("Total: " + totalPrice);
            System.out.println(" ");
            System.out.println(" ");


        }

    }

