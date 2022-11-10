package com.RakhaArgyaZahranJSleepDN.Controller;

import com.RakhaArgyaZahranJSleepDN.Algorithm;
import com.RakhaArgyaZahranJSleepDN.Voucher;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonAutowired;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {

    @JsonAutowired(value = Voucher.class, filepath = "C:/Users/RakhaArgya/OneDrive/Dokumen/Argy/PRAKTIKUM OOP/JSleep/lib/voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    @GetMapping("{id}/isUsed")
    boolean isUsed(@PathVariable int id) {
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, voucher1 -> voucher1.id == id);
        return voucher.isUsed();
    }

    @GetMapping("{id}/canApply")
    boolean canApply(@PathVariable int id, @RequestParam double price) {
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, voucher1 -> voucher1.id == id);
        return voucher.canApply(price);
    }

    @GetMapping("{id}/getAvailable")
    List<Voucher> getAvailable(@RequestParam int page, @RequestParam int pageSize) {
        List<Voucher> vouchers1 = Algorithm.<Voucher>collect(getJsonTable(), pred -> true);
        List<Voucher> vouchers2 = new ArrayList<>();
        for (Voucher voucher : vouchers1) {
            if (!voucher.isUsed()) {


                vouchers2.add(voucher);
            }
        }
        return Algorithm.<Voucher>paginate(vouchers2, page, pageSize, pred -> true);





    }



}
