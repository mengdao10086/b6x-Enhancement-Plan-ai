package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class g72 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f72 f6180a;

    /* JADX WARN: Removed duplicated region for block: B:42:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.g72.<clinit>():void");
    }

    public static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int iM = ec2.M(property, '.', 0, false, 6, null);
        if (iM < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i = iM + 1;
        int iM2 = ec2.M(property, '.', i, false, 4, null);
        if (iM2 < 0) {
            iM2 = property.length();
        }
        if (property == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = property.substring(0, iM);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (property == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring2 = property.substring(i, iM2);
        f92.c(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}
