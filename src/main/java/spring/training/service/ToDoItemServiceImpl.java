package spring.training.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import spring.training.model.ToDoData;
import spring.training.model.ToDoItem;

@Service
public class ToDoItemServiceImpl implements ToDoItemService {

    @Getter
    public final ToDoData data = new ToDoData();

    @Override
    public void addItem(ToDoItem addItem) {
           data.addItem(addItem);
    }

    @Override
    public void removeItem(int number) {
          data.removeItem(number);
    }

    @Override
    public ToDoItem getItem(int number) {
        return data.getItems().get(number);
    }

    @Override
    public void updateItem(ToDoItem updateItem) {
        data.updateItem(updateItem);
    }

}
