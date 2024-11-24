package com.example.lmss.Controller;

import com.example.lmss.ApiResponse.ApiResponse;
import com.example.lmss.Model.User;
import com.example.lmss.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/get")
    public ResponseEntity getAllUsers()
    {
        if (userService.getAllUsers().isEmpty())
        {
            return ResponseEntity.status(400).body(new ApiResponse("List is Empty"));
        }
        return  ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid  User user, Errors errors)
    {
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added successfully"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateUser(@PathVariable int index,@RequestBody @Valid User user, Errors errors)
    {
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getAllErrors().get(0).getDefaultMessage());
        }

        if(userService.updateUser(index, user))
        {
            return ResponseEntity.status(200).body(new ApiResponse("user update successfully"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("user Not found"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteUser(@PathVariable int index)
    {
        if (userService.deleteUser(index))
        {
            return ResponseEntity.status(200).body(new ApiResponse("User Deleted successfully"));
        }

        return ResponseEntity.status(200).body(new ApiResponse("User Not found"));
    }

    @GetMapping("/get-UserHaveBalanceOrAbove/{index}")
    public ResponseEntity getUserHaveBalanceOrAbove(@PathVariable double index)
    {
        return ResponseEntity.ok(userService.getUserHaveBalanceOrAbove(index));
    }

    @GetMapping("/get-UserHaveAgeOrAbove/{index}")
    public ResponseEntity getUserHaveAgeOrAbove(@PathVariable int index)
    {
        return ResponseEntity.ok(userService.getUserHaveAgeOrAbove(index));
    }
}
