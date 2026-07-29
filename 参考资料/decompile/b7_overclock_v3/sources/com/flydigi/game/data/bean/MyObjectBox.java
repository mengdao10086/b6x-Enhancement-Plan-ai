package com.flydigi.game.data.bean;

import db.d;
import ii.f;
import ii.j;

/* JADX INFO: loaded from: classes7.dex */
public class MyObjectBox {
    private static void buildEntityGameBean(j jVar) {
        j.a aVarC = jVar.c("GameBean");
        aVarC.e(5, 4474498264240791856L).f(30, 8700160697033873608L);
        aVarC.d(1);
        aVarC.g("idDB", 6).d(1, 924359737548742755L).c(1);
        aVarC.g("id", 9).d(2, 1137639173564722557L);
        aVarC.g("title", 9).d(3, 7914813117183551895L);
        aVarC.g("packageName", 9).d(13, 9027807934190207615L).c(2048).e(5, 6488855547243271482L);
        aVarC.g("updateTime", 6).d(24, 3420131337794893786L);
        aVarC.g("thumb", 9).d(4, 5603410154875144165L);
        aVarC.g(d.f26139i, 9).d(19, 5767571065304419017L);
        aVarC.g("versionCode", 5).d(21, 5933756066323941303L);
        aVarC.g("star", 5).d(5, 8246972564013349958L);
        aVarC.g("log", 9).d(23, 5234578807927072608L);
        aVarC.g("description", 9).d(6, 3946500422978610292L);
        aVarC.g("link", 9).d(7, 2019713278505289566L);
        aVarC.g("size", 9).d(8, 6538069334649448293L);
        aVarC.g("category", 9).d(9, 6986821348792492201L).c(2);
        aVarC.g("pattern", 9).d(26, 1853316264951412758L).c(2);
        aVarC.g("updateAble", 1).d(22, 7444600788131273413L);
        aVarC.g("lastOperateTime", 6).d(25, 3594394022293857397L);
        aVarC.g("type", 5).d(10, 7528122463709277643L);
        aVarC.g("installed", 1).d(17, 2634826896221669720L);
        aVarC.g("localPath", 9).d(14, 6680686759300737674L);
        aVarC.g("progress", 7).d(15, 8168120992201052292L);
        aVarC.g("wifiRequired", 1).d(18, 2770465219087157241L);
        aVarC.g("appointmentStatus", 5).d(27, 4111566003200882989L);
        aVarC.g("isSubscribed", 5).d(28, 2841540551581913163L);
        aVarC.g("isHide", 1).d(30, 8700160697033873608L);
        aVarC.c();
    }

    public static f builder() {
        f fVar = new f(getModel());
        fVar.o(GameBean_.__INSTANCE);
        return fVar;
    }

    private static byte[] getModel() {
        j jVar = new j();
        jVar.d(15, 7193979068757378655L);
        jVar.e(8, 5515525037688775659L);
        jVar.f(0, 0L);
        buildEntityGameBean(jVar);
        return jVar.a();
    }
}
