package com.mycompany;

public class HelloWorld {


    public static void main(String[] args) throws Exception {
        System.out.println("Hello world");


        //Files.copy()
        Settings settings = YamlReader.read("application.yaml");

        FileService fileService = new FileService();

        fileService.process(settings);


    }
}
