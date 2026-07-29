package x9;

import android.content.Context;
import android.util.Log;
import com.getkeepsafe.relinker.MissingLibraryException;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import x9.c;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f54956g = "lib";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f54957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.b f54958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f54959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f54960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f54961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c.d f54962f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f54963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f54964b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f54965c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c.InterfaceC0648c f54966d;

        public a(final Context val$context, final String val$library, final String val$version, final c.InterfaceC0648c val$listener) {
            this.f54963a = val$context;
            this.f54964b = val$library;
            this.f54965c = val$version;
            this.f54966d = val$listener;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            try {
                d.this.j(this.f54963a, this.f54964b, this.f54965c);
                this.f54966d.a();
            } catch (MissingLibraryException e10) {
                this.f54966d.b(e10);
            } catch (UnsatisfiedLinkError e11) {
                this.f54966d.b(e11);
            }
        }
    }

    public class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f54968a;

        public b(final String val$mappedLibraryName) {
            this.f54968a = val$mappedLibraryName;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File dir, String filename) {
            return filename.startsWith(this.f54968a);
        }
    }

    public d() {
        this(new e(), new x9.a());
    }

    public void b(final Context context, final String library, final String currentVersion) {
        File fileD = d(context);
        File fileE = e(context, library, currentVersion);
        File[] fileArrListFiles = fileD.listFiles(new b(this.f54958b.a(library)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (this.f54960d || !file.getAbsolutePath().equals(fileE.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public d c() {
        this.f54960d = true;
        return this;
    }

    public File d(final Context context) {
        return context.getDir(f54956g, 0);
    }

    public File e(final Context context, final String library, final String version) {
        String strA = this.f54958b.a(library);
        if (f.a(version)) {
            return new File(d(context), strA);
        }
        return new File(d(context), strA + j3.b.f36044h + version);
    }

    public void f(final Context context, final String library) {
        h(context, library, null, null);
    }

    public void g(final Context context, final String library, final String version) {
        h(context, library, version, null);
    }

    public void h(final Context context, final String library, final String version, final c.InterfaceC0648c listener) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (f.a(library)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        m("Beginning load of %s...", library);
        if (listener == null) {
            j(context, library, version);
        } else {
            new Thread(new a(context, library, version, listener)).start();
        }
    }

    public void i(final Context context, final String library, final c.InterfaceC0648c listener) {
        h(context, library, null, listener);
    }

    public final void j(final Context context, final String library, final String version) throws Throwable {
        if (this.f54957a.contains(library) && !this.f54960d) {
            m("%s already loaded previously!", library);
            return;
        }
        try {
            this.f54958b.loadLibrary(library);
            this.f54957a.add(library);
            m("%s (%s) was loaded normally!", library, version);
        } catch (UnsatisfiedLinkError e10) {
            m("Loading the library normally failed: %s", Log.getStackTraceString(e10));
            m("%s (%s) was not loaded normally, re-linking...", library, version);
            File fileE = e(context, library, version);
            if (!fileE.exists() || this.f54960d) {
                if (this.f54960d) {
                    m("Forcing a re-link of %s (%s)...", library, version);
                }
                b(context, library, version);
                this.f54959c.a(context, this.f54958b.c(), this.f54958b.a(library), fileE, this);
            }
            try {
                if (this.f54961e) {
                    y9.f fVar = null;
                    try {
                        y9.f fVar2 = new y9.f(fileE);
                        try {
                            List<String> listD = fVar2.d();
                            fVar2.close();
                            Iterator<String> it2 = listD.iterator();
                            while (it2.hasNext()) {
                                f(context, this.f54958b.b(it2.next()));
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fVar = fVar2;
                            if (fVar != null) {
                                fVar.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            } catch (IOException unused) {
            }
            this.f54958b.d(fileE.getAbsolutePath());
            this.f54957a.add(library);
            m("%s (%s) was re-linked!", library, version);
        }
    }

    public d k(final c.d logger) {
        this.f54962f = logger;
        return this;
    }

    public void l(final String message) {
        c.d dVar = this.f54962f;
        if (dVar != null) {
            dVar.a(message);
        }
    }

    public void m(final String format, final Object... args) {
        l(String.format(Locale.US, format, args));
    }

    public d n() {
        this.f54961e = true;
        return this;
    }

    public d(final c.b libraryLoader, final c.a libraryInstaller) {
        this.f54957a = new HashSet();
        if (libraryLoader == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (libraryInstaller == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        }
        this.f54958b = libraryLoader;
        this.f54959c = libraryInstaller;
    }
}
