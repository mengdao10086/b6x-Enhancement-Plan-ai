package a;

import android.content.Intent;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class we1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7780a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ xe1 f3430a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public we1(xe1 xe1Var, b62 b62Var) {
        super(2, b62Var);
        this.f3430a = xe1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        we1 we1Var = new we1(this.f3430a, b62Var);
        we1Var.f7780a = (wd2) obj;
        return we1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((we1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        xe1 xe1Var = this.f3430a;
        if (xe1Var.f3575a.a(xe1Var.f3576a.getContext())) {
            this.f3430a.f3576a.p();
        } else {
            try {
                Scene.c cVar = Scene.f4798a;
                String string = this.f3430a.f3576a.getString(u61.accessibility_please_activate);
                f92.c(string, "getString(R.string.accessibility_please_activate)");
                cVar.o(string, 0);
                this.f3430a.f3576a.startActivity(new Intent("android.settings.ACCESSIBILITY_SETTINGS"));
            } catch (Exception unused) {
            }
        }
        return m42.f6769a;
    }
}
