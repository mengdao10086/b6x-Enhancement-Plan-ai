package a;

import android.widget.Toast;
import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityModuleUpload;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityModuleUpload$onViewCreated$10$1$1", f = "ActivityModuleUpload.kt", l = {}, m = "invokeSuspend")
public final class yc1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i92 f7969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3678a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zc1 f3679a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yc1(zc1 zc1Var, i92 i92Var, b62 b62Var) {
        super(2, b62Var);
        this.f3679a = zc1Var;
        this.f7969a = i92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        yc1 yc1Var = new yc1(this.f3679a, this.f7969a, b62Var);
        yc1Var.f3678a = (wd2) obj;
        return yc1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((yc1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        if (this.f7969a.b) {
            Toast.makeText(Scene.f4798a.c(), "OK, ^_^", 0).show();
            if (!ActivityModuleUpload.this.isDestroyed()) {
                ActivityModuleUpload.this.setResult(-1);
                ActivityModuleUpload.this.finishAfterTransition();
            }
        } else {
            Toast.makeText(Scene.f4798a.c(), ">_<!", 0).show();
        }
        u90 u90Var = ActivityModuleUpload.this.f8760a;
        if (u90Var != null) {
            u90Var.c();
        }
        return m42.f6769a;
    }
}
