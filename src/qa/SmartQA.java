package qa;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author JunzhengChen
 * Create Time 2019/7/2 15:46
 */
public class SmartQA {

    public String getResult(String question) {
        String questionUrl = null;
        try {
            questionUrl = URLEncoder.encode(question, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = "https://westus.api.cognitive.microsoft.com/luis/v2.0/apps/" +
                "26ed3aef-b18c-4c0b-b52e-b736415f007d?timezoneOffset=-360&" +
                "subscription-key=519f444e62d84f70b5b9d5a39fafb1af&q=" + questionUrl;
        try {
            URL luisUrl = new URL(url);
            HttpURLConnection luisUrlConnect = (HttpURLConnection) luisUrl.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(luisUrlConnect.getInputStream()));
            StringBuilder urlResult = new StringBuilder();
            String inputLine = null;
            while ((inputLine = br.readLine()) != null) {
                urlResult.append(inputLine);
            }
            JSONObject jsonObject = (JSONObject) JSONObject.parse(urlResult.toString());
            return jsonObject.getJSONObject("topScoringIntent").get("intent").toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SmartQA smartQA = new SmartQA();
        smartQA.getResult("宾馆怎么去");
    }
}
