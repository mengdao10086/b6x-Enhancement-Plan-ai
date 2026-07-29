package com.flydigi.sdk.gamepad.extension.config.data;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class CFGMacroList {

    @SerializedName("gamepad_whole_list")
    private ArrayList<CFGPropertyMacro> gpWholeList = new ArrayList<>();

    @SerializedName("keyboard_mouse_list")
    private ArrayList<CFGPropertyMacro> kbMosList = new ArrayList<>();

    @SerializedName("gamepad_half_list")
    private ArrayList<CFGPropertyMacro> gpHalfList = new ArrayList<>();

    public CFGMacroList copy() {
        CFGMacroList cFGMacroList = new CFGMacroList();
        for (int i10 = 0; i10 < this.gpWholeList.size(); i10++) {
            cFGMacroList.gpWholeList.add(this.gpWholeList.get(i10).copy());
        }
        for (int i11 = 0; i11 < this.kbMosList.size(); i11++) {
            cFGMacroList.kbMosList.add(this.kbMosList.get(i11).copy());
        }
        for (int i12 = 0; i12 < this.gpHalfList.size(); i12++) {
            cFGMacroList.gpHalfList.add(this.gpHalfList.get(i12).copy());
        }
        return cFGMacroList;
    }

    public ArrayList<CFGPropertyMacro> getGpHalfList() {
        return this.gpHalfList;
    }

    public ArrayList<CFGPropertyMacro> getGpWholeList() {
        return this.gpWholeList;
    }

    public ArrayList<CFGPropertyMacro> getKbMosList() {
        return this.kbMosList;
    }

    public void setGpHalfList(ArrayList<CFGPropertyMacro> arrayList) {
        this.gpHalfList = arrayList;
    }

    public void setGpWholeList(ArrayList<CFGPropertyMacro> arrayList) {
        this.gpWholeList = arrayList;
    }

    public void setKbMosList(ArrayList<CFGPropertyMacro> arrayList) {
        this.kbMosList = arrayList;
    }
}
