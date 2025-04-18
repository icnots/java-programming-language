# 8. heti feladatsor

Segítségként a [Java 21 dokumentációja](https://docs.oracle.com/en/java/javase/21/docs/api/index.html).

### Rövid demó

Írj egy programot, amely a parancssori paramétereket belehelyezi egy `HashSet` típusba és utána kiírja, hogy milyen elemek vannak.
Ugyanolyan elemek esetén ekkor csak egyszer fog belekerülni az adott elem. Írd ki a `System.out.println` metódussal a halmazod elemeit.

### 1. demó

Készítsük el a `WorkerScheduleStructureTest` szerint a megadott osztályt.
Ennek adattagja leírja, hogy melyik héten kik dolgoznak.
A heteket a hívó fél `1` kezdéssel számozza, de belül `0` kezdéssel tároljuk el.

Dolgozókat két `add()` művelettel adunk a munkarendhez.

- Az egyik egy specifikus héthez adja hozzá a második paraméterben megadott dolgozókat.
	- Hozzáadhatók egyenként is, de a `HashSet` osztály `addAll()` metódusával is.
	- Ha a hét még nem szerepel a `weekToWorkers` adattagban, be kell tenni dolgozók nélkül (üres halmazt hozzárendelve).
- A másik több hetet add meg, a dolgozókat mindegyikhez hozzá kell adni.
	- Ez a metódus hívjon át az előzőre.

A másik két metódus megadja, hogy
egy adott dolgozó szerepel-e a munkarend egy megadott napján,
illetve megadja az összes olyan napot, amelyeken egy adott dolgozó dolgozik.

- Az utóbbihoz használjuk a `HashMap` osztály `entrySet()` metódusát a kulcs-érték párok bejárásához.
	- Ez `Entry<kulcs típusa, érték típusa>` értékeket jár be (`java.util.Map.Entry`).

A következő módon tesztelendő.

- `emptySchedule`: üres munkarendben senki nem dolgozik semelyik napon
	- Itt `assertFalse(<feltétel>)` is használható, ami rövidebb, mint a szintén érvényes `assertEquals(false, <feltétel>)`.
- `schedule`: vegyünk fel néhány dolgozót mindkét `add()` használatával, és aztán próbáljuk ki a két másik metódust.
	- A második változathoz néhány `ArrayList`re van szüksége. Ezek összeállíthatók úgy, hogy minden névre meghívjuk az `add` metódust.
	- Összeállítható így is: `new ArrayList<>(List.of(name1, name2, ...))`. Ebben `List` csomagja szintén `java.util`.
	- A teszt működtethető a szokásos módon `@ParameterizedTest` segítségével is, amivel rövidebb és átfogóbb megoldás adható.

## Feladatok

### 1. feladat

A következő feladatok kódját a `ListUtilStructureTest` szerint kell elkészíteni.

A `divisors()` metódus a paraméterként kapott nemnegatív egész szám osztóit adja vissza egy `ArrayList` adatszerkezetben.

Tesztelendő `0`, `1` és `64` bemenetekre.

### 2. feladat

A `withSameStartEnd()` metódus szövegeket kap meg `ArrayList` adatszerkezetben,
és ezek közül azokat adja vissza egy másik `ArrayList`ben, amelyek nem üresek, nem is `null` értékek, és első és utolsó karakterük megegyezik.

A tesztelés egy üres `ArrayList`tel induljon.
Erre a `withSameStartEnd()` hívásnak üres listát kell adnia.
Ezután ugyanebben a metódusban sorban adjuk a listához az alábbi szövegeket; minden hozzáadás után tesztelendő, mit ad ki a hívás.

- üres szöveg (a kimenet nem változik meg)
- `null` (a kimenet nem változik meg)
- egyetlen szóközt tartozó szöveg (belekerül a kimenetbe)
- az `x` szöveg (belekerül a kimenetbe)
- üres szöveg (a kimenet nem változik meg)
- a `different start and end?` szöveg (a kimenet nem változik meg)
- az `ends and starts the same` szöveg (belekerül a kimenetbe)

### 3. feladat

A `maxToFront()` metódus a megkapott lista ábécérendben utolsó elemét helyezze át a lista elejére.

- A listát helyben kell megváltoztatni, ne jöjjön létre új lista.
- Ha a lista `null` vagy üres, nincsen teendő.
- Tipp: [`Collections.max()`](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Collections.html#max(java.util.Collection)).
- Tipp: [az `ArrayList` osztály megfelelő metódusaival](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/ArrayList.html#method-summary) el lehet távolítani a listából a megtalált értéket, majd vissza lehet tenni a `0` indexre.

A következő bemenetek tesztelendők.

- `null`: `assertX` jellegű hívásra nincsen szükség, csak meg kell hívni a metódust
- üres lista
- egyelemű lista
- három szöveget tartalmazó lista: `can, you, succeed`, erre az elvárt kimenet `you, can, succeed`
- három szöveget tartalmazó lista: `-123, 2000, 100`, erre az elvárt kimenet `2000, -123, 100`

### 4. feladat (beadandó)

A `CharacterStatisticsStructureTest` osztály alapján dolgozzunk.

Az osztály konstruktora egy szöveget kap meg, és az ebben szereplő összes karakterre beteszi annak előfordulási gyakoriságát az adattagba.

- Tipp: [a `String` osztály `toCharArray()` metódusa](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/lang/String.html#toCharArray()) segítségével könnyen elérhetők a szöveg karakterei.
- Tipp: a `HashMap` osztály `getOrDefault()` adattagja is jól használható itt. Oldjuk meg a feladatot a használatával és a használata nélkül is.

A `getCount()` metódus az adott karakter gyakoriságát adja meg.

Szintén elkészítendő egy `toString()` implementáció az osztályhoz, ami a karakterek gyakoriságának szöveges reprezentációját mutatja.
A metódus kapja meg az `@Override` annotációt.
A gyakoriságok az `entrySet()` sorrendjében jelenjenek meg benne.


Tesztelés: az alábbi szövegekre mind vizsgáljuk meg legalább egy karakter gyakoriságát.

- Kipróbálandó az az eset is, amikor a megadott karakter nem szerepel a szövegben.

A `toString()` kimenete szintén megvizsgálandó.

- A kimenetek az alábbiakhoz hasonlóak lesznek, de a karakterek sorrendje függhet a rendszertől.
- A kimenetben a szóközöknek is betűre pontosan egyezniük kell.

A szövegek a következők:

- üres szöveg: üres kimenet
- `aaaaaaaa`: `a(8) `
- `HgFeDcBa`: `a(1) B(1) c(1) D(1) e(1) F(1) g(1) H(1) `
- `a?!_#@{}`: `@(1) a(1) !(1) #(1) {(1) }(1) ?(1) _(1) `
- `Hello world!`: ` (1) !(1) r(1) d(1) e(1) w(1) H(1) l(3) o(2) `
	- Itt az első karakter a szóköz (` `).
