public class Word {
    String text;
    int count;

    Word(String text) {
        this.text = text;
        this.count = 1;
    }

    void incrementCount() {
        this.count++;
    }
}
