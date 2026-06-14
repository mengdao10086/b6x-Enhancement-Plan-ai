package a;

import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class s62 implements b62<Object>, w62, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b62<Object> f7367a;

    public s62(b62<Object> b62Var) {
        this.f7367a = b62Var;
    }

    public b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public final b62<Object> b() {
        return this.f7367a;
    }

    public abstract Object j(Object obj);

    public void k() {
    }

    @Override // a.w62
    public StackTraceElement p() {
        return y62.d(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object objP = p();
        if (objP == null) {
            objP = getClass().getName();
        }
        sb.append(objP);
        return sb.toString();
    }

    @Override // a.w62
    public w62 v() {
        b62<Object> b62Var = this.f7367a;
        if (!(b62Var instanceof w62)) {
            b62Var = null;
        }
        return (w62) b62Var;
    }

    @Override // a.b62
    public final void y(Object obj) {
        s62 s62Var = this;
        while (true) {
            z62.b(s62Var);
            b62<Object> b62Var = s62Var.f7367a;
            f92.b(b62Var);
            try {
                obj = s62Var.j(obj);
            } catch (Throwable th) {
                e42 e42Var = g42.f6169a;
                obj = h42.a(th);
                g42.a(obj);
            }
            if (obj == r62.c()) {
                return;
            }
            e42 e42Var2 = g42.f6169a;
            g42.a(obj);
            s62Var.k();
            if (!(b62Var instanceof s62)) {
                b62Var.y(obj);
                return;
            }
            s62Var = (s62) b62Var;
        }
    }
}
