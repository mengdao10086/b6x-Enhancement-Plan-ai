package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hi0 extends g92 implements g82<Integer, Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pz0 f6314a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hi0(pz0 pz0Var) {
        super(1);
        this.f6314a = pz0Var;
    }

    public final int a(int i) {
        double d = this.f6314a.c;
        return d != 0.0d ? (int) (((double) i) * d) : i;
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ Integer f(Integer num) {
        return Integer.valueOf(a(num.intValue()));
    }
}
