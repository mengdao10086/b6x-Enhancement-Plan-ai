package a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.widget.Toast;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class iz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q61 f6455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1468a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ServiceConnection f1469a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6456a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1470a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1471a;
        public boolean b;
        public boolean c;

        public a(String str) {
            f92.d(str, "packageName");
            this.f1470a = str;
            this.f6456a = -1;
        }

        public final int a() {
            return this.f6456a;
        }

        public final boolean b() {
            return this.f1471a;
        }

        public final String c() {
            return this.f1470a;
        }

        public final boolean d() {
            return this.b;
        }

        public final boolean e() {
            return this.c;
        }

        public final void f(int i) {
            this.f6456a = i;
        }

        public final void g(boolean z) {
            this.f1471a = z;
        }

        public final void h(boolean z) {
            this.b = z;
        }

        public final void i(boolean z) {
            this.c = z;
        }
    }

    public iz0(Context context) {
        f92.d(context, "context");
        this.f1468a = context;
    }

    public final boolean b(Runnable runnable) {
        Context context;
        String str;
        f92.d(runnable, "onCompleted");
        try {
            PackageManager packageManager = this.f1468a.getPackageManager();
            if ((packageManager != null ? packageManager.getPackageInfo("com.omarea.vaddin", 0) : null) == null) {
                return false;
            }
            if (this.f6455a != null) {
                runnable.run();
                return true;
            }
            try {
                this.f1469a = new kz0(this, runnable);
                Intent intent = new Intent();
                intent.setAction("com.omarea.vaddin.ConfigUpdateService");
                intent.setComponent(new ComponentName("com.omarea.vaddin", "com.omarea.vaddin.ConfigUpdateService"));
                Context context2 = this.f1468a;
                ServiceConnection serviceConnection = this.f1469a;
                if (serviceConnection == null) {
                    f92.m("conn");
                    throw null;
                }
                if (context2.bindService(intent, serviceConnection, 1)) {
                    return true;
                }
                throw new Exception("");
            } catch (Exception unused) {
                context = this.f1468a;
                str = "连接到“Scene-高级设定”插件失败，请不要阻止插件自启动！";
                Toast.makeText(context, str, 1).show();
                return false;
            }
        } catch (Exception unused2) {
            context = this.f1468a;
            str = "未安装“Scene-高级设定”插件！";
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final a c(a aVar) {
        f92.d(aVar, "appConfig");
        try {
            q61 q61VarE = e();
            f92.b(q61VarE);
            g30 g30Var = new g30(q61VarE.a(aVar.c(), "{}"));
            Iterator<String> itK = g30Var.k();
            f92.c(itK, "config.keys()");
            while (itK.hasNext()) {
                String next = itK.next();
                if (next != null) {
                    switch (next.hashCode()) {
                        case -743846049:
                            if (next.equals("webDebug")) {
                                aVar.i(g30Var.c(next));
                            }
                            break;
                        case 99677:
                            if (next.equals("dpi")) {
                                aVar.f(g30Var.e(next));
                            }
                            break;
                        case 539018453:
                            if (next.equals("excludeRecent")) {
                                aVar.g(g30Var.c(next));
                            }
                            break;
                        case 848088603:
                            if (next.equals("smoothScroll")) {
                                aVar.h(g30Var.c(next));
                            }
                            break;
                    }
                }
            }
            return aVar;
        } catch (Exception unused) {
            return null;
        }
    }

    public final a d(String str) {
        f92.d(str, "packageName");
        return c(new a(str));
    }

    public final q61 e() {
        return this.f6455a;
    }

    public final jz0 f() {
        if (e() == null) {
            return null;
        }
        try {
            q61 q61VarE = e();
            if (q61VarE == null) {
                return null;
            }
            jz0 jz0Var = new jz0();
            jz0Var.g(q61VarE.d("com.android.systemui_hide_su", false));
            jz0Var.f(q61VarE.d("android_dis_service_foreground", false));
            jz0Var.h(q61VarE.d("reverse_optimizer", false));
            jz0Var.e(q61VarE.d("android_scroll", false));
            return jz0Var;
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean g(jz0 jz0Var) {
        f92.d(jz0Var, "globalConfig");
        if (e() == null) {
            return false;
        }
        try {
            if (e() == null) {
                return false;
            }
            q61 q61Var = this.f6455a;
            f92.b(q61Var);
            q61Var.c("com.android.systemui_hide_su", jz0Var.c());
            q61 q61Var2 = this.f6455a;
            f92.b(q61Var2);
            q61Var2.c("android_dis_service_foreground", jz0Var.b());
            q61 q61Var3 = this.f6455a;
            f92.b(q61Var3);
            q61Var3.c("reverse_optimizer", jz0Var.d());
            q61 q61Var4 = this.f6455a;
            f92.b(q61Var4);
            q61Var4.c("android_scroll", jz0Var.a());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void h() {
        try {
            if (this.f6455a != null) {
                Context context = this.f1468a;
                ServiceConnection serviceConnection = this.f1469a;
                if (serviceConnection == null) {
                    f92.m("conn");
                    throw null;
                }
                context.unbindService(serviceConnection);
                this.f6455a = null;
            }
        } catch (Exception unused) {
        }
    }
}
