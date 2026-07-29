package org.bouncycastle.jcajce.util;

import gm.c0;
import java.io.IOException;
import java.security.AlgorithmParameters;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static gm.h a(AlgorithmParameters algorithmParameters) throws IOException {
        try {
            return c0.D(algorithmParameters.getEncoded("ASN.1"));
        } catch (Exception unused) {
            return c0.D(algorithmParameters.getEncoded());
        }
    }

    public static void b(AlgorithmParameters algorithmParameters, gm.h hVar) throws IOException {
        try {
            algorithmParameters.init(hVar.b().getEncoded(), "ASN.1");
        } catch (Exception unused) {
            algorithmParameters.init(hVar.b().getEncoded());
        }
    }
}
