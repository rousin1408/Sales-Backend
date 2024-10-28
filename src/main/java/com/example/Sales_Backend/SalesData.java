package com.example.Sales_Backend;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales_data")
public class SalesData {
	 	@Id
	    private Long id;

	    @Column(name = "site_name")
	    private String siteName;

	    @Column(name = "sales_area")
	    private String salesArea;

	    @Column(name = "area")
	    private String area;

	    @Column(name = "brand")
	    private String brand;

	    @Column(name = "tot_rev_mtd")
	    private BigDecimal totRevMtd;

	    @Column(name = "tot_rev_lmtd")
	    private BigDecimal totRevLmtd;

	    @Column(name = "tot_rev_growth")
	    private BigDecimal totRevGrowth;

	    @Column(name = "mobo_mtd")
	    private BigDecimal moboMtd;

	    @Column(name = "mobo_lmtd")
	    private BigDecimal moboLmtd;

	    @Column(name = "mobo_growth")
	    private BigDecimal moboGrowth;

	    @Column(name = "org_rev_mtd")
	    private BigDecimal orgRevMtd;

	    @Column(name = "org_rev_lmtd")
	    private BigDecimal orgRevLmtd;

	    @Column(name = "org_rev_growth")
	    private BigDecimal orgRevGrowth;

	    @Column(name = "mobo_non_trade_mtd")
	    private BigDecimal moboNonTradeMtd;

	    @Column(name = "mobo_non_trade_lmtd")
	    private BigDecimal moboNonTradeLmtd;

	    @Column(name = "mobo_non_trade_growth")
	    private BigDecimal moboNonTradeGrowth;

	    @Column(name = "mobo_trade_mtd")
	    private BigDecimal moboTradeMtd;

	    @Column(name = "mobo_trade_lmtd")
	    private BigDecimal moboTradeLmtd;

	    @Column(name = "mobo_trade_growth")
	    private BigDecimal moboTradeGrowth;

	    @Column(name = "vas_rev_mtd")
	    private BigDecimal vasRevMtd;

	    @Column(name = "vas_rev_lmtd")
	    private BigDecimal vasRevLmtd;

	    @Column(name = "vas_rev_growth")
	    private BigDecimal vasRevGrowth;

	    @Column(name = "data_rev_mtd")
	    private BigDecimal dataRevMtd;

	    @Column(name = "data_rev_lmtd")
	    private BigDecimal dataRevLmtd;

	    @Column(name = "data_rev_growth")
	    private BigDecimal dataRevGrowth;

	    @Column(name = "ga_mtd")
	    private Long gaMtd;

	    @Column(name = "ga_lmtd")
	    private Long gaLmtd;

	    @Column(name = "ga_growth")
	    private BigDecimal gaGrowth;

	    @Column(name = "m2s_mtd")
	    private Long m2sMtd;

	    @Column(name = "m2s_lmtd")
	    private Long m2sLmtd;

	    @Column(name = "m2s_growth")
	    private BigDecimal m2sGrowth;

	    @Column(name = "vlr_mtd")
	    private BigDecimal vlrMtd;

	    @Column(name = "vlr_lmtd")
	    private BigDecimal vlrLmtd;

	    @Column(name = "vlr_growth")
	    private BigDecimal vlrGrowth;

	    @Column(name = "vlr_prepaid_mtd")
	    private BigDecimal vlrPrepaidMtd;

	    @Column(name = "vlr_prepaid_lmtd")
	    private BigDecimal vlrPrepaidLmtd;

	    @Column(name = "vlr_prepaid_growth")
	    private BigDecimal vlrPrepaidGrowth;

	    @Column(name = "vlr_postpaid_mtd")
	    private BigDecimal vlrPostpaidMtd;

	    @Column(name = "vlr_postpaid_lmtd")
	    private BigDecimal vlrPostpaidLmtd;

	    @Column(name = "vlr_postpaid_growth")
	    private BigDecimal vlrPostpaidGrowth;

	    @Column(name = "rgu90_mtd")
	    private BigDecimal rgu90Mtd;

	    @Column(name = "rgu90_lmtd")
	    private BigDecimal rgu90Lmtd;

	    @Column(name = "rgu90_growth")
	    private BigDecimal rgu90Growth;

	    @Column(name = "rgu30_mtd")
	    private BigDecimal rgu30Mtd;

