package com.APIwebsitelinc.Storage;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtil {

	private FileUtil() {
		// restrict instantiation
	}

		public static final String folderPath =  "storage-files//";
		public static final Path filePath = Paths.get(folderPath);


}