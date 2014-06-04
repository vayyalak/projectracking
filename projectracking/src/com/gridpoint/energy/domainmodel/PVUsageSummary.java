package com.gridpoint.energy.domainmodel;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;

/*
 * On average, electricity sources emit 1.297 lbs CO2 per kWh (0.0005883 metric tons CO2 per kWh). Average cost in US for commercial: 10.11
 * cents per kWh
 */
public class PVUsageSummary {

    private Double currentGeneration = 0D;
    private Double currentConsumption = 0D;
    private Double currentGenerationPeak = 0D;

    private Double currentConsumptionPeak = 0D;
    private DateTZ currentGenerationDate = null;
    private DateTZ currentConsumptionDate = null;
    private DateTZ peakOccurrenceConsumption = null;
    private DateTZ peakOccurrenceGeneration = null;

    private Collection<HistoricalGeneration> historicalGeneration;
    private List<HourlyWeatherData> weatherData;
    private Map<Integer, SolarImpact> solarImpact;
    
    public Double getCurrentGenerationPeak()
    {
      return currentGenerationPeak;
    }

    public void setCurrentGenerationPeak(Double currentGenerationPeak)
    {
      this.currentGenerationPeak = currentGenerationPeak;
    }

    public Double getCurrentConsumptionPeak()
    {
      return currentConsumptionPeak;
    }

    public void setCurrentConsumptionPeak(Double currentConsumptionPeak)
    {
      this.currentConsumptionPeak = currentConsumptionPeak;
    }

    public PVUsageSummary() {
        this.solarImpact = new HashMap<Integer, SolarImpact>();
    }

    public void addSolarImpact(Integer months, SolarImpact impact) {
        solarImpact.put(months, impact);
    }

    /*public DateTZ getPeakOccurrence() {
        return peakOccurrence;
    }

    public void setPeakOccurrence(DateTZ peakOccurrence) {
        this.peakOccurrence = peakOccurrence;
    }*/

    public DateTZ getCurrentGenerationDate() {
        return currentGenerationDate;
    }

    public void setCurrentGenerationDate(DateTZ currentGenerationDate) {
        this.currentGenerationDate = currentGenerationDate;
    }

    public DateTZ getCurrentConsumptionDate() {
        return currentConsumptionDate;
    }

    public void setCurrentConsumptionDate(DateTZ currentConsumptionDate) {
        this.currentConsumptionDate = currentConsumptionDate;
    }

    public Map<Integer, SolarImpact> getSolarImpact() {
        return solarImpact;
    }

    /*public Double getCurrentPeak() {
        return currentPeak;
    }

    public void setCurrentPeak(Double currentPeak) {
        this.currentPeak = currentPeak;
    }*/

    public Double getCurrentGeneration() {
        return currentGeneration;
    }

    public void setCurrentGeneration(Double currentGeneration) {
        this.currentGeneration = currentGeneration;
    }

    public Double getCurrentConsumption() {
        return currentConsumption;
    }

    public void setCurrentConsumption(Double currentConsumption) {
        this.currentConsumption = currentConsumption;
    }

    public Collection<HistoricalGeneration> getHistoricalGeneration() {
        return historicalGeneration;
    }

    public void setHistoricalGeneration(Collection<HistoricalGeneration> historicalGeneration) {
        this.historicalGeneration = historicalGeneration;
    }

    public List<HourlyWeatherData> getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(List<HourlyWeatherData> weatherData) {
        this.weatherData = weatherData;
    }

    public void setPeakOccurrenceConsumption(DateTZ peakOccurrenceConsumption)
    {
      this.peakOccurrenceConsumption = peakOccurrenceConsumption;
    }

    public DateTZ getPeakOccurrenceConsumption()
    {
      return peakOccurrenceConsumption;
    }

    public void setPeakOccurrenceGeneration(DateTZ peakOccurrenceGeneration)
    {
      this.peakOccurrenceGeneration = peakOccurrenceGeneration;
    }

    public DateTZ getPeakOccurrenceGeneration()
    {
      return peakOccurrenceGeneration;
    }

    // nested class for convenience of packaging PV summary together
    /**
     * Used to hold <b>n</b> days worth of generation and consumption information for solar devices
     * 
     * @author cconstantinescu
     */
    public static class HistoricalGeneration {

        private DateTZ date;
        private Double generation = 0D;
        private Double consumption = 0D;

        public DateTZ getDate() {
            return date;
        }

        public void setDate(DateTZ date) {
            this.date = date;
        }

        public Double getGeneration() {
            return generation;
        }

        public void setGeneration(Double generation) {
            this.generation = generation;
        }

        public Double getConsumption() {
            return consumption;
        }

        public void setConsumption(Double consumption) {
            this.consumption = consumption;
        }
    }

    public static class SolarImpact {

        private Double co2Saved = 0D;
        private String co2Unit = "";

        private Double financialBenefit = 0D;
        private String currencyUnit = "";

        private Double totalGeneration = 0D;
        
        private Double generationSolarImpact = 0D;
        
        private Double consumptionSolarImpact = 0D;

        private Double SavedSolarImpact = 0D;		
		
		private Double systemSize;
		
		public Double getSystemSize() {
			return systemSize;
		}
		
		public void setSystemSize(Double systemSize) {
			this.systemSize = systemSize;
		}

        public Double getCo2Saved() {
            return co2Saved;
        }

        public void setCo2Saved(Double co2Saved) {
            this.co2Saved = co2Saved;
        }

        public String getCo2Unit() {
            return co2Unit;
        }

        public void setCo2Unit(String co2Unit) {
            this.co2Unit = co2Unit;
        }

        public Double getFinancialBenefit() {
            return financialBenefit;
        }

        public void setFinancialBenefit(Double financialBenefit) {
            this.financialBenefit = financialBenefit;
        }

        public String getCurrencyUnit() {
            return currencyUnit;
        }

        public void setCurrencyUnit(String currencyUnit) {
            this.currencyUnit = currencyUnit;
        }

        public Double getTotalGeneration() {
            return totalGeneration;
        }

        public void setTotalGeneration(Double totalGeneration) {
            this.totalGeneration = totalGeneration;
        }

        public void setGenerationSolarImpact(Double generationSolarImpact)
        {
          this.generationSolarImpact = generationSolarImpact;
        }

        public Double getGenerationSolarImpact()
        {
          return generationSolarImpact;
        }

        public void setConsumptionSolarImpact(Double consumptionSolarImpact)
        {
          this.consumptionSolarImpact = consumptionSolarImpact;
        }

        public Double getConsumptionSolarImpact()
        {
          return consumptionSolarImpact;
        }

        public void setSavedSolarImpact(Double savedSolarImpact)
        {
          SavedSolarImpact = savedSolarImpact;
        }

        public Double getSavedSolarImpact()
        {
          return SavedSolarImpact;
        }
    }
    /*public static class SolarImpact {

      private Double generation = 0D;
      
      private Double consumption = 0D;

      private Double Saved = 0D;

      
      public void setGeneration(Double generation)
      {
        this.generation = generation;
      }

      public Double getGeneration()
      {
        return generation;
      }

      public void setConsumption(Double consumption)
      {
        this.consumption = consumption;
      }

      public Double getConsumption()
      {
        return consumption;
      }
      public void setSaved(Double saved)
      {
        Saved = saved;
      }

      public Double getSaved()
      {
        return Saved;
      }
      
  }*/
}
