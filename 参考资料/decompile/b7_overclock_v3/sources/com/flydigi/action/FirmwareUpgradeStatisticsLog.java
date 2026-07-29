package com.flydigi.action;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class FirmwareUpgradeStatisticsLog extends LogAction {
    public static final Parcelable.Creator<FirmwareUpgradeStatisticsLog> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13298a = "step";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13299b = "progress";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13300c = "bluetooth";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13301d = "progress_time";
    private String errorMessage;
    private HashMap<String, String> extraInfo;

    @SerializedName("update_firmware_version")
    private String newFirmwareVersion;

    public class a implements Parcelable.Creator<FirmwareUpgradeStatisticsLog> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FirmwareUpgradeStatisticsLog createFromParcel(Parcel source) {
            return new FirmwareUpgradeStatisticsLog(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FirmwareUpgradeStatisticsLog[] newArray(int size) {
            return new FirmwareUpgradeStatisticsLog[size];
        }
    }

    public FirmwareUpgradeStatisticsLog() {
    }

    public void B0(String key, String value) {
        if (this.extraInfo == null) {
            this.extraInfo = new HashMap<>(2);
        }
        this.extraInfo.put(key, value);
    }

    public void D0(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void E0(final HashMap<String, String> extraInfo) {
        this.extraInfo = extraInfo;
    }

    public void F0(final String newFirmwareVersion) {
        this.newFirmwareVersion = newFirmwareVersion;
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.flydigi.action.LogAction
    public String toString() {
        return "FirmwareUpgradeStatisticsLog{deviceName='" + this.deviceName + "', deviceMac='" + this.deviceMac + "', firmwareVersion='" + this.firmwareVersion + "', errorMessage='" + this.errorMessage + "', newFirmwareVersion='" + this.newFirmwareVersion + "', extraInfo=" + this.extraInfo + ", action='" + this.action + "', timestamp=" + this.timestamp + '}';
    }

    @Override // com.flydigi.action.LogAction, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.deviceName);
        dest.writeString(this.deviceMac);
        dest.writeString(this.firmwareVersion);
        dest.writeString(this.errorMessage);
        dest.writeString(this.newFirmwareVersion);
        dest.writeSerializable(this.extraInfo);
    }

    public FirmwareUpgradeStatisticsLog(Parcel in2) {
        super(in2);
        this.deviceName = in2.readString();
        this.deviceMac = in2.readString();
        this.firmwareVersion = in2.readString();
        this.errorMessage = in2.readString();
        this.newFirmwareVersion = in2.readString();
        this.extraInfo = (HashMap) in2.readSerializable();
    }
}
