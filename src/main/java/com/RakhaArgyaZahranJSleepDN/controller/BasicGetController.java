package com.RakhaArgyaZahranJSleepDN.controller;
import com.RakhaArgyaZahranJSleepDN.Algorithm;
import com.RakhaArgyaZahranJSleepDN.Predicate;
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

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        final Predicate<T> idFilter = pred -> (id == pred.id);
        return Algorithm.find(getJsonTable(), idFilter);
    }
    @GetMapping(value ="/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize) {
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}