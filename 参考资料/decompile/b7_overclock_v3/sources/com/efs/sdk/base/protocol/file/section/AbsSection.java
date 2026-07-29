package com.efs.sdk.base.protocol.file.section;

import ag.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsSection {
    public static final String SEP_LINE_BREAK = "linebreak";
    public static final String SEP_ORIGIN_LINE_BREAK = "\n";
    public String type;
    public String name = "";
    public String version = "1.0";
    public String sep = "";

    public AbsSection(String str) {
        this.type = str;
    }

    public abstract String changeToStr();

    public String getDeclarationLine() {
        return "section:" + this.name + c.f654g + this.type + c.f654g + this.version + c.f654g + this.sep;
    }

    public void setSep(String str) {
        if (str.equals("\n")) {
            this.sep = SEP_LINE_BREAK;
        } else {
            this.sep = str;
        }
    }
}
