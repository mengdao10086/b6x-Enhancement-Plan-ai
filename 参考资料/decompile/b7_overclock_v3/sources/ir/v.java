package ir;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f35734c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f35735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35736b;

    public v(BigInteger bigInteger, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        }
        this.f35735a = bigInteger;
        this.f35736b = i10;
    }

    public static v j(BigInteger bigInteger, int i10) {
        return new v(bigInteger.shiftLeft(i10), i10);
    }

    public v a(v vVar) {
        d(vVar);
        return new v(this.f35735a.add(vVar.f35735a), this.f35736b);
    }

    public v b(BigInteger bigInteger) {
        return new v(this.f35735a.add(bigInteger.shiftLeft(this.f35736b)), this.f35736b);
    }

    public v c(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        }
        int i11 = this.f35736b;
        return i10 == i11 ? this : new v(this.f35735a.shiftLeft(i10 - i11), i10);
    }

    public final void d(v vVar) {
        if (this.f35736b != vVar.f35736b) {
            throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
        }
    }

    public int e(v vVar) {
        d(vVar);
        return this.f35735a.compareTo(vVar.f35735a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f35735a.equals(vVar.f35735a) && this.f35736b == vVar.f35736b;
    }

    public int f(BigInteger bigInteger) {
        return this.f35735a.compareTo(bigInteger.shiftLeft(this.f35736b));
    }

    public v g(v vVar) {
        d(vVar);
        return new v(this.f35735a.shiftLeft(this.f35736b).divide(vVar.f35735a), this.f35736b);
    }

    public v h(BigInteger bigInteger) {
        return new v(this.f35735a.divide(bigInteger), this.f35736b);
    }

    public int hashCode() {
        return this.f35735a.hashCode() ^ this.f35736b;
    }

    public BigInteger i() {
        return this.f35735a.shiftRight(this.f35736b);
    }

    public int k() {
        return this.f35736b;
    }

    public int l() {
        return i().intValue();
    }

    public long m() {
        return i().longValue();
    }

    public v n(v vVar) {
        d(vVar);
        BigInteger bigIntegerMultiply = this.f35735a.multiply(vVar.f35735a);
        int i10 = this.f35736b;
        return new v(bigIntegerMultiply, i10 + i10);
    }

    public v o(BigInteger bigInteger) {
        return new v(this.f35735a.multiply(bigInteger), this.f35736b);
    }

    public v p() {
        return new v(this.f35735a.negate(), this.f35736b);
    }

    public BigInteger q() {
        return a(new v(d.f35647b, 1).c(this.f35736b)).i();
    }

    public v r(int i10) {
        return new v(this.f35735a.shiftLeft(i10), this.f35736b);
    }

    public v s(v vVar) {
        return a(vVar.p());
    }

    public v t(BigInteger bigInteger) {
        return new v(this.f35735a.subtract(bigInteger.shiftLeft(this.f35736b)), this.f35736b);
    }

    public String toString() {
        if (this.f35736b == 0) {
            return this.f35735a.toString();
        }
        BigInteger bigIntegerI = i();
        BigInteger bigIntegerSubtract = this.f35735a.subtract(bigIntegerI.shiftLeft(this.f35736b));
        if (this.f35735a.signum() == -1) {
            bigIntegerSubtract = d.f35647b.shiftLeft(this.f35736b).subtract(bigIntegerSubtract);
        }
        if (bigIntegerI.signum() == -1 && !bigIntegerSubtract.equals(d.f35646a)) {
            bigIntegerI = bigIntegerI.add(d.f35647b);
        }
        String string = bigIntegerI.toString();
        char[] cArr = new char[this.f35736b];
        String string2 = bigIntegerSubtract.toString(2);
        int length = string2.length();
        int i10 = this.f35736b - length;
        for (int i11 = 0; i11 < i10; i11++) {
            cArr[i11] = '0';
        }
        for (int i12 = 0; i12 < length; i12++) {
            cArr[i10 + i12] = string2.charAt(i12);
        }
        String str = new String(cArr);
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.append(j3.b.f36044h);
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
