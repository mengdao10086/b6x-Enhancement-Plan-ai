package a;

import java.security.SecureRandom;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t50 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final t50 f2962a = new t50();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7467a = (int) Math.pow(36.0d, 8);

    public final String a() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder(8);
        while (sb.length() < 8) {
            int iNextInt = secureRandom.nextInt(f7467a);
            za2.a(36);
            String string = Integer.toString(iNextInt, 36);
            f92.c(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(string);
        }
        String string2 = sb.toString();
        f92.c(string2, "sb.toString()");
        return string2;
    }
}
