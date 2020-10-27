package ch.ost.mge.testat.coronarecord.model;

public class Location {

    public final static int CODE_LENGTH = 6;

    private Integer id;
    private Integer code;
    private String name;

    public Location(Integer id, Integer code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
