# OntoGenesis Experiments with DBLP and ScholarlyData
This public repository contains the source codes as well as the results obtained in the experiments performed with the OntoGenesis, an architecture for semantically enriching data services.
Such experiments encompass a data service that provides metadata about articles from DBLP[<sup>1</sup>](#footnote1). As external sources of OntoGenesis, it employs datasets from ScholarlyData[<sup>2</sup>](#footnote2), which contains metadata about articles presented in some events of the Semantic Web area.

## Repository Info
* `Results` Contains all the [results](https://github.com/brunocnoliveira/dblp-scholarly-ontogenesis-experiments/tree/master/Results) of experiments in .csv format: 
  * [Processing Time](https://github.com/brunocnoliveira/dblp-scholarly-ontogenesis-experiments/tree/master/Results/Processing%20Time): results regarding processing time spent by the main components of OntoGenesis.
  * [Resources Consumption](https://github.com/brunocnoliveira/dblp-scholarly-ontogenesis-experiments/tree/master/Results/Resources%20Comsumption): results of CPU and Memory usage.
  * [Thresholds Comparison](https://github.com/brunocnoliveira/dblp-scholarly-ontogenesis-experiments/tree/master/Results/Thresholds%20Comparison) (0.4, 0.6, 0.8): results concerning compliance measures.
* `Data Service Source` Source codes for the [Data Service](https://github.com/brunocnoliveira/dblp-scholarly-ontogenesis-experiments/tree/master/DataService%20Source/publications-dataservice) desgined for experimental purposes. Its executable .jar file is in the target directory.
  * data contains the employed subset of DBLP.
* `SourceRepo` Contains the URL of all other [source codes](https://github.com/brunocnoliveira/dblp-scholarly-ontogenesis-experiments/blob/master/SourceRepo) available.


- - - 

<a name="footnote1"><sup>1</sup></a>DBLP: http://dblp.uni-trier.de/xml/

<a name="footnote2"><sup>2</sup></a>ScholarlyData: http://www.scholarlydata.org/dumps/
