package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.common.net.Daemon$onMessageOutput$1", f = "Daemon.kt", l = {}, m = "invokeSuspend")
public final class b40 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f5672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ byte[] f214a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b40(String str, byte[] bArr, b62 b62Var) {
        super(2, b62Var);
        this.f213a = str;
        this.f214a = bArr;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        b40 b40Var = new b40(this.f213a, this.f214a, b62Var);
        b40Var.f5672a = (wd2) obj;
        return b40Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((b40) a(wd2Var, b62Var)).j(m42.f6769a);
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
            String str = this.f213a;
            byte[] bArr = this.f214a;
            f92.c(bArr, "result");
            l50Var.a(str, new String(bArr, bb2.f5692a));
        }
        return m42.f6769a;
    }
}
