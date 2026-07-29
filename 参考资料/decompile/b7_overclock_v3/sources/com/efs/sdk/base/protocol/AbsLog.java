package com.efs.sdk.base.protocol;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsLog implements ILogProtocol {

    /* JADX INFO: renamed from: cp, reason: collision with root package name */
    private String f12950cp = "none";

    /* JADX INFO: renamed from: de, reason: collision with root package name */
    private byte f12951de = 1;
    private String logType;

    public AbsLog(String str) {
        this.logType = str;
    }

    @Override // com.efs.sdk.base.protocol.ILogProtocol
    public String getLogType() {
        return this.logType;
    }

    public boolean isCp() {
        return !this.f12950cp.equals("none");
    }

    public boolean isDe() {
        return this.f12951de != 1;
    }

    public void setCp(String str) {
        this.f12950cp = str;
    }

    public void setDe(byte b10) {
        this.f12951de = b10;
    }
}
