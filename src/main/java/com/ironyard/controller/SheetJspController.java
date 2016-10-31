package com.ironyard.controller;

import com.ironyard.data.Characterz;
import com.ironyard.repositories.CharacterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Tom on 10/28/16.
 */
@Controller
public class SheetJspController {
    private CharacterRepo characterRepo;
    @Autowired
    public void setPageSortRepo(CharacterRepo pageSortRepo) {
        this.characterRepo = pageSortRepo;
    }



    @RequestMapping(value = "/character/list", method = RequestMethod.GET)
    public String list(Map<String, Object> model)

    {
        Iterable<Characterz> foundIt = null;
        foundIt = characterRepo.findAll();
        // put foundit into model
        model.put("Sheet",foundIt.iterator());

        return "sheet_list";
    }
}
