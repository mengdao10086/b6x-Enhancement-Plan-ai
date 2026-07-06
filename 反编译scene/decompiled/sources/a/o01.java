package a;

import com.omarea.model.AppInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o01<T> implements Comparator<AppInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o01 f6966a = new o01();

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compare(AppInfo appInfo, AppInfo appInfo2) {
        String string = appInfo.stateTags.toString();
        String string2 = appInfo2.stateTags.toString();
        if (string.compareTo(string2) >= 0) {
            if (string.compareTo(string2) > 0) {
                return 1;
            }
            String string3 = appInfo.getPackageName().toString();
            String string4 = appInfo2.getPackageName().toString();
            if (string3.compareTo(string4) >= 0) {
                return string3.compareTo(string4) > 0 ? 1 : 0;
            }
        }
        return -1;
    }
}
