# K-Mean-Java
## Experiment Summary
The data inside the "iris.data" file is composed of multiple specimens from three Iris flower species. Each line contains one specimen's sepal length and width, and its petal length and width. The specie's name is used as a label when the items are being arranged into clusters. 

Because there are three species three clusters are formed, one for every specie. This happens by finding the first nearest neighbor (1-NN) as know as the nearest centroid classifier. This is using the same method as KNN to find the distance and then determine the first nearest iris from a test iris using the same Euclidean distance formula as KNN does.  When the nearest iris is found, it is added to the cluster, which the classification guessed it belongs to. To avoid large amplitudes between the values of the centroid and the values of the items inside the cluster to occur. After every classification, a new centroid is calculated from the average values of all the items inside the cluster. 
	
Most of the time, this approach has no trouble making the right guess when all the specimens of specie have similar size themselves and differ in size from the other species. But when a specimen from a specie has a size, which is similar to the average size of an entirely different species, the model fails to make the right classification and there is no way to correct it from being wrong. 
	
This problem can be observed in the output file "cluster.txt" when several specimens from the "Iris-virginica" specie have a size close to that of the average size of the "Iris-versicolor" specie. And because of that, they have been misplaced into the wrong cluster.
