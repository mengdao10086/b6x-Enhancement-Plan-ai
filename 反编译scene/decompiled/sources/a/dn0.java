package a;

import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.shell.SwapUtils$swappiness$2", f = "SwapUtils.kt", l = {494}, m = "invokeSuspend")
public final class dn0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fn0 f5919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f586a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f587a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn0(fn0 fn0Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f5919a = fn0Var;
        this.f587a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        dn0 dn0Var = new dn0(this.f5919a, this.f587a, b62Var);
        dn0Var.f585a = (wd2) obj;
        return dn0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((dn0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f585a;
            x60 x60Var = x60.f7856a;
            List listY = i52.Y(y42.c(j42.a(this.f5919a.i, "vm_swappiness=" + this.f587a), j42.a(this.f5919a.i, "kswapd_swappiness=" + this.f587a), j42.a(this.f5919a.i, "swapd_swappiness=" + this.f587a)));
            this.f586a = wd2Var;
            this.b = 1;
            if (x60.l(x60Var, listY, 0, this, 2, null) == objC) {
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
