package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ag2 extends yh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bg2 f5606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Object f66a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag2(zh2 zh2Var, zh2 zh2Var2, bg2 bg2Var, Object obj) {
        super(zh2Var2);
        this.f5606a = bg2Var;
        this.f66a = obj;
    }

    @Override // a.kh2
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Object g(zh2 zh2Var) {
        if (this.f5606a.a0() == this.f66a) {
            return null;
        }
        return xh2.a();
    }
}
