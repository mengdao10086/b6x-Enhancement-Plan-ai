package a;

import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.FormValueHandler$bindInput$1$1", f = "FormValueHandler.kt", l = {}, m = "invokeSuspend")
public final class sh0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l92 f7398a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f2894a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ wh0 f2895a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sh0(wh0 wh0Var, l92 l92Var, b62 b62Var) {
        super(2, b62Var);
        this.f2895a = wh0Var;
        this.f7398a = l92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        sh0 sh0Var = new sh0(this.f2895a, this.f7398a, b62Var);
        sh0Var.f2894a = (wd2) obj;
        return sh0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((sh0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        TextView textView = this.f2895a.f3442a;
        if (textView != null) {
            textView.setText(String.valueOf(this.f7398a.f6687a));
        }
        wh0 wh0Var = this.f2895a;
        SeekBar seekBar = wh0Var.f3441a;
        double d = wh0Var.f7789a.c;
        seekBar.setProgress(d != 0.0d ? (int) (((double) this.f7398a.f6687a) / d) : this.f7398a.f6687a);
        return m42.f6769a;
    }
}
