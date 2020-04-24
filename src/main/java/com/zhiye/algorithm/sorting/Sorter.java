package com.zhiye.algorithm.sorting;

import java.util.HashMap;
import java.util.Map;

public class Sorter {

    private static final Sorter instance = new Sorter();

    private Map<Class<? extends ISort>, ISort> sorts = new HashMap<>();

    private Sorter() {
    }

    public static Sorter getInstance() {
        return instance;
    }

    public ISort put(ISort sort) {
        return sorts.put(sort.getClass(), sort);
    }

    public ISort remove(ISort sort) {
        return sorts.remove(sort.getClass());
    }

    public int[] sort(Class<? extends ISort> clazz, int[] array) {
        ISort sort = sorts.get(clazz);
        if (sort == null) {
            try {
                sort = clazz.newInstance();
                sorts.put(clazz, sort);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return sort.sort(array, 0, array.length - 1);
    }
}
