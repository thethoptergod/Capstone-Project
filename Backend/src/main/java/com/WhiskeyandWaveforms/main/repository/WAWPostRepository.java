package com.WhiskeyandWaveforms.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WhiskeyandWaveforms.main.model.WAWPost;

@Repository
public interface WAWPostRepository extends JpaRepository<WAWPost,Integer>{
		List<WAWPost> findByPostTitle(String postTitle);
		List<WAWPost> findBySubject(String subject);
}
