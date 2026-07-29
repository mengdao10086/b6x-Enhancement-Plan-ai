package com.flydigi.data.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class AppConfigDTO implements Parcelable {
    public static final Parcelable.Creator<AppConfigDTO> CREATOR = new Parcelable.Creator<AppConfigDTO>() { // from class: com.flydigi.data.bean.AppConfigDTO.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppConfigDTO createFromParcel(Parcel in2) {
            return new AppConfigDTO(in2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppConfigDTO[] newArray(int size) {
            return new AppConfigDTO[size];
        }
    };

    @SerializedName("should_report")
    private Boolean shouldReport;

    @SerializedName("data_report_num")
    private Integer statisticsBufferSize;

    public AppConfigDTO() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Boolean getShouldReport() {
        return this.shouldReport;
    }

    public Integer getStatisticsBufferSize() {
        return this.statisticsBufferSize;
    }

    public void setShouldReport(Boolean shouldReport) {
        this.shouldReport = shouldReport;
    }

    public void setStatisticsBufferSize(final Integer statisticsBufferSize) {
        this.statisticsBufferSize = statisticsBufferSize;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (this.statisticsBufferSize == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(this.statisticsBufferSize.intValue());
        }
        Boolean bool = this.shouldReport;
        dest.writeByte((byte) (bool != null ? bool.booleanValue() ? 1 : 2 : 0));
    }

    public AppConfigDTO(Parcel in2) {
        Boolean boolValueOf = null;
        if (in2.readByte() == 0) {
            this.statisticsBufferSize = null;
        } else {
            this.statisticsBufferSize = Integer.valueOf(in2.readInt());
        }
        byte b10 = in2.readByte();
        if (b10 != 0) {
            boolValueOf = Boolean.valueOf(b10 == 1);
        }
        this.shouldReport = boolValueOf;
    }
}
