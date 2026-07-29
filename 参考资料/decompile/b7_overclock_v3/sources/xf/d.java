package xf;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.webkit.JavascriptInterface;
import com.bumptech.glide.load.engine.GlideException;
import com.just.agentweb.AgentWeb;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<AgentWeb> f55211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Activity> f55212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f55213c = getClass().getSimpleName();

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (d.this.f55211a.get() != null) {
                x xVarO = ((AgentWeb) d.this.f55211a.get()).o();
                String[] strArr = new String[1];
                Object obj = message.obj;
                strArr[0] = obj instanceof String ? (String) obj : null;
                xVarO.b("uploadFileResult", strArr);
            }
            return true;
        }
    }

    public d(AgentWeb agentWeb, Activity activity) {
        this.f55211a = null;
        this.f55212b = null;
        this.f55211a = new WeakReference<>(agentWeb);
        this.f55212b = new WeakReference<>(activity);
    }

    @JavascriptInterface
    public void uploadFile() {
        uploadFile("*/*");
    }

    @JavascriptInterface
    public void uploadFile(String str) {
        c0.c(this.f55213c, str + GlideException.a.f12263d + this.f55212b.get() + GlideException.a.f12263d + this.f55211a.get());
        if (this.f55212b.get() == null || this.f55211a.get() == null) {
            return;
        }
        com.just.agentweb.a.X(this.f55212b.get(), this.f55211a.get().s().a(), null, null, this.f55211a.get().q(), null, str, new a());
    }
}
