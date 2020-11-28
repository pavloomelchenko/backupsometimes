package com.mycompany;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class YamlReader {

    public static Settings read(String filename) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());

        ObjectMapper om = new ObjectMapper(new YAMLFactory());

        return om.readValue(file, Settings.class);
    }
}
