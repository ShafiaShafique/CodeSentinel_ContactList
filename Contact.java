import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
       static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> contact = new ArrayList<>();
        name.add("Abdul Ahad");
        name.add("Abdullah");
        name.add("Abdul Wassay");
        name.add("Abdul Raffay");

        contact.add("03001234567");
        contact.add("03112345678");
        contact.add("03211234567");
        contact.add("03341234567");
        menu(name,contact);
    }

    public static void menu(ArrayList<String> name, ArrayList<String> contact){
        System.out.println("\n--- Welcome to Menu ---\n");
        System.out.println("1. Add Contact Number");
        System.out.println("2. Search Contact Number");
        System.out.println("3. View Contact Number");
        System.out.println("0. Exit Contact List");
        System.out.println("Choose Number: ");
        int choose = sc.nextInt();
        if(choose == 1){
            add_Contact(name,contact);
        } else if (choose == 2) {
            search_Contact(name,contact);
        } else if (choose == 3) {
            view_Contact(name, contact);
        }
        else if(choose == 0){
            System.out.println("Have a Nice Day!");
            System.exit(0);
        }
        else{
            System.out.println("ERROR: Enter Valid Number");
        }
    }
    public static void add_Contact(ArrayList<String> name, ArrayList<String> contact ){
        sc.nextLine();
        System.out.println("Enter Contact name: ");
        String new_name = sc.nextLine();
            System.out.println("Enter Contact Number: ");
            String new_number = sc.nextLine();
            if(new_number.matches("\\d+") || new_number.startsWith("+92")) {
                if (new_number.startsWith("03") && new_number.length() == 11) {
                    name.add(new_name);
                    contact.add(new_number);
                    System.out.println("Contact Saved Successfully!");
                } else if (new_number.startsWith("+92") && new_number.length() == 13) {
                    name.add(new_name);
                    contact.add(new_number);
                    System.out.println("Contact Saved Successfully!");
                } else {
                    System.out.println("Invalid Contact Number");
                }
            }
            else{
                System.out.println("ERROR: Only Digits are Allowed");
            }
        menu(name,contact);
    }
    public static void search_Contact(ArrayList<String> name, ArrayList<String> contact){
        sc.nextLine();
        System.out.println("Enter Name to Search: ");
        String search_name = sc.nextLine();
        boolean check = false;
        for(int i = 0; i < name.size(); i++){
            if(search_name.equalsIgnoreCase(name.get(i))){
                System.out.println("Name: " + name.get(i));
                System.out.println("Contact Number: "+ contact.get(i));
                check = true;
                break;
            }
            else{
                check = false;
            }
        }
        if(!check){
            System.out.println("Contact not Found");
        }
        menu(name,contact);
    }
    public static void view_Contact(ArrayList<String> name, ArrayList<String> contact){
        System.out.println("---Saved Contact list---\n");
        for(int i = 0; i < name.size() || i < contact.size(); i++){
            System.out.println("Name: " + name.get(i));
            System.out.println("Contact Number: " + contact.get(i));
        }
        menu(name,contact);
    }
}

