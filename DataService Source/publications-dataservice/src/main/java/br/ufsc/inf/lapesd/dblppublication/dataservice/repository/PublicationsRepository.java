package br.ufsc.inf.lapesd.dblppublication.dataservice.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import br.ufsc.inf.lapesd.dblppublication.dataservice.model.Publication;

@Component
public class PublicationsRepository {
	
	private List<Publication> publicationList = new ArrayList<>();
	
	@Value("${dataDir}")
    private File dataDir;
	
	
	@PostConstruct
    private void loadPublications() throws FileNotFoundException {

        if (!dataDir.exists())
            throw new FileNotFoundException(dataDir.getPath());
        
        System.out.println("Loading Publications...");        
        File dblpFile = new File(dataDir+File.separator+"dblp.json");

        Type type = new TypeToken<List<Publication>>(){}.getType();
		JsonReader reader = new JsonReader(new FileReader(dblpFile));
		this.publicationList = new Gson().fromJson(reader, type);
        
        System.out.println("Done.");
    } 
	
	
	public List<Publication> getPublications() {
		return this.publicationList;
	}

}
