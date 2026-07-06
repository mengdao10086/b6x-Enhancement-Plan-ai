package a;

import android.content.Context;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentHome$forceKSWAPD$2", f = "FragmentHome.kt", l = {}, m = "invokeSuspend")
public final class tr1 extends d72 implements k82<wd2, b62<? super String>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zs1 f3057a;
    public int b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tr1(zs1 zs1Var, int i, b62 b62Var) {
        super(2, b62Var);
        this.f3057a = zs1Var;
        this.c = i;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        tr1 tr1Var = new tr1(this.f3057a, this.c, b62Var);
        tr1Var.f7527a = (wd2) obj;
        return tr1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super String> b62Var) {
        return ((tr1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        Context contextP = this.f3057a.p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        return j60.d(new b70(contextP), this.f3057a.P1().d(this.c), false, 2, null);
    }
}
