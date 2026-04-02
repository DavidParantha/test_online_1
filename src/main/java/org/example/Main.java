package org.example;


public class Main{
    public static void main(String[] args){
        Library lib  =new Library();

        Book b1=new Book(1,"Java","James");
        Book b2=new Book(2,"OOP","Bjarne");
        lib.addBook(b1);
        lib.addBook(b2);
        Member m1=new Member(101,"David");
        StudentMember s1=new StudentMember(102,"John");
        lib.displayBooks();
        lib.issueBook(m1.memberId,b1);
        lib.displayBooks();
        lib.returnBook(m1.memberId,b1);

        lib.searchBook("Java");
        lib.searchBook("Bjarne","a");
        System.out.println(m1.calculateFine(3));
        System.out.println(s1.calculateFine(3));
    }
}
