
package library.management.system;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

abstract class human {
     
     boolean login_status=false;
     
    boolean user_login() 
    {
        
        if(login_status)
        {
            System.out.println("YOU ARE ALREADY LOGGED IN");
        }
        else{
            BufferedReader f=null;
            Scanner sc=new Scanner(System.in);
            System.out.println("enter your userid");
            String username=sc.nextLine();
            System.out.println("enter your password");
            String password=sc.nextLine();
            try{
            f=new BufferedReader(new FileReader("user_detail"));
            String content=f.readLine();
            while(content!=null)
            {
                if(content.contains(username))
                {
                    if(content.contains(password)){
                        System.out.println("you are logged in");
                        login_status=true;
                        f.close();
                        break;
                    }
                    else
                    {
                        System.out.println("wrong pasword");
                        f.close();
                        break;
                    }
                } 
                content=f.readLine();
            }
            if(!login_status)
            {
                System.out.println("username not found");
                f.close();
                return false;
            }
            else
                return true;
            }
            catch(FileNotFoundException r)
            {
                System.out.println("Exception :"+r);
                try {
                    f.close();
                } catch (IOException ex) {
                    System.out.println("Exception:"+ex);
                }
            }
            catch(IOException e)
            {
                System.out.println("Exception :"+e);
                try {
                    f.close();
                } catch (IOException ex) {
                    System.out.println("Exception:"+ex);
                }
            }
        }
         return false;
    }
    
    boolean admin_login()
    {
        if(login_status)
        {
            System.out.println("you are already logged in");
        }
        else
        {
            BufferedReader f=null;
            Scanner sc=new Scanner(System.in);
            System.out.println("enter your adminid");
            String username=sc.nextLine();
            System.out.println("enter your password");
            String password=sc.nextLine();
            try{
            f=new BufferedReader(new FileReader("admin"));
            String content=f.readLine();
            while(content!=null)
            {
                if(content.contains(username))
                {
                    if(content.contains(password)){
                        System.out.println("you are logged in");
                        login_status=true;
                        f.close();
                        break;
                    }
                    else
                    {
                        System.out.println("wrong pasword");
                        f.close();
                        break;
                    }
                } 
                content=f.readLine();
            }
            if(login_status==false)
            {
                System.out.println("id not found");
                f.close();
                return false;
            }
            else
            {
                return true;
            }
            }
            catch(FileNotFoundException r)
            {
                 System.out.println("Exception :"+r);
                try {
                    f.close();
                } catch (IOException ex) {
                    System.out.println("Exception:"+ex);
                }   
            }
            catch(IOException e)
            {
                System.out.println("Exception :"+e);
                try {
                    f.close();
                } catch (IOException ex) {
                    System.out.println("Exception:"+ex);
                }
            }
        }
         return false;
    }
    
     void logOut()
    {
        
        if(login_status)
        login_status=false;
        else
        System.out.println("YOU ARE NOT LOGGED IN");
    }
     
     abstract void displayMenu();
     abstract void change_password();        
}
