package gm;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1ParsingException;

/* JADX INFO: loaded from: classes5.dex */
public class b1 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f29641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q1 f29642b;

    public b1(j0 j0Var) {
        this.f29641a = j0Var;
    }

    public static a1 c(j0 j0Var) throws IOException {
        q1 q1Var = new q1(j0Var, false);
        return new a1(kt.c.e(q1Var), q1Var.c());
    }

    @Override // gm.e
    public InputStream a() throws IOException {
        q1 q1Var = new q1(this.f29641a, true);
        this.f29642b = q1Var;
        return q1Var;
    }

    @Override // gm.h
    public c0 b() {
        try {
            return o();
        } catch (IOException e10) {
            throw new ASN1ParsingException("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }

    @Override // gm.e
    public InputStream i() throws IOException {
        q1 q1Var = new q1(this.f29641a, false);
        this.f29642b = q1Var;
        return q1Var;
    }

    @Override // gm.e
    public int m() {
        return this.f29642b.c();
    }

    @Override // gm.h3
    public c0 o() throws IOException {
        return c(this.f29641a);
    }
}
