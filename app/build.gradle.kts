plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
//    // Add the Google services Gradle plugin
//    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.alohcmute_v2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.alohcmute_v2"
        minSdk = 23
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
//    // Import the Firebase BoM
//    implementation(platform("com.google.firebase:firebase-bom:33.0.0"))
//    // Add the dependencies for the desired Firebase products
//    //firebase auth
//    implementation("com.google.firebase:firebase-auth-ktx")

    //add glide
    implementation("com.github.bumptech.glide:glide:4.14.2")
    implementation("androidx.annotation:annotation:1.7.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("com.google.firebase:firebase-auth:23.0.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")
    // add lombok
    implementation("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.airbnb.android:lottie:6.4.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

