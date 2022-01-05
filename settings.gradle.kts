
rootProject.name = "MultiplatformTimeUtils"

pluginManagement {
    resolutionStrategy {

        repositories {
            google()
            mavenCentral()
            mavenLocal()
            gradlePluginPortal()
        }

        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }

            when(requested.id.id) {
                "io.gitlab.arturbosch.detekt" -> {
                    useModule(
                        "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${requested.version}"
                    )
                }
            }
        }
    }
}

