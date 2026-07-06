package a;

import com.omarea.model.ActivationCodeResponse;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class im1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ km1 f6427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivationCodeResponse f1385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1386a;

    public im1(km1 km1Var, String str, ActivationCodeResponse activationCodeResponse) {
        this.f6427a = km1Var;
        this.f1386a = str;
        this.f1385a = activationCodeResponse;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6427a.f6621a.f6932a.b(this.f1386a, this.f1385a.getType());
    }
}
