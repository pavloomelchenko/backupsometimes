package com.mycompany;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FileService {


    public void process(Settings settings) throws Exception {

        String allSourceFilesReport = "all-files-report.txt";//todo append - date
        String copiedFilesReport = "copied-files-report.txt";//todo append - date


        List<Path> sourceFileList = extractFileList(settings.getSourceFolder());
        writeToReport(sourceFileList, allSourceFilesReport);


        Map<Path, Path> successfullyProcessedFiles = new HashMap<>();

        for (Path sourceFile : sourceFileList) {
            Path targetFile = Paths.get(settings.getTargetFolder() + "\\" + sourceFile.getFileName());

            System.out.println("Copying...");
            Files.copy(sourceFile, targetFile);

            successfullyProcessedFiles.put(sourceFile, targetFile);//todo     work on exception handling
        }

        writeToReport(successfullyProcessedFiles, copiedFilesReport);
    }


    private void writeToReport(Map<Path, Path> map, String reportName) throws Exception {
        writeToReportInternal(map.entrySet().stream().map(e -> {
            return e.getKey().toString() + " - " + e.getValue().toString();
        }).collect(toList()), reportName);

    }

    private void writeToReport(List<Path> list, String reportName) throws Exception {

        writeToReportInternal(list.stream().map(Object::toString).collect(toList()), reportName);
    }

    private void writeToReportInternal(List<String> fileList, String reportName) throws Exception {

        boolean append = false;//todo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportName, append))) {

            for (String line : fileList) {
                writer.write(line + "\n");
            }
        }

        //writer.close();
    }

    private List<Path> extractFileList(String sourceFolder) throws Exception {

//        try (Stream<Path> paths = Files.walk(Paths.get(sourceFolder))) {
//            paths
//                    .filter(Files::isRegularFile)
//                    .forEach(System.out::println);
//        }

        return Files.walk(Paths.get(sourceFolder))
                .filter(Files::isRegularFile)
                .collect(toList());


//        return Collections.emptyList();//todo
    }
}
