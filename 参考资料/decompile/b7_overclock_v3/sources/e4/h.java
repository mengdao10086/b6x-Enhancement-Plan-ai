package e4;

import android.content.Context;
import e4.d;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends d {

    public class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f26629b;

        public a(Context context, String str) {
            this.f26628a = context;
            this.f26629b = str;
        }

        @Override // e4.d.c
        public File a() {
            File cacheDir = this.f26628a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f26629b != null ? new File(cacheDir, this.f26629b) : cacheDir;
        }
    }

    public h(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public h(Context context, long j10) {
        this(context, "image_manager_disk_cache", j10);
    }

    public h(Context context, String str, long j10) {
        super(new a(context, str), j10);
    }
}
