package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zk0 {
    public final boolean a(String str) {
        f92.d(str, "serviceName");
        String strC = s60.f7366a.c("settings get secure enabled_accessibility_services");
        if (ec2.C(strC, str, false, 2, null)) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : ec2.d0(strC, new String[]{":"}, false, 0, 6, null)) {
                if (!f92.a(str2, str)) {
                    if (sb.length() > 0) {
                        sb.append(":");
                    }
                    sb.append(str2);
                }
            }
            s60.f7366a.c("settings put secure enabled_accessibility_services " + ((Object) sb) + "\nsettings put secure accessibility_enabled 1");
        }
        return true;
    }
}
