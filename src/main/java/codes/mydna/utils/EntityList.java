package codes.mydna.utils;

import java.util.ArrayList;
import java.util.List;

public class EntityList<E> {
    private List<E> list;
    private Long count;

    public EntityList() {
        this.list = new ArrayList<E>();
        this.count = count;
    }

    public EntityList(List<E> list) {
        this.list = list;
        this.count = (long)list.size();
    }

    public EntityList(List<E> list, Long count) {
        this.list = list;
        this.count = count;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
