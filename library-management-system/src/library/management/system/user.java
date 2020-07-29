
package library.management.system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


class user extends human {
    
    String user_FirstName;
    String user_LastName;
    String user_Password;
    String user_id;
    String roll_no;
    
    void displayMenu()
    {
        if(login_status){
        System.out.println("enter your choice");
        System.out.println("1.Search a book");
        System.out.println("2.Update your details");
        System.out.println("3.Change password");
        System.out.println("4.Logout");
        }
    }
    
    void signUp() 
    {
        FileWriter userDetail = null;
        while(true){
        try{
        userDetail=new FileWriter("user_detail",true); 
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your Roll.No");
        roll_no=sc.nextLine();
        userDetail.write(roll_no);
        System.out.println("enter your FirstName");
        user_FirstName=sc.nextLine();
        userDetail.append(" | "+user_FirstName);
        System.out.println("enter your LastName");
        user_LastName=sc.nextLine();
        userDetail.append(" | "+user_LastName);
        System.out.println("enter your user id");
        user_id=sc.nextLine();
        userDetail.append(" | "+user_id);
        while(true){
        System.out.println("enter your password");
        user_Password = sc.nextLine();
        System.out.println("confirm your password");
        String h=sc.nextLine();
        if(h.equals(user_Password)){
            System.out.println("password confirmed");
            userDetail.append(" | "+user_Password+"\n");
            break;}
        else{
            System.out.println("your password is not matched");
            System.out.println("re-enter your password");
        }
        }
        userDetail.close();
        break;
        }
        catch(FileNotFoundException t)
        {
             System.out.println(t);
            try
            {
                userDetail.close();
            }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
            System.out.println("enter your details again");
        }
        catch(IOException r)
        {
            System.out.println(r);
            try
            {
                userDetail.close();
            }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
            System.out.println("enter your details again");
        }
        }
    }
    
