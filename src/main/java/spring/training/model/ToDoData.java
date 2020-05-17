package spring.training.model;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.*;

@Slf4j
public class ToDoData {
    private static int idValue = 1;

    private final List<ToDoItem> items = new ArrayList<>();

    public ToDoData(){
     //   addItem(new ToDoItem("first,", "first details", LocalDate.now()) );
     //   addItem(new ToDoItem("second,", "second details", LocalDate.now()) );
     //   addItem(new ToDoItem("third,", "third details", LocalDate.now()) );
     //   addItem(new ToDoItem("forth,", "forth details", LocalDate.now()) );
     //   addItem(new ToDoItem("five,", "five details", LocalDate.now()) );
     //   addItem(new ToDoItem("six", "six details", LocalDate.now()));
    }

    public List<ToDoItem> getItems(){
        return Collections.unmodifiableList(items);
    }


    public void addItem (@NonNull ToDoItem toAdd) {
        //if (toAdd == null) { throw new NullPointerException("toAdd is a required parameter")
        items.sort(Comparator.comparing(ToDoItem::getId));
        ListIterator<ToDoItem> itemIterator = items.listIterator();
        int i = 1;
        for (; i <= items.size(); i ++) {

            ToDoItem item = itemIterator.next();
            log.info("verific obiectul  = {}", item.getTitle());
            if ((item.getId() > i)) {
                log.info("idValue  = {}", idValue);
                idValue = i;

                log.info("idValue  = {}", idValue);
                break;
            }
        }
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue = items.size() + 1;

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
    }


    public void updateItem(@NonNull ToDoItem toUpdate){
        ListIterator<ToDoItem> itemIterator = items.listIterator();
        log.info("ajunge aici?");
        while(itemIterator.hasNext()){
            ToDoItem item = itemIterator.next();

            if (item.equals(toUpdate)){
                itemIterator.set(toUpdate);
                break;
            }
        }
    }


}

