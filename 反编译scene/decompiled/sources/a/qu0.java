package a;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.scene_mode.LogoCacheManager$saveAppInfo$1", f = "LogoCacheManager.kt", l = {86}, m = "invokeSuspend")
public final class qu0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ru0 f7240a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2609a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f2610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2611a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qu0(ru0 ru0Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f7240a = ru0Var;
        this.f2611a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        qu0 qu0Var = new qu0(this.f7240a, this.f2611a, b62Var);
        qu0Var.f2609a = (wd2) obj;
        return qu0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((qu0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        SharedPreferences.Editor editorPutString;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f2609a;
            fe2<eh0> fe2VarI = new ih0(this.f7240a.f2786a, 0, 0, 6, null).i(this.f2611a);
            this.f2610a = wd2Var;
            this.b = 1;
            obj = fe2VarI.s(this);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        eh0 eh0Var = (eh0) obj;
        if (eh0Var.b() != null) {
            ru0 ru0Var = this.f7240a;
            Drawable drawableB = eh0Var.b();
            f92.b(drawableB);
            ru0Var.k(drawableB, this.f2611a);
            editorPutString = this.f7240a.f2787a.edit().putString(this.f2611a, eh0Var.a());
        } else {
            ru0 ru0Var2 = this.f7240a;
            Drawable drawableD = yb.d(ru0Var2.f2786a, 2131231120);
            f92.b(drawableD);
            f92.c(drawableD, "ContextCompat.getDrawabl…awable.process_android)!!");
            ru0Var2.k(drawableD, this.f2611a);
            SharedPreferences.Editor editorEdit = this.f7240a.f2787a.edit();
            String str = this.f2611a;
            editorPutString = editorEdit.putString(str, str);
        }
        editorPutString.apply();
        return m42.f6769a;
    }
}
