package hr.tis.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Service
public class SharedService {

    public double convertEURtoUSD(double priceEUR) throws IOException {
        String apiUrl = "https://api.hnb.hr/tecajn-eur/v3?valuta=USD";
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            JSONArray jsonArray = new JSONArray(response.toString());
            JSONObject jsonResponse = new JSONObject(jsonArray.get(0).toString());
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            Number number = format.parse(jsonResponse.getString("srednji_tecaj"));
            double exchangeRate = number.doubleValue();
            return priceEUR * exchangeRate;

        } catch (IOException e) {
            throw new IOException("error getting exchange rate");
        } catch (ParseException e) {
            throw new RuntimeException("error parsing exchange rate");
        }
    }


}
