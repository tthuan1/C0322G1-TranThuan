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

    @Override
    public String search(String vnWord) {
        String result=dictionaryRepository.get(vnWord);
        if (result ==null){
            return "Không tìm thấy";
        }return result;
    }
}
