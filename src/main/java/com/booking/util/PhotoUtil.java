package com.booking.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by raghuramn on 7/13/16.
 */
public class PhotoUtil {

	public static boolean validateRequestedFiles(MultipartFile file, List<String> errorMsg) {
		boolean validationResult = true;
    /* Check that it is a supported image types */
		String fileExtension =
						CommonUtil.getFileExtension(file
										.getOriginalFilename());
		if (!(fileExtension.toLowerCase().equals("gif")
						|| fileExtension.toLowerCase().equals("jpg")
						|| fileExtension.toLowerCase().equals("jpeg") || fileExtension.toLowerCase()
						.equals("png"))) {
			errorMsg
							.add("Sorry, we do not support files in this format. Please check the acceptable formats and try again.");
			return false;
		}
		return validationResult;
	}

	public static File uploadPhoto(MultipartFile file, Long id){
		try {
			byte[] bytes = file.getBytes();

			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "tmpFiles");
			if (!dir.exists())
				dir.mkdirs();

			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
							+ File.separator +id +"_"+file.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			return serverFile;
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
}
