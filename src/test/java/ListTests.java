import com.msmaciek.ReversibleHashMap;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ListTests {
    @Test
    void ListTestInsertion() {
        ReversibleHashMap<String, List<Integer>> map = new ReversibleHashMap<>();

        map.put("even", Arrays.asList(2, 4, 6, 8));
        map.put("odd", Arrays.asList(1, 3, 5, 7));

        HashMap assertedReversedHashMap = new HashMap();
        assertedReversedHashMap.put(1, List.of("odd"));
        assertedReversedHashMap.put(2, List.of("even"));
        assertedReversedHashMap.put(3, List.of("odd"));
        assertedReversedHashMap.put(4, List.of("even"));
        assertedReversedHashMap.put(5, List.of("odd"));
        assertedReversedHashMap.put(6, List.of("even"));
        assertedReversedHashMap.put(7, List.of("odd"));
        assertedReversedHashMap.put(8, List.of("even"));

        assertEquals(assertedReversedHashMap, map.getReversedHashMap());
    }

    @Test
    void ListTestReplacement() {
        ReversibleHashMap<String, List<Integer>> map = new ReversibleHashMap<>();

        map.put("even", Arrays.asList(1, 4, 6, 8));
        map.put("odd", Arrays.asList(2, 3, 5, 7));

        map.replace("even", Arrays.asList(2, 4, 6, 8));
        map.replace("odd", Arrays.asList(1, 3, 5, 7));

        HashMap assertedReversedHashMap = new HashMap();
        assertedReversedHashMap.put(1, List.of("odd"));
        assertedReversedHashMap.put(2, List.of("even"));
        assertedReversedHashMap.put(3, List.of("odd"));
        assertedReversedHashMap.put(4, List.of("even"));
        assertedReversedHashMap.put(5, List.of("odd"));
        assertedReversedHashMap.put(6, List.of("even"));
        assertedReversedHashMap.put(7, List.of("odd"));
        assertedReversedHashMap.put(8, List.of("even"));

        assertEquals(assertedReversedHashMap, map.getReversedHashMap());
    }

    @Test
    void ListTestDeletion() {
        ReversibleHashMap<String, List<Integer>> map = new ReversibleHashMap<>();

        map.put("even", Arrays.asList(2, 4, 6, 8));
        map.put("odd", Arrays.asList(1, 3, 5, 7));

        map.remove("odd");

        HashMap assertedReversedHashMap = new HashMap();
        assertedReversedHashMap.put(2, List.of("even"));
        assertedReversedHashMap.put(4, List.of("even"));
        assertedReversedHashMap.put(6, List.of("even"));
        assertedReversedHashMap.put(8, List.of("even"));

        assertEquals(assertedReversedHashMap, map.getReversedHashMap());
    }
}
