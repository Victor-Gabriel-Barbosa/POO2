package com.pinboard.pattern.strategy;

import java.util.List;

public interface SearchStrategy<T> {
    List<T> search(List<T> items, String query);
}