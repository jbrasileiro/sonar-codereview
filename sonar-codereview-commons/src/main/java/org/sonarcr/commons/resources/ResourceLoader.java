/*
 * GNU GENERAL PUBLIC LICENSE
 * Version 3, 29 June 2007
 *
 * Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
 * Everyone is permitted to copy and distribute verbatim copies
 * of this license document, but changing it is not allowed.
 * 
 */
package org.sonarcr.commons.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.sonarcr.commons.exception.SonarAPIRuntimeException;

public class ResourceLoader {

    public static File loadFrom(
        final Class<?> clazz,
        final String directory,
        final String name) {
        final String file = directory.concat(name);
        final InputStream resource
            = clazz.getClassLoader().getResourceAsStream(file);
        if (resource == null) {
            throw new IllegalArgumentException(file.concat(" not found."));
        } else {
            return new File(ResourceLoader.load(resource, name).getPath());
        }
    }

    public static File load(
        final InputStream vin,
        final String name) {
        try (InputStream in = vin) {
            final File output = newFile(name);
            try (FileOutputStream outputStream = new FileOutputStream(output)) {
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = in.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                return output;
            }
        } catch (final IOException e) {
            throw new SonarAPIRuntimeException(e);
        } catch (final Exception e) {
            throw new SonarAPIRuntimeException(e);
        }
    }

    private static File newFile(
        final String name)
        throws IOException {
        final File tmp = File.createTempFile(".tmp-", "");
        tmp.delete();
        final File directory = new File(tmp.getPath());
        directory.mkdirs();
        return new File(directory.getPath(), name);
    }
}
