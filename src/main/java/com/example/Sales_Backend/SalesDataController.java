package com.example.Sales_Backend;


import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/salesdata")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend to access this controller
public class SalesDataController {

    private final SalesDataService salesDataService;

    @Autowired
    public SalesDataController(SalesDataService salesDataService) {
        this.salesDataService = salesDataService;
    }
    @Autowired
    private SalesDataRepository salesDataRepository;
    
    // Caching the result to prevent frequent database hits
    @GetMapping("/TopColumn")
    public SalesData getSalesDataTotals(@RequestParam(value = "created_at", required = false) String createdAt) {
    	SalesData totalSalesData = new SalesData();
        
        if (createdAt == null || createdAt.equals("null") || createdAt.isEmpty()) {
           
            // Fetching all necessary data in one place to reduce multiple calls
            totalSalesData.setTotRevLmtd(salesDataRepository.findTotalTotRevLmtdAll());
            totalSalesData.setTotRevMtd(salesDataRepository.findTotalTotRevMtdAll());
            totalSalesData.setTotRevGrowth(salesDataRepository.findTotalTotRevGrowthAll());

            totalSalesData.setVlrLmtd(salesDataRepository.findTotalVlrLmtdAll());
            totalSalesData.setVlrMtd(salesDataRepository.findTotalVlrMtdAll());
            totalSalesData.setVlrGrowth(salesDataRepository.findTotalVlrGrowthAll());

            totalSalesData.setRgu90Lmtd(salesDataRepository.findTotalrgu90LmtdAll());
            totalSalesData.setRgu90Mtd(salesDataRepository.findTotalrgu90MtdAll());
            totalSalesData.setRgu90Growth(salesDataRepository.findTotalrgu90GrowthAll());

            totalSalesData.setNetAdd30d(salesDataRepository.findTotalnetAdd30dAll());
            totalSalesData.setNetAdd90d(salesDataRepository.findTotalnetAdd90dAll());
            totalSalesData.setGrossMtdChurn30d(salesDataRepository.findTotalgrossMtdChurn30dAll());
            totalSalesData.setGrossMtdChurn90d(salesDataRepository.findTotalgrossMtdChurn90dAll());
        } else {
           
            try {
                Date date = Date.valueOf(createdAt); 
                // Fetching all necessary data in one place to reduce multiple calls
                totalSalesData.setTotRevLmtd(salesDataRepository.findTotalTotRevLmtd(date));
                totalSalesData.setTotRevMtd(salesDataRepository.findTotalTotRevMtd(date));
                totalSalesData.setTotRevGrowth(salesDataRepository.findTotalTotRevGrowth(date));

                totalSalesData.setVlrLmtd(salesDataRepository.findTotalVlrLmtd(date));
                totalSalesData.setVlrMtd(salesDataRepository.findTotalVlrMtd(date));
                totalSalesData.setVlrGrowth(salesDataRepository.findTotalVlrGrowth(date));

                totalSalesData.setRgu90Lmtd(salesDataRepository.findTotalrgu90Lmtd(date));
                totalSalesData.setRgu90Mtd(salesDataRepository.findTotalrgu90Mtd(date));
                totalSalesData.setRgu90Growth(salesDataRepository.findTotalrgu90Growth(date));

                totalSalesData.setNetAdd30d(salesDataRepository.findTotalnetAdd30d(date));
                totalSalesData.setNetAdd90d(salesDataRepository.findTotalnetAdd90d(date));
                totalSalesData.setGrossMtdChurn30d(salesDataRepository.findTotalgrossMtdChurn30d(date));
                totalSalesData.setGrossMtdChurn90d(salesDataRepository.findTotalgrossMtdChurn90d(date));
            } catch (IllegalArgumentException e) {
      
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use yyyy-MM-dd.");
            }
        }

        return totalSalesData;
    }

