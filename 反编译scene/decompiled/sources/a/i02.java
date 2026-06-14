package a;

import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatQuickPanel$setUpView$updateUI$1$2$1", f = "FloatQuickPanel.kt", l = {}, m = "invokeSuspend")
public final class i02 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j02 f6363a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f1301a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1302a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i02(j02 j02Var, String str, b62 b62Var) {
        super(2, b62Var);
        this.f6363a = j02Var;
        this.f1302a = str;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        i02 i02Var = new i02(this.f6363a, this.f1302a, b62Var);
        i02Var.f1301a = (wd2) obj;
        return i02Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((i02) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        float f;
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        for (TextView textView : this.f6363a.f6460a.f1594a) {
            if (textView == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            }
            CharSequence text = textView.getText();
            f92.b(text);
            if (f92.a(text.toString(), this.f1302a)) {
                f = 1.0f;
            } else if (textView.getAlpha() != 0.0f) {
                f = 0.25f;
            }
            textView.setAlpha(f);
        }
        return m42.f6769a;
    }
}
