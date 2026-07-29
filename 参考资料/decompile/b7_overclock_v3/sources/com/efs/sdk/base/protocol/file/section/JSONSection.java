package com.efs.sdk.base.protocol.file.section;

import com.umeng.socialize.handler.UMSSOHandler;

/* JADX INFO: loaded from: classes2.dex */
public class JSONSection extends AbsSection {
    private String body;

    public JSONSection(String str) {
        super(UMSSOHandler.JSON);
        this.name = str;
    }

    @Override // com.efs.sdk.base.protocol.file.section.AbsSection
    public String changeToStr() {
        return getDeclarationLine() + "\n" + this.body + "\n";
    }

    public void setBody(String str) {
        this.body = str;
    }
}
