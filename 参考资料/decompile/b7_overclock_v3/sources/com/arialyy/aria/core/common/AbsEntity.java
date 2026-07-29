package com.arialyy.aria.core.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.arialyy.aria.core.inf.IEntity;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.orm.annotation.Default;
import com.arialyy.aria.orm.annotation.Ignore;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsEntity extends DbEntity implements IEntity, Parcelable, Serializable {
    private long completeTime;
    private String convertFileSize;

    @Ignore
    private String convertSpeed;
    private long currentProgress;

    @Ignore
    private int failNum;
    private long fileSize;

    @Default("false")
    private boolean isComplete;

    @Ignore
    private int netCode;
    private int percent;

    @Ignore
    private long speed;

    @Default("3")
    private int state;
    private long stopTime;
    private String str;

    @Ignore
    private int timeLeft;

    public AbsEntity() {
        this.speed = 0L;
        this.failNum = 0;
        this.timeLeft = Integer.MAX_VALUE;
        this.fileSize = 0L;
        this.state = 3;
        this.currentProgress = 0L;
        this.isComplete = false;
        this.stopTime = 0L;
        this.netCode = 200;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getCompleteTime() {
        return this.completeTime;
    }

    public String getConvertFileSize() {
        return this.convertFileSize;
    }

    public String getConvertSpeed() {
        return this.convertSpeed;
    }

    public long getCurrentProgress() {
        return this.currentProgress;
    }

    public int getFailNum() {
        return this.failNum;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public long getId() {
        return getRowID();
    }

    public abstract String getKey();

    public int getNetCode() {
        return this.netCode;
    }

    public int getPercent() {
        return this.percent;
    }

    public long getSpeed() {
        return this.speed;
    }

    public int getState() {
        return this.state;
    }

    public long getStopTime() {
        return this.stopTime;
    }

    public String getStr() {
        return this.str;
    }

    public abstract int getTaskType();

    public int getTimeLeft() {
        return this.timeLeft;
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void setComplete(boolean z10) {
        this.isComplete = z10;
    }

    public void setCompleteTime(long j10) {
        this.completeTime = j10;
    }

    public void setConvertFileSize(String str) {
        this.convertFileSize = str;
    }

    public void setConvertSpeed(String str) {
        this.convertSpeed = str;
    }

    public void setCurrentProgress(long j10) {
        this.currentProgress = j10;
    }

    public void setFailNum(int i10) {
        this.failNum = i10;
    }

    public void setFileSize(long j10) {
        this.fileSize = j10;
    }

    public void setNetCode(int i10) {
        this.netCode = i10;
    }

    public void setPercent(int i10) {
        this.percent = i10;
    }

    public void setSpeed(long j10) {
        this.speed = j10;
    }

    public void setState(int i10) {
        this.state = i10;
    }

    public void setStopTime(long j10) {
        this.stopTime = j10;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setTimeLeft(int i10) {
        this.timeLeft = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.speed);
        parcel.writeString(this.convertSpeed);
        parcel.writeInt(this.failNum);
        parcel.writeString(this.str);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.convertFileSize);
        parcel.writeInt(this.state);
        parcel.writeLong(this.currentProgress);
        parcel.writeLong(this.completeTime);
        parcel.writeInt(this.percent);
        parcel.writeByte(this.isComplete ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.stopTime);
    }

    public AbsEntity(Parcel parcel) {
        this.speed = 0L;
        this.failNum = 0;
        this.timeLeft = Integer.MAX_VALUE;
        this.fileSize = 0L;
        this.state = 3;
        this.currentProgress = 0L;
        this.isComplete = false;
        this.stopTime = 0L;
        this.netCode = 200;
        this.speed = parcel.readLong();
        this.convertSpeed = parcel.readString();
        this.failNum = parcel.readInt();
        this.str = parcel.readString();
        this.fileSize = parcel.readLong();
        this.convertFileSize = parcel.readString();
        this.state = parcel.readInt();
        this.currentProgress = parcel.readLong();
        this.completeTime = parcel.readLong();
        this.percent = parcel.readInt();
        this.isComplete = parcel.readByte() != 0;
        this.stopTime = parcel.readLong();
    }
}
