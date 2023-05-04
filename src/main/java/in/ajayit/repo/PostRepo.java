package in.ajayit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ajayit.entity.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {

}