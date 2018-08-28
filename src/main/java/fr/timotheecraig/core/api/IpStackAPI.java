package fr.timotheecraig.core.api;

import fr.timotheecraig.core.security.SecurityConstants;
import fr.timotheecraig.core.utils.JsonReader;
import org.json.JSONObject;

import java.io.IOException;

public class IpStackAPI {

    private static final String BASE_URL = "http://api.ipstack.com/";

    public static String getCountryFromIp(String ipAddress) {
        try {
            JSONObject jsonObject = JsonReader.readJsonFromUrl(BASE_URL + ipAddress + "?access_key=" + SecurityConstants.IP_STACK_API_KEY);
            return ((jsonObject.has("country_name") && !jsonObject.isNull("country_name"))) ? jsonObject.getString("country_name") : null;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
