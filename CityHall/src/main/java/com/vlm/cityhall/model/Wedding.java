package com.vlm.cityhall.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Wedding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private LocalDate date_of_wedding;
    private String location;
	public Wedding() {
	}
	public Wedding(Long id, LocalDate date_of_wedding, String location) {
		this.id = id;
		this.date_of_wedding = date_of_wedding;
		this.location = location;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate_of_wedding() {
		return date_of_wedding;
	}
	public void setDate_of_wedding(LocalDate date_of_wedding) {
		this.date_of_wedding = date_of_wedding;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
    
}
