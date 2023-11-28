package beans;


import jakarta.persistence.*;




@Entity
public class Categorie  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String label ;

    private String descripition;

    @OneToOne(mappedBy = "categorie")
    private Appareil appareil;

    public Categorie() {
        super();
    }
    public Categorie(String label, String descripition, Appareil appareil) {
        this.label = label;
        this.descripition = descripition;
        this.appareil=appareil;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDesc() {
        return descripition;
    }

    public void setDesc(String descripition) {
        this.descripition = descripition;
    }
}
