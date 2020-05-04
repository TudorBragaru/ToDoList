package spring.training.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.training.model.ToDoData;
import spring.training.model.ToDoItem;
import spring.training.service.ToDoItemService;
import spring.training.util.AttributeNames;
import spring.training.util.Mappings;
import spring.training.util.ViewNames;

import java.time.LocalDate;

@Slf4j
@Controller
public class ToDoItemController {

    private final ToDoItemService toDoItemService;

    @Autowired
    private ToDoItemController(ToDoItemService toDoItemService ){
     this.toDoItemService=toDoItemService;
        }



    @ModelAttribute
    public ToDoData toDoData() {
        return toDoItemService.getData();

    }



    @GetMapping(Mappings.ITEMS)
    public String Items () {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String AddEditItem (Model model) {
        ToDoItem toDoItem = new ToDoItem("", "", LocalDate.now());
        model.addAttribute(AttributeNames.TODO_ITEM, toDoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) ToDoItem toDoItem){
        log.info("toDoItem from from = {}", toDoItem);
        toDoItemService.addItem(toDoItem);
        return "redirect:/" + Mappings.ITEMS;
    }


}
