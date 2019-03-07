package com.dreamthought.algorithmix.service.algorithm;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class MergeOrderedIntegers implements MergeAlgorithm {


    @Override
    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        int leftIndex = 0;
        int rightIndex = 0;

        List<Integer> result = new ArrayList<>(left.size() + right.size());

        while (leftIndex < left.size() && rightIndex < right.size()) {

            if (left.get(leftIndex) < right.get(rightIndex)) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else if (right.get(rightIndex) < left.get(leftIndex)){
                result.add(leftIndex);
                rightIndex++;
            } else {
                // pick one as they are the same
                result.add(leftIndex);
                leftIndex++;
                rightIndex++;
            }
        }

        // we exhausted one of the lists
        if (leftIndex == left.size()) {
            result.addAll( right.subList(rightIndex, right.size()) );
        }

        if (rightIndex == right.size()) {
            result.addAll(left.subList(leftIndex, left.size() ));
        }

        return result;
    }
}
