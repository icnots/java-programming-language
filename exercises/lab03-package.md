
## Demo

### 1. demó

Szervezze az előző órai `Point` osztályt és az azt bemutató `PointMain` főprogramot a `point2d` csomagba.

1.  A `Point` osztály ne látszódjon ki a csomagból: ne legyen publikus.
1.  Legyen paraméter nélküli konstruktora is, amely defaultként 0-kat állít be.
1.  Hozzon létre getter és setter metódusokat az adattagok megváltoztatására. Amennyiben a paraméterül kapott érték 1000000-nál nagyobb, akkor váltson ki `IllegalArgumentException`-t.
1.  Készítse el a `pointless.AnotherMain` osztályt.
    Ez a `pointless` csomag `AnotherMain` osztálya lesz.
    A megfelelő fájl: `pointless/AnotherMain.java`.
    -   Próbálja példányosítani a `Point` osztályt az `AnotherMain` osztályból.
        Figyelje meg a hibaüzenetet.

## Feladatok

### 1. feladat

Kísérletezzünk egy kicsit az osztályok láthatóságával.
A `Point` osztály váljon láthatóvá más csomagokból is.

*  Az `AnotherMain` most már valóban készítsen `Point` példányokat, két módon.
  * A teljesen minősített neve használatával.
  * Egy `import` segítségével.
*  Készítse el a `PointMainInDefaultPackage` osztályt a névtelen csomagban.
  * Ebből használható-e a `Point`: készíthető-e `Point` példány a `PointMainInDefaultPackage` osztályban?
  * Megfordítva: ez az osztály használható-e a `Point` osztályból?


### 2. feladat

Készítsen `plane.PublicCircle` osztályt, amellyel egy síkbeli kört reprezentálunk.
Egy körnek van középpontja, `double` típusú `x`, `y` adattagja, amelyeket inicializáljunk `0.0`-ra, illetve `double` típusú sugara (`radius`), amelyet inicializáljunk `1.0`-re.
Az adattagok legyenek publikusak benne.

* Írjon `getArea()` metódust, amely ismét a kör területével térjen vissza (használható a `Math.PI` konstans).
* A `plane.but.not.flying.CircleMain.main` metódus a következőket tegye.
  -   Példányosítson egy `PublicCircle` objektumot.
  -   Írja ki a területét.
  -   Állítsa be a középpontját `(5, 2)`-re, sugarát `10.0`-re.
  -   Írja ki újra a területét.
* Készítsen az előzőhöz hasonló `plane.Circle` osztályt, de ebben az adattagokhoz csak megfelelően megírt getter és setter metódus férhessen hozzá.
  * Az utóbbi váltson ki egy `IllegalArgumentException` kivételt, ha a sugara `0.0` vagy negatív szám lenne.
  * A `CircleMain.main` próbálja ki az új funkcionalitást.
    - A kivételt nem kell elkapni, azzal az anyag későbbi részén foglalkozunk.
* A `Circle` osztályhoz készítsünk konstruktort, az adattagok beállítását ezzel végezzük.
  * A konstruktor a setterhez hasonlóan válthasson ki kivételt.
  * A `CircleMain.main` próbálja ki az új funkcionalitást.


### 3. feladat

Készítsen `string.utils.IterLetter` osztályt.

* Ennek a konstruktora `String` paraméterű.
  -   Ha ez `null`, váltson ki `IllegalArgumentException` kivételt.
* Az osztálynak legyen egy `printNext()` metódusa.
  -   Ez egy új sorban írja ki a szöveg első karakterét, majd újabb hívásra a második karakterét és így tovább.
  -   Ha a szöveg összes karakterét kiírtuk a képernyőre, akkor a metódus egy üres sort ír ki minden további hívásra.
