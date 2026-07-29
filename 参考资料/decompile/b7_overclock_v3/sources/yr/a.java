package yr;

import gm.u1;
import org.bouncycastle.oer.OERDefinition;
import so.d;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static final OERDefinition.a A;
    public static final OERDefinition.a B;
    public static final OERDefinition.a C;
    public static final OERDefinition.a D;
    public static final OERDefinition.a E;
    public static final OERDefinition.a F;
    public static final OERDefinition.a G;
    public static final OERDefinition.a H;
    public static final OERDefinition.a I;
    public static final OERDefinition.a J;
    public static final OERDefinition.b K;
    public static final OERDefinition.b L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OERDefinition.a f57483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final OERDefinition.a f57484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final OERDefinition.a f57485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final OERDefinition.a f57486d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final OERDefinition.a f57487e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final OERDefinition.a f57488f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final OERDefinition.a f57489g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final OERDefinition.a f57490h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final OERDefinition.a f57491i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final OERDefinition.a f57492j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final OERDefinition.a f57493k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final OERDefinition.a f57494l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final OERDefinition.a f57495m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final OERDefinition.a f57496n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final OERDefinition.a f57497o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final OERDefinition.a f57498p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final OERDefinition.a f57499q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final OERDefinition.a f57500r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final OERDefinition.a f57501s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final OERDefinition.a f57502t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final OERDefinition.a f57503u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final OERDefinition.a f57504v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final OERDefinition.a f57505w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final OERDefinition.a f57506x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final OERDefinition.a f57507y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final OERDefinition.a f57508z;

    static {
        OERDefinition.a aVarK = OERDefinition.k(0L, 255L);
        f57483a = aVarK;
        OERDefinition.a aVarD = OERDefinition.d(OERDefinition.p(32).h("sha256HashedData"), OERDefinition.h(), OERDefinition.p(48).h("sha384HashedData"), OERDefinition.p(32).h("reserved"));
        f57484b = aVarD;
        OERDefinition.a aVar = b.f57521g;
        OERDefinition.a aVar2 = b.V;
        OERDefinition.a aVarV = OERDefinition.v(aVar.h("cracaId"), aVar2.h("crlSeries"), OERDefinition.h());
        f57485c = aVarV;
        OERDefinition.a aVarK2 = OERDefinition.k(0L, 255L);
        f57486d = aVarK2;
        OERDefinition.a aVarV2 = OERDefinition.v(aVarK2.h("id"), OERDefinition.h());
        f57487e = aVarV2;
        OERDefinition.a aVarV3 = OERDefinition.v(aVarK2, OERDefinition.w(aVarV2));
        f57488f = aVarV3;
        OERDefinition.a aVar3 = b.f57525i;
        f57489g = aVar3;
        OERDefinition.a aVar4 = b.D;
        OERDefinition.a aVarD2 = OERDefinition.d(aVar4.h("eciesNistP256"), aVar4.h("eciesBrainpoolP256r1"), OERDefinition.h());
        f57490h = aVarD2;
        OERDefinition.a aVarV4 = OERDefinition.v(aVar3.h("recipientId"), aVarD2.h("encKey"));
        f57491i = aVarV4;
        OERDefinition.a aVarV5 = OERDefinition.v(OERDefinition.p(12).h("nonce"), OERDefinition.r().h("ccmCiphertext"));
        f57492j = aVarV5;
        OERDefinition.a aVarD3 = OERDefinition.d(aVarV5.h("aes128ccm"), OERDefinition.h());
        f57493k = aVarD3;
        OERDefinition.a aVarV6 = OERDefinition.v(aVar3.h("recipientId"), aVarD3.h("encKey"));
        f57494l = aVarV6;
        OERDefinition.a aVarD4 = OERDefinition.d(aVar3.h("pskRecipInfo"), aVarV6.h("symmRecipInfo"), aVarV4.h("certRecipInfo"), aVarV4.h("signedDataRecipInfo"), aVarV4.h("rekRecipInfo"));
        f57495m = aVarD4;
        OERDefinition.a aVarW = OERDefinition.w(aVarD4);
        f57496n = aVarW;
        OERDefinition.a aVarV7 = OERDefinition.v(aVarW.h("recipients"), aVarD3.h("ciphertext"));
        f57497o = aVarV7;
        OERDefinition.a aVarC = OERDefinition.c(8L).c(new u1(new byte[]{0}, 0));
        f57498p = aVarC;
        OERDefinition.a aVarH = OERDefinition.d(b.T, OERDefinition.n(), OERDefinition.h()).h("SubjectPermissions");
        f57499q = aVarH;
        OERDefinition.a aVarH2 = OERDefinition.d(b.I, b.f57550w, OERDefinition.h()).h("VerificationKeyIndicator");
        f57500r = aVarH2;
        OERDefinition.a aVarH3 = OERDefinition.v(aVarH, OERDefinition.j(1L), OERDefinition.j(0L), aVarC).h("PsidGroupPermissions");
        f57501s = aVarH3;
        OERDefinition.a aVarH4 = OERDefinition.w(aVarH3).h("SequenceOfPsidGroupPermissions");
        f57502t = aVarH4;
        OERDefinition.a aVarH5 = OERDefinition.v(b.f57541q, b.f57545s, OERDefinition.s(b.f57547t), OERDefinition.h()).h("LinkageData");
        f57503u = aVarH5;
        OERDefinition.a aVarH6 = OERDefinition.d(aVarH5, b.f57543r, OERDefinition.q(1, 64).h("binaryId"), OERDefinition.n(), OERDefinition.h()).h("CertificateId");
        f57504v = aVarH6;
        OERDefinition.a aVarH7 = OERDefinition.v(aVarH6.i("id"), aVar.i("cracaId"), aVar2.i("crlSeries"), b.f57539p.i("validityPeriod"), OERDefinition.s(b.f57546s0.i("region"), b.U.i("assuranceLevel"), b.N.i("appPermissions"), aVarH4.i("certIssuePermissions"), aVarH4.i("certRequestPermissions"), OERDefinition.n().i("canRequestRollover"), b.F.i("encryptionKey")), aVarH2.i("verifyKeyIndicator"), OERDefinition.h()).h("ToBeSignedCertificate");
        f57505w = aVarH7;
        OERDefinition.a aVar5 = b.C;
        OERDefinition.a aVarH8 = OERDefinition.d(aVar3, aVar5, OERDefinition.h(), aVar3).h("IssuerIdentifier");
        f57506x = aVarH8;
        OERDefinition.a aVarH9 = OERDefinition.g(OERDefinition.e("explicit"), OERDefinition.e("implicit"), OERDefinition.h()).h("CertificateType");
        f57507y = aVarH9;
        OERDefinition.a aVar6 = b.f57511b;
        OERDefinition.a aVar7 = b.A;
        OERDefinition.a aVarH10 = OERDefinition.v(aVar6, aVarH9, aVarH8, aVarH7, OERDefinition.s(aVar7)).h("CertificateBase");
        f57508z = aVarH10;
        OERDefinition.a aVarH11 = aVarH10.b().h("Certificate(CertificateBase)");
        A = aVarH11;
        OERDefinition.a aVarW2 = OERDefinition.w(aVarH11);
        B = aVarW2;
        OERDefinition.a aVar8 = b.f57535n;
        OERDefinition.a aVarV8 = OERDefinition.v(b.J.h("psid"), OERDefinition.s(aVar8.h("generationTime"), aVar8.h("expiryTime"), b.f57530k0.h("generationLocation"), aVar.h("p2pcdLearningRequest"), aVarV.h("missingCrlIdentifier"), b.H.h("encryptionKey")), OERDefinition.h(), OERDefinition.s(b.f57523h.h("inlineP2pcdRequest"), aVarH11.h("requestedCertificate"), aVarK.h("pduFunctionalType"), aVarV3.h("contributedExtensions")));
        C = aVarV8;
        OERDefinition.a aVarD5 = OERDefinition.d(aVar3.h(d.f50128b), aVarW2, OERDefinition.n().h("self"), OERDefinition.h());
        D = aVarD5;
        OERDefinition.c cVar = new OERDefinition.c(OERDefinition.BaseType.SEQ);
        E = cVar;
        OERDefinition.a aVarV9 = OERDefinition.v(aVar5.h("hashId"), cVar.h("tbsData"), aVarD5.h("signer"), aVar7.h("signature"));
        F = aVarV9;
        OERDefinition.a aVarD6 = OERDefinition.d(OERDefinition.r().h("unsecuredData"), aVarV9.h("signedData"), aVarV7.h("encryptedData"), OERDefinition.r().h("signedCertificateRequest"), OERDefinition.h());
        G = aVarD6;
        H = OERDefinition.v(aVar6.h("protocolVersion"), aVarD6.h("content"));
        OERDefinition.a aVarV10 = OERDefinition.v(aVar6.h("protocolVersion"), aVarD6.h("content"));
        I = aVarV10;
        OERDefinition.a aVarV11 = OERDefinition.v(OERDefinition.s(aVarV10.h("data"), aVarD.h("extDataHash")), OERDefinition.h());
        J = aVarV11;
        K = aVarH11.a();
        L = aVarH7.a();
        cVar.p(aVarV11.h("payload"), aVarV8.h("headerInfo"));
    }
}
