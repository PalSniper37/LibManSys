package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{

	@Modifying 
//	 @Query(value = "select * from Library123 l where l.book_name like '%:keyword%'\r\n"
//	 		+ "	 				OR l.author_name like '%:keyword%' \r\n"
//	 		+ "	 		 		OR l.book_id like '%:keyword%' ", nativeQuery = true)
//	 List<Library> findByKeyword(@Param("keyword") String keyword);
//}

@Query(value = "select l from Library l where l.bookName like %:keyword% "
 		+ "	 				OR l.authorName like %:keyword%"
 		+ "	 		 		OR l.bookId like %:keyword% ", nativeQuery = false)

List<Library> findByKeyword(@Param("keyword") String keyword);
}