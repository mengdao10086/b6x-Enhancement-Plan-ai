package a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class iu extends hu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Parcel f1408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseIntArray f1409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1410a;
    public final int b;
    public int c;
    public int d;
    public int e;

    public iu(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new ba(), new ba(), new ba());
    }

    public iu(Parcel parcel, int i, int i2, String str, ba<String, Method> baVar, ba<String, Method> baVar2, ba<String, Class> baVar3) {
        super(baVar, baVar2, baVar3);
        this.f1409a = new SparseIntArray();
        this.c = -1;
        this.d = 0;
        this.e = -1;
        this.f1408a = parcel;
        this.f6443a = i;
        this.b = i2;
        this.d = i;
        this.f1410a = str;
    }

    @Override // a.hu
    public void A(byte[] bArr) {
        if (bArr == null) {
            this.f1408a.writeInt(-1);
        } else {
            this.f1408a.writeInt(bArr.length);
            this.f1408a.writeByteArray(bArr);
        }
    }

    @Override // a.hu
    public void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f1408a, 0);
    }

    @Override // a.hu
    public void E(int i) {
        this.f1408a.writeInt(i);
    }

    @Override // a.hu
    public void G(Parcelable parcelable) {
        this.f1408a.writeParcelable(parcelable, 0);
    }

    @Override // a.hu
    public void I(String str) {
        this.f1408a.writeString(str);
    }

    @Override // a.hu
    public void a() {
        int i = this.c;
        if (i >= 0) {
            int i2 = this.f1409a.get(i);
            int iDataPosition = this.f1408a.dataPosition();
            this.f1408a.setDataPosition(i2);
            this.f1408a.writeInt(iDataPosition - i2);
            this.f1408a.setDataPosition(iDataPosition);
        }
    }

    @Override // a.hu
    public hu b() {
        Parcel parcel = this.f1408a;
        int iDataPosition = parcel.dataPosition();
        int i = this.d;
        if (i == this.f6443a) {
            i = this.b;
        }
        return new iu(parcel, iDataPosition, i, this.f1410a + "  ", ((hu) this).f6343a, super.b, super.c);
    }

    @Override // a.hu
    public boolean g() {
        return this.f1408a.readInt() != 0;
    }

    @Override // a.hu
    public byte[] i() {
        int i = this.f1408a.readInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f1408a.readByteArray(bArr);
        return bArr;
    }

    @Override // a.hu
    public CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f1408a);
    }

    @Override // a.hu
    public boolean m(int i) {
        while (this.d < this.b) {
            int i2 = this.e;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f1408a.setDataPosition(this.d);
            int i3 = this.f1408a.readInt();
            this.e = this.f1408a.readInt();
            this.d += i3;
        }
        return this.e == i;
    }

    @Override // a.hu
    public int o() {
        return this.f1408a.readInt();
    }

    @Override // a.hu
    public <T extends Parcelable> T q() {
        return (T) this.f1408a.readParcelable(iu.class.getClassLoader());
    }

    @Override // a.hu
    public String s() {
        return this.f1408a.readString();
    }

    @Override // a.hu
    public void w(int i) {
        a();
        this.c = i;
        this.f1409a.put(i, this.f1408a.dataPosition());
        E(0);
        E(i);
    }

    @Override // a.hu
    public void y(boolean z) {
        this.f1408a.writeInt(z ? 1 : 0);
    }
}
