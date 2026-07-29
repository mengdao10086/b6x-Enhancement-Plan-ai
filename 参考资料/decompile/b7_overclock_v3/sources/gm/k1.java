package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class k1 implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f29726a;

    public k1(j0 j0Var) {
        this.f29726a = j0Var;
    }

    public static i1 c(j0 j0Var) throws IOException {
        return new i1(j0Var.k());
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
        return c(this.f29726a);
    }

    @Override // gm.g0
    public h readObject() throws IOException {
        return this.f29726a.j();
    }
}
