# 1. gyakorlat feladatok

### 1. feladat

Készítsük el a lehető legrövidebb Java fordítási egységet.

~~~{.java}
public class A {}
~~~

Fordítsuk is le.

~~~
javac A.java
~~~

### 2. feladat

Készítsünk futtatható, üres törzsű programot.

~~~{.java}
public class Skip {
    public static void main(String[] args) {
    }
}
~~~

Fordítsuk és futtassuk.

~~~
javac Skip.java
java Skip
~~~

## Feladatok

### 3. feladat

Készítsünk programot, amely a billentyűzetről kéri be a felhasználó nevét,
majd üdvözli. Használjuk az alábbi két parancsot.

~~~{.java}
System.console().readLine()
System.console().printf(...)
~~~


### 4. feladat

Készítsünk programot, amely a felhasználónevet parancssori argumentumként
kapja, majd üdvözli a felhasználót. A szabványos kimenetre történő kiírás
ezzel a paranccsal is elvégezhető - ezt használjuk majdnem mindig.

~~~{.java}
System.out.println(...)
~~~

### 5. feladat

Az alábbi Java program feladata, hogy kiírja az 1-től 4-ig lévő számok felét.

Az elvárt kimenet:
```
0.5
1.0
1.5
2.0
Kiirtam 4 szamot
```

Javítsa ki a programot.

~~~{.java}
public class Print {
    public static void main() {
        for(int i = 1; i < 4; i++) {
            System.out.Println(i/2);
        }
        i = 4;
        System.out.println("Kiirtam " + i + " szamot")
    }
}
~~~


### 6. feladat

Készítsünk programot, amely bekér két egész számot, és kiírja a köztük lévő egész
számok felét. A beolvasás során kapott szövegeket egész számmá az alábbi konverziós
függvénnyel alakíthatjuk át.

~~~{.java}
Integer.parseInt(...)
~~~

### 7. feladat

Készítsünk egy programot, amely kiszámolja két egész szám összegét,
különbségét, szorzatát, hányadosát, és az osztási maradékot is megadja.
Figyeljen a nullával való osztásra (ez esetben ne végezze el az osztást).
A két számot parancssori paraméterként kell megadni. Vizsgáljuk meg azt is,
hogy megfelelő számú parancssori paramétert adtunk–e át. Ennek a hibaüzenetét
a standard hibakimenetre (`System.err`) írjuk ki.

### 8. feladat

Írjuk meg az `n` természetes szám faktoriálisát kiszámoló programot.


## Gyakorló feladatok

### 1. gyakorló feladat

Készítsünk programot, amely a parancssori argumentumában megadott
számról eldönti, hogy tökéletes–e. A számelméletben tökéletes számnak
nevezzük azokat a természetes számokat, amelyek megegyeznek az önmaguknál
kisebb osztóik összegével (vagyis az összes osztóik összege a szám kétszerese).
Az első négy ilyen szám: 6, 28, 496 és 8128.

### 2. gyakorló feladat

Módosítsuk az előző megoldásunkat úgy, hogy 1–től a paraméterként megadott
határig minden egész számra vizsgálja a tökéletességet és adja meg, hogy abban az
intervallumban mennyi ilyet talált. Ha nem talált egyetlen ilyen számot sem,
akkor írja ki, hogy egyetlen tökéletes szám sincs a megadott intervallumban.

### 3. gyakorló feladat

Számoljuk ki a parancssori argumentumként kapott egész számok legnagyobb
közös osztóját. (Nem csak 2 számét, hanem az összes kapott számét.)

A paraméterként kapott egész számok és az eredmény is legyen `long` típusú.
Szövegeket ilyen típusú értékre a `Long.parseLong(...)` függvénnyel alakíthatunk.


### 4. gyakorló feladat

Írjunk programot, mely kiszámítja egy szám négyzetgyökét a babilóniai módszerrel.

Az $S$ szám négyzetgyökének megállapításához számoljuk ki az alábbi $x_n$ sorozat első
néhány elemét. A program kérje be az $S$ számot, és kérjen be egy $\varepsilon$ pontosságot.
A számolást addig folytassuk, amíg két egymást követő $x_i$ érték különbsége nagyobb,
mint $\varepsilon$. A sorozat legutolsó kiszámított elemét írjuk ki.

$$x_0 = {S \over 2}$$
$$x_{n+1} = {1 \over 2} \left(x_n + {S \over x_n}\right)$$

Egy szöveget a `Double.parseDouble(...)` függvénnyel konvertálhatunk `double` típusúvá.

### 5. gyakorló feladat

Számoljuk ki $\sqrt{2}$ értékét közelítőleg lánctört kiértékelésével.

$$\sqrt{2} - 1 = {1 \over {2 + {1 \over {2 + {1 \over {2 + \dots}}}}}}$$

### 6. gyakorló feladat

Számoljuk ki $e$ értékét közelítőleg lánctört segítségével.

$$e - 1 = 1 + {1 \over {1 + {1 \over {2 + {1 \over {1 + {1 \over {1 + {1 \over {4 + {1 \over {1 + {1 \over {1 + {1 \over {6 + \dots}}}}}}}}}}}}}}}}$$

