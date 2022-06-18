package hust.soict.dsai.aims.MemoryDaemon;

public class MemoryDaemon implements Runnable{
    private long memoryUsed = 0;
    public void run() { 
        Runtime rt = Runtime.getRuntime();
        long used;

        while (true) { 
            used = rt.totalMemory() - rt.freeMemory();
            if (used != memoryUsed) {
                System.out.println("\t Memory used = " + used);
                memoryUsed = used;
            }
        }
    }
}
