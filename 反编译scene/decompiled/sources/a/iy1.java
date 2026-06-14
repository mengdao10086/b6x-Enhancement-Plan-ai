package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.popup.FloatMonitorFPS$startTimer$2", f = "FloatMonitorFPS.kt", l = {446}, m = "invokeSuspend")
public final class iy1 extends d72 implements g82<b62<? super m42>, Object> {
    public int b;

    public iy1(b62 b62Var) {
        super(1, b62Var);
    }

    @Override // a.g82
    public final Object f(b62<? super m42> b62Var) {
        return ((iy1) n(b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            e50 e50Var = e50.f677a;
            boolean zB = Scene.f4798a.b(hz0.f1282a.O(), false);
            this.b = 1;
            if (e50Var.Y0(zB, this) == objC) {
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

    public final b62<m42> n(b62<?> b62Var) {
        f92.d(b62Var, "completion");
        return new iy1(b62Var);
    }
}
