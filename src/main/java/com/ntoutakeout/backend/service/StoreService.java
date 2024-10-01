package com.ntoutakeout.backend.service;

import com.ntoutakeout.backend.entity.Store;
import com.ntoutakeout.backend.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public List<Store> getStoresSortedByRating() {
        List<Store> storeList = storeRepository.getStoreList();
        storeList.sort(Comparator.comparingDouble(Store::getRank).reversed());
        return storeList;
    }

    public List<Store> getStoresSortedByTime() {
        return storeRepository.getStoreList();
    }

    public List<Store> findStoresByName(String name) {
        return storeRepository.getStoreList().stream()
                .filter(store -> store.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Store> getStoresFilteredAndSorted(String keyword, String sortBy, String sortDir) {
        List<Store> filteredStores = storeRepository.getStoreList().stream()
                .filter(store -> keyword == null || keyword.isEmpty() ||
                        store.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());

        Comparator<Store> comparator = switch (sortBy.toLowerCase()) {
            case "rank" -> Comparator.comparingDouble(Store::getRank);
            case "averagePrice" -> Comparator.comparingDouble(Store::getAveragePrice);
            case "name" -> Comparator.comparing(Store::getName);
            default -> throw new IllegalArgumentException("Invalid sort field: " + sortBy);
        };

        if ("desc".equalsIgnoreCase(sortDir)) {
            comparator = comparator.reversed();
        }

        filteredStores.sort(comparator);

        return filteredStores;
    }
}