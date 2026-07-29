package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;
import ya.g;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class a extends VersionedParcel {
    public static final Charset C = Charset.forName(g.f56719p);
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final int H = 4;
    public static final int I = 5;
    public static final int J = 6;
    public static final int K = 7;
    public static final int L = 8;
    public static final int M = 9;
    public static final int N = 10;
    public static final int O = 11;
    public static final int P = 12;
    public static final int Q = 13;
    public static final int R = 14;
    public int A;
    public int B;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final DataInputStream f8058t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final DataOutputStream f8059u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public DataInputStream f8060v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public DataOutputStream f8061w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b f8062x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f8063y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f8064z;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteArrayOutputStream f8066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DataOutputStream f8067b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8068c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final DataOutputStream f8069d;

        public b(int i10, DataOutputStream dataOutputStream) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f8066a = byteArrayOutputStream;
            this.f8067b = new DataOutputStream(byteArrayOutputStream);
            this.f8068c = i10;
            this.f8069d = dataOutputStream;
        }

        public void a() throws IOException {
            this.f8067b.flush();
            int size = this.f8066a.size();
            this.f8069d.writeInt((this.f8068c << 16) | (size >= 65535 ? 65535 : size));
            if (size >= 65535) {
                this.f8069d.writeInt(size);
            }
            this.f8066a.writeTo(this.f8069d);
        }
    }

    public a(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void C0(double d10) {
        try {
            this.f8061w.writeDouble(d10);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean F(int i10) {
        while (true) {
            try {
                int i11 = this.A;
                if (i11 == i10) {
                    return true;
                }
                if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                    return false;
                }
                if (this.f8064z < this.B) {
                    this.f8058t.skip(r2 - r1);
                }
                this.B = -1;
                int i12 = this.f8058t.readInt();
                this.f8064z = 0;
                int i13 = i12 & 65535;
                if (i13 == 65535) {
                    i13 = this.f8058t.readInt();
                }
                this.A = (i12 >> 16) & 65535;
                this.B = i13;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float G() {
        try {
            return this.f8060v.readFloat();
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void H0(float f10) {
        try {
            this.f8061w.writeFloat(f10);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int L() {
        try {
            return this.f8060v.readInt();
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void L0(int i10) {
        try {
            this.f8061w.writeInt(i10);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long Q() {
        try {
            return this.f8060v.readLong();
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void Q0(long j10) {
        try {
            this.f8061w.writeLong(j10);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T V() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void W0(Parcelable parcelable) {
        if (!this.f8063y) {
            throw new RuntimeException("Parcelables cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        b bVar = this.f8062x;
        if (bVar != null) {
            try {
                if (bVar.f8066a.size() != 0) {
                    this.f8062x.a();
                }
                this.f8062x = null;
            } catch (IOException e10) {
                throw new VersionedParcel.ParcelException(e10);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel c() {
        return new a(this.f8060v, this.f8061w, this.f8054a, this.f8055b, this.f8056c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String c0() {
        try {
            int i10 = this.f8060v.readInt();
            if (i10 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i10];
            this.f8060v.readFully(bArr);
            return new String(bArr, C);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder e0() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void e1(String str) {
        try {
            if (str != null) {
                byte[] bytes = str.getBytes(C);
                this.f8061w.writeInt(bytes.length);
                this.f8061w.write(bytes);
            } else {
                this.f8061w.writeInt(-1);
            }
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void g1(IBinder iBinder) {
        if (!this.f8063y) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean i() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void i0(int i10) {
        a();
        b bVar = new b(i10, this.f8059u);
        this.f8062x = bVar;
        this.f8061w = bVar.f8067b;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void i1(IInterface iInterface) {
        if (!this.f8063y) {
            throw new RuntimeException("Binders cannot be written to an OutputStream");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void j0(boolean z10, boolean z11) {
        if (!z10) {
            throw new RuntimeException("Serialization of this object is not allowed");
        }
        this.f8063y = z11;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean l() {
        try {
            return this.f8060v.readBoolean();
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void m0(boolean z10) {
        try {
            this.f8061w.writeBoolean(z10);
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    public final void o1(int i10, String str, Bundle bundle) {
        switch (i10) {
            case 0:
                bundle.putParcelable(str, null);
                return;
            case 1:
                bundle.putBundle(str, p());
                return;
            case 2:
                bundle.putBundle(str, p());
                return;
            case 3:
                bundle.putString(str, c0());
                return;
            case 4:
                bundle.putStringArray(str, (String[]) j(new String[0]));
                return;
            case 5:
                bundle.putBoolean(str, l());
                return;
            case 6:
                bundle.putBooleanArray(str, n());
                return;
            case 7:
                bundle.putDouble(str, y());
                return;
            case 8:
                bundle.putDoubleArray(str, A());
                return;
            case 9:
                bundle.putInt(str, L());
                return;
            case 10:
                bundle.putIntArray(str, N());
                return;
            case 11:
                bundle.putLong(str, Q());
                return;
            case 12:
                bundle.putLongArray(str, S());
                return;
            case 13:
                bundle.putFloat(str, G());
                return;
            case 14:
                bundle.putFloatArray(str, I());
                return;
            default:
                throw new RuntimeException("Unknown type " + i10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle p() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (int i10 = 0; i10 < iL; i10++) {
            o1(L(), c0(), bundle);
        }
        return bundle;
    }

    public final void p1(Object obj) {
        if (obj == null) {
            L0(0);
            return;
        }
        if (obj instanceof Bundle) {
            L0(1);
            q0((Bundle) obj);
            return;
        }
        if (obj instanceof String) {
            L0(3);
            e1((String) obj);
            return;
        }
        if (obj instanceof String[]) {
            L0(4);
            k0((String[]) obj);
            return;
        }
        if (obj instanceof Boolean) {
            L0(5);
            m0(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof boolean[]) {
            L0(6);
            o0((boolean[]) obj);
            return;
        }
        if (obj instanceof Double) {
            L0(7);
            C0(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof double[]) {
            L0(8);
            E0((double[]) obj);
            return;
        }
        if (obj instanceof Integer) {
            L0(9);
            L0(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof int[]) {
            L0(10);
            N0((int[]) obj);
            return;
        }
        if (obj instanceof Long) {
            L0(11);
            Q0(((Long) obj).longValue());
            return;
        }
        if (obj instanceof long[]) {
            L0(12);
            S0((long[]) obj);
            return;
        }
        if (obj instanceof Float) {
            L0(13);
            H0(((Float) obj).floatValue());
        } else if (obj instanceof float[]) {
            L0(14);
            J0((float[]) obj);
        } else {
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void q0(Bundle bundle) {
        try {
            if (bundle == null) {
                this.f8061w.writeInt(-1);
                return;
            }
            Set<String> setKeySet = bundle.keySet();
            this.f8061w.writeInt(setKeySet.size());
            for (String str : setKeySet) {
                e1(str);
                p1(bundle.get(str));
            }
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] s() {
        try {
            int i10 = this.f8060v.readInt();
            if (i10 <= 0) {
                return null;
            }
            byte[] bArr = new byte[i10];
            this.f8060v.readFully(bArr);
            return bArr;
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void t0(byte[] bArr) {
        try {
            if (bArr != null) {
                this.f8061w.writeInt(bArr.length);
                this.f8061w.write(bArr);
            } else {
                this.f8061w.writeInt(-1);
            }
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence v() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void v0(byte[] bArr, int i10, int i11) {
        try {
            if (bArr != null) {
                this.f8061w.writeInt(i11);
                this.f8061w.write(bArr, i10, i11);
            } else {
                this.f8061w.writeInt(-1);
            }
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double y() {
        try {
            return this.f8060v.readDouble();
        } catch (IOException e10) {
            throw new VersionedParcel.ParcelException(e10);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y0(CharSequence charSequence) {
        if (!this.f8063y) {
            throw new RuntimeException("CharSequence cannot be written to an OutputStream");
        }
    }

    public a(InputStream inputStream, OutputStream outputStream, androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f8064z = 0;
        this.A = -1;
        this.B = -1;
        DataInputStream dataInputStream = inputStream != null ? new DataInputStream(new C0076a(inputStream)) : null;
        this.f8058t = dataInputStream;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.f8059u = dataOutputStream;
        this.f8060v = dataInputStream;
        this.f8061w = dataOutputStream;
    }

    /* JADX INFO: renamed from: androidx.versionedparcelable.a$a, reason: collision with other inner class name */
    public class C0076a extends FilterInputStream {
        public C0076a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            a aVar = a.this;
            int i10 = aVar.B;
            if (i10 != -1 && aVar.f8064z >= i10) {
                throw new IOException();
            }
            int i11 = super.read();
            a.this.f8064z++;
            return i11;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j10) throws IOException {
            a aVar = a.this;
            int i10 = aVar.B;
            if (i10 != -1 && aVar.f8064z >= i10) {
                throw new IOException();
            }
            long jSkip = super.skip(j10);
            if (jSkip > 0) {
                a.this.f8064z += (int) jSkip;
            }
            return jSkip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            a aVar = a.this;
            int i12 = aVar.B;
            if (i12 != -1 && aVar.f8064z >= i12) {
                throw new IOException();
            }
            int i13 = super.read(bArr, i10, i11);
            if (i13 > 0) {
                a.this.f8064z += i13;
            }
            return i13;
        }
    }
}
