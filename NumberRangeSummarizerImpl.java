import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    
    public Collection<Integer> collect(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] inputArr = input.split(",");
        for (String num : inputArr) {
            try {
                numbers.add(Integer.parseInt(num));
            } catch (NumberFormatException e) {
                // Ignore non-integer inputs
            }
        }
        Collections.sort(numbers);
        return numbers;
    }

   
    public String summarizeCollection(Collection<Integer> input) {
        StringBuilder result = new StringBuilder();
        List<Integer> numbers = new ArrayList<>(input);
        int size = numbers.size();
        int i = 0;
        while (i < size) {
            int start = numbers.get(i);
            int end = numbers.get(i);
            while (i < size - 1 && numbers.get(i + 1) == end + 1) {
                end = numbers.get(i + 1);
                i++;
            }
            if (start == end) {
                result.append(start).append(", ");
            } else {
                result.append(start).append("-").append(end).append(", ");
            }
            i++;
        }
        if (result.length() > 0) {
            result.delete(result.length() - 2, result.length());
        }
        return result.toString();
    }

    // Test the implementation with sample input
    public static void main(String[] args) {
        NumberRangeSummarizerImpl summarizer = new NumberRangeSummarizerImpl();
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);
        System.out.println("Input: " + input);
        System.out.println("Result: " + result);
    }
}
