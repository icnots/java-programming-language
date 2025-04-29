# 11. gyakorlat

* [Java 21 Docs](https://docs.oracle.com/en/java/javase/21/docs/api/index.html)

## Demo feladat

Hozz létre egy `Animal` nevű interface-t, amely két dolgot követel meg:
  * Legyen egy `shout` metódusa,
  * Legyen egy `step` metódusa.
  
Legyen két `Animal`-t megvalósító osztály: `Dog` és `Cat`. Ezek mindegyik úgy implementálja a megkövetelt metódusokat, hogy kiír a képernyőre egy ehhez hasonló feliratot:
`Dog is shouting` vagy `Step is made by a cat`. (Itt helyettesítsd a cat és dog szavakat megfelelően.)
Készíts főprogramot, amely a létrehoz egy `List` típust `Animal` típusból, majd rakj bele 2-2-t a kétféle osztályodból és iterálj rajta végig a két metódust meghívva.
Készítsük el az `equals` metódust (akkor legyen true a visszatérési érték, ha ugyanaz az osztály típusa) és a `hashCode`-ot is. Itt használjuk a `java.util.Objects` osztály `hash` metódusát.

> Itt engedélyezett, hogy egy fájlba készítsd a megoldást a példa bemutatása érdekében.

## Feladatok

### 1. feladat

A `MultiDimensionalPointSuite` alapján készítsünk többdimenziós pont típust.
Ennek a konstruktora a kezdeti koordinátákat veszi át.
A `get` és `set` metódusokkal egyes koordinátákat lehet beállítani és lekérdezni.

Az osztály két interfészt valósít meg.

- `Scalable`: minden koordinátát a megkapott mértékben növel meg
- `Undoable`: itt összetettebb a teendő
	- Minden olyan metódus működését vissza akarjuk tudni vonni, ami megváltoztatja a pont állapotát.
	- Ezt elősegítendő, a `lastCoordinates` adattag mindig a pont legutóbbi állapotát tartalmazza.
		- A pont elkészítése után közvetlenül a kezdeti koordinátákkal legyen feltöltve.
	- Az interfész metódusa az utolsó állapotot állítja vissza.
		- Ha közvetlenül ezután újra meghívják a műveletet, az éppen lecserélt állapot álljon vissza.

Az alábbi három teszteset mindegyikében a következő lépéseket kell megtenni.

1. Pont elkészítése tetszőleges adatokkal.
1. A megteendő lépés elvégzése, lásd lentebb.
1. Megvizsgálandó mindegyik koordináta elvárt értéke.
1. Visszalépés meghívása.
1. Megvizsgálandó, hogy mindegyik koordináta értéke visszaállt az elkészítés utáni állapotra.
1. Visszalépés meghívása ismét.
1. Megvizsgálandó mindegyik koordináta elvárt értéke.

A következők tesztelendők.

- `testInitUndo`: a pontot csak elkészítjük
- `testSet`: a pont elkészítése után beállítjuk egy koordinátáját
- `testScale`: a pont elkészítése után felskálázzuk

Két pont akkor minősüljön tartalmilag egyenlőnek, ha a koordinátáik megegyeznek. A korábbi állapotuk nem számít.

A `testEquality` metódus tesztelje, hogy két olyan lista egyenlő, amelyben egymással egyenlő pontok szerepelnek.

- Mindkét listához használható a `List.of` művelet.
- A pontok különbözőek legyenek a két listában.

Legyen természetes rendezés is adott a pontokon az alábbiak szerint.
Ha valamelyiknek nagyobb a dimenziószáma, az minősül nagyobbnak.
Különben az első eltérő koordinátaérték dönt,
ha pedig mindegyik koordináta megegyezik, akkor egyenlőek.

A `testOrdering` metódusban kerüljön sok különféle pont egy listába.
Erre aztán hívjuk meg a [Collections.shuffle](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Collections.html#shuffle(java.util.List)),
majd a [Collections.sort](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/Collections.html#sort(java.util.List))
műveletet.
Ezután teszteljük, hogy a kijött lista elemei az elvárt, növekvő sorrendbe kerültek.

- Mivel a lista tartalma módosul, az elkészítéséhez *nem* használható a `List.of` művelet.
	- Az elvárt érték elkészítéséhez viszont igen.
- Itt nem szigorúan egységtesztelést végzünk, mert az egyes lefutások során különbözően keverjük össze a lista elemeit.

### 2. feladat

A `GoAroundStructureTest` szerint készítsünk olyan adatszerkezetet, ami egypár elemet tárol.
A bejárója (`GoAroundIteratorStructureTest`) működjön úgy, hogy a tárolt elemeket `roundCount` alkalommal adja elő.

Teszteljük, hogy ha az eltárolt elemek `1, 2, 3, 4` és `roundCount` értéke `2`, akkor a bejáró kimenete `1, 2, 3, 4, 1, 2, 3, 4`.
Mindegyik lépés megtétele előtt próbáljuk ki, hogy `hasNext()` értéke `true`, de az utolsó lépés megtétele után már `false`.
