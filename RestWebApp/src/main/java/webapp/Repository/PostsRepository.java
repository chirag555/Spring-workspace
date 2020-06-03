package webapp.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.entity.Post;

public interface PostsRepository extends CrudRepository<Post,Integer>{

}
