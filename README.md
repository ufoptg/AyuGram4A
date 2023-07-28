## What's this fork even about?

It's fork of [AyuGram for Android](https://github.com/AyuGram/AyuGram4A) without proprietary features.

Other information about original project you can find [here](https://github.com/AyuGram/AyuGram4A/blob/rewrite/README.md)

## How to build

Build instruction differs from [AyuGram](https://github.com/AyuGram/AyuGram4A) because you can't compile original project because of ["lack of some proprietary files"](https://github.com/Dr4iv3rNope/NotSoAndroidAyuGram/tree/rewrite/TMessagesProj/src/main/java/com/radolyn/ayugram/proprietary)

There's two ways to compile AyuGram:

1. [Using Android Command Line Tools](#build-via-android-command-line-tools)
2. [Using Android Studio](#build-via-android-studio)

### Build via Android Command Line Tools

Ensure you have installed [Android Command Line Tools](https://developer.android.com/tools)

1. **Clone this repository**

   `git clone https://github.com/Dr4iv3rNope/NotSoAndroidAyuGram.git`

2. **Navigate to repository**

   `cd NotSoAndroidAyuGram`

3. **Create "local.properties" and add "sdk.dir" variable**

   ```
   sdk.dir=/path/to/android-sdk
   ```

4. **Generate signing keys**

   Command example: `keytool -genkey -v -keystore release-key.keystore -alias release-key-alias -keyalg RSA -keysize 2048 -validity 10000`

5. **Put generated .keystore file to TMessagesProj/config/extera.jks**

   `mv release-key.keystore TMessagesProj/config/extera.jks`

6. **Create API_KEYS file with following content**

   ```
   APP_ID = 6
   APP_HASH = "eb06d4abfb49dc3eeb1aeb98ae0f581e"
   MAPS_V2_API = <...>

   SIGNING_KEY_PASSWORD = myPassword
   SIGNING_KEY_ALIAS = release-key-alias
   SIGNING_KEY_STORE_PASSWORD = myPassword
   ```

7. **Get Google Firebase "google-services.json" configuration file**

   It's required... So just generate it using [this instruction](https://firebase.google.com/docs/android/setup)

8. **Add "google-services.json" to this project**

   Put this file into `TMessageProj/google-services.json`

9. **Build APK!**

   Build APK using `./gradlew <Task name>`

   If you're not sure about your devices ABI,
   just build using `./gradlew assembleAfat`

   | Task name | Output APK ABI |
   | :-------- | :---------- |
   | assembleAfat | **(Recomended)** **"universal apk"** that can be used on all devices |
   | assembleArm64 | **arm64-v8a** |
   | assembleArmv7 | **armeabi-v7a** |
   | assembleX64 | **x86_64** |
   | assembleX86 | **x86** |

   Other tasks can be listed using `./gradlew tasks`

### Build via Android Studio

Android studio can be downloaded [here](https://developer.android.com/studio)

1. Clone this repository
2. Open the project in Android Studio. It should be opened, **not imported**
3. [Generate](https://firebase.google.com/docs/android/setup) and replace `google-services.json` ([he](https://github.com/ZavaruKitsu) don't want to see crash reports from your app...)
4. Generate signing keys and fill API_KEYS
5. Build it!

## AyuGram Localization

[![Crowdin](https://badges.crowdin.net/ayugram/localized.svg)](https://crowdin.com/project/ayugram)
[![Crowdin](https://badges.crowdin.net/exteralocales/localized.svg)](https://crowdin.com/project/exteralocales)

We have our own **[Crowdin](https://crowdin.com/project/ayugram)**.

But since **AyuGram** is based on **exteraGram**, also join their project
at **[Crowdin](https://crowdin.com/project/exteralocales)**!

## Credits

- **[exteraGram](https://github.com/exteraSquad/exteraGram)**
- [Telegraher](https://github.com/nikitasius/Telegraher)
- [Cherrygram](https://github.com/arsLan4k1390/Cherrygram)
- [Nagram](https://github.com/NextAlone/Nagram)
- [Telegram FOSS](https://github.com/Telegram-FOSS-Team/Telegram-FOSS)
