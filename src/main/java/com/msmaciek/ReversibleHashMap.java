package com.msmaciek;

import com.tangosol.util.MapEvent;
import com.tangosol.util.MapListener;
import com.tangosol.util.ObservableHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ReversibleHashMap<K, V> extends ObservableHashMap {
    // Key of reversedHashMap is:
    // if V is single element, then V
    // if V is list, then type of first element in list (type of that list)
    private final HashMap<Object, ArrayList<K>> reversedHashMap;

    public ReversibleHashMap() {
        this.reversedHashMap = new HashMap<>();

        // listen to changes in the original map and apply them to reversedHashMap
        addMapListener(new MapListener() {
            @Override
            public void entryInserted(MapEvent e) {
                K masterKey = (K) e.getKey();
                V masterVal = (V) e.getNewValue();

                if (masterVal instanceof List<?> valList) {
                    // for every element in the list-value, add it to reversedHashmap
                    for (Object newKey : valList) {
                        reversedHashMap.putIfAbsent(newKey, new ArrayList<>());
                        reversedHashMap.get(newKey).add(masterKey);
                    }

                } else {
                    // Single element get reversed (V, K instead of K, V)
                    reversedHashMap.putIfAbsent(masterVal, new ArrayList<>());
                    reversedHashMap.get(masterVal).add(masterKey);
                }
            }

            @Override
            public void entryUpdated(MapEvent e) {
                entryDeleted(e);
                entryInserted(e);
            }

            @Override
            public void entryDeleted(MapEvent e) {
                V oldMasterVal = (V) e.getOldValue();
                K masterKey = (K) e.getKey();

                if (oldMasterVal instanceof List<?> valList) {
                    for (Object newKey : valList) {
                        reversedHashMap.get(newKey).remove(masterKey);
                        removeIfEmpty(newKey);
                    }
                } else {
                    reversedHashMap.get(oldMasterVal).remove(masterKey);
                    removeIfEmpty(oldMasterVal);
                }
            }
        });
    }

    void removeIfEmpty(Object key) {
        if (reversedHashMap.get(key).isEmpty()) {
            reversedHashMap.remove(key);
        }
    }

    public HashMap<Object, ArrayList<K>> getReversedHashMap() {
        return reversedHashMap;
    }
}
