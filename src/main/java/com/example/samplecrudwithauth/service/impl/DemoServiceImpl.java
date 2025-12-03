package com.example.samplecrudwithauth.service.impl;

import com.example.samplecrudwithauth.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String demoMethod() {
        return "This is the demo method.";
    }
}
