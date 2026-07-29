package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bp;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class az {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bv f23342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ci f23343b;

    public az() {
        this(new bp.a());
    }

    private bq j(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        this.f23343b.a(bArr);
        int length = bdVarArr.length + 1;
        bd[] bdVarArr2 = new bd[length];
        int i10 = 0;
        bdVarArr2[0] = bdVar;
        int i11 = 0;
        while (i11 < bdVarArr.length) {
            int i12 = i11 + 1;
            bdVarArr2[i12] = bdVarArr[i11];
            i11 = i12;
        }
        this.f23342a.j();
        bq bqVarL = null;
        while (i10 < length) {
            bqVarL = this.f23342a.l();
            if (bqVarL.f23422b == 0 || bqVarL.f23423c > bdVarArr2[i10].a()) {
                return null;
            }
            if (bqVarL.f23423c != bdVarArr2[i10].a()) {
                by.a(this.f23342a, bqVarL.f23422b);
                this.f23342a.m();
            } else {
                i10++;
                if (i10 < length) {
                    this.f23342a.j();
                }
            }
        }
        return bqVarL;
    }

    public void a(aw awVar, byte[] bArr) throws bc {
        try {
            this.f23343b.a(bArr);
            awVar.read(this.f23342a);
        } finally {
            this.f23343b.e();
            this.f23342a.B();
        }
    }

    public Byte b(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Byte) a((byte) 3, bArr, bdVar, bdVarArr);
    }

    public Double c(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Double) a((byte) 4, bArr, bdVar, bdVarArr);
    }

    public Short d(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Short) a((byte) 6, bArr, bdVar, bdVarArr);
    }

    public Integer e(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Integer) a((byte) 8, bArr, bdVar, bdVarArr);
    }

    public Long f(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Long) a((byte) 10, bArr, bdVar, bdVarArr);
    }

    public String g(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (String) a((byte) 11, bArr, bdVar, bdVarArr);
    }

    public ByteBuffer h(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (ByteBuffer) a((byte) 100, bArr, bdVar, bdVarArr);
    }

    public Short i(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        Short shValueOf;
        try {
            try {
                if (j(bArr, bdVar, bdVarArr) != null) {
                    this.f23342a.j();
                    shValueOf = Short.valueOf(this.f23342a.l().f23423c);
                } else {
                    shValueOf = null;
                }
                return shValueOf;
            } catch (Exception e10) {
                throw new bc(e10);
            }
        } finally {
            this.f23343b.e();
            this.f23342a.B();
        }
    }

    public az(bx bxVar) {
        ci ciVar = new ci();
        this.f23343b = ciVar;
        this.f23342a = bxVar.a(ciVar);
    }

    public void a(aw awVar, String str, String str2) throws bc {
        try {
            try {
                a(awVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bc("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f23342a.B();
        }
    }

    public void a(aw awVar, byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        try {
            try {
                if (j(bArr, bdVar, bdVarArr) != null) {
                    awVar.read(this.f23342a);
                }
            } catch (Exception e10) {
                throw new bc(e10);
            }
        } finally {
            this.f23343b.e();
            this.f23342a.B();
        }
    }

    public Boolean a(byte[] bArr, bd bdVar, bd... bdVarArr) throws bc {
        return (Boolean) a((byte) 2, bArr, bdVar, bdVarArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object a(byte r1, byte[] r2, com.umeng.analytics.pro.bd r3, com.umeng.analytics.pro.bd... r4) throws com.umeng.analytics.pro.bc {
        /*
            r0 = this;
            com.umeng.analytics.pro.bq r2 = r0.j(r2, r3, r4)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r2 == 0) goto L9e
            r3 = 2
            if (r1 == r3) goto L8f
            r3 = 3
            if (r1 == r3) goto L80
            r3 = 4
            if (r1 == r3) goto L71
            r3 = 6
            if (r1 == r3) goto L62
            r3 = 8
            if (r1 == r3) goto L53
            r3 = 100
            r4 = 11
            if (r1 == r3) goto L48
            r3 = 10
            if (r1 == r3) goto L39
            if (r1 == r4) goto L24
            goto L9e
        L24:
            byte r1 = r2.f23422b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r4) goto L9e
            com.umeng.analytics.pro.bv r1 = r0.f23342a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r1 = r1.z()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
        L2e:
            com.umeng.analytics.pro.ci r2 = r0.f23343b
            r2.e()
            com.umeng.analytics.pro.bv r2 = r0.f23342a
            r2.B()
            return r1
        L39:
            byte r1 = r2.f23422b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bv r1 = r0.f23342a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            long r1 = r1.x()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L48:
            byte r1 = r2.f23422b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r4) goto L9e
            com.umeng.analytics.pro.bv r1 = r0.f23342a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.nio.ByteBuffer r1 = r1.A()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L53:
            byte r1 = r2.f23422b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bv r1 = r0.f23342a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            int r1 = r1.w()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L62:
            byte r1 = r2.f23422b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bv r1 = r0.f23342a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            short r1 = r1.v()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Short r1 = java.lang.Short.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L71:
            byte r1 = r2.f23422b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bv r1 = r0.f23342a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            double r1 = r1.y()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L80:
            byte r1 = r2.f23422b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bv r1 = r0.f23342a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            byte r1 = r1.u()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Byte r1 = java.lang.Byte.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L8f:
            byte r1 = r2.f23422b     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 != r3) goto L9e
            com.umeng.analytics.pro.bv r1 = r0.f23342a     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            boolean r1 = r1.t()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            goto L2e
        L9e:
            r1 = 0
            goto L2e
        La0:
            r1 = move-exception
            goto La9
        La2:
            r1 = move-exception
            com.umeng.analytics.pro.bc r2 = new com.umeng.analytics.pro.bc     // Catch: java.lang.Throwable -> La0
            r2.<init>(r1)     // Catch: java.lang.Throwable -> La0
            throw r2     // Catch: java.lang.Throwable -> La0
        La9:
            com.umeng.analytics.pro.ci r2 = r0.f23343b
            r2.e()
            com.umeng.analytics.pro.bv r2 = r0.f23342a
            r2.B()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.az.a(byte, byte[], com.umeng.analytics.pro.bd, com.umeng.analytics.pro.bd[]):java.lang.Object");
    }

    public void a(aw awVar, String str) throws bc {
        a(awVar, str.getBytes());
    }
}
