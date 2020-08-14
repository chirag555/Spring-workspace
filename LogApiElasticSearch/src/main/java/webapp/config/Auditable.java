package webapp.config;

import org.springframework.data.annotation.CreatedDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {
	
	@CreatedDate
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	protected Date createdDate;

}