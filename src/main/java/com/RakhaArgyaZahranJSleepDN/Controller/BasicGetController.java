package com.RakhaArgyaZahranJSleepDN.Controller;
import com.RakhaArgyaZahranJSleepDN.Algorithm;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public interface BasicGetController <T extends Serializable> {
    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize) {

        return getJsonTable().subList(page, page + pageSize);
    }

    @GetMapping("/{id}")
    public default T getById (@PathVariable int id) {
        try {
            return getJsonTable().get(id);
        } catch (Exception e) {
            return null;
        }
    }

}