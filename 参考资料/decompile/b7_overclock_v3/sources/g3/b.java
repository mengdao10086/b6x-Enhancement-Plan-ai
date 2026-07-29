package g3;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import j3.f;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class b extends Instrumentation {
    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        String[] stringArrayExtra;
        Class<?> clsLoadClass = classLoader.loadClass(str);
        Object objNewInstance = clsLoadClass.newInstance();
        if (h3.a.f() && (stringArrayExtra = intent.getStringArrayExtra(h3.a.f30399b)) != null && stringArrayExtra.length > 0) {
            for (String str2 : stringArrayExtra) {
                Object obj = intent.getExtras().get(f.b(str2));
                if (obj != null) {
                    try {
                        Field declaredField = clsLoadClass.getDeclaredField(f.b(str2));
                        declaredField.setAccessible(true);
                        declaredField.set(objNewInstance, obj);
                    } catch (Exception e10) {
                        h3.a.f30402e.error("ARouter::", "Inject values for activity error! [" + e10.getMessage() + "]");
                    }
                }
            }
        }
        return (Activity) objNewInstance;
    }
}
