package a;

import android.widget.SeekBar;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.library.basic.FormValueHandler$bindInput$1", f = "FormValueHandler.kt", l = {81}, m = "invokeSuspend")
public final class wh0 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pz0 f7789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f3439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SeekBar f3441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3443a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3444b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wh0(rh0 rh0Var, TextView textView, SeekBar seekBar, pz0 pz0Var, b62 b62Var) {
        super(2, b62Var);
        this.f3439a = rh0Var;
        this.f3442a = textView;
        this.f3441a = seekBar;
        this.f7789a = pz0Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        wh0 wh0Var = new wh0(this.f3439a, this.f3442a, this.f3441a, this.f7789a, b62Var);
        wh0Var.f3440a = (wd2) obj;
        return wh0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((wh0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        try {
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f3440a;
                l92 l92Var = new l92();
                l92Var.f6687a = ((Number) this.f3439a.getValue()).intValue();
                fg2 fg2VarC = qe2.c();
                sh0 sh0Var = new sh0(this, l92Var, null);
                this.f3443a = wd2Var;
                this.f3444b = l92Var;
                this.b = 1;
                if (oc2.g(fg2VarC, sh0Var, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
        } catch (Exception unused) {
        }
        return m42.f6769a;
    }
}
