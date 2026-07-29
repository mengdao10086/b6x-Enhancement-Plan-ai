package io.objectbox;

import ee.a;
import io.objectbox.converter.PropertyConverter;
import io.objectbox.exception.DbException;
import io.objectbox.query.PropertyQueryConditionImpl;
import io.objectbox.query.QueryBuilder;
import io.objectbox.query.y;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.annotation.Nullable;
import li.c;

/* JADX INFO: loaded from: classes5.dex */
public class Property<ENTITY> implements Serializable {
    private static final long serialVersionUID = 8613291105982758093L;
    public final Class<? extends PropertyConverter> converterClass;
    public final Class<?> customType;
    public final String dbName;
    public final EntityInfo<ENTITY> entity;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final int f32643id;
    private boolean idVerified;
    public final boolean isId;
    public final boolean isVirtual;
    public final String name;
    public final int ordinal;
    public final Class<?> type;

    public Property(EntityInfo<ENTITY> entityInfo, int i10, int i11, Class<?> cls, String str) {
        this(entityInfo, i10, i11, cls, str, false, str, null, null);
    }

    public y<ENTITY> A(boolean z10) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.EQUAL, z10);
    }

    public y<ENTITY> A0(String str, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.LESS_OR_EQUAL, str, stringOrder);
    }

    public y<ENTITY> B(byte[] bArr) {
        return new PropertyQueryConditionImpl.ByteArrayCondition(this, PropertyQueryConditionImpl.ByteArrayCondition.Operation.EQUAL, bArr);
    }

    public y<ENTITY> B0(Date date) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.LESS_OR_EQUAL, date);
    }

    @c
    public int C() {
        int i10 = this.f32643id;
        if (i10 > 0) {
            return i10;
        }
        throw new IllegalStateException("Illegal property ID " + this.f32643id + " for " + this);
    }

    public y<ENTITY> D(double d10) {
        return new PropertyQueryConditionImpl.DoubleCondition(this, PropertyQueryConditionImpl.DoubleCondition.Operation.GREATER, d10);
    }

    public y<ENTITY> D0(short s10) {
        return y0(s10);
    }

    public y<ENTITY> E(int i10) {
        return G(i10);
    }

    public y<ENTITY> E0(byte[] bArr) {
        return new PropertyQueryConditionImpl.ByteArrayCondition(this, PropertyQueryConditionImpl.ByteArrayCondition.Operation.LESS_OR_EQUAL, bArr);
    }

    @Deprecated
    public y<ENTITY> F0(Object obj) {
        if (obj instanceof Long) {
            return p0(((Long) obj).longValue());
        }
        if (obj instanceof Integer) {
            return o0(((Integer) obj).intValue());
        }
        if (obj instanceof Double) {
            return m0(((Double) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return m0(((Float) obj).floatValue());
        }
        throw new IllegalArgumentException("Only LONG, INTEGER, DOUBLE or FLOAT values are supported.");
    }

    public y<ENTITY> G(long j10) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.GREATER, j10);
    }

    @Deprecated
    public y<ENTITY> G0(Object obj) {
        if (obj instanceof Long) {
            return M0(((Long) obj).longValue());
        }
        if (obj instanceof Integer) {
            return K0(((Integer) obj).intValue());
        }
        if (obj instanceof String) {
            return N0((String) obj);
        }
        throw new IllegalArgumentException("Only LONG, INTEGER or STRING values are supported.");
    }

    public y<ENTITY> H(String str) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.GREATER, str);
    }

    public y<ENTITY> I(String str, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.GREATER, str, stringOrder);
    }

    public y<ENTITY> J(Date date) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.GREATER, date);
    }

    public y<ENTITY> K(short s10) {
        return G(s10);
    }

    public y<ENTITY> K0(int i10) {
        return M0(i10);
    }

    public y<ENTITY> L(byte[] bArr) {
        return new PropertyQueryConditionImpl.ByteArrayCondition(this, PropertyQueryConditionImpl.ByteArrayCondition.Operation.GREATER, bArr);
    }

    public y<ENTITY> M(double d10) {
        return new PropertyQueryConditionImpl.DoubleCondition(this, PropertyQueryConditionImpl.DoubleCondition.Operation.GREATER_OR_EQUAL, d10);
    }

    public y<ENTITY> M0(long j10) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.NOT_EQUAL, j10);
    }

    public y<ENTITY> N(int i10) {
        return O(i10);
    }

    public y<ENTITY> N0(String str) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.NOT_EQUAL, str);
    }

    public y<ENTITY> O(long j10) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.GREATER_OR_EQUAL, j10);
    }

    public y<ENTITY> O0(String str, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.NOT_EQUAL, str, stringOrder);
    }

    public y<ENTITY> P(String str, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.GREATER_OR_EQUAL, str, stringOrder);
    }

    public y<ENTITY> P0(Date date) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.NOT_EQUAL, date);
    }

    public y<ENTITY> Q(Date date) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.GREATER_OR_EQUAL, date);
    }

    public y<ENTITY> Q0(short s10) {
        return M0(s10);
    }

    public y<ENTITY> R(short s10) {
        return O(s10);
    }

    public y<ENTITY> R0(boolean z10) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.NOT_EQUAL, z10);
    }

    public y<ENTITY> S0() {
        return new PropertyQueryConditionImpl.NullCondition(this, PropertyQueryConditionImpl.NullCondition.Operation.NOT_NULL);
    }

    public y<ENTITY> T(byte[] bArr) {
        return new PropertyQueryConditionImpl.ByteArrayCondition(this, PropertyQueryConditionImpl.ByteArrayCondition.Operation.GREATER_OR_EQUAL, bArr);
    }

    public y<ENTITY> T0(int[] iArr) {
        return new PropertyQueryConditionImpl.IntArrayCondition(this, PropertyQueryConditionImpl.IntArrayCondition.Operation.NOT_IN, iArr);
    }

    @Deprecated
    public y<ENTITY> U(Object obj) {
        if (obj instanceof Long) {
            return G(((Long) obj).longValue());
        }
        if (obj instanceof Integer) {
            return E(((Integer) obj).intValue());
        }
        if (obj instanceof Double) {
            return D(((Double) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return D(((Float) obj).floatValue());
        }
        throw new IllegalArgumentException("Only LONG, INTEGER, DOUBLE or FLOAT values are supported.");
    }

    public y<ENTITY> U0(long[] jArr) {
        return new PropertyQueryConditionImpl.LongArrayCondition(this, PropertyQueryConditionImpl.LongArrayCondition.Operation.NOT_IN, jArr);
    }

    public y<ENTITY> V0(int[] iArr) {
        return new PropertyQueryConditionImpl.IntArrayCondition(this, PropertyQueryConditionImpl.IntArrayCondition.Operation.IN, iArr);
    }

    @Deprecated
    public y<ENTITY> W(Collection<?> collection) {
        return X(collection.toArray());
    }

    public y<ENTITY> W0(long[] jArr) {
        return new PropertyQueryConditionImpl.LongArrayCondition(this, PropertyQueryConditionImpl.LongArrayCondition.Operation.IN, jArr);
    }

    @Deprecated
    public y<ENTITY> X(Object... objArr) {
        int i10 = 0;
        if (objArr[0] instanceof Long) {
            long[] jArr = new long[objArr.length];
            while (i10 < objArr.length) {
                jArr[i10] = ((Long) objArr[i10]).longValue();
                i10++;
            }
            return W0(jArr);
        }
        if (!(objArr[0] instanceof Integer)) {
            throw new IllegalArgumentException("The IN condition only supports LONG or INTEGER values.");
        }
        int[] iArr = new int[objArr.length];
        while (i10 < objArr.length) {
            iArr[i10] = ((Integer) objArr[i10]).intValue();
            i10++;
        }
        return V0(iArr);
    }

    public y<ENTITY> X0(String[] strArr) {
        return new PropertyQueryConditionImpl.StringArrayCondition(this, PropertyQueryConditionImpl.StringArrayCondition.Operation.IN, strArr);
    }

    public y<ENTITY> Y0(String[] strArr, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringArrayCondition(this, PropertyQueryConditionImpl.StringArrayCondition.Operation.IN, strArr, stringOrder);
    }

    public boolean Z() {
        return this.idVerified;
    }

    public y<ENTITY> Z0(String str) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.STARTS_WITH, str);
    }

    public y<ENTITY> a(double d10, double d11) {
        return new PropertyQueryConditionImpl.DoubleDoubleCondition(this, PropertyQueryConditionImpl.DoubleDoubleCondition.Operation.BETWEEN, d10, d11);
    }

    public y<ENTITY> a1(String str, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.STARTS_WITH, str, stringOrder);
    }

    public y<ENTITY> b(int i10, int i11) {
        return c(i10, i11);
    }

    @Deprecated
    public y<ENTITY> b0() {
        return S0();
    }

    public void b1(int i10) {
        int i11 = this.f32643id;
        if (i11 <= 0) {
            throw new IllegalStateException("Illegal property ID " + this.f32643id + " for " + this);
        }
        if (i11 == i10) {
            this.idVerified = true;
            return;
        }
        throw new DbException(this + " does not match ID in DB: " + i10);
    }

    public y<ENTITY> c(long j10, long j11) {
        return new PropertyQueryConditionImpl.LongLongCondition(this, PropertyQueryConditionImpl.LongLongCondition.Operation.BETWEEN, j10, j11);
    }

    public y<ENTITY> d(Date date, Date date2) {
        return new PropertyQueryConditionImpl.LongLongCondition(this, PropertyQueryConditionImpl.LongLongCondition.Operation.BETWEEN, date, date2);
    }

    public y<ENTITY> f(short s10, short s11) {
        return c(s10, s11);
    }

    @c
    public int getEntityId() {
        return this.entity.getEntityId();
    }

    public final void h() {
        if (String[].class == this.type) {
            throw new IllegalArgumentException("For a String[] property use containsElement() instead.");
        }
    }

    public y<ENTITY> i(String str) {
        h();
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS, str);
    }

    public y<ENTITY> k(String str, QueryBuilder.StringOrder stringOrder) {
        h();
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS, str, stringOrder);
    }

    public y<ENTITY> l(String str) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS_ELEMENT, str);
    }

    public y<ENTITY> l0() {
        return new PropertyQueryConditionImpl.NullCondition(this, PropertyQueryConditionImpl.NullCondition.Operation.IS_NULL);
    }

    public y<ENTITY> m(String str, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS_ELEMENT, str, stringOrder);
    }

    public y<ENTITY> m0(double d10) {
        return new PropertyQueryConditionImpl.DoubleCondition(this, PropertyQueryConditionImpl.DoubleCondition.Operation.LESS, d10);
    }

    public y<ENTITY> n(String str, String str2) {
        return new PropertyQueryConditionImpl.StringStringCondition(this, PropertyQueryConditionImpl.StringStringCondition.Operation.CONTAINS_KEY_VALUE, str, str2, QueryBuilder.StringOrder.CASE_SENSITIVE);
    }

    public y<ENTITY> o(String str, String str2, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringStringCondition(this, PropertyQueryConditionImpl.StringStringCondition.Operation.CONTAINS_KEY_VALUE, str, str2, stringOrder);
    }

    public y<ENTITY> o0(int i10) {
        return p0(i10);
    }

    public y<ENTITY> p(String str) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.ENDS_WITH, str);
    }

    public y<ENTITY> p0(long j10) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.LESS, j10);
    }

    public y<ENTITY> q(String str, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.ENDS_WITH, str, stringOrder);
    }

    public y<ENTITY> q0(String str) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.LESS, str);
    }

    @Deprecated
    public y<ENTITY> r(Object obj) {
        if (obj instanceof Long) {
            return v(((Long) obj).longValue());
        }
        if (obj instanceof Integer) {
            return u(((Integer) obj).intValue());
        }
        if (obj instanceof String) {
            return w((String) obj);
        }
        throw new IllegalArgumentException("Only LONG, INTEGER or STRING values are supported.");
    }

    public y<ENTITY> r0(String str, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.LESS, str, stringOrder);
    }

    public y<ENTITY> t(double d10, double d11) {
        return new PropertyQueryConditionImpl.DoubleDoubleCondition(this, PropertyQueryConditionImpl.DoubleDoubleCondition.Operation.BETWEEN, d10 - d11, d10 + d11);
    }

    public y<ENTITY> t0(Date date) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.LESS, date);
    }

    public String toString() {
        return "Property \"" + this.name + "\" (ID: " + this.f32643id + a.f26979d;
    }

    public y<ENTITY> u(int i10) {
        return v(i10);
    }

    public y<ENTITY> u0(short s10) {
        return p0(s10);
    }

    public y<ENTITY> v(long j10) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.EQUAL, j10);
    }

    public y<ENTITY> v0(byte[] bArr) {
        return new PropertyQueryConditionImpl.ByteArrayCondition(this, PropertyQueryConditionImpl.ByteArrayCondition.Operation.LESS, bArr);
    }

    public y<ENTITY> w(String str) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.EQUAL, str);
    }

    public y<ENTITY> w0(double d10) {
        return new PropertyQueryConditionImpl.DoubleCondition(this, PropertyQueryConditionImpl.DoubleCondition.Operation.LESS_OR_EQUAL, d10);
    }

    public y<ENTITY> x(String str, QueryBuilder.StringOrder stringOrder) {
        return new PropertyQueryConditionImpl.StringCondition(this, PropertyQueryConditionImpl.StringCondition.Operation.EQUAL, str, stringOrder);
    }

    public y<ENTITY> x0(int i10) {
        return y0(i10);
    }

    public y<ENTITY> y(Date date) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.EQUAL, date);
    }

    public y<ENTITY> y0(long j10) {
        return new PropertyQueryConditionImpl.LongCondition(this, PropertyQueryConditionImpl.LongCondition.Operation.LESS_OR_EQUAL, j10);
    }

    public y<ENTITY> z(short s10) {
        return v(s10);
    }

    public Property(EntityInfo<ENTITY> entityInfo, int i10, int i11, Class<?> cls, String str, boolean z10) {
        this(entityInfo, i10, i11, cls, str, false, z10, str, null, null);
    }

    public Property(EntityInfo<ENTITY> entityInfo, int i10, int i11, Class<?> cls, String str, boolean z10, @Nullable String str2) {
        this(entityInfo, i10, i11, cls, str, z10, str2, null, null);
    }

    public Property(EntityInfo<ENTITY> entityInfo, int i10, int i11, Class<?> cls, String str, boolean z10, @Nullable String str2, @Nullable Class<? extends PropertyConverter> cls2, @Nullable Class<?> cls3) {
        this(entityInfo, i10, i11, cls, str, z10, false, str2, cls2, cls3);
    }

    public Property(EntityInfo<ENTITY> entityInfo, int i10, int i11, Class<?> cls, String str, boolean z10, boolean z11, @Nullable String str2, @Nullable Class<? extends PropertyConverter> cls2, @Nullable Class<?> cls3) {
        this.entity = entityInfo;
        this.ordinal = i10;
        this.f32643id = i11;
        this.type = cls;
        this.name = str;
        this.isId = z10;
        this.isVirtual = z11;
        this.dbName = str2;
        this.converterClass = cls2;
        this.customType = cls3;
    }
}
