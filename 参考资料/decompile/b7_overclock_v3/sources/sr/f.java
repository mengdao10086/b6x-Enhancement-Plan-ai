package sr;

import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f50410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50411b = -1;

    public f(InputStream inputStream) {
        this.f50410a = inputStream;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x001a, code lost:
    
        r1 = r4.f50410a.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a() throws java.io.IOException {
        /*
            r4 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            int r1 = r4.f50411b
            r2 = -1
            r3 = 13
            if (r1 == r2) goto L14
            if (r1 != r3) goto L11
            java.lang.String r0 = ""
            return r0
        L11:
            r4.f50411b = r2
            goto L1a
        L14:
            java.io.InputStream r1 = r4.f50410a
            int r1 = r1.read()
        L1a:
            r2 = 10
            if (r1 < 0) goto L26
            if (r1 == r3) goto L26
            if (r1 == r2) goto L26
            r0.write(r1)
            goto L14
        L26:
            if (r1 != r3) goto L34
            java.io.InputStream r3 = r4.f50410a
            int r3 = r3.read()
            if (r3 == r2) goto L34
            if (r3 < 0) goto L34
            r4.f50411b = r3
        L34:
            if (r1 >= 0) goto L38
            r0 = 0
            return r0
        L38:
            byte[] r0 = r0.toByteArray()
            java.lang.String r0 = org.bouncycastle.util.Strings.d(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sr.f.a():java.lang.String");
    }
}
