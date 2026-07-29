package com.qualcomm.qti.libraries.vmupgrade.packet;

import jg.d;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f22179d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f22180e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f22181f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f22182g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f22183h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f22184i = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f22187c;

    public a(int i10, byte[] bArr) {
        this.f22185a = "VMUPacket";
        this.f22186b = i10;
        if (bArr != null) {
            this.f22187c = bArr;
        } else {
            this.f22187c = new byte[0];
        }
    }

    public byte[] a() {
        byte[] bArr = this.f22187c;
        byte[] bArr2 = new byte[bArr.length + 3];
        bArr2[0] = (byte) this.f22186b;
        d.a(bArr.length, bArr2, 1, 2, false);
        byte[] bArr3 = this.f22187c;
        if (bArr3.length > 0) {
            System.arraycopy(bArr3, 0, bArr2, 3, bArr3.length);
        }
        return bArr2;
    }

    public byte[] b() {
        return this.f22187c;
    }

    public int c() {
        return this.f22187c.length;
    }

    public int d() {
        return this.f22186b;
    }

    public a(int i10) {
        this.f22185a = "VMUPacket";
        this.f22186b = i10;
        this.f22187c = new byte[0];
    }

    public a(byte[] bArr) throws VMUException {
        this.f22185a = "VMUPacket";
        if (bArr.length >= 3) {
            this.f22186b = kg.a.a(bArr[0]);
            int iB = d.b(bArr, 1, 2, false);
            int length = bArr.length - 3;
            if (iB > length) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Building packet: the LENGTH (");
                sb2.append(iB);
                sb2.append(") is bigger than the DATA length(");
                sb2.append(length);
                sb2.append(").");
            } else if (iB < length) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Building packet: the LENGTH (");
                sb3.append(iB);
                sb3.append(") is smaller than the DATA length(");
                sb3.append(length);
                sb3.append(").");
            }
            byte[] bArr2 = new byte[length];
            this.f22187c = bArr2;
            if (length > 0) {
                System.arraycopy(bArr, 3, bArr2, 0, length);
                return;
            }
            return;
        }
        throw new VMUException(0, bArr);
    }
}
