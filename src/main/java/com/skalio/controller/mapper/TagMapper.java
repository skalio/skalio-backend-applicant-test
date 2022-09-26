package com.skalio.controller.mapper;

import com.skalio.database.accessobject.TagDAO;
import com.skalio.datatransferobject.Tag;

public class TagMapper {

	public static TagDAO makeTagDAO(Tag tag) {
		return new TagDAO(tag.getLabel(), tag.getColor());
	}

	public static Tag makeTag(TagDAO tagDAO) {
		return new Tag(tagDAO.getId(), tagDAO.getCreatedAt(), tagDAO.getLabel(), tagDAO.getColor());
	}
}
