package i2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;
import com.bumptech.glide.load.engine.GlideException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class d extends VersionedParcel {
    public static final boolean B = false;
    public static final String C = "VersionedParcelParcel";
    public int A;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SparseIntArray f31805t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Parcel f31806u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f31807v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f31808w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f31809x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f31810y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f31811z;

    public d(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void C0(double d10) {
        this.f31806u.writeDouble(d10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean F(int i10) {
        while (this.f31811z < this.f31808w) {
            int i11 = this.A;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f31806u.setDataPosition(this.f31811z);
            int i12 = this.f31806u.readInt();
            this.A = this.f31806u.readInt();
            this.f31811z += i12;
        }
        return this.A == i10;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float G() {
        return this.f31806u.readFloat();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void H0(float f10) {
        this.f31806u.writeFloat(f10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int L() {
        return this.f31806u.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void L0(int i10) {
        this.f31806u.writeInt(i10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long Q() {
        return this.f31806u.readLong();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void Q0(long j10) {
        this.f31806u.writeLong(j10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T V() {
        return (T) this.f31806u.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void W0(Parcelable parcelable) {
        this.f31806u.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i10 = this.f31810y;
        if (i10 >= 0) {
            int i11 = this.f31805t.get(i10);
            int iDataPosition = this.f31806u.dataPosition();
            this.f31806u.setDataPosition(i11);
            this.f31806u.writeInt(iDataPosition - i11);
            this.f31806u.setDataPosition(iDataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel c() {
        Parcel parcel = this.f31806u;
        int iDataPosition = parcel.dataPosition();
        int i10 = this.f31811z;
        if (i10 == this.f31807v) {
            i10 = this.f31808w;
        }
        return new d(parcel, iDataPosition, i10, this.f31809x + GlideException.a.f12263d, this.f8054a, this.f8055b, this.f8056c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String c0() {
        return this.f31806u.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder e0() {
        return this.f31806u.readStrongBinder();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void e1(String str) {
        this.f31806u.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void g1(IBinder iBinder) {
        this.f31806u.writeStrongBinder(iBinder);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void i0(int i10) {
        a();
        this.f31810y = i10;
        this.f31805t.put(i10, this.f31806u.dataPosition());
        L0(0);
        L0(i10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void i1(IInterface iInterface) {
        this.f31806u.writeStrongInterface(iInterface);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean l() {
        return this.f31806u.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void m0(boolean z10) {
        this.f31806u.writeInt(z10 ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle p() {
        return this.f31806u.readBundle(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void q0(Bundle bundle) {
        this.f31806u.writeBundle(bundle);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] s() {
        int i10 = this.f31806u.readInt();
        if (i10 < 0) {
            return null;
        }
        byte[] bArr = new byte[i10];
        this.f31806u.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void t0(byte[] bArr) {
        if (bArr == null) {
            this.f31806u.writeInt(-1);
        } else {
            this.f31806u.writeInt(bArr.length);
            this.f31806u.writeByteArray(bArr);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence v() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f31806u);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void v0(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            this.f31806u.writeInt(-1);
        } else {
            this.f31806u.writeInt(bArr.length);
            this.f31806u.writeByteArray(bArr, i10, i11);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double y() {
        return this.f31806u.readDouble();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y0(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f31806u, 0);
    }

    public d(Parcel parcel, int i10, int i11, String str, androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f31805t = new SparseIntArray();
        this.f31810y = -1;
        this.A = -1;
        this.f31806u = parcel;
        this.f31807v = i10;
        this.f31808w = i11;
        this.f31811z = i10;
        this.f31809x = str;
    }
}
