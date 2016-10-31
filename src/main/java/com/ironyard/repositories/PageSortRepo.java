package com.ironyard.repositories;


import com.ironyard.data.Characterz;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Tom on 10/25/16.
 */
public interface PageSortRepo extends PagingAndSortingRepository<Characterz, Long> {
}
