## Installation

### Calculator app

Install [calculator app]() to emulator if app isn't pre-installed. You need to download calculator .apk file, launch some emulator (I used pixel3 with 33API) and run next command (update path to location where your calculator.apk is downloaded)

```bash
adb install ~/Downloads/Calculator_8.7.apk
```


### Launch test from terminal

Before running next command for launching tests you need to start your AVD.

```bash
./gradlew connectedAndroidTest
```

