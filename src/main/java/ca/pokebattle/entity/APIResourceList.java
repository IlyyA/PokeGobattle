package ca.pokebattle.entity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ca.pokebattle.entity.NamedAPIResource;
/**
 * Used to get information from PokeAPI site using GSON
 * @author Ilyas
 *
 */
public class APIResourceList {
	


	private Integer count;
	private String next;
	private String prev;
	private List<NamedAPIResource> results;
	
	
	private List<NamedAPIResource> getResultInfo(String jsonString) {
		List<NamedAPIResource> result = new ArrayList<NamedAPIResource>();
		Gson gson = new Gson();
		Type listType = new TypeToken<List<NamedAPIResource>>(){}.getType();
		result = gson.fromJson(jsonString, listType);
		
		return result;
	}
	
	
	public final Integer getCount() {
		return count;
	}

	public final void setCount(final Integer count) {
		this.count = count;
	}

	public final String getNext() {
		return next;
	}

	public final void setNext(final String next) {
		this.next = next;
	}

	public final String getPrev() {
		return prev;
	}

	public final void setPrev(final String prev) {
		this.prev = prev;
	}

	public final List<NamedAPIResource> getResults() {
		return results;
	}

	public final void setResults(final List<NamedAPIResource> results) {
		this.results = results;
	}

}
