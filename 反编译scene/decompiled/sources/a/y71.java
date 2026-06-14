package a;

import android.content.ComponentName;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import com.omarea.vtools.activities.ActivityAppComponents;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@x62(c = "com.omarea.vtools.activities.ActivityAppComponents$onCreate$4$1", f = "ActivityAppComponents.kt", l = {103}, m = "invokeSuspend")
public final class y71 extends d72 implements k82<wd2, b62<? super m42>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wd2 f3662a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ComponentInfo f3663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAppComponents.d f3664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f3665a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Object f3666b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y71(ActivityAppComponents.d dVar, ComponentInfo componentInfo, n92 n92Var, b62 b62Var) {
        super(2, b62Var);
        this.f3664a = dVar;
        this.f3663a = componentInfo;
        this.f7955a = n92Var;
    }

    @Override // a.s62
    public final b62<m42> a(Object obj, b62<?> b62Var) {
        f92.d(b62Var, "completion");
        y71 y71Var = new y71(this.f3664a, this.f3663a, this.f7955a, b62Var);
        y71Var.f3662a = (wd2) obj;
        return y71Var;
    }

    @Override // a.k82
    public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
        return ((y71) a(wd2Var, b62Var)).j(m42.f6769a);
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [T, java.util.ArrayList] */
    @Override // a.s62
    public final Object j(Object obj) {
        s60 s60Var;
        StringBuilder sb;
        String str;
        Object objC = r62.c();
        int i = this.c;
        if (i == 0) {
            h42.b(obj);
            wd2 wd2Var = this.f3662a;
            PackageManager packageManager = ActivityAppComponents.this.getPackageManager();
            ComponentInfo componentInfo = this.f3663a;
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(componentInfo.packageName, componentInfo.name));
            if (componentEnabledSetting == 0 || componentEnabledSetting == 1) {
                s60Var = s60.f7366a;
                sb = new StringBuilder();
                str = "pm disable ";
            } else {
                s60Var = s60.f7366a;
                sb = new StringBuilder();
                str = "pm enable ";
            }
            sb.append(str);
            sb.append(this.f3663a.packageName);
            sb.append('/');
            sb.append(this.f3663a.name);
            s60Var.c(sb.toString());
            n92 n92Var = new n92();
            ActivityAppComponents.d dVar = this.f3664a;
            ActivityAppComponents activityAppComponents = ActivityAppComponents.this;
            String str2 = dVar.f5111a;
            f92.c(str2, "packageName");
            ?? L = activityAppComponents.l(str2, this.f3664a.b);
            n92Var.f6891a = L;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : (ArrayList) L) {
                if (t62.a(((ComponentInfo) obj2).isEnabled()).booleanValue()) {
                    arrayList.add(obj2);
                }
            }
            fg2 fg2VarC = qe2.c();
            x71 x71Var = new x71(this, n92Var, null);
            this.f3665a = wd2Var;
            this.b = componentEnabledSetting;
            this.f3666b = n92Var;
            this.c = 1;
            if (oc2.g(fg2VarC, x71Var, this) == objC) {
                return objC;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h42.b(obj);
        }
        return m42.f6769a;
    }
}
