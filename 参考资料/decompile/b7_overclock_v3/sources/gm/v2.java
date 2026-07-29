package gm;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class v2 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g3 f29814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29815b = 0;

    public v2(g3 g3Var) {
        this.f29814a = g3Var;
    }

    @Override // gm.e
    public InputStream a() throws IOException {
        return c(true);
    }

    @Override // gm.h
    public c0 b() {
        try {
            return o();
        } catch (IOException e10) {
            throw new ASN1ParsingException("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }

    public final InputStream c(boolean z10) throws IOException {
        int iD = this.f29814a.d();
        if (iD < 1) {
            throw new IllegalStateException("content octets cannot be empty");
        }
        int i10 = this.f29814a.read();
        this.f29815b = i10;
        if (i10 > 0) {
            if (iD < 2) {
                throw new IllegalStateException("zero length data with non-zero pad bits");
            }
            if (i10 > 7) {
                throw new IllegalStateException("pad bits cannot be greater than 7 or less than 0");
            }
            if (z10) {
                throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.f29815b);
            }
        }
        return this.f29814a;
    }

    @Override // gm.e
    public InputStream i() throws IOException {
        return c(false);
    }

    @Override // gm.e
    public int m() {
        return this.f29815b;
    }

    @Override // gm.h3
    public c0 o() throws IOException {
        return d.G(this.f29814a.h());
    }
}