	    @Column(name = "rgu30_lmtd")
	    private BigDecimal rgu30Lmtd;

	    @Column(name = "rgu30_growth")
	    private BigDecimal rgu30Growth;

	    @Column(name = "net_add_90d")
	    private BigDecimal netAdd90d;

	    @Column(name = "net_add_30d")
	    private BigDecimal netAdd30d;

	    @Column(name = "daily_uro_mtd")
	    private BigDecimal dailyUroMtd;

	    @Column(name = "daily_uro_lmtd")
	    private BigDecimal dailyUroLmtd;

	    @Column(name = "daily_uro_growth")
	    private BigDecimal dailyUroGrowth;

	    @Column(name = "daily_sso_mtd")
	    private BigDecimal dailySsoMtd;

	    @Column(name = "daily_sso_lmtd")
	    private BigDecimal dailySsoLmtd;

	    @Column(name = "daily_sso_growth")
	    private BigDecimal dailySsoGrowth;

	    @Column(name = "tertiary_b_mtd")
	    private BigDecimal tertiaryBMtd;

	    @Column(name = "tertiary_b_lmtd")
	    private BigDecimal tertiaryBLmtd;

	    @Column(name = "tertiary_b_growth")
	    private BigDecimal tertiaryBGrowth;

	    @Column(name = "gross_mtd_churn_90d")
	    private BigDecimal grossMtdChurn90d;

	    @Column(name = "gross_mtd_churn_30d")
	    private BigDecimal grossMtdChurn30d;

	    @Column(name = "trade_supply_mtd")
	    private BigDecimal tradeSupplyMtd;

	    @Column(name = "trade_supply_lmtd")
	    private BigDecimal tradeSupplyLmtd;

	    @Column(name = "trade_supply_growth")
	    private BigDecimal tradeSupplyGrowth;

	    @Column(name = "acq_rev_mtd")
	    private BigDecimal acqRevMtd;

	    @Column(name = "acq_rev_lmtd")
	    private BigDecimal acqRevLmtd;

	    @Column(name = "acq_rev_growth")
	    private BigDecimal acqRevGrowth;

	    @Column(name = "trade_cvm_rev_mtd")
	    private BigDecimal tradeCvmRevMtd;

	    @Column(name = "trade_cvm_rev_lmtd")
	    private BigDecimal tradeCvmRevLmtd;

	    @Column(name = "trade_cvm_rev_growth")
	    private BigDecimal tradeCvmRevGrowth;

	    @Column(name = "trade_rebuy_mtd")
	    private BigDecimal tradeRebuyMtd;

	    @Column(name = "trade_rebuy_lmtd")
	    private BigDecimal tradeRebuyLmtd;

	    @Column(name = "trade_rebuy_growth")
	    private BigDecimal tradeRebuyGrowth;

	    @Column(name = "trade_sp_mtd")
	    private BigDecimal tradeSpMtd;

	    @Column(name = "trade_sp_lmtd")
	    private BigDecimal tradeSpLmtd;

	    @Column(name = "trade_sp_growth")
	    private BigDecimal tradeSpGrowth;

	    @Column(name = "quro_mtd")
	    private BigDecimal quroMtd;

	    @Column(name = "quro_lmtd")
	    private BigDecimal quroLmtd;

	    @Column(name = "quro_growth")
	    private BigDecimal quroGrowth;

	    @Column(name = "qsso_mtd")
	    private BigDecimal qssoMtd;

	    @Column(name = "qsso_lmtd")
	    private BigDecimal qssoLmtd;

	    @Column(name = "qsso_growth")
	    private BigDecimal qssoGrowth;
	    
