# April Fools 2024

This is a simple quick and dirty plugin making use of my `InvUILib` library which you can find here [diademiemi/InvUILib](https://github.com/diademiemi/InvUILib).

This was made for Queercraft's April Fools 2024 event. The joke was that the server needed extra security, which costed too much. This would explain the "CAPTCHA" which this plugin adds, along with the "popup ads".

## Installation
You can get a copy of the plugin from the [releases page](https://github.com/Queercraft/AprilFools2024/releases).
The plugin requires `InvUILib` to be installed on your server. You can get a copy of `InvUILib` from the [InvUILib releases page](https://github.com/diademiemi/InvUILib/releases).

## Usage
When a player joins with the `aprilfools2024.track` permission, they will be tracked by the plugin. This will include some of their actions.

Upon a tracked player joining, they will be greeted with a popup prompting them to accept cookies, a terms of service, privacy policy, EULA and complete a CAPTCHA. These are all humorous and do not actually do anything.
When accepting the cookie, the player will be given a cookie item. This item is purely cosmetic and does not do anything, it includes special lore because people love their collectible items from events...

All these are tracked in a jsonData field in the player's data, this is to track whether they've already received a reward or seen a popup.

Certain tasks will be tracked. For example, placing 64 blocks gives you a popup to "Renew your Minecraft license". Upon getting this popup, a boolean is stored in the player's data to prevent them from getting the popup again.

The plugin also includes a "popup ad" feature. This is a simple scheduler which shows a random popup to every online player once every 10-30 minutes (random interval).

## Commands
- `/aprilfools2024 get <player> <flag>` - Get a flag from a player's data.
- `/aprilfools2024 setbool <player> <flag> <value>` - Set a boolean flag in a player's data.
- `/aprilfools2024 setint <player> <flag> <value>` - Set an integer flag in a player's data.
- `/aprilfools2024 setstring <player> <flag> <value>` - Set a string flag in a player's data.
- `/aprilfools2024 clear <player>` - Reset a player's data.
- `/aprilfools2024 save` - Save the plugin's data to data.yml.
- `/aprilfools2024 test <player> <popupname>` - Test a popup on a player.

## Permissions
- `aprilfools2024.track` - Allows a player to be tracked by the plugin.
- `aprilfools2024.admin` - Allows a player to use the commands.

## the funny bit

ok so im done writing as if this is a serious plugin lmfao. this shit SUCKS. the code is abysmal and was written on a huge time crunch bcs i never EVER start on time with any project with a deadline.

you can use this as inspo for how to use InvUILib, but for the love of god, the code sucks.

gonna write some interesting files

[DgFirstJoin1](src/main/java/me/diademiemi/aprilfools2024/dialogs/DgFirstJoin1.java) contains the code for the initial login prompt. this i wrote when i still thought i had time, so its a bit nicer. There are 8 of these DgFirstJoin files.  
[DgFirstJoin6](src/main/java/me/diademiemi/aprilfools2024/dialogs/DgFirstJoin6.java) contins an easy captcha (BOOBIES!!!). It keeps calling itself until the proper digits are entered.

[DgGlobalCaptcha](src/main/java/me/diademiemi/aprilfools2024/dialogs/DgGlobalCaptcha.java) is the file that shows the FUCKED UP captcha. this is 15 digits. wanna know the fun bit? after 8 digits, the keypad shuffles itself. its awful!!!!!!
Wanna shut someone up? `/aprilfools2024 test <player> GlobalCaptcha`. Wanna halve your playerbase? `/aprilfools2024 test * GlobalCaptcha`. Bam. Now everyones pissed. I LOVED it when this randomly happened. God this is the best fucking file I've ever written.
OH PLEASE DONT LOOK AT THE CODE ITS SO UGLY BUT I MADE IT IN LIKE 5 MINUTES BCS I HAD TO RUSH.

boring files incoming!!!

[TrackedPlayer](src/main/java/me/diademiemi/aprilfools2024/player/TrackedPlayer.java) contains the data structure for the players. This is what gets saved to disk and makes it persistent. Getting this right at first made it easy to add new dialogs.  

[EventListener](src/main/java/me/diademiemi/aprilfools2024/event/EventListener.java) contains the tracking code that actually sees what players do like tracking stats, block places, movement. Based on this it shows the popups dependent on booleans and sets those booleans.