package e4;

import android.content.Context;
import e4.a;
import e4.d;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class f extends d {

    public class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f26624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f26625b;

        public a(Context context, String str) {
            this.f26624a = context;
            this.f26625b = str;
        }

        @Override // e4.d.c
        public File a() {
            File externalCacheDir = this.f26624a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.f26625b != null ? new File(externalCacheDir, this.f26625b) : externalCacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", a.InterfaceC0306a.f26602a);
    }

    public f(Context context, int i10) {
        this(context, "image_manager_disk_cache", i10);
    }

    public f(Context context, String str, int i10) {
        super(new a(context, str), i10);
    }
}
