
package library.management.system;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
1

class admin extends human {
    
    String admin_FirstName;
    String admin_LastName;
    String admin_password;
    String admin_id;
    private String anonymous_code="swartz";
    
    void displayMenu()
    {
        if(login_status){
        System.out.println("enter your choice");
        System.out.println("1.Add a book");
        System.out.println("2.Delete a book");
        System.out.println("3.Search user");
        System.out.println("4.Delete user");
        System.out.println("5.Change password");
        System.out.println("6.Give admin excess to other");
        System.out.println("7.check whether book is on hold or not");
        System.out.println("8.Logout");
        }
    }
    
    void delete_user()
    {
        BufferedReader g=null;
        FileWriter f=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter user_id of student");
        String d=sc.nextLine();
        try
        {
            g=new BufferedReader(new FileReader("user_detail"));
            String line=g.readLine();
            while(line!=null)
            {
                if(line.contains(d))
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
                String content=g.readLine();
                while(content!=null)
                {
                    if(content.contains(d))
                    {
                        content=g.readLine();
                        System.out.println("deleted");     
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
    
    void search_user()
    {
        BufferedReader g=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter user's Roll NO");
        String gh=sc.nextLine();
        try
        {
            g=new BufferedReader(new FileReader("user_detail"));
            String line=g.readLine();
            while(line!=null)
            {
                if(line.contains(gh))
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
                String f[]=line.split("[ | ]+");
                System.out.println("Roll No:"+f[0]);
                System.out.println("First Name:"+f[1]);
                System.out.println("Last Name:"+f[2]);
                System.out.println("user id:"+f[4]);
                g.close();
            }
        }
        catch(FileNotFoundException t)
        {
              System.out.println("Exception"+t);
            try
            {
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
                g.close();
            }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
        }
    }
    
    void add_book()
    {
        Scanner sc=new Scanner(System.in);
        int ch;
        do{
        System.out.println("enter your choice");
        System.out.println("1.Magazine\n2.reference book\n3.text book\n4.news paper");
        ch=sc.nextInt();
        switch(ch)
        {
            case 1:System.out.println("enter name:");
                   sc.nextLine();
                   String Mname=sc.nextLine();
                   System.out.println("enter id:");
                   String Mid=sc.nextLine();
                   System.out.println("enter name of publisher:");
                   String Mpublisher=sc.nextLine();
                   System.out.println("enter date od arrival:");
                   String Mdate=sc.nextLine();
                   Magazine MnewBook=new Magazine(Mname,Mid,Mpublisher,Mdate);
                   MnewBook.add_book();
                   break;
            case 2:System.out.println("enter name:");
                   sc.nextLine();
                   String rname=sc.nextLine();
                   System.out.println("enter id:");
                   String rid=sc.nextLine();
                   System.out.println("enter name of author:");
                   String rAuthor=sc.nextLine();
                   System.out.println("enter edition:");
                   int rEdition=sc.nextInt();
                   Reference_Book RnewBook=new Reference_Book(rname,rid,rAuthor,rEdition);
                   RnewBook.add_book();
                   break;
            case 3:System.out.println("enter name:");
                   sc.nextLine();
                   String Tname=sc.nextLine();
                   System.out.println("enter id:");
                   String Tid=sc.nextLine();
                   System.out.println("enter name of author:");
                   String TAuthor=sc.nextLine();
                   System.out.println("enter suject:");
                   String Tsubject=sc.nextLine();
                   System.out.println("enter edition:");
                   int Tedition=sc.nextInt();
                   Text_Book TnewBook=new Text_Book(Tname,Tid,TAuthor,Tsubject,Tedition);
                   TnewBook.add_book();
                   break;
            case 4:System.out.println("enter name of publisher:");
                   sc.nextLine();
                   String Npublisher=sc.nextLine();
                   System.out.println("enter date of arrival:");
                   String Ndate=sc.nextLine();
                   NewsPaper NnewBook=new NewsPaper(Npublisher,Ndate);
                   NnewBook.add_book();
                   break;
            default:System.out.println("enter valid choice");    
        }
        }while(!(ch>=1&&ch<=4));
    }
    
    void delete_book()
    {
        BufferedReader g=null;
        FileWriter f=null;
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
                      f=new FileWriter("Magazine123");
                      g=new BufferedReader(new FileReader("Magazine"));
                      String content=g.readLine();
                      while(content!=null)
                      {
                        if(content.contains(name))
                        {
                            content=g.readLine();
                            System.out.println("deleted");
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
                      f=new FileWriter("TextBook123");
                      g=new BufferedReader(new FileReader("TextBook"));
                      String content=g.readLine();
                      while(content!=null)
                      {
                        if(content.contains(name))
                        {
                            content=g.readLine();
                            System.out.println("deleted");
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
                      f=new FileWriter("ReferenceBook123");
                      g=new BufferedReader(new FileReader("ReferenceBook"));
                      String content=g.readLine();
                      while(content!=null)
                      {
                        if(content.contains(name))
                        {
                            content=g.readLine();
                            System.out.println("deleted");
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
                      f=new FileWriter("NewsPaper123");
                      g=new BufferedReader(new FileReader("NewsPaper"));
                      String content=g.readLine();
                      while(content!=null)
                      {
                        if(content.contains(name))
                        {
                            content=g.readLine();
                            System.out.println("deleted");
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
                       f=new FileWriter("NewsPaper");
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
                           System.out.println("Exception:"+ex);
                       }
                   }
                   break;
            default:System.out.println("enter valid choice");
        }
    }
    
    void change_password()
    {
        BufferedReader g=null;
        FileWriter f=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter id");
        String id=sc.nextLine();
        try
        {
            g=new BufferedReader(new FileReader("admin"));
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
                f=new FileWriter("admin123");
                g=new BufferedReader(new FileReader("admin"));
                String content=g.readLine();
                while(content!=null)
                {
                    if(content.contains(id))
                    {
                         while(true){
                               System.out.println("enter your current password");
                               String current=sc.nextLine();
                               if(content.contains(current)){        
                               System.out.println("enter your password");
                               admin_password= sc.nextLine();
                               System.out.println("confirm your password");
                               String h=sc.nextLine();
                               if(h.equals(admin_password)){
                               System.out.println("password confirmed");
                               String t[]=content.split("[ | ]+");
                               t[4]=admin_password;
                               f.append(t[0]+" | "+t[1]+" | "+t[2]+" | "+t[3]+" | "+t[4]+"\n");
                               
                               break;}
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
                       f=new FileWriter("admin");
                       g=new BufferedReader(new FileReader("admin123"));
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
    
    void give_admin_excess()
    {
        FileWriter f=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter security code");
        String code=sc.nextLine();
        if(anonymous_code.equals(code))
        {
            System.out.println("enter first name:");
            admin_FirstName=sc.nextLine();
            admin_FirstName.trim();
            System.out.println("enter last name:");
            admin_LastName=sc.nextLine();
            admin_LastName.trim();
            System.out.println("enter id:");
            admin_id=sc.nextLine();
            admin_id.trim();
            while(true){
            System.out.println("enter your password");
            admin_password= sc.nextLine();
            admin_password.trim();
            System.out.println("confirm your password");
            String h=sc.nextLine();
            h.trim();
            if(h.equals(admin_password)){
            System.out.println("password confirmed");
            break;}
        else{
            System.out.println("your password is not matched");
            System.out.println("re-enter your password");
        }   
        }
            try{
            f=new FileWriter("admin");
            f.write(admin_FirstName);
            f.append(" | "+admin_LastName);
            f.append(" | "+admin_id);
            f.append(" | "+admin_password+"\n");
            f.close();
            }
            catch(FileNotFoundException t)
            {
                 System.out.println("Exception:"+t);
                try
                {
                    f.close();
                }
                catch(IOException ex)
                {
                    System.out.println("Exception:"+ex);
                }
            }
            catch(IOException e)
            {
                System.out.println("Exception:"+e);
                try
                {
                    f.close();
                }
                catch(IOException ex)
                {
                    System.out.println("Exception:"+ex);
                }
            }
        }
        else
            System.out.println("wrong security code");
    }
    
    void book_hold_status()
    {
        BufferedReader g=null;
        FileWriter f=null;
        int t=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your choice");
        System.out.println("1.Magazine\n2.TextBook\n3.ReferenceBook\n4.NewsPaper");
        int ch=sc.nextInt();
        sc.nextLine();
        System.out.println("enter book name");
        String name=sc.nextLine();
        System.out.println("enter roll_no");
        String roll=sc.nextLine();
        switch(ch){
            case 1:try
                   {
                       g=new BufferedReader(new FileReader("Magazine"));
                       String content=g.readLine();
                       while(content!=null)
                       {
                          if(content.contains(name))
                          {
                              if(content.contains(roll))
                              {
                                 System.out.println("book is holded by "+roll);
                                 System.out.println("do you want to remove hold");
                                 System.out.println("1.yes\t2.No");
                                 t=sc.nextInt();
                           }
                           else
                           {
                             System.out.println("book is not holded by "+roll);
                            }
                          break;
                       }
                       }
                      if(content==null)
                       {
                        System.out.println("book not found");
                        g.close();
                       }
                       else
                       {
                        g.close();
                        }
                      if(t==1)
                      {
                          try
                          {
                              f= new FileWriter("Magazine123");
                              g= new BufferedReader(new FileReader("Magazine"));
                              String line=g.readLine();
                              while(line!=null)
                              {
                                  if(line.contains(name))
                                  {
                                      String o[]=line.split("[ | ]+");
                                      f.append(o[0]+" | "+o[1]+" | "+o[2]+" | "+o[3]+" | "+o[4]+"\n");
                                      line=g.readLine();
                                  }
                                  else
                                  {
                                      f.append(line);
                                      line=g.readLine();
                                  }
                              }
                              f.close();
                              g.close();
                          } 
                          catch(FileNotFoundException o)
                       {
                        System.out.println("Exception :"+o);
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
                          
                          catch(IOException ex)
                          {
                              System.out.println("Exception:"+ex);
                              try
                              {
                                  f.close();
                                  g.close();
                              }
                              catch(IOException r)
                              {
                                  System.out.println("Exception:"+r);
                              }
                          }
                      }
                   }
                       catch(FileNotFoundException o)
                       {
                        System.out.println("Exception :"+o);
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
                       System.out.println("Exception:"+e);
                       try {
                               g.close();
                       } catch (IOException ex) {
                               System.out.println("Exception:"+ex);
                      }
                   }
                   try
                   {
                       g=new BufferedReader(new FileReader("Magazine123"));
                       f=new FileWriter("Magazine");
                       String k=g.readLine();
                       while(k!=null)
                       {
                           f.append(k);
                           k=g.readLine();
                       }
                       f.close();
                       g.close();
                   }
                    catch(FileNotFoundException o)
                   {
                        System.out.println("Exception :"+o);
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
                  catch(IOException l)
                  {
                      System.out.println("Exception:"+l);
                      try
                      {
                          f.close();
                          g.close();
                      }
                      catch(IOException s)
                      {
                          System.out.println("Exception:"+s);
                      }
                  }
                  break;
            case 2:try
                   {
                       g=new BufferedReader(new FileReader("TextBook"));
                       String content=g.readLine();
                       while(content!=null)
                       {
                          if(content.contains(name))
                          {
                              if(content.contains(roll))
                              {
                                 System.out.println("book is holded by "+roll);
                                 System.out.println("do you want to remove hold");
                                 System.out.println("1.yes\t2.No");
                                 t=sc.nextInt();
                           }
                           else
                           {
                             System.out.println("book is not holded by "+roll);
                            }
                          break;
                       }
                       }
                      if(content==null)
                       {
                        System.out.println("book not found");
                        g.close();
                       }
                       else
                       {
                        g.close();
                        }
                      if(t==1)
                      {
                          try
                          {
                              f= new FileWriter("TextBook123");
                              g= new BufferedReader(new FileReader("TextBook"));
                              String line=g.readLine();
                              while(line!=null)
                              {
                                  if(line.contains(name))
                                  {
                                      String o[]=line.split("[ | ]+");
                                      f.append(o[0]+" | "+o[1]+" | "+o[2]+" | "+o[3]+" | "+o[4]+" | "+o[5]+"\n");
                                      line=g.readLine();
                                  }
                                  else
                                  {
                                      f.append(line);
                                      line=g.readLine();
                                  }
                              }
                              f.close();
                              g.close();
                          }
                              catch(FileNotFoundException o)
                       {
                        System.out.println("Exception :"+o);
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
                          catch(IOException ex)
                          {
                              System.out.println("Exception:"+ex);
                              try
                              {
                                  f.close();
                                  g.close();
                              }
                              catch(IOException r)
                              {
                                  System.out.println("Exception:"+r);
                              }
                          }
                      }
                   }
                       catch(FileNotFoundException o)
                       {
                        System.out.println("Exception :"+o);
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
                       System.out.println("Exception:"+e);
                    try {
                         g.close();
                     } catch (IOException ex) {
                          System.out.println("Exception:"+ex);
                      }
                   }
                   try
                   {
                       g=new BufferedReader(new FileReader("TextBook123"));
                       f=new FileWriter("TextBook");
                       String k=g.readLine();
                       while(k!=null)
                       {
                           f.append(k);
                           k=g.readLine();
                       }
                       f.close();
                       g.close();
                   }
                    catch(FileNotFoundException o)
                   {
                        System.out.println("Exception :"+o);
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
                  catch(IOException l)
                  {
                      System.out.println("Exception:"+l);
                      try
                      {
                          f.close();
                          g.close();
                      }
                      catch(IOException s)
                      {
                          System.out.println("Exception:"+s);
                      }
                  }
                   break;
            case 3:try
                   {
                       g=new BufferedReader(new FileReader("ReferenceBook"));
                       String content=g.readLine();
                       while(content!=null)
                       {
                          if(content.contains(name))
                          {
                              if(content.contains(roll))
                              {
                                 System.out.println("book is holded by "+roll);
                                 System.out.println("do you want to remove hold");
                                 System.out.println("1.yes\t2.No");
                                 t=sc.nextInt();
                           }
                           else
                           {
                             System.out.println("book is not holded by "+roll);
                            }
                          break;
                       }
                       }
                      if(content==null)
                       {
                        System.out.println("book not found");
                        g.close();
                       }
                       else
                       {
                        g.close();
                        }
                      if(t==1)
                      {
                          try
                          {
                              f= new FileWriter("ReferenceBook123");
                              g= new BufferedReader(new FileReader("ReferenceBook"));
                              String line=g.readLine();
                              while(line!=null)
                              {
                                  if(line.contains(name))
                                  {
                                      String o[]=line.split("[ | ]+");
                                      f.append(o[0]+" | "+o[1]+" | "+o[2]+" | "+o[3]+" | "+o[4]+"\n");
                                      line=g.readLine();
                                  }
                                  else
                                  {
                                      f.append(line);
                                      line=g.readLine();
                                  }
                              }
                              f.close();
                              g.close();
                          }
                              catch(FileNotFoundException o)
                       {
                        System.out.println("Exception :"+o);
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
                          catch(IOException ex)
                          {
                              System.out.println("Exception:"+ex);
                              try
                              {
                                  f.close();
                                  g.close();
                              }
                              catch(IOException r)
                              {
                                  System.out.println("Exception:"+r);
                              }
                          }
                      }
                   }
                       catch(FileNotFoundException o)
                       {
                        System.out.println("Exception :"+o);
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
                       System.out.println("Exception:"+e);
                       try {
                               g.close();
                        } catch (IOException ex) {
                               System.out.println("Exception:"+ex);
                        }
                   }
                   try
                   {
                       g=new BufferedReader(new FileReader("ReferenceBook123"));
                       f=new FileWriter("ReferenceBook");
                       String k=g.readLine();
                       while(k!=null)
                       {
                           f.append(k);
                           k=g.readLine();
                       }
                       f.close();
                       g.close();
                   }
                    catch(FileNotFoundException o)
                   {
                        System.out.println("Exception :"+o);
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
                  catch(IOException l)
                  {
                      System.out.println("Exception:"+l);
                      try
                      {
                          f.close();
                          g.close();
                      }
                      catch(IOException s)
                      {
                          System.out.println("Exception:"+s);
                      }
                  }
                   break;
            case 4:try
                   {
                       g=new BufferedReader(new FileReader("NewsPaper"));
                       String content=g.readLine();
                       while(content!=null)
                       {
                          if(content.contains(name))
                          {
                              if(content.contains(roll))
                              {
                                 System.out.println("book is holded by "+roll);
                                 System.out.println("do you want to remove hold");
                                 System.out.println("1.yes\t2.No");
                                 t=sc.nextInt();
                           }
                           else
                           {
                             System.out.println("book is not holded by "+roll);
                            }
                          break;
                       }
                       }
                      if(content==null)
                       {
                        System.out.println("book not found");
                        g.close();
                       }
                       else
                       {
                        g.close();
                        }
                      if(t==1)
                      {
                          try
                          {
                              f= new FileWriter("NewsPaper123");
                              g= new BufferedReader(new FileReader("NewsPaper"));
                              String line=g.readLine();
                              while(line!=null)
                              {
                                  if(line.contains(name))
                                  {
                                      String o[]=line.split("[ | ]+");
                                      f.append(o[0]+" | "+o[1]+"\n");
                                      line=g.readLine();
                                  }
                                  else
                                  {
                                      f.append(line);
                                      line=g.readLine();
                                  }
                              }
                              f.close();
                              g.close();
                          }
                              catch(FileNotFoundException o)
                       {
                        System.out.println("Exception :"+o);
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
                          catch(IOException ex)
                          {
                              System.out.println("Exception:"+ex);
                              try
                              {
                                  f.close();
                                  g.close();
                              }
                              catch(IOException r)
                              {
                                  System.out.println("Exception:"+r);
                              }
                          }
                      }
                   }
                       catch(FileNotFoundException o)
                       {
                        System.out.println("Exception :"+o);
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
                       System.out.println("Exception:"+e);
                    try {
                            g.close();
                    } catch (IOException ex) {
                            System.out.println("Exception:"+ex);
                    }
                   }
                   try
                   {
                       g=new BufferedReader(new FileReader("NewsPaper123"));
                       f=new FileWriter("NewsPaper");
                       String k=g.readLine();
                       while(k!=null)
                       {
                           f.append(k);
                           k=g.readLine();
                       }
                       f.close();
                       g.close();
                   }
                    catch(FileNotFoundException o)
                   {
                        System.out.println("Exception :"+o);
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
                  catch(IOException l)
                  {
                      System.out.println("Exception:"+l);
                      try
                      {
                          f.close();
                          g.close();
                      }
                      catch(IOException s)
                      {
                          System.out.println("Exception:"+s);
                      }
                  }
                   break;
            default:System.out.println("enter valid choice");    
    }
}
}

