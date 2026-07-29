package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class Question {

    @SerializedName("answer")
    @k
    private final List<Answer> answer;

    @SerializedName("next_question")
    @l
    private final Integer nextQuestion;

    @SerializedName("question_title")
    @k
    private final String questionTitle;

    public Question(@k List<Answer> answer, @k String questionTitle, @l Integer num) {
        f0.p(answer, "answer");
        f0.p(questionTitle, "questionTitle");
        this.answer = answer;
        this.questionTitle = questionTitle;
        this.nextQuestion = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Question copy$default(Question question, List list, String str, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = question.answer;
        }
        if ((i10 & 2) != 0) {
            str = question.questionTitle;
        }
        if ((i10 & 4) != 0) {
            num = question.nextQuestion;
        }
        return question.copy(list, str, num);
    }

    @k
    public final List<Answer> component1() {
        return this.answer;
    }

    @k
    public final String component2() {
        return this.questionTitle;
    }

    @l
    public final Integer component3() {
        return this.nextQuestion;
    }

    @k
    public final Question copy(@k List<Answer> answer, @k String questionTitle, @l Integer num) {
        f0.p(answer, "answer");
        f0.p(questionTitle, "questionTitle");
        return new Question(answer, questionTitle, num);
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Question)) {
            return false;
        }
        Question question = (Question) obj;
        return f0.g(this.answer, question.answer) && f0.g(this.questionTitle, question.questionTitle) && f0.g(this.nextQuestion, question.nextQuestion);
    }

    @k
    public final List<Answer> getAnswer() {
        return this.answer;
    }

    @l
    public final Integer getNextQuestion() {
        return this.nextQuestion;
    }

    @k
    public final String getQuestionTitle() {
        return this.questionTitle;
    }

    public int hashCode() {
        int iHashCode = ((this.answer.hashCode() * 31) + this.questionTitle.hashCode()) * 31;
        Integer num = this.nextQuestion;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    @k
    public String toString() {
        return "Question(answer=" + this.answer + ", questionTitle=" + this.questionTitle + ", nextQuestion=" + this.nextQuestion + ')';
    }

    public /* synthetic */ Question(List list, String str, Integer num, int i10, u uVar) {
        this(list, str, (i10 & 4) != 0 ? null : num);
    }
}
