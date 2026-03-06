# MangaPlus Subscription Authentication

The **MangaPlus subscription system** is tied to a specific device. Devices are identified using the Android **`ANDROID_ID`**.

However, starting with **Android 8.0 Oreo (API 26)**, Android changed how this identifier works. Applications no longer receive the same global device identifier. Instead, Android introduced a new mechanism called **SSAID (Scoped Settings Android ID)**.

This document explains how the identifier works and how it can be obtained for use with the API.

---

## Android Device Identification

Historically, applications could retrieve a device identifier directly using:

```bash
adb shell settings get secure android_id
```

This returned a **device-wide identifier** shared by all applications.
Beginning with **Android 8.0 Oreo**, this behavior changed for privacy reasons.
Applications now receive a **per-application identifier** called **SSAID** instead of the global `ANDROID_ID`.

---

### What is SSAID

SSAID is a **unique identifier generated per application**.

The value depends on several parameters including:

* a **system-generated user seed**
* the **application package name**
* the **application UID**
* the **application signing certificate**

As a result:

* Two different apps on the same device will receive **different identifiers**
* The same app installed on two devices will receive **different identifiers**
* Reinstalling the app with a **different signing certificate** will change the identifier

Conceptually, the value is derived from a hash combining internal parameters.

Example representation:

```
SHA-256(cert)

SSAID = hash(user_seed + package + cert)
```

The exact implementation can be found in the **Android Open Source Project**.

Relevant source locations:

```
frameworks/base/packages/SettingsProvider
frameworks/base/services/core/java/com/android/server/pm
```

---

### Why this matters for MangaPlus

The MangaPlus backend links subscriptions to a **device identifier derived from SSAID**.

Because of this:

* The subscription is tied to a specific **app instance on a specific device**
* You cannot simply invent a device identifier
* Subscription restoration requires a valid identifier linked with **Google Play purchases**

---

## Methods to Retrieve the Identifier

Several approaches can be used to obtain the identifier used by the application.

Most of them require **root privileges** or **network interception**.

1. **MITM Registration Request**

   During the **first launch of the application**, the device registers itself to the API.

   Intercepting this request using a **MITM proxy** allows you to retrieve:

    * `device_token`
    * `security_key`

   These values can later be reused to authenticate the device.


2. **MITM API Request**

   A simpler approach is to intercept a regular API request.

   Look for the parameter `secret`

   Unlike the registration request, this method **does not require clearing the application data**.


3. **Read SSAID from the Android Filesystem (Root)**

   SSAID values are stored on the device in:

   ```
   /data/system/users/0/settings_ssaid.xml
   ```

   This file is stored in **Android Binary XML format**.

   You can convert and search it with:

   ```bash
   abx2xml /data/system/users/0/settings_ssaid.xml - | grep "jp.co.shueisha.mangaplus"
   ```

   Example output:

   ```
     <setting id="32" name="10320" value="0123456789abcdef" package="jp.co.shueisha.mangaplus" defaultValue="0123456789abcdef" defaultSysSet="false" tag="null" />
   ```

   The `value` field corresponds to the application's **SSAID**.


4. **Retrieve SSAID with Frida**

   You can hook the application and intercept the identifier at runtime.

   Example command:

   ```bash
   frida -U -l hook.js -f jp.co.shueisha.mangaplus
   ```

   This allows you to capture the value when the application retrieves or processes the identifier.

## Restoring the Subscription

Once you have obtained one of the required identifiers (`device_token`, `secret`, or SSAID), you can use it to authenticate the device in your script.

If the identifier corresponds to a device where the subscription was purchased or restored, the subscription will become active.

However:

* You **cannot arbitrarily choose a device identifier**
* Subscription restoration depends on **Google Play purchase validation**

### Tip: Using an Emulator Instead of Your Personal Device

To avoid rooting your personal device, you can use a **rooted Android emulator**.

Recommended workflow:

1. Launch a rooted Android emulator
2. Sign in with your **Google account**
3. Install MangaPlus
4. Restore your purchases via **Google Play**
5. Extract the generated SSAID

Once the subscription is restored, retrieve the identifier from the emulator using a privileged shell.