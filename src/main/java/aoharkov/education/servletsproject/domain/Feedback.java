package aoharkov.education.servletsproject.domain;

import java.util.Objects;

public class Feedback extends RequestExtension {
    private Integer id;
    private String feedbackText;
    private Integer scoreOutOfTen;

    public Feedback(Request request, String feedbackText, Integer scoreOutOfTen) {
        super(request);
        this.feedbackText = feedbackText;
        this.scoreOutOfTen = scoreOutOfTen;
    }

    public Integer getId() {
        return id;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public Integer getScoreOutOfTen() {
        return scoreOutOfTen;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public void setScoreOutOfTen(Integer scoreOutOfTen) {
        this.scoreOutOfTen = scoreOutOfTen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Feedback)) {
            return false;
        }
        Feedback feedback1 = (Feedback) o;
        return id.equals(feedback1.id) &&
                Objects.equals(feedbackText, feedback1.feedbackText) &&
                Objects.equals(scoreOutOfTen, feedback1.scoreOutOfTen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, feedbackText, scoreOutOfTen);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", feedback='" + feedbackText + '\'' +
                ", scoreOutOfTen=" + scoreOutOfTen +
                '}';
    }
}
