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

@Document(indexName = "logs")

public class Log extends Auditable<String> {
	@Id	
	int id;	
	String entityName;
	String action;
	String beforeSnapshot;
	String firstName;
	String lastName;
	String userName;
	String afterSnapshot;
	String userId;	
	
	
}
