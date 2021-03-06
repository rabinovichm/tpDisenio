package grupo2.tpAnual;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class MorphiaService {

	private Morphia morphia;
	private Datastore datastore;
	private MongoClient mongoClient;
	
	public MorphiaService(){
		mongoClient = new MongoClient("localhost" , 27017);

		//create a new morphia instance
		this.morphia = new Morphia(); 
		String databaseName = "mongo_persistance_dds";
		this.datastore = morphia.createDatastore(mongoClient, databaseName);		
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}
	
	public Morphia getMorphia() {
		return morphia;
	}

	public void setMorphia(Morphia morphia) {
		this.morphia = morphia;
	}

	public Datastore getDatastore() {
		return datastore;
	}

	public void setDatastore(Datastore datastore) {
		this.datastore = datastore;
	}	
}