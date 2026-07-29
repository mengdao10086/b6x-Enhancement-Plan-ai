package e4;

import e4.a;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class d implements a.InterfaceC0306a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f26610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f26611d;

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f26612a;

        public a(String str) {
            this.f26612a = str;
        }

        @Override // e4.d.c
        public File a() {
            return new File(this.f26612a);
        }
    }

    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f26613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f26614b;

        public b(String str, String str2) {
            this.f26613a = str;
            this.f26614b = str2;
        }

        @Override // e4.d.c
        public File a() {
            return new File(this.f26613a, this.f26614b);
        }
    }

    public interface c {
        File a();
    }

    public d(String str, long j10) {
        this(new a(str), j10);
    }

    @Override // e4.a.InterfaceC0306a
    public e4.a a() {
        File fileA = this.f26611d.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.isDirectory() || fileA.mkdirs()) {
            return e.d(fileA, this.f26610c);
        }
        return null;
    }

    public d(String str, String str2, long j10) {
        this(new b(str, str2), j10);
    }

    public d(c cVar, long j10) {
        this.f26610c = j10;
        this.f26611d = cVar;
    }
}
