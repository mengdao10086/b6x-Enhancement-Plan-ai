package a;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.omarea.krscript.model.NodeInfoBase;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class hc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ic0 f6300a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NodeInfoBase f1154a;

    public hc0(ic0 ic0Var, Context context) {
        this.f6300a = ic0Var;
        this.f1154a = new NodeInfoBase("");
        this.f1153a = context;
    }

    public /* synthetic */ hc0(ic0 ic0Var, Context context, tb0 tb0Var) {
        this(ic0Var, context);
    }

    public final void a(Process process, String str, Runnable runnable) {
        InputStream inputStream = process.getInputStream();
        InputStream errorStream = process.getErrorStream();
        Thread thread = new Thread(new ac0(this, inputStream, str));
        Thread thread2 = new Thread(new dc0(this, errorStream, str));
        Thread thread3 = new Thread(new gc0(this, process, str, thread, thread2, runnable));
        thread.start();
        thread2.start();
        thread3.start();
    }

    @JavascriptInterface
    public String executeShell(String str) {
        return (str == null || str.isEmpty()) ? "" : yc0.c(this.f1153a, str, this.f1154a);
    }

    @JavascriptInterface
    public boolean executeShellAsync(String str, String str2, String str3) {
        Process processG;
        HashMap map = new HashMap();
        if (str3 != null) {
            try {
                if (!str3.isEmpty()) {
                    g30 g30Var = new g30(str3);
                    Iterator<String> itK = g30Var.k();
                    while (itK.hasNext()) {
                        String next = itK.next();
                        map.put(next, g30Var.i(next));
                    }
                }
            } catch (Exception e) {
                Toast.makeText(this.f1153a, e.getMessage(), 0).show();
                processG = null;
            }
        }
        processG = a70.g();
        if (processG == null) {
            return false;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(processG.getOutputStream());
        a(processG, str2, new ub0(this));
        yc0.d(this.f1153a, dataOutputStream, str, map, null, null);
        return true;
    }

    @JavascriptInterface
    public String extractAssets(String str) {
        return new wc0(this.f1153a).d(str);
    }

    @JavascriptInterface
    public boolean fileChooser(String str) {
        if (this.f6300a.f6397a != null) {
            return this.f6300a.f6397a.openFileChooser(new xb0(this, str));
        }
        return false;
    }

    @JavascriptInterface
    public boolean rootCheck() {
        return e50.f677a.y0().equals("root");
    }
}
