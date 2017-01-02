package org.sonarcr.commons.file;

import java.io.File;

import org.sonarcr.commons.exception.FileCanNotBeDeleted;
import org.sonarcr.commons.util.ObjectsUtils;

public class FileDeleter {

    public static boolean deleteFile(
        final File file) {
        ObjectsUtils.required(file);
        if(!file.exists()){
            return true;
        }
        if (file.isFile() && file.exists()) {
            return file.delete();
        } else {
            return false;
        }
    }

    public static boolean requiredDeleteFile(
        final File file) {
        if (FileDeleter.deleteFile(file)) {
            return true;
        }else{
            throw new FileCanNotBeDeleted(file);
        }
        
    }
}
