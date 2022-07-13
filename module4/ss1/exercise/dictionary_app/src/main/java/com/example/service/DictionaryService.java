package com.example.service;

import com.example.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private IDictionaryRepository dictionaryRepository;

    static Map<String,String> map= new LinkedHashMap<>();
    static {
        map.put("chó", "dog");
        map.put("hải", "gà");
        map.put("thuận", "đẹp trai");
        map.put("mèo", "cat");
        map.put("quang", "đỉnh");
    }

    @Override
    public String search(String vnWord) {
        String result=map.get(vnWord);
        if (result ==null){
            return "Không tìm thấy";
        }return result;
    }
}
