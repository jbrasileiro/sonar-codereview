/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
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
