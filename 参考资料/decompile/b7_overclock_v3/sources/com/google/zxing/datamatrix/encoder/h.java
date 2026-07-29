package com.google.zxing.datamatrix.encoder;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SymbolShapeHint f21320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ve.c f21321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ve.c f21322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StringBuilder f21323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f21326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f21327i;

    public h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb2 = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i10 = 0; i10 < length; i10++) {
            char c10 = (char) (bytes[i10] & 255);
            if (c10 == '?' && str.charAt(i10) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb2.append(c10);
        }
        this.f21319a = sb2.toString();
        this.f21320b = SymbolShapeHint.FORCE_NONE;
        this.f21323e = new StringBuilder(str.length());
        this.f21325g = -1;
    }

    public int a() {
        return this.f21323e.length();
    }

    public StringBuilder b() {
        return this.f21323e;
    }

    public char c() {
        return this.f21319a.charAt(this.f21324f);
    }

    public char d() {
        return this.f21319a.charAt(this.f21324f);
    }

    public String e() {
        return this.f21319a;
    }

    public int f() {
        return this.f21325g;
    }

    public int g() {
        return i() - this.f21324f;
    }

    public k h() {
        return this.f21326h;
    }

    public final int i() {
        return this.f21319a.length() - this.f21327i;
    }

    public boolean j() {
        return this.f21324f < i();
    }

    public void k() {
        this.f21325g = -1;
    }

    public void l() {
        this.f21326h = null;
    }

    public void m(ve.c cVar, ve.c cVar2) {
        this.f21321c = cVar;
        this.f21322d = cVar2;
    }

    public void n(int i10) {
        this.f21327i = i10;
    }

    public void o(SymbolShapeHint symbolShapeHint) {
        this.f21320b = symbolShapeHint;
    }

    public void p(int i10) {
        this.f21325g = i10;
    }

    public void q() {
        r(a());
    }

    public void r(int i10) {
        k kVar = this.f21326h;
        if (kVar == null || i10 > kVar.b()) {
            this.f21326h = k.o(i10, this.f21320b, this.f21321c, this.f21322d, true);
        }
    }

    public void s(char c10) {
        this.f21323e.append(c10);
    }

    public void t(String str) {
        this.f21323e.append(str);
    }
}
