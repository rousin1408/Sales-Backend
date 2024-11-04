package com.example.Sales_Backend;


import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.io.BufferedReader;
import java.io.IOException;
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
@CrossOrigin(origins = "*") // Allow frontend to access this controller
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
       
            try {
                Date date = Date.valueOf(createdAt); 
           return salesDataService.fetchSalesData(date);
            } catch (IllegalArgumentException e) {
      
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use yyyy-MM-dd.");
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
                if (fields.length < 82) {
                    return new ResponseEntity<>("CSV format is incorrect. Expected 82 fields per row.", HttpStatus.BAD_REQUEST);
                }
                // Parse fields from CSV
                Long id = Long.parseLong(fields[0].trim());
                String siteName = fields[1].trim();
                String salesArea = fields[2].trim();
                String area = fields[3].trim();
                String brand = fields[4].trim();
                BigDecimal totRevMtd = new BigDecimal(fields[5].trim());
                BigDecimal totRevLmtd = new BigDecimal(fields[6].trim());
                BigDecimal totRevGrowth = new BigDecimal(fields[7].trim());
                BigDecimal moboMtd = new BigDecimal(fields[8].trim());
                BigDecimal moboLmtd = new BigDecimal(fields[9].trim());
                BigDecimal moboGrowth = new BigDecimal(fields[10].trim());
                BigDecimal orgRevMtd = new BigDecimal(fields[11].trim());
                BigDecimal orgRevLmtd = new BigDecimal(fields[12].trim());
                BigDecimal orgRevGrowth = new BigDecimal(fields[13].trim());
                BigDecimal moboNonTradeMtd = new BigDecimal(fields[14].trim());
                BigDecimal moboNonTradeLmtd = new BigDecimal(fields[15].trim());
                BigDecimal moboNonTradeGrowth = new BigDecimal(fields[16].trim());
                BigDecimal moboTradeMtd = new BigDecimal(fields[17].trim());
                BigDecimal moboTradeLmtd = new BigDecimal(fields[18].trim());
                BigDecimal moboTradeGrowth = new BigDecimal(fields[19].trim());
                BigDecimal vasRevMtd = new BigDecimal(fields[20].trim());
                BigDecimal vasRevLmtd = new BigDecimal(fields[21].trim());
                BigDecimal vasRevGrowth = new BigDecimal(fields[22].trim());
                BigDecimal dataRevMtd = new BigDecimal(fields[23].trim());
                BigDecimal dataRevLmtd = new BigDecimal(fields[24].trim());
                BigDecimal dataRevGrowth = new BigDecimal(fields[25].trim());
                Long gaMtd = Long.parseLong(fields[26].trim());
                Long gaLmtd = Long.parseLong(fields[27].trim());
                BigDecimal gaGrowth = new BigDecimal(fields[28].trim());
                Long m2sMtd = Long.parseLong(fields[29].trim());
                Long m2sLmtd = Long.parseLong(fields[30].trim());
                BigDecimal m2sGrowth = new BigDecimal(fields[31].trim());
                BigDecimal vlrMtd = new BigDecimal(fields[32].trim());
                BigDecimal vlrLmtd = new BigDecimal(fields[33].trim());
                BigDecimal vlrGrowth = new BigDecimal(fields[34].trim());
                BigDecimal vlrPrepaidMtd = new BigDecimal(fields[35].trim());
                BigDecimal vlrPrepaidLmtd = new BigDecimal(fields[36].trim());
                BigDecimal vlrPrepaidGrowth = new BigDecimal(fields[37].trim());
                BigDecimal vlrPostpaidMtd = new BigDecimal(fields[38].trim());
                BigDecimal vlrPostpaidLmtd = new BigDecimal(fields[39].trim());
                BigDecimal vlrPostpaidGrowth = new BigDecimal(fields[40].trim());
                BigDecimal rgu90Mtd = new BigDecimal(fields[41].trim());
                BigDecimal rgu90Lmtd = new BigDecimal(fields[42].trim());
                BigDecimal rgu90Growth = new BigDecimal(fields[43].trim());
                BigDecimal rgu30Mtd = new BigDecimal(fields[44].trim());
                BigDecimal rgu30Lmtd = new BigDecimal(fields[45].trim());
                BigDecimal rgu30Growth = new BigDecimal(fields[46].trim());
                BigDecimal netAdd90d = new BigDecimal(fields[47].trim());
                BigDecimal netAdd30d = new BigDecimal(fields[48].trim());
                BigDecimal dailyUroMtd = new BigDecimal(fields[49].trim());
                BigDecimal dailyUroLmtd = new BigDecimal(fields[50].trim());
                BigDecimal dailyUroGrowth = new BigDecimal(fields[51].trim());
                BigDecimal dailySsoMtd = new BigDecimal(fields[52].trim());
                BigDecimal dailySsoLmtd = new BigDecimal(fields[53].trim());
                BigDecimal dailySsoGrowth = new BigDecimal(fields[54].trim());
                BigDecimal tertiaryBMtd = new BigDecimal(fields[55].trim());
                BigDecimal tertiaryBLmtd = new BigDecimal(fields[56].trim());
                BigDecimal tertiaryBGrowth = new BigDecimal(fields[57].trim());
                BigDecimal grossMtdChurn90d = new BigDecimal(fields[58].trim());
                BigDecimal grossMtdChurn30d = new BigDecimal(fields[59].trim());
                BigDecimal tradeSupplyMtd = new BigDecimal(fields[60].trim());
                BigDecimal tradeSupplyLmtd = new BigDecimal(fields[61].trim());
                BigDecimal tradeSupplyGrowth = new BigDecimal(fields[62].trim());
                BigDecimal acqRevMtd = new BigDecimal(fields[63].trim());
                BigDecimal acqRevLmtd = new BigDecimal(fields[64].trim());
                BigDecimal acqRevGrowth = new BigDecimal(fields[65].trim());
                BigDecimal tradeCvmRevMtd = new BigDecimal(fields[66].trim());
                BigDecimal tradeCvmRevLmtd = new BigDecimal(fields[67].trim());
                BigDecimal tradeCvmRevGrowth = new BigDecimal(fields[68].trim());
                BigDecimal tradeRebuyMtd = new BigDecimal(fields[69].trim());
                BigDecimal tradeRebuyLmtd = new BigDecimal(fields[70].trim());
                BigDecimal tradeRebuyGrowth = new BigDecimal(fields[71].trim());
                BigDecimal tradeSpMtd = new BigDecimal(fields[72].trim());
                BigDecimal tradeSpLmtd = new BigDecimal(fields[73].trim());
                BigDecimal tradeSpGrowth = new BigDecimal(fields[74].trim());
                BigDecimal quroMtd = new BigDecimal(fields[75].trim());
                BigDecimal quroLmtd = new BigDecimal(fields[76].trim());
                BigDecimal quroGrowth = new BigDecimal(fields[77].trim());
                BigDecimal qssoMtd = new BigDecimal(fields[78].trim());
                BigDecimal qssoLmtd = new BigDecimal(fields[79].trim());
                BigDecimal qssoGrowth = new BigDecimal(fields[80].trim());
                Date createdAt = Date.valueOf(fields[81].trim()); // Assuming date in YYYY-MM-DD format

                // Check if the SalesData already exists
                SalesData existingData = salesDataRepository.findByIdOrNull(id);
                if (existingData != null) {
                    // Update existing data\
                	existingData.setId(id);
                    existingData.setSiteName(siteName);
                    existingData.setSalesArea(salesArea);
                    existingData.setArea(area);
                    existingData.setBrand(brand);
                    existingData.setTotRevMtd(totRevMtd);
                    existingData.setTotRevLmtd(totRevLmtd);
                    existingData.setTotRevGrowth(totRevGrowth);
                    existingData.setMoboMtd(moboMtd);
                    existingData.setMoboLmtd(moboLmtd);
                    existingData.setMoboGrowth(moboGrowth);
                    existingData.setOrgRevMtd(orgRevMtd);
                    existingData.setOrgRevLmtd(orgRevLmtd);
                    existingData.setOrgRevGrowth(orgRevGrowth);
                    existingData.setMoboNonTradeMtd(moboNonTradeMtd);
                    existingData.setMoboNonTradeLmtd(moboNonTradeLmtd);
                    existingData.setMoboNonTradeGrowth(moboNonTradeGrowth);
                    existingData.setMoboTradeMtd(moboTradeMtd);
                    existingData.setMoboTradeLmtd(moboTradeLmtd);
                    existingData.setMoboTradeGrowth(moboTradeGrowth);
                    existingData.setVasRevMtd(vasRevMtd);
                    existingData.setVasRevLmtd(vasRevLmtd);
                    existingData.setVasRevGrowth(vasRevGrowth);
                    existingData.setDataRevMtd(dataRevMtd);
                    existingData.setDataRevLmtd(dataRevLmtd);
                    existingData.setDataRevGrowth(dataRevGrowth);
                    existingData.setGaMtd(gaMtd);
                    existingData.setGaLmtd(gaLmtd);
                    existingData.setGaGrowth(gaGrowth);
                    existingData.setM2sMtd(m2sMtd);
                    existingData.setM2sLmtd(m2sLmtd);
                    existingData.setM2sGrowth(m2sGrowth);
                    existingData.setVlrMtd(vlrMtd);
                    existingData.setVlrLmtd(vlrLmtd);
                    existingData.setVlrGrowth(vlrGrowth);
                    existingData.setVlrPrepaidMtd(vlrPrepaidMtd);
                    existingData.setVlrPrepaidLmtd(vlrPrepaidLmtd);
                    existingData.setVlrPrepaidGrowth(vlrPrepaidGrowth);
                    existingData.setVlrPostpaidMtd(vlrPostpaidMtd);
                    existingData.setVlrPostpaidLmtd(vlrPostpaidLmtd);
                    existingData.setVlrPostpaidGrowth(vlrPostpaidGrowth);
                    existingData.setRgu90Mtd(rgu90Mtd);
                    existingData.setRgu90Lmtd(rgu90Lmtd);
                    existingData.setRgu90Growth(rgu90Growth);
                    existingData.setRgu30Mtd(rgu30Mtd);
                    existingData.setRgu30Lmtd(rgu30Lmtd);
                    existingData.setRgu30Growth(rgu30Growth);
                    existingData.setNetAdd90d(netAdd90d);
                    existingData.setNetAdd30d(netAdd30d);
                    existingData.setDailyUroMtd(dailyUroMtd);
                    existingData.setDailyUroLmtd(dailyUroLmtd);
                    existingData.setDailyUroGrowth(dailyUroGrowth);
                    existingData.setDailySsoMtd(dailySsoMtd);
                    existingData.setDailySsoLmtd(dailySsoLmtd);
                    existingData.setDailySsoGrowth(dailySsoGrowth);
                    existingData.setTertiaryBMtd(tertiaryBMtd);
                    existingData.setTertiaryBLmtd(tertiaryBLmtd);
                    existingData.setTertiaryBGrowth(tertiaryBGrowth);
                    existingData.setGrossMtdChurn90d(grossMtdChurn90d);
                    existingData.setGrossMtdChurn30d(grossMtdChurn30d);
                    existingData.setTradeSupplyMtd(tradeSupplyMtd);
                    existingData.setTradeSupplyLmtd(tradeSupplyLmtd);
                    existingData.setTradeSupplyGrowth(tradeSupplyGrowth);
                    existingData.setAcqRevMtd(acqRevMtd);
                    existingData.setAcqRevLmtd(acqRevLmtd);
                    existingData.setAcqRevGrowth(acqRevGrowth);
                    existingData.setTradeCvmRevMtd(tradeCvmRevMtd);
                    existingData.setTradeCvmRevLmtd(tradeCvmRevLmtd);
                    existingData.setTradeCvmRevGrowth(tradeCvmRevGrowth);
                    existingData.setTradeRebuyMtd(tradeRebuyMtd);
                    existingData.setTradeRebuyLmtd(tradeRebuyLmtd);
                    existingData.setTradeRebuyGrowth(tradeRebuyGrowth);
                    existingData.setTradeSpMtd(tradeSpMtd);
                    existingData.setTradeSpLmtd(tradeSpLmtd);
                    existingData.setTradeSpGrowth(tradeSpGrowth);
                    existingData.setQuroMtd(quroMtd);
                    existingData.setQuroLmtd(quroLmtd);
                    existingData.setQuroGrowth(quroGrowth);
                    existingData.setQssoMtd(qssoMtd);
                    existingData.setQssoLmtd(qssoLmtd);
                    existingData.setQssoGrowth(qssoGrowth);
                    existingData.setCreatedAt(createdAt); // Update createdAt
                    salesDataRepository.save(existingData); // Save updated data
                } else {
                    // Create a new SalesData object for new entries
                    SalesData newSalesData = new SalesData();
                    newSalesData.setId(id);
                    newSalesData.setSiteName(siteName);
                    newSalesData.setSalesArea(salesArea);
                    newSalesData.setArea(area);
                    newSalesData.setBrand(brand);
                    newSalesData.setTotRevMtd(totRevMtd);
                    newSalesData.setTotRevLmtd(totRevLmtd);
                    newSalesData.setTotRevGrowth(totRevGrowth);
                    newSalesData.setMoboMtd(moboMtd);
                    newSalesData.setMoboLmtd(moboLmtd);
                    newSalesData.setMoboGrowth(moboGrowth);
                    newSalesData.setOrgRevMtd(orgRevMtd);
                    newSalesData.setOrgRevLmtd(orgRevLmtd);
                    newSalesData.setOrgRevGrowth(orgRevGrowth);
                    newSalesData.setMoboNonTradeMtd(moboNonTradeMtd);
                    newSalesData.setMoboNonTradeLmtd(moboNonTradeLmtd);
                    newSalesData.setMoboNonTradeGrowth(moboNonTradeGrowth);
                    newSalesData.setMoboTradeMtd(moboTradeMtd);
                    newSalesData.setMoboTradeLmtd(moboTradeLmtd);
                    newSalesData.setMoboTradeGrowth(moboTradeGrowth);
                    newSalesData.setVasRevMtd(vasRevMtd);
                    newSalesData.setVasRevLmtd(vasRevLmtd);
                    newSalesData.setVasRevGrowth(vasRevGrowth);
                    newSalesData.setDataRevMtd(dataRevMtd);
                    newSalesData.setDataRevLmtd(dataRevLmtd);
                    newSalesData.setDataRevGrowth(dataRevGrowth);
                    newSalesData.setGaMtd(gaMtd);
                    newSalesData.setGaLmtd(gaLmtd);
                    newSalesData.setGaGrowth(gaGrowth);
                    newSalesData.setM2sMtd(m2sMtd);
                    newSalesData.setM2sLmtd(m2sLmtd);
                    newSalesData.setM2sGrowth(m2sGrowth);
                    newSalesData.setVlrMtd(vlrMtd);
                    newSalesData.setVlrLmtd(vlrLmtd);
                    newSalesData.setVlrGrowth(vlrGrowth);
                    newSalesData.setVlrPrepaidMtd(vlrPrepaidMtd);
                    newSalesData.setVlrPrepaidLmtd(vlrPrepaidLmtd);
                    newSalesData.setVlrPrepaidGrowth(vlrPrepaidGrowth);
                    newSalesData.setVlrPostpaidMtd(vlrPostpaidMtd);
                    newSalesData.setVlrPostpaidLmtd(vlrPostpaidLmtd);
                    newSalesData.setVlrPostpaidGrowth(vlrPostpaidGrowth);
                    newSalesData.setRgu90Mtd(rgu90Mtd);
                    newSalesData.setRgu90Lmtd(rgu90Lmtd);
                    newSalesData.setRgu90Growth(rgu90Growth);
                    newSalesData.setRgu30Mtd(rgu30Mtd);
                    newSalesData.setRgu30Lmtd(rgu30Lmtd);
                    newSalesData.setRgu30Growth(rgu30Growth);
                    newSalesData.setNetAdd90d(netAdd90d);
                    newSalesData.setNetAdd30d(netAdd30d);
                    newSalesData.setDailyUroMtd(dailyUroMtd);
                    newSalesData.setDailyUroLmtd(dailyUroLmtd);
                    newSalesData.setDailyUroGrowth(dailyUroGrowth);
                    newSalesData.setDailySsoMtd(dailySsoMtd);
                    newSalesData.setDailySsoLmtd(dailySsoLmtd);
                    newSalesData.setDailySsoGrowth(dailySsoGrowth);
                    newSalesData.setTertiaryBMtd(tertiaryBMtd);
                    newSalesData.setTertiaryBLmtd(tertiaryBLmtd);
                    newSalesData.setTertiaryBGrowth(tertiaryBGrowth);
                    newSalesData.setGrossMtdChurn90d(grossMtdChurn90d);
                    newSalesData.setGrossMtdChurn30d(grossMtdChurn30d);
                    newSalesData.setTradeSupplyMtd(tradeSupplyMtd);
                    newSalesData.setTradeSupplyLmtd(tradeSupplyLmtd);
                    newSalesData.setTradeSupplyGrowth(tradeSupplyGrowth);
                    newSalesData.setAcqRevMtd(acqRevMtd);
                    newSalesData.setAcqRevLmtd(acqRevLmtd);
                    newSalesData.setAcqRevGrowth(acqRevGrowth);
                    newSalesData.setTradeCvmRevMtd(tradeCvmRevMtd);
                    newSalesData.setTradeCvmRevLmtd(tradeCvmRevLmtd);
                    newSalesData.setTradeCvmRevGrowth(tradeCvmRevGrowth);
                    newSalesData.setTradeRebuyMtd(tradeRebuyMtd);
                    newSalesData.setTradeRebuyLmtd(tradeRebuyLmtd);
                    newSalesData.setTradeRebuyGrowth(tradeRebuyGrowth);
                    newSalesData.setTradeSpMtd(tradeSpMtd);
                    newSalesData.setTradeSpLmtd(tradeSpLmtd);
                    newSalesData.setTradeSpGrowth(tradeSpGrowth);
                    newSalesData.setQuroMtd(quroMtd);
                    newSalesData.setQuroLmtd(quroLmtd);
                    newSalesData.setQuroGrowth(quroGrowth);
                    newSalesData.setQssoMtd(qssoMtd);
                    newSalesData.setQssoLmtd(qssoLmtd);
                    newSalesData.setQssoGrowth(qssoGrowth);
                    newSalesData.setCreatedAt(createdAt); // Set createdAt for new entries

                    salesDataRepository.save(newSalesData); // Save new data
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error processing file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Upload successful!", HttpStatus.OK);
    }
    

}
