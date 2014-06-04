package com.gridpoint.energy.domainmodel;

import java.util.*;


public class ComparisonUsageStats {
    private final long premisesId;
    private final String premisesDescription;
    private final long deviceCount;
    private final long totalEnergy;
    private final long sessionCount;
    private final long connectionTime;
    private final long previousTotalEnergy;
    private final long previousSessionCount;
    private final long previousConnectionTime;

    // Derived values - should be methods but GSON requires fields
    private final double normalizedSessionCount;
    private final double normalizedConnectionTime;

    // Rank info
    private long totalEnergyRank;
    private long totalEnergyReverseRank;
    private long sessionCountRank;
    private long connectionTimeRank;
    private long previousTotalEnergyRank;
    private long previousSessionCountRank;
    private long previousConnectionTimeRank;
    private long totalEnergyRankDiffRank;
    private long sessionCountRankDiffRank;
    private long connectionTimeRankDiffRank;
    private long normalizedSessionCountRank;
    private long normalizedConnectionTimeRank;

    // Rank derived values - should be methods but GSON requires fields
    private long totalEnergyRankDiff;
    private long sessionCountRankDiff;
    private long connectionTimeRankDiff;

    public ComparisonUsageStats(long premisesId, String premisesDescription, long deviceCount, long totalEnergy, long sessionCount, long connectionTime, long previousTotalEnergy, long previousSessionCount, long previousConnectionTime) {
        this.deviceCount = deviceCount;
        this.totalEnergy = totalEnergy;
        this.sessionCount = sessionCount;
        this.connectionTime = connectionTime;
        this.previousTotalEnergy = previousTotalEnergy;
        this.previousSessionCount = previousSessionCount;
        this.previousConnectionTime = previousConnectionTime;
        this.premisesId = premisesId;
        this.premisesDescription = premisesDescription;

        //  Set derived values return 0 instead of dividing 0 by 0
        this.normalizedSessionCount = (getDeviceCount() == 0) ? 0 : ((double) getSessionCount()) / ((double) getDeviceCount());
        this.normalizedConnectionTime = (getDeviceCount() == 0) ? 0 : ((double) getConnectionTime()) / ((double) getDeviceCount());
    }


    // public for testing
    public void setRankFields(long totalEnergyRank, long totalEnergyReverseRank, long sessionCountRank, long connectionTimeRank,
                              long previousTotalEnergyRank, long previousSessionCountRank, long previousConnectionTimeRank,
                              long totalEnergyRankDiffRank, long sessionCountRankDiffRank, long connectionTimeRankDiffRank,
                              long normalizedSessionCountRank, long normalizedConnectionTimeRank) {
        this.totalEnergyRank = totalEnergyRank;
        this.totalEnergyReverseRank = totalEnergyReverseRank;
        this.sessionCountRank = sessionCountRank;
        this.connectionTimeRank = connectionTimeRank;
        this.previousTotalEnergyRank = previousTotalEnergyRank;
        this.previousSessionCountRank = previousSessionCountRank;
        this.previousConnectionTimeRank = previousConnectionTimeRank;
        this.normalizedSessionCountRank = normalizedSessionCountRank;
        this.normalizedConnectionTimeRank = normalizedConnectionTimeRank;
        this.totalEnergyRankDiffRank = totalEnergyRankDiffRank;
        this.sessionCountRankDiffRank = sessionCountRankDiffRank;
        this.connectionTimeRankDiffRank = connectionTimeRankDiffRank;

        // Set derived values
        this.totalEnergyRankDiff = totalEnergyRank - previousTotalEnergyRank;
        this.sessionCountRankDiff = sessionCountRank - previousSessionCountRank;
        this.connectionTimeRankDiff = connectionTimeRank - previousConnectionTimeRank;

    }

    public long getDeviceCount() {
        return deviceCount;
    }

    public long getTotalEnergy() {
        return totalEnergy;
    }

    public long getSessionCount() {
        return sessionCount;
    }

    public long getConnectionTime() {
        return connectionTime;
    }

    public long getPreviousTotalEnergy() {
        return previousTotalEnergy;
    }

    public long getPreviousSessionCount() {
        return previousSessionCount;
    }

    public long getPreviousConnectionTime() {
        return previousConnectionTime;
    }

    public long getTotalEnergyRank() {
        return totalEnergyRank;
    }

