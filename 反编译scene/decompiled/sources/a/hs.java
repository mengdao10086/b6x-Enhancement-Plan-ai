package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class hs extends bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public is f6337a;

    public hs(is isVar) {
        this.f6337a = isVar;
    }

    @Override // a.bs, a.zr
    public void c(as asVar) {
        is isVar = this.f6337a;
        if (isVar.f) {
            return;
        }
        isVar.a0();
        this.f6337a.f = true;
    }

    @Override // a.zr
    public void e(as asVar) {
        is isVar = this.f6337a;
        int i = isVar.b - 1;
        isVar.b = i;
        if (i == 0) {
            isVar.f = false;
            isVar.p();
        }
        asVar.P(this);
    }
}
