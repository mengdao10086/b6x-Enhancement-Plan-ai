package com.flydigi.data.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.flydigi.data.bean.UnreadMessageBean;

/* JADX INFO: loaded from: classes7.dex */
public class BadgeEvent implements Parcelable {
    public static final Parcelable.Creator<BadgeEvent> CREATOR = new Parcelable.Creator<BadgeEvent>() { // from class: com.flydigi.data.event.BadgeEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BadgeEvent createFromParcel(Parcel source) {
            return new BadgeEvent(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BadgeEvent[] newArray(int size) {
            return new BadgeEvent[size];
        }
    };
    private final UnreadMessageBean unreadMessageBean;

    public BadgeEvent(UnreadMessageBean unreadMessageBean) {
        this.unreadMessageBean = unreadMessageBean;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UnreadMessageBean getUnreadMessageBean() {
        return this.unreadMessageBean;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.unreadMessageBean, flags);
    }

    public BadgeEvent(Parcel in2) {
        this.unreadMessageBean = (UnreadMessageBean) in2.readParcelable(UnreadMessageBean.class.getClassLoader());
    }
}
