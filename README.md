Chyby:
-načtení celého souboru do listu a teprve poté zpracování -> zpracovávat okamžitě, číst řádek po řádku, vybraná data rovnou vypisovat, případně pro další práci nejdříve např. do listu uložit (odstraní riziko zhroucení aplikace pro nedostatek paměti a je v souladu s best practices)
-jedna třída jako "stack" pro metody -> rozvrstvit aplikaci a metody logicky roztřídit do tříd
-testování -> zdokonalit testy (zde jsem s nimi pracoval poprvé v životě a učil se testovat za běhu, v průběhu víkendu)


# TenderForJavaJuniorSDC

Zadaní:
V programovacím jazyce Java s využitím Mavenu vytvořte program, který bude spouštěný z příkazové řádky.
Jako jediný vstupní parametr bude mít zadaný datovy soubor.
Program vypíše všechna prvočisla nalezená v datovém souboru (jeden řadek vystupu = jedno nalezené prvočíslo) v pořadí, v jakém se v souboru vyskytují.
Pro výstup bude použit Logger.
Je možné používat jakékoli volně dostupné knihovny.

Program by měl obsahovat JUnit testy funkcionality.

Vystup včetně zdrojových kódů prosím nahrát na github (případně zaslat zip se zdrojovými soubory).

Popis datového souboru:
Datovy soubor je ve formatu Excel 2007-2013 (xlsx).
Data jsou v prvním listu ve sloupci B.
Validní data jsou pouze kladná cela čísla, nevalidní data by měl program ignorovat.
Malý VZOREK dat je přílohou zadaní, jedna se opravdu o vzorek, finalni data mohou byt jina!
Může jich být více a větší, s vlivem na cekový výkon výpočtu.

Data: vzorek_dat.xlsx
