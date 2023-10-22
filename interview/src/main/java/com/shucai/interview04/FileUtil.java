package com.shucai.interview04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class FileUtil {

    public static Set<String> readWords(String url) {
        Set<String> list = new HashSet<>();

        try {
            InputStreamReader is = new InputStreamReader(new FileInputStream(url), StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(is);
            String line = "";
            while ((line = reader.readLine())!= null) {
                String[] ss = line.split("\t");
                list.add(ss[1]);
            }
        } catch (Exception e) {
            return null;
        }

        return list;
    }
}
