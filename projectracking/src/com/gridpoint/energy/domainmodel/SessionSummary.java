package com.gridpoint.energy.domainmodel;
import java.io.Serializable;
import java.util.List;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;


/**
 *
 */
public class SessionSummary
        implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Tuple>     whSiteRank         = null;

    private List<Tuple>     whStationRank      = null;

    //
    private List<CountPerDay>   sessionsByDay       = null;

    //[0] is current day [1] is previous day [2] is day before that ...
    private List<CountPerDay>   whByDay            = null;

    public SessionSummary () {
    }

    public List<Tuple> getwhSiteRank () {
        return whSiteRank;
    }

    public List<CountPerDay> getwhByDay () {
        return whByDay;
    }

    public void setwhByDay (List<CountPerDay> whByDay) {
        this.whByDay = whByDay;
    }

    public void setwhSiteRank (List<Tuple> whSiteRank) {
        this.whSiteRank = whSiteRank;
    }

    public List<Tuple> getwhStationRank () {
        return whStationRank;
    }

    public void setwhStationRank (List<Tuple> whStationRank) {
        this.whStationRank = whStationRank;
    }

    public List<CountPerDay> getSessionsByDay () {
        return sessionsByDay;
    }

    public void setSessionsByDay (List<CountPerDay> sessionsByDay) {
        this.sessionsByDay = sessionsByDay;
    }

    public static class Tuple implements Serializable {
        private static final long serialVersionUID = 1L;

        private Long    key    = null;
        private Integer value  = null;

        public Tuple () {
        }

        public Tuple (Long key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Long getKey () {
            return key;
        }

        public void setKey (Long key) {
            this.key = key;
        }

        public Integer getValue () {
            return value;
        }

        public void setValue (Integer value) {
            this.value = value;
        }
    }
    
    public static class CountPerDay {

		private DateTZ day;
    	private Integer count;
    	
    	public CountPerDay() {}
    	
		public CountPerDay(DateTZ day, Integer count) {
			this.day = day;
			this.count = count;
		}
    	
		public DateTZ getDay() {
			return day;
		}

		public void setDay(DateTZ day) {
			this.day = day;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}
    }
}
