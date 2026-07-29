package com.flydigi.sdk.gamepad.extension.config.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CFGPropertyJS implements Cloneable, Parcelable {
    public static final Parcelable.Creator<CFGPropertyJS> CREATOR = new Parcelable.Creator<CFGPropertyJS>() { // from class: com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyJS.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGPropertyJS createFromParcel(Parcel parcel) {
            return new CFGPropertyJS(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGPropertyJS[] newArray(int i10) {
            return new CFGPropertyJS[i10];
        }
    };
    public static final int REVERSE_TYPE_BOTH = 3;
    public static final int REVERSE_TYPE_HORIZONTAL = 1;
    public static final int REVERSE_TYPE_NONE = 0;
    public static final int REVERSE_TYPE_VERTICAL = 2;
    public int ban;
    public int double_click_key;
    public int edge_dframe;
    public int js_mode;
    public String key;
    public int key_id;
    public int radius;
    public int reverse_type;
    public int senty_x;
    public int senty_y;
    public int show;
    public int start_delay;
    public int switchRKey;
    public int type;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f16345x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f16346y;

    public CFGPropertyJS(Parcel parcel) {
        this.key_id = 0;
        this.key = "";
        this.f16345x = 0.0f;
        this.f16346y = 0.0f;
        this.type = 0;
        this.show = 1;
        this.radius = 0;
        this.senty_x = -1;
        this.senty_y = -1;
        this.ban = -1;
        this.start_delay = -1;
        this.edge_dframe = -1;
        this.js_mode = 0;
        this.switchRKey = -1;
        this.double_click_key = -1;
        this.reverse_type = 0;
        this.key_id = parcel.readInt();
        this.key = parcel.readString();
        this.f16345x = parcel.readFloat();
        this.f16346y = parcel.readFloat();
        this.type = parcel.readInt();
        this.show = parcel.readInt();
        this.radius = parcel.readInt();
        this.senty_x = parcel.readInt();
        this.senty_y = parcel.readInt();
        this.ban = parcel.readInt();
        this.start_delay = parcel.readInt();
        this.edge_dframe = parcel.readInt();
        this.js_mode = parcel.readInt();
        this.switchRKey = parcel.readInt();
        this.double_click_key = parcel.readInt();
        this.reverse_type = parcel.readInt();
    }

    public CFGPropertyJS copy() {
        return m2clone();
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
        CFGPropertyJS cFGPropertyJS = (CFGPropertyJS) obj;
        return this.key_id == cFGPropertyJS.key_id && Float.compare(cFGPropertyJS.f16345x, this.f16345x) == 0 && Float.compare(cFGPropertyJS.f16346y, this.f16346y) == 0 && this.type == cFGPropertyJS.type && this.show == cFGPropertyJS.show && this.radius == cFGPropertyJS.radius && this.senty_x == cFGPropertyJS.senty_x && this.senty_y == cFGPropertyJS.senty_y && this.ban == cFGPropertyJS.ban && this.start_delay == cFGPropertyJS.start_delay && this.edge_dframe == cFGPropertyJS.edge_dframe && this.js_mode == cFGPropertyJS.js_mode && this.switchRKey == cFGPropertyJS.switchRKey && this.double_click_key == cFGPropertyJS.double_click_key && this.reverse_type == cFGPropertyJS.reverse_type;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.key_id), Float.valueOf(this.f16345x), Float.valueOf(this.f16346y), Integer.valueOf(this.type), Integer.valueOf(this.show), Integer.valueOf(this.radius), Integer.valueOf(this.senty_x), Integer.valueOf(this.senty_y), Integer.valueOf(this.ban), Integer.valueOf(this.start_delay), Integer.valueOf(this.edge_dframe), Integer.valueOf(this.js_mode), Integer.valueOf(this.switchRKey), Integer.valueOf(this.double_click_key), Integer.valueOf(this.reverse_type));
    }

    public String toString() {
        return "CFGPropertyJS{key_id=" + this.key_id + ", key='" + this.key + "', x=" + this.f16345x + ", y=" + this.f16346y + ", type=" + this.type + ", show=" + this.show + ", radius=" + this.radius + ", senty_x=" + this.senty_x + ", senty_y=" + this.senty_y + ", ban=" + this.ban + ", start_delay=" + this.start_delay + ", edge_dframe=" + this.edge_dframe + ", js_mode=" + this.js_mode + ", switchRKey=" + this.switchRKey + ", double_click_key=" + this.double_click_key + ", reverse_type=" + this.reverse_type + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.key_id);
        parcel.writeString(this.key);
        parcel.writeFloat(this.f16345x);
        parcel.writeFloat(this.f16346y);
        parcel.writeInt(this.type);
        parcel.writeInt(this.show);
        parcel.writeInt(this.radius);
        parcel.writeInt(this.senty_x);
        parcel.writeInt(this.senty_y);
        parcel.writeInt(this.ban);
        parcel.writeInt(this.start_delay);
        parcel.writeInt(this.edge_dframe);
        parcel.writeInt(this.js_mode);
        parcel.writeInt(this.switchRKey);
        parcel.writeInt(this.double_click_key);
        parcel.writeInt(this.reverse_type);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CFGPropertyJS m2clone() {
        try {
            return (CFGPropertyJS) super.clone();
        } catch (CloneNotSupportedException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public CFGPropertyJS() {
        this.key_id = 0;
        this.key = "";
        this.f16345x = 0.0f;
        this.f16346y = 0.0f;
        this.type = 0;
        this.show = 1;
        this.radius = 0;
        this.senty_x = -1;
        this.senty_y = -1;
        this.ban = -1;
        this.start_delay = -1;
        this.edge_dframe = -1;
        this.js_mode = 0;
        this.switchRKey = -1;
        this.double_click_key = -1;
        this.reverse_type = 0;
    }
}
