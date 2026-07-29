package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class TopicListBean implements Parcelable {

    @k
    public static final Parcelable.Creator<TopicListBean> CREATOR = new Creator();

    @SerializedName("list")
    @k
    private final ArrayList<TopicBean> topics;

    public static final class Creator implements Parcelable.Creator<TopicListBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final TopicListBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            int i10 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i10);
            for (int i11 = 0; i11 != i10; i11++) {
                arrayList.add(TopicBean.CREATOR.createFromParcel(parcel));
            }
            return new TopicListBean(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final TopicListBean[] newArray(int i10) {
            return new TopicListBean[i10];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TopicListBean() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TopicListBean(@k ArrayList<TopicBean> topics) {
        f0.p(topics, "topics");
        this.topics = topics;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TopicListBean copy$default(TopicListBean topicListBean, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            arrayList = topicListBean.topics;
        }
        return topicListBean.copy(arrayList);
    }

    @k
    public final ArrayList<TopicBean> component1() {
        return this.topics;
    }

    @k
    public final TopicListBean copy(@k ArrayList<TopicBean> topics) {
        f0.p(topics, "topics");
        return new TopicListBean(topics);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TopicListBean) && f0.g(this.topics, ((TopicListBean) obj).topics);
    }

    @k
    public final ArrayList<TopicBean> getTopics() {
        return this.topics;
    }

    public int hashCode() {
        return this.topics.hashCode();
    }

    @k
    public String toString() {
        return "TopicListBean(topics=" + this.topics + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        ArrayList<TopicBean> arrayList = this.topics;
        out.writeInt(arrayList.size());
        Iterator<TopicBean> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i10);
        }
    }

    public /* synthetic */ TopicListBean(ArrayList arrayList, int i10, u uVar) {
        this((i10 & 1) != 0 ? new ArrayList() : arrayList);
    }
}
