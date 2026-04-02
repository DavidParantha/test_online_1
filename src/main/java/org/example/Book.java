package org.example;
import java.util.*;

class Book{
    int bookId;
    String title;
    String author;
    boolean available;

    Book(int id,String t,String a){
        bookId=id;
        title=t;
        author=a;
        available=true;
    }
    void display(){
        System.out.println(bookId+" "+title+" "+author+" "+(available?"Available":"Issued"));
    }
}
class Member{
    int memberId;
    String name;

    Member(int id,String n){
        memberId=id;
        name=n;
    }
    double calculateFine(int days){
        return days*5;
    }
}
class StudentMember extends Member{
    StudentMember(int id,String n){
        super(id,n);
    }
    double calculateFine(int days){
        return days*2;
    }
}
class Library{
    ArrayList<Book> books=new ArrayList<>();
    HashMap<Integer,ArrayList<Book>> issued=new HashMap<>();

    void addBook(Book b){
        books.add(b);
    }

    void displayBooks(){
        for(Book b:books){
            b.display();
        }
    }
    void issueBook(int id,Book b){
        if(b.available){
            b.available=false;
            if(!issued.containsKey(id)){
                issued.put(id,new ArrayList<>());
            }
            issued.get(id).add(b);
            System.out.println("issued");
        }else{
            System.out.println("not available");
        }
    }
    void returnBook(int id,Book b){
        if(issued.containsKey(id)){
            issued.get(id).remove(b);
            b.available=true;
            System.out.println("returned");
        }
    }
    void searchBook(String t){
        for(Book b:books){
            if(b.title.equalsIgnoreCase(t)){
                b.display();
            }
        }
    }
    void searchBook(String t,String dummy){
        for(Book b:books){
            if(b.author.equalsIgnoreCase(t)){
                b.display();
            }
        }
    }
}

