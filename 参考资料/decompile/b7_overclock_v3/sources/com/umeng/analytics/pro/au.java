package com.umeng.analytics.pro;

import com.blankj.utilcode.util.i0;

/* JADX INFO: loaded from: classes5.dex */
public class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private short[] f23326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23327b = -1;

    public au(int i10) {
        this.f23326a = new short[i10];
    }

    private void d() {
        short[] sArr = this.f23326a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f23326a = sArr2;
    }

    public short a() {
        short[] sArr = this.f23326a;
        int i10 = this.f23327b;
        this.f23327b = i10 - 1;
        return sArr[i10];
    }

    public short b() {
        return this.f23326a[this.f23327b];
    }

    public void c() {
        this.f23327b = -1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<ShortStack vector:[");
        for (int i10 = 0; i10 < this.f23326a.length; i10++) {
            if (i10 != 0) {
                sb2.append(i0.f11861z);
            }
            if (i10 == this.f23327b) {
                sb2.append(">>");
            }
            sb2.append((int) this.f23326a[i10]);
            if (i10 == this.f23327b) {
                sb2.append("<<");
            }
        }
        sb2.append("]>");
        return sb2.toString();
    }

    public void a(short s10) {
        if (this.f23326a.length == this.f23327b + 1) {
            d();
        }
        short[] sArr = this.f23326a;
        int i10 = this.f23327b + 1;
        this.f23327b = i10;
        sArr[i10] = s10;
    }
}
