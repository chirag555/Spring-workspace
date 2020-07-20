package webapp.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webapp.config.Auditable;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor

@Document(indexName = "logger")

public class Logger extends Auditable<String> {
	@Id
	
	int id;
	
	String entityName;

	String beforeSnapshot;
	
	String afterSnapshot;

	String userId;		
	
}
