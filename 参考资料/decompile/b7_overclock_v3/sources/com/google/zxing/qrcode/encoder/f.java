package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.g;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21683f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Mode f21684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ErrorCorrectionLevel f21685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f21686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f21687d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f21688e;

    public static boolean f(int i10) {
        return i10 >= 0 && i10 < 8;
    }

    public ErrorCorrectionLevel a() {
        return this.f21685b;
    }

    public int b() {
        return this.f21687d;
    }

    public b c() {
        return this.f21688e;
    }

    public Mode d() {
        return this.f21684a;
    }

    public g e() {
        return this.f21686c;
    }

    public void g(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f21685b = errorCorrectionLevel;
    }

    public void h(int i10) {
        this.f21687d = i10;
    }

    public void i(b bVar) {
        this.f21688e = bVar;
    }

    public void j(Mode mode) {
        this.f21684a = mode;
    }

    public void k(g gVar) {
        this.f21686c = gVar;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(200);
        sb2.append("<<\n");
        sb2.append(" mode: ");
        sb2.append(this.f21684a);
        sb2.append("\n ecLevel: ");
        sb2.append(this.f21685b);
        sb2.append("\n version: ");
        sb2.append(this.f21686c);
        sb2.append("\n maskPattern: ");
        sb2.append(this.f21687d);
        if (this.f21688e == null) {
            sb2.append("\n matrix: null\n");
        } else {
            sb2.append("\n matrix:\n");
            sb2.append(this.f21688e);
        }
        sb2.append(">>\n");
        return sb2.toString();
    }
}
