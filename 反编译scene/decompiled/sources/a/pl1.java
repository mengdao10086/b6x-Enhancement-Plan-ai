package a;

import com.omarea.Scene;
import com.omarea.model.ExchangeResponse;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pl1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ql1 f7128a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ExchangeResponse f2438a;

    public pl1(ql1 ql1Var, ExchangeResponse exchangeResponse) {
        this.f7128a = ql1Var;
        this.f2438a = exchangeResponse;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f7128a.f7220a.n(this.f7128a.f2574a, this.f7128a.f2576a, this.f2438a);
        } catch (Exception e) {
            Scene.c.p(Scene.f4798a, this.f7128a.f7220a.f2115a.getString(u61.user_exchange_unknown_error) + " " + e.getMessage(), 0, 2, null);
        }
    }
}
