package it;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<byte[]> f35863a = new b();

    public static List<byte[]> a(cs.o oVar, List<g> list) {
        q qVar = new q();
        for (int i10 = 0; i10 != list.size(); i10++) {
            qVar.a(list.get(i10).a(oVar));
        }
        return qVar.b();
    }

    public static List<byte[]> b(byte[][] bArr) {
        q qVar = new q();
        for (int i10 = 0; i10 != bArr.length; i10++) {
            qVar.a(bArr[i10]);
        }
        return qVar.b();
    }

    public static byte[] c(cs.o oVar, byte[] bArr, byte[] bArr2) {
        return f35863a.compare(bArr, bArr2) <= 0 ? h(oVar, bArr, bArr2) : h(oVar, bArr2, bArr);
    }

    public static byte[] d(cs.o oVar, byte[][] bArr) {
        return bArr.length == 2 ? c(oVar, bArr[0], bArr[1]) : f(oVar, b(bArr).iterator());
    }

    public static byte[] e(cs.o oVar, InputStream inputStream) {
        try {
            OutputStream outputStreamB = oVar.b();
            kt.c.b(inputStream, outputStreamB);
            outputStreamB.close();
            return oVar.c();
        } catch (IOException e10) {
            throw p.a("unable to calculate hash: " + e10.getMessage(), e10);
        }
    }

    public static byte[] f(cs.o oVar, Iterator<byte[]> it2) {
        try {
            OutputStream outputStreamB = oVar.b();
            while (it2.hasNext()) {
                outputStreamB.write(it2.next());
            }
            outputStreamB.close();
            return oVar.c();
        } catch (IOException e10) {
            throw p.a("unable to calculate hash: " + e10.getMessage(), e10);
        }
    }

    public static byte[] g(cs.o oVar, byte[] bArr) {
        try {
            OutputStream outputStreamB = oVar.b();
            outputStreamB.write(bArr);
            outputStreamB.close();
            return oVar.c();
        } catch (IOException e10) {
            throw p.a("unable to calculate hash: " + e10.getMessage(), e10);
        }
    }

    public static byte[] h(cs.o oVar, byte[] bArr, byte[] bArr2) {
        try {
            OutputStream outputStreamB = oVar.b();
            outputStreamB.write(bArr);
            outputStreamB.write(bArr2);
            outputStreamB.close();
            return oVar.c();
        } catch (IOException e10) {
            throw p.a("unable to calculate hash: " + e10.getMessage(), e10);
        }
    }

    public static byte[] i(cs.o oVar, un.i iVar) {
        byte[][] bArrA = iVar.A();
        return bArrA.length > 1 ? f(oVar, b(bArrA).iterator()) : bArrA[0];
    }
}