    public long getTotalEnergyReverseRank() {
        return totalEnergyReverseRank;
    }

    public long getSessionCountRank() {
        return sessionCountRank;
    }

    public long getConnectionTimeRank() {
        return connectionTimeRank;
    }

    public long getPreviousTotalEnergyRank() {
        return previousTotalEnergyRank;
    }

    public long getPreviousSessionCountRank() {
        return previousSessionCountRank;
    }

    public long getPreviousConnectionTimeRank() {
        return previousConnectionTimeRank;
    }

    public long getTotalEnergyRankDiffRank() {
        return totalEnergyRankDiffRank;
    }

    public long getSessionCountRankDiffRank() {
        return sessionCountRankDiffRank;
    }

    public long getConnectionTimeRankDiffRank() {
        return connectionTimeRankDiffRank;
    }

    public long getNormalizedSessionCountRank() {
        return normalizedSessionCountRank;
    }

    public long getNormalizedConnectionTimeRank() {
        return normalizedConnectionTimeRank;
    }

    // Derived values
    public long getTotalEnergyRankDiff() {
        return totalEnergyRankDiff;
    }

    public long getSessionCountRankDiff() {
        return sessionCountRankDiff;
    }

    public long getConnectionTimeRankDiff() {
        return connectionTimeRankDiff;
    }

    public double getNormalizedSessionCount() {
        return normalizedSessionCount;
    }

    public double getNormalizedConnectionTime() {
        return normalizedConnectionTime;
    }

    public long getPremisesId(){
        return premisesId;
    }

    public String getPremisesDescription(){
        return premisesDescription;
    }


    public static void addRanks(Map<Long, ComparisonUsageStats> unrankedStats) {
        Map<Long, RankData> ranks = new HashMap<Long, RankData>();
        for (Long key : unrankedStats.keySet()) {
            ranks.put(key, new RankData());
        }

        addBaseRanks(unrankedStats, ranks);
        addDerivedRanks(ranks);

        for (Map.Entry<Long, ComparisonUsageStats> entry : unrankedStats.entrySet()) {
            ComparisonUsageStats stats = entry.getValue();
            RankData rankData = ranks.get(entry.getKey());
            stats.setRankFields(
                rankData.totalEnergyRank, rankData.totalEnergyReverseRank, rankData.sessionCountRank, rankData.connectionTimeRank,
                rankData.previousTotalEnergyRank, rankData.previousSessionCountRank, rankData.previousConnectionTimeRank,
                rankData.totalEnergyRankDiffRank, rankData.sessionCountRankDiffRank, rankData.connectionTimeRankDiffRank,
                rankData.normalizedSessionCountRank, rankData.normalizedConnectionTimeRank
            );
        }
    }

