package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.net.SceneServer$ping$result$1", f = "SceneServer.kt", l = {71}, m = "invokeSuspend")
public final class mo0 extends d72 implements k82<wd2, b62<? super String>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ no0 f6828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1966a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1967a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1968a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f1969b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mo0(no0 no0Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f6828a = no0Var;
        this.f1968a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        mo0 mo0Var = new mo0(this.f6828a, this.f1968a, b62Var);
        mo0Var.f1966a = (wd2) obj;
        return mo0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super String> b62Var) {
        return ((mo0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        String strS = "";
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            this.f1967a = this.f1966a;
            this.f1969b = this;
            this.b = 1;
            uc2 uc2Var = new uc2(q62.b(this), 1);
            uc2Var.B();
            try {
                no0 no0Var = this.f6828a;
                StringBuilder sb = new StringBuilder();
                String strA = this.f1968a;
                if (strA == null) {
                    strA = no0.f6937a.a();
                }
                sb.append(strA);
                sb.append("/ping");
                strS = no0Var.s(sb.toString(), "");
            } catch (Exception unused) {
            }
            e42 e42Var = g42.f6169a;
            g42.a(strS);
            uc2Var.y(strS);
            obj = uc2Var.z();
            if (obj == r62.c()) {
                z62.c(this);
            }
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return obj;
    }
}
