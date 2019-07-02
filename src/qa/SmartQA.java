package qa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author JunzhengChen
 * Create Time 2019/7/2 15:46
 */
public class SmartQA {

    public void getResult(String question) {
        String url = "https://westus.api.cognitive.microsoft.com/luis/v2.0/apps/" +
                "26ed3aef-b18c-4c0b-b52e-b736415f007d?timezoneOffset=-360&" +
                "subscription-key=519f444e62d84f70b5b9d5a39fafb1af&q=";
        try {
            URL luisUrl = new URL(url);
            URLConnection luisUrlConnect = luisUrl.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(luisUrlConnect.getInputStream()));
            String urlresult = "";

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }
}
