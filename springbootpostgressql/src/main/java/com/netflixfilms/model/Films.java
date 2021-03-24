/**
 * 
 */
package com.netflixfilms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Nasar Reddy
 *
 */

 
@Entity
@Table(name = "films")
public class Films {
	
	@Id
	@GenericGenerator(name = "show_id", strategy = "com.springbootpostgressql.model.GenaratorClass")
	@GeneratedValue(generator = "show_id")  
	@Column(name = "show_id")
	private String showId;
	
	@Column(name = "type",length = 1000)
	private String type;
	
	@Column(name = "title",length = 1000)
	private String title;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "casting")
	private String casting;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "date_added")
	private String dateAdded;
	
	@Column(name = "release_year")
	private Long releaseYear;

	@Column(name = "rating")
	private String rating;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "listed_in")
	private String listed_in;
	
	@Column(name = "description",length = 1000)
	private String description;

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCasting() {
		return casting;
	}

	public void setCasting(String casting) {
		this.casting = casting;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Long getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Long releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getListed_in() {
		return listed_in;
	}

	public void setListed_in(String listed_in) {
		this.listed_in = listed_in;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
