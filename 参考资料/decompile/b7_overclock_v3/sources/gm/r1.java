package gm;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class r1 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f29796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f29797b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InputStream f29798c;

    public r1(j0 j0Var) {
        this.f29796a = j0Var;
    }

    public final a0 a() throws IOException {
        h hVarJ = this.f29796a.j();
        if (hVarJ == null) {
            return null;
        }
        if (hVarJ instanceof a0) {
            return (a0) hVarJ;
        }
        throw new IOException("unknown object encountered: " + hVarJ.getClass());
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        a0 a0VarA;
        if (this.f29798c == null) {
            if (!this.f29797b || (a0VarA = a()) == null) {
                return -1;
            }
            this.f29797b = false;
            this.f29798c = a0VarA.a();
        }
        while (true) {
            int i10 = this.f29798c.read();
            if (i10 >= 0) {
                return i10;
            }
            a0 a0VarA2 = a();
            if (a0VarA2 == null) {
                this.f29798c = null;
                return -1;
            }
            this.f29798c = a0VarA2.a();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        a0 a0VarA;
        int i12 = 0;
        if (this.f29798c == null) {
            if (!this.f29797b || (a0VarA = a()) == null) {
                return -1;
            }
            this.f29797b = false;
            this.f29798c = a0VarA.a();
        }
        while (true) {
            int i13 = this.f29798c.read(bArr, i10 + i12, i11 - i12);
            if (i13 >= 0) {
                i12 += i13;
                if (i12 == i11) {
                    return i12;
                }
            } else {
                a0 a0VarA2 = a();
                if (a0VarA2 == null) {
                    this.f29798c = null;
                    if (i12 < 1) {
                        return -1;
                    }
                    return i12;
                }
                this.f29798c = a0VarA2.a();
            }
        }
    }
}
