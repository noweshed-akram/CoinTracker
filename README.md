# CoinTracker

# Constants
Where we can change API base urls, SCHEDULE_TIME for Periodic API request in background,
COINS_LIMIT to set the limit of data you want to view in list 

```
object Constants {
    const val BASE_URL = "https://api.coinpaprika.com/v1/"
    const val SCHEDULE_TIME = 1L // e.g 5 min for next API request
    const val COINS_LIMIT = 10 // set the limit of data you want to view in list
    const val BILLION = 1000000000
}
```

# Dependencies
I have Added the following dependencies for this project:

```
    implementation 'com.google.android.material:material:1.7.0'
    //navigation
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.3'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.3'

    def retrofit_version = "2.9.0"
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    def roomVersion = "2.4.3"
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    def coroutines_version = "1.6.1"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines_version")

    def lifecycle_version = "2.5.1"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    def dagger_version = "2.43"
    implementation "com.google.dagger:hilt-android:$dagger_version"
    kapt "com.google.dagger:hilt-compiler:$dagger_version"

    def glider_version = "4.13.1"
    implementation "com.github.bumptech.glide:glide:$glider_version"
    kapt "com.github.bumptech.glide:compiler:$glider_version"

    def paging_version = "3.1.1"
    implementation("androidx.paging:paging-runtime:$paging_version")

    //Swipe refresh
    implementation "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

    // WorkManager
    implementation 'androidx.work:work-runtime-ktx:2.7.1'
```

# Design Pattern & Code Structure

In this project I followed MVVM (Model — View — ViewModel) with Clean Architecture and Navigation
Component.