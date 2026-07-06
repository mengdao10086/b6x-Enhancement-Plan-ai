package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n02 extends g92 implements v72<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a12 f6859a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n02(a12 a12Var) {
        super(0);
        this.f6859a = a12Var;
    }

    public final boolean a() {
        return new zg0().a(this.f6859a.b);
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ Boolean i() {
        return Boolean.valueOf(a());
    }
}
