package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bp;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes5.dex */
public class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f23353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ch f23354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private bv f23355c;

    public bf() {
        this(new bp.a());
    }

    public byte[] a(aw awVar) throws bc {
        this.f23353a.reset();
        awVar.write(this.f23355c);
        return this.f23353a.toByteArray();
    }

    public String b(aw awVar) throws bc {
        return new String(a(awVar));
    }

    public bf(bx bxVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f23353a = byteArrayOutputStream;
        ch chVar = new ch(byteArrayOutputStream);
        this.f23354b = chVar;
        this.f23355c = bxVar.a(chVar);
    }

    public String a(aw awVar, String str) throws bc {
        try {
            return new String(a(awVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bc("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
