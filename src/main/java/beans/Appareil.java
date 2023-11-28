package beans;

import jakarta.persistence.*;



@Entity
public class Appareil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String descripition;
    private boolean state;


    @ManyToOne()
    @JoinColumn(name = "cat_id")
    private Categorie cat;

    public Appareil(String name, String descripition, boolean state,Categorie cat) {
        this.name = name;
        this.descripition = descripition;
        this.state = state;
        this.cat = cat;
    }

    public Appareil() {
        super();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return descripition;
    }

    public boolean isState() {
        return state;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String descripition) {
        this.descripition = descripition;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
