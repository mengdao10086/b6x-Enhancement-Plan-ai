package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class ArticleTopic implements Parcelable {

    @k
    public static final Parcelable.Creator<ArticleTopic> CREATOR = new Creator();

    @SerializedName("topic")
    @l
    private final TopicBean topic;

    public static final class Creator implements Parcelable.Creator<ArticleTopic> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final ArticleTopic createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            return new ArticleTopic(parcel.readInt() == 0 ? null : TopicBean.CREATOR.createFromParcel(parcel));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final ArticleTopic[] newArray(int i10) {
            return new ArticleTopic[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArticleTopic() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ArticleTopic(@l TopicBean topicBean) {
        this.topic = topicBean;
    }

    public static /* synthetic */ ArticleTopic copy$default(ArticleTopic articleTopic, TopicBean topicBean, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            topicBean = articleTopic.topic;
        }
        return articleTopic.copy(topicBean);
    }

    @l
    public final TopicBean component1() {
        return this.topic;
    }

    @k
    public final ArticleTopic copy(@l TopicBean topicBean) {
        return new ArticleTopic(topicBean);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ArticleTopic) && f0.g(this.topic, ((ArticleTopic) obj).topic);
    }

    @l
    public final TopicBean getTopic() {
        return this.topic;
    }

    public int hashCode() {
        TopicBean topicBean = this.topic;
        if (topicBean == null) {
            return 0;
        }
        return topicBean.hashCode();
    }

    @k
    public String toString() {
        return "ArticleTopic(topic=" + this.topic + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        TopicBean topicBean = this.topic;
        if (topicBean == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            topicBean.writeToParcel(out, i10);
        }
    }

    public /* synthetic */ ArticleTopic(TopicBean topicBean, int i10, u uVar) {
        this((i10 & 1) != 0 ? null : topicBean);
    }
}
