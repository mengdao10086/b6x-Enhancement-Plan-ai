pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Xposed API — 优先 Aliyun 镜像，兜底官方仓库
        maven("https://maven.aliyun.com/repository/jcenter")
        maven("https://api.xposed.info/repository")
    }
}

rootProject.name = "WaspWingTempCtrl"
include(":app")
