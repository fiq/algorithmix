package com.dreamthought.algorithmix.service.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeOrderedIntPrimitives implements MergeAlgorithm {
    @Override
    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        int[] leftPrimitives = left.stream().mapToInt(Integer::intValue).toArray();
        int[] rightPrimitives = left.stream().mapToInt(Integer::intValue).toArray();
        int[] result = new int[left.size() + right.size()];
        int resultHead = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < leftPrimitives.length && rightIndex < rightPrimitives.length) {
            int leftValue = leftPrimitives[leftIndex];
            int rightValue = rightPrimitives[rightIndex];

            if (leftValue < rightValue) {
                leftIndex++;
                result[++resultHead] = leftValue;
            } else if (rightValue < leftValue) {
                rightIndex++;
                result[++resultHead] = rightValue;
            } else {
                leftIndex++;
                rightIndex++;
                result[++resultHead] = rightValue;
            }
        }

        if (leftIndex < leftPrimitives.length) {
            for (; leftIndex < leftPrimitives.length; leftIndex++) {
                result[++resultHead] = leftPrimitives[leftIndex];
            }
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

}