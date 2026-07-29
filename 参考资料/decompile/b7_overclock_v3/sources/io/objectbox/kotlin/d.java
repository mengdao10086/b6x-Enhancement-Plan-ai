package io.objectbox.kotlin;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import io.objectbox.Property;
import io.objectbox.query.y;
import java.util.Date;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import m0.k;
import xf.j;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004\u001a'\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\u0004\u001a'\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\u0004\u001a'\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\u0004\u001a'\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\u0004\u001a'\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\fH\u0086\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\fH\u0086\u0004\u001a'\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\fH\u0086\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\fH\u0086\u0004\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0011H\u0086\u0004\u001a'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0011H\u0086\u0004\u001a'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0014H\u0086\u0004\u001a'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0014H\u0086\u0004\u001a'\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0014H\u0086\u0004\u001a'\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0014H\u0086\u0004\u001a'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0019H\u0086\u0004\u001a'\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0019H\u0086\u0004\u001a'\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u001cH\u0086\u0004\u001a'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u001cH\u0086\u0004\u001a'\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u001fH\u0086\u0004\u001a'\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u001fH\u0086\u0004\u001a'\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u001fH\u0086\u0004\u001a'\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u001fH\u0086\u0004\u001a'\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020$H\u0086\u0004\u001a'\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020$H\u0086\u0004\u001a'\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020$H\u0086\u0004\u001a'\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020$H\u0086\u0004\u001a'\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020$H\u0086\u0004\u001a'\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020$H\u0086\u0004\u001a'\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020$H\u0086\u0004\u001a4\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020$0,H\u0086\u0004¢\u0006\u0004\b-\u0010.\u001a'\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020/H\u0086\u0004\u001a'\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020/H\u0086\u0004\u001a'\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020/H\u0086\u0004¨\u00063"}, d2 = {i1.a.f31577d5, "Lio/objectbox/Property;", "", "value", "Lio/objectbox/query/y;", "h", "C", "", "g", "B", "o", "v", "", "c", "x", "k", SsManifestParser.e.J, "", "F", "D", "", "d", "y", l.f16298a, an.aB, "", "G", i1.a.S4, "", j.f55230b, "q", "Ljava/util/Date;", "f", i1.a.W4, "n", "u", "", "e", an.aD, k.f40564b, "t", "a", "I", "b", "", "H", "(Lio/objectbox/Property;[Ljava/lang/String;)Lio/objectbox/query/y;", "", "i", "p", "w", "objectbox-kotlin"}, k = 2, mv = {1, 7, 1})
public final class d {
    @yt.k
    public static final <T> y<T> A(@yt.k Property<T> property, @yt.k Date value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarP0 = property.P0(value);
        f0.o(yVarP0, "notEqual(value)");
        return yVarP0;
    }

    @yt.k
    public static final <T> y<T> B(@yt.k Property<T> property, short s10) {
        f0.p(property, "<this>");
        y<T> yVarQ0 = property.Q0(s10);
        f0.o(yVarQ0, "notEqual(value)");
        return yVarQ0;
    }

    @yt.k
    public static final <T> y<T> C(@yt.k Property<T> property, boolean z10) {
        f0.p(property, "<this>");
        y<T> yVarR0 = property.R0(z10);
        f0.o(yVarR0, "notEqual(value)");
        return yVarR0;
    }

    @yt.k
    public static final <T> y<T> D(@yt.k Property<T> property, @yt.k int[] value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarT0 = property.T0(value);
        f0.o(yVarT0, "notOneOf(value)");
        return yVarT0;
    }

    @yt.k
    public static final <T> y<T> E(@yt.k Property<T> property, @yt.k long[] value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarU0 = property.U0(value);
        f0.o(yVarU0, "notOneOf(value)");
        return yVarU0;
    }

    @yt.k
    public static final <T> y<T> F(@yt.k Property<T> property, @yt.k int[] value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarV0 = property.V0(value);
        f0.o(yVarV0, "oneOf(value)");
        return yVarV0;
    }

    @yt.k
    public static final <T> y<T> G(@yt.k Property<T> property, @yt.k long[] value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarW0 = property.W0(value);
        f0.o(yVarW0, "oneOf(value)");
        return yVarW0;
    }

    @yt.k
    public static final <T> y<T> H(@yt.k Property<T> property, @yt.k String[] value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarX0 = property.X0(value);
        f0.o(yVarX0, "oneOf(value)");
        return yVarX0;
    }

    @yt.k
    public static final <T> y<T> I(@yt.k Property<T> property, @yt.k String value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarZ0 = property.Z0(value);
        f0.o(yVarZ0, "startsWith(value)");
        return yVarZ0;
    }

    @yt.k
    public static final <T> y<T> a(@yt.k Property<T> property, @yt.k String value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarI = property.i(value);
        f0.o(yVarI, "contains(value)");
        return yVarI;
    }

    @yt.k
    public static final <T> y<T> b(@yt.k Property<T> property, @yt.k String value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarP = property.p(value);
        f0.o(yVarP, "endsWith(value)");
        return yVarP;
    }

    @yt.k
    public static final <T> y<T> c(@yt.k Property<T> property, int i10) {
        f0.p(property, "<this>");
        y<T> yVarU = property.u(i10);
        f0.o(yVarU, "equal(value)");
        return yVarU;
    }

