package a;

import com.omarea.vtools.activities.ActivityImg;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityImg$exportConfirm$1$1", f = "ActivityImg.kt", l = {226}, m = "invokeSuspend")
public final class kc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6592a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityImg.d f1613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1614a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1615b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kc1(ActivityImg.d dVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f1613a = dVar;
        this.f6592a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        kc1 kc1Var = new kc1(this.f1613a, this.f6592a, b62Var);
        kc1Var.f1612a = (wd2) obj;
        return kc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((kc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.String] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1612a;
            n92 n92Var = new n92();
            n92Var.f6891a = s60.f7366a.a("dd if='" + this.f1613a.f8723a.e() + "' of='/sdcard/" + this.f1613a.f8723a.d() + ".img'\necho $?");
            fg2 fg2VarC = qe2.c();
            jc1 jc1Var = new jc1(this, n92Var, null);
            this.f1614a = wd2Var;
            this.f1615b = n92Var;
            this.b = 1;
            if (oc2.g(fg2VarC, jc1Var, this) == objC) {
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
