package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vv1 extends g92 implements v72<nm1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f7729a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vv1(bx1 bx1Var) {
        super(0);
        this.f7729a = bx1Var;
    }

    @Override // a.v72
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final nm1 i() {
        cl clVarJ = this.f7729a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "this.activity!!");
        return new nm1(clVarJ, this.f7729a.f5742a, this.f7729a.S1());
    }
}
