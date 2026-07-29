package com.umeng.analytics.pro;

/* JADX INFO: loaded from: classes5.dex */
public final class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f23430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23431c;

    public bt() {
        this("", (byte) 0, 0);
    }

    public boolean a(bt btVar) {
        return this.f23429a.equals(btVar.f23429a) && this.f23430b == btVar.f23430b && this.f23431c == btVar.f23431c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bt) {
            return a((bt) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f23429a + "' type: " + ((int) this.f23430b) + " seqid:" + this.f23431c + ">";
    }

    public bt(String str, byte b10, int i10) {
        this.f23429a = str;
        this.f23430b = b10;
        this.f23431c = i10;
    }
}
