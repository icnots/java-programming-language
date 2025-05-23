# 10. gyakorlat

* [Java 21 Docs](https://docs.oracle.com/en/java/javase/21/docs/api/index.html)

## Feladatok

### 1. feladat

Készítsünk a `BookSuite` alapján könyveket.

Az osztály mindkét konstruktora az `initBook` metódust hívja meg.
A paraméter nélküli konstruktor a `default...` mezők szerint tölti fel az adattagokat, a másik előbb megvizsgálja a kapott adatokat a `checkInitData` metódus segítségével.
A vizsgálat `IllegalArgumentException` kivételt vált ki, ha az `author` szöveg rövidebb két betűnél, a `title` rövidebb négy betűnél, vagy ha `pageCount` nem pozitív szám.

A könyv ára az oldalszámmal megegyező összeg.

Teszteléshez használjuk az alábbi három könyvet.

```
John Steinbeck, Of Mice and Men, 107
Kozsik Tamás, Java programozás, 234
Alan Alexander Milne, Winnie-the-Pooh, 145
```

A könyvek elvárt szöveges alakja az alábbi.
A `decode()` metódus ilyen szövegekből alakít ki könyveket,
tesztelendő, hogy a visszakapott könyvek egyes adatai megegyeznek-e az eredeti példányéival.

- Tipp: szövegek elejéről és végéről a felesleges szóközök a `strip()` metódussal távolíthatók el.

```
John Steinbeck: Of Mice and Men; 107
Kozsik Tamás: Java programozás; 234
Alan Alexander Milne: Winnie-the-Pooh; 145
```

A `getShortInfo()` rövidített alakban írja le a könyvet.
A szerzők neveit iniciálékkal rövidíti, ezt a `getAuthorWithInitials()` valósítsa meg egy `StringBuilder` használatával.

```
J. Steinbeck: Of M; 107
K. Tamás: Java; 234
A. A. Milne: Winn; 145
```

Tesztelendő továbbá, hogy olyan könyveket, amelyek nem mennek át a `checkInitData` vizsgálatain, nem tudunk létrehozni, és `InvalidBookException` kivételt váltanak ki.
Tesztelendő, hogy ezek a kivételek tartalmazzák a könyv leendő szerzőjét és címét.

**Gyermekosztály**: `EBook`

Az `EBook` osztály konstruktora egy `Book` példány mellett a három új mezőnek megfelelő adatokat kap meg, ez utóbbiakat eltárolja.

A könyv ára az oldalszámnál `pdfSize` értékkel több.

Ha a fenti könyvek `pdfSize` értéke rendre 5, 10000 és 8, akkor a szöveges reprezentációik az alábbiak legyenek.
Itt a vásárlók szemét megtévesztő évtizedes gyakorlat szerint a valós árnál `0.01` egységgel kevesebb van feltüntetve, ha az ár `1000` egység vagy kevesebb.

```
EBook(John Steinbeck: Of Mice and Men; 107, $111.99)
EBook(Kozsik Tamás: Java programozás; 234, 10233 Ft)
EBook(Alan Alexander Milne: Winnie-the-Pooh; 145, £152.99)
```

Ezeket dekódolni nehéz lenne, a `decode()` metódus váltson ki `UnsupportedOperationException` kivételt.

**Gyermekosztály**: `PrintedBook`

Egy `PrintedBook` a `Book` szokásos adatai mellett kaphasson meg egy `CoverType` értéket, amit tároljon el az adattagba.
Egy `PrintedBook` a szokásos könyveknél hat oldallal többel rendelkezik.

Egy `PrintedBook` példányt egy `Book` példány adatai segítségével is elő lehessen állítani.
Ez legyen mindig keménykötésű.
Ez a konstruktor hívjon át az előzőre.

A könyv ára az oldalszám többszöröse legyen: puhafedelű könyvek esetén kétszerese, keménykötésűek esetén háromszorosa.

Amennyiben a könyveket a második konstruktorral állítjuk elő, a szöveges reprezentációjuk az alábbi alakú legyen.

```
John Steinbeck: Of Mice and Men; 113 (HARDCOVER)
Kozsik Tamás: Java programozás; 240 (HARDCOVER)
Alan Alexander Milne: Winnie-the-Pooh; 151 (HARDCOVER)
```

Ezt könnyű dekódolni, a `decode()` metódus itt legyen megvalósítva.

- Tipp: mivel a zárójelek a `String` osztály `split()` metódusában speciális jelentésűek, így használandó: `txt.split("[(]")`


**Könyvgyűjtemény**

A `BookCollection` tároljon el sok könyvet egy listában, és ezeket lehessen elmenteni és betölteni az alábbi formátumban.

```
Book--John Steinbeck: Of Mice and Men; 107
Book--abcd: ABCD; 123
EBook--EBook(abcd: ABCD; 123, 356.99$)
PrintedBook--abcd: ABCD; 129 (HARDCOVER)
```

Ha `EBook` vagy érvénytelen adatú könyv érkezne, a helyére egy `DamagedBook` példány kerüljön.

A mentést és töltést próbáljuk ki üres listával, egyetlen (alapértelmezett adatokkal elkészített) könyves listával, és egy mindenfélet (`EBook` és `PrintedBook` könyvet egyaránt tartalmazó) listával.

* **Ismert problémák a feladattal:**
  * A structure testek nem a névtelen package-ben vannak, de nem is az adott osztály mellett, hanem egy harmadikban. => Inkonzisztencia.
  * A structure testek  (`PrintedBook` és `EBook`) nem kérik a `Book` osztályból való öröklődést, csak a `DamagedBook` structure testje kéri) Nem szeretnénk majd Book referenciaként hivatkozni az altípusokra?
  * Nem derül ki, hogy a `BookCollection` milyen módon kap adatokat, amelyeket közben jól kellene kiírnia, de `DamagedBook`-ként kellene kezelnie.
  * `initBook`-ot mindkét konstruktornál meg kellene hívni a feladat szövege szerint, míg a structure test azt kéri, hogy hívjon át a másik konstruktorra a paraméter nélküli.
  * `Book` példányt kap az `EBook` (és a `PrintedBook`), az eredeti cél az volt, hogy getterekkel hívjuk meg az ősosztály konstruktorát? Vagy írjunk copy constructort is a `Book`-hoz? Vagy legyen egy `Book` típusú adattagunk? (De közben leszármazás ne legyen???)
  * A `createReference` metódus implementációját elvárja a structure test, de nincs róla információ, hogy mi a csudát csináljon (ekkor bármit csinálhat, ugye?).
  * A feladat szövege `IllegalArgumentException` kiváltását kéri, a tesztnél viszont a saját `InvalidBookException` kivétel ellenőrzését kéri.

### 2. feladat

Készítsünk `StuffyList` adatszerkezetet a megadott struktúra szerint.

Ez az adatszerkezet olyan, mint egy átlagos lista, ami `E` típusú elemek halmazaiból áll...
kivéve, hogy az `add()` művelet garantálja, hogy egy újonnan hozzáadott halmaz tartalmazza a `neededElement` elemet.

- Ha a `neededElement` hiányozna a paraméterként kapott halmazból, ne az eredeti halmaz objektumot változtassuk meg, hanem készüljön új halmaz, és ez kerüljön be a listába.

A teszteléshez készüljön néhány `StuffyList` úgy, hogy a megkapott halmazok tartalmazzák/nem tartalmazzák a `neededElement` értéket.
Megvizsgálandó, hogy a hozzáadott halmazokban mind szerepel az elvárt érték.

- Az elvárt érték `List.of(...)` és `Set.of(...)` műveletekkel is előállítható.
    - Ezeket a metódusokat csak `assert` jellegű hívások elvárt értékeinél használjuk, **máshol ne**.

