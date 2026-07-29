package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class GameCenterActionLog extends LogAction {
    public static final Parcelable.Creator<GameCenterActionLog> CREATOR = new a();
    private String event;
    private String gameId;
    private String refer;

    public class a implements Parcelable.Creator<GameCenterActionLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GameCenterActionLog createFromParcel(Parcel source) {
            return new GameCenterActionLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GameCenterActionLog[] newArray(int size) {
            return new GameCenterActionLog[size];
        }
    }

    public GameCenterActionLog() {
    }

    public void B0(String event) {
        this.event = event;
    }

    public void D0(String gameId) {
        this.gameId = gameId;
    }

    public void E0(String refer) {
        this.refer = refer;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction
    public String toString() {
        return "GameCenterActionLog{refer='" + this.refer + "', gameId='" + this.gameId + "', event='" + this.event + "', action='" + this.action + "'}";
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.refer);
        dest.writeString(this.gameId);
        dest.writeString(this.event);
    }

    public GameCenterActionLog(Parcel in2) {
        super(in2);
        this.refer = in2.readString();
        this.gameId = in2.readString();
        this.event = in2.readString();
    }
}