    private static void addBaseRanks(Map<Long, ComparisonUsageStats> unrankedStats, Map<Long, RankData> ranks) {
        addRankToUsageStats(
            unrankedStats,
            ranks,
            new RankFieldSelector<Long>() {
                public Long getDataField(ComparisonUsageStats stats) {return stats.getTotalEnergy();}
                public void setRankField(RankData rankData, long value) {rankData.totalEnergyRank = value;}
            },
            true
        );

        // Energy usage top to bottom
        addRankToUsageStats(
            unrankedStats,
            ranks,
            new RankFieldSelector<Long>() {
                public Long getDataField(ComparisonUsageStats stats) {return stats.getTotalEnergy();}
                public void setRankField(RankData rankData, long value) {rankData.totalEnergyReverseRank = value;}
            },
            false
        );

        // Session count top to bottom
        addRankToUsageStats(
            unrankedStats,
            ranks,
            new RankFieldSelector<Long>() {
                public Long getDataField(ComparisonUsageStats stats) {return stats.getSessionCount();}
                public void setRankField(RankData rankData, long value) {rankData.sessionCountRank = value;}
            },
            true
        );

        // Connection time top to bottom
        addRankToUsageStats(
            unrankedStats,
            ranks,
            new RankFieldSelector<Long>() {
                public Long getDataField(ComparisonUsageStats stats) {return stats.getConnectionTime();}
                public void setRankField(RankData rankData, long value) {rankData.connectionTimeRank = value;}
            },
            true
        );

        // Previous energy usage top to bottom
        addRankToUsageStats(
            unrankedStats,
            ranks,
            new RankFieldSelector<Long>() {
                public Long getDataField(ComparisonUsageStats stats) {return stats.getPreviousTotalEnergy();}
                public void setRankField(RankData rankData, long value) {rankData.previousTotalEnergyRank = value;}
            },
            true
        );

        // Previous session count top to bottom
        addRankToUsageStats(
            unrankedStats,
            ranks,
            new RankFieldSelector<Long>() {
                public Long getDataField(ComparisonUsageStats stats) {return stats.getPreviousSessionCount();}
                public void setRankField(RankData rankData, long value) {rankData.previousSessionCountRank = value;}
            },
            true
        );

        // Previous connection time top to bottom
        addRankToUsageStats(
            unrankedStats,
            ranks,
            new RankFieldSelector<Long>() {
                public Long getDataField(ComparisonUsageStats stats) {return stats.getPreviousConnectionTime();}
                public void setRankField(RankData rankData, long value) {rankData.previousConnectionTimeRank = value;}
            },
            true
        );

        // Normalized Session Count Rank
        addRankToUsageStats(
            unrankedStats,
            ranks,
            new RankFieldSelector<Double>() {
                public Double getDataField(ComparisonUsageStats stats) {return stats.getNormalizedSessionCount();}
                public void setRankField(RankData rankData, long value) {rankData.normalizedSessionCountRank = value;}
            },
            true
        );

        // Normalized Connection Time Rank
        addRankToUsageStats(
            unrankedStats,
            ranks,
            new RankFieldSelector<Double>() {
                public Double getDataField(ComparisonUsageStats stats) {return stats.getNormalizedConnectionTime();}
                public void setRankField(RankData rankData, long value) {rankData.normalizedConnectionTimeRank = value;}
            },
            true
        );
    }

    private static void addDerivedRanks(Map<Long, RankData> ranks) {
        addDerivedRankToUsageStats(
            ranks,
            new DerivedRankFieldSelector<Long>() {
                public Long getDataField(RankData rankData) {return Math.abs(rankData.getTotalEnergyRankDiff());}
                public void setRankField(RankData rankData, long value) {rankData.totalEnergyRankDiffRank = value;}
            },
            true
        );

        // Session Count Rank Diff Rank
        addDerivedRankToUsageStats(
            ranks,
            new DerivedRankFieldSelector<Long>() {
                public Long getDataField(RankData rankData) {return Math.abs(rankData.getSessionCountRankDiff());}
                public void setRankField(RankData rankData, long value) {rankData.sessionCountRankDiffRank = value;}
            },
            true
        );

        // Connection Time Rank Diff Rank
        addDerivedRankToUsageStats(
            ranks,
            new DerivedRankFieldSelector<Long>() {
                public Long getDataField(RankData rankData) {return Math.abs(rankData.getConnectionTimeRankDiff());}
                public void setRankField(RankData rankData, long value) {rankData.connectionTimeRankDiffRank = value;}
            },
            true
        );
    }

    private static class RankData {
        public long totalEnergyRank;
        public long totalEnergyReverseRank;
        public long sessionCountRank;
        public long connectionTimeRank;
        public long previousTotalEnergyRank;
        public long previousSessionCountRank;
        public long previousConnectionTimeRank;
        public long totalEnergyRankDiffRank;
        public long sessionCountRankDiffRank;
        public long connectionTimeRankDiffRank;
        public long normalizedSessionCountRank;
        public long normalizedConnectionTimeRank;
        public long getTotalEnergyRankDiff() {return totalEnergyRank - previousTotalEnergyRank;}
        public long getSessionCountRankDiff() {return sessionCountRank - previousSessionCountRank;}
        public long getConnectionTimeRankDiff() {return connectionTimeRank - previousConnectionTimeRank;}
    }


