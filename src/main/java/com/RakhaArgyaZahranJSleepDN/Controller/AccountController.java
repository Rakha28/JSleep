package com.RakhaArgyaZahranJSleepDN.Controller;


import com.RakhaArgyaZahranJSleepDN.Account;
import com.RakhaArgyaZahranJSleepDN.Algorithm;
import com.RakhaArgyaZahranJSleepDN.Renter;

import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])*[a-zA-Z\\d]{8,}$";
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]@[A-Za-z.-]\\.[a-z]$";
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    @JsonAutowired(filepath ="\"C:\\Users\\RakhaArgya\\OneDrive\\Dokumen\\Argy\\PRAKTIKUM OOP\\JSleep\\lib\\account.json\"", value = Account.class)
    public static JsonTable<Account> accountTable;

    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }

    @PostMapping("/login")
    Account login(@RequestParam String email, @RequestParam String password){
        try{
            Account account = Algorithm.<Account>find(accountTable, pred -> pred.email.equals(email));
            if (account != null && account.password.equals(password)){
                return account;
            }
        } catch (Exception e){
            return null;
        }
return null;


    }


    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matchEmail = matcherEmail.find();

        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();
        try{
            Account findAccount = Algorithm.<Account> find(getJsonTable(),pred -> pred.email == email);

            if (findAccount == null && matchEmail && matchFoundPassword){
                Account account = new Account(name, email, password);
                accountTable.add(account);
                return account;
            }
        } catch (Exception e){
            return null;
        }
        return accountTable.get(0);
    }
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter (@PathVariable int id, @RequestParam String name, @RequestParam String address, @RequestParam String phoneNumber){
        try{
            Account account = Algorithm.<Account>find(accountTable, pred -> pred.id == id);
            if (account != null){
                Renter renter = new Renter(name, address, phoneNumber);
                account.renter = renter;
                return renter;
            }
        } catch (Exception e){
            return null;
        }
        return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp (@PathVariable int id, @RequestParam double balance){
        try{
            Account account = Algorithm.<Account>find(accountTable, pred -> pred.id == id);
            if (account != null){
                account.balance += balance;
                return true;
            }
        } catch (Exception e){
            return false;
        }
        return false;
    }
}