    // Caching to prevent unnecessary database hits
    @GetMapping("/SecondColumn")
    public SalesData getSalesDataTotalsecond(@RequestParam(value = "created_at", required = false) String createdAt) {
    	SalesData totalSalesData = new SalesData();
        
        if (createdAt == null || createdAt.equals("null") || createdAt.isEmpty()) {
           
        	totalSalesData.setTotRevMtd(salesDataRepository.findTotalTotRevMtdAll());
            totalSalesData.setDailyUroGrowth(salesDataRepository.findTotaldailyUroGrowthAll());
            totalSalesData.setDailySsoGrowth(salesDataRepository.findTotaldailySsoGrowthAll());

            totalSalesData.setQuroMtd(salesDataRepository.findTotalquroMtdAll());
            totalSalesData.setQuroGrowth(salesDataRepository.findTotalquroGrowthAll());
            totalSalesData.setQssoGrowth(salesDataRepository.findTotalqssoGrowthAll());
            totalSalesData.setQssoMtd(salesDataRepository.findTotalqssoMtdAll());
            
            totalSalesData.setMoboMtd(salesDataRepository.findTotalmoboMtdAll());
            totalSalesData.setDataRevMtd(salesDataRepository.findTotaldataRevMtdAll());
            totalSalesData.setVasRevMtd(salesDataRepository.findTotalvasRevMtdAll());
            totalSalesData.setMoboTradeMtd(salesDataRepository.findTotalMoboTradeMtdAll());
            totalSalesData.setMoboNonTradeMtd(salesDataRepository.findTotalMoboNonTradeMtdAll());
            totalSalesData.setOrgRevMtd(salesDataRepository.findTotalorgRevMtdAll());
            
            totalSalesData.setTradeSupplyMtd(salesDataRepository.findTotalTradeSupplyMtdAll());
            totalSalesData.setTradeCvmRevMtd(salesDataRepository.findTotalTradeCvmRevMtdAll());
            totalSalesData.setTradeSpMtd(salesDataRepository.findTotalTradeSpMtdAll());
            totalSalesData.setTradeRebuyMtd(salesDataRepository.findTotaltradeRebuyMtdAll());
        } else {
           
            try {
                Date date = Date.valueOf(createdAt); 
                totalSalesData.setTotRevMtd(salesDataRepository.findTotalTotRevMtd(date));
                totalSalesData.setDailyUroGrowth(salesDataRepository.findTotaldailyUroGrowth(date));
                totalSalesData.setDailySsoGrowth(salesDataRepository.findTotaldailySsoGrowth(date));

                totalSalesData.setQuroMtd(salesDataRepository.findTotalquroMtd(date));
                totalSalesData.setQuroGrowth(salesDataRepository.findTotalquroGrowth(date));
                totalSalesData.setQssoGrowth(salesDataRepository.findTotalqssoGrowth(date));
                totalSalesData.setQssoMtd(salesDataRepository.findTotalqssoMtd(date));

                totalSalesData.setMoboMtd(salesDataRepository.findTotalmoboMtd(date));
                totalSalesData.setDataRevMtd(salesDataRepository.findTotaldataRevMtd(date));
                totalSalesData.setVasRevMtd(salesDataRepository.findTotalvasRevMtd(date));
                totalSalesData.setMoboTradeMtd(salesDataRepository.findTotalMoboTradeMtd(date));
                totalSalesData.setMoboNonTradeMtd(salesDataRepository.findTotalMoboNonTradeMtd(date));
                totalSalesData.setOrgRevMtd(salesDataRepository.findTotalorgRevMtd(date));

                totalSalesData.setTradeSupplyMtd(salesDataRepository.findTotalTradeSupplyMtd(date));
                totalSalesData.setTradeCvmRevMtd(salesDataRepository.findTotalTradeCvmRevMtd(date));
                totalSalesData.setTradeSpMtd(salesDataRepository.findTotalTradeSpMtd(date));
                totalSalesData.setTradeRebuyMtd(salesDataRepository.findTotaltradeRebuyMtd(date));
            } catch (IllegalArgumentException e) {
      
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use yyyy-MM-dd.");
            }
        }
        
   
        
        

        return totalSalesData;
    }
    @GetMapping("/RevenueSouth")
    public SalesData getSalesDataRevenueSouth(@RequestParam(value = "created_at", required = false) String createdAt) {
        SalesData totalSalesData = new SalesData();
        
        if (createdAt == null || createdAt.equals("null") || createdAt.isEmpty()) {
           
            totalSalesData.setTotRevMtd(salesDataRepository.findTotalRevenueMtdSouthAll());
        } else {
           
            try {
                Date date = Date.valueOf(createdAt); 
                totalSalesData.setTotRevMtd(salesDataRepository.findTotalRevenueMtdSouth(date));
            } catch (IllegalArgumentException e) {
      
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use yyyy-MM-dd.");
            }
        }
        
        return totalSalesData;
    }

    @GetMapping("/created-at")
    public List<Date> getDistinctCreatedAtDates() {
        return salesDataService.getDistinctCreatedAtDates();
    }
    @GetMapping("/RevenueNorth")
    public SalesData getSalesDataRevenueNorth(@RequestParam(value = "created_at", required = false) String createdAt) {
       SalesData totalSalesData = new SalesData();
        
        if (createdAt == null || createdAt.equals("null") || createdAt.isEmpty()) {
           
        	totalSalesData.setTotRevMtd(salesDataRepository.findTotalRevenueMtdNorthAll());
        } else {
           
            try {
                Date date = Date.valueOf(createdAt); 
                totalSalesData.setTotRevMtd(salesDataRepository.findTotalRevenueMtdNorth(date));
            } catch (IllegalArgumentException e) {
      
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use yyyy-MM-dd.");
            }
        }
        
    	 return totalSalesData;
    }
   
