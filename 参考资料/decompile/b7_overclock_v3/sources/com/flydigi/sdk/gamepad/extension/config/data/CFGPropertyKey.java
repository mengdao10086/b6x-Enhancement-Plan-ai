package com.flydigi.sdk.gamepad.extension.config.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import m9.m;

/* JADX INFO: loaded from: classes3.dex */
public class CFGPropertyKey implements Cloneable, Parcelable {
    public static final Parcelable.Creator<CFGPropertyKey> CREATOR = new Parcelable.Creator<CFGPropertyKey>() { // from class: com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGPropertyKey createFromParcel(Parcel parcel) {
            return new CFGPropertyKey(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGPropertyKey[] newArray(int i10) {
            return new CFGPropertyKey[i10];
        }
    };
    public int angle;
    public int ban;
    public int click_times;

    @SerializedName("a_key_id")
    public int comboKeyFirst;

    @SerializedName("ab_type")
    public int comboKeyMode;

    @SerializedName("b_key_id")
    public int comboKeySecond;
    public int cursorControlSpeedX;
    public int cursorControlSpeedY;
    public int cursorRJsX;
    public int cursorRJsY;
    public int duration;
    public int js_link;
    public String key;
    public int key_id;
    public int radius;
    public int radius_change;
    public int range;
    public int senVisualRJsX;
    public int senVisualRJsY;
    public int sentyRJsX;
    public int sentyRJsY;
    public int senty_x;
    public int senty_y;
    public int show;
    public int speedy_gua;
    public int sub_type;
    public int switchRKey;
    public int type;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f16347x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f16348y;

    public CFGPropertyKey(int i10) {
        this.key = "";
        this.f16347x = 0.0f;
        this.f16348y = 0.0f;
        this.show = 1;
        this.senty_x = -1;
        this.senty_y = -1;
        this.speedy_gua = -1;
        this.click_times = -1;
        this.angle = -1;
        this.range = -1;
        this.duration = -1;
        this.js_link = -1;
        this.radius = -1;
        this.sentyRJsX = 40;
        this.sentyRJsY = 20;
        this.senVisualRJsX = 40;
        this.senVisualRJsY = 20;
        this.cursorControlSpeedX = 40;
        this.cursorControlSpeedY = 20;
        this.cursorRJsX = 40;
        this.cursorRJsY = 20;
        this.ban = -1;
        this.radius_change = -1;
        this.switchRKey = -1;
        this.comboKeyMode = 2;
        this.comboKeyFirst = -1;
        this.comboKeySecond = -1;
        this.key_id = i10;
        this.type = 1;
        this.sub_type = 0;
        if (m.a(i10)) {
            this.comboKeyFirst = m.c(i10);
            this.comboKeySecond = m.d(i10);
            this.comboKeyMode = 2;
        }
    }

    public CFGPropertyKey copy() {
        return m3clone();
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
        CFGPropertyKey cFGPropertyKey = (CFGPropertyKey) obj;
        return this.key_id == cFGPropertyKey.key_id && Float.compare(cFGPropertyKey.f16347x, this.f16347x) == 0 && Float.compare(cFGPropertyKey.f16348y, this.f16348y) == 0 && this.type == cFGPropertyKey.type && this.sub_type == cFGPropertyKey.sub_type && this.show == cFGPropertyKey.show && this.senty_x == cFGPropertyKey.senty_x && this.senty_y == cFGPropertyKey.senty_y && this.speedy_gua == cFGPropertyKey.speedy_gua && this.click_times == cFGPropertyKey.click_times && this.angle == cFGPropertyKey.angle && this.range == cFGPropertyKey.range && this.duration == cFGPropertyKey.duration && this.js_link == cFGPropertyKey.js_link && this.radius == cFGPropertyKey.radius && this.sentyRJsX == cFGPropertyKey.sentyRJsX && this.sentyRJsY == cFGPropertyKey.sentyRJsY && this.senVisualRJsX == cFGPropertyKey.senVisualRJsX && this.senVisualRJsY == cFGPropertyKey.senVisualRJsY && this.cursorControlSpeedX == cFGPropertyKey.cursorControlSpeedX && this.cursorControlSpeedY == cFGPropertyKey.cursorControlSpeedY && this.cursorRJsX == cFGPropertyKey.cursorRJsX && this.cursorRJsY == cFGPropertyKey.cursorRJsY && this.ban == cFGPropertyKey.ban && this.radius_change == cFGPropertyKey.radius_change && this.switchRKey == cFGPropertyKey.switchRKey && this.comboKeyMode == cFGPropertyKey.comboKeyMode && this.comboKeyFirst == cFGPropertyKey.comboKeyFirst && this.comboKeySecond == cFGPropertyKey.comboKeySecond;
    }

    public int getReverseOrUnique() {
        int i10 = this.js_link;
        if (i10 > 8) {
            i10 -= 8;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 4) {
            return 2;
        }
        return i10 == 6 ? 3 : 0;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.key_id), Float.valueOf(this.f16347x), Float.valueOf(this.f16348y), Integer.valueOf(this.type), Integer.valueOf(this.sub_type), Integer.valueOf(this.show), Integer.valueOf(this.senty_x), Integer.valueOf(this.senty_y), Integer.valueOf(this.speedy_gua), Integer.valueOf(this.click_times), Integer.valueOf(this.angle), Integer.valueOf(this.range), Integer.valueOf(this.duration), Integer.valueOf(this.js_link), Integer.valueOf(this.radius), Integer.valueOf(this.sentyRJsX), Integer.valueOf(this.sentyRJsY), Integer.valueOf(this.senVisualRJsX), Integer.valueOf(this.senVisualRJsY), Integer.valueOf(this.cursorControlSpeedX), Integer.valueOf(this.cursorControlSpeedY), Integer.valueOf(this.cursorRJsX), Integer.valueOf(this.cursorRJsY), Integer.valueOf(this.ban), Integer.valueOf(this.radius_change), Integer.valueOf(this.switchRKey), Integer.valueOf(this.comboKeyMode), Integer.valueOf(this.comboKeyFirst), Integer.valueOf(this.comboKeySecond));
    }

    public String toString() {
        return "CFGPropertyKey{key_id=" + this.key_id + ", key='" + this.key + "', type=" + this.type + ", sub_type=" + this.sub_type + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.key_id);
        parcel.writeString(this.key);
        parcel.writeFloat(this.f16347x);
        parcel.writeFloat(this.f16348y);
        parcel.writeInt(this.type);
        parcel.writeInt(this.sub_type);
        parcel.writeInt(this.show);
        parcel.writeInt(this.senty_x);
        parcel.writeInt(this.senty_y);
        parcel.writeInt(this.speedy_gua);
        parcel.writeInt(this.click_times);
        parcel.writeInt(this.angle);
        parcel.writeInt(this.range);
        parcel.writeInt(this.duration);
        parcel.writeInt(this.js_link);
        parcel.writeInt(this.radius);
        parcel.writeInt(this.sentyRJsX);
        parcel.writeInt(this.sentyRJsY);
        parcel.writeInt(this.senVisualRJsX);
        parcel.writeInt(this.senVisualRJsY);
        parcel.writeInt(this.cursorControlSpeedX);
        parcel.writeInt(this.cursorControlSpeedY);
        parcel.writeInt(this.cursorRJsX);
        parcel.writeInt(this.cursorRJsY);
        parcel.writeInt(this.ban);
        parcel.writeInt(this.radius_change);
        parcel.writeInt(this.switchRKey);
        parcel.writeInt(this.comboKeyMode);
        parcel.writeInt(this.comboKeyFirst);
        parcel.writeInt(this.comboKeySecond);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CFGPropertyKey m3clone() {
        try {
            return (CFGPropertyKey) super.clone();
        } catch (CloneNotSupportedException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public CFGPropertyKey(int i10, int i11) {
        this.key = "";
        this.f16347x = 0.0f;
        this.f16348y = 0.0f;
        this.show = 1;
        this.senty_x = -1;
        this.senty_y = -1;
        this.speedy_gua = -1;
        this.click_times = -1;
        this.angle = -1;
        this.range = -1;
        this.duration = -1;
        this.js_link = -1;
        this.radius = -1;
        this.sentyRJsX = 40;
        this.sentyRJsY = 20;
        this.senVisualRJsX = 40;
        this.senVisualRJsY = 20;
        this.cursorControlSpeedX = 40;
        this.cursorControlSpeedY = 20;
        this.cursorRJsX = 40;
        this.cursorRJsY = 20;
        this.ban = -1;
        this.radius_change = -1;
        this.switchRKey = -1;
        this.key_id = 256;
        this.type = 1;
        this.sub_type = 0;
        this.comboKeyFirst = i10;
        this.comboKeySecond = i11;
        this.comboKeyMode = 2;
    }

    public CFGPropertyKey(Parcel parcel) {
        this.key_id = -1;
        this.key = "";
        this.f16347x = 0.0f;
        this.f16348y = 0.0f;
        this.type = 0;
        this.sub_type = -1;
        this.show = 1;
        this.senty_x = -1;
        this.senty_y = -1;
        this.speedy_gua = -1;
        this.click_times = -1;
        this.angle = -1;
        this.range = -1;
        this.duration = -1;
        this.js_link = -1;
        this.radius = -1;
        this.sentyRJsX = 40;
        this.sentyRJsY = 20;
        this.senVisualRJsX = 40;
        this.senVisualRJsY = 20;
        this.cursorControlSpeedX = 40;
        this.cursorControlSpeedY = 20;
        this.cursorRJsX = 40;
        this.cursorRJsY = 20;
        this.ban = -1;
        this.radius_change = -1;
        this.switchRKey = -1;
        this.comboKeyMode = 2;
        this.comboKeyFirst = -1;
        this.comboKeySecond = -1;
        this.key_id = parcel.readInt();
        this.key = parcel.readString();
        this.f16347x = parcel.readFloat();
        this.f16348y = parcel.readFloat();
        this.type = parcel.readInt();
        this.sub_type = parcel.readInt();
        this.show = parcel.readInt();
        this.senty_x = parcel.readInt();
        this.senty_y = parcel.readInt();
        this.speedy_gua = parcel.readInt();
        this.click_times = parcel.readInt();
        this.angle = parcel.readInt();
        this.range = parcel.readInt();
        this.duration = parcel.readInt();
        this.js_link = parcel.readInt();
        this.radius = parcel.readInt();
        this.sentyRJsX = parcel.readInt();
        this.sentyRJsY = parcel.readInt();
        this.senVisualRJsX = parcel.readInt();
        this.senVisualRJsY = parcel.readInt();
        this.cursorControlSpeedX = parcel.readInt();
        this.cursorControlSpeedY = parcel.readInt();
        this.cursorRJsX = parcel.readInt();
        this.cursorRJsY = parcel.readInt();
        this.ban = parcel.readInt();
        this.radius_change = parcel.readInt();
        this.switchRKey = parcel.readInt();
        this.comboKeyMode = parcel.readInt();
        this.comboKeyFirst = parcel.readInt();
        this.comboKeySecond = parcel.readInt();
    }

    public CFGPropertyKey() {
        this.key_id = -1;
        this.key = "";
        this.f16347x = 0.0f;
        this.f16348y = 0.0f;
        this.type = 0;
        this.sub_type = -1;
        this.show = 1;
        this.senty_x = -1;
        this.senty_y = -1;
        this.speedy_gua = -1;
        this.click_times = -1;
        this.angle = -1;
        this.range = -1;
        this.duration = -1;
        this.js_link = -1;
        this.radius = -1;
        this.sentyRJsX = 40;
        this.sentyRJsY = 20;
        this.senVisualRJsX = 40;
        this.senVisualRJsY = 20;
        this.cursorControlSpeedX = 40;
        this.cursorControlSpeedY = 20;
        this.cursorRJsX = 40;
        this.cursorRJsY = 20;
        this.ban = -1;
        this.radius_change = -1;
        this.switchRKey = -1;
        this.comboKeyMode = 2;
        this.comboKeyFirst = -1;
        this.comboKeySecond = -1;
    }
}
