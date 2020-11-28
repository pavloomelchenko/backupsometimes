package com.mycompany;

public class Settings {


    public String sourceFolder;
    public String targetFolder;
    public Boolean doZip;

    public String copiedFilesReport;
    public String allFilesReport;

    public String getSourceFolder() {
        return sourceFolder;
    }

    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = sourceFolder;
    }

    public String getTargetFolder() {
        return targetFolder;
    }

    public void setTargetFolder(String targetFolder) {
        this.targetFolder = targetFolder;
    }

    public Boolean getDoZip() {
        return doZip;
    }

    public void setDoZip(Boolean doZip) {
        this.doZip = doZip;
    }

    public String getCopiedFilesReport() {
        return copiedFilesReport;
    }

    public void setCopiedFilesReport(String copiedFilesReport) {
        this.copiedFilesReport = copiedFilesReport;
    }

    public String getAllFilesReport() {
        return allFilesReport;
    }

    public void setAllFilesReport(String allFilesReport) {
        this.allFilesReport = allFilesReport;
    }
}
