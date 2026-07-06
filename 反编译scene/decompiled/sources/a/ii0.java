package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ii0 extends g92 implements g82<Integer, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pz0 f6416a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii0(pz0 pz0Var) {
        super(1);
        this.f6416a = pz0Var;
    }

    public final String a(int i) {
        double d = this.f6416a.c;
        if (d != 0.0d) {
            i = (int) (((double) i) * d);
        }
        return String.valueOf(i);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ String f(Integer num) {
        return a(num.intValue());
    }
}
