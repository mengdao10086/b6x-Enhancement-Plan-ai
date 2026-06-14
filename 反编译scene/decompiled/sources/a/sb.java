package a;

import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class sb {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f2870a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7379a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Set<String> f2871a = new HashSet();

    public static Set<String> a(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f7379a) {
            if (string != null) {
                if (!string.equals(f2870a)) {
                    String[] strArrSplit = string.split(":", -1);
                    HashSet hashSet = new HashSet(strArrSplit.length);
                    for (String str : strArrSplit) {
                        ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                        if (componentNameUnflattenFromString != null) {
                            hashSet.add(componentNameUnflattenFromString.getPackageName());
                        }
                    }
                    f2871a = hashSet;
                    f2870a = string;
                }
                set = f2871a;
            } else {
                set = f2871a;
            }
        }
        return set;
    }
}
