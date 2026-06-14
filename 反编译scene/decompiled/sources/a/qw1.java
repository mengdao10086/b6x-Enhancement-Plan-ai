package a;

import com.omarea.Scene;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentUser$refreshAnnouncement$1", f = "FragmentUser.kt", l = {334}, m = "invokeSuspend")
public final class qw1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f7246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2616a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f2617b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qw1(bx1 bx1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7246a = bx1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        qw1 qw1Var = new qw1(this.f7246a, b62Var);
        qw1Var.f2615a = (wd2) obj;
        return qw1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((qw1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        T string;
        Object objC = r62.c();
        int i = this.b;
        try {
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f2615a;
                n92 n92Var = new n92();
                String str = new mp0(Scene.f4798a.c()).A().get(3L, TimeUnit.SECONDS);
                if (str == null) {
                    string = 0;
                } else {
                    if (str == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    string = ec2.r0(str).toString();
                }
                n92Var.f6891a = string;
                String str2 = (String) string;
                if (!(str2 == null || str2.length() == 0) && !this.f7246a.R()) {
                    fg2 fg2VarC = qe2.c();
                    pw1 pw1Var = new pw1(this, n92Var, null);
                    this.f2616a = wd2Var;
                    this.f2617b = n92Var;
                    this.b = 1;
                    if (oc2.g(fg2VarC, pw1Var, this) == objC) {
                        return objC;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
        } catch (Exception unused) {
        }
        return m42.f6769a;
    }
}
