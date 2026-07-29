package com.flydigi.data.bean;

import com.flydigi.sdk.gamepad.extension.config.data.CFGEntity;

/* JADX INFO: loaded from: classes7.dex */
public class EntitySimpleConfig {
    public static final int VERSION_GAMEPAD = 1;
    public static final int VERSION_GAMEPAD_HALF = 3;
    public static final int VERSION_KEYBOARD_MOUSE = 2;
    public static final int VERSION_OLD = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f14329id = "";
    private String name = "";
    private String fid = "";
    private String url = "";
    private int version = 1;
    private boolean isCheck = false;
    public boolean showSelect = false;
    private CFGEntity cfgEntity = null;

    public CFGEntity getCfgEntity() {
        return this.cfgEntity;
    }

    public boolean getCheck() {
        return this.isCheck;
    }

    public String getFid() {
        return this.fid;
    }

    public String getId() {
        return this.f14329id;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersion() {
        return this.version;
    }

    public void setCfgEntity(CFGEntity cfgEntity) {
        this.cfgEntity = cfgEntity;
    }

    public void setCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public void setId(String id2) {
        this.f14329id = id2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String toString() {
        return "EntitySimpleConfig{id='" + this.f14329id + "', name='" + this.name + "', fid='" + this.fid + "', url='" + this.url + "', version=" + this.version + ", isCheck=" + this.isCheck + ", cfgEntity=" + this.cfgEntity + '}';
    }
}
