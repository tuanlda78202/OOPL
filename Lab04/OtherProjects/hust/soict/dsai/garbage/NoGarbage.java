package hust.soict.dsai.garbage;

public class NoGarbage {
	public void concatBuffer(byte[] inputBytes) {
		long startTime = System.currentTimeMillis();
		StringBuffer outputStringBuffer = new StringBuffer();
		for (byte b: inputBytes) {
			outputStringBuffer.append((char)b);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total running time for concatenation using StringBuffer:" + (endTime - startTime));
	}
	
	public void concatBuilder(byte[] inputBytes) {
		long startTime = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b: inputBytes) {
			outputStringBuilder.append((char)b);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total running time for concatenation using StringBuilder:" + (endTime - startTime));
	}

}
