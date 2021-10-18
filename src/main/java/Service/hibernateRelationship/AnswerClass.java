package Service.hibernateRelationship;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="ans5991")
public class AnswerClass {
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)

    @Column(name = "id")
    private int id;

    @Column(name = "answer_name")
    private String answername;

    @Column(name = "posted_by")
    private String postedBy;

}
