package de.abrandl.regex.benchmark;

import java.io.File;
import java.io.IOException;

/**
 * This step drops all filsystem caches. It needs a script located in
 * /sbin/drop_fs_caches which is executable.
 * 
 * It also requires sudo configured to not need a password for this script:
 * 
 * Add this to /etc/sudoers or similar:
 * <code>abrandl ALL=NOPASSWD:/sbin/drop_fs_caches</code>
 * 
 * @author abrandl
 * 
 */
public class DropFilesystemCaches implements Step {

	private static final String SBIN = "/sbin/drop_fs_caches";

	@Override
	public void run() throws BenchmarkException {

		checkBinaryExists();

		ProcessBuilder builder = new ProcessBuilder("/usr/bin/sudo", "-n", SBIN);
		try {
			Process process = builder.start();
			int waitFor = process.waitFor();

			if (waitFor != 0) {
				throw new BenchmarkException("step DropFileSystemCaches failed. is sudo configured properly?");
			}

		} catch (IOException | InterruptedException e) {
			throw new BenchmarkException(e);
		}

	}

	private void checkBinaryExists() throws BenchmarkException {
		File binary = new File(SBIN);
		if (!binary.isFile()) {
			throw new BenchmarkException("/sbin/drop_fs_caches script does not exist. copy it from classpath.");
		} else if (!binary.canExecute()) {
			throw new BenchmarkException("/sbin/drop_fs_caches is not executable.");
		}

	}

}
