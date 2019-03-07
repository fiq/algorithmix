package com.dreamthought.algorithmix.configuration;

import com.dreamthought.algorithmix.service.algorithm.MergeAlgorithm;
import com.dreamthought.algorithmix.service.algorithm.MergeOrderedIntegers;
import com.google.inject.AbstractModule;

public class BasicModule extends AbstractModule {

    @Override
    public void configure() {
        bind(MergeAlgorithm.class).to(MergeOrderedIntegers.class);
    }

}
