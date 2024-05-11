package systemDesign.questions.twitter;

public class Tweet {
    int tid;
    int uid;
    int time;
    public Tweet(int uid, int tid, int time) {
        this.uid = uid;
        this.tid = tid;
        this.time = time;
    }
}
