package com.flydigi.game.data.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class GameCatEntity implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public String f15817id;
    public long idDB;
    public String title;

    public GameCatEntity() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GameCatEntity gameCatEntity = (GameCatEntity) obj;
        return Objects.equals(this.f15817id, gameCatEntity.f15817id) && Objects.equals(this.title, gameCatEntity.title);
    }

    public int hashCode() {
        return Objects.hash(this.f15817id, this.title);
    }

    public String toString() {
        return "GameCatEntity{id='" + this.f15817id + "', title='" + this.title + "'}";
    }

    public GameCatEntity(String str, String str2) {
        this.f15817id = str;
        this.title = str2;
    }
}
