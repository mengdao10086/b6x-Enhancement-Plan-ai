package jq;

import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes7.dex */
public interface f {
    void a(String str, Object obj);

    void b(g gVar) throws CertPathValidatorException;

    void check(Certificate certificate) throws CertPathValidatorException;
}
