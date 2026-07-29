package org.bouncycastle.jcajce.provider.asymmetric.util;

import pn.u;
import zn.c1;

/* JADX INFO: loaded from: classes7.dex */
public class l {
    public static byte[] a(u uVar) {
        try {
            return uVar.v(gm.j.f29713a);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(zn.b bVar, gm.h hVar) {
        try {
            return a(new u(bVar, hVar.b()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] c(zn.b bVar, gm.h hVar) {
        try {
            return e(new c1(bVar, hVar));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] d(zn.b bVar, byte[] bArr) {
        try {
            return e(new c1(bVar, bArr));
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] e(c1 c1Var) {
        try {
            return c1Var.v(gm.j.f29713a);
        } catch (Exception unused) {
            return null;
        }
    }
}
