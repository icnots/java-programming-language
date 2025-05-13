---
title: Minta zárthelyi
...

<!--
Compile as:
pandoc --strip-comments zh-minta-Rental.md -H stilus5.css -o for-students/zh-minta-Rental.html
-->

## Tesztelés

A feladathoz meg vannak adva strukturális és funkcionális JUnit 5 tesztelők, utóbbiból a `CarRental` osztályhoz három érhető el.
A megoldásokat ezek alapján kell elkészíteni, és a feladatrészek teljesítettségének előfeltétele, hogy a tesztelő kódok helyes eredménnyel fussanak le.

## A feladat összefoglaló leírása

A feladatban egy autókölcsönző leegyszerűsített működését fogjuk szimulálni.

A programhoz tartozik egységtesztelő, amely az egyes osztályok funkcionalitását teszteli.
A fájlok megfelelő könyvtárakba szervezése része a feladatnak.
Elérhető továbbá egy mintafájl (`cars.txt`).

A feladat megoldása során használható a [Java API dokumentáció][javaapi21],
ennek egyes részeire közvetlenül is hivatkozik a szöveg.

## A feladat részletes ismertetése

### `Car`

A `rental.Car` osztály egy autót reprezentál.

- Az osztály konstruktora beállítja a megfelelő adattagokat.
- Az `isValidLicensePlate` metódus megvizsgálja, megfelelő-e egy rendszámtábla.
    -   Akkor az, ha pontosan 7 karakter hosszú: 3 nagybetűből és 3 számjegyből áll, amelyeket egy szóköz választ el egymástól.
    -   *Tipp*: a metódusban használható [a `Character` osztály `isUpperCase()`][isuppercase] és [`isDigit()` metódusa][isdigit].
- A `make` metódus a következőket teszi.
    1. Először ellenőrzi, hogy a paraméterek megfelelőek.
        -   A márkát tartalmazó paraméter akkor megfelelő, ha csak betűkből vagy szóközből áll és legalább 2 karakter hosszú.
            Azt, hogy ezek a karakterek milyen eloszlásban szerepelnek, nem kell vizsgálni.
        -   A rendszámtáblát az `isValidLicensePlate` feltétele alapján vizsgálja meg.
        -   A kölcsönzési díjat tartalmazó paraméter akkor helyes, ha pozitív és értéke legfeljebb a maximális kölcsönzési díj.
    2. Amennyiben minden megfelelő, akkor létrehozza és visszaadja a paramétereknek megfelelő `Car` típusú objektumot. Különben `null`-t adjon vissza a metódus.
        -   *Tipp*: a metódusban használható a `Character` osztály [`isLetter()`][isletter] metódusa.

- A `decreasePrice` metódus az aktuális autó kölcsönzési díját `10`-zel csökkenti, ha az eredeti kölcsönzési díj `10`-nél nagyobb, feltéve, hogy nem egyezik meg a maximális kölcsönzési díjjal.

- Az `isCheaperThan` metódus eldönti, hogy az aktuális autó kölcsönzési díja alacsonyabb-e a paraméterben kapott autó kölcsönzési díjánál.

- Az autók szöveges reprezentációja a `CarTest`ben leírtakat kövesse.
    -   *Tipp*: `"format text goes here".formatted(...)` alakú kifejezést célszerű használni. Ennek leírását [lásd itt][fmtstring].
        -   Az árat egy tizedesjegy pontossággal, öt karakter szélesen jelenítse meg.
    -   Pl. `Volvo (JSD 856) 500,0 EUR`, `BMW (ABC 123)  40,0 EUR`, `Alfa Romeo (DEF 234)   9,0 EUR`.

### `CarRental`, 1. rész

A `rental.CarRental` osztály egy egyszerűsített autókölcsönzőt reprezentál.

- A `cars` adattag mutatja, hogy milyen autókat lehet kölcsönözni.

