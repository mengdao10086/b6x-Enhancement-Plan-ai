package com.flydigi.sdk.gamepad.extension.config.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CFGPropertyMacro implements Cloneable, Parcelable {
    public static final Parcelable.Creator<CFGPropertyMacro> CREATOR = new Parcelable.Creator<CFGPropertyMacro>() { // from class: com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyMacro.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGPropertyMacro createFromParcel(Parcel parcel) {
            return new CFGPropertyMacro(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGPropertyMacro[] newArray(int i10) {
            return new CFGPropertyMacro[i10];
        }
    };
    public static final int DOWN_ACTIVE = 0;
    public static final int HOLD_ACTIVE = 2;
    public static final int RELEASE_ACTIVE = 1;

    @SerializedName("a_key_id")
    public int comboKeyFirst;

    @SerializedName("ab_type")
    public int comboKeyMode;

    @SerializedName("b_key_id")
    public int comboKeySecond;
    public String desc;
    public String key;
    public String key_cancel;
    public int key_id;
    public int key_id_cancel;
    public ArrayList<CFGSubPropertyMacro> macro_keys;
    public String title;
    public int type;

    public CFGPropertyMacro(Parcel parcel) {
        this.key_id = -1;
        this.key = "";
        this.type = 0;
        this.key_id_cancel = 255;
        this.key_cancel = "";
        this.title = "";
        this.desc = "";
        this.comboKeyMode = -1;
        this.comboKeyFirst = -1;
        this.comboKeySecond = -1;
        this.macro_keys = new ArrayList<>();
        this.key_id = parcel.readInt();
        this.key = parcel.readString();
        this.type = parcel.readInt();
        this.key_id_cancel = parcel.readInt();
        this.key_cancel = parcel.readString();
        this.title = parcel.readString();
        this.desc = parcel.readString();
        this.comboKeyMode = parcel.readInt();
        this.comboKeyFirst = parcel.readInt();
        this.comboKeySecond = parcel.readInt();
        this.macro_keys = parcel.createTypedArrayList(CFGSubPropertyMacro.CREATOR);
    }

    public int convertTypeToTMode() {
        int i10 = this.type;
        if (i10 == 0) {
            return 40;
        }
        return i10 == 1 ? 41 : 42;
    }

    public CFGPropertyMacro copy() {
        return m4clone();
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
        CFGPropertyMacro cFGPropertyMacro = (CFGPropertyMacro) obj;
        return this.key_id == cFGPropertyMacro.key_id && this.type == cFGPropertyMacro.type && this.key_id_cancel == cFGPropertyMacro.key_id_cancel && this.comboKeyMode == cFGPropertyMacro.comboKeyMode && this.comboKeyFirst == cFGPropertyMacro.comboKeyFirst && this.comboKeySecond == cFGPropertyMacro.comboKeySecond && Objects.equals(this.key, cFGPropertyMacro.key) && Objects.equals(this.key_cancel, cFGPropertyMacro.key_cancel) && Objects.equals(this.title, cFGPropertyMacro.title) && Objects.equals(this.desc, cFGPropertyMacro.desc) && Objects.equals(this.macro_keys, cFGPropertyMacro.macro_keys);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.key_id), this.key, Integer.valueOf(this.type), Integer.valueOf(this.key_id_cancel), this.key_cancel, this.title, this.desc, Integer.valueOf(this.comboKeyMode), Integer.valueOf(this.comboKeyFirst), Integer.valueOf(this.comboKeySecond), this.macro_keys);
    }

    public String toString() {
        return "CFGPropertyMacro{key_id=" + this.key_id + ", key='" + this.key + "', type=" + this.type + ", key_id_cancel=" + this.key_id_cancel + ", key_cancel='" + this.key_cancel + "', title='" + this.title + "', desc='" + this.desc + "', comboKeyMode=" + this.comboKeyMode + ", comboKeyFirst=" + this.comboKeyFirst + ", comboKeySecond=" + this.comboKeySecond + ", macro_keys=" + this.macro_keys + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.key_id);
        parcel.writeString(this.key);
        parcel.writeInt(this.type);
        parcel.writeInt(this.key_id_cancel);
        parcel.writeString(this.key_cancel);
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeInt(this.comboKeyMode);
        parcel.writeInt(this.comboKeyFirst);
        parcel.writeInt(this.comboKeySecond);
        parcel.writeTypedList(this.macro_keys);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CFGPropertyMacro m4clone() {
        CFGPropertyMacro cFGPropertyMacro;
        CloneNotSupportedException e10;
        try {
            cFGPropertyMacro = (CFGPropertyMacro) super.clone();
            try {
                if (this.macro_keys != null) {
                    cFGPropertyMacro.macro_keys = new ArrayList<>();
                    Iterator<CFGSubPropertyMacro> it2 = this.macro_keys.iterator();
                    while (it2.hasNext()) {
                        cFGPropertyMacro.macro_keys.add(it2.next().copy());
                    }
                }
            } catch (CloneNotSupportedException e11) {
                e10 = e11;
                e10.printStackTrace();
            }
        } catch (CloneNotSupportedException e12) {
            cFGPropertyMacro = null;
            e10 = e12;
        }
        return cFGPropertyMacro;
    }

    public CFGPropertyMacro() {
        this.key_id = -1;
        this.key = "";
        this.type = 0;
        this.key_id_cancel = 255;
        this.key_cancel = "";
        this.title = "";
        this.desc = "";
        this.comboKeyMode = -1;
        this.comboKeyFirst = -1;
        this.comboKeySecond = -1;
        this.macro_keys = new ArrayList<>();
    }
}
