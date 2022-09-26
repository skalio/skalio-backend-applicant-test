package com.skalio.service.file;

import com.skalio.database.accessobject.FileDAO;
import com.skalio.exception.ConstraintsViolationException;
import com.skalio.exception.EntityNotFoundException;

import java.util.List;

public interface IFileService {

	FileDAO find(Long fileId) throws EntityNotFoundException;

	FileDAO create(FileDAO fileDAO) throws ConstraintsViolationException;

	void delete(Long fileId) throws EntityNotFoundException;

	void updateSize(long fileId, long sizeInBytes) throws EntityNotFoundException;

	List<FileDAO> find(String mimeType);

}