    private static <S extends Comparable<S>>  void addRankToUsageStats (Map<Long, ComparisonUsageStats> usages, Map<Long, RankData> ranks, final RankFieldSelector<S> selector, final boolean rankFromHighToLow) {
        // Order from high to low, Order by field followed by premisesId to make the sort order unique
        Comparator<Map.Entry<Long, ComparisonUsageStats>> rankComparator = new Comparator<Map.Entry<Long, ComparisonUsageStats>> () {
            public int compare (Map.Entry<Long, ComparisonUsageStats> e1, Map.Entry<Long, ComparisonUsageStats> e2) {
                int lowToHighCompareValue = selector.getDataField(e1.getValue()).compareTo(selector.getDataField(e2.getValue()));
                if (lowToHighCompareValue == 0) {
                    lowToHighCompareValue = e1.getKey().compareTo(e2.getKey());
                }
                return rankFromHighToLow ? -lowToHighCompareValue : lowToHighCompareValue;
            }
        };
        List <Map.Entry<Long, ComparisonUsageStats>> sortedEntries = new ArrayList<Map.Entry<Long, ComparisonUsageStats>>(usages.entrySet());
        Collections.sort(sortedEntries, rankComparator);
        long i = 1;
        for (Map.Entry<Long, ComparisonUsageStats> entry : sortedEntries) {
            selector.setRankField(ranks.get(entry.getKey()), i);
            i++;
        }
    }

    private static interface RankFieldSelector<T extends Comparable<T>> {
        public T getDataField(ComparisonUsageStats usageStats);
        public void setRankField(RankData rankData, long value);
    }

    private static <S extends Comparable<S>>  void addDerivedRankToUsageStats (Map<Long, RankData> ranks, final DerivedRankFieldSelector<S> selector, final boolean rankFromHighToLow) {
        // Order from high to low, Order by field followed by premisesId to make the sort order unique
        Comparator<Map.Entry<Long, RankData>> rankComparator = new Comparator<Map.Entry<Long, RankData>> () {
            public int compare (Map.Entry<Long, RankData> e1, Map.Entry<Long, RankData> e2) {
                int lowToHighCompareValue = selector.getDataField(e1.getValue()).compareTo(selector.getDataField(e2.getValue()));
                if (lowToHighCompareValue == 0) {
                    lowToHighCompareValue = e1.getKey().compareTo(e2.getKey());
                }
                return rankFromHighToLow ? -lowToHighCompareValue : lowToHighCompareValue;
            }
        };
        List <Map.Entry<Long, RankData>> sortedEntries = new ArrayList<Map.Entry<Long, RankData>>(ranks.entrySet());
        Collections.sort(sortedEntries, rankComparator);
        long i = 1;
        for (Map.Entry<Long, RankData> entry : sortedEntries) {
            selector.setRankField(entry.getValue(), i);
            i++;
        }
    }

