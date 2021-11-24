package com.example.demo.service;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Library;

public interface LibraryService {
	List<Library> getAllBooks();
	
	void saveBook(Library library);

	public List<Library> getByKeyword(String keyword);
}
