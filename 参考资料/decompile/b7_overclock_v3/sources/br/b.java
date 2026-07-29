package br;

import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends a {
    public void b(uq.a aVar, String str, String str2, y yVar) {
        aVar.h("Signature." + str, str2);
        aVar.h("Alg.Alias.Signature." + yVar, str);
        aVar.h("Alg.Alias.Signature.OID." + yVar, str);
    }

    public void c(uq.a aVar, String str, String str2, String str3) {
        d(aVar, str, str2, str3, null);
    }

    public void d(uq.a aVar, String str, String str2, String str3, y yVar) {
        String str4 = str + "WITH" + str2;
        String str5 = str + "with" + str2;
        String str6 = str + "With" + str2;
        String str7 = str + fh.a.f28350w + str2;
        aVar.h("Signature." + str4, str3);
        aVar.h("Alg.Alias.Signature." + str5, str4);
        aVar.h("Alg.Alias.Signature." + str6, str4);
        aVar.h("Alg.Alias.Signature." + str7, str4);
        if (yVar != null) {
            aVar.h("Alg.Alias.Signature." + yVar, str4);
            aVar.h("Alg.Alias.Signature.OID." + yVar, str4);
        }
    }

    public void e(uq.a aVar, y yVar, String str, c cVar) {
        aVar.h("Alg.Alias.KeyFactory." + yVar, str);
        aVar.h("Alg.Alias.KeyPairGenerator." + yVar, str);
        aVar.b(yVar, cVar);
    }

    public void f(uq.a aVar, y yVar, String str) {
        aVar.h("Alg.Alias.AlgorithmParameterGenerator." + yVar, str);
        aVar.h("Alg.Alias.AlgorithmParameters." + yVar, str);
    }

    public void g(uq.a aVar, y yVar, String str) {
        aVar.h("Alg.Alias.AlgorithmParameters." + yVar, str);
    }
}
