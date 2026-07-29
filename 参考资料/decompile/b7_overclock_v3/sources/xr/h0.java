package xr;

import gm.p2;

/* JADX INFO: loaded from: classes6.dex */
public class h0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55920a;

    public h0(String str) {
        this.f55920a = str;
    }

    public static h0 x(Object obj) {
        if (obj instanceof h0) {
            return (h0) obj;
        }
        if (obj instanceof String) {
            return new h0((String) obj);
        }
        if (obj instanceof gm.k0) {
            return new h0(((gm.k0) obj).d());
        }
        throw new IllegalArgumentException("hostname accepts Hostname, String and ASN1String");
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new p2(this.f55920a);
    }
}
