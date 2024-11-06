package com.example.Sales_Backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface SalesDataRepository extends JpaRepository<SalesData, Long> {
    // You can add custom query methods here if needed
	//First Column
    List<SalesData> findAll();
    @Query("SELECT AVG(sd.totRevLmtd) FROM SalesData sd")
    BigDecimal findTotalTotRevLmtdAll();

    @Query("SELECT s FROM SalesData s WHERE s.id = :id")
    SalesData findByIdOrNull(@Param("id") Long id);
    
    @Query("SELECT AVG(sd.totRevMtd) FROM SalesData sd")
    BigDecimal findTotalTotRevMtdAll();  
    
    @Query("SELECT AVG(sd.totRevGrowth)*100 FROM SalesData sd")
    BigDecimal findTotalTotRevGrowthAll();
    
    
    
    
    
    @Query("SELECT AVG(sd.vlrLmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalVlrLmtdAll(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.vlrMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalVlrMtdAll(@Param("createdAt") Date createdAt);
    
    @Query("SELECT AVG(sd.vlrGrowth)*100 FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalVlrGrowthAll(@Param("createdAt") Date createdAt);
    
    
    
//    Tandai
    @Query("SELECT AVG(sd.rgu90Mtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalrgu90LmtdAll(@Param("createdAt") Date createdAt);

    @Query("SELECT AVG(sd.rgu90Lmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalrgu90MtdAll(@Param("createdAt") Date createdAt);
    
    @Query("SELECT AVG(sd.rgu90Growth)*100 FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalrgu90GrowthAll(@Param("createdAt") Date createdAt);
    
    
    
    
    
    
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

    

    
    
    
    @Query("SELECT AVG(sd.vlrLmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalVlrLmtd(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);

    @Query("SELECT AVG(sd.vlrMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalVlrMtd(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);

    @Query("SELECT AVG(sd.vlrGrowth) * 100 FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalVlrGrowth(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);
    
    
    
    
    

    @Query("SELECT AVG(sd.rgu90Mtd) FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalrgu90Lmtd(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);

    @Query("SELECT AVG(sd.rgu90Lmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalrgu90Mtd(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);

    @Query("SELECT AVG(sd.rgu90Growth) * 100 FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalrgu90Growth(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);
    
    
    
    
    
    

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
//    @Query("SELECT AVG(sd.rgu90Mtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
//    BigDecimal findTotalrgu90LmtdAll(@Param("createdAt") Date createdAt);
    
    
    
    @Query("SELECT AVG(sd.quroGrowth) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalquroGrowthAll(@Param("createdAt") Date createdAt);
    
    @Query("SELECT AVG(sd.quroMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalquroMtdAll(@Param("createdAt") Date createdAt);
    
    @Query("SELECT AVG(sd.quroLmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalquroLmtdAll(@Param("createdAt") Date createdAt);
    
    
    
    @Query("SELECT AVG(sd.qssoGrowth) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalqssoGrowthAll(@Param("createdAt") Date createdAt);
    
    @Query("SELECT AVG(sd.qssoMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalqssoMtdAll(@Param("createdAt") Date createdAt);
    
    @Query("SELECT AVG(sd.qssoLmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt")
    BigDecimal findTotalqssoLmtdAll(@Param("createdAt") Date createdAt);
    
    
    
    
    
    
    
    
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

//    @Query("SELECT AVG(sd.vlrGrowth) * 100 FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
//    BigDecimal findTotalVlrGrowth(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);
    
    
    @Query("SELECT AVG(sd.quroLmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalquroLmtd(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);
    
    @Query("SELECT AVG(sd.quroGrowth) FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalquroGrowth(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);

    @Query("SELECT AVG(sd.quroMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalquroMtd(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);

    @Query("SELECT AVG(sd.qssoGrowth) FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalqssoGrowth(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);

    @Query("SELECT AVG(sd.qssoMtd) FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalqssoMtd(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);
    
    @Query("SELECT AVG(sd.qssoLmtd) FROM SalesData sd WHERE sd.createdAt = :createdAt AND sd.salesArea = :salesArea")
    BigDecimal findTotalqssoLmtd(@Param("createdAt") Date createdAt,@Param("salesArea") String salesArea);

    
    
    
    
    
    
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
    


    @Modifying
    @Transactional
    @Query("UPDATE SalesData s SET s.siteName = :siteName, s.salesArea = :salesArea, s.area = :area, s.brand = :brand, "
            + "s.totRevMtd = :totRevMtd, s.totRevLmtd = :totRevLmtd, s.totRevGrowth = :totRevGrowth, "
            + "s.moboMtd = :moboMtd, s.moboLmtd = :moboLmtd, s.moboGrowth = :moboGrowth, "
            + "s.orgRevMtd = :orgRevMtd, s.orgRevLmtd = :orgRevLmtd, s.orgRevGrowth = :orgRevGrowth, "
            + "s.moboNonTradeMtd = :moboNonTradeMtd, s.moboNonTradeLmtd = :moboNonTradeLmtd, s.moboNonTradeGrowth = :moboNonTradeGrowth, "
            + "s.moboTradeMtd = :moboTradeMtd, s.moboTradeLmtd = :moboTradeLmtd, s.moboTradeGrowth = :moboTradeGrowth, "
            + "s.vasRevMtd = :vasRevMtd, s.vasRevLmtd = :vasRevLmtd, s.vasRevGrowth = :vasRevGrowth, "
            + "s.dataRevMtd = :dataRevMtd, s.dataRevLmtd = :dataRevLmtd, s.dataRevGrowth = :dataRevGrowth, "
            + "s.gaMtd = :gaMtd, s.gaLmtd = :gaLmtd, s.gaGrowth = :gaGrowth, "
            + "s.m2sMtd = :m2sMtd, s.m2sLmtd = :m2sLmtd, s.m2sGrowth = :m2sGrowth, "
            + "s.vlrMtd = :vlrMtd, s.vlrLmtd = :vlrLmtd, s.vlrGrowth = :vlrGrowth, "
            + "s.vlrPrepaidMtd = :vlrPrepaidMtd, s.vlrPrepaidLmtd = :vlrPrepaidLmtd, s.vlrPrepaidGrowth = :vlrPrepaidGrowth, "
            + "s.vlrPostpaidMtd = :vlrPostpaidMtd, s.vlrPostpaidLmtd = :vlrPostpaidLmtd, s.vlrPostpaidGrowth = :vlrPostpaidGrowth, "
            + "s.rgu90Mtd = :rgu90Mtd, s.rgu90Lmtd = :rgu90Lmtd, s.rgu90Growth = :rgu90Growth, "
            + "s.rgu30Mtd = :rgu30Mtd, s.rgu30Lmtd = :rgu30Lmtd, s.rgu30Growth = :rgu30Growth, "
            + "s.netAdd90d = :netAdd90d, s.netAdd30d = :netAdd30d, "
            + "s.dailyUroMtd = :dailyUroMtd, s.dailyUroLmtd = :dailyUroLmtd, s.dailyUroGrowth = :dailyUroGrowth, "
            + "s.dailySsoMtd = :dailySsoMtd, s.dailySsoLmtd = :dailySsoLmtd, s.dailySsoGrowth = :dailySsoGrowth, "
            + "s.tertiaryBMtd = :tertiaryBMtd, s.tertiaryBLmtd = :tertiaryBLmtd, s.tertiaryBGrowth = :tertiaryBGrowth, "
            + "s.grossMtdChurn90d = :grossMtdChurn90d, s.grossMtdChurn30d = :grossMtdChurn30d, "
            + "s.tradeSupplyMtd = :tradeSupplyMtd, s.tradeSupplyLmtd = :tradeSupplyLmtd, s.tradeSupplyGrowth = :tradeSupplyGrowth, "
            + "s.acqRevMtd = :acqRevMtd, s.acqRevLmtd = :acqRevLmtd, s.acqRevGrowth = :acqRevGrowth, "
            + "s.tradeCvmRevMtd = :tradeCvmRevMtd, s.tradeCvmRevLmtd = :tradeCvmRevLmtd, s.tradeCvmRevGrowth = :tradeCvmRevGrowth, "
            + "s.tradeRebuyMtd = :tradeRebuyMtd, s.tradeRebuyLmtd = :tradeRebuyLmtd, s.tradeRebuyGrowth = :tradeRebuyGrowth, "
            + "s.tradeSpMtd = :tradeSpMtd, s.tradeSpLmtd = :tradeSpLmtd, s.tradeSpGrowth = :tradeSpGrowth, "
            + "s.quroMtd = :quroMtd, s.quroLmtd = :quroLmtd, s.quroGrowth = :quroGrowth, "
            + "s.qssoMtd = :qssoMtd, s.qssoLmtd = :qssoLmtd, s.qssoGrowth = :qssoGrowth, "
            + "s.createdAt = :createdAt WHERE s.id = :id")
    void updateSalesData(Long id, String siteName, String salesArea, String area, String brand,
                         BigDecimal totRevMtd, BigDecimal totRevLmtd, BigDecimal totRevGrowth,
                         BigDecimal moboMtd, BigDecimal moboLmtd, BigDecimal moboGrowth,
                         BigDecimal orgRevMtd, BigDecimal orgRevLmtd, BigDecimal orgRevGrowth,
                         BigDecimal moboNonTradeMtd, BigDecimal moboNonTradeLmtd, BigDecimal moboNonTradeGrowth,
                         BigDecimal moboTradeMtd, BigDecimal moboTradeLmtd, BigDecimal moboTradeGrowth,
                         BigDecimal vasRevMtd, BigDecimal vasRevLmtd, BigDecimal vasRevGrowth,
                         BigDecimal dataRevMtd, BigDecimal dataRevLmtd, BigDecimal dataRevGrowth,
                         Long gaMtd, Long gaLmtd, BigDecimal gaGrowth,
                         Long m2sMtd, Long m2sLmtd, BigDecimal m2sGrowth,
                         BigDecimal vlrMtd, BigDecimal vlrLmtd, BigDecimal vlrGrowth,
                         BigDecimal vlrPrepaidMtd, BigDecimal vlrPrepaidLmtd, BigDecimal vlrPrepaidGrowth,
                         BigDecimal vlrPostpaidMtd, BigDecimal vlrPostpaidLmtd, BigDecimal vlrPostpaidGrowth,
                         BigDecimal rgu90Mtd, BigDecimal rgu90Lmtd, BigDecimal rgu90Growth,
                         BigDecimal rgu30Mtd, BigDecimal rgu30Lmtd, BigDecimal rgu30Growth,
                         BigDecimal netAdd90d, BigDecimal netAdd30d,
                         BigDecimal dailyUroMtd, BigDecimal dailyUroLmtd, BigDecimal dailyUroGrowth,
                         BigDecimal dailySsoMtd, BigDecimal dailySsoLmtd, BigDecimal dailySsoGrowth,
                         BigDecimal tertiaryBMtd, BigDecimal tertiaryBLmtd, BigDecimal tertiaryBGrowth,
                         BigDecimal grossMtdChurn90d, BigDecimal grossMtdChurn30d,
                         BigDecimal tradeSupplyMtd, BigDecimal tradeSupplyLmtd, BigDecimal tradeSupplyGrowth,
                         BigDecimal acqRevMtd, BigDecimal acqRevLmtd, BigDecimal acqRevGrowth,
                         BigDecimal tradeCvmRevMtd, BigDecimal tradeCvmRevLmtd, BigDecimal tradeCvmRevGrowth,
                         BigDecimal tradeRebuyMtd, BigDecimal tradeRebuyLmtd, BigDecimal tradeRebuyGrowth,
                         BigDecimal tradeSpMtd, BigDecimal tradeSpLmtd, BigDecimal tradeSpGrowth,
                         BigDecimal quroMtd, BigDecimal quroLmtd, BigDecimal quroGrowth,
                         BigDecimal qssoMtd, BigDecimal qssoLmtd, BigDecimal qssoGrowth,
                         Date createdAt);
    
   


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