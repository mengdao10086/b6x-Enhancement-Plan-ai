package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vy1 extends g92 implements v72<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ az1 f7735a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vy1(az1 az1Var) {
        super(0);
        this.f7735a = az1Var;
    }

    public final int a() {
        return !this.f7735a.r() ? 1 : 0;
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ Integer i() {
        return Integer.valueOf(a());
    }
}
