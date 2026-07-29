package so;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class c0 {

    public static class a extends d2 {
        public a(d2 d2Var) {
            super(d2Var);
        }

        @Override // so.d2
        public byte[] j() throws IOException {
            return this.f50145l.v(gm.j.f29714b);
        }
    }

    public static class b extends d2 {
        public b(d2 d2Var, zn.b bVar) {
            super(d2Var, B(d2Var.f50142i, bVar));
        }

        public static mm.v0 B(mm.v0 v0Var, zn.b bVar) {
            return new mm.v0(v0Var.C(), v0Var.y(), v0Var.x(), bVar, v0Var.A(), v0Var.D());
        }
    }

    public static d2 a(d2 d2Var) {
        return new a(d2Var);
    }

    public static d2 b(d2 d2Var, zn.b bVar) {
        return new b(d2Var, bVar);
    }
}
