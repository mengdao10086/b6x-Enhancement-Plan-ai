package vq;

/* JADX INFO: loaded from: classes7.dex */
public abstract class e extends br.a {
    public void b(uq.a aVar, String str, String str2, String str3) {
        String str4 = "HMAC" + str;
        aVar.h("Mac." + str4, str2);
        aVar.h("Alg.Alias.Mac.HMAC-" + str, str4);
        aVar.h("Alg.Alias.Mac.HMAC/" + str, str4);
        aVar.h("KeyGenerator." + str4, str3);
        aVar.h("Alg.Alias.KeyGenerator.HMAC-" + str, str4);
        aVar.h("Alg.Alias.KeyGenerator.HMAC/" + str, str4);
    }

    public void c(uq.a aVar, String str, gm.y yVar) {
        String str2 = "HMAC" + str;
        aVar.h("Alg.Alias.Mac." + yVar, str2);
        aVar.h("Alg.Alias.KeyGenerator." + yVar, str2);
    }
}
