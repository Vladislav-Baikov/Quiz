package domain;

import java.util.Objects;

public class Question {
    private String qText;
    private String qAnswer;

    public Question(String qText, String qAnswer) {
        this.qText = qText;
        this.qAnswer = qAnswer;
    }

    public String getqText() {
        return qText;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    public String getqAnswer() {
        return qAnswer;
    }

    public void setqAnswer(String qAnswer) {
        this.qAnswer = qAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(qText, question.qText) &&
                Objects.equals(qAnswer, question.qAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qText, qAnswer);
    }
}