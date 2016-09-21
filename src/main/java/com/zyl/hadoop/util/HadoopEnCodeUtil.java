package com.zyl.hadoop.util;

import java.io.UnsupportedEncodingException;

import org.apache.hadoop.io.Text;

public class HadoopEnCodeUtil {
    public static Text transTextToCharset(Text text, String encoding) {
        String value = "";
        try {
            value = new String(text.getBytes(), 0, text.getLength(), encoding);
        } catch ( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }
        
        return new Text(value);
    }
}