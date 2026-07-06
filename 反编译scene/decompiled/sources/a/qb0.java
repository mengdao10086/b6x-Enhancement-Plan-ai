package a;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f2563a;

    public qb0(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "activity");
        this.f7195a = context;
        this.f2563a = str;
    }

    public final Intent a() {
        Intent intent;
        try {
            if (ec2.C(this.f2563a, "/", false, 2, null)) {
                intent = new Intent("android.intent.action.VIEW");
                List listD0 = ec2.d0(this.f2563a, new String[]{"/"}, false, 0, 6, null);
                String str = (String) i52.A(listD0);
                String str2 = (String) i52.J(listD0);
                if (bc2.x(str2, ".", false, 2, null)) {
                    str2 = str + str2;
                }
                intent.setClassName(str, str2);
            } else {
                intent = new Intent(this.f2563a);
            }
            intent.addFlags(268435456);
            return intent;
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean b() {
        s60 s60Var;
        StringBuilder sb;
        String str;
        if (bc2.x(this.f2563a, "am ", false, 2, null)) {
            return ec2.C(s60.f7366a.a(this.f2563a), "Start", false, 2, null);
        }
        try {
            this.f7195a.startActivity(a());
            return true;
        } catch (SecurityException unused) {
            if (ec2.C(this.f2563a, "/", false, 2, null)) {
                s60Var = s60.f7366a;
                sb = new StringBuilder();
                str = "am start-activity -W -n '";
            } else {
                s60Var = s60.f7366a;
                sb = new StringBuilder();
                str = "am start-activity -W -a '";
            }
            sb.append(str);
            sb.append(this.f2563a);
            sb.append('\'');
            if (ec2.C(s60Var.c(sb.toString()), "ok", false, 2, null)) {
                return true;
            }
            Context context = this.f7195a;
            Toast.makeText(context, context.getString(ob0.kr_slice_activity_fail), 0).show();
            return false;
        } catch (Exception unused2) {
            Context context2 = this.f7195a;
            Toast.makeText(context2, context2.getString(ob0.kr_slice_activity_fail), 0).show();
            return false;
        }
    }
}
