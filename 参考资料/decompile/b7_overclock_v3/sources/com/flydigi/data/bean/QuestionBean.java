package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class QuestionBean {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final int f14340id;

    @SerializedName("questions")
    @k
    private final List<Question> questions;

    @SerializedName("title")
    @l
    private final String title;

    public QuestionBean(@k List<Question> questions, int i10, @l String str) {
        f0.p(questions, "questions");
        this.questions = questions;
        this.f14340id = i10;
        this.title = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QuestionBean copy$default(QuestionBean questionBean, List list, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = questionBean.questions;
        }
        if ((i11 & 2) != 0) {
            i10 = questionBean.f14340id;
        }
        if ((i11 & 4) != 0) {
            str = questionBean.title;
        }
        return questionBean.copy(list, i10, str);
    }

    @k
    public final List<Question> component1() {
        return this.questions;
    }

    public final int component2() {
        return this.f14340id;
    }

    @l
    public final String component3() {
        return this.title;
    }

    @k
    public final QuestionBean copy(@k List<Question> questions, int i10, @l String str) {
        f0.p(questions, "questions");
        return new QuestionBean(questions, i10, str);
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuestionBean)) {
            return false;
        }
        QuestionBean questionBean = (QuestionBean) obj;
        return f0.g(this.questions, questionBean.questions) && this.f14340id == questionBean.f14340id && f0.g(this.title, questionBean.title);
    }

    public final int getId() {
        return this.f14340id;
    }

    @k
    public final List<Question> getQuestions() {
        return this.questions;
    }

    @l
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((this.questions.hashCode() * 31) + this.f14340id) * 31;
        String str = this.title;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @k
    public String toString() {
        return "QuestionBean(questions=" + this.questions + ", id=" + this.f14340id + ", title=" + this.title + ')';
    }

    public /* synthetic */ QuestionBean(List list, int i10, String str, int i11, u uVar) {
        this(list, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? null : str);
    }
}
