package com.gridpoint.energy.domainmodel;

import java.util.Date;

public class ReportTask{

    private long reportTaskId;
    private String name;
    private String displayName;
    private String mimeType;
    private String status;
    private long downloadCount;

    private Date creationDate;
    private Date completionDate;
    private Date expirationDate;

    public long getReportTaskId(){
        return reportTaskId;
    }
    public void setReportTaskId(long reportTaskId){
        this.reportTaskId = reportTaskId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getMimeType(){
        return mimeType;
    }
    public void setMimeType(String mimeType){
        this.mimeType = mimeType;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public Date getCreationDate(){
        return creationDate;
    }
    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }
    public Date getCompletionDate(){
        return completionDate;
    }
    public void setCompletionDate(Date completionDate){
        this.completionDate = completionDate;
    }
    public Date getExpirationDate(){
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate){
        this.expirationDate = expirationDate;
    }
    public long getDownloadCount(){
        return downloadCount;
    }
    public void setDownloadCount(long downloadCount){
        this.downloadCount = downloadCount;
    }

}
