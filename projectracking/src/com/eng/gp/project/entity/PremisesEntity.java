package com.eng.gp.project.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;






/**
 * Represents a single site, or location.
 */

@Entity
@Table(name = "premises")

public class PremisesEntity implements java.io.Serializable {
    public static final long serialVersionUID = 1L;

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "premises_id")
    private long premisesId;

    /**
     * The description of the premises.
     */
    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

  

    @Column(name = "timezone")
    private String timezone;



	public long getPremisesId() {
		return premisesId;
	}



	public void setPremisesId(long premisesId) {
		this.premisesId = premisesId;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTimezone() {
		return timezone;
	}



	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

   
}
