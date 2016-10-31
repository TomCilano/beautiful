package com.ironyard.repositories;

import com.ironyard.data.Characterz;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Tom on 10/24/16.
 */
public interface CharacterRepo extends CrudRepository<Characterz, Long> {
}
