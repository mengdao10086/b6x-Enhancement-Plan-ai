package e4;

import android.content.Context;
import e4.d;
import g.p0;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends d {

    public class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f26627b;

        public a(Context context, String str) {
            this.f26626a = context;
            this.f26627b = str;
        }

        @Override // e4.d.c
        public File a() {
            File externalCacheDir;
            File fileB = b();
            return ((fileB == null || !fileB.exists()) && (externalCacheDir = this.f26626a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? this.f26627b != null ? new File(externalCacheDir, this.f26627b) : externalCacheDir : fileB;
        }

        @p0
        public final File b() {
            File cacheDir = this.f26626a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f26627b != null ? new File(cacheDir, this.f26627b) : cacheDir;
        }
    }

    public g(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public g(Context context, long j10) {
        this(context, "image_manager_disk_cache", j10);
    }

    public g(Context context, String str, long j10) {
        super(new a(context, str), j10);
    }
}
