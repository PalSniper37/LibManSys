package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;
import com.example.demo.service.LibraryService;

@Controller
public class LibraryController {

	@Autowired
	private LibraryService libraryService;
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listBooks", libraryService.getAllBooks());
		return "index";
	}
	
	@GetMapping("/showNewBookForm")
	public String showNewBookForm(Model model) {
		Library library = new Library();
		model.addAttribute("library", library);
		return "new_book";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("library") Library library) {
		libraryService.saveBook(library);
		return "redirect:/";	
	}
	
	 @RequestMapping(path = {"/search"})
	 public String findByKeyword(Library shop, Model model, @RequestParam("keyword") String keyword) {
	  if(keyword!=null) {
	   List<Library> list = libraryService.getByKeyword(keyword);
	   System.out.println(keyword);
	   model.addAttribute("listBooks", list);
	   System.out.println(list.size());
	  }else {
	  List<Library> list = libraryService.getAllBooks();
	  model.addAttribute("listBooks", list);
	  }
	  return "index";
	 }
	
	
}
