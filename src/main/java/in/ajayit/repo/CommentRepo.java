package in.ajayit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ajayit.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}