- A konstruktor egy fájlnevet kap paraméterként.
    - A bemeneti fájl minden sora egy autót tartalmaz `márka:rendszám,kölcsönzési díj` formátumban.
        - Lásd a `cars.txt` példa fájlt. Ebben az első három sor és az utolsó érvényes.
    - A metódus dolgozza fel a fájlt, szűrje ki belőle a hibás adatokat, majd tárolja el az autókat a listában.
        - Ha a sor nem megfelelő szerkezetű, vagy a kölcsönzési díj nem konvertálható számmá, vagy a megadott adatokból a `Car` objektum nem hozható létre, akkor a sort figyelmen kívül kell hagyni és a feldolgozást a következő sorral kell folytatni.
    - Ha a fájl nem létezik, vagy nem olvasható, akkor az autók listája legyen üres, a konstruktor pedig ne engedje ki a keletkező kivételt.
    - *Tipp*: Az, hogy egy szöveg egy valós számot tartalmaz, ellenőrizhető úgy, hogy elkapjuk a [`Double.parseDouble()`][parsedouble] által számmá történő konvertáláskor dobott [`java.lang.NumberFormatException`][nfe] kivételt.

- A `numberOfCars` metódus a kölcsönzőből kölcsönözhető autók számát adja vissza.

- A példányok szöveges reprezentációjában az autók egy-egy sorban szerepeljenek, a saját szöveges reprezentációjuk szerint.
    -   Olyan sorrendben szerepeljenek, amilyen sorrendben a konstruktor beolvasta.
    -   Az utolsó autó után is legyen sortörés.

## `CarRental`, 2. rész

Az osztályban definiáljuk a következőket:

- Az `insertionSort` metódus a kölcsönözhető autók listáját beszúró rendezéssel a kölcsönzési díjuk szerint növekvő sorrendbe rendezi.
    -   Tehát a lista elején az az autó áll, amelynek a kölcsönzési díja a legkisebb, a végén pedig az, amelynek a legnagyobb.
    -   A beszúró rendezés a következőképpen működjön.
        1.  Feltesszük, hogy az egy elemből álló lista eleve rendezett.
        1.  Minden menetben, minden egyes elemére a listának az 1-es indexűtől kezdve, egészen a lista legutolsó eleméig, ellenőrizzük, hogy az aktuális elem hogyan viszonyul a már rendezett részlistában lévő elemekhez.
            a.  Az aktuális elemnél nagyobb elemeket jobbra toljuk.
            a.  Ha egy kisebb elem következik, vagy pedig a lista végére érünk, az adott elemet beszúrhatjuk.

- A `weightedAverage` metódus az autók árainak súlyozott átlagát számolja ki.
    - Ha nincsenek autók, akkor a metódus `-1.0`-t adjon vissza.
    - Különben minden autó árát szorozzuk meg azzal a számmal (súllyal), ahányadik az autó a listában. Ezen szorzatok összegét osztjuk el a súlyok összegével. 
        - Az első (`0` indexű) autó súlya `1`.

## `CarRental`, 3. rész

Az osztályban definiáljuk a következőket:

- A `rentCheapest` metódus egy autó kölcsönzését szimulálja.
    - Ha a kölcsönzés elején egyetlen autó sincs a kölcsönzőben, akkor a metódus `null`-t adjon vissza.
    - Különben az ügyfél mindig az `insertionSort` alapján legalacsonyabb árú autót kölcsönzi.
        - Ezt kivesszük a `cars` listából, és lesz a metódus visszatérési értéke.

- A `sale` metódus mindegyik autó árát véletlenszerűen vagy csökkenti, vagy nem.
    -   Az autókat egy listába gyűjtsük össze, ez lesz a metódus visszatérési értéke.
    -   *Tipp*: használható a [`java.util.Random`][random] osztály véletlen adat generálására.

[javaapi21]: https://docs.oracle.com/en/java/javase/21/docs/api/index.html
[fmtstring]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Formatter.html#syntax
[arraylist]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html
[parsedouble]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Double.html#parseDouble(java.lang.String)
[nfe]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/NumberFormatException.html
[isdigit]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#isDigit(char)
[isletter]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#isLetter(char)
[isuppercase]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/Character.html#isUpperCase(char)
[random]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Random.html
