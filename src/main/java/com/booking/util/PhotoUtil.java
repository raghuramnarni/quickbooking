package com.booking.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
}
