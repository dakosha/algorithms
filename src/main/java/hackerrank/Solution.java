package hackerrank;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Dauren Mussa
 * @since 4/13/18
 */
public class Solution {

    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) throws InterruptedException {

        int[] result = new int[lowerLimits.length];





        return result;

    }

    static class RegularScore {
        int value;

    }



    /*static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {

        TreeMap<Integer, TreeMap<Integer, Tuple>> map = new TreeMap<>();

        for (int i=0; i<lowerLimits.length; i++) {
            TreeMap<Integer, Tuple> lowerVal = map.get(lowerLimits[i]);

            if (lowerVal==null) {
                lowerVal = new TreeMap<>();
                map.put(lowerLimits[i], lowerVal);
            }

            Tuple tuple = lowerVal.get(upperLimits[i]);
            if (tuple==null) {
                tuple = new Tuple();
                tuple.indexes.add(i);
                lowerVal.put(upperLimits[i], tuple);
            } else {
                tuple.indexes.add(i);
            }

        }

        int[] result = new int[lowerLimits.length];

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];



        }

        return result;

    }*/

    static String[] getMovieTitles(String substr) throws IOException {
        String mainUrl = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%1$s";
        String mainUrlWithPage = "https://jsonmock.hackerrank.com/api/movies/search/?Title=%1$s&page=%2$s";
        mainUrl = String.format(mainUrl, substr);

        URL url = new URL(mainUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        List<String> result = new ArrayList<>();

        int status = con.getResponseCode();
        if (status == 200) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            JsonElement jelement = new JsonParser().parse(content.toString());
            JsonObject jobject = jelement.getAsJsonObject();

            int totalPages = jobject.get("total_pages").getAsInt();
            int totalMovies = jobject.get("total").getAsInt();
            int currentPage = jobject.get("page").getAsInt();
            int perPage = jobject.get("per_page").getAsInt();

            con.disconnect();

            for (int i = currentPage; i <= totalPages; i++) {
                String currentRequest = String.format(mainUrlWithPage, substr, i);
                url = new URL(currentRequest);
                con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                status = con.getResponseCode();
                if (status == 200) {

                    in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));

                    content = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();

                    jelement = new JsonParser().parse(content.toString());
                    jobject = jelement.getAsJsonObject();

                    JsonArray data = jobject.get("data").getAsJsonArray();
                    for (int j = 0; j < data.size(); j++) {
                        String title = data.get(j).getAsJsonObject().get("Title").getAsString();
                        result.add(title);
                    }

                }
                con.disconnect();
            }

        }

        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }

    /*public static void main(String[] args) throws IOException {
        for (String val : getMovieTitles("spiderman")) {
            System.out.println(val);
        }
    }*/


    public static void main(String[] args) throws InterruptedException {
        int[] scores = {4, 8, 7};
        int[] lowerLimits = {2, 4};
        int[] upperLimits = {8, 4};

        int[] res = jobOffers(scores, lowerLimits, upperLimits);

        for (int val : res) {
            System.out.println(val);
        }
    }

}
