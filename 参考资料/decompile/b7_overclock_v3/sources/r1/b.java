package r1;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.os.OperationCanceledException;
import androidx.core.os.f;
import g.n0;
import g.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;
import r1.c;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a<Cursor> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c<Cursor>.a f47700r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Uri f47701s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String[] f47702t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f47703u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String[] f47704v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f47705w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Cursor f47706x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f47707y;

    public b(@n0 Context context) {
        super(context);
        this.f47700r = new c.a();
    }

    @Override // r1.a
    public void D() {
        super.D();
        synchronized (this) {
            f fVar = this.f47707y;
            if (fVar != null) {
                fVar.a();
            }
        }
    }

    @Override // r1.c
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void f(Cursor cursor) {
        if (l()) {
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        Cursor cursor2 = this.f47706x;
        this.f47706x = cursor;
        if (m()) {
            super.f(cursor);
        }
        if (cursor2 == null || cursor2 == cursor || cursor2.isClosed()) {
            return;
        }
        cursor2.close();
    }

    @p0
    public String[] O() {
        return this.f47702t;
    }

    @p0
    public String P() {
        return this.f47703u;
    }

    @p0
    public String[] Q() {
        return this.f47704v;
    }

    @p0
    public String R() {
        return this.f47705w;
    }

    @n0
    public Uri S() {
        return this.f47701s;
    }

    @Override // r1.a
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public Cursor I() {
        synchronized (this) {
            if (H()) {
                throw new OperationCanceledException();
            }
            this.f47707y = new f();
        }
        try {
            Cursor cursorA = h0.b.a(i().getContentResolver(), this.f47701s, this.f47702t, this.f47703u, this.f47704v, this.f47705w, this.f47707y);
            if (cursorA != null) {
                try {
                    cursorA.getCount();
                    cursorA.registerContentObserver(this.f47700r);
                } catch (RuntimeException e10) {
                    cursorA.close();
                    throw e10;
                }
            }
            synchronized (this) {
                this.f47707y = null;
            }
            return cursorA;
        } catch (Throwable th2) {
            synchronized (this) {
                this.f47707y = null;
                throw th2;
            }
        }
    }

    @Override // r1.a
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public void J(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        cursor.close();
    }

    public void V(@p0 String[] strArr) {
        this.f47702t = strArr;
    }

    public void W(@p0 String str) {
        this.f47703u = str;
    }

    public void X(@p0 String[] strArr) {
        this.f47704v = strArr;
    }

    public void Y(@p0 String str) {
        this.f47705w = str;
    }

    public void Z(@n0 Uri uri) {
        this.f47701s = uri;
    }

    @Override // r1.a, r1.c
    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f47701s);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f47702t));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f47703u);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f47704v));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f47705w);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f47706x);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.f47715h);
    }

    @Override // r1.c
    public void r() {
        super.r();
        t();
        Cursor cursor = this.f47706x;
        if (cursor != null && !cursor.isClosed()) {
            this.f47706x.close();
        }
        this.f47706x = null;
    }

    @Override // r1.c
    public void s() {
        Cursor cursor = this.f47706x;
        if (cursor != null) {
            f(cursor);
        }
        if (A() || this.f47706x == null) {
            h();
        }
    }

    @Override // r1.c
    public void t() {
        b();
    }

    public b(@n0 Context context, @n0 Uri uri, @p0 String[] strArr, @p0 String str, @p0 String[] strArr2, @p0 String str2) {
        super(context);
        this.f47700r = new c.a();
        this.f47701s = uri;
        this.f47702t = strArr;
        this.f47703u = str;
        this.f47704v = strArr2;
        this.f47705w = str2;
    }
}
