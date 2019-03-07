package com.dreamthought.algorithmix.service.algorithm;

import com.dreamthought.algorithmix.configuration.BasicModule;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

class MergeOrderedIntegersTest {

    private Injector injector = Guice.createInjector(new com.dreamthought.algorithmix.configuration.BasicModule());

    @Inject
    MergeOrderedIntegers underTest;

    @BeforeEach
    private void setup() {
        injector.injectMembers(this);
    }

    // NOTE THAT I HAVE STARTED USING underscores IN TEST NAMES (ONLY) FOR READABILITY AS THEIR CONTRACT
    // IS WITH HUMANS AND NOT THE REST OF THE SYSTEM.
    @Test
    private void it_Should_Return_A_Presorted_List_When_Merged_With_An_EmptyList() {

        List<Integer> left = Arrays.asList(1,2,3,4,5);
        List<Integer> right = Collections.emptyList();

        List<Integer> mergedList = underTest.merge(left, right);

        assertThat(mergedList, IsIterableContainingInOrder.contains(left.toArray()));
    }

    @Test
    private void it_Should_Return_A_Sorted_List_From_Two_Non_Overlapping_sorted_Lists() {
        List<Integer> left = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> right = Arrays.asList(6, 7, 8, 9, 10);

        List<Integer> mergedList = underTest.merge(left, right);

        assertThat(mergedList, IsIterableContainingInOrder.contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}