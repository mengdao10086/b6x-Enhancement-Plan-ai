package a;

import android.os.Process;
import android.os.UserHandle;
import android.os.UserManager;
import com.omarea.vtools.activities.ActivityApplications;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityApplications$onOptionsItemSelected$1$1$2$1", f = "ActivityApplications.kt", l = {120, 121}, m = "invokeSuspend")
public final class x81 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public wd2 f7862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ y81 f3544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3545a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3546b;
    public Object c;
    public Object d;
    public Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x81(y81 y81Var, b62 b62Var) {
        super(2, b62Var);
        this.f3544a = y81Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        x81 x81Var = new x81(this.f3544a, b62Var);
        x81Var.f7862a = (wd2) obj;
        return x81Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((x81) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    @Override // a.s62
    public final Object j(Object obj) {
        wd2 wd2Var;
        StringBuilder sb;
        UserManager userManager;
        Long lF;
        UserHandle userHandle;
        Object objC = r62.c();
        int i = this.b;
        if (i == 0) {
            h42.b(obj);
            wd2Var = this.f7862a;
            sb = new StringBuilder();
            userManager = (UserManager) ActivityApplications.this.getSystemService("user");
            UserHandle userHandleMyUserHandle = Process.myUserHandle();
            lF = userManager != null ? t62.f(userManager.getSerialNumberForUser(userHandleMyUserHandle)) : null;
            for (String str : this.f3544a.f7958a.f52a) {
                sb.append("pm uninstall " + str + '\n');
                if (lF != null) {
                    sb.append("pm uninstall --user " + lF + ' ' + str + '\n');
                }
            }
            e50 e50Var = e50.f677a;
            String string = sb.toString();
            f92.c(string, "builder.toString()");
            this.f3545a = wd2Var;
            this.f3546b = sb;
            this.c = userManager;
            this.d = userHandleMyUserHandle;
            this.e = lF;
            this.b = 1;
            if (e50Var.X(string, this) == objC) {
                return objC;
            }
            userHandle = userHandleMyUserHandle;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
                return m42.f6769a;
            }
            lF = (Long) this.e;
            userHandle = (UserHandle) this.d;
            userManager = (UserManager) this.c;
            sb = (StringBuilder) this.f3546b;
            wd2Var = (wd2) this.f3545a;
            h42.b(obj);
        }
        fg2 fg2VarC = qe2.c();
        w81 w81Var = new w81(this, null);
        this.f3545a = wd2Var;
        this.f3546b = sb;
        this.c = userManager;
        this.d = userHandle;
        this.e = lF;
        this.b = 2;
        if (oc2.g(fg2VarC, w81Var, this) == objC) {
            return objC;
        }
        return m42.f6769a;
    }
}
