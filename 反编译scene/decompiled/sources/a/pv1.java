package a;

import com.omarea.Scene;
import com.omarea.model.DeviceBindInfo;
import com.omarea.model.LoginResponse;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pv1 implements qn1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ qv1 f2455a;

    public pv1(qv1 qv1Var, n92 n92Var) {
        this.f2455a = qv1Var;
        this.f7153a = n92Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a.qn1
    public void a(String str) {
        f92.d(str, "password");
        mp0 mp0Var = new mp0(Scene.f4798a.c());
        String str2 = this.f2455a.f7244a.f2793a;
        DeviceBindInfo deviceBindInfo = (DeviceBindInfo) this.f7153a.f6891a;
        f92.b(deviceBindInfo);
        LoginResponse loginResponseM = mp0Var.M(str2, str, deviceBindInfo.getItem());
        if (loginResponseM == null || !loginResponseM.getPass()) {
            return;
        }
        Scene.c.p(Scene.f4798a, "OK", 0, 2, null);
    }
}
