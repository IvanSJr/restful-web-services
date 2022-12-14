package com.github.ivansjr.restfulwebservices.user;

import com.github.ivansjr.restfulwebservices.jpa.PostRepository;
import com.github.ivansjr.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    @Autowired
    private UserDaoService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping(value = "/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable Integer id){
        User user = checkIfUserExists(id);
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @DeleteMapping(value = "/jpa/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Integer id){
        userRepository.deleteById(id);
    }

    @PostMapping(value = "/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User userSaved = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userSaved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping(value = "/jpa/users/{id}/posts")
    public List<Post> retrievePostsUser(@PathVariable Integer id) {
        User user = checkIfUserExists(id);
        return user.getPosts();
    }

    @PostMapping(value = "jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable Integer id, @Valid @RequestBody Post post) {
        User user = checkIfUserExists(id);
        post.setUser(user);
        Post postSaved = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postSaved.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    private User checkIfUserExists(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("id: "+ id);
        return user.get();
    }

}
