# Programozási nyelvek Java vizsga, 2024/2025-2 (2025. 05. 23.)


## Feltételek

Végezd el a következőket **most**: győződj meg róla, hogy semmilyen kommunikációs eszköz nincs nálad.

- **Tedd el** a telefonokat, fülhallgatókat, tableteket, okosórákat stb. (lehetőleg csak a sajátodat)
- **Zárj be** minden csevegőprogramot, levelezőklienst (beleértve a Teams-t is).
- **Tartsd ezeket kikapcsolva/távol** a vizsga alatt.

Kérjük a szabályok betartását a zárthelyi kezdetétől a befejezéséig, a terem elhagyásával bezárólag.

- Csalás esetén (pl. segítség adása vagy fogadása, illetve nem megengedett segédanyagok használata) a félévben nem szerezhető érdemjegy.
- Tilos a vizsgamegoldás bármely részét megosztani a vizsga napján.

A kóddal kapcsolatban.

- Amikor egy név vagy azonosító konkrétan meg van adva, azt karakterre pontosan úgy kell használni.
- Elvárt a gyakorlaton bemutatott Java konvenciók követése.

Beküldés.

- Célszerű már 10 perccel a záthelyi vége előtt feltölteni a `java` forrásfájlokat `zip`-be csomagolva a `TMS`-be.
- Ne legyenek a `zip`-ben a strukturális tesztek, `class` fájlok és a demo!


## Általános

Ha a szövegszerkesztőd IDE-funkciókat biztosít bővítmények segítségével, ezeket a vizsga elején le kell tiltani. *(Pl Visual Studio Code bővítmények)*


Nyisd meg a [`struturetests`](./structuretests/) mappát, és használd az egyes strukturális teszteket benne. (Vagy letöltheted egy zipben [innen](./structuretests.zip).)

-   A feladatok megoldása közben az egyes strukturális tesztekkel dolgozz a felsorolt sorrendben, ne a teljes suite-tal.
    -   Ha kész vagy a teljes feladattal, a maximális pontszámért a teljes teszt suite-nak sikeresnek kell lennie.
-   Egy osztály pontosan `0` pontot ér, ha a hozzá tartozó strukturális tesztje nem fut le maradéktalanul sikeresen.
-   Nem módosíthatod sem a strukturális, sem a suite tesztek kódját.
-   A részeket a megadott sorrendben oldd meg. Nem léphetsz tovább a következő részre, amíg az előzőt teljesen meg nem valósítottad.
-   A tesztpontokat pl. `6T` jelzi.


## Okosotthon szimuláció (50 pont)

Ebben a feladatban egy olyan okosotthon központ működését szimuláljuk, amely különféle IoT-eszközöket (okoseszközöket) kezel és vezérel.
A rendszer nem küld valódi internetes kéréseket, nem használ bonyolult könyvtárakat vagy külső csomagokat, csupán egy leegyszerűsített modellként működik.

Minden esetben (hacsak nincs másképp feltüntetve) a mezőkhöz tartozó getter metódusok egyszerűen visszaadják a mezők értékét.

## `BaseModel`, `InteractiveDevice`, `ActionDevice` (30 pont – 1. rész)

Kétféle eszköztípust különböztetünk meg: `InteractiveDevice` és `ActionDevice`. Ezek segítenek kategorizálni a különböző eszközöket:

- `ActionDevice`: Olyan eszközök, amelyek konkrét műveleteket végeznek, például hűtők, kávéfőzők vagy tévék. Ezek meghatározott utasítások alapján működnek.
- `InteractiveDevice`: Főleg világításhoz kapcsolódó interaktív eszközök, például LED szalagok vagy lámpák, amelyek együtt kezelhetők és összehangolhatók egymással.

### `BaseModel` (7 pont)

A `BaseModel` az `IotFunction` interfészt megvalósító osztály, amely minden okoseszköz közös jellemzőit tartalmazza. A konstruktor két paramétert vár: egy tetszőleges azonosítót (szövegként), amely például sorozatszámként is funkcionálhat, illetve egy kategóriát (ami a `Category` felsorolási típusból kerül ki).

- Paraméter nélküli `IllegalArgumentException` kivételt dobódik, ha az azonosító kevesebb mint 3 karakter hosszú vagy `null`.
- A kategória nem rendelkezik alapértelmezett értékkel.
- Kezdetben minden eszköz kikapcsolt állapotban van.

#### A `BaseModel` metódusai

