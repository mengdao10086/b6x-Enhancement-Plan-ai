package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class i31 extends g92 implements v72<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q31 f6372a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i31(q31 q31Var) {
        super(0);
        this.f6372a = q31Var;
    }

    public final int a() {
        return this.f6372a.getResources().getColor(2131099701);
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ Integer i() {
        return Integer.valueOf(a());
    }
}
