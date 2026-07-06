package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatQuicklyGrant$show$1", f = "FloatQuicklyGrant.kt", l = {67, 69}, m = "invokeSuspend")
public final class c12 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe2 f5750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ h12 f317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f320a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f321b;
    public Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c12(h12 h12Var, fe2 fe2Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f317a = h12Var;
        this.f5750a = fe2Var;
        this.f320a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        c12 c12Var = new c12(this.f317a, this.f5750a, this.f320a, b62Var);
        c12Var.f318a = (wd2) obj;
        return c12Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((c12) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v4, types: [T, a.eh0] */
    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        n92 n92Var;
        n92 n92Var2;
        T t;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f318a;
            n92Var = new n92();
            fe2 fe2Var = this.f5750a;
            this.f319a = wd2Var;
            this.f321b = n92Var;
            this.c = n92Var;
            this.b = 1;
            obj = fe2Var.s(this);
            if (obj == objC) {
                return objC;
            }
            n92Var2 = n92Var;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            n92Var = (n92) this.c;
            n92Var2 = (n92) this.f321b;
            wd2Var = (wd2) this.f319a;
            h42.b(obj);
        }
        n92Var.f6891a = (eh0) obj;
        n92 n92Var3 = new n92();
        if (ec2.C(this.f320a, ".", false, 2, null)) {
            String str = this.f320a;
            int iS = ec2.S(str, ".", 0, false, 6, null);
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str.substring(iS);
            f92.c(strSubstring, "(this as java.lang.String).substring(startIndex)");
            t = strSubstring;
        } else {
            t = this.f320a;
        }
        n92Var3.f6891a = t;
        fg2 fg2VarC = qe2.c();
        b12 b12Var = new b12(this, n92Var2, n92Var3, null);
        this.f319a = wd2Var;
        this.f321b = n92Var2;
        this.c = n92Var3;
        this.b = 2;
        if (oc2.g(fg2VarC, b12Var, this) == objC) {
            return objC;
        }
        return m42.f6769a;
    }
}
