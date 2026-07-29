package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class s0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f58941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.f0 f58942b;

    public s0(gm.f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        this.f58941a = gm.y.N(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f58942b = gm.f0.J(f0Var.K(1));
        }
    }

    public s0(gm.y yVar) {
        this.f58941a = yVar;
    }

    public s0(gm.y yVar, gm.f0 f0Var) {
        this.f58941a = yVar;
        this.f58942b = f0Var;
    }

    public static s0 x(Object obj) {
        return (obj == null || (obj instanceof s0)) ? (s0) obj : new s0(gm.f0.J(obj));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f58941a);
        gm.f0 f0Var = this.f58942b;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        return new j2(iVar);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Policy information: ");
        stringBuffer.append(this.f58941a);
        if (this.f58942b != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i10 = 0; i10 < this.f58942b.size(); i10++) {
                if (stringBuffer2.length() != 0) {
                    stringBuffer2.append(", ");
                }
                stringBuffer2.append(v0.x(this.f58942b.K(i10)));
            }
            stringBuffer.append("[");
            stringBuffer.append(stringBuffer2);
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }

    public gm.y y() {
        return this.f58941a;
    }

    public gm.f0 z() {
        return this.f58942b;
    }
}
