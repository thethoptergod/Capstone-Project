package com.WhiskeyandWaveforms.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WhiskeyandWaveforms.main.model.WAWComment;

import java.util.List;

@Repository
public interface WAWCommentRepository extends JpaRepository<WAWComment,Integer>{

	List<WAWComment> findByName(String name);

}