- A `powerOn` és `powerOff` metódusok be- és kikapcsolják az eszközt.
- A `toggleState` metódus nem valósít meg semmilyen funkciót a `BaseModel` osztályban, egyszerűen csak a `BaseModel has no state` szöveggel tér vissza.
- Az osztály szöveges reprezentációja a következő formátumot követi: `Device: <osztálynév>, Type: <kategória>, Identifier: <azonosító>, PowerStatus: <állapot>`. Figyeljünk arra, hogy a "Device" után az osztály egyszerű neve szerepel (tehát a csomagnév nélküli osztálynév).
Példa:
  ```
  Device: BaseModel, Type: FRIDGE, Identifier: FRIDGE1-IDx, PowerStatus: false
  Device: ActionDevice, Type: LIGHT, Identifier: led1-IDx, PowerStatus: false
  Device: InteractiveDevice, Type: LED_STRIP, Identifier: led2-IDx, PowerStatus: false
  ```

- Két eszközt akkor tekintünk egyenlőnek, ha az azonosítójuk első három karaktere megegyezik, és ugyanabba a kategóriába tartoznak.

#### A `BaseModel` funkcionális tesztelése

Erre az osztályra nem szükséges funkcionális teszteket írni.

### `InteractiveDevice` (8 + 4T pont)

- A `BaseModel` osztályt terjeszti ki.
- Az osztály tartalmaz egy kapcsolati listát, amely a vele összepárosított eszközöket tárolja. Ez lehetővé teszi például a lámpák szinkronizálását, vagy több eszköz összehangolt vezérlését.
- Az `InteractiveDevice` csak `LED_STRIP` vagy `LIGHT` kategóriába tartozó eszköz lehet. Minden más esetben `UnsupportedDevice` kivételt eredményez az osztály példányosítása.

#### Az `InteractiveDevice` metódusai

- A `getConnectionLink` metódus visszaadja a kapcsolt eszközök listájának másolatát.
- A `linkDevice` metódus új eszközt ad a listához, ha az még nincs rajta. Segédfüggvényként használják a következő metódusok:
  - A `bulkLinkSameType` több eszközt ad a kapcsolt eszközök listájához. Azokat kihagyja, amelyeknél nem sikeres az egyenlőség vizsgálat a jelenlegi eszközzel összevetve.
  - A `bulkLinkAnyType` is több eszközt ad a kapcsolt eszközök listájához, viszont az egyenlőség vizsgálatnak nem kell teljesülnie a hozzáadandó eszközökre.
- A `syncLights` metódus beállítja minden kapcsolt eszköz fényének színét (ezt csak akkor tudja megtenni, ha világításra képes az adott eszköz). Visszatérési értéke a sikeresen szinkronizált fények száma.
- A `toggleState` metódus elindítja a fények szinkronizációját (színük beállítását), ha az eszköz már be van kapcsolva. Ha ki van kapcsolva, akkor egyszerűen csak bekapcsolja az eszközt. A visszatérési érték az előbbi esetben `Lights synchronized`, az utóbbi esetben pedig `Device turned on`.

#### Az `InteractiveDevice` funkcionális tesztelése

Minden alapfunkciót teszteljünk; a `bulkLinkSameType`, a `bulkLinkAnyType`, a `syncLights` és a `toggleState` metódust is.

#### Tipp

Továbbhaladás előtt fontos, hogy az `InteractiveDevice` osztály **strukturális** és **funkcionális** tesztjei is sikeresen lefussanak.

### `ActionDevice` (8 + 3T pont)

- A `BaseModel` osztályt terjeszti ki.
- Az osztály műveletek típusának és részleteinek kulcs-érték párjait tárolja. Mindkettő egyszerű szöveg, az utóbbi pedig pontosvesszőkkel van általában elválasztva.
- A `lastAction` adattag kezdeti értéke a `None` szöveg, mivel kezdetben még semmilyen művelet nem lett végrehajtva.
- Az `ActionDevice` **nem** tartozhat `LED_STRIP` vagy `LIGHT` kategóriába, ekkor `UnsupportedDevice` kivételt eredményez az osztály példányosítása.

#### Az `ActionDevice` metódusai

- A `getActions` metódus visszaadja a tárolt művelet kulcs-érték párok másolatát.
- Az `addAction` metódus egy művelet a típusát és részleteit kapja meg paraméterként és adja hozzá azokat a már tárolt párokhoz. Nem szükséges a pontosvesszők formátumellenőrzése.
  - Példa: `"TV_CHANNEL", "Netflix;HBO;Sport"`, ahol az előbbi szöveg a művelet típusa, az utóbbi pedig a részletei pontosvesszőkkel elválasztva.
- A `getAvailableActions` metódus vesszővel elválasztva adja vissza az összes tárolt művelet típusát. Ha nincs ilyen, akkor a `No actions available` szöveggel tér vissza.
  - Példa: `"OpenChannel, RadioControl"`
- A `performAction` metódus ellenőrzi, hogy tárolva van-e egy adott művelettípus. Ha igen, akkor a `Performed: <típus> -> <részletek>` szöveggel tér vissza, értelemszerűen behelyettesítve a művelet típusát és részleteit. Ha nem, akkor az `Unknown action: <típus>` szöveget adja vissza, a típust behelyettesítve.
- A `toggleState` metódus bekapcsolja az eszközt és végrehajtja az összes tárolt műveletet (a `performAction` segítségével). Ha nincs mit végrehajtani, akkor egyszerűen csak visszaadja a `No actions available` szöveget, ellenkező esetben viszont visszatér egy összegzéssel a végrehajtott műveletekről. Példa összegzés:
    ```
    Performed: OpenChannel -> Channel4;Decrease Volume
    Performed: TurnOff -> Power off the device
    ```

