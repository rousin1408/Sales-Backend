package com.example.Sales_Backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesDataRepository extends JpaRepository<SalesData, Long> {
    // You can add custom query methods here if needed
	//First Column
    List<SalesData> findAll();
    @Query("SELECT AVG(sd.totRevLmtd) FROM SalesData sd")
    BigDecimal findTotalTotRevLmtdAll();

    @Query("SELECT AVG(sd.totRevMtd) FROM SalesData sd")
    BigDecimal findTotalTotRevMtdAll();  
    
    @Query("SELECT AVG(sd.totRevGrowth)*100 FROM SalesData sd")
    BigDecimal findTotalTotRevGrowthAll();
    
    
    
    @Query("SELECT AVG(sd.vlrLmtd) FROM SalesData sd")
    BigDecimal findTotalVlrLmtdAll();

    @Query("SELECT AVG(sd.vlrMtd) FROM SalesData sd")
    BigDecimal findTotalVlrMtdAll();
    
    @Query("SELECT AVG(sd.vlrGrowth)*100 FROM SalesData sd")
    BigDecimal findTotalVlrGrowthAll();
    
    
    @Query("SELECT AVG(sd.rgu90Mtd) FROM SalesData sd")
    BigDecimal findTotalrgu90LmtdAll();

    @Query("SELECT AVG(sd.rgu90Lmtd) FROM SalesData sd")
    BigDecimal findTotalrgu90MtdAll();
    
    @Query("SELECT AVG(sd.rgu90Growth)*100 FROM SalesData sd")
    BigDecimal findTotalrgu90GrowthAll();
    
    
    @Query("SELECT AVG(sd.netAdd90d) FROM SalesData sd")
    BigDecimal findTotalnetAdd90dAll();

    @Query("SELECT AVG(sd.netAdd30d) FROM SalesData sd")
    BigDecimal findTotalnetAdd30dAll();
    
    @Query("SELECT AVG(sd.grossMtdChurn90d) FROM SalesData sd")
    BigDecimal findTotalgrossMtdChurn90dAll();

    @Query("SELECT AVG(sd.grossMtdChurn30d) FROM SalesData sd")
    BigDecimal findTotalgrossMtdChurn30dAll();
    
    
    @Query("SELECT AVG(sd.totRevLmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalTotRevLmtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.totRevMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalTotRevMtdAll(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.totRevMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalTotRevMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.totRevGrowth) * 100 FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalTotRevGrowth(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.vlrLmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalVlrLmtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.vlrMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalVlrMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.vlrGrowth) * 100 FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalVlrGrowth(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.rgu90Mtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalrgu90Lmtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.rgu90Lmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalrgu90Mtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.rgu90Growth) * 100 FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalrgu90Growth(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.netAdd90d) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalnetAdd90d(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.netAdd30d) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalnetAdd30d(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.grossMtdChurn90d) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalgrossMtdChurn90d(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.grossMtdChurn30d) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalgrossMtdChurn30d(@Param("createdAt") Date createdAt);
    //Second Column
    @Query("SELECT AVG(sd.dailyUroGrowth) FROM SalesData sd")
    BigDecimal findTotaldailyUroGrowthAll();
    
    @Query("SELECT AVG(sd.dailySsoGrowth) FROM SalesData sd")
    BigDecimal findTotaldailySsoGrowthAll();
    
    
    @Query("SELECT AVG(sd.quroGrowth) FROM SalesData sd")
    BigDecimal findTotalquroGrowthAll();
    
    @Query("SELECT AVG(sd.quroMtd) FROM SalesData sd")
    BigDecimal findTotalquroMtdAll();
    
    @Query("SELECT AVG(sd.qssoGrowth) FROM SalesData sd")
    BigDecimal findTotalqssoGrowthAll();
    
    @Query("SELECT AVG(sd.qssoMtd) FROM SalesData sd")
    BigDecimal findTotalqssoMtdAll();
    
    @Query("SELECT AVG(sd.moboMtd) FROM SalesData sd")
    BigDecimal findTotalmoboMtdAll();
    
    @Query("SELECT AVG(sd.dataRevMtd) FROM SalesData sd")
    BigDecimal findTotaldataRevMtdAll();
    
    @Query("SELECT AVG(sd.vasRevMtd) FROM SalesData sd")
    BigDecimal findTotalvasRevMtdAll();
    
    @Query("SELECT AVG(sd.moboTradeMtd) FROM SalesData sd")
    BigDecimal findTotalMoboTradeMtdAll();
    
    @Query("SELECT AVG(sd.moboNonTradeMtd) FROM SalesData sd")
    BigDecimal findTotalMoboNonTradeMtdAll();
    
    @Query("SELECT AVG(sd.orgRevMtd) FROM SalesData sd")
    BigDecimal findTotalorgRevMtdAll();
    
    
    @Query("SELECT AVG(sd.dailyUroGrowth) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotaldailyUroGrowth(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.dailySsoGrowth) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotaldailySsoGrowth(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.quroGrowth) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalquroGrowth(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.quroMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalquroMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.qssoGrowth) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalqssoGrowth(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.qssoMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalqssoMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.moboMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalmoboMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.dataRevMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotaldataRevMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.vasRevMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalvasRevMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.moboTradeMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalMoboTradeMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.moboNonTradeMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalMoboNonTradeMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.orgRevMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalorgRevMtd(@Param("createdAt") Date createdAt);

    
    

    @Query("SELECT AVG(sd.totRevMtd) FROM SalesData sd where sd.area LIKE 'SOUTH CENTRAL JAVA'")
    BigDecimal findTotalRevenueMtdSouthAll();
    
    @Query("SELECT AVG(sd.totRevMtd) FROM SalesData sd where sd.area LIKE 'SOUTH CENTRAL JAVA' AND sd.createdAt = :createdAt")
    BigDecimal findTotalRevenueMtdSouth(@Param("createdAt") Date createdAt);
    
    @Query("SELECT AVG(sd.totRevMtd) FROM SalesData sd where sd.area LIKE 'NORTH CENTRAL JAVA'")
    BigDecimal findTotalRevenueMtdNorthAll();
    
    @Query("SELECT AVG(sd.totRevMtd) FROM SalesData sd where sd.area LIKE 'NORTH CENTRAL JAVA' AND sd.createdAt = :createdAt")
    BigDecimal findTotalRevenueMtdNorth(@Param("createdAt") Date createdAt);
    
    
    
    
    @Query("SELECT AVG(sd.tradeSupplyMtd) FROM SalesData sd")
    BigDecimal findTotalTradeSupplyMtdAll();
    
    @Query("SELECT AVG(sd.tradeSpMtd) FROM SalesData sd")
    BigDecimal findTotalTradeSpMtdAll();

    @Query("SELECT AVG(sd.tradeCvmRevMtd) FROM SalesData sd")
    BigDecimal findTotalTradeCvmRevMtdAll();
    
    @Query("SELECT AVG(sd.tradeRebuyMtd) FROM SalesData sd")
    BigDecimal findTotaltradeRebuyMtdAll();
    
    @Query("SELECT AVG(sd.tradeSupplyMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalTradeSupplyMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.tradeSpMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalTradeSpMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.tradeCvmRevMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalTradeCvmRevMtd(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.tradeRebuyMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotaltradeRebuyMtd(@Param("createdAt") Date createdAt);

    
    @Query(value = "SELECT sd.salesArea AS salesArea, AVG(sd.totRevLmtd) AS averageRevenue FROM SalesData sd GROUP BY sd.salesArea ")
    List<SalesDataBranch> getSalesDataAll();
    
    @Query("SELECT sd.salesArea AS salesArea, AVG(sd.totRevLmtd) AS averageRevenue FROM SalesData sd WHERE sd.createdAt = :createdAt GROUP BY sd.salesArea")
    List<SalesDataBranch> getSalesData(@Param("createdAt") Date createdAt);
    
    @Query(value = "SELECT sd.salesArea AS salesArea, AVG(sd.totRevLmtd) AS averageRevenue " +
            "FROM SalesData sd " +
            "GROUP BY sd.salesArea " +
            "ORDER BY AVG(sd.totRevLmtd) ASC LIMIT 1")
    List<SalesDataBranch> getLowestAll();
    
    @Query(value = "SELECT sd.salesArea AS salesArea, AVG(sd.totRevLmtd) AS averageRevenue " +
            "FROM SalesData sd " +
            "GROUP BY sd.salesArea " +
            "ORDER BY AVG(sd.totRevLmtd) DESC LIMIT 1")
    List<SalesDataBranch> getHighestAll();

    @Query(value = "SELECT sd.salesArea AS salesArea, AVG(sd.totRevLmtd) AS averageRevenue " +
            "FROM SalesData sd WHERE sd.createdAt = :createdAt " +
            "GROUP BY sd.salesArea " +
            "ORDER BY AVG(sd.totRevLmtd) ASC LIMIT 1")
    List<SalesDataBranch> getLowest(@Param("createdAt") Date createdAt);
    
    @Query(value = "SELECT sd.salesArea AS salesArea, AVG(sd.totRevLmtd) AS averageRevenue " +
            "FROM SalesData sd WHERE sd.createdAt = :createdAt " +
            "GROUP BY sd.salesArea " +
            "ORDER BY AVG(sd.totRevLmtd) DESC LIMIT 1")
    List<SalesDataBranch> getHighest(@Param("createdAt") Date createdAt);

    // Query to fetch distinct 'created_at' values
    @Query("SELECT DISTINCT sd.createdAt FROM SalesData sd ORDER BY sd.createdAt DESC")
    List<Date>findDistinctCreatedAt();


//    SELECT 
//    sales_area AS salesArea, 
//    AVG(tot_rev_lmtd) AS averageRevenue 
//FROM 
//    sales_data 
//GROUP BY 
//    sales_area 
//ORDER BY 
//    averageRevenue ASC
//LIMIT 1;
 
//    SELECT AVG(tot_rev_mtd) AS avgTotRevMtd FROM public.sales_data where area LIKE 'SOUTH CENTRAL JAVA';
//    SELECT AVG(tot_rev_mtd) ASavgTotRevMtd FROM public.sales_data where area LIKE 'NORTH CENTRAL JAVA';


    
}