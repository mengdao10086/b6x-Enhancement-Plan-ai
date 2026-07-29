package org.bouncycastle.pqc.crypto.lms;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.crypto.m0;
import zo.e0;
import zo.h0;
import zo.j0;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, gm.y> f45729a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<gm.y, String> f45730b = new HashMap();

    static {
        Map<String, gm.y> map = f45729a;
        gm.y yVar = kn.d.f37592c;
        map.put("SHA-256", yVar);
        Map<String, gm.y> map2 = f45729a;
        gm.y yVar2 = kn.d.f37596e;
        map2.put("SHA-512", yVar2);
        Map<String, gm.y> map3 = f45729a;
        gm.y yVar3 = kn.d.f37612m;
        map3.put("SHAKE128", yVar3);
        Map<String, gm.y> map4 = f45729a;
        gm.y yVar4 = kn.d.f37614n;
        map4.put("SHAKE256", yVar4);
        f45730b.put(yVar, "SHA-256");
        f45730b.put(yVar2, "SHA-512");
        f45730b.put(yVar3, "SHAKE128");
        f45730b.put(yVar4, "SHAKE256");
    }

    public static org.bouncycastle.crypto.s a(gm.y yVar) {
        if (yVar.C(kn.d.f37592c)) {
            return new e0();
        }
        if (yVar.C(kn.d.f37596e)) {
            return new h0();
        }
        if (yVar.C(kn.d.f37612m)) {
            return new j0(128);
        }
        if (yVar.C(kn.d.f37614n)) {
            return new j0(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + yVar);
    }

    public static String b(gm.y yVar) {
        String str = f45730b.get(yVar);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unrecognized digest oid: " + yVar);
    }

    public static gm.y c(String str) {
        gm.y yVar = f45729a.get(str);
        if (yVar != null) {
            return yVar;
        }
        throw new IllegalArgumentException("unrecognized digest name: " + str);
    }

    public static int d(org.bouncycastle.crypto.s sVar) {
        boolean z10 = sVar instanceof m0;
        int iH = sVar.h();
        return z10 ? iH * 2 : iH;
    }
}
