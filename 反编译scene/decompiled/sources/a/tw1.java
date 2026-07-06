package a;

import com.omarea.Scene;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentUser$refreshLoginState$1", f = "FragmentUser.kt", l = {356, 367}, m = "invokeSuspend")
public final class tw1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f7541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f3084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3085a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3086a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3087a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3088b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tw1(bx1 bx1Var, String str, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f7541a = bx1Var;
        this.f3087a = str;
        this.f3084a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        tw1 tw1Var = new tw1(this.f7541a, this.f3087a, this.f3084a, b62Var);
        tw1Var.f3085a = (wd2) obj;
        return tw1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((tw1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, com.omarea.model.AccountPointsResponse] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        Object obj2 = this.b;
        try {
        } catch (Exception e) {
            fg2 fg2VarC = qe2.c();
            sw1 sw1Var = new sw1(this, null);
            this.f3086a = obj2;
            this.f3088b = e;
            this.b = 2;
            if (oc2.g(fg2VarC, sw1Var, this) == objC) {
                return objC;
            }
        }
        if (obj2 == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f3085a;
            n92 n92Var = new n92();
            n92Var.f6891a = new mp0(Scene.f4798a.c()).z(this.f3087a, "").get(10L, TimeUnit.SECONDS);
            fg2 fg2VarC2 = qe2.c();
            rw1 rw1Var = new rw1(this, n92Var, null);
            this.f3086a = wd2Var;
            this.f3088b = n92Var;
            this.b = 1;
            obj2 = wd2Var;
            if (oc2.g(fg2VarC2, rw1Var, this) == objC) {
                return objC;
            }
        } else {
            if (obj2 != 1) {
                if (obj2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            wd2 wd2Var2 = (wd2) this.f3086a;
            h42.b(obj);
            obj2 = wd2Var2;
        }
        return m42.f6769a;
    }
}
