package com.flydigi.data.bean.community;

import android.os.Parcel;
import android.os.Parcelable;
import cl.d;
import com.google.gson.annotations.SerializedName;
import com.umeng.analytics.pro.z;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@d
public final class CommentBean implements Parcelable {

    @k
    public static final Parcelable.Creator<CommentBean> CREATOR = new Creator();

    @SerializedName("child")
    @k
    private final ArrayList<CommentBean> child;

    @SerializedName("content")
    @l
    private final String content;

    @SerializedName("from_userid")
    private final int fromUserId;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final int f14344id;

    @SerializedName("info_id")
    private final int infoId;

    @SerializedName("is_del_by_op")
    private final int isDelByOp;

    @SerializedName("is_zan")
    private int isLiked;

    @SerializedName("zan")
    private int likeNum;

    @SerializedName("parent_id")
    private final int parentId;

    @SerializedName("replied_comment_id")
    private final int repliedCommentId;

    @SerializedName("replay_num")
    private final int replyNum;

    @SerializedName("status")
    private final int status;

    @SerializedName("tm")
    @l
    private final String timestamp;

    @SerializedName("tm_text")
    @l
    private final String tmText;

    @SerializedName(z.f23807m)
    @l
    private final User user;

    @SerializedName("weight")
    private final int weight;

    public static final class Creator implements Parcelable.Creator<CommentBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CommentBean createFromParcel(@k Parcel parcel) {
            f0.p(parcel, "parcel");
            int i10 = parcel.readInt();
            String string = parcel.readString();
            int i11 = parcel.readInt();
            int i12 = parcel.readInt();
            User userCreateFromParcel = parcel.readInt() == 0 ? null : User.CREATOR.createFromParcel(parcel);
            int i13 = parcel.readInt();
            int i14 = parcel.readInt();
            String string2 = parcel.readString();
            int i15 = parcel.readInt();
            int i16 = parcel.readInt();
            String string3 = parcel.readString();
            int i17 = parcel.readInt();
            int i18 = parcel.readInt();
            int i19 = parcel.readInt();
            int i20 = parcel.readInt();
            int i21 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i21);
            int i22 = 0;
            while (i22 != i21) {
                arrayList.add(CommentBean.CREATOR.createFromParcel(parcel));
                i22++;
                i21 = i21;
            }
            return new CommentBean(i10, string, i11, i12, userCreateFromParcel, i13, i14, string2, i15, i16, string3, i17, i18, i19, i20, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @k
        public final CommentBean[] newArray(int i10) {
            return new CommentBean[i10];
        }
    }

    public CommentBean() {
        this(0, null, 0, 0, null, 0, 0, null, 0, 0, null, 0, 0, 0, 0, null, 65535, null);
    }

    public CommentBean(int i10, @l String str, int i11, int i12, @l User user, int i13, int i14, @l String str2, int i15, int i16, @l String str3, int i17, int i18, int i19, int i20, @k ArrayList<CommentBean> child) {
        f0.p(child, "child");
        this.f14344id = i10;
        this.content = str;
        this.weight = i11;
        this.fromUserId = i12;
        this.user = user;
        this.infoId = i13;
        this.isDelByOp = i14;
        this.tmText = str2;
        this.parentId = i15;
        this.repliedCommentId = i16;
        this.timestamp = str3;
        this.replyNum = i17;
        this.isLiked = i18;
        this.likeNum = i19;
        this.status = i20;
        this.child = child;
    }

    public final int component1() {
        return this.f14344id;
    }

    public final int component10() {
        return this.repliedCommentId;
    }

    @l
    public final String component11() {
        return this.timestamp;
    }

    public final int component12() {
        return this.replyNum;
    }

    public final int component13() {
        return this.isLiked;
    }

    public final int component14() {
        return this.likeNum;
    }

    public final int component15() {
        return this.status;
    }

    @k
    public final ArrayList<CommentBean> component16() {
        return this.child;
    }

    @l
    public final String component2() {
        return this.content;
    }

    public final int component3() {
        return this.weight;
    }

    public final int component4() {
        return this.fromUserId;
    }

    @l
    public final User component5() {
        return this.user;
    }

    public final int component6() {
        return this.infoId;
    }

    public final int component7() {
        return this.isDelByOp;
    }

    @l
    public final String component8() {
        return this.tmText;
    }

    public final int component9() {
        return this.parentId;
    }

