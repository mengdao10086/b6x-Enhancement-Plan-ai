package androidx.work.multiprocess.parcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.work.d;
import g.n0;
import g.p0;
import java.util.HashMap;
import java.util.Map;
import x2.b;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableData implements Parcelable {
    public static final Parcelable.Creator<ParcelableData> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f8707b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f8708c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f8709d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f8710e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f8711f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f8712g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f8713h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f8714i = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte f8715j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte f8716k = 9;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte f8717l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte f8718m = 11;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte f8719n = 12;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte f8720o = 13;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte f8721p = 14;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8722a;

    public class a implements Parcelable.Creator<ParcelableData> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableData createFromParcel(@n0 Parcel parcel) {
            return new ParcelableData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableData[] newArray(int i10) {
            return new ParcelableData[i10];
        }
    }

    public ParcelableData(@n0 d dVar) {
        this.f8722a = dVar;
    }

    public final void a(@n0 Parcel parcel, @n0 Map<String, Object> map) {
        Object objValueOf;
        byte b10 = parcel.readByte();
        switch (b10) {
            case 0:
                objValueOf = null;
                break;
            case 1:
                objValueOf = Boolean.valueOf(b.a(parcel));
                break;
            case 2:
                objValueOf = Byte.valueOf(parcel.readByte());
                break;
            case 3:
                objValueOf = Integer.valueOf(parcel.readInt());
                break;
            case 4:
                objValueOf = Long.valueOf(parcel.readLong());
                break;
            case 5:
                objValueOf = Float.valueOf(parcel.readFloat());
                break;
            case 6:
                objValueOf = Double.valueOf(parcel.readDouble());
                break;
            case 7:
                objValueOf = parcel.readString();
                break;
            case 8:
                objValueOf = d.a(parcel.createBooleanArray());
                break;
            case 9:
                objValueOf = d.b(parcel.createByteArray());
                break;
            case 10:
                objValueOf = d.e(parcel.createIntArray());
                break;
            case 11:
                objValueOf = d.f(parcel.createLongArray());
                break;
            case 12:
                objValueOf = d.d(parcel.createFloatArray());
                break;
            case 13:
                objValueOf = d.c(parcel.createDoubleArray());
                break;
            case 14:
                objValueOf = parcel.createStringArray();
                break;
            default:
                throw new IllegalStateException(String.format("Unsupported type %s", Integer.valueOf(b10)));
        }
        map.put(parcel.readString(), objValueOf);
    }

    @n0
    public d b() {
        return this.f8722a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(@n0 Parcel parcel, @n0 String str, @p0 Object obj) {
        if (obj == null) {
            parcel.writeByte((byte) 0);
        } else {
            Class<?> cls = obj.getClass();
            if (cls == Boolean.class) {
                parcel.writeByte((byte) 1);
                b.b(parcel, ((Boolean) obj).booleanValue());
            } else if (cls == Byte.class) {
                parcel.writeByte((byte) 2);
                parcel.writeByte(((Byte) obj).byteValue());
            } else if (cls == Integer.class) {
                parcel.writeByte((byte) 3);
                parcel.writeInt(((Integer) obj).intValue());
            } else if (cls == Long.class) {
                parcel.writeByte((byte) 4);
                parcel.writeLong(((Long) obj).longValue());
            } else if (cls == Float.class) {
                parcel.writeByte((byte) 5);
                parcel.writeFloat(((Float) obj).floatValue());
            } else if (cls == Double.class) {
                parcel.writeByte((byte) 6);
                parcel.writeDouble(((Double) obj).doubleValue());
            } else if (cls == String.class) {
                parcel.writeByte((byte) 7);
                parcel.writeString((String) obj);
            } else if (cls == Boolean[].class) {
                parcel.writeByte((byte) 8);
                parcel.writeBooleanArray(d.l((Boolean[]) obj));
            } else if (cls == Byte[].class) {
                parcel.writeByte((byte) 9);
                parcel.writeByteArray(d.g((Byte[]) obj));
            } else if (cls == Integer[].class) {
                parcel.writeByte((byte) 10);
                parcel.writeIntArray(d.j((Integer[]) obj));
            } else if (cls == Long[].class) {
                parcel.writeByte((byte) 11);
                parcel.writeLongArray(d.k((Long[]) obj));
            } else if (cls == Float[].class) {
                parcel.writeByte((byte) 12);
                parcel.writeFloatArray(d.i((Float[]) obj));
            } else if (cls == Double[].class) {
                parcel.writeByte((byte) 13);
                parcel.writeDoubleArray(d.h((Double[]) obj));
            } else {
                if (cls != String[].class) {
                    throw new IllegalArgumentException(String.format("Unsupported value type %s", cls.getName()));
                }
                parcel.writeByte((byte) 14);
                parcel.writeStringArray((String[]) obj);
            }
        }
        parcel.writeString(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@n0 Parcel parcel, int i10) {
        Map<String, Object> mapX = this.f8722a.x();
        parcel.writeInt(mapX.size());
        for (Map.Entry<String, Object> entry : mapX.entrySet()) {
            e(parcel, entry.getKey(), entry.getValue());
        }
    }

    public ParcelableData(@n0 Parcel parcel) {
        HashMap map = new HashMap();
        int i10 = parcel.readInt();
        for (int i11 = 0; i11 < i10; i11++) {
            a(parcel, map);
        }
        this.f8722a = new d(map);
    }
}
