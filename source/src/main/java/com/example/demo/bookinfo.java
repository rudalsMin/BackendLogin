package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@RequiredArgsConstructor
@Table(name="tbl_bookinfo")
@Entity
@Builder
public class bookinfo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 200, nullable = false)
	private String name;
	
	@Column(length = 50, nullable = false)
	private String isbn;
	
	@Column(length = 50, nullable = false)
	private String author;
	
	@Column(length = 50, nullable = false)
	private LocalDate publishDate;
	
	@Column(length = 500, nullable = false)
	private String info;
	
	public bookinfo(Long id, String name, String isbn, String author, LocalDate publisherDate, String info) {
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.author = author; 
		this.publishDate = publisherDate;
		this.info = info;
	}
	
}