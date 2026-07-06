package a;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.AppInfoLoader$loadIconAsync$1", f = "AppInfoLoader.kt", l = {}, m = "invokeSuspend")
public final class hh0 extends d72 implements k82<wd2, b62<? super Drawable>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih0 f6313a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1171a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hh0(ih0 ih0Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f6313a = ih0Var;
        this.f1171a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        hh0 hh0Var = new hh0(this.f6313a, this.f1171a, b62Var);
        hh0Var.f1170a = (wd2) obj;
        return hh0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super Drawable> b62Var) {
        return ((hh0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        return this.f6313a.k(this.f1171a);
    }
}
