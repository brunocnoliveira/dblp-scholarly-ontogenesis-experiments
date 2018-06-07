package br.ufsc.inf.lapesd.dblppublication.dataservice.report;

import java.util.List;

import br.ufsc.inf.lapesd.ontogenesis.engine.matcher.EquivalentProperty;

public class OntologyReport {

	private String requisitionNumber;
	private String elapsedTime;
	private Integer totalCorrectEquivProps; 	//Relevant Retrieved precision/recall up
	private Integer totalEquivalentProperties; 	//retrieved properties (precision bottom)
	private Integer totalRelevantProps = 5; 	//Relevant: recall bottom
	
	private Double precision;
	private Double recall;
	private Double fMeasrue;
	
	private List<EquivalentProperty> equivPropsList; //EquivalentProperty Report
	
	public OntologyReport(Integer requisitionNumber, long elapsedTime, List<EquivalentProperty> equivPropsList) {
		this.requisitionNumber = requisitionNumber.toString();
		this.elapsedTime = elapsedTime + "";
		this.totalEquivalentProperties = equivPropsList.size();
		this.totalCorrectEquivProps = getTotalCorrects(equivPropsList);

		this.precision = (double) totalCorrectEquivProps / totalEquivalentProperties;
		this.recall = (double) totalCorrectEquivProps / totalRelevantProps;
		this.fMeasrue = (double) 2 * ((precision*recall)/(precision+recall));
		
		this.equivPropsList = equivPropsList;
	}
	
	public String getRequisitionNumber() {
		return requisitionNumber;
	}
	public String getElapsedTime() {
		return elapsedTime;
	}
	public String getTotalCorrectEquivProps() {
		return totalCorrectEquivProps+"";
	}
	public String getTotalEquivalentProperties() {
		return totalEquivalentProperties+"";
	}
	public String getTotalRelevantProps() {
		return totalRelevantProps+"";
	}
	public List<EquivalentProperty> getEquivalentProperties() {
		return this.equivPropsList;
	}
	public String getPrecision() {
		return precision+"";
	}
	public String getRecall() {
		return recall+"";
	}
	public String getFMeasure() {
		return fMeasrue+"";
	}

	public int getTotalCorrects(List<EquivalentProperty> equivPropsList) {
		int count =0 ;
		
		for(EquivalentProperty eqProp : equivPropsList) {
			
			String externalProp = eqProp.getExternalPropertyUri();
			
			switch (eqProp.getRepresentationPropertyUri()) {
			
				case AUTHOR:
					if(externalProp.equals("http://xmlns.com/foaf/0.1/name")
					    //|| externalProp.equals("http://xmlns.com/foaf/0.1/givenname")
					    //|| externalProp.equals("http://xmlns.com/foaf/0.1/familyName")
						|| externalProp.equals("http://www.w3.org/2000/01/rdf-schema#label")
					    || externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#name")
					    //|| externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#givenName")
					    //|| externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#familyName")
					    )
						count++;
					break;
					
				case EDITOR:
					if(externalProp.equals("http://xmlns.com/foaf/0.1/name")
						//|| externalProp.equals("http://xmlns.com/foaf/0.1/givenname")
						//|| externalProp.equals("http://xmlns.com/foaf/0.1/familyName")
						|| externalProp.equals("http://www.w3.org/2000/01/rdf-schema#label")
						|| externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#name") 
						//|| externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#givenName")
						//|| externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#familyName")
						)
						count++;
					break;
					
				case TITLE:
					if(externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#isPartOf") 
						|| externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#title") 
						|| externalProp.equals("http://www.w3.org/2000/01/rdf-schema#label")
						)
						count++;
					break;
					
				case BOOKTITLE:
					if(externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#isPartOf") 
						|| externalProp.equals("http://www.w3.org/2000/01/rdf-schema#label")
						)
						count++;
					break;
					
				case YEAR:
					if(externalProp.equals("http://purl.org/dc/terms/date") 
						|| externalProp.equals("http://www.w3.org/2002/12/cal/icaltzd#dtstart") 
						|| externalProp.equals("http://www.w3.org/2002/12/cal/icaltzd#dtend") 
						|| externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#endDate") 
						|| externalProp.equals("https://w3id.org/scholarlydata/ontology/conference-ontology.owl#startDate")
						)
						count++;
					break;
					
				default:
					break;
			}
		}
		return count;
	}
	
	
	/* Properties */
	private final String AUTHOR 	= "http://127.0.0.1:8081/publications-dataservice/ontology#author";
	private final String TITLE 		= "http://127.0.0.1:8081/publications-dataservice/ontology#title";
	private final String BOOKTITLE 	= "http://127.0.0.1:8081/publications-dataservice/ontology#booktitle";
	private final String YEAR 		= "http://127.0.0.1:8081/publications-dataservice/ontology#year";
	private final String EDITOR 	= "http://127.0.0.1:8081/publications-dataservice/ontology#editor";
	
}
