package com.example.repository;

import com.example.domain.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by raghu.movva on 12/21/2016.
 */
public interface AuthorRepository extends PagingAndSortingRepository<Author,Long> {
}
