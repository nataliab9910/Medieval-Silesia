package app.model.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get() {
        int size = mementoList.size();
        if (size >= 1)
            return mementoList.remove(mementoList.size() - 1);
        return null;
    }
}
