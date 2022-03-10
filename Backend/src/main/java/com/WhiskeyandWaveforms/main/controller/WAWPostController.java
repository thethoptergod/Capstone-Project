//package com.WhiskeyandWaveforms.main.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.WhiskeyandWaveforms.main.exception.WAWException;
//import com.WhiskeyandWaveforms.main.model.WAWPost;
//import com.WhiskeyandWaveforms.main.repository.WAWPostRepository;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/post_data/")
//public class WAWPostController {
//@Autowired
//	private WAWPostRepository WAWPRepo;
//	@GetMapping("/allposts/")
//	public List<WAWPost> getAllPosts(){
//		return WAWPRepo.findAll();
//	}
//	@GetMapping("/posts/subject/{subject}")
//	public List<WAWPost> getPostsBySubject(@PathVariable String subject){
//		List<WAWPost> post=WAWPRepo.findBySubject(subject);
//		if(post.isEmpty()) {
//			System.out.print(new WAWException("No posts with the subject "+ subject));
//		}
//		return WAWPRepo.findBySubject(subject);
//	}
//	@GetMapping("/posts/id/{id}")
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
//	public String deleteComment(@PathVariable int id) {
//		WAWPRepo.findById(id).orElseThrow(() -> new WAWException("Comment Not Found"));
//		WAWPRepo.deleteById(id);
//		return "The post (id: "+id+") has been deleted";
//	}
//}
