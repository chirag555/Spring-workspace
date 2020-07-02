package elastic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Document(indexName = "elasticsearch",shards = 2)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {
	@Id
	private int id;
	private String name;
	private int age;
	private String address;
	private String contact;	
}
