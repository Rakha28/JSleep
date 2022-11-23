package com.RakhaArgyaZahranJSleepDN.controller;


import com.RakhaArgyaZahranJSleepDN.Algorithm;
import com.RakhaArgyaZahranJSleepDN.Account;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonAutowired;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import com.RakhaArgyaZahranJSleepDN.Renter;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    @JsonAutowired(value=Account.class,filepath="C:\\Users\\RakhaArgya\\OneDrive\\Dokumen\\Argy\\PRAKTIKUM OOP\\JSleep\\lib\\account.json")
    public static JsonTable<Account>  accountTable;
    static {
        try {
            accountTable = new JsonTable<>(Account.class, "C:\\Users\\RakhaArgya\\OneDrive\\Dokumen\\Argy\\PRAKTIKUM OOP\\JSleep\\lib\\account.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
        final String generatedPass;
        Matcher matcher_email = REGEX_PATTERN_EMAIL.matcher(email);
        Matcher matcher_password = REGEX_PATTERN_PASSWORD.matcher(password);
        Account findEmail = Algorithm.<Account> find(accountTable, pred -> Objects.equals(pred.email, email));

        if(matcher_email.find() && matcher_password.find() && !name.isBlank() && findEmail == null){
            generatedPass = hashPassword(password);
            Account account = new Account(name, email, generatedPass);
            accountTable.add(account);
            return account;
        }
        return null;
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        final String generatedPass = hashPassword(password);
        return Algorithm.<Account>find(accountTable, pred -> Objects.equals(pred.email, email) && Objects.equals(pred.password, generatedPass));
    }

    @PostMapping("/registerRenter")
    Renter registerRenter(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) { Account test = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if(test.renter == null){
            test.renter = new Renter(name, address, phoneNumber);
            return test.renter;
        }
        return null;
    }

    @PostMapping("/topUp")
    boolean topUp
            (
                    @PathVariable int id,
                    @RequestParam double balance
            )
    {
        Account account = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if(account != null && balance > 0){
            account.balance += balance;
            return true;
        }
        return false;
    }

    private static String hashPassword(String password){
        String hashedPass = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            hashedPass = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hashedPass;
    }
}