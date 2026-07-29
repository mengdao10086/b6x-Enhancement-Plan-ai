package org.bouncycastle.jcajce.provider.asymmetric.util;

import gm.b0;
import gm.s;
import gm.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes7.dex */
public class m implements er.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f45058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f45059b;

    public m() {
        this(new Hashtable(), new Vector());
    }

    public m(Hashtable hashtable, Vector vector) {
        this.f45058a = hashtable;
        this.f45059b = vector;
    }

    public Hashtable a() {
        return this.f45058a;
    }

    public Vector b() {
        return this.f45059b;
    }

    @Override // er.g
    public gm.h c(y yVar) {
        return (gm.h) this.f45058a.get(yVar);
    }

    public void d(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Object object = objectInputStream.readObject();
        if (object instanceof Hashtable) {
            this.f45058a = (Hashtable) object;
            this.f45059b = (Vector) objectInputStream.readObject();
        } else {
            s sVar = new s((byte[]) object);
            while (true) {
                y yVar = (y) sVar.n();
                if (yVar == null) {
                    return;
                } else {
                    h(yVar, sVar.n());
                }
            }
        }
    }

    public int e() {
        return this.f45059b.size();
    }

    @Override // er.g
    public Enumeration f() {
        return this.f45059b.elements();
    }

    public void g(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.f45059b.size() == 0) {
            objectOutputStream.writeObject(new Hashtable());
            objectOutputStream.writeObject(new Vector());
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b0 b0VarB = b0.b(byteArrayOutputStream);
        Enumeration enumerationF = f();
        while (enumerationF.hasMoreElements()) {
            y yVarN = y.N(enumerationF.nextElement());
            b0VarB.y(yVarN);
            b0VarB.x((gm.h) this.f45058a.get(yVarN));
        }
        objectOutputStream.writeObject(byteArrayOutputStream.toByteArray());
    }

    @Override // er.g
    public void h(y yVar, gm.h hVar) {
        if (this.f45058a.containsKey(yVar)) {
            this.f45058a.put(yVar, hVar);
        } else {
            this.f45058a.put(yVar, hVar);
            this.f45059b.addElement(yVar);
        }
    }
}
