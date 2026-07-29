package e4;

import g.n0;
import g.p0;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: e4.a$a, reason: collision with other inner class name */
    public interface InterfaceC0306a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f26602a = 262144000;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f26603b = "image_manager_disk_cache";

        @p0
        a a();
    }

    public interface b {
        boolean a(@n0 File file);
    }

    @p0
    File a(c4.b bVar);

    void b(c4.b bVar, b bVar2);

    void c(c4.b bVar);

    void clear();
}
