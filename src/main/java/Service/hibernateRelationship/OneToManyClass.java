package Service.hibernateRelationship;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="my_table")
public class OneToManyClass {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    private int id;
    private String qname;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="qid")
    @OrderColumn(name="type")
    private List<AnswerClass> answers;



    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQname() {
        return qname;
    }
    public void setQname(String qname) {
        this.qname = qname;
    }
    public List<AnswerClass> getAnswers() {
        return answers;
    }
    public void setAnswers(List<AnswerClass> answers) {
        this.answers = answers;
    }
}
