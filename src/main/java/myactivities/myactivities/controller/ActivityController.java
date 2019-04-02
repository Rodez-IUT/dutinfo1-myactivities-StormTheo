package myactivities.myactivities.controller;

import myactivities.myactivities.model.Activity;
import myactivities.myactivities.model.ActivityDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ActivityController {

    @Autowired
    private ActivityDAOService activityDAOService;

    @GetMapping("/")
    public String allActivities(Model model) {
        List<Activity> activityList = activityDAOService.findAllActivities();
        model.addAttribute("activities", activityList);
        return "index";
    }

    @GetMapping("/fixActivities")
    public String fixActivities(Model model) {
        activityDAOService.fixActivities();
        return allActivities(model);
    }

}
