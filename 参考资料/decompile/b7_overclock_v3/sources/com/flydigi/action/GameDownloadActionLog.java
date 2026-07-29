package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class GameDownloadActionLog extends LogAction {
    public static final Parcelable.Creator<GameDownloadActionLog> CREATOR = new a();
    private String event;
    private String gameId;
    private String refer;

    public class a implements Parcelable.Creator<GameDownloadActionLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GameDownloadActionLog createFromParcel(Parcel source) {
            return new GameDownloadActionLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public GameDownloadActionLog[] newArray(int size) {
            return new GameDownloadActionLog[size];
        }
    }

    public GameDownloadActionLog() {
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
        return "GameDownloadActionLog{event='" + this.event + "', refer='" + this.refer + "', gameId='" + this.gameId + "', action='" + this.action + "'}";
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.event);
        dest.writeString(this.refer);
        dest.writeString(this.gameId);
    }

    public GameDownloadActionLog(Parcel in2) {
        super(in2);
        this.event = in2.readString();
        this.refer = in2.readString();
        this.gameId = in2.readString();
    }
}
