package com.omarea.krscript.model;

import a.f92;
import a.n30;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class PickerNode extends RunnableNode {
    public String getState;
    public boolean multiple;
    public String name;
    public ArrayList<n30> options;
    public String optionsSh;
    public String separator;
    public String value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerNode(String str) {
        super(str);
        f92.d(str, "currentConfigXml");
        this.optionsSh = "";
        this.name = "";
        this.separator = "\n";
    }

    public final String getGetState() {
        return this.getState;
    }

    public final boolean getMultiple() {
        return this.multiple;
    }

    public final String getName() {
        return this.name;
    }

    public final ArrayList<n30> getOptions() {
        return this.options;
    }

    public final String getOptionsSh() {
        return this.optionsSh;
    }

    public final String getSeparator() {
        return this.separator;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setGetState(String str) {
        this.getState = str;
    }

    public final void setMultiple(boolean z) {
        this.multiple = z;
    }

    public final void setName(String str) {
        f92.d(str, "<set-?>");
        this.name = str;
    }

    public final void setOptions(ArrayList<n30> arrayList) {
        this.options = arrayList;
    }

    public final void setOptionsSh(String str) {
        f92.d(str, "<set-?>");
        this.optionsSh = str;
    }

    public final void setSeparator(String str) {
        f92.d(str, "<set-?>");
        this.separator = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
