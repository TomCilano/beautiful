package com.ironyard.controller;

import com.ironyard.repositories.CharacterRepo;
import com.ironyard.repositories.PageSortRepo;
import com.ironyard.data.Characterz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Tom on 10/24/16.
 */
@RestController
public class SheetController {
    private CharacterRepo characterRepo;
    private PageSortRepo pageSortRepo;

    @Autowired
    public void setCharacterRepo(CharacterRepo aCharacterRepo) {
        this.characterRepo = aCharacterRepo;
    }

    @Autowired
    public void setPageSortRepo(PageSortRepo pageSortRepo) {
        this.pageSortRepo = pageSortRepo;
    }

    @RequestMapping(value = "/service/character", method = RequestMethod.POST, produces = "application/json")
    public Characterz save(@RequestBody Characterz one) {
        characterRepo.save(one);
        return characterRepo.findOne(one.getId());
    }
//      extra listing method
//    @RequestMapping(value = "/characters", method = RequestMethod.GET)
//    public Iterable<Characterz> listAll() {
//        Iterable<Characterz> found = characterRepo.findAll();
//        return found;
//    }

    @RequestMapping(value = "/service/characters/update", method = RequestMethod.PUT)
    public Characterz update(@RequestBody Characterz one) {
        characterRepo.save(one);
        return characterRepo.findOne(one.getId());
    }

    @RequestMapping(value = "/service/character/delete/{id}", method = RequestMethod.DELETE)
    public Characterz delete(@PathVariable long id) {
        Characterz deleted = characterRepo.findOne(id);
        characterRepo.delete(id);
        return deleted;
    }

    @RequestMapping(value = "/service/character/{id}", method = RequestMethod.GET)
    public Characterz show(@PathVariable long id) {
        return characterRepo.findOne(id);
    }

    @RequestMapping(value = "/service/characters", method = RequestMethod.GET)
    public Iterable<Characterz> list(@RequestParam(value = "page") Integer page,
                                     @RequestParam(value = "size") Integer size,
                                     @RequestParam(value = "sort", required = false) String sort,
                                     @RequestParam(value = "dir", required = false) Sort.Direction direction)

    {
        Iterable<Characterz> foundIt = null;

        if (sort == null) {
            sort = "name";


        }
        if (direction == null) {
            direction = Sort.Direction.DESC;

        }
        Sort newSort = new Sort(direction, sort);

        PageRequest pageRequest = new PageRequest(page, size, newSort);
        foundIt = pageSortRepo.findAll(pageRequest);
        return foundIt;
    }
}
