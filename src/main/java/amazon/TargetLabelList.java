package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Dauren Mussa
 * @since 1/14/18
 */
public class TargetLabelList {

    public static void main(String[] args) {
        TargetLabelList list = new TargetLabelList();

        List<String> targetList = Arrays.asList("made", "in", "spain");
        List<String> availableList = Arrays.asList("made", "weather", "forecast", "says", "that", "made", "rain", "in", "spain", "stays");

        List<Integer> result = list.subSequenceTags(targetList, availableList);

        for (Integer value : result) {
            System.out.println(value);
        }
    }

    List<Integer> subSequenceTags(List<String> targetList,
                                  List<String> availableTagList) {
        //In case availableList is Linked or other not array
        if (!(availableTagList instanceof ArrayList)) {
            availableTagList = new ArrayList<>(availableTagList);
        }

        Set<String> targetSet = new HashSet<>(targetList.size() % 50);
        targetSet.addAll(targetList);

        int start = 0;
        int end = 0;

        //find first index
        for (int i = 0; i < availableTagList.size(); i++) {
            if (targetSet.contains(availableTagList.get(i))) {
                start = i;
                end = i;
                break;
            }
        }
        if (availableTagList.size() - start < targetSet.size()) {
            return Arrays.asList(0);
        }


        Set<String> localSet = new HashSet<>(targetSet);
        List<List<Integer>> results = new ArrayList<>();

        while (true) {
            String currentTag = availableTagList.get(end);
            localSet.remove(currentTag);
            end++;

            if (localSet.isEmpty()) {
                results.add(Arrays.asList(start, end - 1));
                start++;

                for (int i = start; i < availableTagList.size(); i++) {
                    if (targetSet.contains(availableTagList.get(i))) {
                        start = i;
                        end = i;
                        break;
                    }
                }

                localSet.addAll(targetSet);
            }

            if (end == availableTagList.size()) {
                break;
            }
        }

        if (results.size()>0) {
            int min = results.get(0).get(1) - results.get(0).get(0);
            List<Integer> res = results.get(0);
            for (int i=1; i<results.size(); i++) {
                int newMin = results.get(i).get(1) - results.get(i).get(0);
                if (newMin < min) {
                    min = newMin;
                    res = results.get(i);
                }
            }
            return res;
        }

        return Arrays.asList(0);

    }

}