#### Az `ActionDevice` funkcionális tesztelése

A `performAction` és a `toggleState` metódusokat paraméterezett tesztekkel ellenőrizni kell. Ebben segíthet az alábbi kódrészlet:

```java
@ParameterizedTest
@CsvSource({
  "TurnOn, Power on the device, Performed: TurnOn -> Power on the device",
  "TurnOff, Power off the device, Performed: TurnOff -> Power off the device",
  "Reboot, , Unknown action: Reboot"
})
```

#### Tipp

Továbbhaladás előtt fontos, hogy az `ActionDevice` osztály **strukturális** és **funkcionális** tesztjei is sikeresen lefussanak.

## `Supplier` és `SmartHaven` (20 pont – 2. rész)

Az eszközök összefogásához és kezeléséhez szükség van egy kezelő osztályra (ez lesz a `SmartHaven`), illetve egy eszközgenerálóra (ez lesz a `Supplier`), amely létrehozza a szükséges példányokat.

### `Supplier` (6 pont)

- A `Supplier` osztály `bringSupplies` metódusa a paramétereként megkapott darabszám alapján generál eszközöket, a következő módon:
  - Minden első két eszköz `InteractiveDevice`, váltakozva `LIGHT` és `LED_STRIP` kategóriákkal.
  - Minden harmadik eszköz `ActionDevice`, sorrendben `TV`, `FRIDGE` és `COFFEE_MACHINE`.
  - Az azonosítók automatikusan generálódnak, a számuk mindig eggyel nő eszköz fajtától függően. Példa: `led1-IDx`, `TV1-ADx`, `led2-IDx`, `FRIDGE2-ADx`, stb.

Példa:
```
Device: InteractiveDevice, Type: LIGHT, Identifier: led1-IDx, PowerStatus: false
Device: InteractiveDevice, Type: LED_STRIP, Identifier: led2-IDx, PowerStatus: false
Device: ActionDevice, Type: TV, Identifier: TV1-ADx, PowerStatus: false
Device: InteractiveDevice, Type: LIGHT, Identifier: led3-IDx, PowerStatus: false
Device: InteractiveDevice, Type: LED_STRIP, Identifier: led4-IDx, PowerStatus: false
Device: ActionDevice, Type: FRIDGE, Identifier: FRIDGE2-ADx, PowerStatus: false
Device: InteractiveDevice, Type: LIGHT, Identifier: led5-IDx, PowerStatus: false
Device: InteractiveDevice, Type: LED_STRIP, Identifier: led6-IDx, PowerStatus: false
Device: ActionDevice, Type: COFFEE_MACHINE, Identifier: COFFEE_MACHINE3-ADx, PowerStatus: false
```

#### A `Supplier` funkcionális tesztelése 

Erre az osztályra nem szükséges funkcionális teszteket írni.

### `SmartHaven` (9 + 5T pont)

- A `SmartHaven` `BaseModel` objektumok listáját tárolja, ami lehetővé teszi számára, hogy bármennyi `InteractiveDevice` és `ActionDevice` fajtájú eszközt kezelni tudjon.

#### A `SmartHaven` metódusai

- A `turnOnAllDevices`, `turnOffAllDevices` és `toggleAllDevices` metódusok minden eszközre lefuttatják a megfelelő műveleteket.
- A `toggleLightsForInteractiveDevices` metódus csak az `InteractiveDevice` fajtájú eszközökön hajtja végre a megfelelő műveletet.
- A `printAvailableActions` metódus kiírja a standard kimenetre a listában tárolt `ActionDevice` fajtájú eszközök összes műveletét.
- Az `executeDeviceActions` metódus végrehajtatja az `activate;start` műveletet a listában tárolt `ActionDevice` fajtájú eszközökkel.
- A `syncLightsForInteractiveDevices` metódus megpróbálja szinkronizálni az összes lámpát, azaz beállítani azok fényének paraméterként kapott színre. A visszatérési értéke a sikeresen szinkronizált eszközök száma.
- A `linkDevicesAfterNth` metódus megkeresi az `n`-edik `InteractiveDevice` fajtájú eszközt, és összekapcsolja az utána következő összes azonos fajtájú eszközzel.

#### A `SmartHaven` funkcionális tesztelése

- Készítsünk funkcionális teszteket a következő metódusokhoz:
    - `toggleLightsForInteractiveDevices`
    - `toggleAllDevices`
    - `syncLightsForInteractiveDevices`
    - `linkDevicesAfterNth`
