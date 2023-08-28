package com.example.MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.RandomStringUtils;
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    public Girl getRamdomGirl(){
        String name = randomGirlName(10);
        return girlRepository.getGirlByName(name);
    }
    public String randomGirlName(int length) {
        // Random một string có độ dài quy định
        // Sử dụng thư viện Apache Common Lang
        return RandomStringUtils.randomAlphanumeric(length).toLowerCase();
    }
}
