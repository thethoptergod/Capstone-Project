package com.WhiskeyandWaveforms.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WhiskeyandWaveforms.main.exception.WAWException;
import com.WhiskeyandWaveforms.main.model.WAWComment;
import com.WhiskeyandWaveforms.main.model.WAWPost;
import com.WhiskeyandWaveforms.main.repository.WAWCommentRepository;
import com.WhiskeyandWaveforms.main.repository.WAWPostRepository;


@CrossOrigin
@RestController
@RequestMapping("/api/")
public class WAWCommentController {
@Autowired
	private WAWCommentRepository WAWCRepo;
	private WAWPostRepository WAWPRepo;
	@GetMapping("/comment_data/all_comments")
	public List<WAWComment> getAllComments(){
		return WAWCRepo.findAll();
	}
	@GetMapping("/comment_data/comment/id{id}")
	public Optional<WAWComment> getCommentByName(@PathVariable int id){
		Optional<WAWComment> comments=WAWCRepo.findById(id);
		if(comments.isEmpty()) {
			System.out.print(new WAWException("No comments by "+ id));
		}
		return WAWCRepo.findById(id);
	}
	@GetMapping("/comment_data/comment/name{name}")
	public List<WAWComment> getCommentByName(@PathVariable String name){
		List<WAWComment> comments=WAWCRepo.findByName(name);
		if(comments.isEmpty()) {
			System.out.print(new WAWException("No comments by "+ name));
		}
		return WAWCRepo.findByName(name);
	}
	@PutMapping("/comment_data/updatecomment/id{id}")
	public ResponseEntity<WAWComment> updateWAWComment(@PathVariable int id, @RequestBody WAWComment comment){
		WAWComment c= WAWCRepo.findById(id).orElseThrow(() -> new WAWException("Comment Not Found"));
		c.setName(comment.getName());
		c.setComment_text(comment.getComment_text());
		WAWComment updatedComment = WAWCRepo.save(c);
		return ResponseEntity.ok(updatedComment);
	}
	@PostMapping("/comment_data/add_comment")
	public WAWComment newWAWComment(@RequestBody WAWComment comment) {
		return WAWCRepo.save(comment);
	}
	@DeleteMapping("/comment_data/comment/delete/{id}")
	public String deleteComment(@PathVariable int id) {
		WAWCRepo.findById(id).orElseThrow(() -> new WAWException("Comment Not Found"));
		WAWCRepo.deleteById(id);
		return "Your comment (id: "+id+") has been deleted";
	}
//	@GetMapping("/posts/allposts")
//	public List<WAWPost> getAllPosts(){
//		return WAWPRepo.findAll();
//	}
//	@GetMapping("/posts/bysubject/{subject}")
//	public List<WAWPost> getPostsBySubject(@PathVariable String subject){
//		List<WAWPost> post=WAWPRepo.findBySubject(subject);
//		if(post.isEmpty()) {
//			System.out.print(new WAWException("No posts with the subject "+ subject));
//		}
//		return WAWPRepo.findBySubject(subject);
//	}
//	@GetMapping("/posts/byid/{id}")
//	public ResponseEntity<WAWPost> getPostById(@PathVariable int id, @RequestBody WAWPost post){
//		WAWPost p=WAWPRepo.findById(id).orElseThrow(()-> new WAWException("Post Not Found"));
//		return ResponseEntity.ok(p);
//	}
//	@PutMapping("/posts/updatepost/{id}")
//	public ResponseEntity<WAWPost> updateWAWPost(@PathVariable int id, @RequestBody WAWPost post){
//		WAWPost p= WAWPRepo.findById(id).orElseThrow(() -> new WAWException("Post Not Found"));
//		p.setPostTitle(post.getPostTitle());
//		p.setPostContent(post.getPostContent());
//		WAWPost updatedPost = WAWPRepo.save(p);
//		return ResponseEntity.ok(updatedPost);
//	}
//	@PostMapping("/posts/addpost")
//	public WAWPost newWAWPost(@RequestBody WAWPost post) {
//		return WAWPRepo.save(post);
//	}
//	@DeleteMapping("/posts/deletepost/{id}")
//	public String deletePost(@PathVariable int id) {
//		WAWPRepo.findById(id).orElseThrow(() -> new WAWException("Comment Not Found"));
//		WAWPRepo.deleteById(id);
//		return "The post (id: "+id+") has been deleted";
//	}
}

