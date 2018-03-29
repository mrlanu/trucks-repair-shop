package com.lanu.trucks_repair_shop.services.services_impl;

import com.lanu.trucks_repair_shop.repositories.BreakingDetailRepository;
import com.lanu.trucks_repair_shop.services.BreakingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BreakingDetailServiceImpl implements BreakingDetailService{

    @Autowired
    private BreakingDetailRepository breakingDetailRepository;
}
