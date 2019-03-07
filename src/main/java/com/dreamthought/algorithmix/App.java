package com.dreamthought.algorithmix;

import com.dreamthought.algorithmix.service.algorithm.MergeAlgorithm;
import com.google.inject.Inject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    @Inject
    MergeAlgorithm algorithm;

    public static void main(String[] args) {
        List left = convertToIntegerList(args[0]);
        List right = convertToIntegerList(args[0]);

        System.out.println(left);

    }

    private static List<Integer> convertToIntegerList(String arg) {
        return Arrays.stream( arg.split(",") ).
            map(Integer::parseInt).
            collect(Collectors.toList());
    }
}
