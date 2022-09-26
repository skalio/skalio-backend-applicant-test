package com.skalio.service.file;

import com.skalio.database.IFileRepository;
import com.skalio.database.accessobject.FileDAO;
import com.skalio.exception.ConstraintsViolationException;
import com.skalio.exception.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some file specific things.
 * <p/>
 */
@Service
public class DefaultFileService implements IFileService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultFileService.class);

	private final IFileRepository fileRepository;

	public DefaultFileService(final IFileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	/**
	 * Selects a file by id.
	 *
	 * @param fileId
	 * @return found file
	 * @throws EntityNotFoundException if no file with the given id was found.
	 */
	@Override
	public FileDAO find(Long fileId) throws EntityNotFoundException {
		FileDAO fileDAO = findFileChecked(fileId);
		if (fileDAO.getDeleted()) {
			throw new EntityNotFoundException("Could not find entity with id: " + fileId);
		}
		return fileDAO;
	}

	/**
	 * Creates a new file.
	 *
	 * @param fileDAO
	 * @return
	 * @throws ConstraintsViolationException if a file already exists with the given name, ... .
	 */
	@Override
	public FileDAO create(FileDAO fileDAO) throws ConstraintsViolationException {
		FileDAO file;
		try {
			file = fileRepository.save(fileDAO);
		} catch (DataIntegrityViolationException e) {
			LOG.warn("ConstraintsViolationException while creating a file: {}", fileDAO, e);
			throw new ConstraintsViolationException(e.getMessage());
		}
		return file;
	}

	/**
	 * Deletes an existing file by id.
	 *
	 * @param fileId
	 * @throws EntityNotFoundException if no file with the given id was found.
	 */
	@Override
	@Transactional
	public void delete(Long fileId) throws EntityNotFoundException {
		FileDAO fileDAO = findFileChecked(fileId);
		fileDAO.setDeleted(true);
	}

	/**
	 * Update the size for a file.
	 *
	 * @param fileId
	 * @param sizeInBytes
	 * @throws EntityNotFoundException
	 */
	@Override
	@Transactional
	public void updateSize(long fileId, long sizeInBytes) throws EntityNotFoundException {
		FileDAO fileDAO = findFileChecked(fileId);
		fileDAO.setSizeInBytes(sizeInBytes);
	}

	/**
	 * Find all files by a mime type.
	 *
	 * @param mimeType
	 */
	@Override
	public List<FileDAO> find(String mimeType) {
		return fileRepository.findByMimeType(mimeType);
	}

	private FileDAO findFileChecked(Long fileId) throws EntityNotFoundException {
		return fileRepository.findById(fileId)
				.orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + fileId));

	}
}
