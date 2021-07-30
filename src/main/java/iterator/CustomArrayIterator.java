package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayIterator<T> implements Iterator<T> {
    private final T[][] array;
    int x = 0;
    int y = 0;

    public CustomArrayIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        if (y < array[x].length)
            return true;

        int temp = x;
        while (++temp < array.length)
            if (array[temp].length > 0)
                return true;

        return false;
    }

    @Override
    public T next() {
        if (y < array[x].length)
            return array[x][y++];

        y = 0;
        while (++x < array.length)
            if (array[x].length > 0)
                return array[x][y++];

        throw new NoSuchElementException();
    }
}
