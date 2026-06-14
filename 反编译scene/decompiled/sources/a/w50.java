package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.shared.ActivityHelper$startActivity$1", f = "ActivityHelper.kt", l = {30}, m = "invokeSuspend")
public final class w50 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3395a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3396a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ String f3397b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w50(String str, String str2, b62 b62Var) {
        super(2, b62Var);
        this.f3396a = str;
        this.f3397b = str2;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        w50 w50Var = new w50(this.f3396a, this.f3397b, b62Var);
        w50Var.f7758a = (wd2) obj;
        return w50Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((w50) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7758a;
            e50 e50Var = e50.f677a;
            String str = "am start -n " + this.f3396a + '/' + this.f3397b + " -f 0x10200000";
            this.f3395a = wd2Var;
            this.b = 1;
            if (e50Var.X(str, this) == objC) {
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