    private static interface DerivedRankFieldSelector<T extends Comparable<T>> {
        public T getDataField(RankData rankData);
        public void setRankField(RankData rankData, long value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComparisonUsageStats that = (ComparisonUsageStats) o;

        if (premisesId != that.premisesId) return false;
        if (connectionTime != that.connectionTime) return false;
        if (connectionTimeRank != that.connectionTimeRank) return false;
        if (connectionTimeRankDiff != that.connectionTimeRankDiff) return false;
        if (connectionTimeRankDiffRank != that.connectionTimeRankDiffRank) return false;
        if (deviceCount != that.deviceCount) return false;
        if (Double.compare(that.normalizedConnectionTime, normalizedConnectionTime) != 0) return false;
        if (normalizedConnectionTimeRank != that.normalizedConnectionTimeRank) return false;
        if (Double.compare(that.normalizedSessionCount, normalizedSessionCount) != 0) return false;
        if (normalizedSessionCountRank != that.normalizedSessionCountRank) return false;
        if (previousConnectionTime != that.previousConnectionTime) return false;
        if (previousConnectionTimeRank != that.previousConnectionTimeRank) return false;
        if (previousSessionCount != that.previousSessionCount) return false;
        if (previousSessionCountRank != that.previousSessionCountRank) return false;
        if (previousTotalEnergy != that.previousTotalEnergy) return false;
        if (previousTotalEnergyRank != that.previousTotalEnergyRank) return false;
        if (sessionCount != that.sessionCount) return false;
        if (sessionCountRank != that.sessionCountRank) return false;
        if (sessionCountRankDiff != that.sessionCountRankDiff) return false;
        if (sessionCountRankDiffRank != that.sessionCountRankDiffRank) return false;
        if (totalEnergy != that.totalEnergy) return false;
        if (totalEnergyRank != that.totalEnergyRank) return false;
        if (totalEnergyRankDiff != that.totalEnergyRankDiff) return false;
        if (totalEnergyRankDiffRank != that.totalEnergyRankDiffRank) return false;
        if (totalEnergyReverseRank != that.totalEnergyReverseRank) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = (int) (deviceCount ^ (deviceCount >>> 32));
        result = 31 * result + (int) (totalEnergy ^ (totalEnergy >>> 32));
        result = 31 * result + (int) (sessionCount ^ (sessionCount >>> 32));
        result = 31 * result + (int) (connectionTime ^ (connectionTime >>> 32));
        result = 31 * result + (int) (previousTotalEnergy ^ (previousTotalEnergy >>> 32));
        result = 31 * result + (int) (previousSessionCount ^ (previousSessionCount >>> 32));
        result = 31 * result + (int) (previousConnectionTime ^ (previousConnectionTime >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ComparisonUsageStats{" +
                "premisesId=" + premisesId +
                ", premisesDescription=" + premisesDescription +
                ", deviceCount=" + deviceCount +
                ", totalEnergy=" + totalEnergy +
                ", sessionCount=" + sessionCount +
                ", connectionTime=" + connectionTime +
                ", previousTotalEnergy=" + previousTotalEnergy +
                ", previousSessionCount=" + previousSessionCount +
                ", previousConnectionTime=" + previousConnectionTime +
                ", totalEnergyRank=" + totalEnergyRank +
                ", totalEnergyReverseRank=" + totalEnergyReverseRank +
                ", sessionCountRank=" + sessionCountRank +
                ", connectionTimeRank=" + connectionTimeRank +
                ", previousTotalEnergyRank=" + previousTotalEnergyRank +
                ", previousSessionCountRank=" + previousSessionCountRank +
                ", previousConnectionTimeRank=" + previousConnectionTimeRank +
                ", totalEnergyRankDiffRank=" + totalEnergyRankDiffRank +
                ", sessionCountRankDiffRank=" + sessionCountRankDiffRank +
                ", connectionTimeRankDiffRank=" + connectionTimeRankDiffRank +
                ", normalizedSessionCountRank=" + normalizedSessionCountRank +
                ", normalizedConnectionTimeRank=" + normalizedConnectionTimeRank +
                '}';
    }

    public static class SortUsageRank implements Comparator<ComparisonUsageStats>{

        public static enum FieldName{
            CONNECT_TIME,
            NORMALIZED_CONNECT_TIME,
            SESSIONS,
            NORMALIZED_SESSIONS,
            TOTAL_ENERGY,
            CONNECT_MOVERS,
            SESSION_MOVERS,
            ENERGY_MOVERS
        };

        boolean asc = true;
        public FieldName fieldName;

        public SortUsageRank(boolean asc, FieldName fieldName) {
            this.asc = asc;
            this.fieldName = fieldName;
        }

        @Override
        public int compare(ComparisonUsageStats one, ComparisonUsageStats two){
            int retVal = 0;

            switch(fieldName){
            case CONNECT_TIME:
                retVal = ((Long)one.getConnectionTimeRank()).compareTo(two.getConnectionTimeRank());
                break;
            case NORMALIZED_CONNECT_TIME:
                retVal = ((Long)one.getNormalizedConnectionTimeRank()).compareTo(two.getNormalizedConnectionTimeRank());
                break;
            case SESSIONS:
                retVal = ((Long)one.getSessionCountRank()).compareTo(two.getSessionCountRank());
                break;
            case NORMALIZED_SESSIONS:
                retVal = ((Long)one.getNormalizedSessionCountRank()).compareTo(two.getNormalizedSessionCountRank());
                break;
            case TOTAL_ENERGY:
                retVal = ((Long)one.getTotalEnergyRank()).compareTo(two.getTotalEnergyRank());
                break;
            case CONNECT_MOVERS:
                retVal = ((Long)one.getConnectionTimeRankDiffRank()).compareTo(two.getConnectionTimeRankDiffRank());
                break;
            case SESSION_MOVERS:
                retVal = ((Long)one.getSessionCountRankDiffRank()).compareTo(two.getSessionCountRankDiffRank());
                break;
            case ENERGY_MOVERS:
                retVal = ((Long)one.getTotalEnergyRankDiffRank()).compareTo(two.getTotalEnergyRankDiffRank());
                break;
            default:
                break;
            }
            if(retVal == 0){
                retVal = ((Long)one.getPremisesId()).compareTo(two.getPremisesId());
            }
            return asc?retVal:-retVal;
        }
    }
}
