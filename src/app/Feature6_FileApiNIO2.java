package app;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;

public class Feature6_FileApiNIO2 {

    // Do not deal more with java.io.File.

    public void fileHandler() throws IOException {

        Path currentDir = Paths.get(".");
        Path parentDir = Paths.get("..");

        System.out.println("The current dir: " + currentDir.toAbsolutePath());
        System.out.println("The parent dir: " + parentDir.toAbsolutePath());

        Path path = Paths.get(currentDir.toUri());
        System.out.println("Number of Nodes " + path.getNameCount());
        System.out.println("File Root: " + path.getRoot());
        System.out.println("File Parent: " + path.getParent());
        System.out.println("File name: " + path.getFileName());
        System.out.println("" + path.toAbsolutePath() + "\n" + path.toUri());

        Path newTempPath = Paths.get(currentDir.toString() + "/temp");
        // The same as: Paths.get("./temp");

        System.out.println("My new temp dir: " + newTempPath);
        Path newTempDir = Files.createDirectory(newTempPath);
        Files.delete(newTempDir);
        Files.deleteIfExists(newTempDir);
    }

    /**
     * File change notification - The WatchService API lets you receive notification
     * events upon changes to the subject (directory or file)
     */
    public void fileNotification() throws IOException, InterruptedException {

        // Create the service to monitor the file subjectg
        WatchService watchservice = FileSystems.getDefault().newWatchService();

        // Create the file if it does not exist
        Path path = Paths.get("./temp");
        if (!Files.exists(path)) {
            path = Files.createDirectory(path);
        }

        // Register by specifiying the list of events
        path.register(watchservice, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);
        WatchKey key = null;

        // start an infinite loop to listen events
        while (true) {

            // When events occurs a WatchKey is placed on the queue
            key = watchservice.take(); // this would return your key

            // Consume the watchkey and invoke the query
            for (WatchEvent<?> event : key.pollEvents()) {
                Kind<?> kind = event.kind();
                System.out.println("Event on : " + event.context().toString() + " is " + kind);

            }

            boolean reset = key.reset();
            if (!reset)
                break;
        }
    }

    public static void main(String[] args) {
        Feature6_FileApiNIO2 app = new Feature6_FileApiNIO2();
        try {
            // app.fileHandler();
            app.fileNotification();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}