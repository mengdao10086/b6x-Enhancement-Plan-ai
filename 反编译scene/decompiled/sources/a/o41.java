package a;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o41 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l41 f6981a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p41 f2198a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2199a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityInfo f2200a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2201a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2202a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f2203b;
    public final /* synthetic */ int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Object f2204c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o41(l41 l41Var, ActivityInfo activityInfo, String str, b62 b62Var, p41 p41Var, int i) {
        super(2, b62Var);
        this.f6981a = l41Var;
        this.f2200a = activityInfo;
        this.f2202a = str;
        this.f2198a = p41Var;
        this.c = i;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        o41 o41Var = new o41(this.f6981a, this.f2200a, this.f2202a, b62Var, this.f2198a, this.c);
        o41Var.f2199a = (wd2) obj;
        return o41Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((o41) a(wd2Var, b62Var)).j(m42.f6769a);
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
            wd2 wd2Var = this.f2199a;
            n92 n92Var = new n92();
            n92Var.f6891a = this.f2200a.loadIcon(this.f2198a.f2388a);
            n92 n92Var2 = new n92();
            ?? C = this.f6981a.c();
            f92.b(C);
            n92Var2.f6891a = C;
            if (((Drawable) n92Var.f6891a) != null && f92.a(this.f6981a.b(), this.f2202a)) {
                fg2 fg2VarC = qe2.c();
                n41 n41Var = new n41(n92Var2, n92Var, null);
                this.f2201a = wd2Var;
                this.f2203b = n92Var;
                this.f2204c = n92Var2;
                this.b = 1;
                if (oc2.g(fg2VarC, n41Var, this) == objC) {
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
