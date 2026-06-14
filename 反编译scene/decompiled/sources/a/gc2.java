package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class gc2 extends fc2 {
    public static final String t0(String str, int i) {
        f92.d(str, "$this$take");
        if (i >= 0) {
            String strSubstring = str.substring(0, ga2.d(i, str.length()));
            f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }
}
