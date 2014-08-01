package br.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class StreamUtil {

    public static String convertStreamToString(OutputStream outputStream) {
        String outputStreamAsString = null;
        try {
            outputStreamAsString = new String(((ByteArrayOutputStream) outputStream).toByteArray(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return outputStreamAsString;
    }
}
