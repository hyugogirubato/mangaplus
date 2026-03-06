// frida -U -l hook.js -f jp.co.shueisha.mangaplus
// https://play.google.com/store/apps/details?id=jp.co.shueisha.mangaplus

// abx2xml /data/system/users/0/settings_ssaid.xml - | grep "jp.co.shueisha.mangaplus"
if (Java.available) {
    Java.perform(function () {
        var StringKt = Java.use("jp.co.shueisha.mangaplus.ui.util.StringKt");
        StringKt["toMd5"].implementation = function (str) {
            const value = str.toString();
            if (value.length === 16) console.log(`MangaPlus registered device_id=${value}`);
            return this["toMd5"](str);
        };
    });
}