* Készítse el a következő, főprogramot tartalmazó osztályokat: `Main` (a névtelen csomagban), `stringmain.Main`, `string.main.Main`, `string.utils.Main` és `string.utils.main.Main`.
  -   Ezek közül egy kivételével mindegyiknek az a feladata, hogy áthívjon egy másik `main`re.
        Tehát egy négy hosszú híváslánc alakul ki.
  - A sorrend szabadon megválasztható.
  - Tipp: az `X` osztály `y` (osztályszintű) metódusát így lehet meghívni: `X.y(...)`.
  - Milyen formában kell most `X` nevét használni?
  - Hányfajta sorrend létezik?
  - Néhány sorrend érvénytelen. Melyek? Miért?
  -   Az utoljára érintett főprogram két parancssori paramétert kap meg.
        A kód a `printNext` metódust annyiszor hívja meg a második paraméter szövegével, amennyi az első paraméterben kapott szám értéke.
  -   Futtassa mindegyik főprogramot.
        Paraméterként válasszon különféle szövegeket, az üreset is (ez `""` alakban adható át).
* Az `IterLetter` `reset()` metódusa újrakezdi a szöveg végigjárását.
  -   Tehát a soron következő `printNext` hívások az első karaktertől folytatják a kiírásokat.
  -   A főprogramok egyszer hívják meg ezt a metódust `m` kiírás után, és még `k` kiírást tegyenek meg.
        Itt `m` és `k` a harmadik és negyedik parancssori paraméter.
* Legyen az osztályban egy `hasNext()` metódus is. Ez pontosan akkor tér vissza igaz értékkel, ha van még kiírható betű.
  -   A főprogramok hívják ezt meg az újrakezdés előtt és után, valamint közvetlenül a program befejeződése előtt.


## Gyakorló feladatok

### 1. gyakorló feladat

A `zoo.animal.Panda` osztály egy pandát reprezentál.

* Az osztály a panda nevének, életkorának és tartózkodási országának eltárolására alkalmas.
    Ehhez értelemszerű típusú és nevű adattagokat kell használni.
* Az osztálynak két konstruktora van.
  * Az első egy újszülött pandát ír le: megkapja és eltárolja a másik két adatát.
  * A másik konstruktor a név kivételével kapja meg az adatokat.
        Ennek a pandának az legyen a neve, hogy `Y years old foundling from C`, ahol `Y` és `C` helyén az életkor és az ország szerepel.
* Az osztály rendelkezik egy `happyBirthday()` metódussal is.
    Ez kiírja a panda nevét, országát és az eggyel megnövekedett életkorát is.
    A metódus egy számot is kap paraméterül (`limitYear`),
    amennyiben az életkor ezt meghaladja,
    akkor a pandát visszaköltöztetik a Kínai Népköztársaságba.
* A `zoo.keeper.Crikey` főprogramja próbálja ki a fentieket.

### 2. gyakorló feladat

Bővítse a `string.utils` csomagot a `string.utils.IterWord` osztállyal.

* Az osztály konstruáláskor egy szöveget kap meg.
* Az osztály `printNext()` metódusa új sorban a képernyőre írja a szöveg következő szavát.
* Az osztálynak szintén legyen `reset()` és `hasNext()` metódusa.
* A már létező főprogramok mellé kerüljön egy-egy `WordMain`, amely bemutatja az osztály használatát.

### 3. gyakorló feladat

Készítse el a `magic.library.Incantation` osztályt, amely egy varázslatos ráolvasást ábrázol.
Ez egy `text` szöveges és egy `index` egész szám adatot tárol.

* Az osztály egyik konstruktora átveszi és beállítja a két paraméter értékét.
  -   Ha az előbbi `null`, váltson ki `IllegalArgumentException` kivételt.
* A másik konstruktor egy `Incantation` példányt kap meg, és ennek az adattagjaiból tölti fel a sajátokat.
* Legyen mindkét adattagnak gettere, az `index`nek settere is.
* Az osztály `enchant()` metódusa egy `Incantation` példányt (`otherInc`) kap meg és egy `isPrepend` logikai értéket.
    A metódus az alábbiak szerint módosítja a hívott példány szövegét.
  *  Először megpróbáljuk felvenni a `text` szöveg `index`edik szavát.
    - Ha például `index` értéke `3`, akkor a harmadik szóról van szó.
    - Tipp: a `String` osztály `split` metódusát érdemes használni.
  * Ha nincsen ilyen szó, mert `index` túl magas vagy alacsony (akár negatív is lehet),
            a metódus hamis visszatérési értéket ad.
  * A felvett szót `otherInc` szövege elé írjuk, ha `isPrepend` értéke igaz, és mögé, ha hamis.
    -   Egy szóköz is kerüljön a régi szöveg és az új szó közé.
  * Az `index` adattag eggyel megnő/lecsökken `isPrepend` értékétől függően.
  * A metódus igazzal tér vissza, jelezve, hogy a szöveg megváltozott.
