//package numberrangesummarizer;

import java.util.Collection;

public interface NumberRangeSummarizer {

    // Collect the input
    Collection<Integer> collect(String input);

    // Get the summarized string
    String summarizeCollection(Collection<Integer> input);

    // Default method to summarize the collection and return as a string
    default String summarize(String input) {
        Collection<Integer> collection = collect(input);
        return summarizeCollection(collection);
    }
}


