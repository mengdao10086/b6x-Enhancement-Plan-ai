package com.omarea.krscript.model;

import a.f92;
import a.n30;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ActionParamInfo {
    public String desc;
    public boolean editable;
    public String label;
    public boolean multiple;
    public String name;
    public ArrayList<n30> options;
    public ArrayList<n30> optionsFromShell;
    public boolean readonly;
    public boolean required;
    public String title;
    public String type;
    public String value;
    public String valueFromShell;
    public String valueShell;
    public int maxLength = -1;
    public int max = Integer.MAX_VALUE;
    public int min = Integer.MIN_VALUE;
    public String optionsSh = "";
    public boolean supported = true;
    public String placeholder = "";
    public String mime = "";
    public String suffix = "";
    public String separator = "\n";

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getEditable() {
        return this.editable;
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public final String getMime() {
        return this.mime;
    }

    public final int getMin() {
        return this.min;
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

    public final ArrayList<n30> getOptionsFromShell() {
        return this.optionsFromShell;
    }

    public final String getOptionsSh() {
        return this.optionsSh;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final boolean getReadonly() {
        return this.readonly;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final String getSeparator() {
        return this.separator;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final boolean getSupported() {
        return this.supported;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getValueFromShell() {
        return this.valueFromShell;
    }

    public final String getValueShell() {
        return this.valueShell;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setEditable(boolean z) {
        this.editable = z;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final void setMax(int i) {
        this.max = i;
    }

    public final void setMaxLength(int i) {
        this.maxLength = i;
    }

    public final void setMime(String str) {
        f92.d(str, "<set-?>");
        this.mime = str;
    }

    public final void setMin(int i) {
        this.min = i;
    }

    public final void setMultiple(boolean z) {
        this.multiple = z;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOptions(ArrayList<n30> arrayList) {
        this.options = arrayList;
    }

    public final void setOptionsFromShell(ArrayList<n30> arrayList) {
        this.optionsFromShell = arrayList;
    }

    public final void setOptionsSh(String str) {
        f92.d(str, "<set-?>");
        this.optionsSh = str;
    }

    public final void setPlaceholder(String str) {
        f92.d(str, "<set-?>");
        this.placeholder = str;
    }

    public final void setReadonly(boolean z) {
        this.readonly = z;
    }

    public final void setRequired(boolean z) {
        this.required = z;
    }

    public final void setSeparator(String str) {
        f92.d(str, "<set-?>");
        this.separator = str;
    }

    public final void setSuffix(String str) {
        f92.d(str, "<set-?>");
        this.suffix = str;
    }

    public final void setSupported(boolean z) {
        this.supported = z;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final void setValueFromShell(String str) {
        this.valueFromShell = str;
    }

    public final void setValueShell(String str) {
        this.valueShell = str;
    }
}
