package fd;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.blankj.utilcode.util.i0;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import g.i1;
import g.j1;
import g.p0;
import hd.f0;
import hd.u0;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f28081g = "cached_content_index.exi";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f28082h = 10485760;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, i> f28083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<String> f28084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseBooleanArray f28085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f28086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f28087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public c f28088f;

    public static final class a implements c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f28089e = "ExoPlayerCacheIndex";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f28090f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f28091g = "id";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f28092h = "key";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f28093i = "metadata";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f28094j = 0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f28095k = 1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f28096l = 2;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f28097m = "id = ?";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String[] f28098n = {"id", "key", "metadata"};

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f28099o = "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final db.a f28100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseArray<i> f28101b = new SparseArray<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f28102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f28103d;

        public a(db.a aVar) {
            this.f28100a = aVar;
        }

        public static void j(db.a aVar, long j10) throws DatabaseIOException {
            k(aVar, Long.toHexString(j10));
        }

        public static void k(db.a aVar, String str) throws DatabaseIOException {
            try {
                String strO = o(str);
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    db.d.c(writableDatabase, 1, str);
                    m(writableDatabase, strO);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e10) {
                throw new DatabaseIOException(e10);
            }
        }

        public static void m(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        public static String o(String str) {
            return f28089e + str;
        }

        @Override // fd.j.c
        public void a() throws DatabaseIOException {
            k(this.f28100a, (String) hd.a.g(this.f28102c));
        }

        @Override // fd.j.c
        public void b(HashMap<String, i> map) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.f28100a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    p(writableDatabase);
                    Iterator<i> it2 = map.values().iterator();
                    while (it2.hasNext()) {
                        i(writableDatabase, it2.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f28101b.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e10) {
                throw new DatabaseIOException(e10);
            }
        }

        @Override // fd.j.c
        public void c(i iVar, boolean z10) {
            if (z10) {
                this.f28101b.delete(iVar.f28074a);
            } else {
                this.f28101b.put(iVar.f28074a, null);
            }
        }

        @Override // fd.j.c
        public void d(i iVar) {
            this.f28101b.put(iVar.f28074a, iVar);
        }

        @Override // fd.j.c
        public boolean e() throws DatabaseIOException {
            return db.d.b(this.f28100a.getReadableDatabase(), 1, (String) hd.a.g(this.f28102c)) != -1;
        }

        @Override // fd.j.c
        public void f(HashMap<String, i> map) throws IOException {
            if (this.f28101b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f28100a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i10 = 0; i10 < this.f28101b.size(); i10++) {
                    try {
                        i iVarValueAt = this.f28101b.valueAt(i10);
                        if (iVarValueAt == null) {
                            l(writableDatabase, this.f28101b.keyAt(i10));
                        } else {
                            i(writableDatabase, iVarValueAt);
                        }
                    } finally {
                        writableDatabase.endTransaction();
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f28101b.clear();
            } catch (SQLException e10) {
                throw new DatabaseIOException(e10);
            }
        }

        @Override // fd.j.c
        public void g(long j10) {
            String hexString = Long.toHexString(j10);
            this.f28102c = hexString;
            this.f28103d = o(hexString);
        }

        @Override // fd.j.c
        public void h(HashMap<String, i> map, SparseArray<String> sparseArray) throws IOException {
            hd.a.i(this.f28101b.size() == 0);
            try {
                if (db.d.b(this.f28100a.getReadableDatabase(), 1, (String) hd.a.g(this.f28102c)) != 1) {
                    SQLiteDatabase writableDatabase = this.f28100a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        p(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th2) {
                        writableDatabase.endTransaction();
                        throw th2;
                    }
                }
                Cursor cursorN = n();
                while (cursorN.moveToNext()) {
                    try {
                        i iVar = new i(cursorN.getInt(0), cursorN.getString(1), j.s(new DataInputStream(new ByteArrayInputStream(cursorN.getBlob(2)))));
                        map.put(iVar.f28075b, iVar);
                        sparseArray.put(iVar.f28074a, iVar.f28075b);
                    } finally {
                    }
                }
                cursorN.close();
            } catch (SQLiteException e10) {
                map.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e10);
            }
        }

        public final void i(SQLiteDatabase sQLiteDatabase, i iVar) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            j.v(iVar.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(iVar.f28074a));
            contentValues.put("key", iVar.f28075b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) hd.a.g(this.f28103d), null, contentValues);
        }

        public final void l(SQLiteDatabase sQLiteDatabase, int i10) {
            sQLiteDatabase.delete((String) hd.a.g(this.f28103d), "id = ?", new String[]{Integer.toString(i10)});
        }

        public final Cursor n() {
            return this.f28100a.getReadableDatabase().query((String) hd.a.g(this.f28103d), f28098n, null, null, null, null, null);
        }

        public final void p(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            db.d.d(sQLiteDatabase, 1, (String) hd.a.g(this.f28102c), 1);
            m(sQLiteDatabase, (String) hd.a.g(this.f28103d));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f28103d + i0.f11861z + f28099o);
        }
    }

    public static class b implements c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f28104h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f28105i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f28106j = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f28107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final Cipher f28108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final SecretKeySpec f28109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final SecureRandom f28110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final hd.b f28111e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f28112f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public f0 f28113g;

        public b(File file, @p0 byte[] bArr, boolean z10) {
            Cipher cipherJ;
            SecretKeySpec secretKeySpec;
            hd.a.i((bArr == null && z10) ? false : true);
            if (bArr != null) {
                hd.a.a(bArr.length == 16);
                try {
                    cipherJ = j.j();
                    secretKeySpec = new SecretKeySpec(bArr, m5.b.f40641c);
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e10) {
                    throw new IllegalStateException(e10);
                }
            } else {
                hd.a.a(!z10);
                cipherJ = null;
                secretKeySpec = null;
            }
            this.f28107a = z10;
            this.f28108b = cipherJ;
            this.f28109c = secretKeySpec;
            this.f28110d = z10 ? new SecureRandom() : null;
            this.f28111e = new hd.b(file);
        }

        @Override // fd.j.c
        public void a() {
            this.f28111e.a();
        }

        @Override // fd.j.c
        public void b(HashMap<String, i> map) throws Throwable {
            m(map);
            this.f28112f = false;
        }

        @Override // fd.j.c
        public void c(i iVar, boolean z10) {
            this.f28112f = true;
        }

        @Override // fd.j.c
        public void d(i iVar) {
            this.f28112f = true;
        }

        @Override // fd.j.c
        public boolean e() {
            return this.f28111e.c();
        }

        @Override // fd.j.c
        public void f(HashMap<String, i> map) throws Throwable {
            if (this.f28112f) {
                b(map);
            }
        }

        @Override // fd.j.c
        public void g(long j10) {
        }

        @Override // fd.j.c
        public void h(HashMap<String, i> map, SparseArray<String> sparseArray) {
            hd.a.i(!this.f28112f);
            if (k(map, sparseArray)) {
                return;
            }
            map.clear();
            sparseArray.clear();
            this.f28111e.a();
        }

        public final int i(i iVar, int i10) {
            int iHashCode = (iVar.f28074a * 31) + iVar.f28075b.hashCode();
            if (i10 >= 2) {
                return (iHashCode * 31) + iVar.d().hashCode();
            }
            long jA = k.a(iVar.d());
            return (iHashCode * 31) + ((int) (jA ^ (jA >>> 32)));
        }

        public final i j(int i10, DataInputStream dataInputStream) throws IOException {
            n nVarS;
            int i11 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i10 < 2) {
                long j10 = dataInputStream.readLong();
                m mVar = new m();
                m.h(mVar, j10);
                nVarS = n.f28119f.f(mVar);
            } else {
                nVarS = j.s(dataInputStream);
            }
            return new i(i11, utf, nVarS);
        }

        public final boolean k(HashMap<String, i> map, SparseArray<String> sparseArray) throws Throwable {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            if (!this.f28111e.c()) {
                return true;
            }
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(this.f28111e.d());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                int i10 = dataInputStream.readInt();
                if (i10 >= 0 && i10 <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.f28108b == null) {
                            u0.q(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.f28108b.init(2, (Key) u0.k(this.f28109c), new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f28108b));
                        } catch (InvalidAlgorithmParameterException e10) {
                            e = e10;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e11) {
                            e = e11;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.f28107a) {
                        this.f28112f = true;
                    }
                    int i11 = dataInputStream.readInt();
                    int i12 = 0;
                    for (int i13 = 0; i13 < i11; i13++) {
                        i iVarJ = j(i10, dataInputStream);
                        map.put(iVarJ.f28075b, iVarJ);
                        sparseArray.put(iVarJ.f28074a, iVarJ.f28075b);
                        i12 += i(iVarJ, i10);
                    }
                    int i14 = dataInputStream.readInt();
                    boolean z10 = dataInputStream.read() == -1;
                    if (i14 == i12 && z10) {
                        u0.q(dataInputStream);
                        return true;
                    }
                    u0.q(dataInputStream);
                    return false;
                }
                u0.q(dataInputStream);
                return false;
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    u0.q(dataInputStream2);
                }
                return false;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    u0.q(dataInputStream2);
                }
                throw th;
            }
        }

        public final void l(i iVar, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(iVar.f28074a);
            dataOutputStream.writeUTF(iVar.f28075b);
            j.v(iVar.d(), dataOutputStream);
        }

        public final void m(HashMap<String, i> map) throws Throwable {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream outputStreamF = this.f28111e.f();
                f0 f0Var = this.f28113g;
                if (f0Var == null) {
                    this.f28113g = new f0(outputStreamF);
                } else {
                    f0Var.a(outputStreamF);
                }
                f0 f0Var2 = this.f28113g;
                DataOutputStream dataOutputStream2 = new DataOutputStream(f0Var2);
                try {
                    dataOutputStream2.writeInt(2);
                    int i10 = 0;
                    dataOutputStream2.writeInt(this.f28107a ? 1 : 0);
                    if (this.f28107a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) u0.k(this.f28110d)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            ((Cipher) u0.k(this.f28108b)).init(1, (Key) u0.k(this.f28109c), new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(f0Var2, this.f28108b));
                        } catch (InvalidAlgorithmParameterException e10) {
                            e = e10;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e11) {
                            e = e11;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(map.size());
                    for (i iVar : map.values()) {
                        l(iVar, dataOutputStream2);
                        i10 += i(iVar, 2);
                    }
                    dataOutputStream2.writeInt(i10);
                    this.f28111e.b(dataOutputStream2);
                    u0.q(null);
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = dataOutputStream2;
                    u0.q(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public interface c {
        void a() throws IOException;

        void b(HashMap<String, i> map) throws IOException;

        void c(i iVar, boolean z10);

        void d(i iVar);

        boolean e() throws IOException;

        void f(HashMap<String, i> map) throws IOException;

        void g(long j10);

        void h(HashMap<String, i> map, SparseArray<String> sparseArray) throws IOException;
    }

    public j(db.a aVar) {
        this(aVar, null, null, false, false);
    }

    @j1
    public static void g(db.a aVar, long j10) throws DatabaseIOException {
        a.j(aVar, j10);
    }

    @SuppressLint({"GetInstance"})
    public static Cipher j() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (u0.f31154a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", BouncyCastleProvider.f45329b);
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    @i1
    public static int n(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int i10 = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt >= 0) {
            return iKeyAt;
        }
        while (i10 < size && i10 == sparseArray.keyAt(i10)) {
            i10++;
        }
        return i10;
    }

    public static boolean q(String str) {
        return str.startsWith(f28081g);
    }

    public static n s(DataInputStream dataInputStream) throws IOException {
        int i10 = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i11 = 0; i11 < i10; i11++) {
            String utf = dataInputStream.readUTF();
            int i12 = dataInputStream.readInt();
            if (i12 < 0) {
                throw new IOException("Invalid value size: " + i12);
            }
            int iMin = Math.min(i12, f28082h);
            byte[] bArrCopyOf = u0.f31159f;
            int i13 = 0;
            while (i13 != i12) {
                int i14 = i13 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i14);
                dataInputStream.readFully(bArrCopyOf, i13, iMin);
                iMin = Math.min(i12 - i14, f28082h);
                i13 = i14;
            }
            map.put(utf, bArrCopyOf);
        }
        return new n(map);
    }

    public static void v(n nVar, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> setG = nVar.g();
        dataOutputStream.writeInt(setG.size());
        for (Map.Entry<String, byte[]> entry : setG) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    public final i d(String str) {
        int iN = n(this.f28084b);
        i iVar = new i(iN, str);
        this.f28083a.put(str, iVar);
        this.f28084b.put(iN, str);
        this.f28086d.put(iN, true);
        this.f28087e.d(iVar);
        return iVar;
    }

    public void e(String str, m mVar) {
        i iVarO = o(str);
        if (iVarO.b(mVar)) {
            this.f28087e.d(iVarO);
        }
    }

    public int f(String str) {
        return o(str).f28074a;
    }

    @p0
    public i h(String str) {
        return this.f28083a.get(str);
    }

    public Collection<i> i() {
        return Collections.unmodifiableCollection(this.f28083a.values());
    }

    public l k(String str) {
        i iVarH = h(str);
        return iVarH != null ? iVarH.d() : n.f28119f;
    }

    @p0
    public String l(int i10) {
        return this.f28084b.get(i10);
    }

    public Set<String> m() {
        return this.f28083a.keySet();
    }

    public i o(String str) {
        i iVar = this.f28083a.get(str);
        return iVar == null ? d(str) : iVar;
    }

    @j1
    public void p(long j10) throws IOException {
        c cVar;
        this.f28087e.g(j10);
        c cVar2 = this.f28088f;
        if (cVar2 != null) {
            cVar2.g(j10);
        }
        if (this.f28087e.e() || (cVar = this.f28088f) == null || !cVar.e()) {
            this.f28087e.h(this.f28083a, this.f28084b);
        } else {
            this.f28088f.h(this.f28083a, this.f28084b);
            this.f28087e.b(this.f28083a);
        }
        c cVar3 = this.f28088f;
        if (cVar3 != null) {
            cVar3.a();
            this.f28088f = null;
        }
    }

    public void r(String str) {
        i iVar = this.f28083a.get(str);
        if (iVar != null && iVar.g() && iVar.i()) {
            this.f28083a.remove(str);
            int i10 = iVar.f28074a;
            boolean z10 = this.f28086d.get(i10);
            this.f28087e.c(iVar, z10);
            if (z10) {
                this.f28084b.remove(i10);
                this.f28086d.delete(i10);
            } else {
                this.f28084b.put(i10, null);
                this.f28085c.put(i10, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void t() {
        UnmodifiableIterator it2 = ImmutableSet.copyOf((Collection) this.f28083a.keySet()).iterator();
        while (it2.hasNext()) {
            r((String) it2.next());
        }
    }

    @j1
    public void u() throws IOException {
        this.f28087e.f(this.f28083a);
        int size = this.f28085c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f28084b.remove(this.f28085c.keyAt(i10));
        }
        this.f28085c.clear();
        this.f28086d.clear();
    }

    public j(@p0 db.a aVar, @p0 File file, @p0 byte[] bArr, boolean z10, boolean z11) {
        hd.a.i((aVar == null && file == null) ? false : true);
        this.f28083a = new HashMap<>();
        this.f28084b = new SparseArray<>();
        this.f28085c = new SparseBooleanArray();
        this.f28086d = new SparseBooleanArray();
        a aVar2 = aVar != null ? new a(aVar) : null;
        b bVar = file != null ? new b(new File(file, f28081g), bArr, z10) : null;
        if (aVar2 == null || (bVar != null && z11)) {
            this.f28087e = (c) u0.k(bVar);
            this.f28088f = aVar2;
        } else {
            this.f28087e = aVar2;
            this.f28088f = bVar;
        }
    }
}
