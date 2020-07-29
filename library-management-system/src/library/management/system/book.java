
package library.management.system;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class book {
    
    String book_Name;
    String book_id;
    String book_type;
    
    book(String name,String id,String type)
    {
        book_Name=name;
        book_id=id;
        book_type=type;
    }
}

class Magazine extends book
{
    String Publisher;
    String DateOfArrival;
    Magazine(String name,String id,String Publisher,String DateOfArrival)
    {
        super(name,id,"Magazine");
        this.Publisher=Publisher;
        this.DateOfArrival=DateOfArrival;
    }
    void add_book()
    {
        FileWriter mbookDetail=null;
        while(true){
        try
        {
            mbookDetail=new FileWriter("Magazine",true);
            mbookDetail.write(book_Name);
            mbookDetail.append(" | "+book_id);
            mbookDetail.append(" | "+book_type);
            mbookDetail.append(" | "+Publisher);
            mbookDetail.append(" | "+DateOfArrival+"\n");
            mbookDetail.close();
            break;
        }
        catch(FileNotFoundException r){
            System.out.println("exception"+r);
            try
            {
                mbookDetail.close();
            }
            catch(FileNotFoundException t)
             {
                 System.out.println("Exception:"+t);
             }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
            System.out.println("enter book details again"); 
        }
        catch(IOException e)
        {
            System.out.println("exception"+e);
            try
            {
                mbookDetail.close();
            }
            catch(FileNotFoundException t)
             {
                 System.out.println("Exception:"+t);
             }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
            System.out.println("enter book details again");
        }
        }
    }
}

class Reference_Book extends book
{
    String Author;
    int edition;
    Reference_Book(String name,String id,String Author,int edition)
    {
        super(name,id,"ReferenceBook");
        this.Author=Author;
        this.edition=edition;
    }
    void add_book()
    {
        FileWriter rbookDetail=null;
        while(true){
        try
        {
            rbookDetail=new FileWriter("ReferenceBook",true);
            rbookDetail.write(book_Name);
            rbookDetail.append(" | "+book_id);
            rbookDetail.append(" | "+book_type);
            rbookDetail.append(" | "+Author);
            rbookDetail.append(" | "+edition+"\n");
            rbookDetail.close();
            break;
        }
        catch(FileNotFoundException r)
        {
             System.out.println("exception"+r);
             try
            {
                rbookDetail.close();
            }
             catch(FileNotFoundException t)
             {
                 System.out.println("Exception:"+t);
             }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
            System.out.println("enter book details again");
        }
        catch(IOException e)
        {
            System.out.println("exception"+e);
             try
            {
                rbookDetail.close();
            }
             catch(FileNotFoundException t)
             {
                 System.out.println("Exception:"+t);
             }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
            System.out.println("enter book details again");
        }
        }
    }
}

class Text_Book extends book
{
    int edition;
    String Subject;
    String Author;
    Text_Book(String name,String id,String Author,String Subject,int edition)
    {
        super(name,id,"TextBook");
        this.Author=Author;
        this.Subject=Subject;
        this.edition=edition;
    }
    void add_book()
    {
        FileWriter tbookDetail=null;
        while(true){
        try
        {
            tbookDetail=new FileWriter("TextBook",true);
            tbookDetail.write(book_Name);
            tbookDetail.append(" | "+book_id);
            tbookDetail.append(" | "+book_type);
            tbookDetail.append(" | "+Author);
            tbookDetail.append(" | "+edition);
            tbookDetail.append(" | "+Subject+"\n");
            tbookDetail.close();
            break;
        }
        catch(FileNotFoundException r)
        {
             System.out.println("exception"+r);
              try
            {
                tbookDetail.close();
            }
            catch(FileNotFoundException t)
            {
                System.out.println("Exception:"+t);
            }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
            System.out.println("enter book details again");
        }
        catch(IOException e)
        {
            System.out.println("exception"+e);
             try
            {
                tbookDetail.close();
            }
            catch(FileNotFoundException t)
            {
                System.out.println("Exception:"+t);
            }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
            System.out.println("enter book details again");
        }
        }
    }
}

class NewsPaper 
{
    String Publisher;
    String DateOfArrival;
    
    NewsPaper(String publisher,String date)
    {
        this.Publisher=publisher;
        this.DateOfArrival=date;
    }
    
    void add_book()
    {
        FileWriter newsPaper=null;
        while(true){
        try
        {
            newsPaper=new FileWriter("NewsPaper",true);
            newsPaper.append(Publisher);
            newsPaper.append(" | "+DateOfArrival+"\n");
            newsPaper.close();
            break;
        }
        catch(FileNotFoundException r)
        {
             System.out.println("exception"+r);
             try
            {
                newsPaper.close();
            }
             catch(FileNotFoundException t)
             {
                 System.out.println("Exception:"+t);
             }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
            System.out.println("enter book details again");
        }
        catch(IOException e)
        {
            System.out.println("exception"+e);
             try
            {
                newsPaper.close();
            }
             catch(FileNotFoundException t)
             {
                 System.out.println("Exception:"+t);
             }
            catch(IOException ex)
            {
                System.out.println("Exception:"+ex);
            }
            System.out.println("enter book details again");
        }
        }
    }
}