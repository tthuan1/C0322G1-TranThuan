package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository{
    static Map<String,String> map= new LinkedHashMap<>();
    static {
        map.put("chó", "dog");
        map.put("hải", "dog");
        map.put("thuận", "đẹp trai");
        map.put("mèo", "cat");
        map.put("quang", "đỉnh");
    }

    @Override
    public String get(String vnWord) {
        return map.get(vnWord);
    }
}
