package spring.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
public class ToDoItemController {

    private final ToDoItemService toDoItemService;

    @Autowired
    private ToDoItemController(ToDoItemService toDoItemService ){
     this.toDoItemService=toDoItemService;
        }



    @ModelAttribute
    public ToDoData toDoData() {
        toDoItemService.addItem(new ToDoItem("six", "six details", LocalDate.now()));
        return toDoItemService.getData();

    }



    @GetMapping(Mappings.ITEMS)
    public String Items () {
        return ViewNames.ITEMS_LIST;
    }

    @PostMapping(Mappings.ADD_ITEMS)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) ToDoItem toDoItem){
        return "redirect/" + Mappings.ITEMS;
    }


}
