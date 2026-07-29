package gm;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class v0 {
    public static w A(n0 n0Var, int i10) {
        return y(n0Var, 128, i10);
    }

    public static n0 B(n0 n0Var, int i10) {
        return z(n0Var, 128, i10);
    }

    public static n0 C(n0 n0Var, int i10, int i11, int i12, int i13) {
        if (n0Var.e(i10, i11)) {
            return n0Var.R(i12, i13);
        }
        return null;
    }

    public static n0 D(n0 n0Var, int i10, int i11, int i12) {
        return C(n0Var, 128, i10, i11, i12);
    }

    public static h E(o0 o0Var, int i10, int i11, boolean z10, int i12) throws IOException {
        if (o0Var.e(i10, i11)) {
            return o0Var.p(z10, i12);
        }
        return null;
    }

    public static h F(o0 o0Var, int i10, boolean z10, int i11) throws IOException {
        return E(o0Var, 128, i10, z10, i11);
    }

    public static h G(o0 o0Var, int i10, int i11) throws IOException {
        if (o0Var.e(i10, i11)) {
            return o0Var.g();
        }
        return null;
    }

    public static o0 H(o0 o0Var, int i10, int i11) throws IOException {
        if (o0Var.e(i10, i11)) {
            return o0Var.j();
        }
        return null;
    }

    public static h I(o0 o0Var, int i10) throws IOException {
        return G(o0Var, 128, i10);
    }

    public static o0 J(o0 o0Var, int i10) throws IOException {
        return H(o0Var, 128, i10);
    }

    public static o0 K(o0 o0Var, int i10, int i11, int i12, int i13) throws IOException {
        if (o0Var.e(i10, i11)) {
            return o0Var.f(i12, i13);
        }
        return null;
    }

    public static o0 L(o0 o0Var, int i10, int i11, int i12) throws IOException {
        return K(o0Var, 128, i10, i11, i12);
    }

    public static n0 a(n0 n0Var, int i10, int i11) {
        if (n0Var.e(i10, i11)) {
            return n0Var;
        }
        throw new IllegalStateException("Expected " + k(i10, i11) + " tag but found " + m(n0Var));
    }

    public static o0 b(o0 o0Var, int i10, int i11) {
        if (o0Var.e(i10, i11)) {
            return o0Var;
        }
        throw new IllegalStateException("Expected " + k(i10, i11) + " tag but found " + n(o0Var));
    }

    public static c0 c(n0 n0Var, int i10, int i11, boolean z10, int i12) {
        return a(n0Var, i10, i11).M(z10, i12);
    }

    public static c0 d(n0 n0Var, int i10, boolean z10, int i11) {
        return c(n0Var, 128, i10, z10, i11);
    }

    public static w e(n0 n0Var, int i10, int i11) {
        return a(n0Var, i10, i11).P();
    }

    public static n0 f(n0 n0Var, int i10, int i11) {
        return a(n0Var, i10, i11).Q();
    }

    public static w g(n0 n0Var, int i10) {
        return e(n0Var, 128, i10);
    }

    public static n0 h(n0 n0Var, int i10) {
        return f(n0Var, 128, i10);
    }

    public static n0 i(n0 n0Var, int i10, int i11, int i12, int i13) {
        return a(n0Var, i10, i11).R(i12, i13);
    }

    public static n0 j(n0 n0Var, int i10, int i11, int i12) {
        return i(n0Var, 128, i10, i11, i12);
    }

    public static String k(int i10, int i11) {
        StringBuilder sb2;
        String str;
        if (i10 == 64) {
            sb2 = new StringBuilder();
            str = "[APPLICATION ";
        } else if (i10 == 128) {
            sb2 = new StringBuilder();
            str = "[CONTEXT ";
        } else if (i10 != 192) {
            sb2 = new StringBuilder();
            str = "[UNIVERSAL ";
        } else {
            sb2 = new StringBuilder();
            str = "[PRIVATE ";
        }
        sb2.append(str);
        sb2.append(i11);
        sb2.append("]");
        return sb2.toString();
    }

    public static String l(m0 m0Var) {
        return k(m0Var.b(), m0Var.c());
    }

    public static String m(n0 n0Var) {
        return k(n0Var.r(), n0Var.q());
    }

    public static String n(o0 o0Var) {
        return k(o0Var.r(), o0Var.q());
    }

    public static h o(o0 o0Var, int i10, int i11, boolean z10, int i12) throws IOException {
        return b(o0Var, i10, i11).p(z10, i12);
    }

    public static h p(o0 o0Var, int i10, boolean z10, int i11) throws IOException {
        return o(o0Var, 128, i10, z10, i11);
    }

    public static h q(o0 o0Var, int i10, int i11) throws IOException {
        return b(o0Var, i10, i11).g();
    }

    public static o0 r(o0 o0Var, int i10, int i11) throws IOException {
        return b(o0Var, i10, i11).j();
    }

    public static h s(o0 o0Var, int i10) throws IOException {
        return q(o0Var, 128, i10);
    }

    public static o0 t(o0 o0Var, int i10) throws IOException {
        return r(o0Var, 128, i10);
    }

    public static o0 u(o0 o0Var, int i10, int i11, int i12, int i13) throws IOException {
        return b(o0Var, i10, i11).f(i12, i13);
    }

    public static o0 v(o0 o0Var, int i10, int i11, int i12) throws IOException {
        return u(o0Var, 128, i10, i11, i12);
    }

    public static c0 w(n0 n0Var, int i10, int i11, boolean z10, int i12) {
        if (n0Var.e(i10, i11)) {
            return n0Var.M(z10, i12);
        }
        return null;
    }

    public static c0 x(n0 n0Var, int i10, boolean z10, int i11) {
        return w(n0Var, 128, i10, z10, i11);
    }

    public static w y(n0 n0Var, int i10, int i11) {
        if (n0Var.e(i10, i11)) {
            return n0Var.P();
        }
        return null;
    }

    public static n0 z(n0 n0Var, int i10, int i11) {
        if (n0Var.e(i10, i11)) {
            return n0Var.Q();
        }
        return null;
    }
}
