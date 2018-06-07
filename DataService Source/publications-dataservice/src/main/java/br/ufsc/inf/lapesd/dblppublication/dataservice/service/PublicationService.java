package br.ufsc.inf.lapesd.dblppublication.dataservice.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufsc.inf.lapesd.dblppublication.dataservice.model.Publication;
import br.ufsc.inf.lapesd.dblppublication.dataservice.repository.PublicationsRepository;

@Component
public class PublicationService {
	
	@Autowired
    private PublicationsRepository publicationsRepository;
	
	
	public List<Publication> loadPublications() {
		return publicationsRepository.getPublications();
	}
	
	
	public Publication loadRandomPublication() {
		List<Publication> publications = publicationsRepository.getPublications();
		int i = new Random().nextInt(publications.size()) + 0;
		return publications.get(i);
	}

}
