package com.booking.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by raghuramn on 7/13/16.
 */
public class CommonUtil {

	public boolean validateMimeType(MultipartFile file){

		return  false;
	}

	public static String getFileExtension(String fileName) {
		String fileExtension = null;
		if (!StringUtils.isEmpty(fileName)) {
			fileExtension = fileName.substring(fileName.lastIndexOf('.') + 1);
		}
		return fileExtension;
	}
}
