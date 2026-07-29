package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import g.n0;
import g.p0;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class GlideException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StackTraceElement[] f12261a = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;

    @p0
    private Exception exception;
    private c4.b key;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    public static void b(List<Throwable> list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void c(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            appendable.append("Cause (").append(String.valueOf(i11)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th2 = list.get(i10);
            if (th2 instanceof GlideException) {
                ((GlideException) th2).l(appendable);
            } else {
                d(th2, appendable);
            }
            i10 = i11;
        }
    }

    public static void d(Throwable th2, Appendable appendable) {
        try {
            appendable.append(th2.getClass().toString()).append(": ").append(th2.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th2);
        }
    }

    public final void a(Throwable th2, List<Throwable> list) {
        if (!(th2 instanceof GlideException)) {
            list.add(th2);
            return;
        }
        Iterator<Throwable> it2 = ((GlideException) th2).f().iterator();
        while (it2.hasNext()) {
            a(it2.next(), list);
        }
    }

    public List<Throwable> f() {
        return this.causes;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append(this.detailMessage);
        sb2.append(this.dataClass != null ? ", " + this.dataClass : "");
        sb2.append(this.dataSource != null ? ", " + this.dataSource : "");
        sb2.append(this.key != null ? ", " + this.key : "");
        List<Throwable> listI = i();
        if (listI.isEmpty()) {
            return sb2.toString();
        }
        if (listI.size() == 1) {
            sb2.append("\nThere was 1 root cause:");
        } else {
            sb2.append("\nThere were ");
            sb2.append(listI.size());
            sb2.append(" root causes:");
        }
        for (Throwable th2 : listI) {
            sb2.append('\n');
            sb2.append(th2.getClass().getName());
            sb2.append('(');
            sb2.append(th2.getMessage());
            sb2.append(')');
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    @p0
    public Exception h() {
        return this.exception;
    }

    public List<Throwable> i() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public void k(String str) {
        List<Throwable> listI = i();
        int size = listI.size();
        int i10 = 0;
        while (i10 < size) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Root cause (");
            int i11 = i10 + 1;
            sb2.append(i11);
            sb2.append(" of ");
            sb2.append(size);
            sb2.append(ee.a.f26979d);
            listI.get(i10);
            i10 = i11;
        }
    }

    public final void l(Appendable appendable) {
        d(this, appendable);
        b(f(), new a(appendable));
    }

    public void m(c4.b bVar, DataSource dataSource) {
        n(bVar, dataSource, null);
    }

    public void n(c4.b bVar, DataSource dataSource, Class<?> cls) {
        this.key = bVar;
        this.dataSource = dataSource;
        this.dataClass = cls;
    }

    public void o(@p0 Exception exc) {
        this.exception = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th2) {
        this(str, (List<Throwable>) Collections.singletonList(th2));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        l(printStream);
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(f12261a);
        this.causes = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        l(printWriter);
    }

    public static final class a implements Appendable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f12262c = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f12263d = "  ";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Appendable f12264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12265b = true;

        public a(Appendable appendable) {
            this.f12264a = appendable;
        }

        @n0
        public final CharSequence a(@p0 CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c10) throws IOException {
            if (this.f12265b) {
                this.f12265b = false;
                this.f12264a.append(f12263d);
            }
            this.f12265b = c10 == '\n';
            this.f12264a.append(c10);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(@p0 CharSequence charSequence) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            return append(charSequenceA, 0, charSequenceA.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(@p0 CharSequence charSequence, int i10, int i11) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z10 = false;
            if (this.f12265b) {
                this.f12265b = false;
                this.f12264a.append(f12263d);
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i11 - 1) == '\n') {
                z10 = true;
            }
            this.f12265b = z10;
            this.f12264a.append(charSequenceA, i10, i11);
            return this;
        }
    }
}
