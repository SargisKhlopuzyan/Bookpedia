import org.gradle.kotlin.dsl.invoke

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeCompiler)
}

android {

    namespace = "com.sargis.androidapp"

    compileSdk {
        version = release(libs.versions.android.compileSdk.get().toInt()) //36
    }

    defaultConfig {
        applicationId = "com.sargis.bookpedia"
        minSdk = libs.versions.android.minSdk.get().toInt() //
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //        consumerProguardFiles("consumer-rules.pro")
    }
    //
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(projects.composeApp)

//    implementation(libs.androidx.core.ktx)
    //    implementation(libs.androidx.appcompat)
    //    implementation(libs.material)


//    implementation(libs.compose.uiToolingPreview)
//    implementation(libs.androidx.activity.compose)
//    implementation(libs.compose.runtime)
//    implementation(libs.compose.foundation)
//    implementation(libs.compose.material3)
//    implementation(libs.compose.ui)
//    implementation(libs.compose.components.resources)
//    implementation(libs.compose.uiToolingPreview)
//    implementation(libs.androidx.lifecycle.viewmodelCompose)
//    implementation(libs.androidx.lifecycle.runtimeCompose)


    implementation(platform(libs.androidx.compose.bom))
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.tooling.preview)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.testExt.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}