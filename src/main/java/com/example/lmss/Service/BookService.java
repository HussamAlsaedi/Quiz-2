package com.example.lmss.Service;

import com.example.lmss.Model.Book;

import com.example.lmss.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class BookService {

    ArrayList<Book> books = new ArrayList<>();


    public ArrayList<Book> getAllBooks(){
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public boolean updateBook(int index , Book book)
    {
        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getId() == index)
            {
                books.set(i,book);
                return true;
            }
        }
        return false;
    }


    public boolean deleteBook(int index){
        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getId() == index)
            {
                books.remove(i);
                return true;
            }
        }
        return false;
    }


    public String getBook(String index)
    {

        for (Book loop: books)
        {
            if (loop.getName().equalsIgnoreCase(index))
            {
              return  loop.getName();
            }
        }
        return "Book Not Found";
    }

    // category.

    public ArrayList<Book> getBookByCategory(String index)
    {
        ArrayList<Book> matchingCategory = new ArrayList<>();

        for (Book loop: books)
        {
            if (loop.getCategory().equalsIgnoreCase(index))
            {
                books.add(loop);
            }
        }
        return matchingCategory ;
    }

    //  getBooksHaveNumberPagesOrAbove .

    public ArrayList<Book> getBooksHaveNumberPagesOrAbove(int index)
    {
        ArrayList<Book> matchingPages = new ArrayList<>();

        for (Book loop: books)
        {
            if (loop.getNum_pages() >= index)
            {
                matchingPages.add(loop);
            }
        }

        return matchingPages;
    }

    public String updateStatus(int indexBook)
    {

         for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getId() == indexBook)
            {
                for (Book loop: books){
                    if (!loop.isAvailble())
                    {
                        loop.setAvailble(true);
                        return "STATUS UPDATE";
                    }
                    return "Status is already available";
                }
            }

        }
        return "Book Not fond";
    }




}
