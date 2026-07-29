package gm;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class q1 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f29786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f29787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29788c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29789d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f29790e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InputStream f29791f;

    public q1(j0 j0Var, boolean z10) {
        this.f29786a = j0Var;
        this.f29787b = z10;
    }

    public final e a() throws IOException {
        h hVarJ = this.f29786a.j();
        if (hVarJ == null) {
            if (!this.f29787b || this.f29789d == 0) {
                return null;
            }
            throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.f29789d);
        }
        if (hVarJ instanceof e) {
            if (this.f29789d == 0) {
                return (e) hVarJ;
            }
            throw new IOException("only the last nested bitstring can have padding");
        }
        throw new IOException("unknown object encountered: " + hVarJ.getClass());
    }

    public int c() {
        return this.f29789d;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f29791f == null) {
            if (!this.f29788c) {
                return -1;
            }
            e eVarA = a();
            this.f29790e = eVarA;
            if (eVarA == null) {
                return -1;
            }
            this.f29788c = false;
            this.f29791f = eVarA.i();
        }
        while (true) {
            int i10 = this.f29791f.read();
            if (i10 >= 0) {
                return i10;
            }
            this.f29789d = this.f29790e.m();
            e eVarA2 = a();
            this.f29790e = eVarA2;
            if (eVarA2 == null) {
                this.f29791f = null;
                return -1;
            }
            this.f29791f = eVarA2.i();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        if (this.f29791f == null) {
            if (!this.f29788c) {
                return -1;
            }
            e eVarA = a();
            this.f29790e = eVarA;
            if (eVarA == null) {
                return -1;
            }
            this.f29788c = false;
            this.f29791f = eVarA.i();
        }
        while (true) {
            int i13 = this.f29791f.read(bArr, i10 + i12, i11 - i12);
            if (i13 >= 0) {
                i12 += i13;
                if (i12 == i11) {
                    return i12;
                }
            } else {
                this.f29789d = this.f29790e.m();
                e eVarA2 = a();
                this.f29790e = eVarA2;
                if (eVarA2 == null) {
                    this.f29791f = null;
                    if (i12 < 1) {
                        return -1;
                    }
                    return i12;
                }
                this.f29791f = eVarA2.i();
            }
        }
    }
}
