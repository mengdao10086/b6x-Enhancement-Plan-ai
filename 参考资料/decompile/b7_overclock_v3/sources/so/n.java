package so;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f50231a = "1.2.840.113549.1.9.16.3.8";

    public m a(r0 r0Var, cs.c0 c0Var) throws CMSException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream outputStreamB = c0Var.b(byteArrayOutputStream);
            r0Var.d(outputStreamB);
            outputStreamB.close();
            return new m(new mm.n(mm.k.Q2, new mm.l(c0Var.a(), new mm.n(r0Var.a(), new gm.e1(byteArrayOutputStream.toByteArray())))));
        } catch (IOException e10) {
            throw new CMSException("exception encoding data.", e10);
        }
    }
}
