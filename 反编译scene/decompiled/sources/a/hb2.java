package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hb2 extends g92 implements g82<Integer, eb2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ib2 f6299a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb2(ib2 ib2Var) {
        super(1);
        this.f6299a = ib2Var;
    }

    public final eb2 a(int i) {
        return this.f6299a.c(i);
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ eb2 f(Integer num) {
        return a(num.intValue());
    }
}
