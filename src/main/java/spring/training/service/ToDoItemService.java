package spring.training.service;

import spring.training.model.ToDoData;
import spring.training.model.ToDoItem;

public interface ToDoItemService {

    void addItem(ToDoItem addItem);
    void removeItem(int number);
    ToDoItem getItem(int number);
    void updateItem(ToDoItem updateItem);
    ToDoData getData();
}