    @yt.k
    public static final <T> y<T> d(@yt.k Property<T> property, long j10) {
        f0.p(property, "<this>");
        y<T> yVarV = property.v(j10);
        f0.o(yVarV, "equal(value)");
        return yVarV;
    }

    @yt.k
    public static final <T> y<T> e(@yt.k Property<T> property, @yt.k String value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarW = property.w(value);
        f0.o(yVarW, "equal(value)");
        return yVarW;
    }

    @yt.k
    public static final <T> y<T> f(@yt.k Property<T> property, @yt.k Date value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarY = property.y(value);
        f0.o(yVarY, "equal(value)");
        return yVarY;
    }

    @yt.k
    public static final <T> y<T> g(@yt.k Property<T> property, short s10) {
        f0.p(property, "<this>");
        y<T> yVarZ = property.z(s10);
        f0.o(yVarZ, "equal(value)");
        return yVarZ;
    }

    @yt.k
    public static final <T> y<T> h(@yt.k Property<T> property, boolean z10) {
        f0.p(property, "<this>");
        y<T> yVarA = property.A(z10);
        f0.o(yVarA, "equal(value)");
        return yVarA;
    }

    @yt.k
    public static final <T> y<T> i(@yt.k Property<T> property, @yt.k byte[] value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarB = property.B(value);
        f0.o(yVarB, "equal(value)");
        return yVarB;
    }

    @yt.k
    public static final <T> y<T> j(@yt.k Property<T> property, double d10) {
        f0.p(property, "<this>");
        y<T> yVarD = property.D(d10);
        f0.o(yVarD, "greater(value)");
        return yVarD;
    }

    @yt.k
    public static final <T> y<T> k(@yt.k Property<T> property, int i10) {
        f0.p(property, "<this>");
        y<T> yVarE = property.E(i10);
        f0.o(yVarE, "greater(value)");
        return yVarE;
    }

    @yt.k
    public static final <T> y<T> l(@yt.k Property<T> property, long j10) {
        f0.p(property, "<this>");
        y<T> yVarG = property.G(j10);
        f0.o(yVarG, "greater(value)");
        return yVarG;
    }

    @yt.k
    public static final <T> y<T> m(@yt.k Property<T> property, @yt.k String value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarH = property.H(value);
        f0.o(yVarH, "greater(value)");
        return yVarH;
    }

    @yt.k
    public static final <T> y<T> n(@yt.k Property<T> property, @yt.k Date value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarJ = property.J(value);
        f0.o(yVarJ, "greater(value)");
        return yVarJ;
    }

    @yt.k
    public static final <T> y<T> o(@yt.k Property<T> property, short s10) {
        f0.p(property, "<this>");
        y<T> yVarK = property.K(s10);
        f0.o(yVarK, "greater(value)");
        return yVarK;
    }

    @yt.k
    public static final <T> y<T> p(@yt.k Property<T> property, @yt.k byte[] value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarL = property.L(value);
        f0.o(yVarL, "greater(value)");
        return yVarL;
    }

    @yt.k
    public static final <T> y<T> q(@yt.k Property<T> property, double d10) {
        f0.p(property, "<this>");
        y<T> yVarM0 = property.m0(d10);
        f0.o(yVarM0, "less(value)");
        return yVarM0;
    }

    @yt.k
    public static final <T> y<T> r(@yt.k Property<T> property, int i10) {
        f0.p(property, "<this>");
        y<T> yVarO0 = property.o0(i10);
        f0.o(yVarO0, "less(value)");
        return yVarO0;
    }

    @yt.k
    public static final <T> y<T> s(@yt.k Property<T> property, long j10) {
        f0.p(property, "<this>");
        y<T> yVarP0 = property.p0(j10);
        f0.o(yVarP0, "less(value)");
        return yVarP0;
    }

    @yt.k
    public static final <T> y<T> t(@yt.k Property<T> property, @yt.k String value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarQ0 = property.q0(value);
        f0.o(yVarQ0, "less(value)");
        return yVarQ0;
    }

    @yt.k
    public static final <T> y<T> u(@yt.k Property<T> property, @yt.k Date value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarT0 = property.t0(value);
        f0.o(yVarT0, "less(value)");
        return yVarT0;
    }

    @yt.k
    public static final <T> y<T> v(@yt.k Property<T> property, short s10) {
        f0.p(property, "<this>");
        y<T> yVarU0 = property.u0(s10);
        f0.o(yVarU0, "less(value)");
        return yVarU0;
    }

    @yt.k
    public static final <T> y<T> w(@yt.k Property<T> property, @yt.k byte[] value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarV0 = property.v0(value);
        f0.o(yVarV0, "less(value)");
        return yVarV0;
    }

    @yt.k
    public static final <T> y<T> x(@yt.k Property<T> property, int i10) {
        f0.p(property, "<this>");
        y<T> yVarK0 = property.K0(i10);
        f0.o(yVarK0, "notEqual(value)");
        return yVarK0;
    }

    @yt.k
    public static final <T> y<T> y(@yt.k Property<T> property, long j10) {
        f0.p(property, "<this>");
        y<T> yVarM0 = property.M0(j10);
        f0.o(yVarM0, "notEqual(value)");
        return yVarM0;
    }

    @yt.k
    public static final <T> y<T> z(@yt.k Property<T> property, @yt.k String value) {
        f0.p(property, "<this>");
        f0.p(value, "value");
        y<T> yVarN0 = property.N0(value);
        f0.o(yVarN0, "notEqual(value)");
        return yVarN0;
    }
}
