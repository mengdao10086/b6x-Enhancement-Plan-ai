package a;

import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.dialogs.DialogPaymentMethods$show$2$1$1$1", f = "DialogPaymentMethods.kt", l = {}, m = "invokeSuspend")
public final class ao1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bo1 f5626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f91a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f92a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao1(bo1 bo1Var, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f5626a = bo1Var;
        this.f91a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        ao1 ao1Var = new ao1(this.f5626a, this.f91a, b62Var);
        ao1Var.f92a = (wd2) obj;
        return ao1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((ao1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        this.f5626a.f5720a.f5813a.f5922a.f1572a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String) this.f91a.f6891a)));
        return m42.f6769a;
    }
}
