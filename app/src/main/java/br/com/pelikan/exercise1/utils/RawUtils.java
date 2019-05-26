package br.com.pelikan.exercise1.utils;

import java.io.IOException;
import java.io.InputStream;

public class RawUtils {

    public static String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            return new String(bytes);
        } catch (IOException e) {
            return null;
        }
    }
}
