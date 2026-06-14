package a;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class rb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7286a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Field f2727a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f2728a;

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle b(jb jbVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatE = jbVar.e();
        bundle.putInt("icon", iconCompatE != null ? iconCompatE.b() : 0);
        bundle.putCharSequence("title", jbVar.i());
        bundle.putParcelable("actionIntent", jbVar.a());
        Bundle bundle2 = jbVar.d() != null ? new Bundle(jbVar.d()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", jbVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", e(jbVar.f()));
        bundle.putBoolean("showsUserInterface", jbVar.h());
        bundle.putInt("semanticAction", jbVar.g());
        return bundle;
    }

    public static Bundle c(Notification notification) {
        String str;
        String str2;
        synchronized (f7286a) {
            if (f2728a) {
                return null;
            }
            try {
                if (f2727a == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f2728a = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f2727a = declaredField;
                }
                Bundle bundle = (Bundle) f2727a.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f2727a.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                e = e;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f2728a = true;
                return null;
            } catch (NoSuchFieldException e2) {
                e = e2;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f2728a = true;
                return null;
            }
        }
    }

    public static Bundle d(ub ubVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", ubVar.i());
        bundle.putCharSequence("label", ubVar.h());
        bundle.putCharSequenceArray("choices", ubVar.e());
        bundle.putBoolean("allowFreeFormInput", ubVar.c());
        bundle.putBundle("extras", ubVar.g());
        Set<String> setD = ubVar.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator<String> it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static Bundle[] e(ub[] ubVarArr) {
        if (ubVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[ubVarArr.length];
        for (int i = 0; i < ubVarArr.length; i++) {
            bundleArr[i] = d(ubVarArr[i]);
        }
        return bundleArr;
    }

    public static Bundle f(Notification.Builder builder, jb jbVar) {
        IconCompat iconCompatE = jbVar.e();
        builder.addAction(iconCompatE != null ? iconCompatE.b() : 0, jbVar.i(), jbVar.a());
        Bundle bundle = new Bundle(jbVar.d());
        if (jbVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", e(jbVar.f()));
        }
        if (jbVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", e(jbVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", jbVar.b());
        return bundle;
    }
}
