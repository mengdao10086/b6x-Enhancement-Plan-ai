package a;

import com.omarea.vtools.activities.ActivityImg;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityImg$flashConfirm$1$1", f = "ActivityImg.kt", l = {203}, m = "invokeSuspend")
public final class mc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityImg.e f1922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1923a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1924b;
    public Object c;
    public Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mc1(ActivityImg.e eVar, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f1922a = eVar;
        this.f6793a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        mc1 mc1Var = new mc1(this.f1922a, this.f6793a, b62Var);
        mc1Var.f1921a = (wd2) obj;
        return mc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((mc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r5v9, types: [T, java.lang.String] */
    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f1921a;
            String strB = h60.f6280a.b(ActivityImg.this.getContext(), 2131820548);
            String str = strB + "\nflash_image '" + this.f1922a.f5331a + "' '" + this.f1922a.f8724a.e() + "'\necho $?";
            n92 n92Var = new n92();
            n92Var.f6891a = s60.f7366a.a(str);
            fg2 fg2VarC = qe2.c();
            lc1 lc1Var = new lc1(this, n92Var, null);
            this.f1923a = wd2Var;
            this.f1924b = strB;
            this.c = str;
            this.d = n92Var;
            this.b = 1;
            if (oc2.g(fg2VarC, lc1Var, this) == objC) {
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
