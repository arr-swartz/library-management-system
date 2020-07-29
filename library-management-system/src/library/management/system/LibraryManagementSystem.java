package library.management.system;

import java.io.FileWriter;
import java.lang.Exception;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=0;
        boolean status;
        do{
        System.out.println(" -------------------------------------------------------------------------------------------------------------");
        System.out.println("|                                             WELCOME                                                          |");
        System.out.println(" -------------------------------------------------------------------------------------------------------------");
        System.out.println("| -> enter 1 if you are admin                                                                                  |");
        System.out.println("| -> enter 2 if you are user                                                                                   |");
        System.out.println("| -> enter 3 for exit                                                                                          |");
        n=sc.nextInt();
        int ch;
        if(n==1||n==2||n==3)
        {
        if(n==1)
        {
           admin hod = new admin();
           status=hod.admin_login();
           if(status==true){
           do{
           hod.displayMenu();
           ch=sc.nextInt();
           switch(ch)
           {
               case 1:hod.add_book();
                      break;
               case 2:hod.delete_book();
                      break;
               case 3:hod.search_user();
                      break;
               case 4:hod.delete_user();
                      break;
               case 5:hod.change_password();
                      break;
               case 6:hod.give_admin_excess();
                      break;
               case 7:hod.book_hold_status();
                      break;
               case 8:hod.logOut();
                      break;
               default:System.out.println("enter valid choice");    
           }
           }while(ch!=8);
           }
        }
        else if(n==2)
        {
            user sdt = new user();
            do{
            System.out.println("enter your choice:");
            System.out.println("1.SIGNUP\t\t2.LOGIN");
            int t=sc.nextInt();
            if(t==1){
                sdt.signUp();
                System.out.println("login");
                status=sdt.user_login();
                        
                break;}
            else if(t==2){
                status=sdt.user_login();
                break;}
            else
                System.out.println("enter valid choice");
            }while(true);
            int d;
            if(status==true){
            do
            {
                sdt.displayMenu();
                d=sc.nextInt();
                switch(d)
                {
                    case 1:sdt.search_book();
                           break;
                    case 2:sdt.update_user_details();
                           break;
                    case 3:sdt.change_password();
                           break;
                    case 4:sdt.logOut();
                           break;
                    default:System.out.println("enter valid choice");    
                }
            }while(d!=4);
            }
        }
        else
        {
           sc.close(); 
           System.exit(0);
        }
        }
        else
        {
            System.out.println("enter valid choice");
        }
    }while(n!=3);
}
}    
