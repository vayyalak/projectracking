package com.gridpoint.energy.domainmodel;
import java.io.Serializable;
import java.sql.Timestamp;

public class LogMessage implements Serializable {
    private static final long serialVersionUID = 6180107576574612781L;

    private long timestamp;
    private int sequence;
    private String level;
    private String fileName;
    private String message;

    public LogMessage() {}

    public LogMessage(final Timestamp timestamp, final int sequence, final String level, final String fileName, final String message) {

        if (timestamp==null)
            throw new IllegalArgumentException("No timestamp provided.");

        this.timestamp = timestamp.getTime();
        this.level = level;
        this.fileName = fileName;
        this.message = message;
        this.sequence = sequence;
    }

    public LogMessage(long timestamp, int sequence, String level, String fileName, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.fileName = fileName;
        this.message = message;
        this.sequence = sequence;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "timestamp=" + timestamp +
                ", sequence=" + sequence +
                ", level='" + level + '\'' +
                ", fileName='" + fileName + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
