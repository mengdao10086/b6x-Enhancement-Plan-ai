package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i92 f7584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ vc1 f3165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3166a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uc1(vc1 vc1Var, i92 i92Var, b62 b62Var) {
        super(2, b62Var);
        this.f3165a = vc1Var;
        this.f7584a = i92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        uc1 uc1Var = new uc1(this.f3165a, this.f7584a, b62Var);
        uc1Var.f3166a = (wd2) obj;
        return uc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((uc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        if (!this.f7584a.b) {
            Scene.c.p(Scene.f4798a, ">_<!", 0, 2, null);
        } else if (!this.f3165a.f7679a.f7775a.f3571a.isDestroyed()) {
            this.f3165a.f7679a.f7775a.f3571a.setResult(-1);
            this.f3165a.f7679a.f7775a.f3571a.finishAfterTransition();
        }
        return m42.f6769a;
    }
}
