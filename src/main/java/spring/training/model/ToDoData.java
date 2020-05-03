package spring.training.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ToDoData {
    private static int idValue = 1;

    private final List<ToDoItem> items = new ArrayList<>();

    public ToDoData(){
        addItem(new ToDoItem("first,", "first details", LocalDate.now()) );
        addItem(new ToDoItem("second,", "second details", LocalDate.now()) );
        addItem(new ToDoItem("third,", "third details", LocalDate.now()) );
        addItem(new ToDoItem("forth,", "forth details", LocalDate.now()) );
        addItem(new ToDoItem("five,", "five details", LocalDate.now()) );
    }

    public List<ToDoItem> getItems(){
        return Collections.unmodifiableList(items);
    }


    public void addItem (@NonNull ToDoItem toAdd) {
        //if (toAdd == null) { throw new NullPointerException("toAdd is a required parameter")
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue ++;
    }

    public void removeItem(int id) {
        ListIterator<ToDoItem> itemIterator = items.listIterator();

        while(itemIterator.hasNext()){
            ToDoItem item = itemIterator.next();

            if (item.getId() == id) {
                itemIterator.remove();
                break;
            }
        }
        int i = 1;
        for (; i < items.size(); i ++) {
            ToDoItem item = itemIterator.next();
            if (!(item.getId() == i)) {
                item.setId(i);
            }
            idValue = i;
        }
    }


    public void updateItem(@NonNull ToDoItem toUpdate){
        ListIterator<ToDoItem> itemIterator = items.listIterator();
        while(itemIterator.hasNext()){
            ToDoItem item = itemIterator.next();

            if (item.equals(toUpdate)){
                itemIterator.set(toUpdate);


            }
        }
    }

}

