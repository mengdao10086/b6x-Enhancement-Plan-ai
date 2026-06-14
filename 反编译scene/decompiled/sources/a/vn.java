package a;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class vn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f7709a = new HashMap();

    public static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public final void a() {
        Map<String, Object> map = this.f7709a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f7709a.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
            }
        }
        c();
    }

    public void c() {
    }
}
