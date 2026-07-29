package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements w3.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, k> f11896g = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f11897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f11898f;

    public k(m mVar, i iVar) {
        this.f11897e = mVar;
        this.f11898f = iVar;
    }

    public static k k() {
        return l(m.e(), i.k());
    }

    public static k l(@g.n0 m mVar, @g.n0 i iVar) {
        Objects.requireNonNull(mVar, "Argument 'cacheMemoryUtils' of type CacheMemoryUtils (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(iVar, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        String str = iVar.toString() + "_" + mVar.toString();
        Map<String, k> map = f11896g;
        k kVar = map.get(str);
        if (kVar == null) {
            synchronized (k.class) {
                kVar = map.get(str);
                if (kVar == null) {
                    kVar = new k(mVar, iVar);
                    map.put(str, kVar);
                }
            }
        }
        return kVar;
    }

    public void A(@g.n0 String str, Parcelable parcelable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        B(str, parcelable, -1);
    }

    public void B(@g.n0 String str, Parcelable parcelable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11897e.i(str, parcelable, i10);
        this.f11898f.F(str, parcelable, i10);
    }

    public void C(@g.n0 String str, Serializable serializable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        D(str, serializable, -1);
    }

    public void D(@g.n0 String str, Serializable serializable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11897e.i(str, serializable, i10);
        this.f11898f.H(str, serializable, i10);
    }

    public void E(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        F(str, str2, -1);
    }

    public void F(@g.n0 String str, String str2, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11897e.i(str, str2, i10);
        this.f11898f.J(str, str2, i10);
    }

    public void G(@g.n0 String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        H(str, jSONArray, -1);
    }

    public void H(@g.n0 String str, JSONArray jSONArray, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11897e.i(str, jSONArray, i10);
        this.f11898f.L(str, jSONArray, i10);
    }

    public void I(@g.n0 String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        J(str, jSONObject, -1);
    }

    public void J(@g.n0 String str, JSONObject jSONObject, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11897e.i(str, jSONObject, i10);
        this.f11898f.N(str, jSONObject, i10);
    }

    public void K(@g.n0 String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        L(str, bArr, -1);
    }

    public void L(@g.n0 String str, byte[] bArr, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11897e.i(str, bArr, i10);
        this.f11898f.P(str, bArr, i10);
    }

    public void M(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11897e.j(str);
        this.f11898f.T(str);
    }

    public void a() {
        this.f11897e.a();
        this.f11898f.a();
    }

    public Bitmap b(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return c(str, null);
    }

    public Bitmap c(@g.n0 String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Bitmap bitmap2 = (Bitmap) this.f11897e.b(str);
        return bitmap2 != null ? bitmap2 : this.f11898f.c(str, bitmap);
    }

    public byte[] d(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return e(str, null);
    }

    public byte[] e(@g.n0 String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] bArr2 = (byte[]) this.f11897e.b(str);
        return bArr2 != null ? bArr2 : this.f11898f.e(str, bArr);
    }

    public int f() {
        return this.f11898f.f();
    }

    public long g() {
        return this.f11898f.g();
    }

    public int h() {
        return this.f11897e.d();
    }

    public Drawable i(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return j(str, null);
    }

    public Drawable j(@g.n0 String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Drawable drawable2 = (Drawable) this.f11897e.b(str);
        return drawable2 != null ? drawable2 : this.f11898f.j(str, drawable);
    }

    public JSONArray m(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return n(str, null);
    }

    public JSONArray n(@g.n0 String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        JSONArray jSONArray2 = (JSONArray) this.f11897e.b(str);
        return jSONArray2 != null ? jSONArray2 : this.f11898f.r(str, jSONArray);
    }

    public JSONObject o(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return p(str, null);
    }

    public JSONObject p(@g.n0 String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        JSONObject jSONObject2 = (JSONObject) this.f11897e.b(str);
        return jSONObject2 != null ? jSONObject2 : this.f11898f.t(str, jSONObject);
    }

    public <T> T q(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (T) r(str, creator, null);
    }

    public <T> T r(@g.n0 String str, @g.n0 Parcelable.Creator<T> creator, T t10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        T t11 = (T) this.f11897e.b(str);
        return t11 != null ? t11 : (T) this.f11898f.v(str, creator, t10);
    }

    public Object s(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return t(str, null);
    }

    public Object t(@g.n0 String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Object objB = this.f11897e.b(str);
        return objB != null ? objB : this.f11898f.x(str, obj);
    }

    public String u(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return v(str, null);
    }

    public String v(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        String str3 = (String) this.f11897e.b(str);
        return str3 != null ? str3 : this.f11898f.z(str, str2);
    }

    public void w(@g.n0 String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        x(str, bitmap, -1);
    }

    public void x(@g.n0 String str, Bitmap bitmap, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11897e.i(str, bitmap, i10);
        this.f11898f.B(str, bitmap, i10);
    }

    public void y(@g.n0 String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        z(str, drawable, -1);
    }

    public void z(@g.n0 String str, Drawable drawable, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f11897e.i(str, drawable, i10);
        this.f11898f.D(str, drawable, i10);
    }
}
