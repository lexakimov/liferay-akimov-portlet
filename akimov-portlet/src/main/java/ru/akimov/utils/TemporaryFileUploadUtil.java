package ru.akimov.utils;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.SystemProperties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.liferay.portal.kernel.util.SystemProperties.TMP_DIR;
import static java.io.File.separator;

/**
 * @author akimov
 * created at 07.03.2020 12:43
 */
public class TemporaryFileUploadUtil {

	private static Log log = LogFactoryUtil.getLog(TemporaryFileUploadUtil.class);

	public static String generateFileId() {
		return UUID.randomUUID().toString();
	}

	public static File initTempSessionStorage(HttpServletRequest req) throws IOException {
		HttpSession session = req.getSession(true);
		return initTempSessionStorage(session);
	}

	public static File initTempSessionStorage(HttpSession session) throws IOException {
		String sessionTempStorage = SystemProperties.get(TMP_DIR) + separator + session.getId() + separator;
		File tmpDir = new File(sessionTempStorage);
		FileUtil.mkdirs(tmpDir);
		return tmpDir;
	}

	public static TempFile getFile(HttpSession session, String fileId) throws IOException {
		File tempSessionStorageDir = initTempSessionStorage(session);
		Path tempFilePath = Paths.get(tempSessionStorageDir.getPath(), fileId);
		Path tempFileMetaPath = Paths.get(tempSessionStorageDir.getPath(), fileId + ".meta");

		String meta = FileUtil.read(tempFileMetaPath.toFile());
		JSONObject metaJson;
		try {
			metaJson = JSONFactoryUtil.createJSONObject(meta);
		} catch (JSONException e) {
			throw new IOException(e);
		}
		String fileName = metaJson.getString("name");
		int size = metaJson.getInt("size");

		return new TempFile(fileId, fileName, tempFilePath, size);
	}

	public static Collection<TempFile> listStorage(HttpSession session, String[] fileIds) throws IOException {
		try {
			return Arrays.stream(fileIds)
					.map(fileId -> {
						try {
							return getFile(session, fileId);
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					})
					.collect(Collectors.toList());
		} catch (RuntimeException re) {
			throw (IOException) re.getCause();
		}
	}

	public static List<TempFile> listStorage(HttpSession session) throws IOException {
		File tempSessionStorageDir = initTempSessionStorage(session);
		Path tempDirPath = tempSessionStorageDir.toPath();

		return Files.list(tempDirPath)
				.filter(path -> !path.getFileName().toString().endsWith(".meta"))
				.map(path -> {
					String fileId = path.toFile().getName();
					Path metaPath = Paths.get(tempSessionStorageDir.getPath(), fileId + ".meta");
					JSONObject metaJson;
					try {
						String metaContent = FileUtil.read(metaPath.toFile());
						metaJson = JSONFactoryUtil.createJSONObject(metaContent);
					} catch (JSONException | IOException e) {
						throw new RuntimeException(e);
					}
					String fileName1 = metaJson.getString("name");
					int size = metaJson.getInt("size");

					return new TempFile(fileId, fileName1, path, size);
				})
				.collect(Collectors.toList());
	}

	public static void deleteFile(HttpSession session, String fileId) throws IOException {
		File tempSessionStorageDir = initTempSessionStorage(session);
		Path tempFilePath = Paths.get(tempSessionStorageDir.getPath(), fileId);
		Path tempFileMetaPath = Paths.get(tempSessionStorageDir.getPath(), fileId + ".meta");
		Files.delete(tempFilePath);
		Files.delete(tempFileMetaPath);
	}

	public static void emptyTempStorageContent(HttpSession session) throws IOException {
		File tempSessionStorageDir = initTempSessionStorage(session);
		File[] files = tempSessionStorageDir.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
	}

	private static void deleteFolder(File folder) {
		File[] files = folder.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					deleteFolder(f);
				} else {
					f.delete();
				}
			}
		}
		folder.delete();
	}

	public static class TempFile {
		private final Path filePath;
		private final String fileId;
		private final String fileName;
		private final int size;

		public TempFile(String fileId, String fileName, Path filePath, int size) {
			this.fileId = fileId;
			this.fileName = fileName;
			this.filePath = filePath;
			this.size = size;
		}

		public InputStream getInputStream() throws IOException {
			return Files.newInputStream(filePath);
		}

		public String getFileName() {
			return fileName;
		}

		public String getFileId() {
			return fileId;
		}

		public int getSize() {
			return size;
		}
	}
}
