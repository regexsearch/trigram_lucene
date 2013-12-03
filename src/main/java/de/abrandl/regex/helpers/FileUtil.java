package de.abrandl.regex.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.apache.commons.io.FileUtils;

final public class FileUtil {

	public static File createEmptyTempDirectory(String basename) throws IOException {
		File temp = new File(System.getProperty("java.io.tmpdir"), basename);

		if (temp.isDirectory()) {
			FileUtils.deleteDirectory(temp);
		}

		if (!temp.mkdirs()) {
			throw new IOException("could not create temporary directory");
		}
		return temp;
	}

	public static StringBuffer read(File file) throws FileNotFoundException, IOException {
		StringBuffer sb = new StringBuffer();
		try (RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
				FileChannel inChannel = randomAccessFile.getChannel()) {
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while (inChannel.read(buffer) > 0) {
				buffer.flip();
				for (int i = 0; i < buffer.limit(); i++) {
					sb.append((char) buffer.get());
				}
				buffer.clear();
			}
		}
		return sb;
	}

}
