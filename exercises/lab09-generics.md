# 9. gyakorlat

* [Java 21 Docs](https://docs.oracle.com/en/java/javase/21/docs/api/index.html)

## Feladatok

### 1. feladat

Készítsen a `MultiSetStructureTest` szerint olyan osztályt, amely `E` típusú elemek multiplicitásos halmazát reprezentálja.
Ennek adattagja leírja, hogy milyen elemből hány darab van a halmazban.
Ezt az adatszerkezetet zsáknak (bag) is szokták nevezni.

Az osztály konstruktora a paraméterül kapott elemekkel tölti fel kezdetben a zsákot. Mivel vararg-ot vár paraméterül (`E... elems`), ezért fordításkor warning-ot dob a fordítóprogram. Használjuk a `@SafeVarargs` annotációt.

Elemeket az `add()` művelettel adhatunk a zsákhoz.
Ha az elem még nem volt benne a zsákban, kerüljön bele `1` multiplictással,
ha pedig már benne volt, akkor nőjön meg eggyel a multiplicitása.
A visszatérési érték a megnövelt multiplicitás legyen.

A `getCount()` a paraméter multiplicitását kérdezi le.
Ha ez nem szerepel a zsákban, legyen `0` az eredmény.

Az `intersect()` két zsák metszetét állítja elő.
Ebben azok az elemek lesznek benne, amelyek mindkettőben megtalálhatóak, ennek a multiplicitása a kisebbik.
A metódus egyik eredeti zsákot se változtassa meg, az eredmény egy új `MultiSet` objektum legyen.

A `countExcept()` megadja a zsákban található összes elem darabszámát (multiplicitással együtt), de a paraméter elemeit nem veszi figyelembe. (Ez a metódus valamiért hiányzik a `MultiSetStructureTest`-ből... Legyen akkor `public int countExcept(Set<E> notCounted)` a szignatúrája.)

A `size()` metódus összeszámolja a zsákban található összes elemet (összeadja a darabszámokat).

A következő módon tesztelendő:

- `multiSetInteger`, `multiSetString`: a névben megadott típusú zsák
    - Adjunk hozzá pár elemet az `add()` metódussal, illetve a konstruktorban, és vizsgáljuk meg a `getCount()` eredményét.
- `intersect`, `countExcept`: hozzunk létre két zsákot, és próbáljuk ki rajtuk az `intersect()` és `countExcept()` függvényeket

### 2. feladat

Az `OrganiserStructureTest` alapján készítsünk olyan osztályt, amely adatokat tárol sorban az `elems` adattagjában.
A másik adattag pozíciópárokat (cseréket) tartalmaz.

A konstruktor a megkapott adatok alapján feltölti az `elems` adattagot.
Kezdetben cserék nincsenek beállítva.

-   A konstruktor kódjára figyelmeztetést fog adni a fordítóprogram.
    Mivel a megvalósításban most biztosan nem fog veszélyes kód szerepelni, a konstruktor megkaphatja a `@SafeVarargs` annotációt.

A `get()` metódusnak legyen kétféle paraméterezése.

-   Az egyik az `elems` egy érvényes indexét veszi át, és visszaadja az indexelt elemet.
    Feltételezhető, hogy a paraméter érvényes.
-   A másik változat mindegyik eltárolt elemet visszaadja egy listában.
    - Vigyázzunk, hogy ne szivárogjon ki az osztály belső állapota!

Az `addSwap()` művelet egy egész számokból álló párt ad a `swaps` adattaghoz.

-   Mivel a Javának nincsen beépített pár/rendezett n-es adatszerkezete,
    az adattag [`Map.Entry`](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Map.Entry.html) típusú elemekből áll.
    -   Ez `Integer` típusparamétereket kap, mert típusparaméterek nem lehetnek primitívek.
-   A [Map.entry(from, to)](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Map.html#entry(K,V)) hívással készíthető ilyen "pár".

A `swap()` segédmetódus cserélje meg a két megadott indexű elemet az `elems` adattagban.

-   Ez a metódus ne látszódjon az osztályon kívül.
-   Tipp: átmeneti változó tárolja el az egyik értéket.

A `runSwaps()` sorban végrehajtja a `swaps` listában leírt cseréket.

-   Az egyes cserék végrehajtásához a `swap()` hívandó meg.

Az osztály szöveges reprezentációja ilyen alakú legyen: `[1 3 5 7 9 ]` vagy `[d a c b e ]`. **Erre utal a *textual representation* utalás a structure testben.**

Írj kétféle paraméterezéssel tesztesetet (`Integer` és `char`). Állítsd elő a `[4 2 1 3 5 ]` és `[d a c b e ]` szöveges reprezentációjú `Organiser` struktúrát.

### 3. feladat (beadandó)

A `RangedStackStructureTest` alapján készítsünk vermet ábrázoló osztályt, amelybe egyszerre több elem tehető be/vehető ki. (Sajnos a `RangedStackSuite` osztály rosszul van összerakva a tesztek között!)

Lehessen üresen is elkészíteni, és másoló konstruktorral is.
Ez utóbbi egy másik `RangedStack` példányhoz hasonló tartalmú vermet készít el, de az adattagjaik ne egy közös listára mutassanak (aliasing).

A következő módon tesztelendő.

- `empty`: készüljön el egy üres `RangedStack` és egy másolata
    - Mindkét esetben: akárhány elemet veszünk ki (pl. `0`, `1` vagy `100` elemet egyszerre), a kimenet üres lista.
- `testString`, `testInteger`: mindkét típusra készüljön el `6` elemből egy `RangedStack` (pl. egész típus esetén a `2`, `4`, `6`, `8`, `10`, `12` elemekből), és legyen egy másolata is
    - Az eredetiből vegyünk ki sorban `1`, majd `2`, majd `3`, majd `100` elemet. Az elvárt kimenetek sorban `[12]`, `[10, 8]`, `[6, 4, 2]` és az üres lista.
    - A másolatból vegyünk ki `100` elemet, majd megint `100` elemet. Az első lépés elvárt kimenete `[12, 10, 8, 6, 4, 2]`, a másodiké egy üres listaí.
    
