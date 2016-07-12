package com.booking.service.impl;

import com.booking.dao.*;
import com.booking.domain.*;
import com.booking.service.PropertyService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by raghuramn on 6/25/16.
 */
@Service
public class PropertyServiceImpl implements PropertyService{

	@Override
	public void uploadPhotos(MultipartFile file, Long propertyId){
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
								+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				PropertyDAO propertyDAO = new PropertyDAO();
				Property property = propertyDAO.find(propertyId);
				PropertyImageFile imageFile = new PropertyImageFile(file.getName(), serverFile.getPath(), property);
				PropertyImageFileDAO propertyImageFileDAO = new PropertyImageFileDAO();
				propertyImageFileDAO.save(imageFile);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		} else {
			return;
		}
	}

	@Override
	public void uploadDocuments(MultipartFile file, Long propertyId){
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
								+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
								new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				PropertyDAO propertyDAO = new PropertyDAO();
				Property property = propertyDAO.find(propertyId);
				PropertyDocumentFile imageFile = new PropertyDocumentFile(file.getName(), serverFile.getPath(), property);
				PropertyDocumentFileDAO propertyDocumentFileDAO = new PropertyDocumentFileDAO();
				propertyDocumentFileDAO.save(imageFile);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}
		} else {
			return;
		}
	}

}
