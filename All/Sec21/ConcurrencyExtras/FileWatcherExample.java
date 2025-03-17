package ConcurrencyExtras;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;




public class FileWatcherExample {
    public static void printNatoTransform(String str){
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            switch(c){
                case 'A' -> System.out.print("Able ");
                case 'B' -> System.out.print("Baker ");
                case 'C' -> System.out.print("Charlie ");
                case 'D' -> System.out.print("Dog ");
                case 'E' -> System.out.print("Easy ");
            }
        }
    }
    public static void main(String[] args) {
        // boolean keepGoing = true;
        // try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
        //     Path directory = Paths.get(".");
        //     directory.register(watchService,
        //             StandardWatchEventKinds.ENTRY_CREATE,
        //             StandardWatchEventKinds.ENTRY_MODIFY,
        //             StandardWatchEventKinds.ENTRY_DELETE);

        //     System.out.println("Watching directory: " + directory.toAbsolutePath());

        //     while (keepGoing) {
        //         WatchKey watchKey;
        //         try {
        //             watchKey = watchService.take();
        //         } catch (InterruptedException e) {
        //             System.out.println("File watcher interrupted.");
        //             return;
        //         }

        //         for (WatchEvent<?> event : watchKey.pollEvents()) {
        //             Path context = (Path) event.context();
        //             System.out.printf("Event type: %s - Context: %s%n", event.kind(), context);
        //             if(context.getFileName().toString().equals("Testing.txt") && 
        //                 event.kind() == StandardWatchEventKinds.ENTRY_DELETE){
        //                     System.out.println("Shutting down watch service");
        //                     watchService.close();
        //                     keepGoing = false;
        //                     break;
        //                 }
        //         }

                
        //         boolean valid = watchKey.reset();
        //         if (!valid) {
        //             System.out.println("WatchKey is no longer valid. Stopping watcher.");
        //             break;
        //         }
        //     }
        // } catch (IOException e) {
        //     System.err.println("Error setting up file watcher: " + e.getMessage());
        // }

        printNatoTransform("ECBADE");
    }
}
