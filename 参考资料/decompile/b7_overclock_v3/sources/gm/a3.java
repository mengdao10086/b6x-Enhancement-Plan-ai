package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class a3 implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f29639a;

    public a3(j0 j0Var) {
        this.f29639a = j0Var;
    }

    @Override // gm.h
    public c0 b() {
        try {
            return o();
        } catch (IOException e10) {
            throw new IllegalStateException(e10.getMessage());
        }
    }

    @Override // gm.h3
    public c0 o() throws IOException {
        return x2.a(this.f29639a.k());
    }

    @Override // gm.g0
    public h readObject() throws IOException {
        return this.f29639a.j();
    }
}
