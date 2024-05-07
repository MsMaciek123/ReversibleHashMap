import com.msmaciek.ReversibleHashMap;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"rawtypes", "unchecked"})
public class SingleTests {

    @Test
    void SingleElementTestInsertion() {
        ReversibleHashMap<String, Integer> map = new ReversibleHashMap<>();

        map.put("even", 2);
        map.put("odd", 1);

        HashMap assertedReversedHashMap = new HashMap();
        assertedReversedHashMap.put(1, List.of("odd"));
        assertedReversedHashMap.put(2, List.of("even"));

        assertEquals(assertedReversedHashMap, map.getReversedHashMap());
    }

    @Test
    void SingleElementTestReplacement() {
        ReversibleHashMap<String, Integer> map = new ReversibleHashMap<>();

        map.put("even", 1);
        map.put("odd", 2);

        map.replace("even", 4);
        map.replace("odd", 3);

        HashMap assertedReversedHashMap = new HashMap();
        assertedReversedHashMap.put(3, List.of("odd"));
        assertedReversedHashMap.put(4, List.of("even"));

        assertEquals(assertedReversedHashMap, map.getReversedHashMap());
    }

    @Test
    void SingleElementTestDeletion() {
        ReversibleHashMap<String, Integer> map = new ReversibleHashMap<>();

        map.put("even", 2);
        map.put("odd", 1);

        map.remove("odd");

        HashMap assertedReversedHashMap = new HashMap();
        assertedReversedHashMap.put(2, List.of("even"));

        assertEquals(assertedReversedHashMap, map.getReversedHashMap());
    }
}
