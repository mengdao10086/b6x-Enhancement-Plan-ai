package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public enum zd2 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public final <R, T> void a(k82<? super R, ? super b62<? super T>, ? extends Object> k82Var, R r, b62<? super T> b62Var) {
        int i = yd2.b[ordinal()];
        if (i == 1) {
            xi2.b(k82Var, r, b62Var);
            return;
        }
        if (i == 2) {
            f62.a(k82Var, r, b62Var);
        } else if (i == 3) {
            yi2.a(k82Var, r, b62Var);
        } else if (i != 4) {
            throw new b42();
        }
    }

    public final boolean b() {
        return this == LAZY;
    }
}
