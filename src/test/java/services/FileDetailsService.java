package services;

import com.google.common.collect.Lists;
import model.FileDetails;
import org.apache.tika.Tika;
import org.apache.tika.io.FilenameUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tolaf on 02/05/2018.
 */
public class FileDetailsService {
    //this method is to iterate all the files and store extension and file details in the map
    public Map<String, List<FileDetails>> getFileDetailsFromADirectory(String directoryName) {
        Map<String, List<FileDetails>> fileData = new HashMap<>();
        File directory = new File(directoryName);
        File[] fileList = directory.listFiles();
        assert fileList != null;
        for (File file : fileList) {
            String absolutePath = file.getAbsolutePath();
            if (file.isFile()) {
                //String extension = FilenameUtils.getExtension(absolutePath);
                String extension = FilenameUtils.getName(absolutePath);
                List<FileDetails> fileDetailsList = fileData.get(extension);
                if (fileDetailsList == null) {
                    fileData.put(extension, Lists.newArrayList(getFilesDetails(absolutePath)));
                } else {
                    fileDetailsList.add(getFilesDetails(absolutePath));
                    fileData.put(extension, fileDetailsList);
                }
            } else if (file.isDirectory()) {
//                do nothing
            }
        }
        return fileData;
    }

    // this method is to get the file details like size, name and mime type
    private FileDetails getFilesDetails(String absolutePath) {
        FileDetails fileDetails = new FileDetails();
        String mimeType = getMimeType(absolutePath);
        fileDetails.setFileMimeType(mimeType);
        fileDetails.setFileSize(new File(absolutePath).length());
        fileDetails.setFilename(absolutePath);
        return fileDetails;
    }

    // this method is to get the mimeType of the file
    private String getMimeType(final String fileName) {
        Tika mimeTika = new Tika();
        String fileType;
        try {
            final File file = new File(fileName);
            fileType = mimeTika.detect(file);
        } catch (IOException exp) {
            fileType = "Unknown";
        }
        return fileType;
    }
}
