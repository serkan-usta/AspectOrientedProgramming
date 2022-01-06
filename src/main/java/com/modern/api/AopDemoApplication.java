package com.modern.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.modern.api.SortUtil ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class AopDemoApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(AopDemoApplication.class, args);
    SortUtil aopTest = context.getBean(SortUtil.class);

    final List<Integer> list = new ArrayList<>(Arrays.asList(99, 7, 78, 10, 17, 8, 19, 91, 15, 1));

    aopTest.bubbleSort(list.stream().mapToInt(Integer::intValue).toArray());
    aopTest.insertionSort(list.stream().mapToInt(Integer::intValue).toArray());
    aopTest.selectionSort(list.stream().mapToInt(Integer::intValue).toArray());
    aopTest.mergeSort(list.stream().mapToInt(Integer::intValue).toArray());
    aopTest.quickSort(list.stream().mapToInt(Integer::intValue).toArray());
    System.exit(0);
  }
}