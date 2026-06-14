package a;

import com.omarea.ui.BlurViewLinearLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gu1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f6245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1069a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gu1(b62 b62Var, kv1 kv1Var) {
        super(2, b62Var);
        this.f6245a = kv1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        gu1 gu1Var = new gu1(b62Var, this.f6245a);
        gu1Var.f1069a = (wd2) obj;
        return gu1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((gu1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) this.f6245a.w1(t61.extreme_performance);
        if (blurViewLinearLayout != null) {
            blurViewLinearLayout.setVisibility(new hn0().f() ? 0 : 8);
        }
        return m42.f6769a;
    }
}
