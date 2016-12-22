package com.example;

import com.example.domain.Author;
import com.example.domain.Post;
import com.example.repository.AuthorRepository;
import com.example.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HypermediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HypermediaApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository) {
		return new CommandLineRunner() {
			public void run(String... args) {
				Stream.of(new Author("Raghu","Movva","movvar@gmail.com"),
						new Author("Roja","Movva","roja.movva@gmail.com")).forEach(n->authorRepository.save(n));


				Author dv = new Author("Dan","Vega","danvega@gmail.com");
				authorRepository.save( dv );
				authorRepository.findAll().forEach(System.out::println);

				Post post = new Post("Spring Boot Rocks!");
				post.setSlug("spring-data-rocks");
				post.setTeaser("Post Teaser");
				post.setBody("Post Body");
				post.setPostedOn(new Date());
				post.setAuthor(dv);
				postRepository.save(post);

				Post rest = new Post("REST is what all the cool kids are doing");
				rest.setSlug("rest-is-cool");
				rest.setTeaser("REST Teaser");
				rest.setBody("REST BODY");
				rest.setPostedOn(new Date());
				rest.setAuthor(dv);
				postRepository.save(rest);
			}
		};
	}
}
