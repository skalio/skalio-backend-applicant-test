package com.skalio.database;

import com.skalio.database.accessobject.FileDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Database Access Object for files table.
 * <p/>
 */
public interface IFileRepository extends CrudRepository<FileDAO, Long> {

	List<FileDAO> findByMimeType(String mimeType);
}
