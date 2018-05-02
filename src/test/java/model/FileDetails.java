package model;

/**
 * Created by tolaf on 02/05/2018.
 * Getter and Setter for File
 */
public class FileDetails {
    private String filename;
    private String fileMimeType;
    private double fileSize;

    public String getFileMimeType() {
        return fileMimeType;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilename() {
        return filename;

    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
