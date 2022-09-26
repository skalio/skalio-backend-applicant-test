package com.skalio.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class File {
	private Long id;

	@NotNull(message = "Name can not be null!")
	private String name;

	@NotNull(message = "Size can not be null!")
	private Long sizeInBytes;

	private Instant modifiedAt;

	private String mimeType;

	private File() {}

	public File(Long id, String name, Long sizeInBytes, Instant modifiedAt, String mimeType) {
		this.id = id;
		this.name = name;
		this.sizeInBytes = sizeInBytes;
		this.modifiedAt = modifiedAt;
		this.mimeType = mimeType;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getSizeInBytes() {
		return sizeInBytes;
	}

	public String getMimeType() {
		return mimeType;
	}

	public Instant getModifiedAt() {
		return modifiedAt;
	}
}
