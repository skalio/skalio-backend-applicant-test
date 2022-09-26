package com.skalio.controller;

import com.skalio.controller.mapper.FileMapper;
import com.skalio.database.accessobject.FileDAO;
import com.skalio.datatransferobject.File;
import com.skalio.exception.ConstraintsViolationException;
import com.skalio.exception.EntityNotFoundException;
import com.skalio.service.file.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * All operations with a file will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/files")
public class FileController {

	private final IFileService fileService;

	@Autowired
	public FileController(final IFileService fileService) {
		this.fileService = fileService;
	}

	@GetMapping("/{fileId}")
	public File getFile(@PathVariable long fileId) throws EntityNotFoundException {
		return FileMapper.makeFile(fileService.find(fileId));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public File createFile(@Valid @RequestBody File file) throws ConstraintsViolationException {
		FileDAO fileDAO = FileMapper.makeFileDAO(file);
		return FileMapper.makeFile(fileService.create(fileDAO));
	}

	@DeleteMapping("/{fileId}")
	public void deleteFile(@PathVariable long fileId) throws EntityNotFoundException {
		fileService.delete(fileId);
	}

	@PutMapping("/{fileId}")
	public void updateSize(
			@PathVariable long fileId, @RequestParam long sizeInBytes)
			throws EntityNotFoundException {
		fileService.updateSize(fileId, sizeInBytes);
	}

	@GetMapping
	public List<File> getFiles(@RequestParam String mimeType) {
		return FileMapper.makeFileList(fileService.find(mimeType));
	}
}
