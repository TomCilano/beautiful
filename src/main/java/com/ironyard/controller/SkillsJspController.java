package com.ironyard.controller;

import com.ironyard.data.Characterz;
import com.ironyard.data.Skills;
import com.ironyard.repositories.CharacterRepo;
import com.ironyard.repositories.SkillsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Tom on 10/28/16.
 */
@Controller
public class SkillsJspController {
    private SkillsRepo skillsRepo;
    private CharacterRepo characterRepo;
    @Autowired
    public void setPageSortRepo(SkillsRepo skillsRepo) {
        this.skillsRepo = skillsRepo;
    }
    @Autowired
    public void setCharacterRepo(CharacterRepo characterRepo){
        this.characterRepo = characterRepo;
    }




    @RequestMapping(value = "/character/skills", method = RequestMethod.GET)
    public String list(Map<String, Object> model)

    {
        Iterable<Skills> foundIt = null;



        foundIt = skillsRepo.findAll();
        // put foundit into model
        model.put("Skill",foundIt.iterator());

        return "detail";
    }
    @RequestMapping(value = "/character/characterSkill", method = RequestMethod.GET)
    public String charlist(Map<String, Object> model){
        Iterable<Characterz> foundIt =null;

        foundIt = characterRepo.findAll();
        model.put("Sheet",foundIt.iterator());

        return "detail";
    }
    @RequestMapping(value = "/character/{id}", method = RequestMethod.GET)
    public Characterz show(@PathVariable long id) {
        return characterRepo.findOne(id);
    }


}