    @k
    public final CommentBean copy(int i10, @l String str, int i11, int i12, @l User user, int i13, int i14, @l String str2, int i15, int i16, @l String str3, int i17, int i18, int i19, int i20, @k ArrayList<CommentBean> child) {
        f0.p(child, "child");
        return new CommentBean(i10, str, i11, i12, user, i13, i14, str2, i15, i16, str3, i17, i18, i19, i20, child);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommentBean)) {
            return false;
        }
        CommentBean commentBean = (CommentBean) obj;
        return this.f14344id == commentBean.f14344id && f0.g(this.content, commentBean.content) && this.weight == commentBean.weight && this.fromUserId == commentBean.fromUserId && f0.g(this.user, commentBean.user) && this.infoId == commentBean.infoId && this.isDelByOp == commentBean.isDelByOp && f0.g(this.tmText, commentBean.tmText) && this.parentId == commentBean.parentId && this.repliedCommentId == commentBean.repliedCommentId && f0.g(this.timestamp, commentBean.timestamp) && this.replyNum == commentBean.replyNum && this.isLiked == commentBean.isLiked && this.likeNum == commentBean.likeNum && this.status == commentBean.status && f0.g(this.child, commentBean.child);
    }

    @k
    public final ArrayList<CommentBean> getChild() {
        return this.child;
    }

    @l
    public final String getContent() {
        return this.content;
    }

    public final int getFromUserId() {
        return this.fromUserId;
    }

    public final int getId() {
        return this.f14344id;
    }

    public final int getInfoId() {
        return this.infoId;
    }

    public final int getLikeNum() {
        return this.likeNum;
    }

    public final int getParentId() {
        return this.parentId;
    }

    public final int getRepliedCommentId() {
        return this.repliedCommentId;
    }

    public final int getReplyNum() {
        return this.replyNum;
    }

    public final int getStatus() {
        return this.status;
    }

    @l
    public final String getTimestamp() {
        return this.timestamp;
    }

    @l
    public final String getTmText() {
        return this.tmText;
    }

    @l
    public final User getUser() {
        return this.user;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int i10 = this.f14344id * 31;
        String str = this.content;
        int iHashCode = (((((i10 + (str == null ? 0 : str.hashCode())) * 31) + this.weight) * 31) + this.fromUserId) * 31;
        User user = this.user;
        int iHashCode2 = (((((iHashCode + (user == null ? 0 : user.hashCode())) * 31) + this.infoId) * 31) + this.isDelByOp) * 31;
        String str2 = this.tmText;
        int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.parentId) * 31) + this.repliedCommentId) * 31;
        String str3 = this.timestamp;
        return ((((((((((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.replyNum) * 31) + this.isLiked) * 31) + this.likeNum) * 31) + this.status) * 31) + this.child.hashCode();
    }

    public final int isDelByOp() {
        return this.isDelByOp;
    }

    public final int isLiked() {
        return this.isLiked;
    }

    public final void setLikeNum(int i10) {
        this.likeNum = i10;
    }

    public final void setLiked(int i10) {
        this.isLiked = i10;
    }

    @k
    public String toString() {
        return "CommentBean(id=" + this.f14344id + ", content=" + this.content + ", weight=" + this.weight + ", fromUserId=" + this.fromUserId + ", user=" + this.user + ", infoId=" + this.infoId + ", isDelByOp=" + this.isDelByOp + ", tmText=" + this.tmText + ", parentId=" + this.parentId + ", repliedCommentId=" + this.repliedCommentId + ", timestamp=" + this.timestamp + ", replyNum=" + this.replyNum + ", isLiked=" + this.isLiked + ", likeNum=" + this.likeNum + ", status=" + this.status + ", child=" + this.child + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@k Parcel out, int i10) {
        f0.p(out, "out");
        out.writeInt(this.f14344id);
        out.writeString(this.content);
        out.writeInt(this.weight);
        out.writeInt(this.fromUserId);
        User user = this.user;
        if (user == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            user.writeToParcel(out, i10);
        }
        out.writeInt(this.infoId);
        out.writeInt(this.isDelByOp);
        out.writeString(this.tmText);
        out.writeInt(this.parentId);
        out.writeInt(this.repliedCommentId);
        out.writeString(this.timestamp);
        out.writeInt(this.replyNum);
        out.writeInt(this.isLiked);
        out.writeInt(this.likeNum);
        out.writeInt(this.status);
        ArrayList<CommentBean> arrayList = this.child;
        out.writeInt(arrayList.size());
        Iterator<CommentBean> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(out, i10);
        }
    }

    public /* synthetic */ CommentBean(int i10, String str, int i11, int i12, User user, int i13, int i14, String str2, int i15, int i16, String str3, int i17, int i18, int i19, int i20, ArrayList arrayList, int i21, u uVar) {
        this((i21 & 1) != 0 ? 0 : i10, (i21 & 2) != 0 ? null : str, (i21 & 4) != 0 ? 0 : i11, (i21 & 8) != 0 ? 0 : i12, (i21 & 16) != 0 ? null : user, (i21 & 32) != 0 ? 0 : i13, (i21 & 64) != 0 ? 0 : i14, (i21 & 128) != 0 ? null : str2, (i21 & 256) != 0 ? 0 : i15, (i21 & 512) != 0 ? 0 : i16, (i21 & 1024) == 0 ? str3 : null, (i21 & 2048) != 0 ? 0 : i17, (i21 & 4096) != 0 ? 0 : i18, (i21 & 8192) != 0 ? 0 : i19, (i21 & 16384) != 0 ? 0 : i20, (i21 & 32768) != 0 ? new ArrayList() : arrayList);
    }
}
