package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@RequiredArgsConstructor
@Builder
@Table(name = "tbl_memo")
@Entity
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 200, nullable = false)    
    private String userid;
    
    @Column(length = 50, nullable = false)
	private String password; 	
    
    @Column(length = 300, nullable = false)
    private String addr;
	
	public Memo(Long id, String userid, String password, String addr) {
		this.id = id;
		this.userid = userid;
		this.password = password;	
		this.addr = addr;
	}

}
