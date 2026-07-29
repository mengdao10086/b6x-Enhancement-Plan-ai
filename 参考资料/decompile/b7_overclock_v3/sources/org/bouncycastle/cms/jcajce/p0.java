package org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class p0 implements cs.c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44614a = "1.2.840.113549.1.9.16.3.8";

    @Override // cs.c0
    public zn.b a() {
        return new zn.b(new gm.y("1.2.840.113549.1.9.16.3.8"));
    }

    @Override // cs.c0
    public OutputStream b(OutputStream outputStream) {
        return new DeflaterOutputStream(outputStream);
    }
}
