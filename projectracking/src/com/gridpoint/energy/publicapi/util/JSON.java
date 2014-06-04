package com.gridpoint.energy.publicapi.util;

public interface JSON {

	public static interface BILLING_RECORD {
		static final String PREMISES_ID = "premisesId";
		static final String DATA_COMPLETE = "isDataComplete";
		static final String GOOD_MODEL = "hasGoodModel";
		static final String SITE_ID = "siteId";
		static final String START = "start";
		static final String END = "end";
		static final String HDD = "hdd";
		static final String CDD = "cdd";
		static final String UNITS = "units";
		static final String USAGE = "usage";
		static final String PREDICTED_USAGE = "predictedUsage";
		static final String AMOUNT = "amount";
		static final String PREDICTED_AMOUNT = "predictedAmount";
		static final String REDUCTION = "reduction";
		static final String COUNT = "count";
		static final String EXCLUDE = "exclude";
		static final String A = "a";
		static final String B = "b";
		static final String C = "c";
		static final String R2 = "r2";
		static final String COMMISSION_DATE = "commissionDate";
		static final String SQ_FOOTAGE = "sqFootage";
		static final String SQ_FOOTAGE_UNIT = "sqFootageUnit";
	}

	public static interface CHANNEL {
		static final String DICTIONARY_NAME = "dictionaryName";
		static final String SCALE = "scale";
		static final String CHANNEL_NAME = "channelName";
		static final String CALC_TYPE = "calcType";
		static final String CHANNEL_ID = "channelId";
		static final String REFERENCE_ID = "referenceId";
		static final String DICTIONARY_UNIT = "dictionaryUnit";
		static final String DISPLAY_NAME = "displayName";
		static final String DISABLED = "disabled";
	    static final String INVISIBLE = "invisible";
		static final String GRANULARITY = "granularity";
		static final String TOTAL_TYPE = "totalType";
		static final String CATEGORY = "category";
		static final String SUBCATEGORY = "subcategory";
		static final String MEASURETYPE = "measureType";
		static final String UNIT_OF_MEASURE = "unitOfMeasure";
		static final String UNIT_IDENTIFIER = "unitIdentifier";
		static final String METADATA = "metadata";
        static final String LEGACY = "legacy";

        /** @see com.gridpoint.energy.domainmodel.Channel#displayedByDefault */
        static final String DISPLAYED_BY_DEFAULT = "displayedByDefault";
	}

	public static interface CALC_TYPE {
	    static final String AVG = "average";
	    static final String SUM = "sum";
	}

	public static interface COLOR_CONFIG {
		static final String TENANT_ID = "tenantId";
		static final String ID = "id";
		static final String TYPE = "type";
		static final String PALETTE_ID = "paletteId";
		static final String GRAPH_ORDER = "graphOrder";
	}

	public static interface DATA_TUPLE {
		static final String VALUE = "value";
		static final String MAX = "max";
		static final String MIN = "min";
	}

	public static interface DEVICE {
		static final String DEVICE_ID = "deviceId";
		static final String PREMISES_ID = "premisesId";
		static final String ENDPOINT_ID = "endpointId";
		static final String PREMISES_DESC = "premisesDescription";
		static final String DEVICE_TYPE = "deviceType";
		static final String NAME = "name";
		static final String ADDRESS = "address";
		static final String PROPERTIES = "properties";
		static final String STATE = "state";
		static final String CHANNELS = "channels";
	}

	public static interface ENDPOINT {
		static final String ID = "id";
		static final String REFERENCE_ID = "referenceId";
        static final String PASSWORD = "password";
        static final String TYPE = "type";
		static final String FACTORY_FIRMWARE = "factoryFirmware";
		static final String FIRMWARE = "firmware";
		static final String STATE = "state";
		static final String PREMISES_ID = "premisesId";
        static final String MAC_ADDRESS = "macAddress";
        static final String SERIAL = "serial";
        static final String CONTROLLER_FIRMWARE_VERSION_LABEL = "controllerFirmwareVersionLabel";
    }

	public static interface EXTERNAL_ALARM {
	    static final String CLASSIFICATION_ID = "classificationId";
	    static final String CHANNEL_ID = "channelId";
	}

	public static interface FIRMWARE {
		static final String ID = "id";
		static final String NAME = "name";
		static final String VERSION = "version";
		static final String RELEASE_DATE = "releaseDate";
		static final String ACTIVE = "active";
        static final String ENDPOINT_TYPE = "endpointType";
	}

    public static interface GPEC_PERIPHERAL_FIRMWARE {
        static final String ID = "id";
        static final String ACTIVE = "active";
        static final String VERSION_MAJOR_NUMBER = "versionMajorNumber";
        static final String VERSION_MINOR_NUMBER = "versionMinorNumber";
        static final String MINIMUM_CONTROLLER_FIRMWARE_VERSION_MAJOR_NUMBER = "minimumControllerFirmwareVersionMajorNumber";
        static final String MINIMUM_CONTROLLER_FIRMWARE_VERSION_MINOR_NUMBER = "minimumControllerFirmwareVersionMinorNumber";
        static final String MINIMUM_CONTROLLER_FIRMWARE_VERSION_REVISION_NUMBER = "minimumControllerFirmwareVersionRevisionNumber";
        static final String BINARY_EXECUTABLE = "binaryExecutable";
        static final String PERIPHERAL_TYPE_NAME = "peripheralTypeName";
        static final String RELEASE_DATE = "releaseDate";
    }

