/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/07
 */

package project;

import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {

    public static String FILENAME = "src/project/stock.csv";
    public static String ShelvedType = "Shelved";
    public static String AgeRestrictedType = "AgeRestricted";
    public static String ProduceType = "Produce";

    public static void main(String[] args) {
        // load initial data and print status
        ArrayList<Goods> goodsList = readFile(FILENAME);

        // run main menu
        menu(new Store(goodsList));

    }

    // main menu
    public static void menu(Store store) {
        Scanner input = new Scanner(System.in);
        boolean done = false;

        do {
            // Print out menu
            System.out.println("-----------main menu----------");
            System.out.println("1. Add  a new goods");
            System.out.println("2. Sell  goods");
            System.out.println("3. Remove goods");
            System.out.println("4. Search for  goods (by name)");
            System.out.println("5. Modify a goods");
            System.out.println("6. List all goods");
            System.out.println("7. Save the current stock to a file");
            System.out.println("8. Exit and save");
            // Get user selection
            System.out.print("Choice: ");
            String in = input.nextLine();
            // Handle user selection
            switch (in) {
                case "1": // Add a new goods
                    addGoodsOption(store, input);
                    break;
                case "2": // Sell goods
                    sellGoodsOption(store, input);
                    break;
                case "3": // Remove goods
                    removeGoodsOption(store, input);
                    break;
                case "4": // Search for goods (by name)
                    searchGoodsOption(store, input);
                    break;
                case "5": // Modify a goods
                    modifyGoodsOption(store, input);
                    break;
                case "6": // List all goods
                    System.out.println(store.toString());
                    break;
                case "7": // Save the current stock
                    System.out.print("Input filename: ");
                    String filename = input.nextLine();
                    writeFile(store, filename);
                    break;
                case "8": // Exit
                    writeFile(store, FILENAME);
                    done = true;
                    break;
                default:
                    System.out.println(
                            "****INPUT ERROR**** I'm sorry, but I didn't understand " + in + " . Please try again ");
            }
        } while (!done);
        input.close();
        System.out.println("Goodbye!");
    }

    // read data from file
    public static ArrayList<Goods> readFile(String filename) {
        ArrayList<Goods> data = new ArrayList<Goods>();

        try {
            File f = new File(filename);
            Scanner input = new Scanner(f);
            while (input.hasNextLine()) {
                try {
                    // line format: AgeRestricted,asdf,3.0,2,18
                    String line = input.nextLine();
                    String[] values = line.split(",");
                    String type = values[0];
                    switch (type) {
                        case "Produce":// Produce Item
                            Date d = new SimpleDateFormat("MM/dd/yyyy").parse(values[4], new ParsePosition(0));
                            ProduceGoods produceGoods = new ProduceGoods(values[1], Double.parseDouble(values[2]),
                                    Integer.parseInt(values[3]), d);
                            data.add(produceGoods);
                            break;
                        case "Shelved":// Shelved Item
                            Goods goods = new Goods(values[1], Double.parseDouble(values[2]),
                                    Integer.parseInt(values[3]));
                            data.add(goods);
                            break;
                        case "AgeRestricted":// Age Restricted Item
                            AgeRestrictedGoods ageRestrictedGoods = new AgeRestrictedGoods(values[1],
                                    Double.parseDouble(values[2]), Integer.parseInt(values[3]),
                                    Integer.parseInt(values[4]));
                            data.add(ageRestrictedGoods);
                            break;
                        default:
                            System.out.println("A line format error. unkown type");
                            break;
                    }

                } catch (Exception e) {
                    System.out.println("A line format error. " + e.getMessage());
                }
            }
            input.close();
        } catch (Exception e) {
            System.out.println(
                    "The store is initialized empty from stock.csv, you can check the file`s format than restart or continue use the empty store. "
                            + e.getMessage());
        }
        System.out.println("The store is initialized from " + filename);
        return data;
    }

    // write the stock to file
    public static void writeFile(Store store, String filename) {
        try {
            FileWriter f = new FileWriter(filename);
            f.write(store.serialize());
            f.flush();
            f.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Finished Writing");
    }

    // handle 1. Add a new goods
    public static void addGoodsOption(Store store, Scanner input) {
        System.out.println("Input  name:");
        String name = input.nextLine();

        System.out.println("Input  price:");
        double price = parseDouble(input);

        System.out.println("Please enter the stock number for this goods");
        int number = parseInt(input);

        Goods goods = new Goods(name, price, number);
        Date date = hasExpDate(input);
        if (date != null) {
            ProduceGoods produceGoods = new ProduceGoods(name, price, number, date);
            goods = produceGoods;
        } else {
            int age = hasAgeRestricted(input);
            if (age > 0) {
                AgeRestrictedGoods ageGoods = new AgeRestrictedGoods(name, price, number, age);
                goods = ageGoods;
            }
        }

        if (store.addGoods(goods)) {
            System.out.println(goods.toString());
            System.out.println("---- Add succeed");
        } else {
            System.out.println("---- Add failed");
        }
    }

    // handle 2. Sell goods
    public static void sellGoodsOption(Store store, Scanner input) {
        boolean done = false;
        int pos;
        do {
            System.out.println("------------ your cart -----------");
            System.out.println(store.cartString());
            System.out.println("------------ cart menu -----------");
            System.out.println("1. Add a goods to cart.  ");
            System.out.println("2. Delete a goods from cart. ");
            System.out.println("3. Checkout. ");
            System.out.println("4. Back to main menu. ");
            System.out.println("5. Clear cart. ");
            System.out.print("Choice: ");
            String in = input.nextLine();
            // Handle user selection
            switch (in) {
                case "1":// 1. Add a goods to cart.
                    try {
                        System.out.println(
                                "Input the Index of goods that you want add  to cart. If you forget index, go back to the main menu to check it out");
                        pos = parseIntFromInput(input);
                        store.addToCart(pos);
                    } catch (Exception e) {
                        System.out.println("**** Error: " + e.getMessage());
                    }
                    break;
                case "2":// 2. Delete a goods from cart.
                    try {
                        System.out.println("Input the CartIndex of goods that you want delete from  cart. ");
                        pos = parseIntFromInput(input);
                        store.deleteFromCart(pos);
                    } catch (Exception e) {
                        System.out.println("**** Error: " + e.getMessage());
                    }
                    break;
                case "3":// 3. Checkout.
                    try {
                        store.checkoutCart();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("---- Checkout Succeed");
                    break;
                case "4":// 4. Back to main menu.
                    done = true;
                    break;
                case "5":// 5. Clear cart.
                    done = true;
                    store.clearCart();
                    System.out.println("---- Cart cleared");
                    break;
                default:
                    System.out.println("****INPUT ERROR**** I'm sorry, but I didn't understand");
            }

        } while (!done);
    }

    // handle 4. Search for goods (by name)
    public static void searchGoodsOption(Store store, Scanner input) {
        System.out.println("Input the name: ");
        String name = input.nextLine();
        ArrayList<Goods> goodsList = store.getGoodsByName(name);

        if (goodsList == null) {
            System.out.println("---- Sorry, there are no products named " + name + "  here");
        } else {
            for (Goods goods : goodsList) {
                System.out.println(goods.toString());
            }
        }
    }

    // handle 5. Modify a goods
    public static void modifyGoodsOption(Store store, Scanner input) {
        System.out.println("Input the index of goods that you want to modify:  ");
        int pos = parseInt(input);

        Goods goods = store.getGoods(pos);
        if (goods == null) {
            System.out.println("Sorry, this goods dont exist. ");
        } else {
            boolean done = false;
            do {
                System.out.println(goods.toString());
                System.out.println("-----------modify menu----------");
                System.out.println("1. Modify name");
                System.out.println("2. Modify Price");
                System.out.println("3. Modify the stock number");
                if (goods.getType().equals(AgeRestrictedType)) {
                    System.out.println("4. Modify Restricted Age ");
                } else if (goods.getType().equals(ProduceType)) {
                    System.out.println("5. Modify Expire Date ");
                }
                System.out.println("6. Save the goods");
                System.out.println("7. Cancel");
                // Get user selection
                System.out.print("Choice: ");
                String in = input.nextLine();
                // Handle user selection
                switch (in) {
                    case "1": // 1. Modify name
                        goods = modifyNameFromInput(goods, input);
                        break;
                    case "2": // 2. Modify Price
                        goods = modifyPriceFromInput(goods, input);
                        break;
                    case "3": // 3. Modify the stock number
                        goods = modifyNumberFromInput(goods, input);
                        break;
                    case "4": // 4. Modify Restricted Age
                        goods = modifyRestrictedAgeFromInput(goods, input);
                        break;
                    case "5": // 5. Modify Expire Date
                        goods = modifyExpireDate(goods, input);
                        break;
                    case "6": // 6. Save the goods
                        done = true;
                        if (store.updateGoods(pos, goods)) {
                            System.out.println("Save success");
                        } else {
                            System.out.println("Save fail");
                        }
                        break;
                    case "7": // 7. Cancel
                        done = true;
                        break;
                    default:
                        System.out.println("I'm sorry, but I didn't understand");
                }
            } while (!done);

        }
    }

    // handle 3. Remove goods
    public static void removeGoodsOption(Store store, Scanner input) {
        System.out.println("Input the index of goods that you want to remove:  ");

        int pos = parseInt(input);
        Goods goods = store.getGoods(pos);
        if (goods == null) {
            System.out.println("Sorry, this goods dont exist. ");
            return;
        }
        System.out.println(goods.toString());
        System.out.println(
                "Remove all this goods ? Y/N , if you want to reduce the number of the goods, please select the 5 option in main menu.");
        String in = input.nextLine();
        if (in.equalsIgnoreCase("Y")) {
            store.deleteGoods(pos);
            System.out.println(goods.getName() + "  removed succeed");

        }
    }

    // handle 5. Modify a goods -> modify Name
    private static Goods modifyNameFromInput(Goods goods, Scanner input) {
        System.out.println("Input the name: ");
        String modifyName = input.nextLine();
        goods.setName(modifyName);
        return goods;
    }

    // handle 5. Modify a goods -> modify Price
    private static Goods modifyPriceFromInput(Goods goods, Scanner input) {
        System.out.println("Input the price: ");
        double price = parseDouble(input);
        goods.setPrice(price);
        return goods;
    }

    // handle 5. Modify a goods -> modify stock Number
    private static Goods modifyNumberFromInput(Goods goods, Scanner input) {
        System.out.println("Input the stock number: ");
        int number = parseInt(input);
        goods.setNumber(number);
        return goods;
    }

    // handle 5. Modify a goods -> modify Restricted Age
    private static Goods modifyRestrictedAgeFromInput(Goods goods, Scanner input) {
        System.out.println("Input the Restricted Age: ");
        int age = parseInt(input);
        AgeRestrictedGoods ageGoods = (AgeRestrictedGoods) goods;
        ageGoods.setRestrictedAge(age);
        goods = ageGoods;
        return goods;
    }

    // handle 5. Modify a goods -> modify ExpireDate
    private static Goods modifyExpireDate(Goods goods, Scanner input) {
        while (true) {
            System.out.println("Please input date in format \"MM/dd/yyyy\"");
            String datestr = input.nextLine();
            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(datestr, new ParsePosition(0));
            if (date == null) {
                continue;
            }
            ProduceGoods tmpgoods = new ProduceGoods("name", 0, 0, date);
            if (!tmpgoods.isExpire()) {
                ProduceGoods produceGoods = (ProduceGoods)goods;
                produceGoods.setExpireDate(date);
                return produceGoods;
            }
        }
    }

    private static int parseIntFromInput(Scanner input) throws Exception {
        int pos = Integer.parseInt(input.nextLine());
        if (pos < 0) {
            throw new Exception("****INPUT ERROR****  Invalid number.");
        }
        return pos;
    }

    private static Date hasExpDate(Scanner input) {
        boolean done;
        System.out.println("Has a expire Date ? input a date in \"MM/dd/yyyy\" format, or \"N\" to cancel.  ");
        done = false;
        do {
            try {
                String datestr = input.nextLine();
                if (datestr.equalsIgnoreCase("N")) {

                } else {
                    Date date = new SimpleDateFormat("MM/dd/yyyy").parse(datestr, new ParsePosition(0));
                    if (date == null) {
                        throw new Exception("Error date format.");
                    }
                    ProduceGoods tmpgoods = new ProduceGoods("name", 0, 0, date);
                    if (tmpgoods.isExpire()) {
                        throw new Exception("The date is expire.");
                    }
                    return date;
                }
                done = true;
            } catch (Exception e) {
                System.out.println("Please input date in format \"MM/dd/yyyy\",  error : " + e.getMessage());
                System.out.println("Or input  \"N\" to cancel expire Date . ");
            }
        } while (!done);
        return null;
    }

    private static int hasAgeRestricted(Scanner input) {
        System.out.println("Has Age Restricted ? input a number age , or \"N\" to cancel.  ");
        while (true) {
            try {
                String in = input.nextLine();
                if (in.equalsIgnoreCase("N")) {
                    return 0;
                }
                int age = Integer.parseInt(in);
                if (age <= 0) {
                    throw new Exception("Age invalid.");
                }
                return age;
            } catch (Exception e) {
                System.out.println("**** Error : " + e.getMessage());
                System.out.println("Input a number age Or input  \"N\" to cancel Age Restricted . ");
            }
        }
    }

    private static double parseDouble(Scanner input) {
        while (true) {
            try {
                double price = Double.parseDouble(input.nextLine());
                if (price <= 0) {
                    throw new Exception();
                }
                return price;
            } catch (Exception e) {
                System.out.println("****INPUT ERROR**** Please input valid price.");
            }
        }
    }

    private static int parseInt(Scanner input) {
        while (true) {
            try {
                int number = parseIntFromInput(input);
                return number;
            } catch (Exception e) {
                System.out.println("****INPUT ERROR**** Please input valid number ." + e.getMessage());
            }
        }
    }
}
