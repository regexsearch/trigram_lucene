package de.abrandl.regex.helpers;

import java.io.File;
import java.io.IOException;

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

}
