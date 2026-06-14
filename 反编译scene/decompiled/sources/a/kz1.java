package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kz1 extends g92 implements v72<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l02 f6657a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kz1(l02 l02Var) {
        super(0);
        this.f6657a = l02Var;
    }

    public final boolean a() {
        return hz0.f1282a.b0() && (hz0.f1282a.B() || this.f6657a.p());
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ Boolean i() {
        return Boolean.valueOf(a());
    }
}
