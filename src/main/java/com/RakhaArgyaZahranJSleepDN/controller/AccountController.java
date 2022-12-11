package com.RakhaArgyaZahranJSleepDN.controller;


import com.RakhaArgyaZahranJSleepDN.Algorithm;
import com.RakhaArgyaZahranJSleepDN.Account;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonAutowired;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import com.RakhaArgyaZahranJSleepDN.Renter;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rakha Argya Zahran
 * @version 1.0
 * Class ini berfungsi untuk mengatur akun
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    @JsonAutowired(value=Account.class,filepath="C:\\Users\\RakhaArgya\\OneDrive\\Dokumen\\Argy\\PRAKTIKUM OOP\\JSleep\\lib\\account.json")
    public static JsonTable<Account>  accountTable;

    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    /**
     * Method ini berfungsi untuk mengembalikan tabel akun
     * @return tabel akun
     */
    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    /**
     * Register akun baru
     * @param name nama akun
     * @param email email akun
     * @param password password akun
     * @return akun yang telah dibuat
     */
    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) {
        final String generatedPass;
        Matcher matcher_email = REGEX_PATTERN_EMAIL.matcher(email);
        Matcher matcher_password = REGEX_PATTERN_PASSWORD.matcher(password);
        Account findEmail = Algorithm.<Account> find(getJsonTable(), pred -> Objects.equals(pred.email, email));

        if(matcher_email.find() && matcher_password.find() && !name.isBlank() && findEmail == null){
            generatedPass = hashPassword(password);
            Account account = new Account(name, email, generatedPass);
            accountTable.add(account);
            return account;
        }
        return null;
    }

    /**
     * Login akun
     * @param email email akun
     * @param password password akun
     * @return akun yang telah login
     */
    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        final String generatedPass = hashPassword(password);
        return Algorithm.<Account>find(accountTable, pred -> Objects.equals(pred.email, email) && Objects.equals(pred.password, generatedPass));
    }

    /**
     * Register penyewa baru
     * @param id id akun
     * @param name nama penyewa
     * @param address alamat penyewa
     * @param phoneNumber nomor telepon penyewa
     * @return penyewa yang telah dibuat
     */
    @PostMapping("/{id}/registerRenter")
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

    /**
     * Tambah saldo akun
     * @param id id akun
     * @param balance saldo yang ditambahkan
     * @return akun yang telah ditambah saldo
     */
    @PostMapping("/{id}/topUp")
    Account topUp
            (
                    @PathVariable int id,
                    @RequestParam double balance
            )
    {
        Account account = Algorithm.<Account>find(getJsonTable(), pred -> pred.id == id);
        if(account != null && balance > 0){
            account.balance += balance;
            return account;

        }
        return null;
    }

    /**
     * hash password
     * @param password password yang akan dihash
     * @return password yang telah dihash
     */
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
