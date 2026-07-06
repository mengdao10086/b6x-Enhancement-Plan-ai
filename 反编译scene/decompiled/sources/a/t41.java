package a;

import android.content.pm.ComponentInfo;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t41 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q41 f7464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ u41 f2952a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2953a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ComponentInfo f2954a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2956a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f2957b;
    public final /* synthetic */ int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Object f2958c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t41(q41 q41Var, ComponentInfo componentInfo, String str, b62 b62Var, u41 u41Var, int i) {
        super(2, b62Var);
        this.f7464a = q41Var;
        this.f2954a = componentInfo;
        this.f2956a = str;
        this.f2952a = u41Var;
        this.c = i;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        t41 t41Var = new t41(this.f7464a, this.f2954a, this.f2956a, b62Var, this.f2952a, this.c);
        t41Var.f2953a = (wd2) obj;
        return t41Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((t41) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, android.widget.ImageView, java.lang.Object] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f2953a;
            n92 n92Var = new n92();
            n92Var.f6891a = this.f2954a.loadIcon(this.f2952a.f3136a);
            n92 n92Var2 = new n92();
            ?? C = this.f7464a.c();
            f92.b(C);
            n92Var2.f6891a = C;
            if (((Drawable) n92Var.f6891a) != null && f92.a(this.f7464a.b(), this.f2956a)) {
                fg2 fg2VarC = qe2.c();
                s41 s41Var = new s41(n92Var2, n92Var, null);
                this.f2955a = wd2Var;
                this.f2957b = n92Var;
                this.f2958c = n92Var2;
                this.b = 1;
                if (oc2.g(fg2VarC, s41Var, this) == objC) {
                    return objC;
                }
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
