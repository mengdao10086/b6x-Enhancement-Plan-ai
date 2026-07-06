package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentPerf$chooseConfigSource$2$2", f = "FragmentPerf.kt", l = {434}, m = "invokeSuspend")
public final class tt1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3060a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3061b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tt1(View view, b62 b62Var) {
        super(2, b62Var);
        this.f3059a = view;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        tt1 tt1Var = new tt1(this.f3059a, b62Var);
        tt1Var.f7532a = (wd2) obj;
        return tt1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((tt1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [T, a.kl0] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7532a;
            n92 n92Var = new n92();
            n92Var.f6891a = new kl0();
            n92 n92Var2 = new n92();
            n92Var2.f6891a = ((kl0) n92Var.f6891a).v("");
            od2 od2VarB = qe2.b();
            st1 st1Var = new st1(this, n92Var2, n92Var, null);
            this.f3060a = wd2Var;
            this.f3061b = n92Var;
            this.c = n92Var2;
            this.b = 1;
            if (oc2.g(od2VarB, st1Var, this) == objC) {
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
