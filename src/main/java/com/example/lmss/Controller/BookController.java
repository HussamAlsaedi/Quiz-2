package com.example.lmss.Controller;

import com.example.lmss.ApiResponse.ApiResponse;
import com.example.lmss.Model.Book;

import com.example.lmss.Service.BookService;
import com.example.lmss.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;
    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAllBooks()
    {
         if (bookService.getAllBooks().isEmpty())
         {
             return ResponseEntity.status(400).body(new ApiResponse("List is Empty"));
         }
        return  ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book, Errors errors)
    {
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("Book added successfully"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateBook(@PathVariable int index,@RequestBody @Valid Book book, Errors errors)
    {
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }

        if(bookService.updateBook(index, book))
        {
            return ResponseEntity.status(200).body(new ApiResponse("Book update successfully"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("BookNot found"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteBook(@PathVariable int index)
    {
        if (bookService.deleteBook(index))
        {
            return ResponseEntity.status(200).body(new ApiResponse("Book Deleted successfully"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("Book Not found"));
    }


    @GetMapping("/get-book/{index}")
    public  ResponseEntity getBook(@PathVariable String index)
    {

        return ResponseEntity.ok(bookService.getBook(index));
    }

    @GetMapping("/get-BookByCategory/{index}")
    public  ResponseEntity getBookByCategory(@PathVariable String index)
    {
        return ResponseEntity.ok(bookService.getBookByCategory(index));
    }

    @GetMapping("/get-BooksHaveNumberPagesOrAbove/{index}")
    public  ResponseEntity getBooksHaveNumberPagesOrAbove(@PathVariable int index)
    {
        return ResponseEntity.ok(bookService.getBooksHaveNumberPagesOrAbove(index));
    }

   @GetMapping("/changeStatus/{index}/{indexBook}")
    public ResponseEntity changeStatus(@PathVariable int index,@PathVariable int indexBook )
    {
        if (userService.checkUser(index))
        {
            return ResponseEntity.ok(bookService.updateStatus(indexBook));
        }

       return ResponseEntity.status(400).body(new ApiResponse(" user not allow"));

    }

}
