package a;

import a.p80;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class u90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<String, p80.b> f7577a = new LinkedHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p80.b f3157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f3158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f3159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f3160a;

    public u90(Activity activity, String str) {
        f92.d(activity, "context");
        this.f3158a = activity;
        this.f3160a = str;
        c();
    }

    public /* synthetic */ u90(Activity activity, String str, int i, b92 b92Var) {
        this(activity, (i & 2) != 0 ? null : str);
    }

    public static /* synthetic */ void b(u90 u90Var, String str, Handler handler, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: execShell");
        }
        if ((i & 2) != 0) {
            handler = null;
        }
        u90Var.a(str, handler);
    }

    public static /* synthetic */ u90 e(u90 u90Var, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showDialog");
        }
        if ((i & 1) != 0) {
            str = u90Var.f3158a.getString(z20.execute_wait);
            f92.c(str, "context.getString(R.string.execute_wait)");
        }
        u90Var.d(str);
        return u90Var;
    }

    @SuppressLint({"InflateParams"})
    public final void a(String str, Handler handler) {
        f92.d(str, "cmd");
        c();
        View viewInflate = LayoutInflater.from(this.f3158a).inflate(y20.dialog_loading, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(x20.dialog_text);
        f92.c(viewFindViewById, "dialog.findViewById(R.id.dialog_text)");
        ((TextView) viewFindViewById).setText(this.f3158a.getString(z20.execute_wait));
        p80.a aVar = p80.f2403a;
        Activity activity = this.f3158a;
        f92.c(viewInflate, "dialog");
        this.f3157a = aVar.r(activity, viewInflate, false);
        if (handler == null) {
            r60 r60Var = new r60(new t90(this.f3157a));
            r60Var.b(str);
            r60Var.f();
        } else {
            r60 r60Var2 = new r60(handler);
            r60Var2.b(str);
            r60Var2.f();
        }
    }

    public final void c() {
        try {
            if (this.f3157a != null) {
                p80.b bVar = this.f3157a;
                f92.b(bVar);
                bVar.c();
                this.f3157a = null;
            }
        } catch (Exception unused) {
        }
        String str = this.f3160a;
        if (str == null || !f7577a.containsKey(str)) {
            return;
        }
        f7577a.remove(str);
    }

    @SuppressLint({"InflateParams"})
    public final u90 d(String str) {
        f92.d(str, "text");
        TextView textView = this.f3159a;
        if (textView == null || this.f3157a == null) {
            c();
            View viewInflate = LayoutInflater.from(this.f3158a).inflate(y20.dialog_loading, (ViewGroup) null);
            View viewFindViewById = viewInflate.findViewById(x20.dialog_text);
            f92.b(viewFindViewById);
            TextView textView2 = (TextView) viewFindViewById;
            this.f3159a = textView2;
            f92.b(textView2);
            textView2.setText(str);
            p80.a aVar = p80.f2403a;
            Activity activity = this.f3158a;
            f92.c(viewInflate, "dialog");
            this.f3157a = aVar.r(activity, viewInflate, false);
        } else {
            f92.b(textView);
            textView.setText(str);
        }
        String str2 = this.f3160a;
        if (str2 != null) {
            if (f7577a.containsKey(str2)) {
                f7577a.remove(str2);
            }
            p80.b bVar = this.f3157a;
            if (bVar != null) {
                LinkedHashMap<String, p80.b> linkedHashMap = f7577a;
                f92.b(bVar);
                linkedHashMap.put(str2, bVar);
            }
        }
        return this;
    }
}
