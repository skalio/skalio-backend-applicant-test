package com.skalio.datatransferobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.skalio.datatransferobject.enums.Color;

import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tag {
	private Long id;

	private Instant createdAt;

	private String label;

	private Color color;

	public Tag(Long id, Instant createdAt, String label, Color color) {
		this.id = id;
		this.createdAt = createdAt;
		this.label = label;
		this.color = color;
	}

	public Long getId() {
		return id;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
