package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.k(level = DeprecationLevel.ERROR, message = "This class is no longer supported, do not use it.")
@Deprecated
public abstract class FunctionImpl implements kotlin.u, Serializable, ik.a, ik.l, ik.p, ik.q, ik.r, ik.s, ik.t, ik.u, ik.v, ik.w, ik.b, ik.c, ik.d, ik.e, ik.f, ik.g, ik.h, ik.i, ik.j, ik.k, ik.m, ik.n, ik.o {
    @Override // ik.q
    public Object A(Object obj, Object obj2, Object obj3) {
        b(3);
        return d(obj, obj2, obj3);
    }

    @Override // ik.u
    public Object A0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        b(7);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // ik.b
    public Object B0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        b(10);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // ik.d
    public Object C(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        b(12);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // ik.k
    public Object G(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
        b(19);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // ik.g
    public Object G0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        b(15);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // ik.h
    public Object H(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        b(16);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // ik.r
    public Object N(Object obj, Object obj2, Object obj3, Object obj4) {
        b(4);
        return d(obj, obj2, obj3, obj4);
    }

    @Override // ik.v
    public Object P(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        b(8);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // ik.m
    public Object U(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
        b(20);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // ik.o
    public Object X(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        b(22);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }

    @Override // ik.e
    public Object Z(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        b(13);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    public final void b(int i10) {
        if (h() != i10) {
            f(i10);
        }
    }

    public Object d(Object... objArr) {
        throw new UnsupportedOperationException();
    }

    public final void f(int i10) {
        throw new IllegalStateException("Wrong function arity, expected: " + i10 + ", actual: " + h());
    }

    public abstract int h();

    @Override // ik.l
    public Object i(Object obj) {
        b(1);
        return d(obj);
    }

    @Override // ik.t
    public Object m0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        b(6);
        return d(obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // ik.a
    public Object o() {
        b(0);
        return d(new Object[0]);
    }

    @Override // ik.f
    public Object o0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        b(14);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // ik.i
    public Object p0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        b(17);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // ik.c
    public Object q(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        b(11);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // ik.p
    public Object r0(Object obj, Object obj2) {
        b(2);
        return d(obj, obj2);
    }

    @Override // ik.w
    public Object t0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        b(9);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // ik.j
    public Object v(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        b(18);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // ik.s
    public Object w0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        b(5);
        return d(obj, obj2, obj3, obj4, obj5);
    }

    @Override // ik.n
    public Object y0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
        b(21);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }
}
