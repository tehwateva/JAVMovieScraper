package moviescraper.doctord.SiteParsingProfile;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class SiteParsingProfileJSON extends SiteParsingProfile {

	public String getJSONStringFromURL(String url) throws IOException
	{
		String json = Jsoup.connect(url).ignoreContentType(true).execute().body();
		return json;
	}
	
	public JSONObject getJSONObjectFromString (String jsonString) throws JSONException
	{
		JSONObject jsonObject =  new JSONObject(jsonString);
		return jsonObject;
	}
	
	public JSONObject getJSONObjectFromURL(String url) throws JSONException, IOException{
		return getJSONObjectFromString(getJSONStringFromURL(url));
	}
	
	public static Document getDocument(String url) throws IOException
	{
		return Jsoup.connect(url).ignoreContentType(true).get();
	}
	
	
}
