package a;

import android.content.Context;
import com.omarea.Scene;
import com.omarea.model.DeviceBindInfo;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.fragments.FragmentUser$deviceManager$1$1", f = "FragmentUser.kt", l = {}, m = "invokeSuspend")
public final class tv1 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ uv1 f7539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3069a;
    public int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tv1(uv1 uv1Var, b62 b62Var) {
        super(2, b62Var);
        this.f7539a = uv1Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        tv1 tv1Var = new tv1(this.f7539a, b62Var);
        tv1Var.f3069a = (wd2) obj;
        return tv1Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((tv1) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) throws ExecutionException, InterruptedException {
        r62.c();
        if (this.b != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        h42.b(obj);
        String strB0 = hz0.f1282a.B0();
        if (strB0 == null) {
            strB0 = "";
        }
        String str = strB0;
        Context contextP = this.f7539a.f7636a.p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        ArrayList<DeviceBindInfo> arrayList = new mp0(contextP).G(str).get();
        if (arrayList == null) {
            return m42.f6769a;
        }
        if (arrayList.size() > 1) {
            c52.n(arrayList, new sv1());
        }
        cl clVarJ = this.f7539a.f7636a.j();
        if (clVarJ == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.vtools.activities.ActivityBase");
        }
        g91 g91Var = (g91) clVarJ;
        x90 themeMode = g91Var.getThemeMode();
        ArrayList arrayList2 = new ArrayList();
        for (DeviceBindInfo deviceBindInfo : arrayList) {
            n30 n30Var = new n30();
            n30Var.i(deviceBindInfo.getCurrent() ? deviceBindInfo.getName() + this.f7539a.f7636a.J(u61.user_current) : deviceBindInfo.getName());
            n30Var.j(deviceBindInfo.getId());
            m42 m42Var = m42.f6769a;
            arrayList2.add(n30Var);
        }
        Scene.f4798a.i(new rv1(this, themeMode, arrayList2, arrayList, g91Var, str));
        return m42.f6769a;
    }
}
