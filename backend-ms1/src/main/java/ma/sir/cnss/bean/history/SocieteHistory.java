package ma.sir.cnss.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.cnss.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "societe")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="societe_seq",sequenceName="societe_seq",allocationSize=1, initialValue = 1)
public class SocieteHistory extends HistBusinessObject  {


    public SocieteHistory() {
    super();
    }

    public SocieteHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="societe_seq")
    public Long getId() {
    return id;
    }
}