	    @Column(name = "created_at")
	    private Date createdAt;
	    
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Long getId() {
			return id;
		}
		public String getSiteName() {
			return siteName;
		}
		public String getSalesArea() {
			return salesArea;
		}
		public String getArea() {
			return area;
		}
		public String getBrand() {
			return brand;
		}
		public BigDecimal getTotRevMtd() {
			return totRevMtd;
		}
		public BigDecimal getTotRevLmtd() {
			return totRevLmtd;
		}
		public BigDecimal getTotRevGrowth() {
			return totRevGrowth;
		}
		public BigDecimal getMoboMtd() {
			return moboMtd;
		}
		public BigDecimal getMoboLmtd() {
			return moboLmtd;
		}
		public BigDecimal getMoboGrowth() {
			return moboGrowth;
		}
		public BigDecimal getOrgRevMtd() {
			return orgRevMtd;
		}
		public BigDecimal getOrgRevLmtd() {
			return orgRevLmtd;
		}
		public BigDecimal getOrgRevGrowth() {
			return orgRevGrowth;
		}
		public BigDecimal getMoboNonTradeMtd() {
			return moboNonTradeMtd;
		}
		public BigDecimal getMoboNonTradeLmtd() {
			return moboNonTradeLmtd;
		}
		public BigDecimal getMoboNonTradeGrowth() {
			return moboNonTradeGrowth;
		}
		public BigDecimal getMoboTradeMtd() {
			return moboTradeMtd;
		}
		public BigDecimal getMoboTradeLmtd() {
			return moboTradeLmtd;
		}
		public BigDecimal getMoboTradeGrowth() {
			return moboTradeGrowth;
		}
		public BigDecimal getVasRevMtd() {
			return vasRevMtd;
		}
		public BigDecimal getVasRevLmtd() {
			return vasRevLmtd;
		}
		public BigDecimal getVasRevGrowth() {
			return vasRevGrowth;
		}
		public BigDecimal getDataRevMtd() {
			return dataRevMtd;
		}
		public BigDecimal getDataRevLmtd() {
			return dataRevLmtd;
		}
		public BigDecimal getDataRevGrowth() {
			return dataRevGrowth;
		}
		public Long getGaMtd() {
			return gaMtd;
		}
		public Long getGaLmtd() {
			return gaLmtd;
		}
		public BigDecimal getGaGrowth() {
			return gaGrowth;
		}
		public Long getM2sMtd() {
			return m2sMtd;
		}
		public Long getM2sLmtd() {
			return m2sLmtd;
		}
		public BigDecimal getM2sGrowth() {
			return m2sGrowth;
		}
		public BigDecimal getVlrMtd() {
			return vlrMtd;
		}
		public BigDecimal getVlrLmtd() {
			return vlrLmtd;
		}
		public BigDecimal getVlrGrowth() {
			return vlrGrowth;
		}
		public BigDecimal getVlrPrepaidMtd() {
			return vlrPrepaidMtd;
		}
		public BigDecimal getVlrPrepaidLmtd() {
			return vlrPrepaidLmtd;
		}
		public BigDecimal getVlrPrepaidGrowth() {
			return vlrPrepaidGrowth;
		}
		public BigDecimal getVlrPostpaidMtd() {
			return vlrPostpaidMtd;
		}
		public BigDecimal getVlrPostpaidLmtd() {
			return vlrPostpaidLmtd;
		}
		public BigDecimal getVlrPostpaidGrowth() {
			return vlrPostpaidGrowth;
		}
		public BigDecimal getRgu90Mtd() {
			return rgu90Mtd;
		}
		public BigDecimal getRgu90Lmtd() {
			return rgu90Lmtd;
		}
		public BigDecimal getRgu90Growth() {
			return rgu90Growth;
		}
		public BigDecimal getRgu30Mtd() {
			return rgu30Mtd;
		}
		public BigDecimal getRgu30Lmtd() {
			return rgu30Lmtd;
		}
		public BigDecimal getRgu30Growth() {
			return rgu30Growth;
		}
		public BigDecimal getNetAdd90d() {
			return netAdd90d;
		}
		public BigDecimal getNetAdd30d() {
			return netAdd30d;
		}
		public BigDecimal getDailyUroMtd() {
			return dailyUroMtd;
		}
		public BigDecimal getDailyUroLmtd() {
			return dailyUroLmtd;
		}
		public BigDecimal getDailyUroGrowth() {
			return dailyUroGrowth;
		}
		public BigDecimal getDailySsoMtd() {
			return dailySsoMtd;
		}
		public BigDecimal getDailySsoLmtd() {
			return dailySsoLmtd;
		}
		public BigDecimal getDailySsoGrowth() {
			return dailySsoGrowth;
		}
		public BigDecimal getTertiaryBMtd() {
			return tertiaryBMtd;
		}
		public BigDecimal getTertiaryBLmtd() {
			return tertiaryBLmtd;
		}
		public BigDecimal getTertiaryBGrowth() {
			return tertiaryBGrowth;
		}
		public BigDecimal getGrossMtdChurn90d() {
			return grossMtdChurn90d;
		}
		public BigDecimal getGrossMtdChurn30d() {
			return grossMtdChurn30d;
		}
		public BigDecimal getTradeSupplyMtd() {
			return tradeSupplyMtd;
		}
		public BigDecimal getTradeSupplyLmtd() {
			return tradeSupplyLmtd;
		}
		public BigDecimal getTradeSupplyGrowth() {
			return tradeSupplyGrowth;
		}
		public BigDecimal getAcqRevMtd() {
			return acqRevMtd;
		}
		public BigDecimal getAcqRevLmtd() {
			return acqRevLmtd;
		}
		public BigDecimal getAcqRevGrowth() {
			return acqRevGrowth;
		}
		public BigDecimal getTradeCvmRevMtd() {
			return tradeCvmRevMtd;
		}
		public BigDecimal getTradeCvmRevLmtd() {
			return tradeCvmRevLmtd;
		}
		public BigDecimal getTradeCvmRevGrowth() {
			return tradeCvmRevGrowth;
		}
		public BigDecimal getTradeRebuyMtd() {
			return tradeRebuyMtd;
		}
		public BigDecimal getTradeRebuyLmtd() {
			return tradeRebuyLmtd;
		}
		public BigDecimal getTradeRebuyGrowth() {
			return tradeRebuyGrowth;
		}
		public BigDecimal getTradeSpMtd() {
			return tradeSpMtd;
		}
		public BigDecimal getTradeSpLmtd() {
			return tradeSpLmtd;
		}
		public BigDecimal getTradeSpGrowth() {
			return tradeSpGrowth;
		}
		public BigDecimal getQuroMtd() {
			return quroMtd;
		}
		public BigDecimal getQuroLmtd() {
			return quroLmtd;
		}
		public BigDecimal getQuroGrowth() {
			return quroGrowth;
		}
		public BigDecimal getQssoMtd() {
			return qssoMtd;
		}
		public BigDecimal getQssoLmtd() {
			return qssoLmtd;
		}
		public BigDecimal getQssoGrowth() {
			return qssoGrowth;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setSiteName(String siteName) {
			this.siteName = siteName;
		}
		public void setSalesArea(String salesArea) {
			this.salesArea = salesArea;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public void setTotRevMtd(BigDecimal totRevMtd) {
			this.totRevMtd = totRevMtd;
		}
		public void setTotRevLmtd(BigDecimal totRevLmtd) {
			this.totRevLmtd = totRevLmtd;
		}
		public void setTotRevGrowth(BigDecimal totRevGrowth) {
			this.totRevGrowth = totRevGrowth;
		}
		public void setMoboMtd(BigDecimal moboMtd) {
			this.moboMtd = moboMtd;
		}
		public void setMoboLmtd(BigDecimal moboLmtd) {
			this.moboLmtd = moboLmtd;
		}
		public void setMoboGrowth(BigDecimal moboGrowth) {
			this.moboGrowth = moboGrowth;
		}
		public void setOrgRevMtd(BigDecimal orgRevMtd) {
			this.orgRevMtd = orgRevMtd;
		}
		public void setOrgRevLmtd(BigDecimal orgRevLmtd) {
			this.orgRevLmtd = orgRevLmtd;
		}
		public void setOrgRevGrowth(BigDecimal orgRevGrowth) {
			this.orgRevGrowth = orgRevGrowth;
		}
		public void setMoboNonTradeMtd(BigDecimal moboNonTradeMtd) {
			this.moboNonTradeMtd = moboNonTradeMtd;
		}
		public void setMoboNonTradeLmtd(BigDecimal moboNonTradeLmtd) {
			this.moboNonTradeLmtd = moboNonTradeLmtd;
		}
		public void setMoboNonTradeGrowth(BigDecimal moboNonTradeGrowth) {
			this.moboNonTradeGrowth = moboNonTradeGrowth;
		}
		public void setMoboTradeMtd(BigDecimal moboTradeMtd) {
			this.moboTradeMtd = moboTradeMtd;
		}
		public void setMoboTradeLmtd(BigDecimal moboTradeLmtd) {
			this.moboTradeLmtd = moboTradeLmtd;
		}
		public void setMoboTradeGrowth(BigDecimal moboTradeGrowth) {
			this.moboTradeGrowth = moboTradeGrowth;
		}
		public void setVasRevMtd(BigDecimal vasRevMtd) {
			this.vasRevMtd = vasRevMtd;
		}
		public void setVasRevLmtd(BigDecimal vasRevLmtd) {
			this.vasRevLmtd = vasRevLmtd;
		}
		public void setVasRevGrowth(BigDecimal vasRevGrowth) {
			this.vasRevGrowth = vasRevGrowth;
		}
		public void setDataRevMtd(BigDecimal dataRevMtd) {
			this.dataRevMtd = dataRevMtd;
		}
		public void setDataRevLmtd(BigDecimal dataRevLmtd) {
			this.dataRevLmtd = dataRevLmtd;
		}
		public void setDataRevGrowth(BigDecimal dataRevGrowth) {
			this.dataRevGrowth = dataRevGrowth;
		}
		public void setGaMtd(Long gaMtd) {
			this.gaMtd = gaMtd;
		}
		public void setGaLmtd(Long gaLmtd) {
			this.gaLmtd = gaLmtd;
		}
		public void setGaGrowth(BigDecimal gaGrowth) {
			this.gaGrowth = gaGrowth;
		}
		public void setM2sMtd(Long m2sMtd) {
			this.m2sMtd = m2sMtd;
		}
		public void setM2sLmtd(Long m2sLmtd) {
			this.m2sLmtd = m2sLmtd;
		}
		public void setM2sGrowth(BigDecimal m2sGrowth) {
			this.m2sGrowth = m2sGrowth;
		}
		public void setVlrMtd(BigDecimal vlrMtd) {
			this.vlrMtd = vlrMtd;
		}
		public void setVlrLmtd(BigDecimal vlrLmtd) {
			this.vlrLmtd = vlrLmtd;
		}
		public void setVlrGrowth(BigDecimal vlrGrowth) {
			this.vlrGrowth = vlrGrowth;
		}
		public void setVlrPrepaidMtd(BigDecimal vlrPrepaidMtd) {
			this.vlrPrepaidMtd = vlrPrepaidMtd;
		}
		public void setVlrPrepaidLmtd(BigDecimal vlrPrepaidLmtd) {
			this.vlrPrepaidLmtd = vlrPrepaidLmtd;
		}
		public void setVlrPrepaidGrowth(BigDecimal vlrPrepaidGrowth) {
			this.vlrPrepaidGrowth = vlrPrepaidGrowth;
		}
		public void setVlrPostpaidMtd(BigDecimal vlrPostpaidMtd) {
			this.vlrPostpaidMtd = vlrPostpaidMtd;
		}
		public void setVlrPostpaidLmtd(BigDecimal vlrPostpaidLmtd) {
			this.vlrPostpaidLmtd = vlrPostpaidLmtd;
		}
		public void setVlrPostpaidGrowth(BigDecimal vlrPostpaidGrowth) {
			this.vlrPostpaidGrowth = vlrPostpaidGrowth;
		}
		public void setRgu90Mtd(BigDecimal rgu90Mtd) {
			this.rgu90Mtd = rgu90Mtd;
		}
		public void setRgu90Lmtd(BigDecimal rgu90Lmtd) {
			this.rgu90Lmtd = rgu90Lmtd;
		}
		public void setRgu90Growth(BigDecimal rgu90Growth) {
			this.rgu90Growth = rgu90Growth;
		}
		public void setRgu30Mtd(BigDecimal rgu30Mtd) {
			this.rgu30Mtd = rgu30Mtd;
		}
		public void setRgu30Lmtd(BigDecimal rgu30Lmtd) {
			this.rgu30Lmtd = rgu30Lmtd;
		}
		public void setRgu30Growth(BigDecimal rgu30Growth) {
			this.rgu30Growth = rgu30Growth;
		}
		public void setNetAdd90d(BigDecimal netAdd90d) {
			this.netAdd90d = netAdd90d;
		}
		public void setNetAdd30d(BigDecimal netAdd30d) {
			this.netAdd30d = netAdd30d;
		}
		public void setDailyUroMtd(BigDecimal dailyUroMtd) {
			this.dailyUroMtd = dailyUroMtd;
		}
		public void setDailyUroLmtd(BigDecimal dailyUroLmtd) {
			this.dailyUroLmtd = dailyUroLmtd;
		}
		public void setDailyUroGrowth(BigDecimal dailyUroGrowth) {
			this.dailyUroGrowth = dailyUroGrowth;
		}
		public void setDailySsoMtd(BigDecimal dailySsoMtd) {
			this.dailySsoMtd = dailySsoMtd;
		}
		public void setDailySsoLmtd(BigDecimal dailySsoLmtd) {
			this.dailySsoLmtd = dailySsoLmtd;
		}
		public void setDailySsoGrowth(BigDecimal dailySsoGrowth) {
			this.dailySsoGrowth = dailySsoGrowth;
		}
		public void setTertiaryBMtd(BigDecimal tertiaryBMtd) {
			this.tertiaryBMtd = tertiaryBMtd;
		}
		public void setTertiaryBLmtd(BigDecimal tertiaryBLmtd) {
			this.tertiaryBLmtd = tertiaryBLmtd;
		}
		public void setTertiaryBGrowth(BigDecimal tertiaryBGrowth) {
			this.tertiaryBGrowth = tertiaryBGrowth;
		}
		public void setGrossMtdChurn90d(BigDecimal grossMtdChurn90d) {
			this.grossMtdChurn90d = grossMtdChurn90d;
		}
		public void setGrossMtdChurn30d(BigDecimal grossMtdChurn30d) {
			this.grossMtdChurn30d = grossMtdChurn30d;
		}
		public void setTradeSupplyMtd(BigDecimal tradeSupplyMtd) {
			this.tradeSupplyMtd = tradeSupplyMtd;
		}
		public void setTradeSupplyLmtd(BigDecimal tradeSupplyLmtd) {
			this.tradeSupplyLmtd = tradeSupplyLmtd;
		}
		public void setTradeSupplyGrowth(BigDecimal tradeSupplyGrowth) {
			this.tradeSupplyGrowth = tradeSupplyGrowth;
		}
		public void setAcqRevMtd(BigDecimal acqRevMtd) {
			this.acqRevMtd = acqRevMtd;
		}
		public void setAcqRevLmtd(BigDecimal acqRevLmtd) {
			this.acqRevLmtd = acqRevLmtd;
		}
		public void setAcqRevGrowth(BigDecimal acqRevGrowth) {
			this.acqRevGrowth = acqRevGrowth;
		}
		public void setTradeCvmRevMtd(BigDecimal tradeCvmRevMtd) {
			this.tradeCvmRevMtd = tradeCvmRevMtd;
		}
		public void setTradeCvmRevLmtd(BigDecimal tradeCvmRevLmtd) {
			this.tradeCvmRevLmtd = tradeCvmRevLmtd;
		}
		public void setTradeCvmRevGrowth(BigDecimal tradeCvmRevGrowth) {
			this.tradeCvmRevGrowth = tradeCvmRevGrowth;
		}
		public void setTradeRebuyMtd(BigDecimal tradeRebuyMtd) {
			this.tradeRebuyMtd = tradeRebuyMtd;
		}
		public void setTradeRebuyLmtd(BigDecimal tradeRebuyLmtd) {
			this.tradeRebuyLmtd = tradeRebuyLmtd;
		}
		public void setTradeRebuyGrowth(BigDecimal tradeRebuyGrowth) {
			this.tradeRebuyGrowth = tradeRebuyGrowth;
		}
		public void setTradeSpMtd(BigDecimal tradeSpMtd) {
			this.tradeSpMtd = tradeSpMtd;
		}
		public void setTradeSpLmtd(BigDecimal tradeSpLmtd) {
			this.tradeSpLmtd = tradeSpLmtd;
		}
		public void setTradeSpGrowth(BigDecimal tradeSpGrowth) {
			this.tradeSpGrowth = tradeSpGrowth;
		}
		public void setQuroMtd(BigDecimal quroMtd) {
			this.quroMtd = quroMtd;
		}
		public void setQuroLmtd(BigDecimal quroLmtd) {
			this.quroLmtd = quroLmtd;
		}
		public void setQuroGrowth(BigDecimal quroGrowth) {
			this.quroGrowth = quroGrowth;
		}
		public void setQssoMtd(BigDecimal qssoMtd) {
			this.qssoMtd = qssoMtd;
		}
		public void setQssoLmtd(BigDecimal qssoLmtd) {
			this.qssoLmtd = qssoLmtd;
		}
		public void setQssoGrowth(BigDecimal qssoGrowth) {
			this.qssoGrowth = qssoGrowth;
		}
	

	    // Getters and Setters
	    
	}