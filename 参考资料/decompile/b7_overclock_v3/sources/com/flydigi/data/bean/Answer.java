package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class Answer {

    @SerializedName("answer_text")
    @k
    private final String answerText;

    @SerializedName("next_question")
    private final int nextQuestion;

    public Answer(@k String answerText, int i10) {
        f0.p(answerText, "answerText");
        this.answerText = answerText;
        this.nextQuestion = i10;
    }

    public static /* synthetic */ Answer copy$default(Answer answer, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = answer.answerText;
        }
        if ((i11 & 2) != 0) {
            i10 = answer.nextQuestion;
        }
        return answer.copy(str, i10);
    }

    @k
    public final String component1() {
        return this.answerText;
    }

    public final int component2() {
        return this.nextQuestion;
    }

    @k
    public final Answer copy(@k String answerText, int i10) {
        f0.p(answerText, "answerText");
        return new Answer(answerText, i10);
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Answer)) {
            return false;
        }
        Answer answer = (Answer) obj;
        return f0.g(this.answerText, answer.answerText) && this.nextQuestion == answer.nextQuestion;
    }

    @k
    public final String getAnswerText() {
        return this.answerText;
    }

    public final int getNextQuestion() {
        return this.nextQuestion;
    }

    public int hashCode() {
        return (this.answerText.hashCode() * 31) + this.nextQuestion;
    }

    @k
    public String toString() {
        return "Answer(answerText=" + this.answerText + ", nextQuestion=" + this.nextQuestion + ')';
    }
}