    void search_book()
    {
        FileWriter f=null;
        BufferedReader g=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your choice");
        System.out.println("1.Magazine\n2.Textbook\n3.Reference book\n4.newsPaper");
        int h=sc.nextInt();
        sc.nextLine();
        System.out.println("enter name:");
        String name=sc.nextLine();
        switch(h)
        {
            case 1: try
                    {
                     g=new BufferedReader(new FileReader("Magazine"));
                     String line=g.readLine();
                     while(line!=null)
                     {
                     if(line.contains(name))
                         break;
                     else
                         line=g.readLine();
                     }
                     if(line==null){
                     System.out.println("magazine not found");
                     g.close();
                     }
                     else
                     {
                      g.close();
                      g=new BufferedReader(new FileReader("Magazine"));
                      f=new FileWriter("Magazine123");
                      String content=g.readLine();
                      while(content!=null)
                      {
                        if(content.contains(name))
                        {
                            String j[]=content.split("[ | ]+");
                            System.out.println("Name:"+j[0]);
                            System.out.println("ID:"+j[1]);
                            System.out.println("type:"+j[2]);
                            System.out.println("publisher:"+j[3]);
                            System.out.println("date of arrival:"+j[4]);
                            int ch;
                            do{
                            System.out.println("you want to hold the book");
                            System.out.println("1.yes\n2.no");
                            ch=sc.nextInt();
                            switch(ch)
                            {
                                case 1:if(content.contains("on hold"))
                                {
                                    System.out.println("book is already on hold");
                                }
                                else{
                                    j[4]=j[4].substring(0,j[4].length());
                                    f.append(j[0]+" | "+j[1]+" | "+j[2]+" | "+j[3]+" | "+j[4]+" | "+"on hold"+" | "+roll_no+"\n");
                                    System.out.println("book is holded");
                                }
                                break;
                                case 2:f.append(j[0]+" | "+j[1]+" | "+j[2]+" | "+j[3]+" | "+j[4]);
                                break;
                                default:System.out.println("enter valid choice");    
                            }
                            }while(ch!=1&&ch!=2);
                            content=g.readLine();
                        }
                        else
                        {
                        f.append(content);
                        content=g.readLine();
                        }
                      }
                      f.close();
                      g.close();
                    }
                  }
                    catch(FileNotFoundException t)
                   {
                        System.out.println("Exception :"+t);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
                   catch(IOException r)
                        {
                           System.out.println("Exception"+r);
                           try {
                                g.close();
                                f.close();
                            } catch (IOException ex) {
                                System.out.println("Exception:"+ex);
                            }
                        }
                   try
                   {
                       f=new FileWriter("Magazine");
                       g=new BufferedReader(new FileReader("Magazine123"));
                       String line=g.readLine();
                       while(line!=null)
                       {
                           f.append(line);
                           line=g.readLine();
                       }
                       f.close();
                       g.close();
                   }
                   catch(FileNotFoundException t)
                   {
                        System.out.println("Exception :"+t);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
                   catch(IOException e)
                   {
                       System.out.println("Exception :"+e);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
                   break;
            case 2:try
                    {
                     g=new BufferedReader(new FileReader("TextBook"));
                     String line=g.readLine();
                     while(line!=null)
                     {
                     if(line.contains(name))
                         break;
                     else
                         line=g.readLine();
                     }
                     if(line==null){
                     System.out.println("text book not found");
                     g.close();
                     }
                     else
                     {
                      g.close();
                      g=new BufferedReader(new FileReader("TextBook"));
                      f=new FileWriter("TextBook123");
                      String content=g.readLine();
                      while(content!=null)
                      {
                        if(content.contains(name))
                        {
                            String j[]=content.split("[ | ]+");
                            System.out.println("Name:"+j[0]);
                            System.out.println("ID:"+j[1]);
                            System.out.println("type:"+j[2]);
                            System.out.println("author"+j[3]);
                            System.out.println("edition:"+j[4]);
                            System.out.println("subject:"+j[5]);
                             int ch;
                            do{
                            System.out.println("you want to hold the book");
                            System.out.println("1.yes\n2.no");
                            ch=sc.nextInt();
                            switch(ch)
                            {
                                case 1:if(content.contains("on hold"))
                                {
                                    System.out.println("book is already on hold");
                                }
                                else{
                                    j[5]=j[5].substring(0,j[5].length());
                                    f.append(j[0]+" | "+j[1]+" | "+j[2]+" | "+j[3]+" | "+j[4]+" | "+j[5]+" | "+"on hold"+" | "+roll_no+"\n");
                                    System.out.println("book is holded");
                                }
                                break;
                                case 2:f.append(j[0]+" | "+j[1]+" | "+j[2]+" | "+j[3]+" | "+j[4]+" | "+j[5]);
                                break;
                               }
                            }while(ch!=1&&ch!=2);
                            content=g.readLine();
                        }
                        else
                        {
                        f.append(content);
                        content=g.readLine();
                        }
                      }
                      f.close();
                      g.close();
                    }
                  }
                    catch(FileNotFoundException t)
                   {
                        System.out.println("Exception :"+t);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
                   catch(IOException r)
                        {
                           System.out.println("Exception"+r);
                           try {
                               f.close();
                               g.close();
                           } catch (IOException ex) {
                               System.out.println("Exception:"+ex);
                           }
                        }
                   try
                   {
                       f=new FileWriter("TextBook");
                       g=new BufferedReader(new FileReader("TextBook123"));
                       String line=g.readLine();
                       while(line!=null)
                       {
                           f.append(line);
                           line=g.readLine();
                       }
                       f.close();
                       g.close();
                   }
                    catch(FileNotFoundException t)
                   {
                        System.out.println("Exception :"+t);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
                   catch(IOException e)
                   {
                       System.out.println("Exception :"+e);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
                   break;
            case 3:try
                    {
                     g=new BufferedReader(new FileReader("ReferenceBook"));
                     String line=g.readLine();
                     while(line!=null)
                     {
                     if(line.contains(name))
                         break;
                     else
                         line=g.readLine();
                     }
                     if(line==null){
                     System.out.println("reference not found");
                     g.close();
                     }
                     else
                     {
                      g.close();
                      g=new BufferedReader(new FileReader("ReferenceBook"));
                      f=new FileWriter("ReferenceBook123");
                      String content=g.readLine();
                      while(content!=null)
                      {
                        if(content.contains(name))
                        {
                            String j[]=content.split("[ | ]+");
                            System.out.println("Name:"+j[0]);
                            System.out.println("ID:"+j[1]);
                            System.out.println("type:"+j[2]);
                            System.out.println("author"+j[3]);
                            System.out.println("edition:"+j[4]);
                            int ch;
                            do{
                            System.out.println("you want to hold the book");
                            System.out.println("1.yes\n2.no");
                            ch=sc.nextInt();
                            switch(ch)
                            {
                                case 1:if(content.contains("on hold"))
                                {
                                    System.out.println("book is already on hold");
                                }
                                else{
                                    j[4]=j[4].substring(0,j[4].length());
                                    f.append(j[0]+" | "+j[1]+" | "+j[2]+" | "+j[3]+" | "+j[4]+" | "+"on hold"+" | "+roll_no+"\n");
                                    System.out.println("book is holded");
                                }
                                break;
                                case 2:f.append(j[0]+" | "+j[1]+" | "+j[2]+" | "+j[3]+" | "+j[4]);
                                break;
                            }
                            }while(ch!=1&&ch!=2);
                            content=g.readLine();
                        }
                        else
                        {
                        f.append(content);    
                        content=g.readLine();
                        }
                      }
                      f.close();
                      g.close();
                    }
                  }
                    catch(FileNotFoundException t)
                   {
                        System.out.println("Exception :"+t);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
                   catch(IOException r)
                        {
                           System.out.println("Exception"+r);
                           try {
                                f.close();
                                g.close();
                          } catch (IOException ex) {
                                System.out.println("Exception:"+ex);
                          }
                        }
                      try
                   {
                       f=new FileWriter("ReferenceBook");
                       g=new BufferedReader(new FileReader("ReferenceBook123"));
                       String line=g.readLine();
                       while(line!=null)
                       {
                           f.append(line);
                           line=g.readLine();
                       }
                       f.close();
                       g.close();
                   }
                       catch(FileNotFoundException t)
                   {
                        System.out.println("Exception :"+t);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
                   catch(IOException e)
                   {
                       System.out.println("Exception :"+e);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
                   break;
            case 4:try
                    {
                     g=new BufferedReader(new FileReader("NewsPaper"));
                     String line=g.readLine();
                     while(line!=null)
                     {
                     if(line.contains(name))
                         break;
                     else
                         line=g.readLine();
                     }
                     if(line==null){
                     System.out.println("news paper not found");
                     g.close();
                     }
                     else
                     {
                      g.close();
                      g=new BufferedReader(new FileReader("NewsPaper"));
                      f=new FileWriter("NewsPaper123");
                      String content=g.readLine();
                      while(content!=null)
                      {
                        if(content.contains(name))
                        {
                            String j[]=content.split("[ | ]+");
                            System.out.println("publisher:"+j[0]);
                            System.out.println("date of arrival:"+j[1]);
                             int ch;
                            do{
                            System.out.println("you want to hold the news papper");
                            System.out.println("1.yes\n2.no");
                            ch=sc.nextInt();
                            switch(ch)
                            {
                                case 1:if(content.contains("on hold"))
                                {
                                    System.out.println("it is already on hold");
                                }
                                else{
                                    j[1]=j[1].substring(0,j[1].length());
                                    f.append(j[0]+" | "+j[1]+" | "+"on hold"+" | "+roll_no+"\n");
                                    System.out.println("it is holded");
                                }
                                break;
                                case 2:f.append(j[0]+" | "+j[1]);
                                break;
                            }
                            }while(ch!=1&&ch!=2);
                            content=g.readLine();
                        }
                        else
                        {
                         f.append(content);   
                        content=g.readLine();
                        }
                      }
                      f.close();
                      g.close();
                    }
                  }
                    catch(FileNotFoundException t)
                   {
                        System.out.println("Exception :"+t);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
                   catch(IOException r)
                        {
                           System.out.println("Exception"+r);
                         try {
                              f.close();
                              g.close();
                         } catch (IOException ex) {
                               System.out.println("Exception:"+ex);
                         }
                        }
                      try
                   {
                       f=new FileWriter("NewsPaprer");
                       g=new BufferedReader(new FileReader("NewsPaper123"));
                       String line=g.readLine();
                       while(line!=null)
                       {
                           f.append(line);
                           line=g.readLine();
                       }
                       f.close();
                       g.close();
                   }
                    catch(FileNotFoundException t)
                   {
                        System.out.println("Exception :"+t);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }   
                   catch(IOException e)
                   {
                       System.out.println("Exception :"+e);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception :"+ex);
                       }
                   }
                   break;
            default:System.out.println("enter valid choice");
        }
    }
    
    void update_user_details()
    {
        BufferedReader g=null;
        FileWriter f=null;
        String content="";
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your user id");
        String h=sc.nextLine();
        try
        {
            g=new BufferedReader(new FileReader("user_detail"));
            String line=g.readLine();
            while(line!=null)
            {
                if(line.contains(h))
                    break;
                else
                    line=g.readLine();
            }
            if(line==null){
                System.out.println("user doesn't exsists in database");
                g.close();
            }
            else
            {
                g.close();
                f=new FileWriter("user_detail123");
                g=new BufferedReader(new FileReader("user_detail"));
                content=g.readLine();
                while(content!=null)
                {
                    if(content.contains(h))
                    {
                        System.out.println("enter your password");
                        String current=sc.nextLine();
                        if(content.contains(current)){
                        System.out.println("enter your roll no");
                        roll_no=sc.nextLine();
                        System.out.println("enter your first name");
                        user_FirstName=sc.nextLine();
                        System.out.println("enter your last name");
                        user_LastName=sc.nextLine();
                        System.out.println("enter your user id");
                        user_id=sc.nextLine();
                        f.append(roll_no+" | "+user_FirstName+" | "+user_LastName+" | "+user_id+" | "+user_Password+"\n");
                        content=g.readLine();
                        }
                        else{
                            System.out.println("wrong password");
                            f.append(content);
                            content=g.readLine();
                            }
                    }
                    else
                    {
                        f.append(content);
                        content=g.readLine();
                    }
                }
                f.close();
                g.close();
            }
        }
        catch(FileNotFoundException t)
        {
              System.out.println("Exception"+t);
            try {
                f.close();
                g.close();
            } catch (IOException ex) {
                System.out.println("Exception:"+ex);
            }
        }
        catch(IOException r)
        {
            System.out.println("Exception"+r);
            try {
                f.close();
                g.close();
            } catch (IOException ex) {
                System.out.println("Exception:"+ex);
            }
            }
                try
                   {
                       f=new FileWriter("user_detail");
                       g=new BufferedReader(new FileReader("user_detail123"));
                       String line=g.readLine();
                       while(line!=null)
                       {
                           f.append(line);
                           line=g.readLine();
                       }
                       f.close();
                       g.close();
                   }
                catch(FileNotFoundException t)
                {
                      System.out.println("Exception :"+t);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                }
                   catch(IOException e)
                   {
                       System.out.println("Exception :"+e);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
           }
    
    
    void change_password()
    {
        BufferedReader g=null;
        FileWriter f=null;
        String content="";
        Scanner sc=new Scanner(System.in);
        System.out.println("enter id");
        String id=sc.nextLine();
        try
        {
            g=new BufferedReader(new FileReader("user_detail"));
            String line=g.readLine();
            while(line!=null)
            {
                if(line.contains(id))
                    break;
                else
                    line=g.readLine();
            }
            if(line==null){
                System.out.println("id not found");
                g.close();
            }
            else
            {
                g.close();
                f=new FileWriter("user_detail123");
                g=new BufferedReader(new FileReader("user_detail"));
                content=g.readLine();
                while(content!=null)
                {
                    if(content.contains(id))
                    {
                         while(true){
                               System.out.println("enter your current password");
                               String current=sc.nextLine();
                               if(content.contains(current)){        
                               System.out.println("enter your password");
                               user_Password = sc.nextLine();
                               System.out.println("confirm your password");
                               String h=sc.nextLine();
                               if(h.equals(user_Password)){
                               System.out.println("password confirmed");
                               String t[]=content.split("[ | ]+");
                               t[4]=user_Password;
                               f.append(t[0]+" | "+t[1]+" | "+t[2]+" | "+t[3]+" | "+t[4]+"\n");
                               break;
                               }
                               else{
                               System.out.println("your password is not matched");
                               System.out.println("re-enter your password");
                               }
                               }
                               else
                               {
                                   System.out.println("wrong password");
                                   f.append(content);
                                   break;
                               }
                    }
                         content=g.readLine();
                    }
                    else
                    {
                        f.append(content);
                        content=g.readLine();
                    }
                }
                f.close();
                g.close();
            }
        }
        catch(FileNotFoundException t)
        {
             System.out.println("Exception"+t);
            try
            {
                f.close();
                g.close();
            }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
        }
        catch(IOException r)
        {
            System.out.println("Exception"+r);
            try
            {
                f.close();
                g.close();
            }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
           }
                try
                   {
                       f=new FileWriter("user_detail");
                       g=new BufferedReader(new FileReader("user_detail123"));
                       String line=g.readLine();
                       while(line!=null)
                       {
                           f.append(line);
                           line=g.readLine();
                       }
                       f.close();
                       g.close();
                   }
                catch(FileNotFoundException t)
                {
                     System.out.println("Exception :"+t);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                }
                   catch(IOException e)
                   {
                       System.out.println("Exception :"+e);
                       try
                       {
                           f.close();
                           g.close();
                       }
                       catch(IOException ex)
                       {
                           System.out.println("Exception:"+ex);
                       }
                   }
}
}