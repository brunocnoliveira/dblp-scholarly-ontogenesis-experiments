package br.ufsc.inf.lapesd.dblppublication.dataservice.endpoint;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import br.ufsc.inf.lapesd.dblppublication.dataservice.config.OntoGenesisAdapter2;
import br.ufsc.inf.lapesd.dblppublication.dataservice.model.Publication;
import br.ufsc.inf.lapesd.dblppublication.dataservice.report.OntologyReport;
import br.ufsc.inf.lapesd.dblppublication.dataservice.report.ReportManager;
import br.ufsc.inf.lapesd.dblppublication.dataservice.service.PublicationService;
import br.ufsc.inf.lapesd.ontogenesis.adapter.OntoGenesisAdapter;
import br.ufsc.inf.lapesd.ontogenesis.engine.SemanticFeatures;
import br.ufsc.inf.lapesd.ontogenesis.engine.matcher.EquivalentProperty;


@Path("publication")
public class PublicationEndpoint {
	
	@Autowired
    private PublicationService publicationService;
	@Autowired
	private OntoGenesisAdapter2 ontoGenesisAdapter;
	
	@Context
    private UriInfo uriInfo;
	
	
	/**
     * Example of request to start experiment:
     * http://localhost:8081/publications-dataservice/publication/startOntoGenesisExperiment?requests=10
     * @param requests
     * @return
     */
    @GET
    @Path("startOntoGenesisExperiment")
    @Produces(MediaType.APPLICATION_JSON)
    public Response startOntoGenesisExperiment(@QueryParam("requests") int requests) {
    	
    	try {
    		ReportManager reportManager = new ReportManager();
        	SemanticFeatures semanticFeatures = null;
        	
        	long startTime = System.currentTimeMillis();        	
        	ontoGenesisAdapter.registryMicroservice();
        	
        	int countFlushReport = 0;
        	
        	for(int c=0; c<requests; c++) {
        		Publication p = publicationService.loadRandomPublication();
        		
        		System.out.printf("Representation %d of %d:\n",++countFlushReport,requests);
        		String representation = new Gson().toJson(p);
        		System.out.println(representation);
        		
        		long requisitionStartTime = System.currentTimeMillis();
            	semanticFeatures = ontoGenesisAdapter.sendToEnrich(representation);
            	long requisitionTotalTime = (System.currentTimeMillis() - requisitionStartTime);
            	
            	List<EquivalentProperty> equivPropsList = semanticFeatures.getEquivalentProperties();
            	OntologyReport ontologyReport = new OntologyReport(countFlushReport, requisitionTotalTime, equivPropsList);
            	reportManager.add(ontologyReport);
            	
            	if(countFlushReport%10 == 0)
            		reportManager.flushToFile();
        	}
        	
        	reportManager.flushToFile();
        	
        	long totalTime = (System.currentTimeMillis() - startTime);
        	System.out.println("===Final Ontology===\n "+semanticFeatures.getOntologyAsString());
    		System.out.printf("\n End of execution in: %d ms\n", totalTime);
        	
    		return Response.status(Status.OK).build();
        	
        } 
    	catch (FileNotFoundException e) {
        	e.printStackTrace();
            return Response.status(Status.NOT_FOUND).build();
        } 
    	catch (IOException e) {
			e.printStackTrace();
        	return Response.status(Status.NOT_FOUND).build();
		}
    }
    
    
    
    @GET
    @Path("loadRandomPublication")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadRandomPublication() {    	
		Publication p = publicationService.loadRandomPublication();
		String representation = new Gson().toJson(p);
		
		return Response.ok(representation).build();
    }

}