    public static interface ENDPOINT_TYPE {
        static final String ENDPOINT_TYPE_ID = "endpointTypeId";
        static final String DESCRIPTION = "description";
        static final String NAME = "name";
    }

    public static interface PERIPHERAL_SUMMARY {
        static final String NAME = "name";
    }

	public static interface PREMISES {
		static final String ID = "id";
		static final String NAME = "name";
		static final String DESCRIPTION = "description";
		static final String REFERENCE_ID = "referenceId";
		static final String TIMEZONE = "timezone";
		static final String ZIPCODE = "zipcode";
		static final String ADDRESS_1 = "address1";
		static final String ADDRESS_2 = "address2";
		static final String PROVINCE = "province";
		static final String CITY = "city";
		static final String COUNTRY = "country";
		static final String PHONE_1 = "phone1";
		static final String PHONE_2 = "phone2";
		static final String CONTROL_DATE = "controlDate";
		static final String COMMISSION_DATE = "commissionDate";
		static final String SQ_FOOTAGE = "sqfootage";
		static final String SQ_FOOTAGE_UNIT = "sqfootage_unit";
		static final String LATITUDE = "latitude";
		static final String LONGITUDE = "longitude";
		static final String TAGS = "tags";
		static final String TENANT = "tenant";
		static final String LEGACY_SITE_ID = "legacySiteId";
		static final String HIDDEN = "hidden";
		static final String HAS_EV = "hasEv";
		static final String HAS_SUBMETERING = "hasSubmetering";
		static final String HAS_PV = "hasPv";
		static final String HAS_CONTROL = "hasControl";
		static final String SYSTEMSIZE = "systemSize";
	}

	public static interface PREMISES_REIMPORT_REQUEST {
		static final String ID = "id";
		static final String PREMISES_ID = "premisesId";
		static final String REQUEST_TIME = "requestTime";
		static final String PROCESS_TIME = "processTime";
		static final String FINISH_TIME = "finishTime";
		static final String STATUS = "status";
	}

	public static interface PROPERTY {
		static final String READ_ONLY = "readOnly";
		static final String NAME = "name";
		static final String VALUE = "value";
	}

	public static interface REPORT_PARAMETER {
		static final String NAME = "name";
		static final String TYPE = "type";
		static final String VALUE = "value";
	}

	public static interface TAG_MAP {
		static final String SQ_FOOTAGE = "sqfootage";
		static final String SQ_FOOTAGE_UNIT = "sqfootage_unit";
	}

	public static interface TASK_RESULT {
		static final String DONE = "done";
		static final String RESULT = "result";
	}

	public static interface TENANT {
        static final String TENANT_ID = "tenantId";
        static final String PARENT_ID = "parentId";
		static final String THEME = "theme";
		static final String NAME = "name";
		static final String TENANT_URL = "tenantUrl";
		static final String COLOR_CONFIGS = "colorConfigs";
	}

	public static interface VALUE_WITH_UNIT {
		static final String VALUE = "value";
		static final String UNIT = "unit";
	}
	
	public static interface USER_DETAILS {
	    static final String ID = "id";
	    static final String PASSWORD = "password";
	    static final String USERNAME = "username";
	    static final String ROLE = "role";
	    static final String ACCOUNT_NON_EXPIRED = "accountNonExpired";
	    static final String ACCOUNT_NON_LOCKED = "accountNonLocked";
	    static final String RESET_PASSWORD = "resetPassword";
	    static final String ENABLED = "enabled";
	    static final String AUTHORITIES = "authorities";
	    static final String LANGUAGE = "language";
	    static final String MEASUREMENT_SYSTEM = "measurementSystem";
	    static final String EMAIL = "email";
	    static final String FIRST_NAME = "firstName";
	    static final String LAST_NAME = "lastName";
	    static final String DEFAULT_THEME = "defaultTheme";
	    static final String DEFAULT_TENANT = "defaultTenant";
	    static final String LAST_READ_NEWS_FILE = "lastReadNewsFile";
	    static final String CAPABILITIES = "capabilities";
	}
	
	public static interface USER_AUTHORITIES {
	    static final String ACCESS_MAP = "accessMap";
	    static final String CAPABILITIES = "capabilities";
	    static final String ACCEPTED_EULA = "acceptedEula";
	    static final String TENANT_EULA = "tenantEula";	    
	}
	
	public static interface PROJECT_TRACKING {
		static  final  String  PROJECT_ID = "projectId";
		static  final  String  PREMISES_ID = "premisesId";
		static  final  String  PROJECT_NAME = "projectName";
		static  final  String  START_DATE = "startDate";
		static  final  String  END_DATE =   "endDate";
		static  final  String  PROJECT_TYPE_ID ="projectTypeId";
		static  final  String  CHANNELS = "channels";
		static  final  String  STATUS = "projectStatus";
		static  final  String    DEPRECATED = "deprecated";
		static  final  String    PROJECT_TYPE ="projectType";
		static  final  String  PROJECT_ERROR_WARNING ="errorsAndWarnings";
		static final String SITE_NAME = "siteName";
	}
}
