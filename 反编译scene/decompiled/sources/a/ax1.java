package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentUser$unbindDevice$1", f = "FragmentUser.kt", l = {438}, m = "invokeSuspend")
public final class ax1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f5651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f158a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f159b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax1(bx1 bx1Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f5651a = bx1Var;
        this.f158a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ax1 ax1Var = new ax1(this.f5651a, this.f158a, b62Var);
        ax1Var.f156a = (wd2) obj;
        return ax1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ax1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, com.omarea.model.LoginResponse] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f156a;
            n92 n92Var = new n92();
            n92Var.f6891a = new mp0(Scene.f4798a.c()).J(this.f158a);
            fg2 fg2VarC = qe2.c();
            zw1 zw1Var = new zw1(this, n92Var, null);
            this.f157a = wd2Var;
            this.f159b = n92Var;
            this.b = 1;
            if (oc2.g(fg2VarC, zw1Var, this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return m42.f6769a;
    }
}
