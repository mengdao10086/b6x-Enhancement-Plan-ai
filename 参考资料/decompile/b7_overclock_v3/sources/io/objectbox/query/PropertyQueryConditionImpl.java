package io.objectbox.query;

import io.objectbox.Property;
import io.objectbox.query.QueryBuilder;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PropertyQueryConditionImpl<T> extends i0<T> implements y<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Property<T> f32793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f32794b;

    public static class ByteArrayCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f32796d;

        public enum Operation {
            EQUAL,
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL
        }

        public ByteArrayCondition(Property<T> property, Operation operation, byte[] bArr) {
            super(property);
            this.f32795c = operation;
            this.f32796d = bArr;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            int i10 = a.f32828g[this.f32795c.ordinal()];
            if (i10 == 1) {
                queryBuilder.v(this.f32793a, this.f32796d);
                return;
            }
            if (i10 == 2) {
                queryBuilder.B(this.f32793a, this.f32796d);
                return;
            }
            if (i10 == 3) {
                queryBuilder.G(this.f32793a, this.f32796d);
                return;
            }
            if (i10 == 4) {
                queryBuilder.S(this.f32793a, this.f32796d);
            } else {
                if (i10 == 5) {
                    queryBuilder.X(this.f32793a, this.f32796d);
                    return;
                }
                throw new UnsupportedOperationException(this.f32795c + " is not supported for byte[]");
            }
        }
    }

    public static class DoubleCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f32798d;

        public enum Operation {
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL
        }

        public DoubleCondition(Property<T> property, Operation operation, double d10) {
            super(property);
            this.f32797c = operation;
            this.f32798d = d10;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            int i10 = a.f32826e[this.f32797c.ordinal()];
            if (i10 == 1) {
                queryBuilder.x(this.f32793a, this.f32798d);
                return;
            }
            if (i10 == 2) {
                queryBuilder.C(this.f32793a, this.f32798d);
                return;
            }
            if (i10 == 3) {
                queryBuilder.O(this.f32793a, this.f32798d);
            } else {
                if (i10 == 4) {
                    queryBuilder.T(this.f32793a, this.f32798d);
                    return;
                }
                throw new UnsupportedOperationException(this.f32797c + " is not supported for double");
            }
        }
    }

    public static class DoubleDoubleCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32799c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f32800d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double f32801e;

        public enum Operation {
            BETWEEN
        }

        public DoubleDoubleCondition(Property<T> property, Operation operation, double d10, double d11) {
            super(property);
            this.f32799c = operation;
            this.f32800d = d10;
            this.f32801e = d11;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            if (this.f32799c == Operation.BETWEEN) {
                queryBuilder.d(this.f32793a, this.f32800d, this.f32801e);
                return;
            }
            throw new UnsupportedOperationException(this.f32799c + " is not supported with two double values");
        }
    }

    public static class IntArrayCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f32803d;

        public enum Operation {
            IN,
            NOT_IN
        }

        public IntArrayCondition(Property<T> property, Operation operation, int[] iArr) {
            super(property);
            this.f32802c = operation;
            this.f32803d = iArr;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            int i10 = a.f32823b[this.f32802c.ordinal()];
            if (i10 == 1) {
                queryBuilder.H(this.f32793a, this.f32803d);
            } else {
                if (i10 == 2) {
                    queryBuilder.e0(this.f32793a, this.f32803d);
                    return;
                }
                throw new UnsupportedOperationException(this.f32802c + " is not supported for int[]");
            }
        }
    }

    public static class LongArrayCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f32805d;

        public enum Operation {
            IN,
            NOT_IN
        }

        public LongArrayCondition(Property<T> property, Operation operation, long[] jArr) {
            super(property);
            this.f32804c = operation;
            this.f32805d = jArr;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            int i10 = a.f32825d[this.f32804c.ordinal()];
            if (i10 == 1) {
                queryBuilder.I(this.f32793a, this.f32805d);
            } else {
                if (i10 == 2) {
                    queryBuilder.f0(this.f32793a, this.f32805d);
                    return;
                }
                throw new UnsupportedOperationException(this.f32804c + " is not supported for long[]");
            }
        }
    }

    public static class NullCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32811c;

        public enum Operation {
            IS_NULL,
            NOT_NULL
        }

        public NullCondition(Property<T> property, Operation operation) {
            super(property);
            this.f32811c = operation;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            int i10 = a.f32822a[this.f32811c.ordinal()];
            if (i10 == 1) {
                queryBuilder.N(this.f32793a);
            } else {
                if (i10 == 2) {
                    queryBuilder.g0(this.f32793a);
                    return;
                }
                throw new UnsupportedOperationException(this.f32811c + " is not supported");
            }
        }
    }

    public static class StringStringCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f32819d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f32820e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final QueryBuilder.StringOrder f32821f;

        public enum Operation {
            CONTAINS_KEY_VALUE
        }

        public StringStringCondition(Property<T> property, Operation operation, String str, String str2, QueryBuilder.StringOrder stringOrder) {
            super(property);
            this.f32818c = operation;
            this.f32819d = str;
            this.f32820e = str2;
            this.f32821f = stringOrder;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            if (this.f32818c == Operation.CONTAINS_KEY_VALUE) {
                queryBuilder.m(this.f32793a, this.f32819d, this.f32820e, this.f32821f);
                return;
            }
            throw new UnsupportedOperationException(this.f32818c + " is not supported with two String values");
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f32823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f32824c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f32825d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int[] f32826e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int[] f32827f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int[] f32828g;

        static {
            int[] iArr = new int[ByteArrayCondition.Operation.values().length];
            f32828g = iArr;
            try {
                iArr[ByteArrayCondition.Operation.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32828g[ByteArrayCondition.Operation.GREATER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32828g[ByteArrayCondition.Operation.GREATER_OR_EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32828g[ByteArrayCondition.Operation.LESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32828g[ByteArrayCondition.Operation.LESS_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[StringCondition.Operation.values().length];
            f32827f = iArr2;
            try {
                iArr2[StringCondition.Operation.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32827f[StringCondition.Operation.NOT_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32827f[StringCondition.Operation.GREATER.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f32827f[StringCondition.Operation.GREATER_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f32827f[StringCondition.Operation.LESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f32827f[StringCondition.Operation.LESS_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f32827f[StringCondition.Operation.CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f32827f[StringCondition.Operation.CONTAINS_ELEMENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f32827f[StringCondition.Operation.STARTS_WITH.ordinal()] = 9;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f32827f[StringCondition.Operation.ENDS_WITH.ordinal()] = 10;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr3 = new int[DoubleCondition.Operation.values().length];
            f32826e = iArr3;
            try {
                iArr3[DoubleCondition.Operation.GREATER.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f32826e[DoubleCondition.Operation.GREATER_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f32826e[DoubleCondition.Operation.LESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f32826e[DoubleCondition.Operation.LESS_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            int[] iArr4 = new int[LongArrayCondition.Operation.values().length];
            f32825d = iArr4;
            try {
                iArr4[LongArrayCondition.Operation.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f32825d[LongArrayCondition.Operation.NOT_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused21) {
            }
            int[] iArr5 = new int[LongCondition.Operation.values().length];
            f32824c = iArr5;
            try {
                iArr5[LongCondition.Operation.EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f32824c[LongCondition.Operation.NOT_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f32824c[LongCondition.Operation.GREATER.ordinal()] = 3;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f32824c[LongCondition.Operation.GREATER_OR_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f32824c[LongCondition.Operation.LESS.ordinal()] = 5;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f32824c[LongCondition.Operation.LESS_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused27) {
            }
            int[] iArr6 = new int[IntArrayCondition.Operation.values().length];
            f32823b = iArr6;
            try {
                iArr6[IntArrayCondition.Operation.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f32823b[IntArrayCondition.Operation.NOT_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused29) {
            }
            int[] iArr7 = new int[NullCondition.Operation.values().length];
            f32822a = iArr7;
            try {
                iArr7[NullCondition.Operation.IS_NULL.ordinal()] = 1;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f32822a[NullCondition.Operation.NOT_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused31) {
            }
        }
    }

    public PropertyQueryConditionImpl(Property<T> property) {
        this.f32793a = property;
    }

    @Override // io.objectbox.query.i0, io.objectbox.query.h0
    public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
        return super.a(h0Var);
    }

    @Override // io.objectbox.query.i0, io.objectbox.query.h0
    public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
        return super.b(h0Var);
    }

    @Override // io.objectbox.query.y
    public h0<T> c(String str) {
        this.f32794b = str;
        return this;
    }

    @Override // io.objectbox.query.i0
    public void d(QueryBuilder<T> queryBuilder) {
        e(queryBuilder);
        String str = this.f32794b;
        if (str == null || str.length() == 0) {
            return;
        }
        queryBuilder.l0(this.f32794b);
    }

    public abstract void e(QueryBuilder<T> queryBuilder);

    public static class LongCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f32807d;

        public enum Operation {
            EQUAL,
            NOT_EQUAL,
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL
        }

        public LongCondition(Property<T> property, Operation operation, long j10) {
            super(property);
            this.f32806c = operation;
            this.f32807d = j10;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            switch (a.f32824c[this.f32806c.ordinal()]) {
                case 1:
                    queryBuilder.r(this.f32793a, this.f32807d);
                    return;
                case 2:
                    queryBuilder.a0(this.f32793a, this.f32807d);
                    return;
                case 3:
                    queryBuilder.y(this.f32793a, this.f32807d);
                    return;
                case 4:
                    queryBuilder.D(this.f32793a, this.f32807d);
                    return;
                case 5:
                    queryBuilder.P(this.f32793a, this.f32807d);
                    return;
                case 6:
                    queryBuilder.U(this.f32793a, this.f32807d);
                    return;
                default:
                    throw new UnsupportedOperationException(this.f32806c + " is not supported for String");
            }
        }

        public LongCondition(Property<T> property, Operation operation, boolean z10) {
            this(property, operation, z10 ? 1L : 0L);
        }

        public LongCondition(Property<T> property, Operation operation, Date date) {
            this(property, operation, date.getTime());
        }
    }

    public static class LongLongCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f32809d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f32810e;

        public enum Operation {
            BETWEEN
        }

        public LongLongCondition(Property<T> property, Operation operation, long j10, long j11) {
            super(property);
            this.f32808c = operation;
            this.f32809d = j10;
            this.f32810e = j11;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            if (this.f32808c == Operation.BETWEEN) {
                queryBuilder.e(this.f32793a, this.f32809d, this.f32810e);
                return;
            }
            throw new UnsupportedOperationException(this.f32808c + " is not supported with two long values");
        }

        public LongLongCondition(Property<T> property, Operation operation, Date date, Date date2) {
            this(property, operation, date.getTime(), date2.getTime());
        }
    }

    public static class StringArrayCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String[] f32813d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final QueryBuilder.StringOrder f32814e;

        public enum Operation {
            IN
        }

        public StringArrayCondition(Property<T> property, Operation operation, String[] strArr, QueryBuilder.StringOrder stringOrder) {
            super(property);
            this.f32812c = operation;
            this.f32813d = strArr;
            this.f32814e = stringOrder;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            if (this.f32812c == Operation.IN) {
                queryBuilder.J(this.f32793a, this.f32813d, this.f32814e);
                return;
            }
            throw new UnsupportedOperationException(this.f32812c + " is not supported for String[]");
        }

        public StringArrayCondition(Property<T> property, Operation operation, String[] strArr) {
            this(property, operation, strArr, QueryBuilder.StringOrder.CASE_SENSITIVE);
        }
    }

    public static class StringCondition<T> extends PropertyQueryConditionImpl<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Operation f32815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f32816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final QueryBuilder.StringOrder f32817e;

        public enum Operation {
            EQUAL,
            NOT_EQUAL,
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL,
            CONTAINS,
            CONTAINS_ELEMENT,
            STARTS_WITH,
            ENDS_WITH
        }

        public StringCondition(Property<T> property, Operation operation, String str, QueryBuilder.StringOrder stringOrder) {
            super(property);
            this.f32815c = operation;
            this.f32816d = str;
            this.f32817e = stringOrder;
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 a(h0 h0Var) {
            return super.a(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl, io.objectbox.query.i0, io.objectbox.query.h0
        public /* bridge */ /* synthetic */ h0 b(h0 h0Var) {
            return super.b(h0Var);
        }

        @Override // io.objectbox.query.PropertyQueryConditionImpl
        public void e(QueryBuilder<T> queryBuilder) {
            switch (a.f32827f[this.f32815c.ordinal()]) {
                case 1:
                    queryBuilder.s(this.f32793a, this.f32816d, this.f32817e);
                    return;
                case 2:
                    queryBuilder.b0(this.f32793a, this.f32816d, this.f32817e);
                    return;
                case 3:
                    queryBuilder.z(this.f32793a, this.f32816d, this.f32817e);
                    return;
                case 4:
                    queryBuilder.E(this.f32793a, this.f32816d, this.f32817e);
                    return;
                case 5:
                    queryBuilder.Q(this.f32793a, this.f32816d, this.f32817e);
                    return;
                case 6:
                    queryBuilder.V(this.f32793a, this.f32816d, this.f32817e);
                    return;
                case 7:
                    queryBuilder.k(this.f32793a, this.f32816d, this.f32817e);
                    return;
                case 8:
                    queryBuilder.l(this.f32793a, this.f32816d, this.f32817e);
                    return;
                case 9:
                    queryBuilder.n0(this.f32793a, this.f32816d, this.f32817e);
                    return;
                case 10:
                    queryBuilder.p(this.f32793a, this.f32816d, this.f32817e);
                    return;
                default:
                    throw new UnsupportedOperationException(this.f32815c + " is not supported for String");
            }
        }

        public StringCondition(Property<T> property, Operation operation, String str) {
            this(property, operation, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        }
    }
}
