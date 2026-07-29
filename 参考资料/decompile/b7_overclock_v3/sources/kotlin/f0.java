package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes5.dex */
public class f0 {
    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal a(BigDecimal bigDecimal) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(BigDecimal.ONE);
        kotlin.jvm.internal.f0.o(bigDecimalSubtract, "this.subtract(BigDecimal.ONE)");
        return bigDecimalSubtract;
    }

    @bk.f
    public static final BigDecimal b(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigDecimal bigDecimalDivide = bigDecimal.divide(other, RoundingMode.HALF_EVEN);
        kotlin.jvm.internal.f0.o(bigDecimalDivide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return bigDecimalDivide;
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal c(BigDecimal bigDecimal) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        BigDecimal bigDecimalAdd = bigDecimal.add(BigDecimal.ONE);
        kotlin.jvm.internal.f0.o(bigDecimalAdd, "this.add(BigDecimal.ONE)");
        return bigDecimalAdd;
    }

    @bk.f
    public static final BigDecimal d(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(other);
        kotlin.jvm.internal.f0.o(bigDecimalSubtract, "this.subtract(other)");
        return bigDecimalSubtract;
    }

    @bk.f
    public static final BigDecimal e(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigDecimal bigDecimalAdd = bigDecimal.add(other);
        kotlin.jvm.internal.f0.o(bigDecimalAdd, "this.add(other)");
        return bigDecimalAdd;
    }

    @bk.f
    public static final BigDecimal f(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigDecimal bigDecimalRemainder = bigDecimal.remainder(other);
        kotlin.jvm.internal.f0.o(bigDecimalRemainder, "this.remainder(other)");
        return bigDecimalRemainder;
    }

    @bk.f
    public static final BigDecimal g(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigDecimal bigDecimalMultiply = bigDecimal.multiply(other);
        kotlin.jvm.internal.f0.o(bigDecimalMultiply, "this.multiply(other)");
        return bigDecimalMultiply;
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal h(double d10) {
        return new BigDecimal(String.valueOf(d10));
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal i(double d10, MathContext mathContext) {
        kotlin.jvm.internal.f0.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(d10), mathContext);
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal j(float f10) {
        return new BigDecimal(String.valueOf(f10));
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal k(float f10, MathContext mathContext) {
        kotlin.jvm.internal.f0.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(f10), mathContext);
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal l(int i10) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(i10);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        return bigDecimalValueOf;
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal m(int i10, MathContext mathContext) {
        kotlin.jvm.internal.f0.p(mathContext, "mathContext");
        return new BigDecimal(i10, mathContext);
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal n(long j10) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(j10);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this)");
        return bigDecimalValueOf;
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal o(long j10, MathContext mathContext) {
        kotlin.jvm.internal.f0.p(mathContext, "mathContext");
        return new BigDecimal(j10, mathContext);
    }

    @bk.f
    public static final BigDecimal p(BigDecimal bigDecimal) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        BigDecimal bigDecimalNegate = bigDecimal.negate();
        kotlin.jvm.internal.f0.o(bigDecimalNegate, "this.negate()");
        return bigDecimalNegate;
    }
}
