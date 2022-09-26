package com.skalio.database.accessobject;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
@Table(name = "files")
public class FileDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Instant createdAt = Instant.now();

	@Column
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Instant modifiedAt;

	@Column(nullable = false)
	@NotNull(message = "Name can not be null!")
	private String name;

	@Column(nullable = false)
	@NotNull(message = "Size can not be null!")
	private Long sizeInBytes;

	@Column(nullable = false)
	private Boolean deleted = false;

	@Column(nullable = false)
	private String mimeType;

	private FileDAO() {
	}

	public FileDAO(String name, Long sizeInBytes, String mimeType) {
		this.name = name;
		this.sizeInBytes = sizeInBytes;
		this.mimeType = mimeType;
		this.deleted = false;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getSizeInBytes() {
		return sizeInBytes;
	}

	public void setSizeInBytes(Long sizeInBytes) {
		this.sizeInBytes = sizeInBytes;
	}

	public String getMimeType() {
		return mimeType;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Instant getModifiedAt() {
		return modifiedAt;
	}
}
