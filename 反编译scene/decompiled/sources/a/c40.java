package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$onMessageOutput$2", f = "Daemon.kt", l = {}, m = "invokeSuspend")
public final class c40 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f349a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c40(String str, b62 b62Var) {
        super(2, b62Var);
        this.f349a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        c40 c40Var = new c40(this.f349a, b62Var);
        c40Var.f5758a = (wd2) obj;
        return c40Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((c40) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        e50 e50Var = e50.f677a;
        l50 l50Var = e50.f679a;
        if (l50Var != null) {
            l50Var.c(this.f349a);
        }
        return m42.f6769a;
    }
}
