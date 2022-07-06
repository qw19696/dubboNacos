package pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Song implements Serializable {
    private String name;
    private String singerName;
    private String introduction;

}
