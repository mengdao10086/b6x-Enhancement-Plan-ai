package sr;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class c extends FilterOutputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static byte[] f50397c = {13, 10};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f50399b;

    public c(ur.d dVar, e eVar, OutputStream outputStream) {
        super(outputStream);
        this.f50398a = -1;
        this.f50399b = eVar.g() != null ? (eVar.g() == null || eVar.g().equals("binary")) ? false : true : dVar.a().equals("7bit");
    }

    public void a() throws IOException {
        ((FilterOutputStream) this).out.write(f50397c);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(int r3) throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r2.f50399b
            if (r0 == 0) goto L20
            r0 = 13
            if (r3 != r0) goto L10
            java.io.OutputStream r0 = r2.out
            byte[] r1 = sr.c.f50397c
            r0.write(r1)
            goto L25
        L10:
            r1 = 10
            if (r3 != r1) goto L20
            int r1 = r2.f50398a
            if (r1 == r0) goto L25
            java.io.OutputStream r0 = r2.out
            byte[] r1 = sr.c.f50397c
            r0.write(r1)
            goto L25
        L20:
            java.io.OutputStream r0 = r2.out
            r0.write(r3)
        L25:
            r2.f50398a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sr.c.write(int):void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        for (int i12 = i10; i12 != i10 + i11; i12++) {
            write(bArr[i12]);
        }
    }
}
