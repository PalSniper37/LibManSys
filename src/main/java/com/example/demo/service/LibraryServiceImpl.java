package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Override
	public List<Library> getAllBooks() {
		return libraryRepository.findAll();
	}

	@Override
	public void saveBook(Library library) {
		this.libraryRepository.save(library);	
	}
	
	@Override
	public List<Library> getByKeyword(String keyword) {
		return libraryRepository.findByKeyword(keyword);
	}

	
}
