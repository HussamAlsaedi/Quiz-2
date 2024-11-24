package com.example.lmss.Service;

import com.example.lmss.Model.Book;
import com.example.lmss.Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Service
public class UserService {

    ArrayList<User> users = new ArrayList<>();


    public ArrayList<User> getAllUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean updateUser(int index , User user)
    {
        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == index)
            {
                users.set(i,user);
                return true;
            }
        }
        return false;
    }


    public boolean deleteUser(int index){
        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == index)
            {
                users.remove(i);
                return true;
            }
        }
        return false;
    }


    public ArrayList<User> getUserHaveBalanceOrAbove(double index)
    {
        ArrayList<User> balanceUser = new ArrayList<>();

        for (User loop: users)
        {
            if (loop.getBalance() >= index )
            {
                balanceUser.add(loop);
            }
        }

        return balanceUser;
    }

    public ArrayList<User> getUserHaveAgeOrAbove (int index)
    {
        ArrayList<User> ages = new ArrayList<>();

        for (User loop: users)
        {
            if (loop.getAge() >= index )
            {
                ages.add(loop);
            }
        }

        return ages;
    }


    public boolean checkUser(int indexBook)
    {

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId() == indexBook )
            {
                 for (User loop: users)
                 {
                     if (loop.getRole().equalsIgnoreCase("librarian"));
                     return true;
                 }

            }

        }
        return false;
    }







}
