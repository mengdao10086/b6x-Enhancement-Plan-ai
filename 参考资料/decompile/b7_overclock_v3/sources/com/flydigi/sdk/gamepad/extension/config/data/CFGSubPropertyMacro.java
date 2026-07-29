package com.flydigi.sdk.gamepad.extension.config.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public class CFGSubPropertyMacro implements Cloneable, Parcelable {
    public static final Parcelable.Creator<CFGSubPropertyMacro> CREATOR = new Parcelable.Creator<CFGSubPropertyMacro>() { // from class: com.flydigi.sdk.gamepad.extension.config.data.CFGSubPropertyMacro.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGSubPropertyMacro createFromParcel(Parcel parcel) {
            return new CFGSubPropertyMacro(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGSubPropertyMacro[] newArray(int i10) {
            return new CFGSubPropertyMacro[i10];
        }
    };
    private int angle;
    private int duration;

    @SerializedName("js_link")
    private int jsLink;

    @SerializedName("next_vkey")
    private int nextVKey;
    private int radius;
    private int range;
    private int type;

    @SerializedName("wait_time")
    private int waitTime;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f16349x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f16350y;

    public CFGSubPropertyMacro() {
        this.f16349x = 0.0f;
        this.f16350y = 0.0f;
        this.nextVKey = 0;
        this.angle = -1;
        this.range = -1;
        this.jsLink = -1;
        this.radius = -1;
        this.type = 1;
        this.waitTime = 2;
        this.duration = 2;
    }

    public CFGSubPropertyMacro copy() {
        return m5clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CFGSubPropertyMacro cFGSubPropertyMacro = (CFGSubPropertyMacro) obj;
        return Float.compare(cFGSubPropertyMacro.f16349x, this.f16349x) == 0 && Float.compare(cFGSubPropertyMacro.f16350y, this.f16350y) == 0 && this.type == cFGSubPropertyMacro.type && this.nextVKey == cFGSubPropertyMacro.nextVKey && this.waitTime == cFGSubPropertyMacro.waitTime && this.duration == cFGSubPropertyMacro.duration && this.angle == cFGSubPropertyMacro.angle && this.range == cFGSubPropertyMacro.range && this.jsLink == cFGSubPropertyMacro.jsLink && this.radius == cFGSubPropertyMacro.radius;
    }

    public int getAngle() {
        return this.angle;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getJsLink() {
        return this.jsLink;
    }

    public int getNextVKey() {
        return this.nextVKey;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getRange() {
        return this.range;
    }

    public int getType() {
        return this.type;
    }

    public int getWaitTime() {
        return this.waitTime;
    }

    public float getX() {
        return this.f16349x;
    }

    public float getY() {
        return this.f16350y;
    }

    public int hashCode() {
        return Objects.hash(Float.valueOf(this.f16349x), Float.valueOf(this.f16350y), Integer.valueOf(this.type), Integer.valueOf(this.nextVKey), Integer.valueOf(this.waitTime), Integer.valueOf(this.duration), Integer.valueOf(this.angle), Integer.valueOf(this.range), Integer.valueOf(this.jsLink), Integer.valueOf(this.radius));
    }

    public boolean reverse() {
        return this.jsLink == 2;
    }

    public boolean reverseAndUnique() {
        return this.jsLink == 6;
    }

    public void setAngle(int i10) {
        this.angle = i10;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setJsLink(int i10) {
        this.jsLink = i10;
    }

    public void setNextVKey(int i10) {
        this.nextVKey = i10;
    }

    public void setRadius(int i10) {
        this.radius = i10;
    }

    public void setRange(int i10) {
        this.range = i10;
    }

    public void setType(int i10) {
        this.type = i10;
    }

    public void setWaitTime(int i10) {
        this.waitTime = i10;
    }

    public void setX(float f10) {
        this.f16349x = f10;
    }

    public void setY(float f10) {
        this.f16350y = f10;
    }

    @k
    public String toString() {
        return "CFGSubPropertyMacro{x=" + this.f16349x + ", y=" + this.f16350y + ", type=" + this.type + ", next_vkey=" + this.nextVKey + ", wait_time=" + this.waitTime + ", duration=" + this.duration + ", angle=" + this.angle + ", range=" + this.range + ", js_link=" + this.jsLink + ", radius=" + this.radius + '}';
    }

    public boolean unique() {
        return this.jsLink == 4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f16349x);
        parcel.writeFloat(this.f16350y);
        parcel.writeInt(this.type);
        parcel.writeInt(this.nextVKey);
        parcel.writeInt(this.waitTime);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.angle);
        parcel.writeInt(this.range);
        parcel.writeInt(this.jsLink);
        parcel.writeInt(this.radius);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CFGSubPropertyMacro m5clone() {
        try {
            return (CFGSubPropertyMacro) super.clone();
        } catch (CloneNotSupportedException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public CFGSubPropertyMacro(Parcel parcel) {
        this.f16349x = 0.0f;
        this.f16350y = 0.0f;
        this.nextVKey = 0;
        this.angle = -1;
        this.range = -1;
        this.jsLink = -1;
        this.radius = -1;
        this.f16349x = parcel.readFloat();
        this.f16350y = parcel.readFloat();
        this.type = parcel.readInt();
        this.nextVKey = parcel.readInt();
        this.waitTime = parcel.readInt();
        this.duration = parcel.readInt();
        this.angle = parcel.readInt();
        this.range = parcel.readInt();
        this.jsLink = parcel.readInt();
        this.radius = parcel.readInt();
    }
}
