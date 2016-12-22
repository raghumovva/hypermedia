package com.example.repository;

import com.example.domain.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by raghu.movva on 12/21/2016.
 */
@RepositoryRestResource(path = "blogposts")
public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
    public List<Post> findByTitleContaining(@Param("title") String title);
}
