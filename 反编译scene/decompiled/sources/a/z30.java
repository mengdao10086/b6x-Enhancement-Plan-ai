package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$onConnected$1", f = "Daemon.kt", l = {1159, 1167}, m = "invokeSuspend")
public final class z30 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f8032a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3790a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3791b;

    public z30(b62 b62Var) {
        super(2, b62Var);
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        z30 z30Var = new z30(b62Var);
        z30Var.f8032a = (wd2) obj;
        return z30Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((z30) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws InterruptedException {
        wd2 wd2Var;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f8032a;
            e50 e50Var = e50.f677a;
            this.f3790a = wd2Var;
            this.b = 1;
            obj = e50Var.y1(this);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                e50.f677a.u1(e50.f692d);
                e50.f677a.U0(t62.a(e50.f690c));
                return m42.f6769a;
            }
            wd2Var = (wd2) this.f3790a;
            h42.b(obj);
        }
        String str = (String) obj;
        if ((str.length() > 0) && (!f92.a(str, "error"))) {
            e50 e50Var2 = e50.f677a;
            if (!f92.a(e50.f693e, str)) {
                e50 e50Var3 = e50.f677a;
                e50.f693e = str;
            }
        }
        e50 e50Var4 = e50.f677a;
        if (e50.f689c.length() > 0) {
            e50.f677a.Q(e50.f689c);
        }
        this.f3790a = wd2Var;
        this.f3791b = str;
        this.b = 2;
        if (ke2.a(500L, this) == objC) {
            return objC;
        }
        e50.f677a.u1(e50.f692d);
        e50.f677a.U0(t62.a(e50.f690c));
        return m42.f6769a;
    }
}
