package zq;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l0 extends br.a {
    public void b(uq.a aVar, String str, String str2, String str3) {
        aVar.h("Mac." + str + "-CMAC", str2);
        aVar.h("Alg.Alias.Mac." + str + "CMAC", str + "-CMAC");
        aVar.h("KeyGenerator." + str + "-CMAC", str3);
        aVar.h("Alg.Alias.KeyGenerator." + str + "CMAC", str + "-CMAC");
    }

    public void c(uq.a aVar, String str, String str2, String str3) {
        aVar.h("Mac." + str + "-GMAC", str2);
        aVar.h("Alg.Alias.Mac." + str + "GMAC", str + "-GMAC");
        aVar.h("KeyGenerator." + str + "-GMAC", str3);
        aVar.h("Alg.Alias.KeyGenerator." + str + "GMAC", str + "-GMAC");
    }

    public void d(uq.a aVar, String str, String str2, String str3) {
        aVar.h("Mac.POLY1305-" + str, str2);
        aVar.h("Alg.Alias.Mac.POLY1305" + str, "POLY1305-" + str);
        aVar.h("KeyGenerator.POLY1305-" + str, str3);
        aVar.h("Alg.Alias.KeyGenerator.POLY1305" + str, "POLY1305-" + str);
    }
}
