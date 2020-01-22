import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PatientFileIO {

	public PatientFileIO() {

	}

	public byte[] readFile(String fileName) throws IOException {
		File file = new File(fileName);

		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			// File is too large
			throw new IOException("File is too large!");
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;

		InputStream is = new FileInputStream(file);
		try {
			while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}
		} finally {
			is.close();
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}

		return bytes;
	}

	public void writeFile(String fileName, byte[] buf) {

		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(fileName);
			fos.write(buf);
		} catch (IOException ex) {
			System.out.println(ex);
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (Exception ex) {
				}
		}
	}
}