    @GetMapping("/average")
    public List<SalesDataBranch> getAverageSalesDataAll(@RequestParam(value = "created_at", required = false) String createdAt) {
        if (createdAt == null || createdAt.equals("null") || createdAt.isEmpty()) {
           
           return salesDataService.fetchSalesDataAll();
        } else {
           
            try {
                Date date = Date.valueOf(createdAt); 
           return salesDataService.fetchSalesData(date);
            } catch (IllegalArgumentException e) {
      
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use yyyy-MM-dd.");
            }
        }
    }
    
    @GetMapping("/lowest")
    public List<SalesDataBranch> getLowest(@RequestParam(value = "created_at", required = false) String createdAt) {
    	 if (createdAt == null || createdAt.equals("null") || createdAt.isEmpty()) {
             
             return salesDataService.fetchLowestAll();
          } else {
             
              try {
                  Date date = Date.valueOf(createdAt); 
             return salesDataService.fetchLowest(date);
              } catch (IllegalArgumentException e) {
        
                  throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use yyyy-MM-dd.");
              }
          }
    }
    @GetMapping("/highest")
    public List<SalesDataBranch> getHighest(@RequestParam(value = "created_at", required = false) String createdAt) {
    	if (createdAt == null || createdAt.equals("null") || createdAt.isEmpty()) {
            
    		return salesDataService.fetchHighestAll();
         } else {
             try {
                 Date date = Date.valueOf(createdAt); 
            return salesDataService.fetchHighest(date);
             } catch (IllegalArgumentException e) {
       
                 throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use yyyy-MM-dd.");
             }
         }
    	
    }
    
    // This method does not seem to require optimization, but could benefit from pagination if the dataset is large
    @GetMapping
    public List<SalesData> getAllSalesData() {
        return salesDataService.getAllSalesData();
    }
    
    

