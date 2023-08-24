package com.example.Register_login.Entity;

import java.util.Date;

//import jakarta.annotation.Generated;
import jakarta.persistence.*;


@Entity
@Table(name="note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title", length = 255)
    private String title;
    @Column(name="content", length = 255)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Note(Long id, String title, String content, Date createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}

	public Note() {
		
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt + "]";
	}

    
    // Constructors, getters, and setters
}
