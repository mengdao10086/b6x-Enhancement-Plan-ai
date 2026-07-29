package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.a0;
import c2.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements c2.e, p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final c2.e f7314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final a f7315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public final androidx.room.a f7316c;

    public static final class a implements c2.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public final androidx.room.a f7317a;

        public a(@g.n0 androidx.room.a aVar) {
            this.f7317a = aVar;
        }

        public static /* synthetic */ Object F0(c2.d dVar) {
            return null;
        }

        public static /* synthetic */ Object G0(boolean z10, c2.d dVar) {
            dVar.o0(z10);
            return null;
        }

        public static /* synthetic */ Integer M(String str, String str2, Object[] objArr, c2.d dVar) {
            return Integer.valueOf(dVar.j(str, str2, objArr));
        }

        public static /* synthetic */ Object M0(Locale locale, c2.d dVar) {
            dVar.o1(locale);
            return null;
        }

        public static /* synthetic */ Object P(String str, c2.d dVar) {
            dVar.C(str);
            return null;
        }

        public static /* synthetic */ Object T(String str, Object[] objArr, c2.d dVar) {
            dVar.y0(str, objArr);
            return null;
        }

        public static /* synthetic */ Long W(String str, int i10, ContentValues contentValues, c2.d dVar) {
            return Long.valueOf(dVar.P0(str, i10, contentValues));
        }

        public static /* synthetic */ Boolean Z(c2.d dVar) {
            return Boolean.valueOf(dVar.G1());
        }

        public static /* synthetic */ Boolean b0(int i10, c2.d dVar) {
            return Boolean.valueOf(dVar.f1(i10));
        }

        public static /* synthetic */ Object d1(int i10, c2.d dVar) {
            dVar.I1(i10);
            return null;
        }

        public static /* synthetic */ Long h1(long j10, c2.d dVar) {
            return Long.valueOf(dVar.C0(j10));
        }

        public static /* synthetic */ Object i1(long j10, c2.d dVar) {
            dVar.K1(j10);
            return null;
        }

        public static /* synthetic */ Object k1(int i10, c2.d dVar) {
            dVar.A(i10);
            return null;
        }

        public static /* synthetic */ Integer m1(String str, int i10, ContentValues contentValues, String str2, Object[] objArr, c2.d dVar) {
            return Integer.valueOf(dVar.B0(str, i10, contentValues, str2, objArr));
        }

        @Override // c2.d
        public void A(final int i10) {
            this.f7317a.c(new p.a() { // from class: androidx.room.s
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.k1(i10, (c2.d) obj);
                }
            });
        }

        @Override // c2.d
        public void A0() {
            try {
                this.f7317a.f().A0();
            } catch (Throwable th2) {
                this.f7317a.b();
                throw th2;
            }
        }

        @Override // c2.d
        public void B() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // c2.d
        public int B0(final String str, final int i10, final ContentValues contentValues, final String str2, final Object[] objArr) {
            return ((Integer) this.f7317a.c(new p.a() { // from class: androidx.room.x
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.m1(str, i10, contentValues, str2, objArr, (c2.d) obj);
                }
            })).intValue();
        }

        @Override // c2.d
        public void C(final String str) throws SQLException {
            this.f7317a.c(new p.a() { // from class: androidx.room.v
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.P(str, (c2.d) obj);
                }
            });
        }

        @Override // c2.d
        public long C0(final long j10) {
            return ((Long) this.f7317a.c(new p.a() { // from class: androidx.room.u
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.h1(j10, (c2.d) obj);
                }
            })).longValue();
        }

        @Override // c2.d
        public boolean G() {
            return ((Boolean) this.f7317a.c(new p.a() { // from class: androidx.room.k
                @Override // p.a
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((c2.d) obj).G());
                }
            })).booleanValue();
        }

        @Override // c2.d
        @g.v0(api = 16)
        public boolean G1() {
            return ((Boolean) this.f7317a.c(new p.a() { // from class: androidx.room.e
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.Z((c2.d) obj);
                }
            })).booleanValue();
        }

        @Override // c2.d
        public void I1(final int i10) {
            this.f7317a.c(new p.a() { // from class: androidx.room.m
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.d1(i10, (c2.d) obj);
                }
            });
        }

        @Override // c2.d
        public c2.i K(String str) {
            return new b(str, this.f7317a);
        }

        @Override // c2.d
        public boolean K0() {
            return ((Boolean) this.f7317a.c(o.f7500a)).booleanValue();
        }

        @Override // c2.d
        public void K1(final long j10) {
            this.f7317a.c(new p.a() { // from class: androidx.room.t
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.i1(j10, (c2.d) obj);
                }
            });
        }

        @Override // c2.d
        public Cursor L0(String str) {
            try {
                return new c(this.f7317a.f().L0(str), this.f7317a);
            } catch (Throwable th2) {
                this.f7317a.b();
                throw th2;
            }
        }

        @Override // c2.d
        @g.v0(api = 24)
        public Cursor O(c2.g gVar, CancellationSignal cancellationSignal) {
            try {
                return new c(this.f7317a.f().O(gVar, cancellationSignal), this.f7317a);
            } catch (Throwable th2) {
                this.f7317a.b();
                throw th2;
            }
        }

        @Override // c2.d
        public long P0(final String str, final int i10, final ContentValues contentValues) throws SQLException {
            return ((Long) this.f7317a.c(new p.a() { // from class: androidx.room.w
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.W(str, i10, contentValues, (c2.d) obj);
                }
            })).longValue();
        }

        @Override // c2.d
        public void Q0(SQLiteTransactionListener sQLiteTransactionListener) {
            try {
                this.f7317a.f().Q0(sQLiteTransactionListener);
            } catch (Throwable th2) {
                this.f7317a.b();
                throw th2;
            }
        }

        @Override // c2.d
        public /* synthetic */ boolean R0() {
            return c2.c.b(this);
        }

        @Override // c2.d
        public /* synthetic */ void R1(String str, Object[] objArr) {
            c2.c.a(this, str, objArr);
        }

        @Override // c2.d
        public boolean S0() {
            if (this.f7317a.d() == null) {
                return false;
            }
            return ((Boolean) this.f7317a.c(new p.a() { // from class: androidx.room.l
                @Override // p.a
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((c2.d) obj).S0());
                }
            })).booleanValue();
        }

        @Override // c2.d
        public void T0() {
            if (this.f7317a.d() == null) {
                throw new IllegalStateException("End transaction called but delegateDb is null");
            }
            try {
                this.f7317a.d().T0();
            } finally {
                this.f7317a.b();
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f7317a.a();
        }

        @Override // c2.d
        public boolean e0() {
            return ((Boolean) this.f7317a.c(new p.a() { // from class: androidx.room.n
                @Override // p.a
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((c2.d) obj).e0());
                }
            })).booleanValue();
        }

        @Override // c2.d
        public boolean f1(final int i10) {
            return ((Boolean) this.f7317a.c(new p.a() { // from class: androidx.room.b
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.b0(i10, (c2.d) obj);
                }
            })).booleanValue();
        }

        @Override // c2.d
        public String getPath() {
            return (String) this.f7317a.c(new p.a() { // from class: androidx.room.h
                @Override // p.a
                public final Object apply(Object obj) {
                    return ((c2.d) obj).getPath();
                }
            });
        }

        @Override // c2.d
        public int getVersion() {
            return ((Integer) this.f7317a.c(new p.a() { // from class: androidx.room.i
                @Override // p.a
                public final Object apply(Object obj) {
                    return Integer.valueOf(((c2.d) obj).getVersion());
                }
            })).intValue();
        }

        @Override // c2.d
        public boolean isOpen() {
            c2.d dVarD = this.f7317a.d();
            if (dVarD == null) {
                return false;
            }
            return dVarD.isOpen();
        }

        @Override // c2.d
        public int j(final String str, final String str2, final Object[] objArr) {
            return ((Integer) this.f7317a.c(new p.a() { // from class: androidx.room.y
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.M(str, str2, objArr, (c2.d) obj);
                }
            })).intValue();
        }

        @Override // c2.d
        public Cursor j1(c2.g gVar) {
            try {
                return new c(this.f7317a.f().j1(gVar), this.f7317a);
            } catch (Throwable th2) {
                this.f7317a.b();
                throw th2;
            }
        }

        @Override // c2.d
        public void o() {
            try {
                this.f7317a.f().o();
            } catch (Throwable th2) {
                this.f7317a.b();
                throw th2;
            }
        }

        @Override // c2.d
        @g.v0(api = 16)
        public void o0(final boolean z10) {
            this.f7317a.c(new p.a() { // from class: androidx.room.d
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.G0(z10, (c2.d) obj);
                }
            });
        }

        @Override // c2.d
        public void o1(final Locale locale) {
            this.f7317a.c(new p.a() { // from class: androidx.room.c
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.M0(locale, (c2.d) obj);
                }
            });
        }

        public void p1() {
            this.f7317a.c(new p.a() { // from class: androidx.room.f
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.F0((c2.d) obj);
                }
            });
        }

        @Override // c2.d
        public long q0() {
            return ((Long) this.f7317a.c(new p.a() { // from class: androidx.room.q
                @Override // p.a
                public final Object apply(Object obj) {
                    return Long.valueOf(((c2.d) obj).q0());
                }
            })).longValue();
        }

        @Override // c2.d
        public boolean t(long j10) {
            return ((Boolean) this.f7317a.c(o.f7500a)).booleanValue();
        }

        @Override // c2.d
        public boolean t0() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // c2.d
        public Cursor v(String str, Object[] objArr) {
            try {
                return new c(this.f7317a.f().v(str, objArr), this.f7317a);
            } catch (Throwable th2) {
                this.f7317a.b();
                throw th2;
            }
        }

        @Override // c2.d
        public void v0() {
            c2.d dVarD = this.f7317a.d();
            if (dVarD == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
            }
            dVarD.v0();
        }

        @Override // c2.d
        public void v1(SQLiteTransactionListener sQLiteTransactionListener) {
            try {
                this.f7317a.f().v1(sQLiteTransactionListener);
            } catch (Throwable th2) {
                this.f7317a.b();
                throw th2;
            }
        }

        @Override // c2.d
        public List<Pair<String, String>> w() {
            return (List) this.f7317a.c(new p.a() { // from class: androidx.room.g
                @Override // p.a
                public final Object apply(Object obj) {
                    return ((c2.d) obj).w();
                }
            });
        }

        @Override // c2.d
        public boolean x1() {
            if (this.f7317a.d() == null) {
                return false;
            }
            return ((Boolean) this.f7317a.c(new p.a() { // from class: androidx.room.j
                @Override // p.a
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((c2.d) obj).x1());
                }
            })).booleanValue();
        }

        @Override // c2.d
        public void y0(final String str, final Object[] objArr) throws SQLException {
            this.f7317a.c(new p.a() { // from class: androidx.room.z
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.a.T(str, objArr, (c2.d) obj);
                }
            });
        }

        @Override // c2.d
        public long z0() {
            return ((Long) this.f7317a.c(new p.a() { // from class: androidx.room.p
                @Override // p.a
                public final Object apply(Object obj) {
                    return Long.valueOf(((c2.d) obj).z0());
                }
            })).longValue();
        }
    }

    public static class b implements c2.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<Object> f7319b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.room.a f7320c;

        public b(String str, androidx.room.a aVar) {
            this.f7318a = str;
            this.f7320c = aVar;
        }

        public static /* synthetic */ Object h(c2.i iVar) {
            iVar.X();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object i(p.a aVar, c2.d dVar) {
            c2.i iVarK = dVar.K(this.f7318a);
            d(iVarK);
            return aVar.apply(iVarK);
        }

        @Override // c2.f
        public void D(int i10, String str) {
            k(i10, str);
        }

        @Override // c2.f
        public void E0(int i10, byte[] bArr) {
            k(i10, bArr);
        }

        @Override // c2.i
        public String I0() {
            return (String) f(new p.a() { // from class: androidx.room.e0
                @Override // p.a
                public final Object apply(Object obj) {
                    return ((c2.i) obj).I0();
                }
            });
        }

        @Override // c2.f
        public void M1() {
            this.f7319b.clear();
        }

        @Override // c2.f
        public void R(int i10, double d10) {
            k(i10, Double.valueOf(d10));
        }

        @Override // c2.i
        public void X() {
            f(new p.a() { // from class: androidx.room.c0
                @Override // p.a
                public final Object apply(Object obj) {
                    return a0.b.h((c2.i) obj);
                }
            });
        }

        @Override // c2.i
        public long Y() {
            return ((Long) f(new p.a() { // from class: androidx.room.g0
                @Override // p.a
                public final Object apply(Object obj) {
                    return Long.valueOf(((c2.i) obj).Y());
                }
            })).longValue();
        }

        @Override // c2.i
        public long Z1() {
            return ((Long) f(new p.a() { // from class: androidx.room.f0
                @Override // p.a
                public final Object apply(Object obj) {
                    return Long.valueOf(((c2.i) obj).Z1());
                }
            })).longValue();
        }

        @Override // c2.i
        public int a0() {
            return ((Integer) f(new p.a() { // from class: androidx.room.d0
                @Override // p.a
                public final Object apply(Object obj) {
                    return Integer.valueOf(((c2.i) obj).a0());
                }
            })).intValue();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final void d(c2.i iVar) {
            int i10 = 0;
            while (i10 < this.f7319b.size()) {
                int i11 = i10 + 1;
                Object obj = this.f7319b.get(i10);
                if (obj == null) {
                    iVar.l1(i11);
                } else if (obj instanceof Long) {
                    iVar.s0(i11, ((Long) obj).longValue());
                } else if (obj instanceof Double) {
                    iVar.R(i11, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    iVar.D(i11, (String) obj);
                } else if (obj instanceof byte[]) {
                    iVar.E0(i11, (byte[]) obj);
                }
                i10 = i11;
            }
        }

        public final <T> T f(final p.a<c2.i, T> aVar) {
            return (T) this.f7320c.c(new p.a() { // from class: androidx.room.b0
                @Override // p.a
                public final Object apply(Object obj) {
                    return this.f7335a.i(aVar, (c2.d) obj);
                }
            });
        }

        public final void k(int i10, Object obj) {
            int i11 = i10 - 1;
            if (i11 >= this.f7319b.size()) {
                for (int size = this.f7319b.size(); size <= i11; size++) {
                    this.f7319b.add(null);
                }
            }
            this.f7319b.set(i11, obj);
        }

        @Override // c2.f
        public void l1(int i10) {
            k(i10, null);
        }

        @Override // c2.f
        public void s0(int i10, long j10) {
            k(i10, Long.valueOf(j10));
        }
    }

    public static final class c implements Cursor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cursor f7321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.room.a f7322b;

        public c(Cursor cursor, androidx.room.a aVar) {
            this.f7321a = cursor;
            this.f7322b = aVar;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f7321a.close();
            this.f7322b.b();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i10, CharArrayBuffer charArrayBuffer) {
            this.f7321a.copyStringToBuffer(i10, charArrayBuffer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.f7321a.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i10) {
            return this.f7321a.getBlob(i10);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f7321a.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.f7321a.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
            return this.f7321a.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i10) {
            return this.f7321a.getColumnName(i10);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f7321a.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.f7321a.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i10) {
            return this.f7321a.getDouble(i10);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f7321a.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i10) {
            return this.f7321a.getFloat(i10);
        }

        @Override // android.database.Cursor
        public int getInt(int i10) {
            return this.f7321a.getInt(i10);
        }

        @Override // android.database.Cursor
        public long getLong(int i10) {
            return this.f7321a.getLong(i10);
        }

        @Override // android.database.Cursor
        @g.v0(api = 19)
        public Uri getNotificationUri() {
            return b.C0107b.a(this.f7321a);
        }

        @Override // android.database.Cursor
        @g.p0
        @g.v0(api = 29)
        public List<Uri> getNotificationUris() {
            return b.e.a(this.f7321a);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.f7321a.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i10) {
            return this.f7321a.getShort(i10);
        }

        @Override // android.database.Cursor
        public String getString(int i10) {
            return this.f7321a.getString(i10);
        }

        @Override // android.database.Cursor
        public int getType(int i10) {
            return this.f7321a.getType(i10);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f7321a.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f7321a.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f7321a.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f7321a.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f7321a.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f7321a.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i10) {
            return this.f7321a.isNull(i10);
        }

        @Override // android.database.Cursor
        public boolean move(int i10) {
            return this.f7321a.move(i10);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f7321a.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f7321a.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f7321a.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i10) {
            return this.f7321a.moveToPosition(i10);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f7321a.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.f7321a.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f7321a.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.f7321a.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.f7321a.respond(bundle);
        }

        @Override // android.database.Cursor
        @g.v0(api = 23)
        public void setExtras(Bundle bundle) {
            b.d.a(this.f7321a, bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f7321a.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        @g.v0(api = 29)
        public void setNotificationUris(@g.n0 ContentResolver contentResolver, @g.n0 List<Uri> list) {
            b.e.b(this.f7321a, contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f7321a.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f7321a.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public a0(@g.n0 c2.e eVar, @g.n0 androidx.room.a aVar) {
        this.f7314a = eVar;
        this.f7316c = aVar;
        aVar.g(eVar);
        this.f7315b = new a(aVar);
    }

    @g.n0
    public androidx.room.a a() {
        return this.f7316c;
    }

    @g.n0
    public c2.d c() {
        return this.f7315b;
    }

    @Override // c2.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        try {
            this.f7315b.close();
        } catch (IOException e10) {
            b2.f.a(e10);
        }
    }

    @Override // c2.e
    @g.p0
    public String getDatabaseName() {
        return this.f7314a.getDatabaseName();
    }

    @Override // c2.e
    @g.n0
    @g.v0(api = 24)
    public c2.d getReadableDatabase() {
        this.f7315b.p1();
        return this.f7315b;
    }

    @Override // c2.e
    @g.n0
    @g.v0(api = 24)
    public c2.d getWritableDatabase() {
        this.f7315b.p1();
        return this.f7315b;
    }

    @Override // androidx.room.p0
    @g.n0
    public c2.e l() {
        return this.f7314a;
    }

    @Override // c2.e
    @g.v0(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f7314a.setWriteAheadLoggingEnabled(z10);
    }
}