    @PostMapping("/upload")
    public ResponseEntity<String> uploadSalesData(@RequestParam("file") MultipartFile file) {
        List<SalesData> salesDataList = new ArrayList<>();
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy"); // Input format
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd"); // Output format for SQL Date
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            reader.readLine(); // Skip header line
            
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");

                // Verify if the CSV has the expected number of fields
                if (fields.length < 81) {
                    return new ResponseEntity<>("CSV format is incorrect. Expected 80 fields per row.", HttpStatus.BAD_REQUEST);
                }

                SalesData salesData = new SalesData();
                // Adding the initial fields first
                salesData.setSiteName(fields[0]);
                salesData.setSalesArea(fields[1]);
                salesData.setArea(fields[2]);
                salesData.setBrand(fields[3]);
                salesData.setTotRevMtd(new BigDecimal(fields[4]));
                salesData.setTotRevLmtd(new BigDecimal(fields[5]));
                salesData.setTotRevGrowth(new BigDecimal(fields[6]));

                // Continue with the remaining fields
                salesData.setMoboMtd(new BigDecimal(fields[7]));
                salesData.setMoboLmtd(new BigDecimal(fields[8]));
                salesData.setMoboGrowth(new BigDecimal(fields[9]));

                salesData.setOrgRevMtd(new BigDecimal(fields[10]));
                salesData.setOrgRevLmtd(new BigDecimal(fields[11]));
                salesData.setOrgRevGrowth(new BigDecimal(fields[12]));

                salesData.setMoboNonTradeMtd(new BigDecimal(fields[13]));
                salesData.setMoboNonTradeLmtd(new BigDecimal(fields[14]));
                salesData.setMoboNonTradeGrowth(new BigDecimal(fields[15]));

                salesData.setMoboTradeMtd(new BigDecimal(fields[16]));
                salesData.setMoboTradeLmtd(new BigDecimal(fields[17]));
                salesData.setMoboTradeGrowth(new BigDecimal(fields[18]));

                salesData.setVasRevMtd(new BigDecimal(fields[19]));
                salesData.setVasRevLmtd(new BigDecimal(fields[20]));
                salesData.setVasRevGrowth(new BigDecimal(fields[21]));

                salesData.setDataRevMtd(new BigDecimal(fields[22]));
                salesData.setDataRevLmtd(new BigDecimal(fields[23]));
                salesData.setDataRevGrowth(new BigDecimal(fields[24]));

                salesData.setGaMtd(Long.parseLong(fields[25]));
                salesData.setGaLmtd(Long.parseLong(fields[26]));
                salesData.setGaGrowth(new BigDecimal(fields[27]));

                salesData.setM2sMtd(Long.parseLong(fields[28]));
                salesData.setM2sLmtd(Long.parseLong(fields[29]));
                salesData.setM2sGrowth(new BigDecimal(fields[30]));

                salesData.setVlrMtd(new BigDecimal(fields[31]));
                salesData.setVlrLmtd(new BigDecimal(fields[32]));
                salesData.setVlrGrowth(new BigDecimal(fields[33]));

                salesData.setVlrPrepaidMtd(new BigDecimal(fields[34]));
                salesData.setVlrPrepaidLmtd(new BigDecimal(fields[35]));
                salesData.setVlrPrepaidGrowth(new BigDecimal(fields[36]));

                salesData.setVlrPostpaidMtd(new BigDecimal(fields[37]));
                salesData.setVlrPostpaidLmtd(new BigDecimal(fields[38]));
                salesData.setVlrPostpaidGrowth(new BigDecimal(fields[39]));

                salesData.setRgu90Mtd(new BigDecimal(fields[40]));
                salesData.setRgu90Lmtd(new BigDecimal(fields[41]));
                salesData.setRgu90Growth(new BigDecimal(fields[42]));

                salesData.setRgu30Mtd(new BigDecimal(fields[43]));
                salesData.setRgu30Lmtd(new BigDecimal(fields[44]));
                salesData.setRgu30Growth(new BigDecimal(fields[45]));

                salesData.setNetAdd90d(new BigDecimal(fields[46]));
                salesData.setNetAdd30d(new BigDecimal(fields[47]));

                salesData.setDailyUroMtd(new BigDecimal(fields[48]));
                salesData.setDailyUroLmtd(new BigDecimal(fields[49]));
                salesData.setDailyUroGrowth(new BigDecimal(fields[50]));

                salesData.setDailySsoMtd(new BigDecimal(fields[51]));
                salesData.setDailySsoLmtd(new BigDecimal(fields[52]));
                salesData.setDailySsoGrowth(new BigDecimal(fields[53]));

                salesData.setTertiaryBMtd(new BigDecimal(fields[54]));
                salesData.setTertiaryBLmtd(new BigDecimal(fields[55]));
                salesData.setTertiaryBGrowth(new BigDecimal(fields[56]));

                salesData.setGrossMtdChurn90d(new BigDecimal(fields[57]));
                salesData.setGrossMtdChurn30d(new BigDecimal(fields[58]));

                salesData.setTradeSupplyMtd(new BigDecimal(fields[59]));
                salesData.setTradeSupplyLmtd(new BigDecimal(fields[60]));
                salesData.setTradeSupplyGrowth(new BigDecimal(fields[61]));

                salesData.setAcqRevMtd(new BigDecimal(fields[62]));
                salesData.setAcqRevLmtd(new BigDecimal(fields[63]));
                salesData.setAcqRevGrowth(new BigDecimal(fields[64]));

                salesData.setTradeCvmRevMtd(new BigDecimal(fields[65]));
                salesData.setTradeCvmRevLmtd(new BigDecimal(fields[66]));
                salesData.setTradeCvmRevGrowth(new BigDecimal(fields[67]));

                salesData.setTradeRebuyMtd(new BigDecimal(fields[68]));
                salesData.setTradeRebuyLmtd(new BigDecimal(fields[69]));
                salesData.setTradeRebuyGrowth(new BigDecimal(fields[70]));

                salesData.setTradeSpMtd(new BigDecimal(fields[71]));
                salesData.setTradeSpLmtd(new BigDecimal(fields[72]));
                salesData.setTradeSpGrowth(new BigDecimal(fields[73]));

                salesData.setQuroMtd(new BigDecimal(fields[74]));
                salesData.setQuroLmtd(new BigDecimal(fields[75]));
                salesData.setQuroGrowth(new BigDecimal(fields[76]));

                salesData.setQssoMtd(new BigDecimal(fields[77]));
                salesData.setQssoLmtd(new BigDecimal(fields[78]));
                salesData.setQssoGrowth(new BigDecimal(fields[79]));
                String createdAtStr = fields[80].trim(); // Ensure there are no leading/trailing spaces

                // Validate the date format
                if (createdAtStr.isEmpty()) {
                    return new ResponseEntity<>("Date for createdAt cannot be empty.", HttpStatus.BAD_REQUEST);
                }

                try {
                    // Parse the date from the input format and convert to SQL date
                    java.util.Date parsedDate = inputFormat.parse(createdAtStr);
                    salesData.setCreatedAt(new Date(parsedDate.getTime()));
                } catch (ParseException e) {
                    return new ResponseEntity<>("Invalid date format for createdAt: " + createdAtStr, HttpStatus.BAD_REQUEST);
                }
                salesDataList.add(salesData);
            }

            // Save all data to database
            salesDataRepository.saveAll(salesDataList);

        } catch (Exception e) {
            // Log the error details for better debugging
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload and save sales data. Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Sales data uploaded and saved successfully.", HttpStatus.OK);
    }

}
