plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.notabnsol.jetpack_compose_assignment_2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.notabnsol.jetpack_compose_assignment_2"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    hilt {
        enableAggregatingTask = false
    }
}

kapt{
    correctErrorTypes = true
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // --- Compose UI ---
    implementation( libs.ui )// Jetpack Compose UI library
    implementation( libs.androidx.material) // Material Design components for Compose
    implementation( libs.ui.tooling.preview )// Preview support for Compose

    // --- Navigation ---
    implementation (libs.androidx.navigation.compose) // Compose Navigation library

    // retrofit
    implementation(libs.retrofit.v300)
    implementation (libs.converter.gson)
    implementation(libs.logging.interceptor)

    // coroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

    // --- ViewModel and Lifecycle ---
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.runtime.livedata)
    implementation (libs.androidx.lifecycle.viewmodel.ktx.v261)

    // room db
    implementation ("androidx.room:room-runtime:2.7.1") // Room persistence library
    kapt("androidx.room:room-compiler:2.7.1") // Annotation processor for Room
    implementation ("androidx.room:room-ktx:2.7.1") // Kotlin extensions for Room

    // Hilt dependency
    implementation("com.google.dagger:hilt-android:2.56.2") // Hilt Android library
    kapt("com.google.dagger:hilt-compiler:2.56.2") // Hilt compiler
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

}