package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConcatenationInLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String fileName = "/Users/charles/Desktop/Notebook.txt";
			byte[] inputBytes = Files.readAllBytes(Paths.get(fileName));
			GarbageCreator garbage = new GarbageCreator();
			NoGarbage notGarbage = new NoGarbage();
			garbage.concat(inputBytes);
			notGarbage.concatBuffer(inputBytes);
			notGarbage.concatBuilder(inputBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
