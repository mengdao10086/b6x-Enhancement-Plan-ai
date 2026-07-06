package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class yh2 extends kh2<zh2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zh2 f7985a;
    public final zh2 b;

    public yh2(zh2 zh2Var) {
        this.b = zh2Var;
    }

    @Override // a.kh2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(zh2 zh2Var, Object obj) {
        boolean z = obj == null;
        zh2 zh2Var2 = z ? this.b : this.f7985a;
        if (zh2Var2 != null && zh2.f8073a.compareAndSet(zh2Var, this, zh2Var2) && z) {
            zh2 zh2Var3 = this.b;
            zh2 zh2Var4 = this.f7985a;
            f92.b(zh2Var4);
            zh2Var3.m(zh2Var4);
        }
    }
}
