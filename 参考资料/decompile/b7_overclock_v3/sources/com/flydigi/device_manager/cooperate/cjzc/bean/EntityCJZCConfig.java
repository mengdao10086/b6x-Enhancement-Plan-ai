package com.flydigi.device_manager.cooperate.cjzc.bean;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public class EntityCJZCConfig implements Serializable {
    private String desc;
    private final ArrayList<EntityCJZCAction> list_config = new ArrayList<>();
    private int mode;
    private String name;

    public EntityCJZCConfig a() {
        EntityCJZCConfig entityCJZCConfig = new EntityCJZCConfig();
        entityCJZCConfig.k(this.mode);
        entityCJZCConfig.l(this.name);
        entityCJZCConfig.h(this.desc);
        for (int i10 = 0; i10 < this.list_config.size(); i10++) {
            entityCJZCConfig.list_config.add(this.list_config.get(i10).a());
        }
        return entityCJZCConfig;
    }

    public String b() {
        return this.desc;
    }

    public ArrayList<EntityCJZCAction> c() {
        return this.list_config;
    }

    public int d() {
        return this.mode;
    }

    public String f() {
        return this.name;
    }

    public void h(String str) {
        this.desc = str;
    }

    public void i(ArrayList<EntityCJZCAction> arrayList) {
        this.list_config.clear();
        this.list_config.addAll(arrayList);
    }

    public void k(int i10) {
        this.mode = i10;
    }

    public void l(String str) {
        this.name = str;
    }
}
