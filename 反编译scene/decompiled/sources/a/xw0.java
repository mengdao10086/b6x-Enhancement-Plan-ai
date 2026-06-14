package a;

import a.tw0;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.scene_mode.SceneMode$FreezeAppThread$run$fgApps$1", f = "SceneMode.kt", l = {57}, m = "invokeSuspend")
public final class xw0 extends d72 implements k82<wd2, b62<? super ArrayList<String>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3624a;
    public int b;

    public xw0(b62 b62Var) {
        super(2, b62Var);
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        xw0 xw0Var = new xw0(b62Var);
        xw0Var.f7924a = (wd2) obj;
        return xw0Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super ArrayList<String>> b62Var) {
        return ((xw0) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f7924a;
            tw0.a aVar = tw0.f3070a;
            this.f3624a = wd2Var;
            this.b = 1;
            obj = aVar.c(this);
            if (obj == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return obj;
    }
}
