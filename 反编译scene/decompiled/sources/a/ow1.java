package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ow1 extends g92 implements v72<u90> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f7062a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ow1(bx1 bx1Var) {
        super(0);
        this.f7062a = bx1Var;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final u90 i() {
        cl clVarJ = this.f7062a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        return new u90(clVarJ, null, 2, null);
    }
}
