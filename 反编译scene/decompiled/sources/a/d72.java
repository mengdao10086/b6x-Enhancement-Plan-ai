package a;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class d72 extends v62 implements c92<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5869a;

    public d72(int i, b62<Object> b62Var) {
        super(b62Var);
        this.f5869a = i;
    }

    @Override // a.c92
    public int h() {
        return this.f5869a;
    }

    @Override // a.s62
    public String toString() {
        if (b() != null) {
            return super.toString();
        }
        String strD = o92.d(this);
        f92.c(strD, "Reflection.renderLambdaToString(this)");
        return strD;
    }
}
