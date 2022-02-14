package ru.titov.lesson6.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lesson6HomeworkTest {

    private Lesson6Homework dz;

    @Before
    public void prepare() {
        dz = new Lesson6Homework();
    }

    @Test(expected = RuntimeException.class)
    public void test_task1_empty_array() {
        dz.task1(new int[0]);
    }

    @Test(expected = RuntimeException.class)
    public void test_task1_without_4() {
        dz.task1(new int[]{1, 2, 3});
    }

    @Test
    public void test_task1_where_4_is_not_last() {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        Assert.assertArrayEquals(new int[]{5, 6, 7}, dz.task1(data));
    }

    @Test
    public void test_task1_with_some_4() {
        int[] data = {1, 4, 3, 4, 5, 6, 4};
        Assert.assertArrayEquals(new int[]{}, dz.task1(data));
    }

}