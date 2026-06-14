package a;

import android.util.Log;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uj0 {
    public final String a(String str) {
        f92.d(str, "origin");
        try {
            return new nb2("\r\t").g(new nb2("\r\n").g(str, "\n"), "\t");
        } catch (Exception e) {
            Log.e("Dos2Unix", "" + e.getMessage());
            return "";
        }
    }
}
