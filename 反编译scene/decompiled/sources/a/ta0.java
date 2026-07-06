package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ta0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aa0 f7482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ua0 f3008a;

    public ta0(ua0 ua0Var, aa0 aa0Var) {
        this.f3008a = ua0Var;
        this.f7482a = aa0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        aa0 aa0Var = this.f7482a;
        if (aa0Var == aa0.SCREEN_OFF) {
            this.f3008a.f3162a[0] = f92.a(az1.f5657a.a(), Boolean.TRUE);
            this.f3008a.f3162a[1] = u12.f3107a.b();
            this.f3008a.f3162a[2] = iz1.f6457a.b();
            this.f3008a.f3162a[3] = f92.a(py1.f7160a.a(), Boolean.TRUE);
            this.f3008a.f3162a[4] = f92.a(ox1.f7064a.a(), Boolean.TRUE);
            this.f3008a.f3162a[5] = f92.a(d22.f5853a.a(), Boolean.TRUE);
            az1.w(new az1(this.f3008a.f7580a), false, 1, null);
            u12.n(new u12(this.f3008a.f7580a), false, 1, null);
            new iz1(this.f3008a.f7580a).i();
            py1.z(new py1(this.f3008a.f7580a), false, 1, null);
            ox1.s(new ox1(this.f3008a.f7580a), false, 1, null);
            new d22(this.f3008a.f7580a).f();
            return;
        }
        if (aa0Var != aa0.SCREEN_ON) {
            if (aa0Var == aa0.ACCESSIBILITY_SERVICE) {
                if (Scene.f4798a.b(hz0.f1282a.j0(), false)) {
                    new az1(this.f3008a.f7580a).z();
                }
                if (Scene.f4798a.b(hz0.f1282a.h0(), false)) {
                    new py1(this.f3008a.f7580a).C();
                }
                if (Scene.f4798a.b(hz0.f1282a.i0(), false)) {
                    new ox1(this.f3008a.f7580a).u();
                    return;
                }
                return;
            }
            return;
        }
        if (this.f3008a.f3162a[0] || Scene.f4798a.b(hz0.f1282a.j0(), false)) {
            new az1(this.f3008a.f7580a).z();
            this.f3008a.f3162a[0] = false;
        }
        if (this.f3008a.f3162a[1]) {
            new u12(this.f3008a.f7580a).q();
            this.f3008a.f3162a[1] = false;
        }
        if (this.f3008a.f3162a[2]) {
            new iz1(this.f3008a.f7580a).j();
            this.f3008a.f3162a[2] = false;
        }
        if (this.f3008a.f3162a[3] || Scene.f4798a.b(hz0.f1282a.h0(), false)) {
            new py1(this.f3008a.f7580a).C();
            this.f3008a.f3162a[3] = false;
        }
        if (this.f3008a.f3162a[4] || Scene.f4798a.b(hz0.f1282a.i0(), false)) {
            new ox1(this.f3008a.f7580a).u();
            this.f3008a.f3162a[4] = false;
        }
        if (this.f3008a.f3162a[5]) {
            new d22(this.f3008a.f7580a).h();
            this.f3008a.f3162a[5] = false;
        }
    }
}
