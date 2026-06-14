package a;

import com.omarea.Scene;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentUser$accountInfo$1", f = "FragmentUser.kt", l = {385}, m = "invokeSuspend")
public final class ov1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f7059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2306a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2307a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2308a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f2309b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ov1(bx1 bx1Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f7059a = bx1Var;
        this.f2308a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ov1 ov1Var = new ov1(this.f7059a, this.f2308a, b62Var);
        ov1Var.f2306a = (wd2) obj;
        return ov1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ov1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, com.omarea.model.AccountPointsResponse] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f2306a;
            n92 n92Var = new n92();
            n92Var.f6891a = new mp0(Scene.f4798a.c()).z(this.f2308a, "").get(10L, TimeUnit.SECONDS);
            fg2 fg2VarC = qe2.c();
            nv1 nv1Var = new nv1(this, n92Var, null);
            this.f2307a = wd2Var;
            this.f2309b = n92Var;
            this.b = 1;
            if (oc2.g(fg2VarC, nv1Var, this) == objC) {
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
