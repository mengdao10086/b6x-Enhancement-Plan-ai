package a;

import com.omarea.model.AppInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract /* synthetic */ class ep1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6029a;

    static {
        int[] iArr = new int[AppInfo.AppType.values().length];
        f6029a = iArr;
        iArr[AppInfo.AppType.USER.ordinal()] = 1;
        f6029a[AppInfo.AppType.SYSTEM.ordinal()] = 2;
        f6029a[AppInfo.AppType.BACKUPFILE.ordinal()] = 3;
    }
}
