package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consumer implements Serializable {

    private int id;
    private String username;
    private String password;
    private String phoneNum;


}