* A `magic.Soliloquy` osztály `reciteIncantations()` metódusát a főprogram fogja hívni, és a következőket teszi.
  * Két `Incantation` példányt kap meg (`inc1` és `inc2`), valamint egy `idx` egész és egy `startWithAppend` logikai értéket.
  * Háromszor hívja meg az `inc1` példányra az `enchant` metódust. Az első paraméter mindegyik esetben `inc2`.
    -   A második paraméter az első hívásban `startWithAppend` ellentéte.
    -   A másodikban `startWithAppend`.
    -   Harmadjára `true`.
  * Mindegyik hívás után írja ki a kifejezés visszatérési értékét és mindkét objektum adatait.
    -   Ez utóbbiakat a getterek segítségével lehet elérni.
    -   A formátumhoz lásd a lenti példát.
    -   A kiírás kódja a `printStatus` segédfüggvénybe kerüljön.
  * Az első kiírás után `inc1` `index` adattagjának értéke álljon `idx`re.
* A `magic.Soliloquy` osztályban levő főprogram hat parancssori paramétert vár (`argN` lentebb) és a következőket teszi.
  * Feltehető, hogy a paraméterek száma és tartalma megfelelő, nem kell ellenőrizni.
  * A főprogram elkészíti az `inc1`, `inc2` és `inc3` `Incantation` példányokat. Az első kettő tartalmát az első négy parancssori paraméter értékei alapján inicializálja, a harmadikat pedig a másodikból.
    -   Az első és harmadik parancssori paramétert idézőjellel (`"`) kell majd körbevenni, mert szóközöket tartalmaznak.
  * Ezután a következőket teszi.
    -   Meghívja a `reciteIncantations` segédfüggvényt az `inc1, inc2, arg5, true` paraméterekkel.
    -   Beállítja `inc1` `index`ét `arg6` értékre.
    -   Meghívja a `reciteIncantations` segédfüggvényt az `inc1, inc3, arg5, false` paraméterekkel.
* Kipróbálás: a főprogram kapja meg a következő paramétereket: `programming is a creative activity`, `4`, `to be or not to be`, `-123`, `1`.
    Ennek hatására a kiírások legyenek az alábbiak.

```
true;7;programming is a fun and creative activity;-123;to be or not to be creative
true;1;programming is a fun and creative activity;-123;to be or not to be creative
true;0;programming is a fun and creative activity;-123;programming to be or not to be creative
false;0;programming is a fun and creative activity;-123;programming to be or not to be creative

true;3;programming is a fun and creative activity;-123;fun to be or not to be
true;1;programming is a fun and creative activity;-123;fun to be or not to be
true;2;programming is a fun and creative activity;-123;fun to be or not to be programming
true;1;programming is a fun and creative activity;-123;is fun to be or not to be programming
```

### 4. gyakorló feladat

Készítsen egy `game.utils.Vehicle` osztályt, amellyel egy játék járművét reprezentáljuk.
Egy járműnek van modelid-je (`int`), rendszáma (`String`), és két színállapota (`color1`, `color2` `int` típusú adatok).
A rendszámhoz készítsen setter és getter metódusokat.

Készítsen `game.Player` osztályt, amellyel egy játékost reprezentálunk.
Egy játékosnak van neve (`String`), IP-címe (`String`), egészségi állapota (`int`) és lehet járműve (`Vehicle`) (ha nincsen, akkor tároljunk `null` értéket).

A játékos osztályhoz készítsen `print()` metódust, amellyel ki lehet íratni egy játékos legfontosabb információit: nevét, IP-címét, egészségi állapotát, illetve járművének rendszámát (ha van).

Készítsen `game.Main` főprogramot, amelyben példányosít legalább 3 járművet és legalább 2 játékost.
Az egyik játékoshoz tartozzon jármű.
A főprogram írja ki a képernyőre a játékosok adatait.
