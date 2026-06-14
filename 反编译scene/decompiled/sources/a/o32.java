package a;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.omarea.krscript.model.PageNode;
import com.omarea.vtools.activities.ActivityActionPage;
import com.omarea.vtools.activities.ActivityAddinOnline;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f6978a;

    public o32(Activity activity) {
        f92.d(activity, "activity");
        this.f6978a = activity;
        new Handler(Looper.getMainLooper());
    }

    public static /* synthetic */ void b(o32 o32Var, PageNode pageNode, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        o32Var.a(pageNode, str);
    }

    public final void a(PageNode pageNode, String str) {
        f92.d(pageNode, "pageNode");
        if (!yc0.m()) {
            new za0().d(this.f6978a.getApplicationContext());
        }
        Intent intent = null;
        try {
            boolean z = true;
            if (!(pageNode.getOnlineHtmlPage().length() == 0)) {
                intent = new Intent(this.f6978a, (Class<?>) ActivityAddinOnline.class);
                intent.addFlags(268435456);
                intent.putExtra("url", pageNode.getOnlineHtmlPage());
            }
            if (!(pageNode.getPageConfigSh().length() == 0)) {
                if (intent == null) {
                    intent = new Intent(this.f6978a, (Class<?>) ActivityActionPage.class);
                }
                intent.addFlags(268435456);
            }
            if (pageNode.getPageConfigPath().length() != 0) {
                z = false;
            }
            if (!z) {
                if (intent == null) {
                    intent = new Intent(this.f6978a, (Class<?>) ActivityActionPage.class);
                }
                intent.addFlags(268435456);
            }
            if (intent != null) {
                intent.putExtra("page", pageNode);
                if (str != null) {
                    intent.putExtra("autoRunItemId", str);
                }
                this.f6978a.startActivity(intent);
            }
        } catch (Exception e) {
            Toast.makeText(this.f6978a, "" + e.getMessage(), 0).show();
        }
    }
}
