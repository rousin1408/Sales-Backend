package com.example.Sales_Backend;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesDataService {

    private final SalesDataRepository salesDataRepository;

    @Autowired
    public SalesDataService(SalesDataRepository salesDataRepository) {
        this.salesDataRepository = salesDataRepository;
    }

    public List<SalesData> getAllSalesData() {
        return salesDataRepository.findAll();
    }
    
    public List<SalesDataBranch> fetchSalesDataAll() {
        return salesDataRepository.getSalesDataAll();
    }
    public List<SalesDataBranch> fetchSalesData(Date createdAt) {
        return salesDataRepository.getSalesData(createdAt);
    }
    public List<SalesDataBranch> fetchLowestAll() {
        return salesDataRepository.getLowestAll();
    }
    public List<SalesDataBranch> fetchHighestAll() {
        return salesDataRepository.getHighestAll();
    }
    public List<SalesDataBranch> fetchLowest(Date createdAt) {
        return salesDataRepository.getLowest(createdAt);
    }
    public List<SalesDataBranch> fetchHighest(Date createdAt) {
        return salesDataRepository.getHighest(createdAt);
    }
    // Get distinct 'created_at' dates
    public List<Date> getDistinctCreatedAtDates() {
        return salesDataRepository.findDistinctCreatedAt();
    }
//    // Get sales data filtered by 'created_at'
//    public List<SalesData> getSalesByCreatedAt(String createdAt) {
//        return salesDataRepository.findByCreatedAt(createdAt);
//    }
}
