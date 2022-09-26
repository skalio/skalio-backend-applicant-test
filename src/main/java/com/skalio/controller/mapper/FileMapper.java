package com.skalio.controller.mapper;

import com.skalio.database.accessobject.FileDAO;
import com.skalio.datatransferobject.File;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FileMapper {
	public static FileDAO makeFileDAO(File file) {
		return new FileDAO(file.getName(), file.getSizeInBytes(), file.getMimeType());
	}

	public static File makeFile(FileDAO fileDAO) {
		return new File(fileDAO.getId(), fileDAO.getName(), fileDAO.getSizeInBytes(), fileDAO.getModifiedAt(), fileDAO.getMimeType());
	}

	public static List<File> makeFileList(Collection<FileDAO> files) {
		return files.stream()
				.map(FileMapper::makeFile)
				.collect(Collectors.toList());
	}
}
