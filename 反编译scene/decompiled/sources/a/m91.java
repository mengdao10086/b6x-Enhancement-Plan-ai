package a;

import com.omarea.vtools.activities.ActivityChargeControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityChargeControl$onViewCreated$7$setValue$1", f = "ActivityChargeControl.kt", l = {}, m = "invokeSuspend")
public final class m91 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f6784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityChargeControl.q f1907a;
    public int b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m91(ActivityChargeControl.q qVar, int i, b62 b62Var) {
        super(2, b62Var);
        this.f1907a = qVar;
        this.c = i;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        m91 m91Var = new m91(this.f1907a, this.c, b62Var);
        m91Var.f6784a = (wd2) obj;
        return m91Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((m91) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        hl0.A(ActivityChargeControl.this.f8575a, this.c, false, 2, null);
        return m42.f6769a;
    }
}
