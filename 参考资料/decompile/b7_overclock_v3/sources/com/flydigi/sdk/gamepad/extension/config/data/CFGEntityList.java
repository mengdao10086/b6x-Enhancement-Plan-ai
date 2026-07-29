package com.flydigi.sdk.gamepad.extension.config.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CFGEntityList implements Parcelable {
    public static final Parcelable.Creator<CFGEntityList> CREATOR = new Parcelable.Creator<CFGEntityList>() { // from class: com.flydigi.sdk.gamepad.extension.config.data.CFGEntityList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGEntityList createFromParcel(Parcel parcel) {
            return new CFGEntityList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CFGEntityList[] newArray(int i10) {
            return new CFGEntityList[i10];
        }
    };

    @SerializedName("v1_list")
    private List<CFGEntity> configsForHalfGamepad;

    @SerializedName("keyboard_mouse_list")
    private List<CFGEntity> configsForKeyboard;

    @SerializedName("gamepad_list")
    private List<CFGEntity> configsForWholeGamepad;
    private int modify;

    public CFGEntityList() {
        this.modify = -1;
        this.configsForWholeGamepad = new ArrayList();
        this.configsForKeyboard = new ArrayList();
        this.configsForHalfGamepad = new ArrayList();
    }

    public CFGEntityList copy() {
        CFGEntityList cFGEntityList = new CFGEntityList();
        cFGEntityList.modify = this.modify;
        for (int i10 = 0; i10 < this.configsForWholeGamepad.size(); i10++) {
            cFGEntityList.configsForWholeGamepad.add(this.configsForWholeGamepad.get(i10).copy());
        }
        for (int i11 = 0; i11 < this.configsForKeyboard.size(); i11++) {
            cFGEntityList.configsForKeyboard.add(this.configsForKeyboard.get(i11).copy());
        }
        for (int i12 = 0; i12 < this.configsForHalfGamepad.size(); i12++) {
            cFGEntityList.configsForHalfGamepad.add(this.configsForHalfGamepad.get(i12).copy());
        }
        return cFGEntityList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<CFGEntity> getConfigsForHalfGamepad() {
        return this.configsForHalfGamepad;
    }

    public List<CFGEntity> getConfigsForKeyboard() {
        return this.configsForKeyboard;
    }

    public List<CFGEntity> getConfigsForWholeGamepad() {
        return this.configsForWholeGamepad;
    }

    public int getModify() {
        return this.modify;
    }

    public boolean isValid() {
        List<CFGEntity> list;
        List<CFGEntity> list2;
        List<CFGEntity> list3 = this.configsForWholeGamepad;
        return (list3 != null && list3.size() > 0) || ((list = this.configsForKeyboard) != null && list.size() > 0) || ((list2 = this.configsForHalfGamepad) != null && list2.size() > 0);
    }

    public void setConfigsForHalfGamepad(List<CFGEntity> list) {
        this.configsForHalfGamepad = list;
    }

    public void setConfigsForKeyboard(List<CFGEntity> list) {
        this.configsForKeyboard = list;
    }

    public void setConfigsForWholeGamepad(List<CFGEntity> list) {
        this.configsForWholeGamepad = list;
    }

    public void setModify(int i10) {
        this.modify = i10;
    }

    public String toString() {
        return "CFGEntityList{modify=" + this.modify + ", gamepadList=" + this.configsForWholeGamepad + ", keydMosList=" + this.configsForKeyboard + ", v1List=" + this.configsForHalfGamepad + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.modify);
        parcel.writeTypedList(this.configsForWholeGamepad);
        parcel.writeTypedList(this.configsForKeyboard);
        parcel.writeTypedList(this.configsForHalfGamepad);
    }

    public CFGEntityList(Parcel parcel) {
        this.modify = -1;
        this.configsForWholeGamepad = new ArrayList();
        this.configsForKeyboard = new ArrayList();
        this.configsForHalfGamepad = new ArrayList();
        this.modify = parcel.readInt();
        Parcelable.Creator<CFGEntity> creator = CFGEntity.CREATOR;
        this.configsForWholeGamepad = parcel.createTypedArrayList(creator);
        this.configsForKeyboard = parcel.createTypedArrayList(creator);
        this.configsForHalfGamepad = parcel.createTypedArrayList(creator);
    }
}
