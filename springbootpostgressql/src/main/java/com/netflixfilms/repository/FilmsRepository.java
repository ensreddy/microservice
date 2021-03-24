package com.netflixfilms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflixfilms.model.Films;


@Repository
public interface FilmsRepository extends JpaRepository<Films, Long>{
	@Query("select f from Films f where f.title = ?1 order by f.dateAdded")
	List<Films> findByTitleName(String title);

}
