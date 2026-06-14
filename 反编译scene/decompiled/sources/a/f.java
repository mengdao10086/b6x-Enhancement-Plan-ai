package a;

import android.media.MediaDescription;
import android.net.Uri;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class f {

    public static class a {
        public static void a(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri a(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
