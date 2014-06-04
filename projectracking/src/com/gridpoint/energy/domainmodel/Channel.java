package com.gridpoint.energy.domainmodel;

import java.io.Serializable;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.gridpoint.energy.publicapi.util.JacksonChannelDeserializer;
import com.gridpoint.energy.publicapi.util.JacksonChannelSerializer;
import com.gridpoint.energy.util.JacksonMapSerializer;

/**
 * Represents a stream of measurements or settings for a device.
 */
@JsonDeserialize(using=JacksonChannelDeserializer.class,
as=Map.class,
keyAs=JacksonMapSerializer.class
)
@JsonSerialize(using=JacksonChannelSerializer.class)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Channel implements Serializable {

    private static final long serialVersionUID = 1L;

    private long channelId;
    private String channelName;
    private String displayName;
    private DataDictionaryType dataDictionaryType;
    private CalcType calcType;
    private Device device;
    private boolean locked;
    private double scale;
    private String referenceId;
    private boolean disabled;
    private IntervalSize granularity;
    private String category;
    private String subcategory;
    private String measureType;
    private String unitOfMeasure;
    private String unitIdentifier;
    private ChannelTotalType totalType;
    private ChannelMetadata metadata;

    /**
     * Allows the UI to determine if the channel should be displayed according to "ADM" (legacy) display format or modern ("GPEC", or non-legacy) channel format.
     * The legacy display format groups channels by the {@link #displayName} (or {@link #channelName} if the {@link #displayName} is null).
     * The non-legacy display format groups channels by the parent device name.
     * The legacy display format places the {@link #displayName} (or {@link #channelName} if the {@link #displayName} is null) in the legend.
     * The non-legacy display format places the device name <em>and</em> {@link #displayName} (or CMS-translated {@link #channelName} if the {@link #displayName} is null) in the legend.
     */
    // Addresses JIRA issues GPUP-10322, GPUP-10215.
    // This property does not correspond to any property in the data layer, as it is entirely a business-determined property.
    private boolean legacy;

    /**
     * whether or not this channel's data should be displayed by default to end users.
     * When this property is false, the end user may choose to override the default and view this channel's data anyway, but it is not shown by default.
     */
    // see also com.gridpoint.energy.datamodel.ChannelMetadataEntity.displayedByDefault
    private boolean displayedByDefault;

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getDisplayName() {
        return this.displayName == null ? channelName : displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public DataDictionaryType getDataDictionaryType() {
        return dataDictionaryType;
    }

    public void setDataDictionaryType(DataDictionaryType dataDictionaryType) {
        this.dataDictionaryType = dataDictionaryType;
    }

    public CalcType getCalcType() {
        return calcType;
    }

    public void setCalcType(CalcType calcType) {
        this.calcType = calcType;
    }

    public Device getDevice() {
        return this.device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public boolean getLocked() {
        return this.locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public double getScale() {
        return this.scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public String getReferenceId() {
        return this.referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
    
    public boolean isInvisible() {
        //GPUP-8186: This will need to be replaced when we deprecate data dictionary. Invisible channels on ADM have channel_type_id=12.
        return getDataDictionaryType() == null || "Invisible".equals(getDataDictionaryType().getName());
    }

    public void setGranularity(IntervalSize granularity) {
        this.granularity = granularity;
    }

    public IntervalSize getGranularity() {
        return granularity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getMeasureType() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getUnitIdentifier() {
        return unitIdentifier;
    }

    public void setUnitIdentifier(String unitIdentifier) {
        this.unitIdentifier = unitIdentifier;
    }
    
    public ChannelTotalType getTotalType() {
        return totalType;
    }
    
    public void setTotalType(ChannelTotalType totalType) {
        this.totalType = totalType;
    }

    public boolean isDisplayedByDefault() {
        return displayedByDefault;
    }

    public void setDisplayedByDefault(boolean displayedByDefault) {
        this.displayedByDefault = displayedByDefault;
    }

    public boolean isLegacy() {
        return legacy;
    }

    public void setLegacy(boolean legacy) {
        this.legacy = legacy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Channel channel = (Channel) o;

        if (channelId != channel.channelId) {
            return false;
        }
        if (channelName != null ? !channelName.equals(channel.channelName) : channel.channelName != null) {
            return false;
        }
        if (dataDictionaryType != null ? !dataDictionaryType.equals(channel.dataDictionaryType) : channel.dataDictionaryType != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) ( channelId ^ ( channelId >>> 32 ) );
        result = 31 * result + ( channelName != null ? channelName.hashCode() : 0 );
        result = 31 * result + ( dataDictionaryType != null ? dataDictionaryType.hashCode() : 0 );
        return result;
    }

	public ChannelMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(ChannelMetadata metadata) {
		this.metadata = metadata;
	}

}
